package com.foxsteven.search_utilities.entity_loader.jpa.inline_table;

import com.foxsteven.search_utilities.entity_loader.jpa.abstractions.DatabaseMetadataProvider;
import com.foxsteven.search_utilities.entity_loader.jpa.abstractions.SelectStatementBuilder;

public class InlineTableSelectStatementBuilder implements SelectStatementBuilder {
    private final DatabaseMetadataProvider metadataProvider;

    public InlineTableSelectStatementBuilder(DatabaseMetadataProvider metadataProvider) {
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
        statementBuilder.append(" AS e\n");
        statementBuilder.append("INNER JOIN (VALUES ");

        for (var index = 1; index <= count; ++index) {
            statementBuilder.append('(');
            statementBuilder.append(index);
            statementBuilder.append(", ");
            statementBuilder.append('?');
            statementBuilder.append(index);
            statementBuilder.append(')');

            if (index < count) {
                statementBuilder.append(", ");
            }
        }

        statementBuilder.append(") AS i(p, v) ON e.");
        statementBuilder.append(delimiter);
        statementBuilder.append(identifierColumnName);
        statementBuilder.append(delimiter);
        statementBuilder.append(" = i.v\n");
        statementBuilder.append("ORDER BY i.p ASC");

        return statementBuilder.toString();
    }
}
