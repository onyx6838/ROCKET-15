package com.vti.testing.specification;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.jpa.domain.Specification;

import com.vti.testing.Application;
import com.vti.testing.config.resourceproperties.searchparameter.OperatorProperty;

/**
 * This class is generic of Specification Builder.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 12, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 12, 2020
 * @param <T>
 */
public class GenericSpecificationsBuilder<T> {

	private OperatorProperty operatorProperty;

	/**
	 * Constructor for class GenericSpecificationsBuilder.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 27, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 27, 2020
	 */
	public GenericSpecificationsBuilder() {
		operatorProperty = Application.getBean(OperatorProperty.class);
	}

	/**
	 * This method is converted to Specification.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 13, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 13, 2020
	 * @param criteriaExpressionStack
	 * @param converter
	 * @return
	 */
	public Specification<T> build(Deque<?> criteriaExpressionStack,
			Function<SearchCriteria, Specification<T>> converter) {

		Deque<Specification<T>> specificationStack = new LinkedList<>();

		Collections.reverse((List<?>) criteriaExpressionStack);

		while (!criteriaExpressionStack.isEmpty()) {
			Object mayBeOperand = criteriaExpressionStack.pop();

			if (!(mayBeOperand instanceof String)) {
				specificationStack.push(converter.apply((SearchCriteria) mayBeOperand));

			} else {
				Specification<T> operand1 = specificationStack.pop();
				Specification<T> operand2 = specificationStack.pop();
				if (mayBeOperand.equals(operatorProperty.getAnd()))
					specificationStack.push(Specification.where(operand1).and(operand2));

				else if (mayBeOperand.equals(operatorProperty.getOr()))
					specificationStack.push(Specification.where(operand1).or(operand2));
			}
		}

		return specificationStack.pop();
	}

}
