$.ajax({
    url: 'createUser',
    type: 'POST',
    success: function (data, textStatus, xhr) {
        $.ajax({
            url: 'createGr',
            type: 'POST',
            success: function (data, textStatus, xhr) {
                console.log("end");
            },
            error(jqXHR, textStatus, errorThrown) {
                console.log("end");
            }
        });
    },
    error(jqXHR, textStatus, errorThrown) {
        console.log("end");
    }
});