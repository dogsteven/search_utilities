package com.foxsteven.search_utilities.searching.elasticsearch.query_builders;

import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import com.foxsteven.search_utilities.searching.elasticsearch.query_builders.abstractions.StringBasedQueryBuilder;
import com.foxsteven.search_utilities.searching.elasticsearch.translators.abstractions.ExpressionToQueryTranslator;
import com.foxsteven.search_utilities.searching.expressions.builders.abstractions.StringBasedExpressionBuilder;
import com.foxsteven.search_utilities.searching.expressions.optimizers.abstractions.ExpressionOptimizer;

public class FqlQueryBuilder implements StringBasedQueryBuilder {
    private final StringBasedExpressionBuilder expressionBuilder;

    private final ExpressionOptimizer expressionOptimizer;

    private final ExpressionToQueryTranslator expressionToQueryTranslator;

    private boolean isOptimizerEnabled;

    public FqlQueryBuilder(StringBasedExpressionBuilder expressionBuilder,
                           ExpressionOptimizer expressionOptimizer,
                           ExpressionToQueryTranslator expressionToQueryTranslator) {
        this.expressionBuilder = expressionBuilder;
        this.expressionOptimizer = expressionOptimizer;
        this.expressionToQueryTranslator = expressionToQueryTranslator;
        this.isOptimizerEnabled = true;
    }

    public void enableOptimizer() {
        this.isOptimizerEnabled = true;
    }

    public void disableOptimizer() {
        this.isOptimizerEnabled = false;
    }

    @Override
    public Query build(String queryString) {
        final var expression = expressionBuilder.build(queryString);

        if (isOptimizerEnabled) {
            final var optimizedExpression = expressionOptimizer.optimize(expression);

            return expressionToQueryTranslator.translate(optimizedExpression);
        } else {
            return expressionToQueryTranslator.translate(expression);
        }
    }
}
