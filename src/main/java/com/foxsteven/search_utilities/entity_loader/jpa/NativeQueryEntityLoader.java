package com.foxsteven.search_utilities.entity_loader.jpa;

import com.foxsteven.search_utilities.entity_loader.abstractions.StringIdentifiable;
import com.foxsteven.search_utilities.entity_loader.abstractions.StringIdentifiableEntityLoader;
import jakarta.persistence.EntityManager;

import java.util.List;

public class NativeQueryEntityLoader implements StringIdentifiableEntityLoader {
    private final EntityManager entityManager;

    private final SelectInStatementProvider statementProvider;

    public NativeQueryEntityLoader(EntityManager entityManager, SelectInStatementProvider statementProvider) {
        this.entityManager = entityManager;
        this.statementProvider = statementProvider;
    }

    @Override
    public <T extends StringIdentifiable> List<T> load(List<String> identifiers, Class<T> entityClass) {
        final var selectStatement = statementProvider.provideSelectInStatement(identifiers, entityClass);
        final var nativeQuery = entityManager.createNativeQuery(selectStatement, entityClass);

        //noinspection unchecked
        return (List<T>) nativeQuery.getResultList();
    }
}
