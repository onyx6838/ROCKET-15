import React from "react";

import UserApi from '../../api/UserApi'

import { Button, Card, CardBody, FormGroup } from "reactstrap";

import { FastField, Formik, Form } from "formik";
import { ReactstrapInput } from "reactstrap-formik";
import * as Yup from 'yup';
import { useParams } from "react-router";
import { toastr } from "react-redux-toastr";

const NewPassword = (props) => {
  const { token } = useParams();

  const showSucessNotification = (title, message) => {
    const options = {
      timeOut: 2500,
      type: "success",
      showCloseButton: false,
      progressBar: false,
      position: "top-right"
    };

    // show notification
    toastr.success(title, message, options);
  }

  return (
    <>
      <div className="text-center mt-4">
        <h1 className="h2">Reset password</h1>
        <p className="lead">Enter your new password.</p>
      </div>

      <Formik
        initialValues={
          {
            password: '',
            confirmpassword: ''
          }
        }

        validationSchema={
          Yup.object({
            password: Yup.string()
              .max(50, 'Must be between 6 to 50 characters')
              .min(6, 'Must be between 6 to 50 characters')
              .required('Required'),

            confirmpassword: Yup.string()
              .when("password", {
                is: value => (value && value.length > 0 ? true : false),
                then: Yup.string().oneOf(
                  [Yup.ref("password")],
                  "Both password need to be the same"
                )
              })
              .required('Required')
          })
        }

        onSubmit={
          //async (values, { setFieldError }) => {
          async (values) => {
            try {
              // call api
              await UserApi.resetPassword(token, values.password);

              // notification
              showSucessNotification(
                "Reset Password",
                "Reset Password Successfully!"
              );

              // redirect login page
              props.history.push("/auth/sign-in");

            } catch (error) {
              //setFieldError('errorForm', 'There is an error from the server');
              props.history.push("/auth/500")
            }
          }
        }

        validateOnChange={false}
      >
        {({ isSubmitting }) => (
          <Card>
            <CardBody>
              <div className="m-sm-4">
                <Form>
                  {/* password */}
                  <FormGroup>
                    <FastField label="Password" bsSize="lg" type="password" name="password" placeholder="Enter new password"
                      component={ReactstrapInput}
                    />
                  </FormGroup>

                  {/* confirm password */}
                  <FormGroup>
                    <FastField label="Confirm Password" bsSize="lg" type="password" name="confirmpassword" placeholder="Enter confirm new password"
                      component={ReactstrapInput}
                    />
                  </FormGroup>

                  <div className="text-center mt-3">
                    <Button type='submit' color="primary" size="lg" disabled={isSubmitting}>
                      Reset password
                    </Button>
                  </div>

                </Form>
              </div>
            </CardBody>
          </Card>
        )}
      </Formik>
    </>
  )
};

export default NewPassword;