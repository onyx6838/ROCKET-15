package com.vti.testing.specification;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

/**
 * This class is Testing Category Specification.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 12, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 12, 2020
 */
@SuppressWarnings("serial")
public class GenericSpecification<T> implements Specification<T> {

	private SearchCriteria criteria;

	/**
	 * Constructor for class TestingCategorySpecification.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 12, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 12, 2020
	 * @param criteria
	 */
	public GenericSpecification(SearchCriteria criteria) {
		this.criteria = criteria;
	}

	/**
	 * This method is checked date is date or datetime.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 14, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 14, 2020
	 * @param date
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private boolean isDateTimeDatatype(Date date) {
		if (date.getHours() != 0 || date.getMinutes() != 0 || date.getSeconds() != 0) {
			return true;
		}
		return false;
	}

	/*
	 * @see org.springframework.data.jpa.domain.Specification#toPredicate(javax.
	 * persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery,
	 * javax.persistence.criteria.CriteriaBuilder)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

		switch (criteria.getOperation()) {
		case EQUALITY:
			if (criteria.getValue() instanceof Date) {
				Date date = (Date) criteria.getValue();

				if (isDateTimeDatatype(date)) {
					return builder.equal(getKey(root), date);
				} else {
					return builder.equal(getKey(root).as(java.sql.Date.class), date);
				}
			} else {
				Path key = getKey(root);
				// check attribute is enum
				if (!isEnumType(key)) {
					return builder.equal(key, criteria.getValue());
				} else {
					return builder.equal(key, Enum.valueOf(getKey(root).getJavaType(), criteria.getValue().toString()));
				}
			}

		case NEGATION:
			if (criteria.getValue() instanceof Date) {
				Date date = (Date) criteria.getValue();

				if (isDateTimeDatatype(date)) {
					return builder.notEqual(getKey(root), date);
				} else {
					return builder.notEqual(getKey(root).as(java.sql.Date.class), date);
				}
			} else {
				Path key = getKey(root);
				// check attribute is enum
				if (!isEnumType(key)) {
					return builder.notEqual(key, criteria.getValue());
				} else {
					return builder.notEqual(key, Enum.valueOf(getKey(root).getJavaType(), criteria.getValue().toString()));
				}
			}

		case GREATER_THAN:
			if (criteria.getValue() instanceof Date) {
				return builder.greaterThan(getKey(root), (Date) criteria.getValue());
			} else {
				return builder.greaterThan(getKey(root), criteria.getValue().toString());
			}

		case GREATER_THAN_OR_EQUAL:
			if (criteria.getValue() instanceof Date) {
				return builder.greaterThanOrEqualTo(getKey(root), (Date) criteria.getValue());
			} else {
				return builder.greaterThanOrEqualTo(getKey(root), criteria.getValue().toString());
			}

		case LESS_THAN:
			if (criteria.getValue() instanceof Date) {
				return builder.lessThan(getKey(root), (Date) criteria.getValue());
			} else {
				return builder.lessThan(getKey(root), criteria.getValue().toString());
			}

		case LESS_THAN_OR_EQUAL:
			if (criteria.getValue() instanceof Date) {
				return builder.lessThanOrEqualTo(getKey(root), (Date) criteria.getValue());
			} else {
				return builder.lessThanOrEqualTo(getKey(root), criteria.getValue().toString());
			}

		case LIKE:
			return builder.like(getKey(root), criteria.getValue().toString());

		case STARTS_WITH:
			return builder.like(getKey(root), criteria.getValue() + "%");

		case ENDS_WITH:
			return builder.like(getKey(root), "%" + criteria.getValue());

		case CONTAINS:
			return builder.like(getKey(root), "%" + criteria.getValue() + "%");

		default:
			return null;
		}
	}

	/**
	 * This method is checked Enum Type.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 28, 2020
	 * @param key
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private boolean isEnumType(Path key) {
		return key.getJavaType().isEnum() ? true : false;
	}

	/**
	 * This method is getted key from criteria.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 13, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 13, 2020
	 * @param root
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Path getKey(Root root) {
		Path keys = getRootJoin(root, criteria.getKeys().get(0));
		if (criteria.getKeys().size() > 1) {
			for (int i = 1; i < criteria.getKeys().size(); i++) {
				keys = keys.get(criteria.getKeys().get(i));
			}
		}
		return keys;
	}

	/**
	 * if key is collection then joining else then get
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 13, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 13, 2020
	 * @param root
	 * @param key
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Path getRootJoin(Root root, String key) {
		// if key is List
		if (key.endsWith("Collection")) {
			return root.join(key);
		}

		// else key is attribute
		return root.get(criteria.getKeys().get(0));
	}
}
