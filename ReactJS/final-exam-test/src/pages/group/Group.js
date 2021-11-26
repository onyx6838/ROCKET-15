import React, { useEffect } from "react";
import { Card, CardBody, Col, Container, Row } from "reactstrap";

import { useDispatch, useSelector } from "react-redux";
import BootstrapTable from "react-bootstrap-table-next";
import paginationFactory from 'react-bootstrap-table2-paginator';

import { getGroupsAsync } from '../../redux/slices/groupSlice'
import { selectListGroup, selectPage, selectSize, selectTotalElements } from "../../redux/selectors/groupSelector";

const Group = () => {
  const dispatch = useDispatch()
  const groups = useSelector(selectListGroup);
  const size = useSelector(selectSize);
  const page = useSelector(selectPage);
  const totalElements = useSelector(selectTotalElements);

  useEffect(() => {
    dispatch(getGroupsAsync(1, size));
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

  const handleTableChange = async (type, { page, sizePerPage }) => {
    dispatch(getGroupsAsync(page, size));
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
  })

  return (
    <Container fluid className="p-0">
      <h1 className="h3 mb-3">Group Management</h1>
      <Row>
        <Col>
          <Card>
            <CardBody>
              <BootstrapTable
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
            </CardBody>
          </Card>
        </Col>
      </Row>
    </Container>
  )
};

export default Group;