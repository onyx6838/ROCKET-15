package com.vti.specification.custom.parse;

import com.vti.specification.custom.entity.SearchCriteria;
import com.vti.specification.custom.entity.SearchSection;
import com.vti.specification.custom.misc.SpecificationUtils;
import lombok.var;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BaseParseCommand implements ParseCommand {

    private final Pattern pattern;

    BaseParseCommand(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public List<SearchCriteria> parse(String[] search, boolean isOrPredicate) {
        var listOfResults = new ArrayList<SearchCriteria>();
        for (var s : search) {
            var matcher = pattern.matcher(s);
            if (matcher.matches()) {
                var section = process(matcher);
                section.setOrPredicate(isOrPredicate);
                listOfResults.add(buildCriteriaFromSection(section));
            }
        }
        return listOfResults;
    }

    private SearchCriteria buildCriteriaFromSection(SearchSection searchSection) {
        var searchOperation = SpecificationUtils.resolveSearchOperation(searchSection);
        return new SearchCriteria(searchSection.isOrPredicate(),
                searchSection.getKey(),
                searchOperation,
                searchSection.getValue());
    }

    protected abstract SearchSection process(Matcher matcher);

}
