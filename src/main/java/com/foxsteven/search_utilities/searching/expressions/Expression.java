package com.foxsteven.search_utilities.searching.expressions;

public interface Expression {
    <T> T accept(ExpressionVisitor<T> visitor);
}
