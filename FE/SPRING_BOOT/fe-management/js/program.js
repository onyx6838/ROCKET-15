var departments = [];

function getDataToTable() {
    $.get("http://localhost:8080/api/v1/departments", function (data, status) {
        // reset list employees
        departments = [];

        // error
        if (status == "error") {
            // TODO
            alert("Error when loading data");
            return;
        }

        // success
        departments = data;
        fillDataToTable();
    });
}

function fillDataToTable() {
    departments.forEach(function (item) {
        $('tbody').append(
            '<tr>' +
            '<td>' + item.id + '</td>' +
            '<td>' + item.name + '</td>' +
            '<td>' +
            '<a class="edit" onclick="openUpdateModal(' + item.id + ')"><i class="glyphicon glyphicon-pencil"></i></a>&nbsp;' +
            '<a class="delete" onclick="openConfirmDelete(' + item.id + ')"><i class="glyphicon glyphicon-trash"></i></a>' +
            '</td>' +
            '</tr>')
    });
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
    var index = departments.findIndex(x => x.id == id);
    var name = departments[index].name;

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