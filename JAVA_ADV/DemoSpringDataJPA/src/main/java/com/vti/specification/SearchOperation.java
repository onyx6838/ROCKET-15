package com.vti.specification;

public enum SearchOperation {
	EQUALITY, NEGATION, GREATER_THAN, GREATER_THAN_OR_EQUAL, LESS_THAN, LESS_THAN_OR_EQUAL, LIKE, STARTS_WITH,
	ENDS_WITH, CONTAINS;

	public static SearchOperation getSimpleOperation(final String input) {
		if ("=".equals(input)) {
			return EQUALITY;

		} else if ("!=".equals(input)) {
			return NEGATION;

		} else if (">".equals(input)) {
			return GREATER_THAN;

		} else if (">=".equals(input)) {
			return GREATER_THAN_OR_EQUAL;

		} else if ("<".equals(input)) {
			return LESS_THAN;

		} else if ("<=".equals(input)) {
			return LESS_THAN_OR_EQUAL;

		} else if ("~".equals(input)) {
			return LIKE;

		}
		return null;
	}
}
