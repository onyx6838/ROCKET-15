import React, { useEffect, useState } from "react";
import BootstrapTable from "react-bootstrap-table-next";
import { Card, CardBody, Col, Container, Row } from "reactstrap";
import CustomSearch from './CustomSearch';
import * as Icon from 'react-feather'

import paginationFactory from "react-bootstrap-table2-paginator";
import filterFactory, { customFilter } from 'react-bootstrap-table2-filter';
import { connect } from "react-redux";

import ToolkitProvider from 'react-bootstrap-table2-toolkit';

import { selectListGroup, selectPage, selectSize, selectTotalElement } from '../../redux/selectors/groupSelectors';
import { getListGroupsAction } from '../../redux/actions/groupActions';

import GroupApi from '../../api/GroupApi'
import CustomFilter from "./CustomFilter";

const Group = (props) => {
  const getListGroups = props.getListGroupsAction;
  const size = props.size;

  const [isVisibleFilter, setVisibleFilter] = useState(false);

  useEffect(() => {
    const getAllGroups = async () => {
      const result = await GroupApi.getAll();
      const groups = result.content;
      const totalSize = result.totalElements;
      getListGroups(groups, 1, totalSize);
    }
    getAllGroups();

  }, [getListGroups, size]);

  let onTotalMemberFilter;

  const onFilterChange = (minTotalMember, maxTotalMember) => {
    onTotalMemberFilter({ // get from filter callback
      minTotalMember,
      maxTotalMember
    });
  }

  const tableColumns = [
    {
      dataField: "name",
      text: "Name",
      sort: true
    },
    {
      dataField: "member",
      text: "TotalMember",
      sort: true,
      filter: customFilter(),
      filterRenderer: (onFilter, column) => {
        onTotalMemberFilter = onFilter;
        return null;
      }
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

  const handleTableChange = async (type, { page, sizePerPage, sortField, sortOrder, searchText, filters }) => {
    if (sortField === null || sortField === undefined || sortOrder == null || sortOrder === undefined) {
      sortField = 'id'
      sortOrder = 'desc'
    }
    //filter
    const filter = filters.member && filters.member.filterVal ? filters.member.filterVal : null;
    const minTotalMember = filter && filter.minTotalMember ? filter.minTotalMember : null;
    const maxTotalMember = filter && filter.maxTotalMember ? filter.maxTotalMember : null;
    const result = await GroupApi.getAll(page, size, sortField, sortOrder, searchText, minTotalMember, maxTotalMember);
    const groups = result.content;
    const totalsize = result.totalElements;
    getListGroups(groups, page, totalsize, minTotalMember, maxTotalMember);
  }

  return (
    <Container fluid className="p-0">
      <h1 className="h3 mb-3">Group Page</h1>
      <Row>
        <Col>
          <Card>
            <CardBody>
              <ToolkitProvider
                keyField="name"
                data={props.groups}
                columns={tableColumns}
                search
              >
                {
                  toolkitprops => (
                    <>
                      {/* Filter */}
                      <Row>
                        <Col>
                          {isVisibleFilter && <CustomFilter onFilterChange={onFilterChange}/>}
                        </Col>
                      </Row>
                      {/* search */}
                      <Row>
                        <Col lg="3">
                          <CustomSearch {...toolkitprops.searchProps} />
                        </Col>
                        <Col lg="9">
                          <div className="float-right pull-right">
                            <Icon.Filter size="24" className="align-middle mr-2"
                              onClick={() => setVisibleFilter(!isVisibleFilter)} />
                          </div>
                        </Col>
                      </Row>
                      <BootstrapTable
                        {...toolkitprops.baseProps}
                        bootstrap4
                        striped
                        hover
                        bordered
                        remote
                        pagination={paginationFactory({
                          page: props.page,
                          totalSize: props.totalElement,
                          sizePerPage: props.size,
                          nextPageText: '>',
                          prePageText: '<',
                          withFirstAndLast: false,
                          hideSizePerPage: true
                        })}
                        filter={filterFactory()}
                        onTableChange={handleTableChange}
                      />
                    </>
                  )
                }
              </ToolkitProvider>
            </CardBody>
          </Card>
        </Col>
      </Row>
    </Container>
  )
};

const mapGlobalStateToProps = state => {
  return {
    groups: selectListGroup(state),
    page: selectPage(state),
    size: selectSize(state),
    totalElement: selectTotalElement(state)
  };
};

export default connect(mapGlobalStateToProps, { getListGroupsAction })(Group);