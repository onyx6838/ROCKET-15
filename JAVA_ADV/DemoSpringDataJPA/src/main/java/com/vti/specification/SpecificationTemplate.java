package com.vti.specification;

import java.text.ParseException;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

/**
 * This class is Building Specification Template.
 */
public class SpecificationTemplate {
	/**
	 * This method is handle Specification.
	 * @param search
	 * @return
	 * @throws ParseException
	 */
	public static <T> Specification<T> buildSpecification(String search) throws ParseException {
		if (StringUtils.isEmpty(search)) {
			return null;
		}

		return new GenericSpecificationsBuilder<T>().build(new CriteriaParser().parseToCriteria(search),
				GenericSpecification<T>::new);
	}
}
