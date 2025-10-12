package com.foxsteven.search_utilities.searching.elasticsearch.translators.homogeneous;

import co.elastic.clients.elasticsearch._types.query_dsl.DateRangeQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.NumberRangeQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import com.foxsteven.search_utilities.searching.elasticsearch.translators.abstractions.ExpressionToQueryTranslator;
import com.foxsteven.search_utilities.searching.expressions.*;

import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public class HomogeneousExpressionToQueryTranslator implements ExpressionToQueryTranslator, ExpressionVisitor<Query> {
    @Override
    public Query translate(Expression expression) {
        return expression.accept(this);
    }

    @Override
    public Query visitOrExpression(OrExpression expression) {
        return Query.of(query -> query
                .bool(bool -> bool
                        .minimumShouldMatch("1")
                        .should(expression.subExpressions()
                                .stream()
                                .map(this::translate)
                                .toList())));
    }

    @Override
    public Query visitAndExpression(AndExpression expression) {
        return Query.of(query -> query
                .bool(bool -> bool
                        .must(expression.subExpressions()
                                .stream()
                                .map(this::translate)
                                .toList())));
    }

    @Override
    public Query visitNotExpression(NotExpression expression) {
        return Query.of(query -> query
                .bool(bool -> bool
                        .mustNot(expression.innerExpression().accept(this))));
    }

    @Override
    public Query visitExistencePrimitive(ExistencePrimitive expression) {
        return Query.of(query -> query
                .exists(exists -> exists
                        .field(expression.field())));
    }

    @Override
    public Query visitBooleanEqualityPrimitive(BooleanEqualityPrimitive expression) {
        return Query.of(query -> query
                .term(term -> term
                        .field(expression.field())
                        .value(expression.value())));
    }

    @Override
    public Query visitNumberEqualityPrimitive(NumberEqualityPrimitive expression) {
        return Query.of(query -> query
                .term(term -> term
                        .field(expression.field())
                        .value(expression.value())));
    }

    @Override
    public Query visitTextEqualityPrimitive(TextEqualityPrimitive expression) {
        return Query.of(query -> query
                .term(term -> term
                        .field(expression.field())
                        .value(expression.value())));
    }

    @Override
    public Query visitNumberComparisonPrimitive(NumberComparisonPrimitive expression) {
        final Function<NumberRangeQuery.Builder, NumberRangeQuery.Builder> queryCustomizer;

        queryCustomizer = switch (expression.operator()) {
            case Less -> number -> number.lt(expression.value());
            case LessEqual -> number -> number.lte(expression.value());
            case Greater -> number -> number.gt(expression.value());
            case GreaterEqual -> number -> number.gte(expression.value());
        };

        return Query.of(query -> query
                .range(range -> range
                        .number(number -> queryCustomizer
                                .apply(number.field(expression.field())))));
    }

    @Override
    public Query visitLocalDateComparisonPrimitive(LocalDateComparisonPrimitive expression) {
        final var value = expression.value().format(DateTimeFormatter.ISO_LOCAL_DATE);

        return buildDateComparisonQuery(expression.field(), expression.operator(), value);
    }

    @Override
    public Query visitLocalDateTimeComparisonPrimitive(LocalDateTimeComparisonPrimitive expression) {
        final var value = expression.value().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        return buildDateComparisonQuery(expression.field(), expression.operator(), value);
    }

    @Override
    public Query visitOffsetDateTimeComparisonPrimitive(OffsetDateTimeComparisonPrimitive expression) {
        final var value = expression.value().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        return buildDateComparisonQuery(expression.field(), expression.operator(), value);
    }

    private Query buildDateComparisonQuery(String field, ComparisonOperator operator, String value) {
        final Function<DateRangeQuery.Builder, DateRangeQuery.Builder> queryCustomizer;

        queryCustomizer = switch (operator) {
            case Less -> date -> date.lt(value);
            case LessEqual -> date -> date.lte(value);
            case Greater -> date -> date.gt(value);
            case GreaterEqual -> date -> date.gte(value);
        };

        return Query.of(query -> query
                .range(range -> range
                        .date(date -> queryCustomizer
                                .apply(date.field(field)))));
    }

    @Override
    public Query visitTextContainmentPrimitive(TextContainmentPrimitive expression) {
        Boolean caseInsensitive = expression.isCaseInsensitive() ? true : null;


        return Query.of(query -> query
                .wildcard(wildcard -> wildcard
                        .field(expression.field())
                        .value("*" + expression.value() + "*")
                        .caseInsensitive(caseInsensitive)));
    }

    @Override
    public Query visitWildcardPrimitive(WildcardPrimitive expression) {
        Boolean caseInsensitive = expression.isCaseInsensitive() ? true : null;

        return Query.of(query -> query
                .wildcard(wildcard -> wildcard
                        .field(expression.field())
                        .value(expression.value())
                        .caseInsensitive(caseInsensitive)));
    }
}
