grammar comp;

programa         : declaracao* ;
declaracao       : declaracaoVariavel
                 | declaracaoFuncao
                 | declaracaoEstrutura
                 | comentario ;

declaracaoVariavel
                 : tipo ID ';'
                 | tipo ID '=' expressao ';' ;

tipo             : 'int'
                 | 'float'
                 | 'double'
                 | 'char'
                 | 'boolean' ;

declaracaoFuncao : tipo ID '(' parametros ')' bloco ;

parametros       : parametro (',' parametro)* ;
parametro        : tipo ID ('[]')? ('...')? ;

bloco            : '{' declaracao* '}' ;

comentario       : LINE_COMMENT
                 | BLOCK_COMMENT ;

expressao        : atribuicao
                 |expressaoLogica;

atribuicao       : ID '=' expressao
                 | ID '+=' expressao
                 | ID '-=' expressao
                 | ID '*=' expressao
                 | ID '/=' expressao
                 | ID '%=' expressao
                 | ID '&&=' expressao
                 | ID '||=' expressao
                 | ID '=' ID
                 | ID '+=' ID
                 | ID '-=' ID
                 | ID '*=' ID
                 | ID '/=' ID
                 | ID '%=' ID
                 | ID '&&=' ID
                 | ID '||=' ID ;

estruturaDeControle
                    :'if''('expressao')' bloco
                    |'if''('expressao')' bloco 'else' bloco
                    |'while''('expressao')' bloco
                    | 'for' '('expressao';'expressao';'expressao')' bloco
                    |'switch' '(' expressao ')' caseLista
                    |'break'';'
                    |'continue'';'
                    |'return' expressao ';' ;

arrays:
        ID '[' expressao ']'
        |ID '['']' ;
arrayInicializacao
        :'{'expressaoLista'}';

expressaoLista
        :

expressaoLogica
                    :expressaoRelacional
                    |expressaoLogica '&&' expressaoRelacional
                    |expressaoLogica '||' expressaoRelacional
                    |'!'expressaoRelacional;

expressaoRelacional
                    :expressaoAritmetica
                    |expressaoAritmetica'>'expressaoAritmetica
                    |expressaoAritmetica'>='expressaoAritmetica
                    |expressaoAritmetica'<'expressaoAritmetica
                    |expressaoAritmetica'<='expressaoAritmetica
                    |expressaoAritmetica'!='expressaoAritmetica
                    |expressaoAritmetica'=='expressaoAritmetica;

expressaoAritmetica
                    :expressaoMultiplicativa
                    |expressaoAritmetica '+' expressaoMultiplicativa
                    |expressaoAritmetica '-' expressaoMultiplicativa;

expressaoMultiplicativa
                    :expressaoUnaria
                    |expressaoMultiplicativa'*'expressaoUnaria
                    |expressaoMultiplicativa'/'expressaoUnaria
                    |expressaoMultiplicativa'%'expressaoUnaria;

expressaoUnaria
                    :expressaoPostfix
                    |'-'expressaoUnaria
                    |'++'expressaoPostfix
                    |'--'expressaoPostfix;

expressaoPostfix
                    :primaria
                    |primaria'['expressao']'
                    |primaria'(' argumentos')'
                    |primaria '.' ID
                    |primaria '->' ID;

argumentos
                    :expressaoLista
                    |;

primaria
                    :ID
                    |NUM_INT
                    |NUM_DEC
                    |TEXTO
                    |'('expressao')';


caseLista
        :caseDecl*;
caseDecl:
        'case' expressao ':' bloco
        | 'default' ':' bloco;





declaracaoEstrutura
                 : 'struct' ID '{' declaracaoVariavel* '}' ';' ;

ID               : [a-zA-Z_] [a-zA-Z_0-9]* ;
NUM_INT          : [0-9]+ ;
NUM_DEC          : [0-9]* '.' [0-9]+ ;
TEXTO            : '"' ~["\r\n]* '"' ;
LINE_COMMENT     : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT    : '/*' .*? '*/' -> skip ;
WS               : [ \t\r\n]+ -> skip ;
