package com.foxsteven.search_utilities.searching.expressions.builders.abstractions;

import com.foxsteven.search_utilities.searching.expressions.Expression;

public interface StringBasedExpressionBuilder {
    Expression build(String expressionString);
}
