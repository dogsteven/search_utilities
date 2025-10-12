package com.foxsteven.search_utilities.searching.expressions;

public record ExistencePrimitive(String field) implements Expression {
    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visitExistencePrimitive(this);
    }
}
