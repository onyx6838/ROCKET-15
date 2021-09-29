var departments = [];
// paging data
var pageNumber = 1;
var size = 3;
var maxPage = 2;
// sort data
var sortField = "id";
var isAsc = false;
// filter data and searching
var search = '';
var minCreateDate = "";
var maxCreateDate = "";
// old name data
var oldName;
/**
 * GET API
 */
function getDataToTable() {
    var url = "http://localhost:8080/api/v1/groups";

    url += "?page=" + pageNumber + "&size=" + size;

    url += "&sort=" + sortField + "," + (isAsc ? "asc" : "desc");

    var search = $('#input-search').val();
    if (search) {
        url += "&search=" + search;
    }

    $.ajax({
        url: url,
        type: 'GET',
        contentType: "application/json",
        dataType: 'json', // datatype return
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function (data, textStatus, xhr) {
            // reset list employees
            departments = [];
            departments = data.content;
            fillDataToTable();
            checkAllCheckBox(false);
            pagingTable(data.totalPages);
            //sortUI();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
            if (jqXHR.status == 403) {
                window.location.href = "http://127.0.0.1:5501/html/forbidden.html";
            }
        }
    });
}

/**
 * init
 */
function fillDataToTable() {
    var tr;
    $('#dpt_body').empty();
    departments.forEach(function (item, index) {
        tr = $('<tr/>');
        tr.append('<td>' + '<input id="checkbox-' + index + '" type="checkbox" class="cb-child" data-id="' + index + '" onClick="onChangeCheckboxItem()" >' + '</td>');
        tr.append('<td>' + index + '</td>');
        tr.append('<td>' + item.name + '</td>');
        tr.append('<td>' + item.member + '</td>');
        tr.append('<td>' + item.creator.fullName + '</td>');
        tr.append('<td>' + item.createDate + '</td>');
        tr.append('<td>' + '<a class="edit" onclick="openUpdateModal(' + item.id + ')"><i class="glyphicon glyphicon-pencil"></i></a>&nbsp;' +
            '<a class="delete" onclick="openConfirmDelete(' + item.id + ')"><i class="glyphicon glyphicon-trash"></i></a>' +
            '</td>');
        $('tbody').append(tr);
    });
}

/**
 * Paging
 */
function pagingTable(pageCount) {
    var pagingStr = "";

    var startPageIndex = Math.max(1, pageNumber - maxPage / 2);
    var endPageIndex = Math.min(pageCount, pageNumber + maxPage / 2);
    //console.log(startPageIndex + " -- " + endPageIndex);

    if (pageNumber != 1) {
        pagingStr +=
            '<li class="page-item">' +
            '<a href="#" class="page-link" id="' + (pageNumber - 1) + '" onClick="prevPaging()">Previous</a>' +
            '</li>';
    }

    for (i = startPageIndex; i <= endPageIndex; i++) {
        pagingStr +=
            '<li class="page-item ' + (pageNumber == i ? "active" : "") + '">' +
            '<a class="page-link" onClick="changePage(' + i + ')">' + i + '</a>' +
            '</li>';
    }
    if (pageNumber != pageCount) {
        pagingStr +=
            '<li class="page-item">' +
            '<a class="page-link" onClick="nextPaging()">Next</a>' +
            '</li>';
    }

    $('#pagination').empty();
    $('#pagination').append(pagingStr);
}

function resetPaging() {
    pageNumber = 1;
}

function prevPaging() {
    changePage(pageNumber - 1);
}

function nextPaging() {
    changePage(pageNumber + 1);
}

function changePage(page) {
    if (page == pageNumber) {
        return;
    }
    pageNumber = page;
    getDataToTable();
}
/**
 * Sorting
 */
function sortUI() {
    var sortTypeClazz = isAsc ? "fa-sort-asc" : "fa-sort-desc";
    var sortDefault = 'fa-sort';
    switch (sortField) {
        case 'name':
            changeIconSort("sort-name", sortTypeClazz);
            changeIconSort("sort-member", sortDefault);
            break;
        case 'member':
            changeIconSort("sort-member", sortTypeClazz);
            changeIconSort("sort-name", sortDefault);
            changeIconSort("sort-creator", sortDefault);
            changeIconSort("sort-createDate", sortDefault);
            break;
        case 'creator':
            changeIconSort("sort-creator", sortTypeClazz);
            changeIconSort("sort-name", sortDefault);
            changeIconSort("sort-member", sortDefault);
            changeIconSort("sort-createDate", sortDefault);
            break;
        case 'createDate':
            changeIconSort("sort-createDate", sortTypeClazz);
            changeIconSort("sort-member", sortDefault);
            changeIconSort("sort-name", sortDefault);
            changeIconSort("sort-creator", sortDefault);
            break;
        default:
            changeIconSort("sort-name", sortDefault);
            changeIconSort("sort-member", sortDefault);
            changeIconSort("sort-creator", sortDefault);
            changeIconSort("sort-createDate", sortDefault);
            break;
    }
}

function changeIconSort(id, sortTypeClazz) {
    $(this.id).removeClass();
    $(this.id).toggleClass(sortTypeClazz);
}

function changeSort(field) {
    if (field == sortField) {
        isAsc = !isAsc;
    } else {
        sortField = field;
        isAsc = true;
    }
    getDataToTable();
}

function resetSort() {
    sortField = "id";
    isAsc = false;
}
/**
 * Searching
 */
function resetSearch() {
    $('#input-search').val('');
}

