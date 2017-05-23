package org.eda1.actividad02.ejercicio02;

import java.util.ArrayList;
import java.util.Comparator;

import org.eda1.actividad02.ejercicio01.Heap;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public static <T> void sortHeap(ArrayList<T> aList, Comparator<T> comp) {
		Heap<T> monticulo = new Heap<T>(aList.size(), comp);
		while (!aList.isEmpty()) {
			T x = aList.remove(0);
			monticulo.add(x);
		}
		while (!monticulo.isEmpty()) {
			aList.add(monticulo.removeMin());
		}

	}

	protected static <T> void swap(ArrayList<T> lista, int parent, int child) {
		T aux = lista.get(parent);
		lista.set(parent, lista.get(child));
		lista.set(child, aux);
	}

	private static <T> void siftDown(ArrayList<T> lista, int ini, int fin,
			Comparator<T> comp) {

		int parent = ini, child = (parent << 1) + 1; // parent << 1 is
		// slightly faster than
		// parent * 2
		// => (2 * parent) + 1

		while (child < fin) {
			if (child < fin - 1
					&& comp.compare(lista.get(child), lista.get(child + 1)) > 0)
				child++; // child is the right child (child = (2 * parent) + 2)
			if (comp.compare(lista.get(child), lista.get(parent)) >= 0)
				break;
			swap(lista, parent, child);
			parent = child;
			child = (parent << 1) + 1; // => child = (2 * parent) + 1
		}
	}

	public static <T> void heapSort(ArrayList<T> aList, Comparator<T> comp) {

		for (int i = aList.size() / 2; i >= 0; i--)
			siftDown(aList, i, aList.size() - 1, comp); // ordenamos el arr[]

		for (int i = aList.size(); i > 0; i--) {
			T aux = aList.get(0);
			aList.set(0, aList.get(i - 1));
			aList.set(i - 1, aux);
			siftDown(aList, 0, i - 1, comp); // ordenamos el arr[] sin modificar
												// la parte ya ordenada.
		}
		// invertimos el array.
		for (int ini = 0, fin = aList.size() - 1; ini < fin; ini++, fin--) {
			T aux = aList.get(ini);
			aList.set(ini, aList.get(fin));
			aList.set(fin, aux);

		}
	}
}
