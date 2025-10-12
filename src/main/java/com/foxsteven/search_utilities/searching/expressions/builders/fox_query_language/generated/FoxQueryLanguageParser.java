// Generated from /Users/rio/IdeaProjects/search_utilities/src/main/java/com/foxsteven/search_utilities/searching/expressions/builder/fox_query_language/FoxQueryLanguage.g4 by ANTLR 4.13.2
package com.foxsteven.search_utilities.searching.expressions.builders.fox_query_language.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class FoxQueryLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, OR=2, NOT=3, LEFT_PARENTHESIS=4, RIGHT_PARENTHESIS=5, EQUAL_OPERATOR=6, 
		NOT_EQUAL_OPERATOR=7, LESS_EQUAL_OPERATOR=8, LESS_OPERATOR=9, GREATER_EQUAL_OPERATOR=10, 
		GREATER_OPERATOR=11, CONTAINMENT_OPERATOR=12, WILDCARD_OPERATOR=13, CASE_INSENSITIVE_MARK=14, 
		NULL=15, BOOLEAN=16, OFFSET_DATE_TIME=17, LOCAL_DATE_TIME=18, LOCAL_DATE=19, 
		NUMBER=20, TEXT=21, WILDCARD_PATTERN=22, FIELD=23, WHITESPACE=24;
	public static final int
		RULE_expression = 0, RULE_orExpression = 1, RULE_andExpression = 2, RULE_term = 3, 
		RULE_parenthesisExpression = 4, RULE_primitiveExpression = 5, RULE_existenceExpression = 6, 
		RULE_equalityExpression = 7, RULE_comparisonExpression = 8, RULE_textContainmentExpression = 9, 
		RULE_wildcardExpression = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"expression", "orExpression", "andExpression", "term", "parenthesisExpression", 
			"primitiveExpression", "existenceExpression", "equalityExpression", "comparisonExpression", 
			"textContainmentExpression", "wildcardExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'and'", "'or'", "'not'", "'('", "')'", "'=='", "'!='", "'<='", 
			"'<'", "'>='", "'>'", "'@='", "'widlcard'", "'*'", "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AND", "OR", "NOT", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", "EQUAL_OPERATOR", 
			"NOT_EQUAL_OPERATOR", "LESS_EQUAL_OPERATOR", "LESS_OPERATOR", "GREATER_EQUAL_OPERATOR", 
			"GREATER_OPERATOR", "CONTAINMENT_OPERATOR", "WILDCARD_OPERATOR", "CASE_INSENSITIVE_MARK", 
			"NULL", "BOOLEAN", "OFFSET_DATE_TIME", "LOCAL_DATE_TIME", "LOCAL_DATE", 
			"NUMBER", "TEXT", "WILDCARD_PATTERN", "FIELD", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FoxQueryLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FoxQueryLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoxQueryLanguageVisitor ) return ((FoxQueryLanguageVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			orExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OrExpressionContext extends ParserRuleContext {
		public List<AndExpressionContext> andExpression() {
			return getRuleContexts(AndExpressionContext.class);
		}
		public AndExpressionContext andExpression(int i) {
			return getRuleContext(AndExpressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(FoxQueryLanguageParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(FoxQueryLanguageParser.OR, i);
		}
		public OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoxQueryLanguageVisitor ) return ((FoxQueryLanguageVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExpressionContext orExpression() throws RecognitionException {
		OrExpressionContext _localctx = new OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_orExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			andExpression();
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(25);
				match(OR);
				setState(26);
				andExpression();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AndExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(FoxQueryLanguageParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(FoxQueryLanguageParser.AND, i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoxQueryLanguageVisitor ) return ((FoxQueryLanguageVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			term();
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(33);
				match(AND);
				setState(34);
				term();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public ParenthesisExpressionContext parenthesisExpression() {
			return getRuleContext(ParenthesisExpressionContext.class,0);
		}
		public PrimitiveExpressionContext primitiveExpression() {
			return getRuleContext(PrimitiveExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(FoxQueryLanguageParser.NOT, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoxQueryLanguageVisitor ) return ((FoxQueryLanguageVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(40);
				match(NOT);
				}
			}

			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_PARENTHESIS:
				{
				setState(43);
				parenthesisExpression();
				}
				break;
			case FIELD:
				{
				setState(44);
				primitiveExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesisExpressionContext extends ParserRuleContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(FoxQueryLanguageParser.LEFT_PARENTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(FoxQueryLanguageParser.RIGHT_PARENTHESIS, 0); }
		public ParenthesisExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesisExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).enterParenthesisExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).exitParenthesisExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoxQueryLanguageVisitor ) return ((FoxQueryLanguageVisitor<? extends T>)visitor).visitParenthesisExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesisExpressionContext parenthesisExpression() throws RecognitionException {
		ParenthesisExpressionContext _localctx = new ParenthesisExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parenthesisExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(LEFT_PARENTHESIS);
			setState(48);
			expression();
			setState(49);
			match(RIGHT_PARENTHESIS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveExpressionContext extends ParserRuleContext {
		public ExistenceExpressionContext existenceExpression() {
			return getRuleContext(ExistenceExpressionContext.class,0);
		}
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public ComparisonExpressionContext comparisonExpression() {
			return getRuleContext(ComparisonExpressionContext.class,0);
		}
		public TextContainmentExpressionContext textContainmentExpression() {
			return getRuleContext(TextContainmentExpressionContext.class,0);
		}
		public WildcardExpressionContext wildcardExpression() {
			return getRuleContext(WildcardExpressionContext.class,0);
		}
		public PrimitiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).enterPrimitiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).exitPrimitiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoxQueryLanguageVisitor ) return ((FoxQueryLanguageVisitor<? extends T>)visitor).visitPrimitiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveExpressionContext primitiveExpression() throws RecognitionException {
		PrimitiveExpressionContext _localctx = new PrimitiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_primitiveExpression);
		try {
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				existenceExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				equalityExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				comparisonExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(54);
				textContainmentExpression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(55);
				wildcardExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExistenceExpressionContext extends ParserRuleContext {
		public TerminalNode FIELD() { return getToken(FoxQueryLanguageParser.FIELD, 0); }
		public TerminalNode NULL() { return getToken(FoxQueryLanguageParser.NULL, 0); }
		public TerminalNode EQUAL_OPERATOR() { return getToken(FoxQueryLanguageParser.EQUAL_OPERATOR, 0); }
		public TerminalNode NOT_EQUAL_OPERATOR() { return getToken(FoxQueryLanguageParser.NOT_EQUAL_OPERATOR, 0); }
		public ExistenceExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_existenceExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).enterExistenceExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).exitExistenceExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoxQueryLanguageVisitor ) return ((FoxQueryLanguageVisitor<? extends T>)visitor).visitExistenceExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExistenceExpressionContext existenceExpression() throws RecognitionException {
		ExistenceExpressionContext _localctx = new ExistenceExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_existenceExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(FIELD);
			setState(59);
			_la = _input.LA(1);
			if ( !(_la==EQUAL_OPERATOR || _la==NOT_EQUAL_OPERATOR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(60);
			match(NULL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExpressionContext extends ParserRuleContext {
		public TerminalNode FIELD() { return getToken(FoxQueryLanguageParser.FIELD, 0); }
		public TerminalNode EQUAL_OPERATOR() { return getToken(FoxQueryLanguageParser.EQUAL_OPERATOR, 0); }
		public TerminalNode NOT_EQUAL_OPERATOR() { return getToken(FoxQueryLanguageParser.NOT_EQUAL_OPERATOR, 0); }
		public TerminalNode BOOLEAN() { return getToken(FoxQueryLanguageParser.BOOLEAN, 0); }
		public TerminalNode NUMBER() { return getToken(FoxQueryLanguageParser.NUMBER, 0); }
		public TerminalNode TEXT() { return getToken(FoxQueryLanguageParser.TEXT, 0); }
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoxQueryLanguageVisitor ) return ((FoxQueryLanguageVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(FIELD);
			setState(63);
			_la = _input.LA(1);
			if ( !(_la==EQUAL_OPERATOR || _la==NOT_EQUAL_OPERATOR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(64);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3211264L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExpressionContext extends ParserRuleContext {
		public TerminalNode FIELD() { return getToken(FoxQueryLanguageParser.FIELD, 0); }
		public TerminalNode LESS_EQUAL_OPERATOR() { return getToken(FoxQueryLanguageParser.LESS_EQUAL_OPERATOR, 0); }
		public TerminalNode LESS_OPERATOR() { return getToken(FoxQueryLanguageParser.LESS_OPERATOR, 0); }
		public TerminalNode GREATER_EQUAL_OPERATOR() { return getToken(FoxQueryLanguageParser.GREATER_EQUAL_OPERATOR, 0); }
		public TerminalNode GREATER_OPERATOR() { return getToken(FoxQueryLanguageParser.GREATER_OPERATOR, 0); }
		public TerminalNode NUMBER() { return getToken(FoxQueryLanguageParser.NUMBER, 0); }
		public TerminalNode OFFSET_DATE_TIME() { return getToken(FoxQueryLanguageParser.OFFSET_DATE_TIME, 0); }
		public TerminalNode LOCAL_DATE_TIME() { return getToken(FoxQueryLanguageParser.LOCAL_DATE_TIME, 0); }
		public TerminalNode LOCAL_DATE() { return getToken(FoxQueryLanguageParser.LOCAL_DATE, 0); }
		public ComparisonExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).enterComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).exitComparisonExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoxQueryLanguageVisitor ) return ((FoxQueryLanguageVisitor<? extends T>)visitor).visitComparisonExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonExpressionContext comparisonExpression() throws RecognitionException {
		ComparisonExpressionContext _localctx = new ComparisonExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_comparisonExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(FIELD);
			setState(67);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3840L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(68);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1966080L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextContainmentExpressionContext extends ParserRuleContext {
		public TerminalNode FIELD() { return getToken(FoxQueryLanguageParser.FIELD, 0); }
		public TerminalNode CONTAINMENT_OPERATOR() { return getToken(FoxQueryLanguageParser.CONTAINMENT_OPERATOR, 0); }
		public TerminalNode TEXT() { return getToken(FoxQueryLanguageParser.TEXT, 0); }
		public TerminalNode CASE_INSENSITIVE_MARK() { return getToken(FoxQueryLanguageParser.CASE_INSENSITIVE_MARK, 0); }
		public TextContainmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textContainmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).enterTextContainmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).exitTextContainmentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoxQueryLanguageVisitor ) return ((FoxQueryLanguageVisitor<? extends T>)visitor).visitTextContainmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContainmentExpressionContext textContainmentExpression() throws RecognitionException {
		TextContainmentExpressionContext _localctx = new TextContainmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_textContainmentExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(FIELD);
			setState(71);
			match(CONTAINMENT_OPERATOR);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CASE_INSENSITIVE_MARK) {
				{
				setState(72);
				match(CASE_INSENSITIVE_MARK);
				}
			}

			setState(75);
			match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WildcardExpressionContext extends ParserRuleContext {
		public TerminalNode FIELD() { return getToken(FoxQueryLanguageParser.FIELD, 0); }
		public TerminalNode WILDCARD_OPERATOR() { return getToken(FoxQueryLanguageParser.WILDCARD_OPERATOR, 0); }
		public TerminalNode WILDCARD_PATTERN() { return getToken(FoxQueryLanguageParser.WILDCARD_PATTERN, 0); }
		public TerminalNode CASE_INSENSITIVE_MARK() { return getToken(FoxQueryLanguageParser.CASE_INSENSITIVE_MARK, 0); }
		public WildcardExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcardExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).enterWildcardExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FoxQueryLanguageListener ) ((FoxQueryLanguageListener)listener).exitWildcardExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoxQueryLanguageVisitor ) return ((FoxQueryLanguageVisitor<? extends T>)visitor).visitWildcardExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WildcardExpressionContext wildcardExpression() throws RecognitionException {
		WildcardExpressionContext _localctx = new WildcardExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_wildcardExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(FIELD);
			setState(78);
			match(WILDCARD_OPERATOR);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CASE_INSENSITIVE_MARK) {
				{
				setState(79);
				match(CASE_INSENSITIVE_MARK);
				}
			}

			setState(82);
			match(WILDCARD_PATTERN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0018U\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u001c\b\u0001\n\u0001\f\u0001"+
		"\u001f\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002$\b\u0002"+
		"\n\u0002\f\u0002\'\t\u0002\u0001\u0003\u0003\u0003*\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003.\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u00059\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0003\tJ\b\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0003\nQ\b\n\u0001\n\u0001\n\u0001\n\u0000\u0000\u000b"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0000\u0004\u0001"+
		"\u0000\u0006\u0007\u0002\u0000\u0010\u0010\u0014\u0015\u0001\u0000\b\u000b"+
		"\u0001\u0000\u0011\u0014S\u0000\u0016\u0001\u0000\u0000\u0000\u0002\u0018"+
		"\u0001\u0000\u0000\u0000\u0004 \u0001\u0000\u0000\u0000\u0006)\u0001\u0000"+
		"\u0000\u0000\b/\u0001\u0000\u0000\u0000\n8\u0001\u0000\u0000\u0000\f:"+
		"\u0001\u0000\u0000\u0000\u000e>\u0001\u0000\u0000\u0000\u0010B\u0001\u0000"+
		"\u0000\u0000\u0012F\u0001\u0000\u0000\u0000\u0014M\u0001\u0000\u0000\u0000"+
		"\u0016\u0017\u0003\u0002\u0001\u0000\u0017\u0001\u0001\u0000\u0000\u0000"+
		"\u0018\u001d\u0003\u0004\u0002\u0000\u0019\u001a\u0005\u0002\u0000\u0000"+
		"\u001a\u001c\u0003\u0004\u0002\u0000\u001b\u0019\u0001\u0000\u0000\u0000"+
		"\u001c\u001f\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000"+
		"\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u0003\u0001\u0000\u0000\u0000"+
		"\u001f\u001d\u0001\u0000\u0000\u0000 %\u0003\u0006\u0003\u0000!\"\u0005"+
		"\u0001\u0000\u0000\"$\u0003\u0006\u0003\u0000#!\u0001\u0000\u0000\u0000"+
		"$\'\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000"+
		"\u0000&\u0005\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000(*\u0005"+
		"\u0003\u0000\u0000)(\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000"+
		"*-\u0001\u0000\u0000\u0000+.\u0003\b\u0004\u0000,.\u0003\n\u0005\u0000"+
		"-+\u0001\u0000\u0000\u0000-,\u0001\u0000\u0000\u0000.\u0007\u0001\u0000"+
		"\u0000\u0000/0\u0005\u0004\u0000\u000001\u0003\u0000\u0000\u000012\u0005"+
		"\u0005\u0000\u00002\t\u0001\u0000\u0000\u000039\u0003\f\u0006\u000049"+
		"\u0003\u000e\u0007\u000059\u0003\u0010\b\u000069\u0003\u0012\t\u00007"+
		"9\u0003\u0014\n\u000083\u0001\u0000\u0000\u000084\u0001\u0000\u0000\u0000"+
		"85\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000087\u0001\u0000\u0000"+
		"\u00009\u000b\u0001\u0000\u0000\u0000:;\u0005\u0017\u0000\u0000;<\u0007"+
		"\u0000\u0000\u0000<=\u0005\u000f\u0000\u0000=\r\u0001\u0000\u0000\u0000"+
		">?\u0005\u0017\u0000\u0000?@\u0007\u0000\u0000\u0000@A\u0007\u0001\u0000"+
		"\u0000A\u000f\u0001\u0000\u0000\u0000BC\u0005\u0017\u0000\u0000CD\u0007"+
		"\u0002\u0000\u0000DE\u0007\u0003\u0000\u0000E\u0011\u0001\u0000\u0000"+
		"\u0000FG\u0005\u0017\u0000\u0000GI\u0005\f\u0000\u0000HJ\u0005\u000e\u0000"+
		"\u0000IH\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0001\u0000"+
		"\u0000\u0000KL\u0005\u0015\u0000\u0000L\u0013\u0001\u0000\u0000\u0000"+
		"MN\u0005\u0017\u0000\u0000NP\u0005\r\u0000\u0000OQ\u0005\u000e\u0000\u0000"+
		"PO\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000"+
		"\u0000RS\u0005\u0016\u0000\u0000S\u0015\u0001\u0000\u0000\u0000\u0007"+
		"\u001d%)-8IP";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}