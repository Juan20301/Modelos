import java.util.Scanner;
public class EntradaTeclado extends Entrada {
    
    private Scanner sc;
    public EntradaTeclado() {
        sc = new Scanner(System.in);
    }
    
    @Override
    public String recibir() {
        return sc.nextLine();
    }


}
