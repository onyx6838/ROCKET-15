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
				//regex: "\\p{L}+.*\\p{L}+"
				//utf: false
				uniqueName: true
			}
		},
		messages: {
			name: {
				required: "Please enter some data",
				minlength: "Your data must be at least 6 characters",
				maxlength: "data 50 characters maximum",
				//regex: "no special characters"
			}
		}
	});
});