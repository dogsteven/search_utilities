package com.foxsteven.search_utilities.entity_loader.jpa.in_operator;

import com.foxsteven.search_utilities.entity_loader.jpa.abstractions.DatabaseMetadataProvider;
import com.foxsteven.search_utilities.entity_loader.jpa.abstractions.SelectStatementBuilder;

public class InOperatorSelectStatementBuilder implements SelectStatementBuilder {
    private final DatabaseMetadataProvider metadataProvider;

    public InOperatorSelectStatementBuilder(DatabaseMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    @Override
    public <T> String buildSelectStatement(int count, Class<T> entityClass) {
        final var tableName = metadataProvider.provideTableName(entityClass);
        final var identifierColumnName = metadataProvider.provideIdentifierColumnName(entityClass);
        final var delimiter = metadataProvider.provideDelimiter();

        final var statementBuilder = new StringBuilder();

        statementBuilder.append("SELECT e.* FROM ");
        statementBuilder.append(delimiter);
        statementBuilder.append(tableName);
        statementBuilder.append(delimiter);
        statementBuilder.append(" AS e WHERE e.");
        statementBuilder.append(delimiter);
        statementBuilder.append(identifierColumnName);
        statementBuilder.append(delimiter);
        statementBuilder.append(" IN (");

        for (var index = 1; index <= count; ++index) {
            statementBuilder.append('?');
            statementBuilder.append(index);

            if (index < count) {
                statementBuilder.append(", ");
            }
        }

        statementBuilder.append(')');

        return statementBuilder.toString();
    }
}
