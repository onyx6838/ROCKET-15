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
/**
 * GET all call
 */
function getDataToTable() {
    var url = "http://localhost:8080/api/v1/departments";

    url += "?page=" + pageNumber + "&size=" + size;

    url += "&sort=" + sortField + "," + (isAsc ? "asc" : "desc");

    $.get(url, function (data, status) {
        departments = [];
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        departments = data.content;
        fillDataToTable();
        checkAllCheckBox(false);
        pagingTable(data.totalPages);
        sortUI();
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
        tr.append('<td>' + item.name + '</td>');
        tr.append('<td>' + item.totalMember + '</td>');
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
            changeIconSort("sort-totalMember", sortDefault);
            break;
        case 'totalMember':
            changeIconSort("sort-name", sortTypeClazz);
            changeIconSort("sort-totalMember", sortDefault);
            break;
        default:
            changeIconSort("sort-name", sortDefault);
            changeIconSort("sort-totalMember", sortDefault);
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
 * Save or update
 */
function save() {
    var id = $('input#id').val();

    if (id == null || id == "") {
        addDataToTable();
    } else {
        updateDataToTable();
    }
}
/**
 * Add data
 */
function addDataToTable() {
    var name = $('input#name').val();
    var department = {
        name: name
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/departments',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(department),
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
/**
 * Update Data
 */
function openUpdateModal(id) {
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'GET',
        success: function (result) {
            $('input#id').val(result.id);
            $('input#name').val(result.name);
            openModal();
        },
        error: function (xhr, status, error) {
            console.log(xhr.status);
            console.log(error);
            return;
        }
    });
}

function updateDataToTable() {
    var id = $('input#id').val();
    var name = $('input#name').val();

    // TODO validate
    var department = {
        name: name
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(department),
        success: function (result) {
            // success
            buildSuccess();
        },
        error: function (xhr, status, error) {
            console.log(xhr.status);
            console.log(error);
            return;
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
    var index = records.findIndex(x => x.id == id);
    var name = records[index].name;

    var result = confirm("Want to delete " + name + "?");
    if (result) {
        deleteDepartment(id);
    }
}

function deleteDepartments(ids) {
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments?ids=' + ids,
        type: 'DELETE',
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

function deleteDepartment(id) {
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'DELETE',
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
    $('#checkbox-all').prop('checked', false);
    hideModal();
    showSuccessAlert();
    resetPaging();
    getDataToTable();
}