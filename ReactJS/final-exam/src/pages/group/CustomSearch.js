import { FastField, Form, Formik } from "formik";
import React from "react";
import { connect } from "react-redux";
import { Button, Col, InputGroupAddon, Row } from "reactstrap";
import { ReactstrapInput } from "reactstrap-formik";
import { selectSearch } from "../../redux/selectors/groupSelectors";

const CustomSearch = (props) => {
    return (
        <Formik
            key={Date.parse(new Date())}
            enableReinitialize
            initialValues={
                {
                    search: props.search ? props.search : ""
                }
            }

            onSubmit={
                values => {
                    props.onSearch(values.search);
                }
            }
        >
            <Form>
                <Row style={{ alignItems: "center" }}>
                    <Col xs="auto">
                        <FastField
                            bsSize="lg"
                            type="text"
                            name="search"
                            placeholder="Search for..."
                            component={ReactstrapInput}
                        />
                    </Col>
                    <Col xs="auto">
                        <InputGroupAddon addonType="append" color="primary">
                            <Button type="submit">Search!</Button>
                        </InputGroupAddon>
                    </Col>
                </Row>
            </Form>
        </Formik>
    );
};

const mapGlobalStateToProps = state => {
    return {
        search: selectSearch(state)
    };
};

export default connect(mapGlobalStateToProps)(CustomSearch);