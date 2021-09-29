$(function () {
    /**
     * regex validator (input type text)
     */
    $.validator.addMethod(
        "regex",
        function (value, element, regexp) {
            var re = new XRegExp(regexp);
            return this.optional(element) || re.test(value);
        },
        "Please check your input."
    );
    /**
     * date validator (input type text)
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
     * unique ajax validator (data table)
     */
    $.validator.addMethod(
        "uniqueName",
        function (value, element) {
            var result;
            //console.log("rs " + result + value);
            $.ajax({
                type: "GET",
                url: 'http://localhost:8080/api/v1/departments/name/' + value + '/exists',
                async: false,
                success: function (msg) {
                    result = (msg == true) ? false : true;
                }
            });
            //console.log("rs after " + result + value);
            return result;
        },
        "Username Already Exists.");

    $.validator.addClassRules("unique", {
        uniqueName: true
    });
});