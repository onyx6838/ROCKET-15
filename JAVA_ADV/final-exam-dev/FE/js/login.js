$(function () {
    $('#rememberMe').prop('checked', storage.getRememberMe());
});

function login() {
    var username = $('#username').val();
    var password = $('#password').val();

    // validate
    if (!username) {
        showNameErrMsg("Please input username!");
        return;
    }

    if (!password) {
        showNameErrMsg("Please input password!");
        return;
    }

    if (username.length < 6 || username.length > 50 || password.length < 6 || password.length > 50) {
        // show error message
        showNameErrMsg("Login fail!");
        return;
    }

    $.ajax({
        url: 'http://localhost:8080/api/v1/login',
        type: 'POST',
        data: {
            username: username,
            password: password
        }
    }).done(function (data, status, xhr) {
        console.log(data);
        var isRememberMe = $('#rememberMe').prop('checked');
        storage.saveRememberMe(isRememberMe);
        storage.setItem("ID", data.id);
        storage.setItem("FULL_NAME", data.fullName);
        //storage.setItem("USERNAME", username);
        //storage.setItem("PASSWORD", password);
        storage.setItem("ROLE", data.role);
        storage.setItem("TOKEN", data.jwt);
        window.location.replace("http://127.0.0.1:5501/html/index.html");
    }).fail(function (jqXHR, textStatus, errorThrown) {
        if (jqXHR.status == 401) {
            showNameErrMsg("Login fail!");
        } else {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    })

    // Call API
    // $.ajax({
    //     url: 'http://localhost:8080/api/v1/login',
    //     type: 'GET',
    //     contentType: "application/json",
    //     dataType: 'json', // datatype return
    //     beforeSend: function (xhr) {
    //         xhr.setRequestHeader("Authorization", "Basic " + btoa(username + ":" + password));
    //     },
    //     success: function (data, textStatus, xhr) {
    //         var isRememberMe = $('#rememberMe').prop('checked');
    //         storage.saveRememberMe(isRememberMe);
    //         storage.setItem("ID", data.id);
    //         storage.setItem("FULL_NAME", data.name);
    //         storage.setItem("USERNAME", username);
    //         storage.setItem("PASSWORD", password);
    //         storage.setItem("ROLE", data.role);
    //         var myHeader = XMLHttpRequest.getResponseHeader(headerName);
    //         // redirect to home page
    //        window.location.replace("http://127.0.0.1:5501/html/index.html");

    //     },
    //     error(jqXHR, textStatus, errorThrown) {
    //         if (jqXHR.status == 401) {
    //             showNameErrMsg("Login fail!");
    //         } else {
    //             console.log(jqXHR);
    //             console.log(textStatus);
    //             console.log(errorThrown);
    //         }
    //     }
    // });
}

function showNameErrMsg(message) {
    $('#name-err-msg').html(message);
    hideNameErrMsg('block');
}

function hideNameErrMsg(style) {
    $('#name-err-msg').css('display', style);
}

function handKeyUpEventForLogin(event) {
    if (event.keyCode === 13) {
        event.preventDefault();
    }
}