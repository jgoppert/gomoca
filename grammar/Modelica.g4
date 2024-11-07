// modelica language standard 3.7
grammar Modelica;

//=========================================================
//  A.2.1 Stored Definition - Within
//=========================================================

stored_definition:
   (WITHIN component_reference? ';')?
   (FINAL? class_definition ';')+ EOF;

//=========================================================
//  A.2.2 Class Definition
//=========================================================
class_definition:
    ENCAPSULATED? class_prefixes class_specifier;

class_prefixes:
    PARTIAL? class_type;

class_type:
    BLOCK                                        # class_type_block    
    //| CLASS                                     # class_type_class
    //| MODEL                                     # class_type_class
    //| OPERATOR? RECORD                          # class_type_record
    //| EXPANDABLE? CONNECTOR                     # class_type_connector
    //| TYPE                                      # class_type_type
    //| PACKAGE                                   # class_type_package
    //| (PURE | IMPURE)? OPERATOR? FUNCTION       # class_type_function
    //| OPERATOR                                  # class_type_operator
    ;

class_specifier:
    long_class_specifier                          # class_specifier_long
    //|short_class_specifier                      # class_specifier_short
    //| der_class_specifier                       # class_specifier_der
    ;

long_class_specifier :
    IDENT description_string composition END IDENT
    //| EXTENDS IDENT class_modification? description_string composition END IDENT
    ;

// short_class_specifier:
//     IDENT '=' causality=(INPUT | OUTPUT) type_specifier array_subscripts? class_modification? description
//     | IDENT '=' ENUMERATION '(' ( enum_list? | ':') ')' description
//     ;

// der_class_specifier:
//     IDENT '=' DER '(' type_specifier ',' IDENT ( ',' IDENT)* ')' description;

// enum_list:
//     enumeration_literal ( ',' enumeration_literal)*;

// enumeration_literal:
//     IDENT description;

composition:
    element_list
    composition_non_first*
    //( EXTERNAL language_specification? external_function_call? annotation_clause? ';')?
    //( annotation_clause ';' )?
    ;

 composition_non_first:
    visibility=(PUBLIC | PROTECTED) element_list    # composition_visiblity_element_list
    | INITIAL? EQUATION ( equation ';')*            # composition_equation_section
    | INITIAL? ALGORITHM ( statement ';')*          # composition_algorithm_section
    ;

external_function_call:
    (component_reference '=')? IDENT '(' expression_list? ')';

element_list:
    ( element ';')*;

element:
    element_options component_clause  # element_component_clause
    //| element_options class_definition    # element_class_definition
    //| element_options REPLACEABLE class_definition
    //     (constraining_clause description)? # element_replaceable_class_definition
    //| element_options REPLACEABLE component_clause
    //     (constraining_clause description)?  # element_replaceable_component_clause
    //| import_clause
    //| extends_clause
    ;

element_options:
    REDECLARE? FINAL? INNER? OUTER?;

import_clause:
    IMPORT import_clause_types description;

import_clause_types:
    IDENT '=' name                                          # import_clause_simple
    //| name ( ('.*' | '.') ( '*' | '{' import_list '}') )?   # import_clause_list
    ;

import_list:
    IDENT ( ',' IDENT )*;

//=========================================================
//  A.2.3 Extends
//=========================================================
// extends_clause:
//     EXTENDS
//     type_specifier
//     class_or_inheritance_modification?
//     annotation_clause?
//     ;

// constraining_clause:
//     CONSTRAINEDBY
//     type_specifier
//     class_modification?
//     ;

// class_or_inheritance_modification:
//     '(' argument_or_inheritance_modification_list? ')';

// argument_or_inheritance_modification_list:
//     ( argument | inheritance_modification)
//     ( ',' (argument | inheritance_modification) )*
//     ;

// inheritance_modification:
//     BREAK ( connect_equation | IDENT);

//=========================================================
//  A.2.4 Component Clause
//=========================================================
component_clause:
    type_prefix type_specifier array_subscripts? component_list;

type_prefix:
    flow_stream=(FLOW | STREAM)?
    variablity=(DISCRETE | PARAMETER | CONSTANT)?
    causality=(INPUT | OUTPUT)?;

component_list:
    component_declaration ( ',' component_declaration)*;

component_declaration:
    declaration
    //condition_attribute?
    description
    ;

// condition_attribute:
//     IF expression;

declaration:
    IDENT
    array_subscripts?
    //modification?
    ;

//=========================================================
//  A.2.5 Modification
//=========================================================
// modification:
//     class_modification ( '=' modification_expression )?
//     | '=' modification_expression;

// modification_expression :
//     expression
//     | BREAK;

// class_modification:
//     '(' argument_list? ')';

// argument_list:
//     argument ( ',' argument )*;

// argument:
//     element_modification_or_replaceable
//     | element_redeclaration;

// element_modification_or_replaceable:
//     EACH? FINAL? (element_modification | element_replaceable);

