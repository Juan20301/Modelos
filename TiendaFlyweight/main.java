import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tienda tienda = new Tienda();
        int opcion;

        do {
            System.out.println("\n=== MENU TIENDA FLYWEIGHT ===");
            System.out.println("1. Mostrar inventario");
            System.out.println("2. Comprar producto");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");

            while (!sc.hasNextInt()) {
                System.out.println("Ingrese un número valido.");
                sc.next();
            }

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> tienda.mostrarInventario();
                case 2 -> tienda.comprarProducto(sc);
                case 3 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 3);
        sc.close();
    }
}