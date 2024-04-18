package Clases;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaManager {	
	/*Instanciacion de un arreglo de arreglos*/
    private ArrayList <Lista> listas = new ArrayList<>();
    
	/*Metodo setter para crear lista*/
	/*Tipo de dato Scanner*/
	
	
	
    public void crearLista(Scanner scanner) {
        System.out.print("Ingrese el nombre de la lista: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el número de elementos: ");
        int numElementos = scanner.nextInt();
        
        Lista lista = new Lista(nombre, numElementos);
        for (int i = 0; i < numElementos; i++) {
            System.out.print("Ingrese el elemento " + (i + 1) + ": ");
            String elemento = scanner.next();
			
			/*Invocación al metodo setElemento de la del objeto lista*/
            lista.setElemento(i, elemento);
       

	   }
        // esto no lo hemos visto es propio de arraylit
		// .add es método dentro de la clase ArrayList
        listas.add(lista);
		
		// 0 lista
		// 1 lista 2
		// 2 lista 3
		
		
    }
    
    public void verListas() {
        System.out.println("\nListas creadas:");
        for (int i = 0; i < listas.size(); i++) {
            System.out.println((i + 1) + ". " + listas.get(i).getNombre()); //. get(int) le decimos que elemento del arreglo queremos trabajar y .getNombre son propios de arrayList
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione una lista para ver sus elementos: ");
        int indiceLista = scanner.nextInt();
        
		/*Lista con L mayuscula es tipo de dato*/
        Lista listaSeleccionada = listas.get(indiceLista - 1);
		
		
        System.out.println("\nElementos de la lista " + listaSeleccionada.getNombre() + ":");
        for (int i = 0; i < listaSeleccionada.getNumElementos(); i++) {
            System.out.println((i + 1) + ". " + listaSeleccionada.getElemento(i));
        }
    }
	
	
    
	public void modificarLista(Scanner scanner) {
    System.out.println("\nListas creadas:");
    for (int i = 0; i < listas.size(); i++) {
        System.out.println((i + 1) + ". " + listas.get(i).getNombre());
    }

    System.out.print("Seleccione una lista para modificar: ");
    int indiceLista = scanner.nextInt();
    Lista listaSeleccionada = listas.get(indiceLista - 1);
	
	
	/*Impresión de lista seleccionada para modificar Yisus Avila*/
	System.out.println("\nLa lista seleccionada es " + listaSeleccionada.getNombre() + ":");
        for (int i = 0; i < listaSeleccionada.getNumElementos(); i++) {
            System.out.println((i + 1) + ". " + listaSeleccionada.getElemento(i));
        }
	
	
	int opcion;//pueblo
    do {//pueblo
    System.out.println("\n¿Qué acción desea realizar en la lista " + listaSeleccionada.getNombre() + "?");
    System.out.println("1. Cambiar de lugar un elemento");
    System.out.println("2. Actualizar el nombre de un elemento");
    System.out.println("3. Borrar un elemento");
    System.out.println("4. Agregar un nuevo elemento");
	System.out.println("5. Regresar al menu principal"); //pueblo
    System.out.print("Seleccione una opción: ");
    opcion = scanner.nextInt();

    switch (opcion) {
        case 1: 
            // Cambiar de lugar un elemento
            System.out.print("Ingrese el índice del elemento que desea mover: ");
            int indiceElemento = scanner.nextInt();
            System.out.print("Ingrese la nueva posición para el elemento: ");
            int nuevaPosicion = scanner.nextInt();
            if (indiceElemento >= 1 && indiceElemento <= listaSeleccionada.getNumElementos()
                    && nuevaPosicion >= 1 && nuevaPosicion <= listaSeleccionada.getNumElementos()) {
               

               //SE NECESITABA CREAR 2 "LISTAS" E INVOCAR LOS 2 METODOS CON LOS INDICES A CAMBIAR - IvanouskiR
			   String elemento = listaSeleccionada.getElemento(indiceElemento-1); 
			   String nuevoElemento = listaSeleccionada.getElemento(nuevaPosicion-1);
                listaSeleccionada.setElemento(nuevaPosicion-1, elemento );
				listaSeleccionada.setElemento(indiceElemento-1, nuevoElemento );
				
            } else {
                System.out.println("Índices inválidos. No se realizó ningún cambio.");
            }
			
			// Para impresión cada que hay un cambio YisusAvila
			System.out.println("\nLa lista nueva de " + listaSeleccionada.getNombre() + " es :");
			for (int i = 0; i < listaSeleccionada.getNumElementos(); i++) {
            System.out.println((i + 1) + ". " + listaSeleccionada.getElemento(i));
			}			
            break;
        case 2:
            // Actualizar el nombre de un elemento
            System.out.print("Ingrese el índice del elemento que desea actualizar: ");
            int indiceActualizar = scanner.nextInt();
            System.out.print("Ingrese el nuevo nombre para el elemento: ");
            String nuevoNombre = scanner.next();
            if (indiceActualizar >= 1 && indiceActualizar <= listaSeleccionada.getNumElementos()) {
                listaSeleccionada.setElemento(indiceActualizar - 1, nuevoNombre);
            } else {
                System.out.println("Índice inválido. No se realizó ninguna actualización.");
            }
			
			// Para impresión cada que hay un cambio YisusAvila
			System.out.println("\nLa lista nueva de " + listaSeleccionada.getNombre() + " es:");
			for (int i = 0; i < listaSeleccionada.getNumElementos(); i++) {
            System.out.println((i + 1) + ". " + listaSeleccionada.getElemento(i));
			}
			
            break;
        case 3:
            // Borrar un elemento
			System.out.print("Ingrese el índice del elemento que desea borrar: ");
			//el dato ingresado lo guarda en la variable indiceBorrar
			int indiceBorrar = scanner.nextInt();
			//verifica el rango que va desde 1 hasta la cantidad actual de elementos
			if (indiceBorrar >= 1 && indiceBorrar <= listaSeleccionada.getNumElementos()) {
				//bucle que comienza el indice de borrar hasta el final de la lista y luego mueve todos los elementos
				//un lugar atras sobrescribiendo el elemento en la posicion actual con el elemento siguiente
				for (int i = indiceBorrar; i < listaSeleccionada.getNumElementos(); i++) {
					listaSeleccionada.setElemento(i - 1, listaSeleccionada.getElemento(i));
				}
				//establece el [ultimo elemento de la lista como null, ahora se encuentra en una posicion duplicada
				listaSeleccionada.setElemento(listaSeleccionada.getNumElementos() - 1, null);
				//elimina el ultimo elemento de la lista que ahora es null utilizando remove de arraylist
				listaSeleccionada.getElementos().remove(listaSeleccionada.getNumElementos() - 1);
				System.out.println("Elemento eliminado exitosamente.");
			} else {
				//en caso de colocar un # de indice no valido
				System.out.println("Índice inválido. No se realizó ninguna eliminación.");
			}
			
			// Para impresión cada que hay un cambio YisusAvila (Se puede meter en un método)
			System.out.println("\nLa lista nueva de " + listaSeleccionada.getNombre() + " es:");
			for (int i = 0; i < listaSeleccionada.getNumElementos(); i++) {
            System.out.println((i + 1) + ". " + listaSeleccionada.getElemento(i));
			}
			
            break;
        case 4:
            // Agregar un nuevo elemento
			System.out.print("Seleccione el índice de la lista donde desea agregar el nuevo elemento: ");
			//el dato ingresado lo guarda de la variable inddice agregar
			int indiceAgregar = scanner.nextInt();
			//verifica el rango que va desde 1 hasta la cantidad actual de elementos +1
			if (indiceAgregar >= 1 && indiceAgregar <= listaSeleccionada.getNumElementos() + 1) {
			System.out.print("Ingrese el nuevo elemento: ");
			//el dato ingresado lo guarda en la variable nuevoElemento
			String nuevoElemento = scanner.next();
			//agrega el nuevo elemento en el espacio seleccionado de la lista. Se le resta 1 al indice
			listaSeleccionada.getElementos().add(indiceAgregar - 1, nuevoElemento);
			System.out.println("Elemento agregado exitosamente.");
			} else {
				//en caso de colocar un # de indice no valido
			System.out.println("Índice inválido. No se realizó ninguna adición.");
			}
            
			// Para impresión cada que hay un cambio YisusAvila
			System.out.println("\nLa lista nueva de " + listaSeleccionada.getNombre() + " es:");
			for (int i = 0; i < listaSeleccionada.getNumElementos(); i++) {
            System.out.println((i + 1) + ". " + listaSeleccionada.getElemento(i));
			}
			
			break;
		
		//se debe de agregar una opcion que nos regrese al menu inicial (pueblo)
		case 5:
            System.out.println("Regresando al menu principal....."); //pueblo		
            break;	
			
        default:
            System.out.println("Opción no válida. No se realizó ninguna acción.");
            break;
		}
	  } while (opcion != 5);
	}
}
   
