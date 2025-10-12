// Generated from /Users/rio/IdeaProjects/search_utilities/src/main/java/com/foxsteven/search_utilities/searching/expressions/builder/fox_query_language/FoxQueryLanguage.g4 by ANTLR 4.13.2
package com.foxsteven.search_utilities.searching.expressions.builders.fox_query_language.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FoxQueryLanguageParser}.
 */
public interface FoxQueryLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FoxQueryLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(FoxQueryLanguageParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoxQueryLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(FoxQueryLanguageParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FoxQueryLanguageParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(FoxQueryLanguageParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoxQueryLanguageParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(FoxQueryLanguageParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FoxQueryLanguageParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(FoxQueryLanguageParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoxQueryLanguageParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(FoxQueryLanguageParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FoxQueryLanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(FoxQueryLanguageParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoxQueryLanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(FoxQueryLanguageParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link FoxQueryLanguageParser#parenthesisExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisExpression(FoxQueryLanguageParser.ParenthesisExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoxQueryLanguageParser#parenthesisExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisExpression(FoxQueryLanguageParser.ParenthesisExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FoxQueryLanguageParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveExpression(FoxQueryLanguageParser.PrimitiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoxQueryLanguageParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveExpression(FoxQueryLanguageParser.PrimitiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FoxQueryLanguageParser#existenceExpression}.
	 * @param ctx the parse tree
	 */
	void enterExistenceExpression(FoxQueryLanguageParser.ExistenceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoxQueryLanguageParser#existenceExpression}.
	 * @param ctx the parse tree
	 */
	void exitExistenceExpression(FoxQueryLanguageParser.ExistenceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FoxQueryLanguageParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(FoxQueryLanguageParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoxQueryLanguageParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(FoxQueryLanguageParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FoxQueryLanguageParser#comparisonExpression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(FoxQueryLanguageParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoxQueryLanguageParser#comparisonExpression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(FoxQueryLanguageParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FoxQueryLanguageParser#textContainmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterTextContainmentExpression(FoxQueryLanguageParser.TextContainmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoxQueryLanguageParser#textContainmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitTextContainmentExpression(FoxQueryLanguageParser.TextContainmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FoxQueryLanguageParser#wildcardExpression}.
	 * @param ctx the parse tree
	 */
	void enterWildcardExpression(FoxQueryLanguageParser.WildcardExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FoxQueryLanguageParser#wildcardExpression}.
	 * @param ctx the parse tree
	 */
	void exitWildcardExpression(FoxQueryLanguageParser.WildcardExpressionContext ctx);
}