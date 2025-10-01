import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String tipoMoneda;
        Conversor conversor = new dolarAdapter(new conversorDolar());
        calculadora calcular = new calculadora();
        System.out.println("Ingrese la el primer cantidad: ");
        double a = Double.parseDouble(sc.nextLine());
        System.out.print("¿que tipo de moneda es? ");
        tipoMoneda = sc.nextLine();

        if (tipoMoneda.equalsIgnoreCase("pesos")) {
            a = conversor.convertirDolar(a);
        } else {
            System.out.println("Tipo de moneda no soportada");
        }
        
        System.out.println("Ingrese la el segundo cantidad: ");
        double b = Double.parseDouble(sc.nextLine());
        System.out.print("¿que tipo de moneda es? ");
        tipoMoneda = sc.nextLine();
        if (tipoMoneda.equalsIgnoreCase("pesos")) {
            b = conversor.convertirDolar(b);
        } else {
            System.out.println("Tipo de moneda no soportada");
        }
        double resultado = calcular.sumar(a, b);
        System.out.println("El resultado de la suma es: " + resultado + " dolares");
        System.out.println("El resultado de la suma es: " + conversor.convertirPeso(resultado) + " COP");
    }
}
