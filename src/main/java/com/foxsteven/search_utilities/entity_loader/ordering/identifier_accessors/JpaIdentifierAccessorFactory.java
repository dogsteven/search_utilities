package com.foxsteven.search_utilities.entity_loader.ordering.identifier_accessors;

import com.foxsteven.search_utilities.entity_loader.ordering.abstractions.IdentifierAccessor;
import com.foxsteven.search_utilities.entity_loader.ordering.abstractions.IdentifierAccessorFactory;

import java.util.concurrent.ConcurrentHashMap;

public class JpaIdentifierAccessorFactory implements IdentifierAccessorFactory {
    private final ConcurrentHashMap<Class<?>, IdentifierAccessor<?>> identifierAccessorDictionary;


    public JpaIdentifierAccessorFactory() {
        identifierAccessorDictionary = new ConcurrentHashMap<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> IdentifierAccessor<T> create(Class<T> entityClass) {
        return (IdentifierAccessor<T>) identifierAccessorDictionary
                .computeIfAbsent(entityClass, (clazz) -> new JpaIdentifierAccessor<T>());
    }
}
