package com.foxsteven.search_utilities.searching.expressions;

import java.time.OffsetDateTime;

public record OffsetDateTimeComparisonPrimitive(String field, ComparisonOperator operator, OffsetDateTime value) implements Expression {
    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visitOffsetDateTimeComparisonPrimitive(this);
    }
}
