//la clase lista pertenece al paquete clases
package Clases; 
//importa la clase ArrayList
import java.util.ArrayList;

public class Lista {
	//declara la variable privada para guardar el nombre de la lista
    private String nombre;
	//declara una variable para guardar los elemntos de la lista
    private ArrayList<String> elementos;

	//constructor de la clase lista, recibe el nombre d ela lista y la cantidad de elementos
    public Lista(String nombre, int numElementos) {
        //asigna el nombre de la lista al atributo nombre de la clase
		this.nombre = nombre;
		//inicializa el atributo elementos como un nuevo arrayList
        this.elementos = new ArrayList<>();
		//bucle que recorre de 0 hasta la cantidad de elementos (esto se modifico para agregar un nuevo elemento)
        for (int i = 0; i < numElementos; i++) {
            elementos.add(null);
        }
    }

    //metodo getter que devuelve el nombre de la lista
	public String getNombre() {
        //devuelve el nombre de la lista almacenado en el atributo nombre
		return nombre;
    }

    //metodo setter que establece el nombre de la lista
	public void setNombre(String nombre) {
        //asigna el nuevo nombre de la lista al atributo nombre
		this.nombre = nombre;
    }

	//metodo getter que devuelve el elemento en la posici[on indice 
    public String getElemento(int indice) {
        //devuelve el elemento en la posicion indice de la lista elementos
		return elementos.get(indice);
    }

	//metodo setter que establece el elemento en la pocision indice 
    public void setElemento(int indice, String elemento) {
        elementos.set(indice, elemento);
    }

	//metodo getter que devuelve la lista completa de elementos almacenados en el atributo elementos
    public ArrayList<String> getElementos() {
        return elementos;
    }

	//metodo setter que agrega un elemento a la lista
    public void add(String elemento) {
        //agrega el elemento a la lista elementos
		elementos.add(elemento);
    }

	//metodo getter quq devuelve el n[umero de elementos de la lista
    public int getNumElementos() {
        return elementos.size();
    }
}