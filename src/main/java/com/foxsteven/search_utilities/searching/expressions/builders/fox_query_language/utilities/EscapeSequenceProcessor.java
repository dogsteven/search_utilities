package com.foxsteven.search_utilities.searching.expressions.builders.fox_query_language.utilities;

public class EscapeSequenceProcessor {
    public static String process(String text) {
        final var processedTextBuilder = new StringBuilder();

        var isProcessingEscapeSequence = false;

        for (var i = 0; i < text.length(); ++i) {
            final var character = text.charAt(i);

            if (isProcessingEscapeSequence) {
                if (character == '\\') {
                    processedTextBuilder.append('\\');
                } else if (character == 'n') {
                    processedTextBuilder.append('\n');
                } else if (character == 't') {
                    processedTextBuilder.append('\t');
                } else if (character == 'r') {
                    processedTextBuilder.append('\r');
                }

                isProcessingEscapeSequence = false;
            } else {
                if (character == '\\') {
                    isProcessingEscapeSequence = true;
                } else {
                    processedTextBuilder.append(character);
                }
            }
        }

        return processedTextBuilder.toString();
    }
}
