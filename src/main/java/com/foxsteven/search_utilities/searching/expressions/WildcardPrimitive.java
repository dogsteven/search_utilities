package com.foxsteven.search_utilities.searching.expressions;

public record WildcardPrimitive(String field, String value, boolean isCaseInsensitive) implements Expression {
    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visitWildcardPrimitive(this);
    }
}
