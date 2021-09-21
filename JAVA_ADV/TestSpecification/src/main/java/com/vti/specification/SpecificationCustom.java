package com.vti.specification;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class SpecificationCustom<T> implements Specification<T> {
	private static final long serialVersionUID = 1L;
	private SearchCriteria criteria;

	public SpecificationCustom(SearchCriteria criteria) {
		this.criteria = criteria;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if (criteria.getOperator().equalsIgnoreCase("~")) {
			return criteriaBuilder.like(parseAttribute(criteria.getKey(), root), criteria.getValue().toString());
		}
		if (criteria.getOperator().equalsIgnoreCase(">")) {
			if (criteria.getValue() instanceof Date) {
				Date date = (Date) criteria.getValue();
				// check datetime search data type
				if (!isDateTimeDatatype(date)) {
					date.setTime(date.getTime() + (long) 1000 * 60 * 60 * 24);
				}

				return criteriaBuilder.greaterThanOrEqualTo(parseAttribute(criteria.getKey(), root), date);
			}
			return criteriaBuilder.greaterThan(parseAttribute(criteria.getKey(), root), criteria.getValue().toString());
		}

		if (criteria.getOperator().equalsIgnoreCase(">=")) {
			if (criteria.getValue() instanceof Date) {
				return criteriaBuilder.greaterThanOrEqualTo(parseAttribute(criteria.getKey(), root), (Date) criteria.getValue());
			}
			return criteriaBuilder.greaterThanOrEqualTo(parseAttribute(criteria.getKey(), root), criteria.getValue().toString());
		}

		if (criteria.getOperator().equalsIgnoreCase("<")) {
			if (criteria.getValue() instanceof Date) {
				return criteriaBuilder.lessThan(parseAttribute(criteria.getKey(), root), (Date) criteria.getValue());
			}
			return criteriaBuilder.lessThan(parseAttribute(criteria.getKey(), root), criteria.getValue().toString());
		}

		if (criteria.getOperator().equalsIgnoreCase("<=")) {
			if (criteria.getValue() instanceof Date) {
				Date date = (Date) criteria.getValue();
				if (!isDateTimeDatatype(date)) {
					date = getLastTimeOfDay(date);
				}

				date = getLastTimeOfDay(date);
				return criteriaBuilder.lessThanOrEqualTo(parseAttribute(criteria.getKey(), root), date);
			}
			return criteriaBuilder.lessThanOrEqualTo(parseAttribute(criteria.getKey(), root), criteria.getValue().toString());
		}

		if (criteria.getOperator().equalsIgnoreCase("=")) {
			if (criteria.getValue() instanceof Date) {
				Date date = (Date) criteria.getValue();
				if (isDateTimeDatatype(date)) {
					return criteriaBuilder.equal(parseAttribute(criteria.getKey(), root), date);
				} else {
					return criteriaBuilder.equal(parseAttribute(criteria.getKey(), root).as(java.sql.Date.class), date);
				}
			}
			Path field = parseAttribute(criteria.getKey(), root);
			// enum type check
			if (field.getJavaType().isEnum()) {
				return criteriaBuilder.equal(field, Enum.valueOf(field.getJavaType(), criteria.getValue().toString()));
			}
			return criteriaBuilder.equal(parseAttribute(criteria.getKey(), root), criteria.getValue().toString());
		}

		if (criteria.getOperator().equalsIgnoreCase("!=")) {
			if (criteria.getValue() instanceof Date) {
				Date date = (Date) criteria.getValue();
				if (isDateTimeDatatype(date)) {
					return criteriaBuilder.equal(parseAttribute(criteria.getKey(), root), date);
				}
				return criteriaBuilder.equal(parseAttribute(criteria.getKey(), root).as(java.sql.Date.class), date);
			}

			Path field = parseAttribute(criteria.getKey(), root);
			// enum type check
			if (field.getJavaType().isEnum()) {
				return criteriaBuilder.notEqual(field,
						Enum.valueOf(field.getJavaType(), criteria.getValue().toString()));
			}
			return criteriaBuilder.notEqual(parseAttribute(criteria.getKey(), root), criteria.getValue().toString());
		}

		return null;
	}

	@SuppressWarnings("rawtypes")
	private Path parseAttribute(String nameField, Root<T> root) {
		// nameField = department.id
		String[] fields = nameField.split("\\.");

		Path path = root.get(fields[0]);

		for (int i = 1; i < fields.length; i++) {
			path = path.get(fields[i]);
		}
		return path;
	}

	@SuppressWarnings("deprecation")
	private Date getLastTimeOfDay(Date date) {
		date.setHours(23);
		date.setMinutes(59);
		date.setSeconds(59);
		return date;
	}

	@SuppressWarnings("deprecation")
	private boolean isDateTimeDatatype(Date date) {
		if (date.getHours() != 0 || date.getMinutes() != 0 || date.getSeconds() != 0) {
			return true;
		}
		return false;
	}
}