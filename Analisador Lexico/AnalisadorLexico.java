import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalisadorLexico {
    private String[] pReserv;
    private String[] operadores;
    private String[] simb;
    private ArrayList<String> tabelaSimb;
    private ArrayList<String> listTokens;
    private String lex;
    private String simbolo;
    private int id;
    private int index;
    private String[] line;

    public AnalisadorLexico(String[] line) {
        pReserv = new String[] { "int", "float", "char", "boolean", "void", "if", "else", "for", "while", "scanf",
                "println", "main", "return" };
        operadores = new String[] { "=", "+", "-", "*", "/", "%", "&&", "||", "!", ">", ">=", "<", "<=", "!=", "==" };
        simb = new String[] { "(", ")", "[", "]", "{", "}", ",", ";" };
        tabelaSimb = new ArrayList<String>();
        listTokens = new ArrayList<String>();
        lex = "";
        simbolo = "";
        id = 0;
        this.line = line;
    }

    public void generateList() {
        for (int i = 0; i < line.length; i++) {
            if (isNum(line[i])) {
                listTokens.add("NUM_INT_" + line[i]);
            } else if (isDecimal(line[i])) {
                listTokens.add("NUM_DECIMAL_" + line[i]);
            } else if (isOp(line[i])) {
                listTokens.add(line[i]);
            } else if (isPalavraReservada(line[i])) {
                listTokens.add(line[i]);
            } else if (isString(line[i])) {
                listTokens.add("LITERAL_" + line[i]);
            } else if (isStringComp(line[i])) {
                Pattern strCompF = Pattern.compile("\"[a-zA-Z]+");
                String stringConcat = "";
                for (int j = i; j < line.length; j++) {
                    Matcher matcherCompF = strCompF.matcher(line[j]);
                    stringConcat += " " + line[j];
                    if (matcherCompF.matches()) {
                        i = j;
                        break;
                    }
                }
                listTokens.add("LITERAL_" + stringConcat);

            } else if (isSimb(line[i])) {
                listTokens.add(line[i]);
            } else if (isId(line[i])) {
                if (!tabelaSimb.contains(line[i])) {
                    tabelaSimb.add(line[i]);
                    id++;
                    listTokens.add("ID_" + id);
                } else {
                    listTokens.add("ID_" + (tabelaSimb.indexOf(line[i]) + 1));
                }
            } else if (isComment(line[i])) {
                continue;
            } else if (line[i].equals("")) {
                continue;
            } else if (line[i].equals("\n")) {
                continue;
            } else {
                throw new RuntimeException("Token Invalido");
            }
        }
    }

    public boolean isString(String lex) {
        Pattern str = Pattern.compile(" \"[a-zA-Z]+\"");
        Matcher matcher = str.matcher(lex);
        return matcher.matches();
    }

    public boolean isStringComp(String lex) {
        Pattern strComp = Pattern.compile("\"[a-zA-Z]+");
        Matcher matcherComp = strComp.matcher(lex);
        return matcherComp.matches();
    }

    public boolean isId(String lex) {
        Pattern id = Pattern.compile("[a-zA-Z_][a-zA-Z0-9_]*");
        Matcher matcher = id.matcher(lex);
        return matcher.matches();
    }

    public boolean isNum(String lex) {
        Pattern id = Pattern.compile("[0-9]+");
        Matcher matcher = id.matcher(lex);
        return matcher.matches();
    }

    public boolean isDecimal(String lex) {
        Pattern id = Pattern.compile("[0-9].[0-9]*");
        Matcher matcher = id.matcher(lex);
        return matcher.matches();
    }

    public boolean isComment(String lex) {
        Pattern com = Pattern.compile("//[a-zA-Z]\n*");
        Matcher matcher = com.matcher(lex);
        return matcher.matches();
    }

    public boolean isPalavraReservada(String lex) {
        for (String str : pReserv) {
            if (str.equals(lex)) {
                return true;
            }
        }
        return false;
    }

    public boolean isOp(String lex) {

        for (String str : operadores) {
            if (str.equals(lex)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSimb(String lex) {
        for (String str : simb) {
            if (str.equals(lex)) {
                return true;
            }
        }
        return false;
    }

    public String getpReserv() {
        return this.pReserv.toString();
    }

    public String getOperadores() {
        return this.operadores.toString();
    }

    public String getSimb() {
        return this.simb.toString();
    }

    public String getTabelaSimb() {
        return this.tabelaSimb.toString();
    }

    public String getListTokens() {
        return this.listTokens.toString();
    }

    public String getLex() {
        return this.lex;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public int getId() {
        return this.id;
    }

    public int getIndex() {
        return this.index;
    }

    public void setLex(String lex) {
        this.lex = lex;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getLine() {
        return line.toString();
    }

}
