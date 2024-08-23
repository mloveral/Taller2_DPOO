package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
    	List <String> valores = new ArrayList<String>();
    	if(!this.mapaCadenas.isEmpty())
    	{
    		SortedSet<String> llaves = new TreeSet<>(this.mapaCadenas.keySet());
    		String valor = null;
    		for (Iterator<String> iterador = llaves.iterator(); iterador.hasNext();)
    		{
    			valor = this.mapaCadenas.get(iterador.next());
    			valores.add(valor);
    		}
        	Collections.sort(valores);
    	}
    	
    	return valores;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
        
    	SortedSet<String> setLlaves = new TreeSet<>(this.mapaCadenas.keySet());
    	List<String> llavesInvert = new ArrayList<>(setLlaves.reversed());
    	return llavesInvert;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
        String primera = null;
        if (this.getCantidadCadenasDiferentes() != 0)
        {
        	SortedSet<String> llaves = new TreeSet<>(this.mapaCadenas.keySet());
        	primera = llaves.first();
        }
    	return primera;
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
    	String ultima = null;
        if (this.getCantidadCadenasDiferentes() != 0)
        {
        	SortedSet<String> llaves = new TreeSet<>(this.mapaCadenas.keySet());
        	ultima = llaves.last();
        }
    	return ultima;
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
        Collection<String> llaves = new ArrayList<>();
        SortedSet<String> llavesMapa = new TreeSet<>(this.mapaCadenas.keySet());
        String llave = null;
        for (Iterator<String> iterador = llavesMapa.iterator(); iterador.hasNext();)
        {
        	llave = iterador.next().toUpperCase();
        	llaves.add(llave);
        }
        
    	return llaves;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
    	// La cantidad de llaves indica la cantidad de valores diferentes en el mapa
    	// porque son lo mismo, pero invertido
    	int cantidad = this.mapaCadenas.size();
    	return cantidad;
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	// Invertir la cadena para la llave
    	String llave = "";
    	for (int i = cadena.length()- 1; i >= 0; i--)
    	{
    		llave += cadena.charAt(i);
    	}
    	
    	//Verificar que no exista la llave antes
    	if (!this.mapaCadenas.containsKey(llave))
    	{
    		this.mapaCadenas.put(llave, cadena);
    	}
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
    	this.mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    	String llave = "";
    	for (int i = valor.length()- 1; i >= 0; i--)
    	{
    		llave += valor.charAt(i);
    	}
    	if (this.mapaCadenas.containsKey(llave))
    	{
    		this.mapaCadenas.remove(llave);
    	}
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	this.mapaCadenas.clear();
    	String llave = "";
    	String valor = "";
    	for (Object obj: objetos)
    	{
    		valor = obj.toString();
    		for (int i = valor.length()- 1; i >= 0; i--)
    		{
    			llave += valor.charAt(i);
    		}
    		this.mapaCadenas.put(llave, valor);
    		llave = "";
    	}
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
    	String llave = "";
    	String valor = "";
    	SortedSet<String> llaves = new TreeSet<>(this.mapaCadenas.keySet());
    	for (Iterator<String> iterador = llaves.iterator(); iterador.hasNext();)
    	{
    		llave = iterador.next();
    		valor = this.mapaCadenas.get(llave);
    		this.mapaCadenas.remove(llave, valor);
    		this.mapaCadenas.put(llave.toUpperCase(), valor);
    	}
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
    	boolean iguales = true;
    	SortedSet<String> llaves = new TreeSet<>(this.mapaCadenas.keySet());
    	if (this.getCantidadCadenasDiferentes() == 0)
    	{
    		iguales = false;
    	}
    	int i = 0;
    	String valor = null, llave = "";
    	while (iguales && i < otroArreglo.length)
    	{
    		valor = otroArreglo[i];
    		for (int j = valor.length()-1; j >= 0; j--)
    		{
    			llave += valor.charAt(j);
    		}
    		if (!this.mapaCadenas.containsKey(llave))
    		{
    			iguales = false;
    		}
    		llave = "";
    		i++;
    	}
    	return iguales;
    }

}
