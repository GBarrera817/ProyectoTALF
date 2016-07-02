grammar json;

json
    : value
    ;

object
    : '{' pair (',' pair)* '}'
    | '{' '}' // Objeto vacío
    ;

pair
    : STRING ':' value
    ;

array
    : '[' value (',' value)* ']'
    | '[' ']' // Array vacío
    ;

value
    : STRING
    | NUMBER
    | object  //recursión
    | array   //recursión
    | 'true'  //keywords
    | 'false'
    | 'null'
    ;

// Reglas léxicas



STRING
    : '"' (ESC | ~["\\])* '"'
    ;

fragment ESC
    : '\\' (["\\/bfnrt] | UNICODE)
    ;

fragment UNICODE
    : 'u' HEX HEX HEX HEX
    ;

fragment HEX
    : [0-9a-fA-F]
    ;


NUMBER
    : '-'? INT '.' INT EXP?      // 1.35, 1.35E-9, 0.3, -4.5
    | '-'? INT EXP               // 1e10 -3e4
    | '-'? INT                   // -3, 45
    ;

fragment INT
    : '0' | [1-9] [0-9]*  // no leading zeros
    ;


fragment EXP
    : [Ee] [+\-]? INT  // '\-' desde - significa "rango" dentro[...]
    ;


WS
    : [ \t\n\r]+ -> skip
    ;