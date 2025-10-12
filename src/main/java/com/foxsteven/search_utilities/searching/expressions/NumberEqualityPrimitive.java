package com.foxsteven.search_utilities.searching.expressions;

public record NumberEqualityPrimitive(String field, double value) implements Expression {
    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visitNumberEqualityPrimitive(this);
    }
}
