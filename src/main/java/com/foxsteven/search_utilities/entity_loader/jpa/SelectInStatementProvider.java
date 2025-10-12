package com.foxsteven.search_utilities.entity_loader.jpa;

import com.foxsteven.search_utilities.entity_loader.abstractions.StringIdentifiable;

import java.util.List;

public interface SelectInStatementProvider {
    <T extends StringIdentifiable> String provideSelectInStatement(List<String> identifiers, Class<T> entityClass);
}
