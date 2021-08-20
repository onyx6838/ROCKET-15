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
    $(".main").load("home.html")
}

/**
 * load view list page
 */
function loadListPage() {
    $(".main").load("table-employee.html");
    buildTable();
}

