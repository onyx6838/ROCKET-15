package com.vti.testing.specification;

import java.text.ParseException;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.ImmutableMap;
import com.vti.testing.Application;
import com.vti.testing.config.resourceproperties.searchparameter.GroupPatternProperty;
import com.vti.testing.config.resourceproperties.searchparameter.OperatorProperty;

/**
 * This class is used for parsing criteria from search String.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 12, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 12, 2020
 */
public class CriteriaParser {

	private GroupPatternProperty groupPatternProperty;

	private OperatorProperty operatorProperty;

	private static final Map<String, Operator> OPERATOR_MAPS = ImmutableMap.of("AND", Operator.AND, "OR", Operator.OR,
			"or", Operator.OR, "and", Operator.AND);

	public static final Map<String, Operator> OPERATORS = Collections.unmodifiableMap(OPERATOR_MAPS);

	private final Pattern criteriaRegex;

	private enum Operator {
		OR(1), AND(2);

		final int priority;

		Operator(int priority) {
			this.priority = priority;
		}
	}

	/**
	 * Constructor for class CriteriaParser.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 13, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 13, 2020
	 */
	public CriteriaParser() {
		groupPatternProperty = Application.getBean(GroupPatternProperty.class);
		operatorProperty = Application.getBean(OperatorProperty.class);

		criteriaRegex = Pattern.compile(groupPatternProperty.getCriteraRegex());
	}

	/**
	 * This method is checked priority of operator.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 13, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 13, 2020
	 * @param currentOperator
	 * @param prevOperator
	 * @return
	 */
	private boolean isHigerPriorityOperator(String currentOperator, String prevOperator) {
		return (OPERATORS.containsKey(prevOperator)
				&& OPERATORS.get(prevOperator).priority >= OPERATORS.get(currentOperator).priority);
	}

	/**
	 * This method is used for parsing criteria and operator (AND or OR).
	 * 
	 * @Description: split into tokens (criteria, parenthesis, AND & OR operators).
	 * @author: NNDuy
	 * @create_date: Mar 12, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 12, 2020
	 * @param search
	 * @return
	 */
	public Deque<?> parseToCriteria(String search) throws ParseException {

		Deque<Object> output = new LinkedList<>();
		Deque<String> stack = new LinkedList<>();

		// \\s - matches single whitespace character.
		// \\s+ - matches sequence of one or more whitespace characters
		String[] tokens = search.split("\\s+");
		for (String token : tokens) {
			if (OPERATORS.containsKey(token)) {
				while (!stack.isEmpty() && isHigerPriorityOperator(token, stack.peek()))
					output.push(stack.pop().equalsIgnoreCase(operatorProperty.getOr()) ? operatorProperty.getOr()
							: operatorProperty.getAnd());
				stack.push(token.equalsIgnoreCase(operatorProperty.getOr()) ? operatorProperty.getOr()
						: operatorProperty.getAnd());

			} else if (token.equals(operatorProperty.getLeftParanthesis())) {
				stack.push(operatorProperty.getLeftParanthesis());

			} else if (token.equals(operatorProperty.getRightParanthesis())) {
				while (!stack.peek().equals(operatorProperty.getLeftParanthesis()))
					output.push(stack.pop());
				stack.pop();

			} else {
				Matcher matcher = criteriaRegex.matcher(token);
				while (matcher.find()) {
					output.push(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3),
							matcher.group(4), matcher.group(5)));
				}
			}
		}

		while (!stack.isEmpty())
			output.push(stack.pop());

		return output;
	}

}
