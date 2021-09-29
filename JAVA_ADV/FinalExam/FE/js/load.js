$(function () {
    if (!storage.getItem("ID")) window.location.replace("http://127.0.0.1:5501/html/login.html");
    $(".header").load("header.html", function () {
        $('#name_login').html(storage.getItem('FULL_NAME'));
    });
    $(".sidenav").load("sidebar.html", function () {
        if (storage.getItem('ROLE') == 'User') $('#groupViewList').hide();
    });
    $(".main").load("home.html");
    $(".footer").load("footer.html");
});

function logout() {
    storage.removeItem("ID");
    storage.removeItem("FULL_NAME");
    storage.removeItem("USERNAME");
    storage.removeItem("PASSWORD");
    storage.removeItem("ROLE");

    // redirect to login page
    window.location.replace("http://127.0.0.1:5501/html/login.html");
}

function clickSideBarHome() {
    $(".main").load("home.html");
}

function clickSideBarAccount() {
    $(".main").load("account.html");
}

function clickSideBarGroup() {
    $(".main").load("viewlist.html", () => {
        handleSearch();
    });
}

function openModal() {
    $('#myModal').modal('show');
}

function hideModal() {
    $('#myModal').modal('hide');
}

function openAddModal() {
    openModal();
    resetForm('ADD');
}

function resetForm(type) {
    var style = (type == 'ADD' ? 'none' : 'block');
    if (type == 'ADD') {
        $('input#id , input#name').val('');
    }
    $('.modal-title').html(type + ' Group'); // set title
    $('label#label-creator , label#label-member , label#label-createDate').css('display', style); // css
    $('input#creator , input#member , input#createDate').css('display', style); // css
    hideNameErrMsg('none');
}

function showNameErrMsg(message) {
    $('#name-err-msg').html(message);
    hideNameErrMsg('block');
}

function hideNameErrMsg(style) {
    $('#name-err-msg').css('display', style);
}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function () {
        $("#success-alert").slideUp(500);
    });
}