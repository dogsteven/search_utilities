package com.foxsteven.search_utilities.searching.elasticsearch.query_builders.abstractions;

import co.elastic.clients.elasticsearch._types.query_dsl.Query;

public interface StringBasedQueryBuilder {
    Query build(String queryString);
}
