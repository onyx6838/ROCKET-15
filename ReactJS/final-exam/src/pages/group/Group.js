import React, { useEffect } from "react";
import BootstrapTable from "react-bootstrap-table-next";
import { Card, CardBody, Col, Container, Row } from "reactstrap";

import paginationFactory from "react-bootstrap-table2-paginator";
import { connect } from "react-redux";

import { selectGroups } from '../../redux/selectors/groupSelectors';
import { getListGroupsAction } from '../../redux/actions/groupActions';

import GroupApi from '../../api/GroupApi'

const Group = (props) => {
  const getListGroups = props.getListGroupsAction;

  useEffect(() => {
    const getAllGroups = async () => {
      const result = await GroupApi.getAll();
      const groups = result.content;
      getListGroups(groups);
    }
    getAllGroups();

  }, [getListGroups]);

  const tableColumns = [
    {
      dataField: "name",
      text: "Name",
      sort: true
    },
    {
      dataField: "member",
      text: "TotalMember",
      sort: true
    },
    {
      dataField: "createDate",
      text: "Create Date",
      sort: true
    },
    {
      dataField: "creator.fullName",
      text: "Creator",
      sort: true
    }
  ];

  return (
    <Container fluid className="p-0">
      <h1 className="h3 mb-3">Group Page</h1>

      <Row>
        <Col>
          <Card>
            <CardBody>
              <BootstrapTable
                keyField="name"
                data={props.groups}
                columns={tableColumns}
                bootstrap4
                hover
                bordered
                pagination={paginationFactory({
                  sizePerPage: 5,
                  sizePerPageList: [5, 10, 25, 50]
                })}
              />
            </CardBody>
          </Card>
        </Col>
      </Row>
    </Container>
  )
};

const mapGlobalStateToProps = state => {
  return {
    groups: selectGroups(state)
  };
};

export default connect(mapGlobalStateToProps, { getListGroupsAction })(Group);