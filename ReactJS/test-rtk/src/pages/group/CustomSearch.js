import React from "react";
import { FastField, Form, Formik } from "formik";
import { useSelector } from "react-redux";
import { Button, Col, InputGroupAddon, Row } from "reactstrap";
import { ReactstrapInput } from "reactstrap-formik";
import { selectSearch } from "../../redux/selectors/groupSelector";

const CustomSearch = (props) => {
    const searchText = useSelector(selectSearch);

    return (
        <Formik
            key={Date.parse(new Date())}
            enableReinitialize
            initialValues={
                {
                    search: searchText ? searchText : ""
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

export default CustomSearch;