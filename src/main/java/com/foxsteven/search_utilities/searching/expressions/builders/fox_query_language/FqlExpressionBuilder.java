package com.foxsteven.search_utilities.searching.expressions.builders.fox_query_language;

import com.foxsteven.search_utilities.searching.expressions.Expression;
import com.foxsteven.search_utilities.searching.expressions.builders.abstractions.StringBasedExpressionBuilder;
import com.foxsteven.search_utilities.searching.expressions.builders.fox_query_language.generated.FoxQueryLanguageLexer;
import com.foxsteven.search_utilities.searching.expressions.builders.fox_query_language.generated.FoxQueryLanguageParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class FqlExpressionBuilder implements StringBasedExpressionBuilder {
    @Override
    public Expression build(String expressionString) {
        final var charStream = CharStreams.fromString(expressionString);
        final var lexer = new FoxQueryLanguageLexer(charStream);
        final var tokenStream = new CommonTokenStream(lexer);
        final var parser = new FoxQueryLanguageParser(tokenStream);
        final var expressionContext = parser.expression();

        return expressionContext.accept(ParseTreeToExpressionTranslator.shared);
    }
}
