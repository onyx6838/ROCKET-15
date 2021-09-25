var ajaxCallParams = {};
var ajaxDataParams = {};

// General function for all ajax calls
function ajaxCall(callParams, dataParams, callback) {   
    $.ajax({
        type: callParams.Type,
        url: callParams.Url,
        quietMillis: 100,
        dataType: callParams.DataType,
        data: dataParams,
        cache: true,
        success: function (response) {
            callback(response);
        },
        error: function (response) {
            callback(response);
        }
    });
}

// ajaxCallParams.Type = "POST"; // POST type function 
    // ajaxCallParams.Url = "/Payment/Create"; // Pass Complete end point Url e-g Payment Controller, Create Action
    // ajaxCallParams.DataType = "JSON"; // Return data type e-g Html, Json etc

    // // Set Data parameters 
    // ajaxDataParams.Id = 1;
    // ajaxDataParams.Name = "Shujat Munawar";

    // ajaxCall(ajaxCallParams, ajaxDataParams, function (result) {
    //     console.log(result);
    // });