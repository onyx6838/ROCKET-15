$(function () {
    $(".header").load("header.html");
    $(".sidenav").load("sidebar.html");
    $(".main").load("home.html");
    $(".footer").load("footer.html");
});

function clickSideBarHome() {
    $(".main").load("home.html");
}

function clickSideBarDepartment() {
    $(".main").load("viewlist.html", function () {
        resetPaging();
        resetSort();
        getDataToTable();
    });
}

function openModal() {
    $('#myModal').modal('show');
}

function hideModal() {
    $('#myModal').modal('hide');
}

function openAddModal() {
    resetForm();
    openModal();
    $('input#name').attr('readonly', false);
}

function resetForm() {
    $('input#name').val('');
}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function () {
        $("#success-alert").slideUp(500);
    });
}