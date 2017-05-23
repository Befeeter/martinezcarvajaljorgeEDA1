package org.eda1.examenParcialGrupoB.ejercicio01;

import java.util.Comparator;

public class MyPQWithHeap<T> implements MyPriorityQueue<T> {
	
	private Heap<T> heap;
	
	public MyPQWithHeap (){
		heap = new Heap<T>();
	}
	
	public MyPQWithHeap (Comparator <T> comp){
		heap = new Heap<T>(comp);
	}
	
	public MyPQWithHeap (int initialCapacity, Comparator<T> comp){
		heap = new Heap<T> (initialCapacity, comp);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return heap.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return heap.isEmpty();
	}

	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		heap.add(element);
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return heap.getMin();
	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		return heap.removeMin();
	}

}
