package com.foxsteven.search_utilities.searching.expressions.transformers.abstractions;

import com.foxsteven.search_utilities.searching.expressions.Expression;

public interface ExpressionTransformer {
    Expression transform(Expression expression);
}
