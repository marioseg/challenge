import acciones.*;
import java.util.Scanner;

public class PrincipalMatricial {
private static verLista lista = new verLista(); // Instancia única de Lista
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		ModificarListas Modificar = new ModificarListas(); 
		String [][] listaGen=new String [0][];		
       	//Lista uno = new Lista(scanner);
		String nombre;		
        System.out.print("Ingrese su nombre: ");
        nombre = scanner.nextLine();  

        while (true) {
            System.out.println("Hola, " + nombre + ". Elija la accion que desea realizar:");
            System.out.println("1. Crear lista");
            System.out.println("2. Ver lista");
            System.out.println("3. Modificar lista");
            System.out.println("4. Salir");
			
			if(scanner.hasNextInt()){
				int opcion=scanner.nextInt();
				
				if (opcion == 4) {
					System.out.println("Saliendo del programa. ¡Hasta luego, " + nombre + "!");
					System.out.println("\nChambiadores : Gio, Samuel, Erik, Norma, Abdo, Paloma.");
					break;
				}
            switch (opcion) {
                case 1:
                    /*crear lista*/
					while (true){
						lista.parametros(); // Establecer los parámetros de la lista
						String[] nuevaLista = lista.crearLista(); // Crear la lista
						lista.crearNombre(); // Agregar el nombre de la lista
						listaGen=lista.agregarLista(nuevaLista); // Agregar la lista a listOfLists						
						String respuesta;
						while (true) {
							System.out.print("¿Desea realizar alguna otra lista? (Si/No): ");
							respuesta = scanner.next().toLowerCase();
							if (respuesta.equals("si")) {
								break; // Sale del bucle
							} else if (respuesta.equals("no")) {
								System.out.println("Saliendo de crear lista.");
								break;
							} else {
								System.out.println("Por favor, ingrese 'si' o 'no'.");
							}
						}
						if (respuesta.equals("no")) {
							break; // Sale del bucle externo
						}
					}
                    break;
                case 2:
                    /*ver lista*/
                    while (true){
						lista.mostrarListas();// Mostrar las listas existentes
						System.out.print("Por favor, elija el número de la lista que desea visualizar: ");
						if (scanner.hasNextInt()){
							int numeroLista = scanner.nextInt();
							lista.mostrarElementosLista(numeroLista);
							System.out.print("¿Desea ver otra lista? (Si/No): ");
							String respuesta = scanner.next().toLowerCase();
							
							if (!respuesta.equals("si")) {
								System.out.println("Saliendo de ver listas.");
								break;
								}
						}else{
							System.out.println("Ingrese un número entero: ");
							scanner.next();
						}
					}		
                    break;
                case 3:
                    /*modificar lista*/
					Modificar.mostrarListas(listaGen);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una accion válida.");
                    continue;
            }
          	String respuesta;
			while (true) {
				System.out.print("¿Desea Regresar al menu principal (1) o salir del programa (2)?");
				respuesta = scanner.next().toLowerCase();
				if (respuesta.equals("1")) {
					break; // Sale del bucle
				} else if (respuesta.equals("2")) {
					System.out.println("Saliendo del programa. ¡Hasta luego, " + nombre + "!");
					System.out.println("\nChambiadores : Gio, Samuel, Erik, Norma, Abdo, Paloma." );
					return;
				} else {
					System.out.println("Por favor, ingrese '1' o '2'.");
				}
			}            
        }
		else{
				scanner.nextLine();
				System.out.println("Por favor elija una opción válida: ");
			}
		}
        scanner.close();
	}
}
