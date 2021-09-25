var departments = [];
var currentPage = 1;
var size = 3;
var sortField = "modifiedDate";
var isAsc = false;

var search = '';

var minCreateDate = "";
var maxCreateDate = "";

function getDataToTable() {
    var url = "http://localhost:8080/api/v1/departments";

    url += "?page=" + currentPage + "&size=" + size;

    url += "&sort=" + sortField + "," + (isAsc ? "asc" : "desc");

    $.get(url, function (data, status) {
        departments = [];
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        departments = data.content;
        fillDepartmentToTable();
        pagingTable(data.totalPages);
        renderSortUI();
    });
}

/**
 * init data to Table
 */
function fillDataToTable() {
    var tr;
    $('#dpt_body').empty();
    displayRecords.forEach(function (item, index) {
        tr = $('<tr/>');
        tr.append('<td>' + '<input id="checkbox-' + index + '" type="checkbox" onClick="onChangeCheckboxItem()">' + '</td>');
        tr.append('<td>' + item.id + '</td>');
        tr.append('<td>' + item.name + '</td>');
        tr.append('<td>' + '<a class="edit" onclick="openUpdateModal(' + item.id + ')"><i class="glyphicon glyphicon-pencil"></i></a>&nbsp;' +
            '<a class="delete" onclick="openConfirmDelete(' + item.id + ')"><i class="glyphicon glyphicon-trash"></i></a>' +
            '</td>');
        $('tbody').append(tr);
    });
}

/**
 * Paging function
 */
function pagingTable(pageAmount) {

    var pagingStr = "";

    if (pageAmount > 1 && currentPage > 1) {
        pagingStr +=
            '<li class="page-item">' +
            '<a class="page-link" onClick="prevPaging()">Previous</a>' +
            '</li>';
    }

    for (i = 0; i < pageAmount; i++) {
        pagingStr +=
            '<li class="page-item ' + (currentPage == i + 1 ? "active" : "") + '">' +
            '<a class="page-link" onClick="changePage(' + (i + 1) + ')">' + (i + 1) + '</a>' +
            '</li>';
    }

    if (pageAmount > 1 && currentPage < pageAmount) {
        pagingStr +=
            '<li class="page-item">' +
            '<a class="page-link" onClick="nextPaging()">Next</a>' +
            '</li>';
    }

    $('#pagination').empty();
    $('#pagination').append(pagingStr);

}

function resetPaging() {
    currentPage = 1;
    size = 3;
}

function prevPaging() {
    changePage(currentPage - 1);
}

function nextPaging() {
    changePage(currentPage + 1);
}

function changePage(page) {
    if (page == currentPage) {
        return;
    }
    currentPage = page;
    buildTable();
}

/**
 * Sort table
 */
 function renderSortUI() {
    var sortTypeClazz = isAsc ? "fa-sort-asc" : "fa-sort-desc";

    switch (sortField) {
        case 'name':
            changeIconSort("heading-name", sortTypeClazz);
            changeIconSort("heading-author", "fa-sort");
            changeIconSort("heading-createDate", "fa-sort");
            break;
        case 'author.fullName':
            changeIconSort("heading-author", sortTypeClazz);
            changeIconSort("heading-name", "fa-sort");
            changeIconSort("heading-createDate", "fa-sort");
            break;
        case 'createDate':
            changeIconSort("heading-createDate", sortTypeClazz);
            changeIconSort("heading-name", "fa-sort");
            changeIconSort("heading-author", "fa-sort");
            break;
        default:
            changeIconSort("heading-name", "fa-sort");
            changeIconSort("heading-author", "fa-sort");
            changeIconSort("heading-createDate", "fa-sort");
            break;
    }
}

function changeIconSort(id, sortTypeClazz) {
    document.getElementById(id).classList.remove("fa-sort", "fa-sort-asc", "fa-sort-desc");
    document.getElementById(id).classList.add(sortTypeClazz);
}

function changeSort(field) {
    if (field == sortField) {
        isAsc = !isAsc;
    } else {
        sortField = field;
        isAsc = true;
    }
    buildTable();
}

function resetSort() {
    sortField = 'modifiedDate';
    isAsc = false;
}

function save() {
    var id = $('input#id').val();

    if (id == null || id == "") {
        addDataToTable();
    } else {
        updateDataToTable();
    }
}

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

function openConfirmDelete(id) {
    var index = records.findIndex(x => x.id == id);
    var name = records[index].name;

    var result = confirm("Want to delete " + name + "?");
    if (result) {
        deleteEmployee(id);
    }
}

function deleteEmployee(id) {
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
    hideModal();
    showSuccessAlert();
    buildTable();
}