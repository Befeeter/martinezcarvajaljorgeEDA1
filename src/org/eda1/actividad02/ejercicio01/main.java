package org.eda1.actividad02.ejercicio01;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;


public class main {

	public static <T> void main(String[] args) {
		
		int capacidadInicial = 7;

		ArrayList<T> theHeap;

		 Comparator<T> comparator = null;
		
		
		
		Integer[ ] intArray = {17, 30, 15, 12, 9, 2, 8, 20, 7, 6, 5, 3};
		
		ArrayList<Integer> theArray = new ArrayList<Integer>();
		for (int i = 0; i < intArray.length; i++)
			theArray.add(intArray[i]);
		
		
		Heap heap = new Heap(capacidadInicial,comparator);
		
		for (int i = 0; i < theArray.size(); i++)
			
			heap.assign(i, theArray.get(i));

    	String content = heap.toString();
    	System.out.println("Contenido de nuestro HEAP:");
    	System.out.println(content);
    	System.out.println("Cumple las proiedades de un Heap:");
    	if (heap.isHeap() == true)
    		System.out.println("True");
    	else 
    		System.out.println("False");
    	System.out.println("Ordenamos el Heap");
    	heap.makeHeap();
    	System.out.println("Contenido del Heap ordenado:");
    	System.out.println(heap.toString());
    	System.out.println("Cumple las proiedades de un Heap:");
    	if (heap.isHeap() == true)
    		System.out.println("True");
    	else 
    		System.out.println("False");
    	
    	System.out.println("Añadimos al Heap los elementos 21,1,45,4");
    	heap.add(21);
    	heap.add(1);
    	heap.add(45);
    	heap.add(4);
    	
    	System.out.println("Cumple las proiedades de un Heap:");
    	if (heap.isHeap() == true)
    		System.out.println("True");
    	else 
    		System.out.println("False");
    	
    	System.out.println("Contenido del Heap ordenado:");
    	System.out.println(heap.toString());
    
    	System.out.println("Elemento de menor prioridad (Padre) = "+heap.getMin());
    	System.out.println("Eliminamos el elemento con menor prioridad");
    	int elementoMenorPrio = (Integer) heap.removeMin();
    	System.out.println("Contenido del Heap ordenado:");
    	System.out.println(heap.toString());
    	System.out.println("Añadimos nuevamente el elemento eliminado: "+1);
    	heap.add(elementoMenorPrio);
    	System.out.println("Contenido del Heap ordenado:");
    	System.out.println(heap.toString());
    	
    	System.out.println("Incremento en 9 el elemento de la posicion 0");
    	heap.increaseKey(0, new Integer(9));
    	System.out.println("Contenido del Heap ordenado:");
    	System.out.println(heap.toString());
    	System.out.println("Cumple las proiedades de un Heap:");
    	if (heap.isHeap() == true)
    		System.out.println("True");
    	else 
    		System.out.println("False");
    	
    	System.out.println("Decrementamos al valor del elemento 9 que es "+heap.getValue(9)+ " - 29" );
    	
    	heap.decreaseKey(9,(Integer) heap.getValue(9) - new Integer(1));
    	
    	if (heap.isHeap() == true)
    		System.out.println("True");
    	else 
    		System.out.println("False");
    
    	System.out.println("Contenido del Heap ordenado:");
    	System.out.println(heap.toString());
    	System.out.println("Remplaza el contenido del elemento 1 por el numero 22");
    	heap.replaceKey(1, new Integer(22));
    	System.out.println("Contenido del Heap ordenado:");
    	System.out.println(heap.toString());
    	System.out.println("Elimina el elemento 2");
    	heap.delete(2);
    	System.out.println("Contenido del Heap ordenado:");
    	System.out.println(heap.toString());
    	System.out.println("Remplaza el contenido del elemento 0 por el numero 11");
    	heap.replaceKey(0, new Integer(11));
    	System.out.println("Contenido del Heap ordenado:");
    	System.out.println(heap.toString());
    	
    	/*
    	
    	
    	
    	
		*/
	}

}