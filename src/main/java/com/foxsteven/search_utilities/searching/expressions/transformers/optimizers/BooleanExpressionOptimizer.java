package com.foxsteven.search_utilities.searching.expressions.transformers.optimizers;

import com.foxsteven.search_utilities.searching.expressions.*;
import com.foxsteven.search_utilities.searching.expressions.transformers.abstractions.ExpressionTransformer;

public abstract class BooleanExpressionOptimizer implements ExpressionTransformer, ExpressionVisitor<Expression> {
    @Override
    public Expression transform(Expression expression) {
        return expression.accept(this);
    }

    @Override
    public Expression visitExistencePrimitive(ExistencePrimitive expression) {
        return expression;
    }

    @Override
    public Expression visitBooleanEqualityPrimitive(BooleanEqualityPrimitive expression) {
        return expression;
    }

    @Override
    public Expression visitNumberEqualityPrimitive(NumberEqualityPrimitive expression) {
        return expression;
    }

    @Override
    public Expression visitTextEqualityPrimitive(TextEqualityPrimitive expression) {
        return expression;
    }

    @Override
    public Expression visitNumberComparisonPrimitive(NumberComparisonPrimitive expression) {
        return expression;
    }

    @Override
    public Expression visitLocalDateComparisonPrimitive(LocalDateComparisonPrimitive expression) {
        return expression;
    }

    @Override
    public Expression visitLocalDateTimeComparisonPrimitive(LocalDateTimeComparisonPrimitive expression) {
        return expression;
    }

    @Override
    public Expression visitOffsetDateTimeComparisonPrimitive(OffsetDateTimeComparisonPrimitive expression) {
        return expression;
    }

    @Override
    public Expression visitTextContainmentPrimitive(TextContainmentPrimitive expression) {
        return expression;
    }

    @Override
    public Expression visitTextPrefixPrimitive(TextPrefixPrimitive expression) {
        return expression;
    }

    @Override
    public Expression visitTextSuffixPrimitive(TextSuffixPrimitive expression) {
        return expression;
    }

    @Override
    public Expression visitWildcardPrimitive(WildcardPrimitive expression) {
        return expression;
    }
}
