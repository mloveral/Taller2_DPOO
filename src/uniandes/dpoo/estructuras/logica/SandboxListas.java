package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre listas de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos listaEnteros y listaCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre listas (ie., no haga cosas como construir arreglos para evitar la manipulación de listas).
 * 
 * Intente usar varias formas de recorrer las listas (while, for, for each, iteradores ... )
 */
public class SandboxListas
{
    /**
     * Una lista de enteros para realizar varias de las siguientes operaciones.
     */
    private List<Integer> listaEnteros;

    /**
     * Una lista de cadenas para realizar varias de las siguientes operaciones
     */
    private List<String> listaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxListas( )
    {
        listaEnteros = new ArrayList<Integer>( );
        listaCadenas = new LinkedList<String>( );
    }

    /**
     * Retorna una copia de la lista de enteros, es decir una nueva lista del mismo tamaño que contiene copias de los valores de la lista original
     * @return Una copia de la lista de enteros
     */
    public List<Integer> getCopiaEnteros( )
    {
        List<Integer> nuevaLista = new ArrayList<Integer>(this.listaEnteros);
    	return nuevaLista;
    }

    /**
     * Retorna una copia de la lista de cadenas, es decir una nueva lista del mismo tamaño que contiene copias de los valores de la lista original
     * @return Una copia de la lista de cadenas
     */
    public List<String> getCopiaCadenas( )
    {
        List<String> nuevaLista = new LinkedList<String>(this.listaCadenas);
    	return nuevaLista;
    }

    /**
     * Retorna un arreglo con los valores de la lista de enteros, es decir un arreglo del mismo tamaño que contiene copias de los valores de la lista
     * @return Una arreglo de enteros
     */
    public int[] getEnterosComoArreglo( )
    {
        int listaSize = this.getCantidadEnteros();
    	int[] arreglo = new int[listaSize];
        for (int i = 0; i < listaSize; i++)
        {
        	arreglo[i] = this.listaEnteros.get(i);
        }
    	return arreglo;
    }

    /**
     * Retorna la cantidad de valores en la lista de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        int cantidad = this.listaEnteros.size();
    	return cantidad;
    }

    /**
     * Retorna la cantidad de valores en la lista de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        int cantidad = this.listaCadenas.size();
    	return cantidad;
    }

    /**
     * Agrega un nuevo valor al final de la lista de enteros. Es decir que este método siempre debería aumentar en 1 el tamaño de la lista.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	this.listaEnteros.add(entero);
    }

    /**
     * Agrega un nuevo valor al final de la lista de cadenas. Es decir que este método siempre debería aumentar en 1 la capacidad de la lista.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	this.listaCadenas.add(cadena);
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro de la lista de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int numTemp = 0;
    	for(int i = 0; i < this.listaEnteros.size(); i++)
    	{
    		numTemp = this.listaEnteros.get(i);
    		if (numTemp == valor)
    		{
    			this.listaEnteros.remove(i);
    		}
    	}
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro de la lista de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	String cadTemp = "";
    	for (int i = 0; i < this.listaCadenas.size(); i++)
    	{
    		cadTemp = this.listaCadenas.get(i);
    		if (cadena.equals(cadTemp))
    		{
    			this.listaCadenas.remove(i);
    		}
    	}
    }

    /**
     * Inserta un nuevo entero en la lista de enteros
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en la lista aumentada. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño de la lista, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	int maxPosicion = this.getCantidadEnteros()-1;
    	if (maxPosicion < 0)
    	{
    		this.listaEnteros.add(entero);
    	}
    	else if (posicion < 0)
    	{
    		this.listaEnteros.addFirst(entero);
    	} 
    	else if (posicion > maxPosicion)
    	{
    		this.listaEnteros.addLast(entero);
    	} 
    	else
    	{
    		this.listaEnteros.add(posicion, entero);
    	}
    }

    /**
     * Elimina un valor de la lista de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición de la lista de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	if (0<= posicion && posicion < this.getCantidadEnteros())
    	{
    		this.listaEnteros.remove(posicion);
    	}
    }

    /**
     * Reinicia la lista de enteros con los valores contenidos en el parámetro 'valores', pero truncados.
     * 
     * Es decir que si el valor fuera 3.67, en la nueva lista debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	List<Integer> nListaEnteros = new ArrayList<Integer>();
    	for (double valor: valores)
    	{
    		Integer numInt = (int) valor;
    		nListaEnteros.add(numInt);
    	}
    	this.listaEnteros = nListaEnteros;
    }

    /**
     * Reinicia la lista de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarArregloCadenas( List<Object> objetos )
    {
    	List<String> nListaCadenas = new LinkedList<String>();
    	for (Object obj: objetos)
    	{
    		nListaCadenas.add(obj.toString());
    	}
    	this.listaCadenas = nListaCadenas;
    }

    /**
     * Modifica la lista de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	int listaSize = this.getCantidadEnteros();
    	int temp = 0;
    	for (int i = 0; i < listaSize; i++)
    	{
    		temp = this.listaEnteros.get(i);
    		if (temp < 0)
    		{
    			temp = temp *(-1);
    			this.listaEnteros.set(i, temp);
    		}
    	}
    }

    /**
     * Modifica la lista de enteros para que todos los valores queden organizados de MAYOR a MENOR.
     */
    public void organizarEnteros( )
    {
    	Collections.sort(this.listaEnteros);
    	Collections.reverse(this.listaEnteros);
    }

    /**
     * Modifica la lista de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	Collections.sort(this.listaCadenas);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en la lista de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
        int counter = 0;
        int currentNum = 0;
        for (Iterator<Integer> iterador = this.listaEnteros.iterator(); iterador.hasNext();)
        {
        	currentNum = iterador.next();
        	if (valor == currentNum)
        	{
        		counter++;
        	}
        }
    	return counter;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en la lista de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
        int counter = 0;
        String current = "";
        for (Iterator<String> iterador = this.listaCadenas.iterator(); iterador.hasNext();)
        {
        	current = iterador.next();
        	if (current.equalsIgnoreCase(cadena))
        	{
        		counter++;
        	}
        }
    	return counter;
    }

    /**
     * Cuenta cuántos valores dentro de la lista de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
        int repetidos = 0, currentNum = 0, apariciones = 0;
    	List<Integer> vistos = new ArrayList<Integer>();
        for (Iterator<Integer> iterador = this.listaEnteros.iterator(); iterador.hasNext();)
        {
        	currentNum = iterador.next();
        	if (!vistos.contains(currentNum))
        	{
        		apariciones = this.contarApariciones(currentNum);
        		if (apariciones > 1)
        		{
        			repetidos++;
        		}
        		vistos.add(currentNum);
        	}
        }
    	return repetidos;
    }

    /**
     * Compara la lista de enteros con un arreglo de enteros y verifica si contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos son los mismos y en el mismo orden y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
        boolean iguales = true;
        int len = this.getCantidadEnteros();
        if (otroArreglo.length != len)
        {
        	iguales = false;
        }
        int i = 0;
        while (iguales && i < len)
        {
        	if (otroArreglo[i] != this.listaEnteros.get(i))
        	{
        		iguales = false;
        	}
        }
    	return iguales;
    }

    /**
     * Cambia los elementos de la lista de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en la lista deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en la lista
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	this.listaEnteros.clear();
    	int randNum = 0;
    	for (int i = 0; i < cantidad; i++)
    	{
    		randNum = (int) (Math.random()*(maximo - minimo + 1)) + minimo;
    		this.listaEnteros.add(randNum);
    	}
    }

}