// element_modification:
//     name modification? description_string;

// element_redeclaration:
//     REDECLARE EACH? FINAL?
//     (short_class_definition | component_clause1 | element_replaceable);

// element_replaceable:
//     REPLACEABLE (short_class_definition | component_clause1) constraining_clause?;

// component_clause1:
//     type_prefix type_specifier component_declaration1;

// component_declaration1:
//     declaration description;

// short_class_definition:
//     class_prefixes short_class_specifier;

//=========================================================
//  A.2.6 Equations
//=========================================================
// NOTE: equation_section and algorithm_section embedded in composition
//       to reduce parsing levels

equation:
    simple_expression '=' expression description            # equation_simple
    //| if_equation description                               # equation_if
    //| for_equation description                              # equation_for
    //| connect_equation description                          # equation_connect
    //| when_equation description                             # equation_when
    //| component_reference function_call_args description    # equation_function
    ;

statement:
    component_reference ( ':=' expression | function_call_args) description                     # statement_component_reference
    //| '(' output_expression_list ')' ':=' component_reference function_call_args description  # statement_ouput_expression_list
    //| BREAK description                         # statement_break
    //| RETURN description                        # statement_return
    //| if_statement description                  # statement_if
    //| for_statement description                 # statement_for
    //| while_statement description               # statement_while
    //| when_statement description                # statement_when
    ;

// if_equation:
//     if_equation_if
//     if_equation_elseif*
//     if_equation_else?
//     END IF;

// if_equation_if:
//     IF expression THEN ( equation ';')*;

// if_equation_elseif:
//     ELSEIF expression THEN (equation ';')*;

// if_equation_else:
//     ELSE (else_eq=equation ';')*;

// if_statement:
//     if_statement_if
//     if_statement_elseif*
//     if_statement_else?
//     END IF;

// if_statement_if:
//     IF expression THEN ( statement ';')*;

// if_statement_elseif:
//     ELSEIF expression THEN (statement ';')*;

// if_statement_else:
//     ELSE (statement ';')*;

// for_equation:
//     FOR for_indices LOOP
//         ( equation ';')*
//     END FOR;

// for_statement:
//     FOR for_indices LOOP
//         ( statement ';')*
//     END FOR;

for_indices:
    for_index ( ',' for_index)*;

for_index:
    IDENT (IN expression)?;

// while_statement:
//     WHILE expression LOOP
//         (statement ';')*
//     END WHILE;

// when_equation:
//     when_equation_when
//     when_equation_elsewhen*
//     END WHEN;

// when_equation_when:
//     WHEN when_cond=expression THEN
//         (when_eq+=equation ';')*;

// when_equation_elsewhen:
//     ELSEWHEN expression THEN
//         (equation ';')*;

// when_statement:
//     when_statement_when
//     when_statement_elsewhen*
//     END WHEN;

// when_statement_when:
//     WHEN expression THEN
//         (statement ';')*;

// when_statement_elsewhen:
//     ELSEWHEN expression THEN
//         (statement ';')*;

// connect_equation:
//     CONNECT '(' left=component_reference ',' right=component_reference ')';

//=========================================================
//  A.2.7 Expressions
//=========================================================
expression:
    simple_expression    # expression_simple
    //| IF expression THEN expression
    //(ELSEIF expression THEN expression)* ELSE expression  # expression_if
    ;

simple_expression:
    logical_expression ( ':' logical_expression ( ':' logical_expression)? )?;

logical_expression:
    logical_term ( OR logical_term)*;

logical_term:
    NOT? relation;

relation:
    left=arithmetic_expression (
        op=('<' | '<=' | '>' | '>=' | '==' | '<>')
        right=arithmetic_expression)?;

arithmetic_expression:
    sign=('+' | '-')? term ( op+=('+' | '-' | '.+' | '.-') term)*;

term:
    factor (op+=('*' | '/' | '.*' | './') factor)*;

factor:
    left=primary ( op=( '^' | '.^') right=primary)?;

primary:
    UNSIGNED_NUMBER                                                         # primary_unsigned_number
    | STRING                                                                # primary_string
    | TRUE                                                                  # primary_true
    | FALSE                                                                 # primary_false
    //| component_reference function_call_args                                # primary_function
    | DER function_call_args                                                # primary_derivative
    //| INITIAL function_call_args                                            # primary_initial
    //| PURE function_call_args                                               # primary_pure
    | component_reference                                                   # primary_component_reference
    //| '(' output_expression_list ')' ( (array_subscripts  | '.' IDENT))?    # primary_output_expression_list
    //| '[' expression_list ( ';' expression_list)* ']'                       # primary_expression_list
    //| '{' array_arguments '}'                                               # primary_array_arguments
    //| END                                                                   # primary_end
    ;                                                                  

UNSIGNED_NUMBER:
    UNSIGNED_INTEGER | UNSIGNED_REAL;

