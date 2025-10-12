package com.foxsteven.search_utilities.searching.expressions;

public record BooleanEqualityPrimitive(String field, boolean value) implements Expression {
    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visitBooleanEqualityPrimitive(this);
    }
}
