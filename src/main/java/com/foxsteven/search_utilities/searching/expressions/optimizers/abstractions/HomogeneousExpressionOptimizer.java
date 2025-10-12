package com.foxsteven.search_utilities.searching.expressions.optimizers.abstractions;

import com.foxsteven.search_utilities.searching.expressions.*;

public abstract class HomogeneousExpressionOptimizer implements ExpressionOptimizer, ExpressionVisitor<Expression> {
    @Override
    public Expression optimize(Expression expression) {
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
    public Expression visitWildcardPrimitive(WildcardPrimitive expression) {
        return expression;
    }
}
