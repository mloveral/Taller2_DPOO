package uniandes.dpoo.estructuras.logica;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
        int[] copia = new int[]{};
        copia = this.arregloEnteros;
    	return copia;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
        String[] copia = new String[]{};
        copia = this.arregloCadenas;
    	return copia;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        int cantidad = this.arregloEnteros.length;
    	return cantidad;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        int cantidad = this.arregloCadenas.length;
    	return cantidad;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	int nuevoTamanio = this.getCantidadEnteros() + 1;
    	int[] nuevo = Arrays.copyOf(this.arregloEnteros, nuevoTamanio);
    	nuevo[nuevoTamanio-1] = entero;
    	this.arregloEnteros = nuevo;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	int nuevoTamanio = this.getCantidadCadenas() + 1;
    	String[] nuevo = Arrays.copyOf(this.arregloCadenas, nuevoTamanio);
    	nuevo[nuevoTamanio-1] = cadena;
    	this.arregloCadenas = nuevo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int cantidadValor = this.contarApariciones(valor);
    	if (cantidadValor != 0)
    	{
    		int[] nuevoArreglo = new int[this.getCantidadEnteros()-cantidadValor];
        	int i = 0;
        	for (int num: this.arregloEnteros)
        	{
        		if (num != valor)
        		{
        			nuevoArreglo[i] = num;
        			i++;
        		}
        	}
        	this.arregloEnteros = nuevoArreglo;
    	}
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int cantidadCadena = 0;
    	for (String c: this.arregloCadenas)
    	{
    		if (c.equals(cadena))
    		{
    			cantidadCadena++;
    		}
    	}
    	if (cantidadCadena != 0)
    	{
    		String[] nuevoArreglo = new String[this.getCantidadCadenas()-cantidadCadena];
        	int i = 0;
        	for (String c: this.arregloCadenas)
        	{
        		if (!c.equals(cadena))
        		{
        			nuevoArreglo[i] = c;
        			i++;
        		}
        	}
        	this.arregloCadenas = nuevoArreglo;
    	}
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	//Crear un arreglo con una posición extra del arreglo actual
    	int listaSize = this.getCantidadEnteros();
    	int[] nuevoArreglo = new int[listaSize + 1];
    	// Asegurarse que la posición este por dentro del rango del arreglo
    	int pos = posicion;
    	if (pos < 0)
    	{
    		pos = 0;
    	} else if (pos > listaSize)
    	{
    		pos = listaSize;
    	}
    	// Recorrer la lista y añadir los valores hasta antes de la posición
    	int i = 0;
    	while (i < pos)
    	{
    		nuevoArreglo[i] = this.arregloEnteros[i];
    		i++;
    	}
    	// Añadir el elemento a la posición dada
    	nuevoArreglo[i] = entero;
    	i++;
    	// Terminar de agregar los elementos restantes
    	while (i < listaSize + 1)
    	{
    		nuevoArreglo[i] = this.arregloEnteros[i - 1];
    		i++;
    	}
    	// Cambiar la lista de enteros por la nueva lista
    	this.arregloEnteros = nuevoArreglo;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	int tamanioArreglo = this.getCantidadEnteros();
    	if (posicion < tamanioArreglo && posicion >= 0)
    	{
    		int[] nuevoArreglo = new int[this.getCantidadEnteros() - 1];
        	int resta = 0;
        	for (int i = 0; i < tamanioArreglo; i++)
        	{
        		if (i != posicion)
        		{
        			nuevoArreglo[i - resta] = this.arregloEnteros[i];
        		}
        		else
        		{
        			resta++;
        		}
        	}
    	}
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int[] nuevo = new int[valores.length];
    	int i = 0;
    	for (double v: valores)
    	{
    		nuevo[i] = (int) v;
    		i++;
    	}
    	this.arregloEnteros = nuevo;
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	String[] nuevo = new String[objetos.length];
    	int i = 0;
    	for (Object obj: objetos)
    	{
    		nuevo[i] = obj.toString();
    		i++;
    	}
    	this.arregloCadenas = nuevo;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	int tamanioArreglo = this.getCantidadEnteros();
    	int currentNum = 0;
    	for (int i = 0; i < tamanioArreglo; i++)
    	{
    		currentNum = this.arregloEnteros[i];
    		if (currentNum < 0)
    		{
    			currentNum = currentNum * (-1);
    			this.arregloEnteros[i] = currentNum;
    		}
    	}
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	Arrays.sort(this.arregloEnteros);
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	Arrays.sort(this.arregloCadenas);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
        int counter = 0;
        for (int num: this.arregloEnteros)
        {
        	if (num == valor)
        	{
        		counter++;
        	}
        }
    	return counter;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
        int counter = 0;
        for (String c: this.arregloCadenas)
        {
        	if (c.equalsIgnoreCase(cadena))
        	{
        		counter++;
        	}
        }
    	return counter;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
        int tamanio = 0;
        int tamanioEnteros = this.getCantidadEnteros();
        int[] arreglo = new int[] {};
        for (int i = 0; i < tamanioEnteros; i++)
        {
        	int num = this.arregloEnteros[i];
        	if (num == valor)
        	{
        		tamanio++;
        		arreglo = Arrays.copyOf(arreglo, tamanio);
        		arreglo[tamanio - 1] = i;
        	}
        }
    	return arreglo;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
        int tamanio = this.getCantidadEnteros();
        int[] nuevo;
        if (tamanio == 0)
        {
        	nuevo = new int[] {};
        }
        else
        {
        	nuevo = new int[2];
        	nuevo[0] = this.arregloEnteros[0];
        	nuevo[1] = this.arregloEnteros[0];
        	for (int num: this.arregloEnteros)
        	{
        		if (num < nuevo[0])
        		{
        			nuevo[0] = num;
        		} else if (num > nuevo[1])
        		{
        			nuevo[1] = num;
        		}
        	}
        }
    	return nuevo;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
        return null;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	//Inicialización del contador de repetidos y el contador de apariciones de un número
    	int counter = 0, apariciones = 0;
    	//Verificar que el arreglo no este vacío
    	if (this.getCantidadEnteros() != 0)
    	{
    		int currentNum = this.arregloEnteros[0];
            boolean added = false;
            //Hacer una copia del arreglo para organizarla e iterar sobre ella
        	int[] copia = Arrays.copyOf(arregloEnteros, this.getCantidadEnteros());
        	Arrays.sort(copia);
        	for (int num : copia)
        	{
        		//Si el número es igual al número anterior, se sube el contador de apariciones y repeticiones
        		if (num == currentNum)
        		{
        			apariciones++;
        			if (!added && apariciones>1)
        			{
        				counter++;
        			}
        		}
        		else
        		{
        			// Si el número es diferente al anterior, se actualiza el valor de la variable
        			// currentNum y se resetea el contador a 1
        			currentNum = num;
        			apariciones = 1;
        		}
        	}
    	}
        
    	return counter;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
        return false;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
        boolean iguales = false;
    	int equal = Arrays.compare(this.arregloEnteros, otroArreglo);
        if (equal == 0)
        {
        	iguales = true;
        }
    	return iguales;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {

    }

}
