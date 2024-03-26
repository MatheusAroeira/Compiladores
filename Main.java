public class Main {
    public static void main(String[] args) {

        String input = " \"chupa arthur\" ";
        AnalisadorLexico al = new AnalisadorLexico(input.split(" "));
        al.generateList();
        String ts = al.getTabelaSimb();
        String lt = al.getListTokens();
        System.out.println(ts);
        System.out.println(lt);
        
    }
    
}
