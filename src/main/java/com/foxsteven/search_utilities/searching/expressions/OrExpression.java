package com.foxsteven.search_utilities.searching.expressions;

import java.util.List;

public record OrExpression(List<Expression> subExpressions) implements Expression {
    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visitOrExpression(this);
    }
}
