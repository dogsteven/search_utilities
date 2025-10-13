package com.foxsteven.search_utilities.searching.elasticsearch.query_builders;

import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import com.foxsteven.search_utilities.searching.elasticsearch.query_builders.abstractions.StringBasedQueryBuilder;
import com.foxsteven.search_utilities.searching.elasticsearch.translators.abstractions.ExpressionToQueryTranslator;
import com.foxsteven.search_utilities.searching.expressions.builders.abstractions.StringBasedExpressionBuilder;
import com.foxsteven.search_utilities.searching.expressions.transformers.abstractions.ExpressionTransformer;

public class CommonQueryBuilder implements StringBasedQueryBuilder {
    private final StringBasedExpressionBuilder expressionBuilder;

    private final ExpressionTransformer expressionTransformer;

    private final ExpressionToQueryTranslator expressionToQueryTranslator;

    public CommonQueryBuilder(StringBasedExpressionBuilder expressionBuilder,
                              ExpressionTransformer expressionTransformer,
                              ExpressionToQueryTranslator expressionToQueryTranslator) {
        this.expressionBuilder = expressionBuilder;
        this.expressionTransformer = expressionTransformer;
        this.expressionToQueryTranslator = expressionToQueryTranslator;
    }

    @Override
    public Query build(String queryString) {
        final var expression = expressionBuilder.build(queryString);

        final var transformedExpression = expressionTransformer.transform(expression);

        return expressionToQueryTranslator.translate(transformedExpression);
    }
}
