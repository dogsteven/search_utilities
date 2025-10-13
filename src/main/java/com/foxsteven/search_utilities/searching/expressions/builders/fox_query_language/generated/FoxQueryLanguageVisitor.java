// Generated from D:/works/search_utilities/src/main/java/com/foxsteven/search_utilities/searching/expressions/builders/fox_query_language/FoxQueryLanguage.g4 by ANTLR 4.13.2
package com.foxsteven.search_utilities.searching.expressions.builders.fox_query_language.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FoxQueryLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FoxQueryLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FoxQueryLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(FoxQueryLanguageParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoxQueryLanguageParser#orExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(FoxQueryLanguageParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoxQueryLanguageParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(FoxQueryLanguageParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoxQueryLanguageParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(FoxQueryLanguageParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoxQueryLanguageParser#parenthesisExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisExpression(FoxQueryLanguageParser.ParenthesisExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoxQueryLanguageParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveExpression(FoxQueryLanguageParser.PrimitiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoxQueryLanguageParser#existenceExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistenceExpression(FoxQueryLanguageParser.ExistenceExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoxQueryLanguageParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(FoxQueryLanguageParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoxQueryLanguageParser#comparisonExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(FoxQueryLanguageParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoxQueryLanguageParser#textContainmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextContainmentExpression(FoxQueryLanguageParser.TextContainmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoxQueryLanguageParser#textPrefixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextPrefixExpression(FoxQueryLanguageParser.TextPrefixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoxQueryLanguageParser#textSuffixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextSuffixExpression(FoxQueryLanguageParser.TextSuffixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoxQueryLanguageParser#wildcardExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcardExpression(FoxQueryLanguageParser.WildcardExpressionContext ctx);
}