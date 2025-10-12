package com.foxsteven.search_utilities.entity_loader.abstractions;

import java.util.List;

public interface StringIdentifiableEntityLoader {
    <T extends StringIdentifiable> List<T> load(List<String> identifiers, Class<T> entityClass);
}