type_specifier:
    '.'? name;

name:
    IDENT ( '.' IDENT)*;

component_reference:
    local='.'? component_scope ('.' component_scope)*;

component_scope:
    IDENT array_subscripts?;

// results_reference:
//     component_reference
//     | DER '(' component_reference ( ',' UNSIGNED_INTEGER)? ')'
//     ;

function_call_args:
    '(' function_arguments? ')';

function_arguments:
    expression ( ',' function_arguments_non_first | FOR for_indices)?
    //| function_partial_application (',' function_arguments_non_first)?
    //| named_arguments
    ;

function_arguments_non_first:
    function_argument (',' function_arguments_non_first)*
    | named_arguments
    ;

array_arguments:
    expression ( ',' array_arguments_non_first | FOR for_indices)?
    ;

array_arguments_non_first:
    expression ( ',' array_arguments_non_first)?
    ;

named_arguments:
    named_argument ( ',' named_argument)?
    ;

named_argument:
    IDENT '=' function_argument
    ;

function_argument:
    function_partial_application
    | expression
    ;

function_partial_application:
    FUNCTION type_specifier '(' named_arguments? ')'
    ;

// output_expression_list:
//     expression? ( ',' expression?)*
//     ;

expression_list:
    expression ( ',' expression)*
    ;

array_subscripts:
    '[' subscript (',' subscript)* ']'
    ;

subscript:
    colon=':' | expression;

description:
    description_string
    //annotation_clause?
    ;

description_string:
    ( STRING ( '+' STRING)* )?
    ;

// annotation_clause:
//     ANNOTATION class_modification
//     ;

//=========================================================
// Keywords 2.3.3
//=========================================================
ALGORITHM : 'algorithm';
AND : 'and';
ANNOTATION : 'annotation';
BLOCK : 'block';
BREAK : 'break';
CLASS : 'class';
CONNECT : 'connect';
CONNECTOR : 'connector';
CONSTANT : 'constant';
CONSTRAINEDBY : 'constrainedby';
DER : 'der';
DISCRETE : 'discrete';
EACH : 'each';
ELSE : 'else';
ELSEIF : 'elseif';
ELSEWHEN : 'elsewhen';
ENCAPSULATED : 'encapsulated';
END : 'end';
ENUMERATION : 'enumeration';
EQUATION : 'equation';
EXPANDABLE : 'expandable';
EXTENDS : 'extends';
EXTERNAL : 'external';
FALSE : 'false';
FINAL : 'final';
FLOW : 'flow';
FOR : 'for';
FUNCTION : 'function';
IF : 'if';
IMPORT : 'import';
IMPURE : 'impure';
IN : 'in';
INITIAL : 'initial';
INNER : 'inner';
INPUT : 'input';
LOOP : 'loop';
MODEL : 'model';
NOT : 'not';
OPERATOR : 'operator';
OR : 'or';
OUTER : 'outer';
OUTPUT : 'output';
PACKAGE : 'package';
PARAMETER : 'parameter';
PARTIAL : 'partial';
PROTECTED : 'protected';
PUBLIC : 'public';
PURE : 'pure';
RECORD : 'record';
REDECLARE : 'redeclare';
REPLACEABLE : 'replaceable';
RETURN : 'return';
STREAM : 'stream';
THEN : 'then';
TRUE : 'true';
TYPE : 'type';
WHEN : 'when';
WHILE : 'while';
WITHIN : 'within';

//=========================================================
// A.1 Lexical Conventions
//=========================================================
IDENT : NON_DIGIT ( DIGIT | NON_DIGIT )* | Q_IDENT;
fragment Q_IDENT : '\'' ( Q_CHAR | S_ESCAPE)+;
fragment NON_DIGIT : [_a-zA-Z];
fragment DIGIT :  [0-9];
fragment Q_CHAR : NON_DIGIT | DIGIT | [!#$%&()*+,-./:;<>=?@[\]^{}|~ "];
fragment S_ESCAPE : '\\' ('’' | '\'' | '"' | '?' | '\\' | 'a' | 'b' | 'f' | 'n' | 'r' | 't' | 'v');
STRING : '"' (S_CHAR | S_ESCAPE)* '"';
fragment S_CHAR : [\u0000-\u00FF];
UNSIGNED_INTEGER : DIGIT (DIGIT)*;
UNSIGNED_REAL :
    UNSIGNED_INTEGER ('.' UNSIGNED_INTEGER)
    | UNSIGNED_INTEGER  ( '.' UNSIGNED_INTEGER? )? [eE] [+-]? UNSIGNED_INTEGER
    | '.' UNSIGNED_INTEGER ( [eE] [+-]? UNSIGNED_INTEGER )?;
COMMENT :
    ('/' '/' .*? '\n' | '/*' .*? '*/') -> channel(HIDDEN);
WS  :   [ \r\n\t]+ -> skip ; // toss out whitespace
