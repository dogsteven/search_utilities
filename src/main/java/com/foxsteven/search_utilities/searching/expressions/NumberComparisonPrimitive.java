package com.foxsteven.search_utilities.searching.expressions;

public record NumberComparisonPrimitive(String field, ComparisonOperator operator, double value) implements Expression {
    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visitNumberComparisonPrimitive(this);
    }
}
