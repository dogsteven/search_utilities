package com.foxsteven.search_utilities.entity_loader.jpa;

import com.foxsteven.search_utilities.entity_loader.abstractions.EntityLoader;
import com.foxsteven.search_utilities.entity_loader.jpa.abstractions.SelectStatementBuilder;
import jakarta.persistence.EntityManager;

import java.util.List;

public class JpaNativeQueryEntityLoader implements EntityLoader {
    private final EntityManager entityManager;

    private final SelectStatementBuilder selectStatementBuilder;

    public JpaNativeQueryEntityLoader(EntityManager entityManager, SelectStatementBuilder selectStatementBuilder) {
        this.entityManager = entityManager;
        this.selectStatementBuilder = selectStatementBuilder;
    }

    @Override
    public <T> List<T> load(List<String> identifiers, Class<T> entityClass) {
        final var selectStatement = selectStatementBuilder.buildSelectStatement(identifiers.size(), entityClass);
        final var nativeQuery = entityManager.createNativeQuery(selectStatement, entityClass);

        for (var index = 0; index < identifiers.size(); ++index) {
            nativeQuery.setParameter(index + 1, identifiers.get(index));
        }

        //noinspection unchecked
        return (List<T>) nativeQuery.getResultList();
    }
}
