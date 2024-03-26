public class Main {
    public static void main(String[] args) {

        String input = "int x = 10 ;";
        AnalisadorLexico al = new AnalisadorLexico(input.split(" "));
        String ts = al.getTabelaSimb();
        String lt = al.getListTokens();
        System.out.println(ts);
        System.out.println(lt);
        
    }
    
}
