import React, { useState } from "react";

import { Button, Card, CardBody, FormGroup } from "reactstrap";
import { Modal, ModalBody, ModalFooter, ModalHeader } from "reactstrap";

import { ReactstrapInput } from "reactstrap-formik";
import { Formik, Form, FastField } from 'formik';
import * as Yup from 'yup';

import UserApi from '../../api/UserApi'

const SignUp = () => {
  const [openModals, setOpenModals] = useState(false);
  const [email, setEmail] = useState('');

  return (
    <React.Fragment>
      <div className="text-center mt-4">
        <h1 className="h2">Get started</h1>
        <p className="lead">
          Create account to experience the course at <b>VTI Academy</b>.
        </p>
      </div>

      <Formik
        initialValues={
          {
            firstname: '',
            lastname: '',
            username: '',
            email: '',
            password: '',
            confirmPassword: ''
          }
        }

        validationSchema={
          Yup.object({
            firstname: Yup.string()
              .max(50, 'Must be less than 50 characters or equal')
              .required('Required'),

            lastname: Yup.string()
              .max(50, 'Must be less than 50 characters or equal')
              .required('Required'),

            username: Yup.string()
              .required('Required')
              .max(50, 'Must be between 6 to 50 characters')
              .min(6, 'Must be between 6 to 50 characters')
              .test('checkUniqueUsername', 'This username is already registered.', async username => {
                // call api
                const isExists = await UserApi.existsByUsername(username);
                return !isExists;
              }),

            email: Yup.string()
              .required('Required')
              .max(50, 'Must be between 6 to 50 characters')
              .min(6, 'Must be between 6 to 50 characters')
              .email('Invalid email address')
              .test('checkUniqueEmail', 'This email is already registered.', async email => {
                // call api
                console.log(email);
                const isExists = await UserApi.existsByEmail(email);
                return !isExists;
              }),

            password: Yup.string()
              .max(50, 'Must be between 6 to 50 characters')
              .min(6, 'Must be between 6 to 50 characters')
              .required('Required'),

            confirmPassword: Yup.string()
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
          async (values) => {
            try {
              // call api
              await UserApi.create(
                values.username,
                values.email,
                values.password,
                values.firstname,
                values.lastname);
              //alert("success")
              //open model 
              setOpenModals(true);
              setEmail(values.email);
            } catch (error) {
              //setFieldError('errorForm', 'There is an error from the server');
              console.log(error);
            }
          }
        }

        validateOnChange={false}
        validateOnBlur={false}
      >
        {({ isSubmitting }) => (
          <Card>
            <CardBody>
              <div className="m-sm-4">
                <Form>

                  <FormGroup>
                    <FastField type="text" label="First Name" bsSize="lg" name="firstname" id="firstname"
                      component={ReactstrapInput} />
                  </FormGroup>

                  <FormGroup>
                    <FastField
                      type="text" label="Last Name" bsSize="lg" name="lastname" id="lastname"
                      component={ReactstrapInput}
                    />
                  </FormGroup>

                  <FormGroup>
                    <FastField type="text" label="Username" bsSize="lg" name="username" id="username"
                      component={ReactstrapInput}
                    />
                  </FormGroup>

                  <FormGroup>
                    <FastField type="Email" label="Email" bsSize="lg" name="email" id="email"
                      component={ReactstrapInput}
                    />
                  </FormGroup>

                  <FormGroup>
                    <FastField type="Password" label="Password" bsSize="lg" name="password" id="password"
                      component={ReactstrapInput}
                    />
                  </FormGroup>

                  <FormGroup>
                    <FastField label="Confirm Password" bsSize="lg" type="password" name="confirmPassword"
                      component={ReactstrapInput}
                    />
                  </FormGroup>

                  <div className="text-center mt-3">
                    <Button type='submit' color="primary" size="lg" disabled={isSubmitting}>
                      Sign up
                    </Button>
                  </div>
                </Form>
              </div>
            </CardBody>
          </Card>
        )}
      </Formik>

      <Modal isOpen={openModals}>
        <ModalHeader >
          You need to confirm your account
        </ModalHeader>
        <ModalBody className="m-3">
          <p>
            We have sent an email to <b>{email}</b>.
          </p>
          <p>
            Please check your email to active account.
          </p>
        </ModalBody>
        <ModalFooter>
          <Button color="primary">
            Resend
          </Button>
          <Button color="primary">
            Save changes
          </Button>
        </ModalFooter>
      </Modal>

    </React.Fragment>
  )
};

export default SignUp;
