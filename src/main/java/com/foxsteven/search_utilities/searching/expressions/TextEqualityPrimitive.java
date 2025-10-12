package com.foxsteven.search_utilities.searching.expressions;

public record TextEqualityPrimitive(String field, String value) implements Expression {
    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visitTextEqualityPrimitive(this);
    }
}
