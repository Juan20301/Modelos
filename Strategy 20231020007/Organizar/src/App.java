import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Persona> personas = new ArrayList<>();
        boolean opcion = true;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Seleccione una opcion: 1. Agregar persona 2. Ordenar Mayor a menor 3. Ordenar Menor a mayor 4. Salir");
            int seleccion = scanner.nextInt();
            switch (seleccion) {
                case 1:
                    System.out.println("Ingrese el nombre:");
                    String nombre = scanner.next();
                    System.out.println("Ingrese la cedula:");
                    int cedula = scanner.nextInt();
                    personas.add(new Persona(nombre, cedula));
                    break;
                case 2:
                    Ordenar ordenarMayor = new Mayor();
                    ordenarMayor.ordenar(personas);
                    for (Persona p : personas) {
                        System.out.println("\nNombre: " + p.getNombre() + ", Cedula: " + p.getCedula());
                    }
                    break;
                case 3:
                    Ordenar ordenarMenor = new Menor();
                    ordenarMenor.ordenar(personas);
                    for (Persona p : personas) {
                        System.out.println("\nNombre: " + p.getNombre() + ", Cedula: " + p.getCedula());
                    }
                    break;
                case 4:
                    opcion = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }while(opcion == true);
    }
}
