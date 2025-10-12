package com.foxsteven.search_utilities.searching.expressions;

import java.util.List;

public record AndExpression(List<Expression> subExpressions) implements Expression {

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visitAndExpression(this);
    }
}
