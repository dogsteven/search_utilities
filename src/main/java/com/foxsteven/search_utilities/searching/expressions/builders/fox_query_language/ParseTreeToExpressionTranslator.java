package com.foxsteven.search_utilities.searching.expressions.builders.fox_query_language;

import com.foxsteven.search_utilities.searching.expressions.*;
import com.foxsteven.search_utilities.searching.expressions.builders.fox_query_language.generated.FoxQueryLanguageBaseVisitor;
import com.foxsteven.search_utilities.searching.expressions.builders.fox_query_language.generated.FoxQueryLanguageParser;
import com.foxsteven.search_utilities.searching.expressions.builders.fox_query_language.utilities.EscapeSequenceProcessor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class ParseTreeToExpressionTranslator extends FoxQueryLanguageBaseVisitor<Expression> {
    public static final ParseTreeToExpressionTranslator shared = new ParseTreeToExpressionTranslator();

    private ParseTreeToExpressionTranslator() {}

    private String getTextContent(String text) {
        final var content = text.substring(1, text.length() - 1)
                .replace("\\\"", "\"");

        return EscapeSequenceProcessor.process(content);
    }

    private String getWildcardPatternContent(String wildcardPattern) {
        final var content = wildcardPattern.substring(1, wildcardPattern.length() - 1)
                .replace("\\#", "#");

        return EscapeSequenceProcessor.process(content);
    }

    @Override
    public Expression visitExpression(FoxQueryLanguageParser.ExpressionContext ctx) {
        return ctx.orExpression().accept(this);
    }

    @Override
    public Expression visitOrExpression(FoxQueryLanguageParser.OrExpressionContext ctx) {
        return new OrExpression(
                ctx.andExpression()
                        .stream()
                        .map(context -> context.accept(this))
                        .toList()
        );
    }

    @Override
    public Expression visitAndExpression(FoxQueryLanguageParser.AndExpressionContext ctx) {
        return new AndExpression(
                ctx.term()
                        .stream()
                        .map(context -> context.accept(this))
                        .toList()
        );
    }

    @Override
    public Expression visitTerm(FoxQueryLanguageParser.TermContext ctx) {
        final var parenthesisExpressionContext = ctx.parenthesisExpression();
        final var primitiveExpressionContext = ctx.primitiveExpression();

        final Expression expression;

        if (parenthesisExpressionContext != null) {
            expression = parenthesisExpressionContext.accept(this);
        } else if (primitiveExpressionContext != null) {
            expression = primitiveExpressionContext.accept(this);
        } else {
            expression = null;
        }

        final var positive = ctx.NOT() == null;

        if (positive) {
            return expression;
        }

        return new NotExpression(expression);
    }

    @Override
    public Expression visitParenthesisExpression(FoxQueryLanguageParser.ParenthesisExpressionContext ctx) {
        return ctx.expression().accept(this);
    }

    @Override
    public Expression visitPrimitiveExpression(FoxQueryLanguageParser.PrimitiveExpressionContext ctx) {
        final var existenceExpressionContext = ctx.existenceExpression();
        final var equalityExpressionContext = ctx.equalityExpression();
        final var comparisonExpressionContext = ctx.comparisonExpression();
        final var textContainmentExpressionContext = ctx.textContainmentExpression();
        final var wildcardExpressionContext = ctx.wildcardExpression();

        if (existenceExpressionContext != null) {
            return existenceExpressionContext.accept(this);
        }

        if (equalityExpressionContext != null) {
            return equalityExpressionContext.accept(this);
        }

        if (comparisonExpressionContext != null) {
            return comparisonExpressionContext.accept(this);
        }

        if (textContainmentExpressionContext != null) {
            return textContainmentExpressionContext.accept(this);
        }

        if (wildcardExpressionContext != null) {
            return wildcardExpressionContext.accept(this);
        }

        return null;
    }

    @Override
    public Expression visitExistenceExpression(FoxQueryLanguageParser.ExistenceExpressionContext ctx) {
        final var field = ctx.FIELD().getText();
        final var positive = ctx.EQUAL_OPERATOR() != null;

        final var existencePrimitive = new ExistencePrimitive(field);

        if (positive) {
            return existencePrimitive;
        }

        return new NotExpression(existencePrimitive);
    }

    @Override
    public Expression visitEqualityExpression(FoxQueryLanguageParser.EqualityExpressionContext ctx) {
        final var field = ctx.FIELD().getText();
        final var positive = ctx.EQUAL_OPERATOR() != null;

        final Expression expression;

        if (ctx.BOOLEAN() != null) {
            final var value = ctx.BOOLEAN().getText().equals("true");

            expression = new BooleanEqualityPrimitive(field, value);
        } else if (ctx.NUMBER() != null) {
            final var value = Double.parseDouble(ctx.NUMBER().getText());

            expression = new NumberEqualityPrimitive(field, value);
        } else if (ctx.TEXT() != null) {
            final var value = getTextContent(ctx.TEXT().getText());

            expression = new TextEqualityPrimitive(field, value);
        } else {
            expression = null;
        }

        if (positive) {
            return expression;
        }

        return new NotExpression(expression);
    }

    @Override
    public Expression visitComparisonExpression(FoxQueryLanguageParser.ComparisonExpressionContext ctx) {
        final var field = ctx.FIELD().getText();
        final var operator = switch (ctx.getChild(1).getText()) {
            case "<" -> ComparisonOperator.Less;
            case "<=" -> ComparisonOperator.LessEqual;
            case ">" -> ComparisonOperator.Greater;
            case ">=" -> ComparisonOperator.GreaterEqual;
            default -> null;
        };

        if (ctx.NUMBER() != null) {
            final var value = Double.parseDouble(ctx.NUMBER().getText());

            return new NumberComparisonPrimitive(field, operator, value);
        } else if (ctx.OFFSET_DATE_TIME() != null) {
            final var value = OffsetDateTime.parse(ctx.OFFSET_DATE_TIME().getText());

            return new OffsetDateTimeComparisonPrimitive(field, operator, value);
        } else if (ctx.LOCAL_DATE_TIME() != null) {
            final var value = LocalDateTime.parse(ctx.LOCAL_DATE_TIME().getText());

            return new LocalDateTimeComparisonPrimitive(field, operator, value);
        } else if (ctx.LOCAL_DATE() != null) {
            final var value = LocalDate.parse(ctx.LOCAL_DATE().getText());

            return new LocalDateComparisonPrimitive(field, operator, value);
        } else {
            return null;
        }
    }

    @Override
    public Expression visitTextContainmentExpression(FoxQueryLanguageParser.TextContainmentExpressionContext ctx) {
        final var field = ctx.FIELD().getText();
        final var value = getTextContent(ctx.TEXT().getText());
        final var isCaseInsensitive = ctx.CASE_INSENSITIVE_MARK() != null;

        return new TextContainmentPrimitive(field, value, isCaseInsensitive);
    }

    @Override
    public Expression visitWildcardExpression(FoxQueryLanguageParser.WildcardExpressionContext ctx) {
        final var field = ctx.FIELD().getText();
        final var value = getWildcardPatternContent(ctx.WILDCARD_PATTERN().getText());
        final var isCaseInsensitive = ctx.CASE_INSENSITIVE_MARK() != null;

        return new WildcardPrimitive(field, value, isCaseInsensitive);
    }
}
