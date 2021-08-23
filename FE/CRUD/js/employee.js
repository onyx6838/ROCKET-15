/**
 * Employee constructor
 * @param {*} id 
 * @param {*} name 
 * @param {*} department 
 * @param {*} phonenumber 
 */
function Employee(id, name, department, phonenumber) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.phonenumber = phonenumber;
}

/**
 * init data
 */
function initEmployees() {
    $.ajax({
        type: "GET",
        url: "https://6123b178124d8800175683d7.mockapi.io/employees",
        success: function (data) {
            buildTable(data);
        }
    });
}

/**
 * build table
 */
function buildTable(data) {
    setTimeout(function appendToTable() {
        $('tbody').empty();
        data.forEach(function (item) {
            $('tbody').append(
                '<tr>' +
                '<td>' + item.name + '</td>' +
                '<td>' + item.department + '</td>' +
                '<td>' + item.phone + '</td>' +
                '<td>' +
                '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
                '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
                '</td>' +
                '</tr>')
        });
    }, 500);
}

/**
 * add employee
 */
function addEmployee() {
    var name = $('#name').val();
    var department = $('#department').val();
    var phone = $('#phone').val();

    // TODO validate
    // then fail validate ==> return;

    $.ajax({
        type: "POST",
        url: "https://6123b178124d8800175683d7.mockapi.io/employees",
        dataType: "json",
        data: {
            name: name,
            department: department,
            phone: phone
        },
        success: function (response) {
            hideModal();
            showSuccessAlert();
            initEmployees();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);
        }
    });
}

function openUpdateModal(id) {
    $.ajax({
        type: "GET",
        url: "https://6123b178124d8800175683d7.mockapi.io/employees/" + id,
        dataType: "json",
        success: function (response) {
            $('#id').val(response.id)
            $('#name').val(response.name)
            $('#department').val(response.department)
            $('#phone').val(response.phone)
            openModal();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);
        }
    });
}

/**
 * save or update modal
 */
function save() {
    var id = $('#id').val();

    if (id == null || id == "") {
        addEmployee();
    } else {
        updateEmployee();
    }
}

/**
 * update employee
 */
function updateEmployee() {
    var id = $('#id').val();
    var name = $('#name').val();
    var department = $('#department').val();
    var phone = $('#phone').val();

    // TODO validate
    // then fail validate ==> return;

    $.ajax({
        type: "PUT",
        url: "https://6123b178124d8800175683d7.mockapi.io/employees/" + id,
        dataType: "json",
        data: {
            name: name,
            department: department,
            phone: phone
        },
        success: function (response) {
            hideModal();
            showSuccessAlert();
            initEmployees();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);
        }
    });
}


/**
 * confirm delete with id selected
 * @param {*} id 
 */
function openConfirmDelete(id) {
    var result = confirm("Want to delete ?");
    if (result) {
        $.ajax({
            type: "DELETE",
            url: "https://6123b178124d8800175683d7.mockapi.io/employees/" + id,
            dataType: "json",
            success: function (response) {
                showSuccessAlert();
                initEmployees();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus, errorThrown);
            }
        });
    }
}

/**
 * fade alert success
 */
function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function () {
        $("#success-alert").slideUp(500);
    });
}