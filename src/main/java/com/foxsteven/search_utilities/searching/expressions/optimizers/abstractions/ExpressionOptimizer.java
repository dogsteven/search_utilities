package com.foxsteven.search_utilities.searching.expressions.optimizers.abstractions;

import com.foxsteven.search_utilities.searching.expressions.Expression;

public interface ExpressionOptimizer {
    Expression optimize(Expression expression);
}
