import Clases.Lista;
import Clases.ListaManager;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaManager listaManager = new ListaManager();
        
        int opcion;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Crear lista");
            System.out.println("2. Ver listas");
            System.out.println("3. Modificar lista");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    listaManager.crearLista(scanner);
                    break;
                case 2:
                    listaManager.verListas();
                    break;
                case 3:
                    listaManager.modificarLista(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 4);
        
        scanner.close();
    }
}