function handKeyUpEventForSearching(event) { // enter key event
    // Number 13 is the "Enter" key on the keyboard
    if (event.keyCode === 13) {
        event.preventDefault();
        handleSearch();
    }
}

/**
 * reset paging, sort, checkbox, filter, fill data
 */
function handleSearch() {
    resetPaging();
    resetSort();
    resetDeleteCheckbox();
    resetFilter();
    getDataToTable();
}

/**
 * filter
 */
function changeMinCreateDate(e) {
    minCreateDate = e.target.value;
    console.log(minCreateDate);
    //handleSearch(); // reset after binding value to url
}

function changeMaxCreateDate(e) {
    maxCreateDate = e.target.value;
    //handleSearch(); // reset after binding value to url
}

function resetFilter() {
    minCreateDate = "";
    maxCreateDate = "";
    $('#minCreateDate').val('');
    $('maxCreateDate').val('');
}

/**
 * Save or update
 */
function save() {
    var id = $('input#id').val();
    if (id == null || id == "") {
        addDataToTable();
    } else {
        updateDataToTable(id);
    }
}
/**
 * Add data
 */
function addDataToTable() {
    var name = $('input#name').val();
    if (!name || name.length < 6 || name.length > 30) {
        // show error message
        showNameErrMsg("Group name must be from 6 to 30 characters!");
        return;
    }
    //validate(name);

    // promise
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/api/v1/groups/name/" + name + "/exists",
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        }
    }).then(data => {
        if (data) {
            showNameErrMsg("Group name is exists!");
            return;
        } else {
            var department = {
                name: name,
                creatorId: storage.getItem('ID')
            };
            return $.ajax({
                url: 'http://localhost:8080/api/v1/groups',
                type: 'POST',
                data: JSON.stringify(department),
                contentType: "application/json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
                }
            }).then(() => {
                hideModal();
                showSuccessAlert();
                buildSuccess();
            });
        }
    });
}
/**
 * Update Data
 */
function openUpdateModal(id) {
    //$('input#name').attr('readonly', true); // can't change data in name input 
    //$('input#name').rules('remove', "uniqueName"); // remove exist name rule validate
    $.ajax({
        url: 'http://localhost:8080/api/v1/groups/' + id,
        type: 'GET',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function (result) {
            openModal();
            resetForm('UPDATE');
            // binding
            $('input#id').val(result.id);
            $('input#name').val(result.name);
            $('input#member').val(result.member);
            $('input#creator').val(result.creator.fullName);
            $('input#createDate').val(result.createDate);
            oldName = result.name;
        },
        error: function (xhr, status, error) {
            console.log(xhr.status);
            console.log(error);
            return;
        }
    });
}

function updateDataToTable(id) {
    var name = $('input#name').val();
    if (!name || name.length < 6 || name.length > 30) {
        // show error message
        showNameErrMsg("Group name must be from 6 to 30 characters!");
        return;
    }
    if (oldName == name) {
        // success
        buildSuccess();
        return;
    }

    // promise
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/api/v1/groups/name/" + name + "/exists",
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        }
    }).then(data => {
        if (data) {
            showNameErrMsg("Group name is exists!");
            return;
        } else {
            var department = {
                name: name
            };
            return $.ajax({
                url: 'http://localhost:8080/api/v1/groups/' + id,
                type: 'PUT',
                data: JSON.stringify(department),
                contentType: "application/json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
                }
            }).then(() => {
                hideModal();
                showSuccessAlert();
                getDataToTable();
            });
        }
    });
}
/**
 * Delete Data
 */
function checkAllCheckBox(isChecked) {
    $('input.cb-child:checkbox').prop('checked', isChecked);
}

function onChangeCheckboxItem() {
    if ($('input.cb-child:checkbox:checked').length == $('input.cb-child:checkbox').length) {
        $('#checkbox-all').prop('checked', true);
    } else {
        $('#checkbox-all').prop('checked', false);
    }
}

function resetDeleteCheckbox() {
    $('#checkbox-all').prop('checked', false);
    $('input.cb-child:checkbox').prop('checked', false);
}

function deleteAllDepartment() {
    var ids = [];
    var names = [];

    $('input.cb-child:checkbox:checked').each(function () {
        ids.push(departments[$(this).attr('data-id')].id);
        names.push(departments[$(this).attr('data-id')].name);
    })
    var result = confirm("Want to delete " + names + "?");
    if (result) {
        deleteDepartments(ids);
    }
}

function openConfirmDelete(id) {
    var index = departments.findIndex(x => x.id == id);
    var name = departments[index].name;

    var result = confirm("Want to delete " + name + "?");
    if (result) {
        deleteDepartment(id);
    }
}

function deleteDepartments(ids) {
    $.ajax({
        url: 'http://localhost:8080/api/v1/groups?ids=' + ids,
        type: 'DELETE',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function (result) {
            buildSuccess();
            handleSearch();
        },
        error: function (xhr, status, error) {
            console.log(xhr.status);
            console.log(error);
            return;
        }
    });
}

function deleteDepartment(id) {
    $.ajax({
        url: 'http://localhost:8080/api/v1/groups/' + id,
        type: 'DELETE',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function (result) {
            buildSuccess();
        },
        error: function (xhr, status, error) {
            console.log(xhr.status);
            console.log(error);
            return;
        }
    });
}

function buildSuccess() { // C,U,D success
    hideModal();
    showSuccessAlert();
    getDataToTable();
}

function validate(input) {
    if (!input || input.length < 6 || input.length > 30) {
        // show error message
        showNameErrMsg("Department name must be from 6 to 30 characters!");
        return;
    }
}