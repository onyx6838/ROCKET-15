import React, { useEffect } from 'react';
import BootstrapTable from "react-bootstrap-table-next";
import paginationFactory from 'react-bootstrap-table2-paginator';
import { useDispatch, useSelector } from 'react-redux';
import { Card, CardBody, Col, Container, Row } from "reactstrap";
import { selectListGroup, selectPage, selectSize, selectTotalElements } from "../../redux/selectors/groupSelector";
import { getGroupsAsync } from '../../redux/slices/groupSlice';

import ToolkitProvider from "react-bootstrap-table2-toolkit";
import CustomSearch from './CustomSearch';

const Group = () => {
    const dispatch = useDispatch();
    const groups = useSelector(selectListGroup);
    const size = useSelector(selectSize);
    const page = useSelector(selectPage);
    const totalElements = useSelector(selectTotalElements);

    useEffect(() => {
        dispatch(getGroupsAsync({ page: 1, sizePerPage: size }));
    }, [dispatch, size])

    const tableColumns = [
        {
            dataField: "name",
            text: "Name",
            sort: true
        },
        {
            dataField: "totalMember",
            text: "Total Member",
            sort: true
        }
    ];

    const handleTableChange = (_, { page, sizePerPage, sortField, sortOrder, searchText }) => {
        // sort
        if (sortField === null || sortField === undefined || sortOrder === null || sortOrder === undefined) {
            sortField = 'id'
            sortOrder = 'desc';
        }
        dispatch(getGroupsAsync({ page, sizePerPage, sortField, sortOrder, searchText }));
    }

    const pagination = paginationFactory({
        page: page,
        totalSize: totalElements,
        sizePerPage: size,
        nextPageText: '>',
        prePageText: '<',
        withFirstAndLast: false,
        alwaysShowAllBtns: true,
        hideSizePerPage: true
    });

    return (
        <Container fluid className="p-0">
            <Row>
                <Col>
                    <Card>
                        <CardBody>
                            <ToolkitProvider
                                keyField="id"
                                data={groups}
                                columns={tableColumns}
                                search>
                                {props => (
                                    <>
                                        <CustomSearch {...props.searchProps} />
                                        <BootstrapTable
                                            {...props.baseProps}
                                            remote
                                            keyField="name"
                                            data={groups}
                                            columns={tableColumns}
                                            bootstrap4
                                            striped
                                            hover
                                            bordered
                                            pagination={pagination}
                                            onTableChange={handleTableChange}
                                        />
                                    </>
                                )}
                            </ToolkitProvider>
                        </CardBody>
                    </Card>
                </Col>
            </Row>
        </Container>
    )
};

export default Group;