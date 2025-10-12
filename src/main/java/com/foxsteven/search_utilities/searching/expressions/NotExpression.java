package com.foxsteven.search_utilities.searching.expressions;

public record NotExpression(Expression innerExpression) implements Expression {
    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visitNotExpression(this);
    }
}
