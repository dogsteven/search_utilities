package com.foxsteven.search_utilities.searching.expressions;

public interface ExpressionVisitor<T> {
    T visitOrExpression(OrExpression expression);
    T visitAndExpression(AndExpression expression);
    T visitNotExpression(NotExpression expression);

    T visitExistencePrimitive(ExistencePrimitive expression);
    T visitBooleanEqualityPrimitive(BooleanEqualityPrimitive expression);
    T visitNumberEqualityPrimitive(NumberEqualityPrimitive expression);
    T visitTextEqualityPrimitive(TextEqualityPrimitive expression);
    T visitNumberComparisonPrimitive(NumberComparisonPrimitive expression);
    T visitLocalDateComparisonPrimitive(LocalDateComparisonPrimitive expression);
    T visitLocalDateTimeComparisonPrimitive(LocalDateTimeComparisonPrimitive expression);
    T visitOffsetDateTimeComparisonPrimitive(OffsetDateTimeComparisonPrimitive expression);
    T visitTextContainmentPrimitive(TextContainmentPrimitive expression);
    T visitTextPrefixPrimitive(TextPrefixPrimitive expression);
    T visitTextSuffixPrimitive(TextSuffixPrimitive expression);
    T visitWildcardPrimitive(WildcardPrimitive expression);
}
