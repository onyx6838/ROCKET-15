import React, { useEffect, useState } from "react";
import { connect } from "react-redux";
import { selectListGroup, selectPage, selectSelectedRows, selectSize, selectSortField, selectSortType, selectTotalElement } from '../../redux/selectors/groupSelectors';
import { getListGroupAction, updateSelectedRowsAction } from '../../redux/actions/groupActions';

import ToolkitProvider from 'react-bootstrap-table2-toolkit';

import CustomFilter from "./CustomFilter";

import paginationFactory from "react-bootstrap-table2-paginator";
import filterFactory, { customFilter } from 'react-bootstrap-table2-filter';
import CustomSearch from './CustomSearch';
import * as Icon from 'react-feather'
import BootstrapTable from "react-bootstrap-table-next";
import { Button, Card, CardBody, Col, Container, Row } from "reactstrap";
import { Modal, ModalBody, ModalFooter, ModalHeader } from "reactstrap";
import { ReactstrapInput } from "reactstrap-formik";
import { toastr } from "react-redux-toastr";
import { FastField, Form, Formik } from "formik";

import * as Yup from 'yup';
import GroupApi from '../../api/GroupApi';

const Group = (props) => {
  const getListGroups = props.getListGroupAction;
  const size = props.size;

  const [isVisibleFilter, setVisibleFilter] = useState(false);
  const [isOpenModalCreate, setOpenModalCreate] = useState(false);

  let onTotalMemberFilter;

  useEffect(() => {
    getListGroups(1, size);
  }, [getListGroups, size]);

  const actionFormatter = (cell, row, rowIndex) => {
    return (
      <Icon.Edit2 className="align-middle mr-1" size={18} onClick={() => updateGroup(row.id)} />
    );
  };

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
    },
    {
      dataField: "actions",
      text: "",
      align: () => {
        return 'center';
      },
      headerStyle: () => {
        return { width: '80px' };
      },
      formatter: actionFormatter
    }
  ];

  const onFilterChange = (minTotalMember, maxTotalMember) => {
    onTotalMemberFilter({ // get from filter callback
      minTotalMember,
      maxTotalMember
    });
  }

  const handleTableChange = (type, { page, sizePerPage, sortField, sortOrder, searchText, filters }) => {
    const filter = filters && filters.member && filters.member.filterVal ? filters.member.filterVal : null;
    const minTotalMember = filter && filter.minTotalMember ? filter.minTotalMember : null;
    const maxTotalMember = filter && filter.maxTotalMember ? filter.maxTotalMember : null;
    getListGroups(page, sizePerPage, sortField, sortOrder, searchText, minTotalMember, maxTotalMember);
  }

  const refreshForm = () => {
    handleTableChange(
      null,
      {
        page: 1,
        sizePerPage: size,
        sortField: null,
        sortOrder: null,
        searchText: "",
        filters: {
          minTotalMember: null,
          maxTotalMember: null
        }
      }
    );
    // refresh selected rows
    props.updateSelectedRowsAction([]);
  }

  const showSuccessNotification = (title, message) => {
    const options = {
      timeOut: 2500,
      showCloseButton: false,
      progressBar: false,
      position: "top-right"
    };

    // show notification
    toastr.success(title, message, options);
  }

  const showWrongNotification = (title, message) => {
    const options = {
      timeOut: 2500,
      showCloseButton: false,
      progressBar: false,
      position: "top-right"
    };

    // show notification
    toastr.error(title, message, options);
  }

  const [isOpenModalUpdate, setOpenModalUpdate] = useState(false);
  const [updateGroupInfo, setUpdateGroupInfo] = useState();

  const updateGroup = async (groupId) => {
    const groupInfo = await GroupApi.getByID(groupId);
    setUpdateGroupInfo(groupInfo);
    setOpenModalUpdate(true);
  }

  // delete 
  const deleteGroups = async () => {
    if (props.selectedRows === null || props.selectedRows === undefined || props.selectedRows.length === 0) {
      showWrongNotification(
        "Delete Group",
        "You have not selected group!"
      );
    } else {
      await GroupApi.deleteByIds(props.selectedRows);
      // show notification
      showSuccessNotification(
        "Delete Group",
        "Delete Group Successfully!");
      // reload group page
      refreshForm();
    }
  }

  const handleOnSelect = (row, isSelect) => {
    let selected = props.selectedRows;
    if (isSelect) {
      selected = [...selected, row.id]
    } else {
      selected = selected.filter(x => x !== row.id)
    }
    props.updateSelectedRowsAction(selected);
  }

  const handleOnSelectAll = (isSelect, rows) => {
    const ids = rows.map(r => r.id);
    let selected = [];

    if (isSelect) {
      selected = ids;
    }

    props.updateSelectedRowsAction(selected);
  }

  return (
    <Container fluid className="p-0">
      <h1 className="h3 mb-3">Group Page</h1>
      <Card>
        <CardBody>
          <ToolkitProvider
            keyField="id"
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
                      {isVisibleFilter && <CustomFilter onFilterChange={onFilterChange} />}
                    </Col>
                  </Row>
                  {/* search */}
                  <Row style={{ alignItems: "flex-end" }}>
                    <Col lg="9">
                      <CustomSearch {...toolkitprops.searchProps} />
                    </Col>
                    <Col lg="3" style={{ paddingBottom: 20 }}>
                      <div className="float-right pull-right">
                        <Icon.Filter size="24" className="align-middle mr-2"
                          onClick={() => setVisibleFilter(!isVisibleFilter)} />
                        <Icon.RefreshCcw size="24" className="align-middle mr-2"
                          onClick={() => refreshForm()} />
                        <Icon.PlusCircle size="24" className="align-middle mr-2" onClick={() => setOpenModalCreate(true)} />
                        <Icon.Trash2 size="24" className="align-middle mr-2" onClick={deleteGroups} />
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
                    sort={{
                      dataField: props.sortField,
                      order: props.sortType
                    }}
                    pagination={paginationFactory({
                      page: props.page,
                      totalSize: props.totalElement,
                      sizePerPage: props.size,
                      nextPageText: '>',
                      prePageText: '<',
                      withFirstAndLast: false,
                      alwaysShowAllBtns: true,
                      hideSizePerPage: true
                    })}
                    selectRow={{
                      mode: 'checkbox',
                      clickToSelect: true,
                      selected: props.selectedRows,
                      onSelect: handleOnSelect,
                      onSelectAll: handleOnSelectAll
                    }}
                    filter={filterFactory()}
                    onTableChange={handleTableChange}
                  />
                </>
              )
            }
          </ToolkitProvider>
        </CardBody>
      </Card>

      <Modal
        isOpen={isOpenModalCreate}
      >
        <Formik
          initialValues={
            {
              name: ''
            }
          }
          validationSchema={
            Yup.object({
              name: Yup.string()
                .required('Required')
                .max(50, 'Must be between 6 to 50 characters')
                .min(6, 'Must be between 6 to 50 characters')
                .test('checkUniqueName', 'This name is already exists.', async name => {
                  // call api
                  const isExists = await GroupApi.existsByName(name);
                  return !isExists;
                })
            })
          }
          onSubmit={
            async (values) => {
              try {
                // call api
                await GroupApi.create(values.name);
                setOpenModalCreate(false);
                // show notification
                showSuccessNotification(
                  "Create Group",
                  "Create Group Successfully!");
                // reload group page
                refreshForm();

              } catch (error) {
                console.log(error);
                setOpenModalCreate(false);
              }
            }
          }
          validateOnChange={false}
          validateOnBlur={false}
        >
          {({ isSubmitting }) => (
            <Form>
              {/* header */}
              <ModalHeader>
                Create Group
              </ModalHeader>

              {/* body */}
              <ModalBody className="m-3">

                {/* GroupName */}
                <Row style={{ alignItems: "center" }}>
                  <Col xs="auto">
                    Group Name:
                  </Col>
                  <Col>
                    <FastField
                      //label="Group Name"
                      bsSize="lg"
                      type="text"
                      name="name"
                      placeholder="Enter Group Name"
                      component={ReactstrapInput}
                    />
                  </Col>
                </Row>
              </ModalBody>

              {/* footer */}
              <ModalFooter>
                {/* resend */}
                <Button
                  color="primary"
                  style={{ marginLeft: 10 }}
                  disabled={isSubmitting}
                  type="submit"
                >
                  Save
                </Button>

                {/* close button */}
                <Button
                  color="primary"
                  onClick={() => setOpenModalCreate(false)}
                >
                  Cancel
                </Button>
              </ModalFooter>
            </Form>
          )}
        </Formik>
      </Modal>

      <Modal
        isOpen={isOpenModalUpdate}
      >
        <Formik
          initialValues={
            {
              name: updateGroupInfo ? updateGroupInfo.name : '',
              totalMember: updateGroupInfo ? updateGroupInfo.member : ''
            }
          }
          validationSchema={
            Yup.object({
              name: Yup.string()
                .required('Required')
                .max(50, 'Must be between 6 to 50 characters')
                .min(6, 'Must be between 6 to 50 characters')
                .test('checkUniqueName', 'This name is already exists.', async name => {
                  if (name === updateGroupInfo.name) {
                    return true;
                  }

                  // call api
                  const isExists = await GroupApi.existsByName(name);
                  return !isExists;
                }),
              totalMember: Yup.number()
                .min(0, "Must be a positive integer")
                .integer("Must be a positive integer"),
            })
          }
          onSubmit={
            async (values) => {
              try {
                // call api
                await GroupApi.update(updateGroupInfo.id, values.name, values.totalMember, updateGroupInfo.createDate);
                setOpenModalUpdate(false);
                // show notification
                showSuccessNotification(
                  "Update Group",
                  "Update Group Successfully!");
                // reload group page
                refreshForm();

              } catch (error) {
                console.log(error);
                setOpenModalUpdate(false);
              }
            }
          }
          validateOnChange={false}
          validateOnBlur={false}
        >
          {({ isSubmitting }) => (
            <Form>
              {/* header */}
              <ModalHeader>
                Update Group
              </ModalHeader>

              {/* body */}
              <ModalBody className="m-3">

                {/* GroupName */}
                <Row style={{ alignItems: "center" }}>
                  <Col xs="auto">
                    Group Name:
                  </Col>
                  <Col>
                    <FastField
                      //label="Group Name"
                      bsSize="lg"
                      type="text"
                      name="name"
                      placeholder="Enter Group Name"
                      component={ReactstrapInput}
                    />
                  </Col>
                </Row>
                {/* Total Member */}
                <Row style={{ alignItems: "center" }}>
                  <Col xs="auto">
                    Total Member:
                  </Col>
                  <Col>
                    <FastField
                      bsSize="lg"
                      type="number"
                      name="totalMember"
                      placeholder="Enter Total Member"
                      component={ReactstrapInput}
                    />
                  </Col>
                </Row>
              </ModalBody>

              {/* footer */}
              <ModalFooter>
                {/* resend */}
                <Button
                  color="primary"
                  style={{ marginLeft: 10 }}
                  disabled={isSubmitting}
                  type="submit"
                >
                  Save
                </Button>

                {/* close button */}
                <Button
                  color="primary"
                  onClick={() => setOpenModalUpdate(false)}
                >
                  Cancel
                </Button>
              </ModalFooter>
            </Form>
          )}
        </Formik>
      </Modal>

    </Container>
  )
};

const mapGlobalStateToProps = state => {
  return {
    groups: selectListGroup(state),
    page: selectPage(state),
    size: selectSize(state),
    totalElement: selectTotalElement(state),
    sortField: selectSortField(state),
    sortType: selectSortType(state),
    selectedRows: selectSelectedRows(state)
  };
};

export default connect(mapGlobalStateToProps, { getListGroupAction, updateSelectedRowsAction })(Group);