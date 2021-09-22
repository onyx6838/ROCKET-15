package com.vti.specification.custom.predicatebuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;

public class CollectionContainsPredicate<T> extends BasePredicate<T> {

    public CollectionContainsPredicate(ObjectMapper objectMapper, Class<? extends Serializable> idClazz) {
        super(objectMapper, idClazz);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return builder.equal(getCriteriaExpressionJoinKey(root), parseValue(getCriteriaObjectValue().toString(), builder));
    }

}
