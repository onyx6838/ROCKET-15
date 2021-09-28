$(function () {
    /**
     * regex validator
     */
    $.validator.addMethod(
        "regex",
        function (value, element, regexp) {
            var re = new RegExp(regexp);
            return this.optional(element) || re.test(value);
        },
        "Please check your input."
    );
    /**
     * date validator
     */
    $.validator.addMethod("dateRange", function (value, element, params) {
        try {
            var date = new Date(value);
            if (date >= params.from && date <= params.to) {
                return true;
            }
        } catch (e) {}
        return false;
    }, 'message');
    // setup date
    var fromDate = new Date().toLocaleDateString('en-CA');
    var toDate = new Date("2000-12-31");
    // add rule with 2 condition
    $.validator.addClassRules({
        myDateFieldRangeValidate: {
            dateRange: {
                from: fromDate,
                to: toDate
            }
        }
    });
    /**
     * unique ajax validator
     */
    $.validator.addMethod(
        "uniqueName",
        function (value, element) {
            var response = false;
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/api/v1/departments/name/" + value + "/exists",
                // dataType: "html",
                success: function (msg) {
                    console.log("msg" + typeof msg);
                    //If username exists, set response to true
                    response = (msg == true) ? true : false;
                }
            });
            console.log("res" + response);
            return response;
        },
        "Name Already Taken"
    );
    /**
     * member validator
     */
});