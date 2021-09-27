package com.vti.testing.specification;

import java.text.ParseException;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

/**
 * This class is Building Specification Template.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 16, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 16, 2020
 */
public class SpecificationTemplate {
	/**
	 * This method is handle Specification.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 12, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 12, 2020
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
