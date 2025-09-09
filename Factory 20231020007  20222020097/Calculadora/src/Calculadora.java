import java.util.Scanner;
public class Calculadora{

    public static void main(String[] args) {
        Cliente clienteSuma = new Cliente(new FSuma());
        Cliente clienteResta = new Cliente(new FResta());
        Cliente clienteMultiplicacion = new Cliente(new FMultiplicacion());
        Cliente clienteDivision = new Cliente(new FDivision());
        
        Scanner scanner = new Scanner(System.in);
        double resultado;
        
        System.out.println("Ingrese una operacion: \n "
                + "1. Suma\n"
                + "2. Resta\n"
                + "3. Multiplicacion\n"
                + "4. Division\n");    
        
        int decision = scanner.nextInt();
        
        System.out.println("Ahora ingrese dos numeros: ");
        float n1 = scanner.nextFloat();
        float n2 = scanner.nextFloat();
        
        
        switch (decision){
            case 1:
                resultado = clienteSuma.ejecutarOPeracion(n1, n2);
                System.out.println("Resultado: "+resultado);
                break;
            case 2:
                resultado = clienteResta.ejecutarOPeracion(n1, n2);
                System.out.println("Resultado: "+resultado);
                break;
            case 3:
                resultado = clienteMultiplicacion.ejecutarOPeracion(n1, n2);
                System.out.println("Resultado: "+resultado);
                break;
            case 4:
                resultado = clienteDivision.ejecutarOPeracion(n1, n2);
                System.out.println("Resultado: "+resultado);
                break;
            default: 
                System.out.println("Ingrese un numero correcto");
        }
    }
}
