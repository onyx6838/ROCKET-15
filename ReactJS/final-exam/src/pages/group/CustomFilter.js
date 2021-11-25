import React from "react";
import { Button, FormGroup, Row, Col, InputGroupAddon } from "reactstrap";
import { ReactstrapInput } from "reactstrap-formik";
import { Formik, FastField, Form } from 'formik';
import * as Yup from 'yup';

import { connect } from "react-redux";
import { selectMaxTotalMember, selectMinTotalMember } from "../../redux/selectors/groupSelectors";

const CustomFilter = (props) => {

    return (
        <Formik
            enableReinitialize
            key={Date.parse(new Date())}
            initialValues={
                {
                    minTotalMember: props.minTotalMember ? props.minTotalMember : '',
                    maxTotalMember: props.maxTotalMember ? props.maxTotalMember : ''
                }
            }
            validationSchema={
                Yup.object({
                    minTotalMember: Yup.number()
                        .min(0, "Must be a positive integer")
                        .integer("Must be a positive integer"),

                    maxTotalMember: Yup.number()
                        .min(0, "Must be a positive integer")
                        .integer("Must be a positive integer"),
                })
            }
            onSubmit={
                values => {
                    props.onFilterChange(values.minTotalMember, values.maxTotalMember);
                }
            }
        >
            <Form>
                <fieldset className="filter-border">
                    <legend className="filter-border">Filter</legend>
                    <FormGroup>
                        <Row style={{ alignItems: "center" }}>
                            <Col xs="auto">
                                Total Member:
                            </Col>
                            <Col lg='2'>
                                <FastField bsSize="lg" type="number" name="minTotalMember"
                                    placeholder="Enter min"
                                    component={ReactstrapInput}
                                />
                            </Col>
                            {"-"}
                            <Col lg='2'>
                                <FastField bsSize="lg" type="number" name="maxTotalMember"
                                    placeholder="Enter max"
                                    component={ReactstrapInput}
                                />
                            </Col>
                            <Col xs="auto">
                                <InputGroupAddon addonType="append" color="primary">
                                    <Button type="submit">Filter!</Button>
                                </InputGroupAddon>
                            </Col>
                        </Row>
                    </FormGroup>
                </fieldset>
            </Form>
        </Formik>
    );
};
const mapGlobalStateToProps = state => {
    return {
        minTotalMember: selectMinTotalMember(state),
        maxTotalMember: selectMaxTotalMember(state)
    };
};

export default connect(mapGlobalStateToProps)(CustomFilter);