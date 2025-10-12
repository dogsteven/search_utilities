package com.foxsteven.search_utilities.searching.expressions;

import java.time.LocalDateTime;

public record LocalDateTimeComparisonPrimitive(String field, ComparisonOperator operator, LocalDateTime value) implements Expression  {
    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visitLocalDateTimeComparisonPrimitive(this);
    }
}

