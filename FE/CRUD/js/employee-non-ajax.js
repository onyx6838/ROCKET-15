/**
 * variables
 */
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
  * init fake data for table 
  */
 
 function initEmployees() {
     if (employees == null || employees.length == 0) {
         employees.push(new Employee("John Doe", "Administration", "(171) 555-2222"));
         employees.push(new Employee("Peter Parker", "Customer Service", "(313) 555-5735"));
         employees.push(new Employee("Fran Wilson", "Human Resources", "(503) 555-9931"));
         employees.push(new Employee("Jack Wilson", "Human Resources", "(503) 555-9931"));
         employees.push(new Employee("Tom Wilson", "Human Resources", "(503) 555-9931"));
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
 /**
  * add employee
  */
 function addEmployee() {
     var name = $('#name').val('');
     var department = $('#department').val();
     var phone = $('#phone').val('');
 
     // TODO validate
     // then fail validate ==> return;
 
     employees.push(new Employee(name, department, phone));
 
     hideModal();
     showSuccessAlert();
     buildTable();
 }
 
 function openUpdateModal(id) {
     // get index from employee's id
     var index = employees.findIndex(x => x.id == id);
 
     // fill data
     $('#id').val(employees[index].id)
     $('#name').val(employees[index].name)
     $('#department').val(employees[index].department)
     $('#phone').val(employees[index].phone)
 
     openModal();
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
 
     // get index from employee's id
     var index = employees.findIndex(x => x.id == id);
 
     // update employee
     employees[index].name = name;
     employees[index].department = department;
     employees[index].phone = phone;
 
     hideModal();
     showSuccessAlert();
     buildTable();
 }
 
 
 /**
  * confirm delete with id selected
  * @param {*} id 
  */
 function openConfirmDelete(id) {
     var index = employees.findIndex(x => x.id == id);
     var name = employees[index].name;
     var result = confirm("Want to delete " + name + " ?");
     if (result) {
         deleteEmployee(index);
     }
 }
 
 /**
  * delete employee
  */
 function deleteEmployee(index) {
     employees.splice(index, 1);
     buildTable();
 }
 
 /**
  * fade alert success
  */
 function showSuccessAlert() {
     $("#success-alert").fadeTo(2000, 500).slideUp(500, function () {
         $("#success-alert").slideUp(500);
     });
 }