package com.foxsteven.search_utilities.searching.expressions.optimizers.reduction;

import com.foxsteven.search_utilities.searching.expressions.optimizers.abstractions.HomogeneousExpressionOptimizer;
import com.foxsteven.search_utilities.searching.expressions.AndExpression;
import com.foxsteven.search_utilities.searching.expressions.Expression;
import com.foxsteven.search_utilities.searching.expressions.NotExpression;
import com.foxsteven.search_utilities.searching.expressions.OrExpression;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StructureReductionExpressionOptimizer extends HomogeneousExpressionOptimizer {
    @Override
    public Expression visitOrExpression(OrExpression expression) {
        final var subExpressions = new ArrayList<Expression>();
        final var notExpressions = new ArrayList<NotExpression>();

        expression.subExpressions()
                .stream()
                .map(this::optimize)
                .flatMap(subExpression -> {
                    if (subExpression instanceof OrExpression orExpression) {
                        return orExpression.subExpressions().stream();
                    } else {
                        return Stream.of(subExpression);
                    }
                })
                .forEach(subExpression -> {
                    if (subExpression instanceof NotExpression notExpression) {
                        notExpressions.add(notExpression);
                    } else {
                        subExpressions.add(subExpression);
                    }
                });

        if (notExpressions.size() <= 1) {
            subExpressions.addAll(notExpressions);
        } else {
            final var combinedAndExpression = new AndExpression(notExpressions
                    .stream()
                    .map(NotExpression::innerExpression)
                    .toList());

            final var combinedNotExpression = new NotExpression(combinedAndExpression).accept(this);

            subExpressions.add(combinedNotExpression);
        }

        if (subExpressions.size() == 1) {
            return subExpressions.get(0);
        } else {
            return new OrExpression(subExpressions);
        }
    }

    @Override
    public Expression visitAndExpression(AndExpression expression) {
        final var subExpressions = new ArrayList<Expression>();
        final var notExpressions = new ArrayList<NotExpression>();

        expression.subExpressions()
                .stream()
                .map(this::optimize)
                .flatMap(subExpression -> {
                    if (subExpression instanceof AndExpression andExpression) {
                        return andExpression.subExpressions().stream();
                    } else {
                        return Stream.of(subExpression);
                    }
                })
                .forEach(subExpression -> {
                    if (subExpression instanceof NotExpression notExpression) {
                        notExpressions.add(notExpression);
                    } else {
                        subExpressions.add(subExpression);
                    }
                });

        if (notExpressions.size() <= 1) {
            subExpressions.addAll(notExpressions);
        } else {
            final var combinedOrExpression = new OrExpression(notExpressions
                    .stream()
                    .map(NotExpression::innerExpression)
                    .toList());

            final var combinedNotExpression = new NotExpression(combinedOrExpression).accept(this);

            subExpressions.add(combinedNotExpression);
        }

        if (subExpressions.size() == 1) {
            return subExpressions.get(0);
        } else {
            return new AndExpression(subExpressions);
        }
    }

    @Override
    public Expression visitNotExpression(NotExpression expression) {
        final var reducedInnerExpression = expression.innerExpression().accept(this);

        if (reducedInnerExpression instanceof NotExpression notExpression) {
            return notExpression.innerExpression();
        } else {
            return new NotExpression(reducedInnerExpression);
        }
    }
}
