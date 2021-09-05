$(function () {
    $(".header").load("header.html");
    $(".main").load("home.html");
    $(".footer").load("footer.html");
});

function clickNavHome() {
    $(".main").load("home.html");
}

function clickNavViewListDepartments() {
    $(".main").load("viewlistdepartments.html", function () {
        buildTable();
    });
}

var departments = [];

function getListDepartments() {
    // call API from server
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
        fillDepartmentToTable();
        resetDeleteCheckbox();
    });
}

function resetDeleteCheckbox() {
    // reset delete all checkbox
    document.getElementById("checkbox-all").checked = false;

    // reset checkbox item
    var i = 0;
    while (true) {
        var checkboxItem = document.getElementById("checkbox-" + i);
        if (checkboxItem !== undefined && checkboxItem !== null) {
            checkboxItem.checked = false;
            i++;
        } else {
            break;
        }
    }
}

function fillDepartmentToTable() {
    departments.forEach(function (item, index) {
        $('tbody').append(
            '<tr>' +
            '<td><input id="checkbox-' + index + '" type="checkbox" onClick="onChangeCheckboxItem()"></td>' +
            '<td>' + item.name + '</td>' +
            '<td>' + item.author.fullName + '</td>' +
            '<td>' + item.createDate + '</td>' +
            '<td>' +
            '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
            '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
            '</td>' +
            '</tr>')
    });
}

function buildTable() {
    $('tbody').empty();
    getListDepartments();
}

function openAddModal() {
    openModal();
    resetFormAdd();
}

function resetFormAdd() {
    document.getElementById("titleModal").innerHTML = "Add Department";
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
    document.getElementById("authorLabel").style.display = "none";
    document.getElementById("author").style.display = "none";
    document.getElementById("createdDateLabel").style.display = "none";
    document.getElementById("createdDate").style.display = "none";
}

function openModal() {
    $('#myModal').modal('show');
}

function hideModal() {
    $('#myModal').modal('hide');
}

function addDepartment() {

    // get data
    var name = document.getElementById("name").value;

    // TODO validate
    // then fail validate ==> return;

    var department = {
        name: name,
        authorId: 3
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/departments',
        type: 'POST',
        data: JSON.stringify(department), // body
        contentType: "application/json", // type of body (json, xml, text)
        // dataType: 'json', // datatype return
        success: function (data, textStatus, xhr) {
            console.log(data);
            // success
            hideModal();
            showSuccessAlert();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            alert("Error when loading data");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function resetFormUpdate() {
    document.getElementById("titleModal").innerHTML = "Update Department";
    document.getElementById("authorLabel").style.display = "block";
    document.getElementById("author").style.display = "block";
    document.getElementById("createdDateLabel").style.display = "block";
    document.getElementById("createdDate").style.display = "block";
}

function openUpdateModal(id) {
    $.get("http://localhost:8080/api/v1/departments/" + id, function (data, status) {

        // error
        if (status == "error") {
            // TODO
            alert("Error when loading data");
            return;
        }

        // success
        openModal();
        resetFormUpdate();

        // fill data
        document.getElementById("id").value = data.id;
        document.getElementById("name").value = data.name;
        document.getElementById("author").value = data.author.fullName;
        document.getElementById("createdDate").value = data.createDate;
    });
}

function save() {
    var id = document.getElementById("id").value;

    if (id == null || id == "") {
        addDepartment();
    } else {
        updateDepartment();
    }
}

function updateDepartment() {
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;

    // TODO validate
    // then fail validate ==> return;

    var department = {
        name: name
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'PUT',
        data: JSON.stringify(department), // body
        contentType: "application/json", // type of body (json, xml, text)
        // dataType: 'json', // datatype return
        success: function (data, textStatus, xhr) {
            console.log(data);
            // success
            hideModal();
            showSuccessAlert();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            alert("Error when loading data");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}


function openConfirmDelete(id) {
    // get index from employee's id
    var index = departments.findIndex(x => x.id == id);
    var name = departments[index].name;

    var result = confirm("Want to delete " + name + "?");
    if (result) {
        deleteDepartment(id);
    }
}

function deleteDepartment(id) {
    // TODO validate

    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'DELETE',
        success: function (result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }

            // success
            showSuccessAlert();
            buildTable();
        }
    });
}

function onChangeCheckboxItem() {
    var i = 0;
    while (true) {
        var checkboxItem = document.getElementById("checkbox-" + i);
        if (checkboxItem !== undefined && checkboxItem !== null) {
            if (!checkboxItem.checked) {
                document.getElementById("checkbox-all").checked = false;
                return;
            }
            i++;
        } else {
            break;
        }
    }
    document.getElementById("checkbox-all").checked = true;

}

function onChangeCheckboxAll() {
    var i = 0;
    while (true) {
        var checkboxItem = document.getElementById("checkbox-" + i);
        if (checkboxItem !== undefined && checkboxItem !== null) {
            checkboxItem.checked = document.getElementById("checkbox-all").checked
            // if (document.getElementById("checkbox-all").checked) {
            //     checkboxItem.checked = true;
            // } else {
            //     checkboxItem.checked = false;
            // }
            i++;
        } else {
            break;
        }
    }
}

function deleteAllDepartment() {
    // get checked
    var ids = [];
    var names = [];
    var i = 0;
    while (true) {
        var checkboxItem = document.getElementById("checkbox-" + i);
        if (checkboxItem !== undefined && checkboxItem !== null) {
            if (checkboxItem.checked) {
                ids.push(departments[i].id);
                names.push(departments[i].name);
            }
            i++;
        } else {
            break;
        }
    }

    // open confirm ==> bạn có muốn xóa bản ghi ...

    var result = confirm("Want to delete " + names + "?");
    if (result) {
        // call API
        $.ajax({
            url: 'http://localhost:8080/api/v1/departments?ids=' + ids,
            type: 'DELETE',
            success: function (result) {
                // error
                if (result == undefined || result == null) {
                    alert("Error when loading data");
                    return;
                }

                // success
                showSuccessAlert();
                buildTable();
            }
        });
    }

}



function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function () {
        $("#success-alert").slideUp(500);
    });
}