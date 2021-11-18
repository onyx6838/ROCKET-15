import React, { useState } from "react";
import { Link } from "react-router-dom";

import { Button, Card, CardBody, FormGroup, CustomInput } from "reactstrap";
import { Modal, ModalBody, ModalFooter, ModalHeader } from "reactstrap";

import LoginApi from '../../api/LoginApi'
import UserApi from '../../api/UserApi'

import { Formik, Form, FastField } from 'formik';
import { ReactstrapInput } from "reactstrap-formik";
import * as Yup from 'yup';

import avatar from "../../assets/img/avatars/avatar.jpg";
import storage from "../../storage/storage";
import { toastr } from "react-redux-toastr";

import { setRememberMeInfo, setTokenInfo, setUserLoginInfo } from '../../redux/actions/userLoginInfoAction'
import { useDispatch, useSelector } from "react-redux";
import { selectRememberMe } from "../../redux/selectors/userLoginInfoSelector";

const SignIn = (props) => {
  const dispatch = useDispatch();
  const [openModals, setOpenModals] = useState(false);
  const [email, setEmail] = useState('');
  const [isDisabledResendEmailButton, setDisabledResendEmailButton] = useState(false);

  const showWrongLoginNotification = (title, message) => {
    const options = {
      timeOut: 2500,
      showCloseButton: false,
      progressBar: false,
      position: "top-right"
    };

    // show notification
    toastr.error(title, message, options);
  }

  const resendEmailToActiveAccount = async () => {
    setDisabledResendEmailButton(true);
    // call api
    await UserApi.resendEmailToActiveAccount(email);
    setDisabledResendEmailButton(false);
  }

  const [isRememberMe, setRememberMe] = useState(selectRememberMe(useSelector(state => state)));

  return (
    <>
      <div className="text-center mt-4">
        <h2>Welcome to VTI Academy</h2>
        <p className="lead">Sign in to your account to continue</p>
      </div>

      <Formik
        initialValues={
          {
            username: '',
            password: ''
          }
        }

        validationSchema={
          Yup.object({
            username: Yup.string()
              .required('Required')
              .max(50, 'Must be between 6 to 50 characters')
              .min(6, 'Must be between 6 to 50 characters'),
            password: Yup.string()
              .max(50, 'Must be between 6 to 50 characters')
              .min(6, 'Must be between 6 to 50 characters')
              .required('Required'),
          })
        }

        onSubmit={
          async (values) => {
            try {
              const user = await LoginApi.login(values.username, values.password);
              if (user.status === "NOT_ACTIVE") {
                setOpenModals(true);
                setEmail(user.email);
              } else {
                storage.setRememberMe(isRememberMe);
                storage.setToken(user.token)
                storage.setUserInfo(user)
                // save data to redux
                dispatch(setRememberMeInfo(isRememberMe))
                dispatch(setUserLoginInfo(user))
                dispatch(setTokenInfo(user.token))

                props.history.push("/dashboard/default");
              }
            } catch (error) {
              if (error.status === 401) {
                console.log(error);
                showWrongLoginNotification("Login Failed", "Wrong username or password!");
              } else {
                props.history.push("/auth/500")
              }
            }
          }
        }
      >

        {({ isSubmitting }) => (
          <Card>
            <CardBody>
              <div className="m-sm-4">
                <div className="text-center">
                  <img
                    src={avatar}
                    alt="Chris Wood"
                    className="img-fluid rounded-circle"
                    width="132"
                    height="132"
                  />
                </div>
                <Form>
                  {/* username */}
                  <FormGroup>
                    <FastField label="Username" bsSize="lg" type="text" name="username" placeholder="Enter your username"
                      component={ReactstrapInput}
                    />
                  </FormGroup>

                  {/* password */}
                  <FormGroup>
                    <FastField
                      label="Password" bsSize="lg" type="password" name="password" placeholder="Enter password"
                      component={ReactstrapInput}
                    />
                    {/* forgot password */}
                    <small>
                      <Link to="/auth/reset-password">Forgot password?</Link>
                    </small>
                  </FormGroup>
                  {/* remember me */}
                  <div>
                    <CustomInput type="checkbox" id="rememberMe" label="Remember me next time"
                      checked={isRememberMe} onChange={e => setRememberMe(e.target.checked)}
                    />
                  </div>
                  {/* submit */}
                  <div className="text-center mt-3">
                    <Button type='submit' color="primary" size="lg" disabled={isSubmitting}>
                      Sign in
                    </Button>
                  </div>
                </Form>
              </div>
            </CardBody>
          </Card>
        )}
      </Formik>

      <Modal isOpen={openModals}>
        <ModalHeader >You need to confirm your account</ModalHeader>
        <ModalBody className="m-3">
          <p>Your account is not active.</p>
          <p>Please check your email (<b>{email}</b>) to active account.</p>
        </ModalBody>
        <ModalFooter>
          <Button color="primary" onClick={resendEmailToActiveAccount} disabled={isDisabledResendEmailButton}>
            Resend
          </Button>
          <Button color="primary" onClick={() => setOpenModals(false)}>
            Close
          </Button>
        </ModalFooter>
      </Modal>
    </>
  )
};

export default SignIn;