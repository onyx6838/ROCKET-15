package com.vti.specification.custom.predicatebuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msampietro.springspecquerylanguage.misc.SpecificationUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;

public class EqualityPredicate<T> extends BasePredicate<T> {

    public EqualityPredicate(ObjectMapper objectMapper, Class<? extends Serializable> idClazz) {
        super(objectMapper, idClazz);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        var searchValue = getCriteriaObjectValue().toString();
        if (SpecificationUtils.isValueNullKey(searchValue))
            return builder.isNull(getCriteriaStringExpressionKey(root));
        return builder.equal(getCriteriaStringExpressionKey(root), parseValue(searchValue, builder));
    }
}
