grammar FoxQueryLanguage;

expression: orExpression;
orExpression: andExpression (OR andExpression)*;
andExpression: term (AND term)*;
term: NOT? (parenthesisExpression | primitiveExpression);

parenthesisExpression: LEFT_PARENTHESIS expression RIGHT_PARENTHESIS;
primitiveExpression: existenceExpression | equalityExpression | comparisonExpression | textContainmentExpression | wildcardExpression;

existenceExpression: FIELD (EQUAL_OPERATOR | NOT_EQUAL_OPERATOR) NULL;
equalityExpression: FIELD (EQUAL_OPERATOR | NOT_EQUAL_OPERATOR) (BOOLEAN | NUMBER | TEXT);
comparisonExpression: FIELD (LESS_EQUAL_OPERATOR | LESS_OPERATOR | GREATER_EQUAL_OPERATOR | GREATER_OPERATOR) (NUMBER | OFFSET_DATE_TIME | LOCAL_DATE_TIME | LOCAL_DATE);
textContainmentExpression: FIELD CONTAINMENT_OPERATOR CASE_INSENSITIVE_MARK? TEXT;
wildcardExpression: FIELD WILDCARD_OPERATOR CASE_INSENSITIVE_MARK? WILDCARD_PATTERN;

AND: 'and';
OR: 'or';
NOT: 'not';

LEFT_PARENTHESIS: '(';
RIGHT_PARENTHESIS: ')';

EQUAL_OPERATOR: '==';
NOT_EQUAL_OPERATOR: '!=';

LESS_EQUAL_OPERATOR: '<=';
LESS_OPERATOR: '<';
GREATER_EQUAL_OPERATOR: '>=';
GREATER_OPERATOR: '>';

CONTAINMENT_OPERATOR: '@=';
WILDCARD_OPERATOR: 'widlcard';

CASE_INSENSITIVE_MARK: '*';

NULL: 'null';

BOOLEAN: TRUE | FALSE;
fragment TRUE: 'true';
fragment FALSE: 'false';

OFFSET_DATE_TIME: YEAR '-' MONTH '-' DAY 'T' HOUR ':' MINUTE ':' SECOND [+-] HOUR ':' MINUTE;
LOCAL_DATE_TIME: YEAR '-' MONTH '-' DAY 'T' HOUR ':' MINUTE ':' SECOND;
LOCAL_DATE: YEAR '-' MONTH '-' DAY;

fragment YEAR: [0-9][0-9][0-9][0-9];
fragment MONTH: [0-9][0-9];
fragment DAY: [0-9][0-9];
fragment HOUR: [0-9][0-9];
fragment MINUTE: [0-9][0-9];
fragment SECOND: [0-9][0-9];

NUMBER: [0-9]+ ('.' [0-9]+)?;

TEXT: '"' TEXT_ELEMENT* '"';
fragment TEXT_ELEMENT: (~["\\\n\t\r]) | '\\"' | '\\\\' | '\\n' | '\\t' | '\\r';

WILDCARD_PATTERN: '#' WILDCARD_PATTERN_ELEMENT* '#';
fragment WILDCARD_PATTERN_ELEMENT: (~[#\\\n\t\r]) | '\\#' | '\\\\' | '\\n' | '\\t' | '\\r';

FIELD: IDENTIFIER ('.' IDENTIFIER)*;
fragment IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;

WHITESPACE: [ \n\t\r]+ -> skip;