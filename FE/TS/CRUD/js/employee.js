var employees = [];
var counter = 0;

/**
 * create Employee object
 * @param {*} name 
 * @param {*} department 
 * @param {*} phone 
 */

function Employee(name, department, phone) {
    this.id = ++counter; // auto-increment
    this.name = name;
    this.department = department;
    this.phone = phone;
}

/**
 * 
 */
 function openAddModal() {
    //resetForm();
    openModal();
}


/**
 * 
 */
function openModal() {
    $('#myModal').modal('show');
}

/**
 * 
 */
 function hideModal() {
    $('#myModal').modal('hide');
}

/**
 * init fake data for table 
 */

function initEmployees() {
    if (employees == null || employees.length == 0) {
        employees.push(new Employee("John Doe", "Administration", "(171) 555-2222"));
        employees.push(new Employee("Peter Parker", "Customer Service", "(313) 555-5735"));
        employees.push(new Employee("Fran Wilson", "Human Resources", "(503) 555-9931"));
        employees.push(new Employee("Fran Wilson", "Human Resources", "(503) 555-9931"));
        employees.push(new Employee("Fran Wilson", "Human Resources", "(503) 555-9931"));
    }
}

/**
 * build table
 */

function buildTable() {
    function appendToTable() {
        $('tbody').empty();
        initEmployees();

        employees.forEach(function (item) {
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
    };
    setTimeout(appendToTable, 500);
}

function openConfirmDelete(id) {
    var id = employees.findIndex(x => x.id == id);
    var name = employees[id].name;
    var result = confirm("Want to delete " + name + " ?");
    if (result) {
        deleteEmployee(id);
    }
}


function deleteEmployee() {
    employees.splice(employees.findIndex(x => x.id === id), 1)
}