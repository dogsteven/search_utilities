package com.foxsteven.search_utilities.searching.elasticsearch.translators.abstractions;

import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import com.foxsteven.search_utilities.searching.expressions.Expression;

public interface ExpressionToQueryTranslator {
    Query translate(Expression expression);
}
