$(function () {
	/**
	 * Build Validator
	 */
	$("#newModalForm").validate({
		rules: {
			name: {
				required: true,
				minlength: 3,
				maxlength: 50,
				//checkDate: true,
				//regex: "[\p{L}\p{N}]"
				//regex: "^[a-zA-Z0-9]$",
				uniqueName: true
			},
			createdDate: {
				regex: "d{4}-d{1,2}-d{1,2}",
				dateRange: true
			}
		},
		messages: {
			name: {
				required: "Please enter some data",
				minlength: "Your data must be at least 6 characters",
				maxlength: "max 50 characters"
				//checkDate: "greater 2000 and < now",
				//regex: "no special characters"
			},
			createdDate: {
				regex: "format yyyy-mm-dd",
				dateRange: "between"
			}
		}
	});
});