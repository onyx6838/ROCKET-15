/**
 * load container
 */
$(function () {
    $(".header").load("header.html");
    $(".main").load("main.html");
    $(".footer").load("footer.html");
});

/**
 * load home page
 */
function loadHomePage() {
    $(".main").load("home.html");
}

/**
 * load view list page
 */
function loadListPage() {
    $(".main").load("table-employee.html");
    buildTable();
}

/**
 * control modal
 */
function openAddModal() {
    resetForm();
    openModal();
}

/**
 * open modal form
 */
function openModal() {
    $('#idModal').modal('show')
}

/**
 * hide modal form
 */
function hideModal() {
    $('#idModal').modal('hide');
}

/**
 * reset modal form
 */
function resetForm() {
    $('#id').val('');
    $('#name').val('');
    $('#department').val('');
    $('#phone').val('');
}