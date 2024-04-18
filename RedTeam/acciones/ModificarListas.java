package acciones;
import java.util.Scanner;
import java.util.Arrays;
public class ModificarListas{
		
	Scanner scanner = new Scanner(System.in);
	Scanner scanner2 = new Scanner(System.in);
	verLista verLista1 = new verLista();
	    //variables de instancia
	    //lista general donde se encuentran todas las listas
		String[][] listasGeneral;		
		//que lista modificaremos
		protected int lista1, opcion;
		//que elemento
		protected int elemento;
		//posicion de la lista
		protected int elementoLugar;
		
//metodo mostrar listas
		public void mostrarListas(String [][] listasGeneral){
			if (listasGeneral.length>0){
				//System.out.println(listasGeneral.length);
				System.out.println("Listas disponibles");
				//mostrar listas guardadas listasGeneral
				for(int i=0; listasGeneral.length > i; i++){
					System.out.println("Lista: "+(i+1));
				}		
				System.out.println("¿Que lista modificaremos?");
				//scaner....
				while (true){
					if(scanner.hasNextInt()){						
						lista1 = scanner.nextInt();
						if(lista1<=listasGeneral.length){
							//mostrar la lista
							System.out.println("Lista "+ lista1);
							for(int i=0; listasGeneral[lista1-1].length > i; i++){
								System.out.println("Elemento "+ (i+1)+ "= "+ listasGeneral[lista1-1][i]);		
							}break;
						} else{
							System.out.println("Numero de lista inexistente intente nuevamente: ");
						}
					} else{
						System.out.println("Ingrese un número entero: ");
						scanner.next();
					}
				}
				//preguntar cambiar lugar, actualizar nombre de elemento, borrar elemento, agregar elemento
				//dependiendo lo que quiera se llama al metodo
				while (true) {
					System.out.println("Hola, Elija la accion que desea realizar en la lista:");
					System.out.println("1. Cambiar de posicion un elemento");
					System.out.println("2. Actualizar el valor de un elemento");
					System.out.println("3. Borrar un elemento");
					System.out.println("4. Agregar un elemento");
					System.out.println("5. Regresar al menu principal");
					
					if(scanner.hasNextInt()){
						int opcion = scanner.nextInt();							
						if (opcion == 5) {
							System.out.println("Saliendo de modificar lista.");
							break;
						}
						switch (opcion) {
							case 1:
								cambiarLugar(listasGeneral, lista1);
								break;
							case 2:
								actualizarElemento(listasGeneral, lista1);
								break;
							case 3:
								borrarElemento(listasGeneral, lista1);
								break;
							case 4:
								agregarElemento(listasGeneral, lista1);
								break;
							default:
								System.out.println("Opción no válida. Por favor, elija una acción válida.");
								continue;
						}
						String respuesta;
						while (true) {
							System.out.print("¿Desea realizar otra acción? (Si/No): ");
							respuesta = scanner.next().toLowerCase();
							if (respuesta.equals("si")) {
								break; // Sale del bucle
							} else if (respuesta.equals("no")) {
								System.out.println("Saliendo de modificar lista");
								break;
							} else {
								System.out.println("Por favor, ingrese 'si' o 'no'.");
							}
						}
						if (respuesta.equals("no")) {
							break; // Sale del bucle externo
						}            
					}else{
					 System.out.println("Opción no válida. Por favor, elija una acción válida.");
					 scanner.nextLine();
					}
				}
			}else{
				System.out.println("Aun no se encuentran listas registradas");
			}
		
		}
//metodo cambiar lugar
		String[] cambiarLugar(String[][] listaGeneral, int lista1){			
			while(true){
				System.out.println("¿Que valor desea cambiar de lugar?");				
				if(scanner.hasNextInt()){
					int opcion2 = scanner.nextInt();					
					if(listaGeneral[lista1-1].length>=opcion2){
					//scanner.nextLine();					
						while(true){
							System.out.println("¿Por cual valor se deberia de cambiar?");						
							if(scanner.hasNextInt()){					
									int opcion3 = scanner.nextInt();
								if(listaGeneral[lista1-1].length>=opcion3){			
									String a=listaGeneral[lista1-1][opcion2-1]; /// el que se va a cambiar
									String b=listaGeneral[lista1-1][opcion3-1]; //nuevo valor			
									System.out.println("Nueva Lista");
					
									for(int i=0; listaGeneral[lista1-1].length > i; i++){
										if(listaGeneral[lista1-1][i]==listaGeneral[lista1-1][opcion2-1]){
											listaGeneral[lista1-1][opcion2-1]=b;
										}
										if(listaGeneral[lista1-1][i]==listaGeneral[lista1-1][opcion3-1]){
											listaGeneral[lista1-1][opcion3-1]=a;
										}
										System.out.println("Elemento "+ (i+1)+ "= "+ listaGeneral[lista1-1][i]);
										} 					
										break;					
								}else{
									//segundo numero	
									System.out.println("Elemento fuera de la lista, ingrese un numero de elemento correcto");
								}
							}else{
								System.out.println("Ingrese un numero entero");
								scanner.next();
							}
						}
						break;									
					}else{
						//primer numero
						System.out.println("Elemento fuera de la lista, ingrese un numero de elemento correcto");
					}
				}else{
					System.out.println("Ingrese un numero entero");
					scanner.next();
				}
			}return listaGeneral[lista1-1];
		}		
//metodo actualizar nombre
		String[] actualizarElemento(String[][] listaGeneral, int opcion){			
			while (true) {				
				System.out.println("¿Que elemento desea actualizar?");			
				if(scanner.hasNextInt()){
					int opcion2 = scanner.nextInt();
					if(listaGeneral[lista1-1].length>=opcion2){
						System.out.println("¿Cual seria el nuevo valor del elemento?");					
						String opcion4 = scanner2.nextLine();			
						String a=opcion4; /// el que se va a cambiar string			
						System.out.println("Nueva Lista");			
						for(int i=0; listaGeneral[lista1-1].length > i; i++){
							if(listaGeneral[lista1-1][i]==listaGeneral[lista1-1][opcion2-1]){
								listaGeneral[lista1-1][opcion2-1]=a;
							}				
							System.out.println("Elemento "+ (i+1)+ "= "+ listaGeneral[lista1-1][i]);
						}
						break;						
					}else{						
							System.out.println("Elemento fuera de la lista, ingrese el numero del elemento correcto");
						}
				}else{
					System.out.println("Ingrese un numero entero");
					scanner.next();
				}
			}return listaGeneral[lista1-1];
		}		
///metodo borrar elemento
		String[] borrarElemento(String[][] listaGeneral, int opcion){
		//instanciamos nueva matris para almacenar y ordenar nuevos valores
			String [][] listaGeneral1 = new String [listaGeneral.length][listaGeneral[lista1-1].length-1];
			while (true) {				
				System.out.println("¿Que elemento desea borrar?");			
				if(scanner.hasNextInt()){
					int opcion5 = scanner.nextInt();
					if(listaGeneral[lista1-1].length>=opcion5){
					//for para encontrar el valor a eliminar
						System.out.println("Nueva Lista");
						for(int i=0; listaGeneral[lista1-1].length > i; i++){
							if(i==(opcion5-1)){
								//una vez dentro del dato a eliminar recorremos cada valor hasta la posicion exacta y cuando esta sea diferente
								//igualamos si no seguimos adelante
								int j, h=0;								
								for(j=0; j<listaGeneral[lista1-1].length; j++){									
									if(j!=i){
										listaGeneral1[lista1-1][h]=listaGeneral[lista1-1][j];
										//mostramos nueva lista con dato borrado
										System.out.println("Elemento " + (1+h) + "= " +listaGeneral1[lista1-1][h]); 
										h++;
									}
								}
							}	
						}break;					
					}else{
						System.out.println("Elemento fuera de la lista, ingrese un numero de elemento correcto");
					}
				}else{
					System.out.println("Ingrese un numero entero");
					scanner.next();
				}
			}
			listaGeneral[lista1-1]=listaGeneral1[lista1-1];
			return listaGeneral[lista1-1];
		}
// metodo agregar elemento
		String[] agregarElemento(String[][] listaGeneral, int opcion){
			System.out.println("¿Cual seria el nuevo elemento de la lista?");
			String nuevoValor = scanner2.nextLine();			
			String [][] listaGeneral1 = new String [listaGeneral.length][listaGeneral[lista1-1].length+1];
			System.out.println("Nueva Lista");			
			for(int i=0; listaGeneral1[lista1-1].length > i; i++){
				if(listaGeneral[lista1-1].length > i){
					listaGeneral1[lista1-1][i]=listaGeneral[lista1-1][i];					   
				}else {
					listaGeneral1[lista1-1][i]=nuevoValor;
				} 				
				System.out.println("Elemento " + (i+1) + "= " + listaGeneral1[lista1-1][i]);
			}
			listaGeneral[lista1-1]=listaGeneral1[lista1-1];
			return listaGeneral[lista1-1];
		}
}

	