package com.vti.specification;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import com.vti.utils.Config;
import com.vti.utils.Utils;

public class SpecificationBuilder<T> {

	private List<SearchCriteria> searchCriterias;

	public SpecificationBuilder(String search) throws ParseException {
		searchCriterias = new ArrayList<>();
		parseRegex(search);
	}

	// builder pattern
	private SpecificationBuilder<T> with(String key, String operator, Object value, boolean isOrPredicate) {
		searchCriterias.add(new SearchCriteria(key, operator, value, isOrPredicate));
		return this;
	}

	@SuppressWarnings("unused")
	private SpecificationBuilder<T> with(SearchCriteria criteria) {
		searchCriterias.add(criteria);
		return this;
	}

	private void parseRegex(String search) throws ParseException {
		if (ObjectUtils.isEmpty(search)) {
			return;
		}

		Pattern pattern = Pattern.compile(Config.REGEX_SEARCH);
		Matcher matcher = pattern.matcher(search);

		while (matcher.find()) {
			// TODO LIKE, DATE, ENUM
			// TODO AND OR()
			String key = matcher.group(1);
			String operator = matcher.group(2);
			String value = matcher.group(4);

			// handling LIKE operator
			String prefixWildcard = matcher.group(3);

			if (!ObjectUtils.isEmpty(prefixWildcard) && operator.equals("~")) {
				value = "%" + value;
			}

			String endfixWildcard = matcher.group(5);
			if (!ObjectUtils.isEmpty(endfixWildcard) && operator.equals("~")) {
				value = value + "%";
			}
			// date time parse handling
			if (Utils.isMatchRegex(value, Config.REGEX_DATE_VALUE)) {
				//Date convert = (Date) Utils.convertStringToDateObject(value, Config.DATE_PATTERN);
				with(key, operator, Utils.convertStringToDateObject(value, Config.DATE_PATTERN), false);
			} else if (Utils.isMatchRegex(value, Config.REGEX_DATE_TIME_VALUE)) {
				with(key, operator, Utils.convertStringToDateObject(value, Config.DATE_TIME_PATTERN), false);
			} else {
				with(key, operator, value, false);
			}
		}
	}

	public Specification<T> build() {
		if (searchCriterias.size() == 0) {
			return null;
		}
		Specification<T> specification = new SpecificationCustom<T>(searchCriterias.get(0));

		for (int i = 1; i < searchCriterias.size(); i++) {
			specification = searchCriterias.get(i).isOrPredicate()
					? Specification.where(specification).or(new SpecificationCustom<T>(searchCriterias.get(i)))
					: Specification.where(specification).and(new SpecificationCustom<T>(searchCriterias.get(i)));
		}
		return specification;
	}

}