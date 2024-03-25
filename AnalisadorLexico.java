import java.util.ArrayList;
import java.util.regex.Pattern;
public class AnalisadorLexico {
    private Pattern identificador = Pattern.compile("[a-zA-Z][a-zA-Z0-9]*");
    private String[] pReserv;
    private String[] operadores;
    private String[] simb;
    private ArrayList<String> tabelaSimb;
    private ArrayList<String> listTokens;
    private String lex;
    private String simbolo;
    private int id;
    private int index;
    private int[] alfNum;
    private char[] alfChar;
    private String line;

    public AnalisadorLexico(String line) {
        pReserv = new String[]{"int","float","char","boolean","void","if","else","for","while","scanf","println","main","return"};
        operadores = new String[]{"=", "+", "-", "*", "/", "%", "&&", "||", "!", ">", ">=", "<", "<=", "!=", "=="};
        simb = new String[]{"(", ")", "[", "]", "{", "}", ",", ";","'"};
        tabelaSimb = new ArrayList<String>();
        listTokens = new ArrayList<String>();
        lex = "";
        simbolo = "";
        id = 0;
        alfNum = new int[]{0,1,2,3,4,5,6,7,8,9};
        alfChar = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
        'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        this.line = line;
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

    public ArrayList<String> getTabelaSimb() {
        return this.tabelaSimb;
    }

    public ArrayList<String> getListTokens() {
        return this.listTokens;
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

    public String getAlfNum() {
        return this.alfNum.toString();
    }

    public String getAlfChar() {
        return this.alfChar.toString();
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
        return this.line;
    }


    
}
