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
        for (String str : line) {
            if (isNum(str)) {
                listTokens.add("NUM_INT," + str);
            } else if (isDecimal(str)) {
                listTokens.add("NUM_DECIMAL," + str);
            } else if (isOp(str)) {
                listTokens.add(str);
            } else if (isPalavraReservada(str)) {
                listTokens.add(str);
            } else if (isString(str)) {
                tabelaSimb.add(str);
                id++;
                listTokens.add("Id," + str);
            } else if (isSimb(str)) {
                listTokens.add(str);
            } else if (isId(str)) {
                tabelaSimb.add(str);
                id++;
                listTokens.add("Id," + str);
            } else {
                throw new RuntimeException("Token Invalido");
            }
        }
    }

    public boolean isString(String lex) {
        Pattern str = Pattern.compile("\"[a-zA-Z]+\"");
        Matcher matcher = str.matcher(lex);
        return matcher.matches();
    }

    public boolean isId(String lex) {
        Pattern id = Pattern.compile("[a-zA-Z][a-zA-Z0-9]*");
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
