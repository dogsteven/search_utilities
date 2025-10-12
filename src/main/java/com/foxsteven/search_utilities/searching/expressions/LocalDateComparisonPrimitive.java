package com.foxsteven.search_utilities.searching.expressions;

import java.time.LocalDate;

public record LocalDateComparisonPrimitive(String field, ComparisonOperator operator, LocalDate value) implements Expression  {
    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visitLocalDateComparisonPrimitive(this);
    }
}
