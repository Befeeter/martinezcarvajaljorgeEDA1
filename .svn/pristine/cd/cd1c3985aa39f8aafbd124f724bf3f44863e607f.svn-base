package org.eda1.actividad04.ejercicio01;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

import org.eda1.estructurasdedatos.Iterator;

public class HashAVL<T> {

	private AVLTree<T>[] table; // creo un vector de AVL.
	private int hashTableSize; // tamaño de la tabla.
	private int defaultHashTableSize; // Tamaño por defecto de la tabla.
	private double maxLoadFactor; // factor de carga maximo de la tabla.
	private int tableThreshold; // tamaño maximo para hacer rehash
	private int modCount; // for iterator consistency checks

	private void rehash(int newHasTableSize) {
		// allocate the new hash table and record a reference
		// to the current one in oldTable
		int newTableSize = nextPrime(newHasTableSize);
		AVLTree<T>[] newTable = new AVLTree[newTableSize];
		for (int i = 0; i < newTableSize; i++)
			newTable[i] = new AVLTree<T>();

		AVLTree<T>[] oldTable = table;

		int index;

		// cycle through the current hash table
		for (int i = 0; i < table.length; i++) {
			// see if there is a linked list present
			if (table[i] != null) {
				Iterator<T> iter = table[i].iterator();
				T currItem;
				while (iter.hasNext()) {
					currItem = iter.next();

					index = (currItem.hashCode() & Integer.MAX_VALUE)
							% newTableSize;
					// funcion hash para conocer la posicion del elemento.

					newTable[index].add(currItem);
				}
			}
		}

		// the table is now newTable
		table = newTable;
		// update the table threshold
		tableThreshold = (int) (table.length * maxLoadFactor);
		// let garbage collection get rid of oldTable
		oldTable = null;
	}

	/**
	 * Internal method to find a prime number at least as large as n.
	 * 
	 * @param n
	 *            the starting number (must be positive).
	 * @return a prime number larger than or equal to n.
	 */

	private static int nextPrime(int n) { // calcula el siguiente numero primo
											// mallor o igual a n.
		if (n % 2 == 0)
			n++;

		for (; !isPrime(n); n += 2)
			;

		return n;
	}

	private static boolean isPrime(int n) { // devuelve si un numero es primo o
											// no.
		if (n == 2 || n == 3)
			return true;

		if (n == 1 || n % 2 == 0)
			return false;

		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;

		return true;
	}

	public HashAVL() {
		defaultHashTableSize = 11;
		table = new AVLTree[defaultHashTableSize];
		for (int i = 0; i < defaultHashTableSize; i++)
			table[i] = new AVLTree<T>();
		hashTableSize = 0;
		maxLoadFactor = 0.75;
		tableThreshold = (int) (table.length * maxLoadFactor);
	}
	
	public HashAVL (int defaultTableSize, double loadFactor){
		defaultHashTableSize = nextPrime(defaultTableSize);
		table = new AVLTree[defaultHashTableSize];
		for (int i = 0; i < defaultHashTableSize; i++)
			table[i] = new AVLTree<T>();
		hashTableSize = 0;
		maxLoadFactor = loadFactor;
		tableThreshold = (int)(table.length * maxLoadFactor);
	}

	public boolean add (T item){
		// compute the hash table index
				int index = (item.hashCode() & Integer.MAX_VALUE) % table.length;
				
				// find the item and return false if item is in the AVLTree
				if (table[index].contains((T)item))
					return false;
				
				if (!table[index].add(item))
					return false;
				
				// we will add item, so increment modCount
				modCount++;

				hashTableSize++;

				if (hashTableSize >= tableThreshold)
					rehash(2 * table.length + 1);

				return true;
	}
	
	
	public void clear (){
		// make all hash table entries null
		for (int i = 0; i < table.length; i++)
			table[i] = null;

		// we have modified the hash table, and it has
		// no entries
		modCount++;
		hashTableSize = 0;
	}
	
	/**
     * Returns <tt>true</tt> if this hash table contains the specified element.
     *
     * @param item the object to be checked for containment in this hash table.
     * @return <tt>true</tt> if this hash table contains the specified element.
     */
	public boolean contains (Object item){
		// compute the hash table index
				int index = (item.hashCode() & Integer.MAX_VALUE) % table.length;

				// find the item and return false if item is in the ArrayList
				if (table[index].contains((T)item))
					return true;
				else
					return false;
	}
	
	public int find (Object item){
		// compute the hash table index
				int index = (item.hashCode() & Integer.MAX_VALUE) % table.length;
				
				if (table[index] != null) {
				return table[index].pathHeight((T) item) +1;
				}

				return -1;
	}
	
	/**
     * Returns <tt>true</tt> if this hash table contains no elements.
     *
     * @return <tt>true</tt> if this hash table contains no elements.
     */
	public boolean isEmpty (){
		return hashTableSize == 0;
	}
	
	/**
     * Returns an iterator over the elements in this tree.
     *
     * @return an iterator over the elements in this tree.
     */
	public Iterator <T> iterator (){
		// create and return an instance of the inner class IteratorImpl
				return new HashAVLTreeIterator();
	}
	
	public boolean remove (Object item){
		// compute the hash table index
				int index = (item.hashCode() & Integer.MAX_VALUE) % table.length;
				
				if (table[index].remove(item)) {
					modCount++;
					hashTableSize--;
					return true;
				}
				else
					return false;

	}
	//Return the size of the table.
	public int size(){
		return hashTableSize;
	}
	
	
	/**
     * Returns an array containing all of the elements in this hash table.
     *
     * @return an array containing all of the elements in this hash table.
     */
	public Object[] toArray(){
		// allocate the array an an iterator
				Object[] arr = new Object[hashTableSize];
				Iterator<T> iter = iterator();
				int i = 0;

				// iterate the hash table and assign its
				// values into the array
				while (iter.hasNext()) {
					arr[i] = iter.next();
					i++;
				}

				return arr;
	}
	
	  /**
	    * Returns a string representation of this tree. The
	    * representation is a comma separated list in iterator order
	    * enclosed in square brackets.
	    */
	public String toString (){
		int max = hashTableSize - 1;
		StringBuffer buf = new StringBuffer();
		Iterator<T> iter = iterator();

		buf.append("[");
		for (int i = 0; i <= max; i++) {
			buf.append(iter.next());

	    	if (i < max)
				buf.append(", ");
		}
		buf.append("]");
		return buf.toString();
	}
//return the lenght of the table.
	public int tableLength() {
		return table.length;
	}
 //return the max number of elements on one entry of table.
	public int maxEntrySize() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; (i < table.length); i++) {
			if (table [i] != null) {
				if (table[i].size() > max)
					max = table[i].size();
			}
		}
		return max;
	}
// return the min number of elements on one entry of table.
	public int minEntrySize() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; (i < table.length); i++) {
			if (table [i] != null) {
				if (table[i].size() < min)
					min = table[i].size();
			}
		}
		return min;
	}
	
	public void showHashTable (){
		
	}
	
	

	private class HashAVLTreeIterator implements Iterator<T>{
		int expectedModCount;	// to check iterator consistency
		int index;         		// index of current hash table bucket
		int indexOfCurrentAVL;	// index of the current AVLTree
		int globalIndex;		// global index
		T lastReturned;			// reference to the last value returned by next()

		HashAVLTreeIterator() {
			// the expected modCount starts at modCount
			expectedModCount = modCount;

			// find the first non-empty bucket
			if (hashTableSize != 0) {
				int i = 0;
				while ((i < table.length) && (table[i].isEmpty()))
					i++;
				index = i;
				indexOfCurrentAVL = 0;
			}
			else {
				index = -1;
				indexOfCurrentAVL = 0;				
			}
				
			globalIndex = 0;
			lastReturned = null;			
	}
		public boolean hasNext() {
			// we are at the end of the table if next == null
			return globalIndex < hashTableSize;
		}

		public T current() {
			return lastReturned;
		}

		public T next() {
			// check for iterator consistency
			if (modCount != expectedModCount)
				 throw new ConcurrentModificationException();

			// if entry is null, we are at the end of the table
			if (table[index].isEmpty())
				 throw new NoSuchElementException();

			//System.out.println(index + ", " + indexOfCurrentAL + ", " + globalIndex);
			
			// capture the value we will return
			Iterator<T> it = table[index].iterator();
			for (int i=0; i<indexOfCurrentAVL; i++){
				it.next();
			}
			lastReturned = it.next();
			
			// move to the next entry in the current ArrayList
			if (indexOfCurrentAVL + 1 == table[index].size()) {
				// record the current bucket index
				int i = index;

				i++;
				if (i < table.length) {
					while ((i < table.length) && (table[i].isEmpty()))
						i++;
					
					index = i;
					indexOfCurrentAVL = 0;
				}
			}
			else
				indexOfCurrentAVL++;
			
			globalIndex++;
			
			return lastReturned;
		}

		public void remove() {
		   // check for a missing call to next() or previous()
		   if (lastReturned == null)
		      throw new IllegalStateException(
		         "Iterator call to next() " +
		         "required before calling remove()");
			if (modCount != expectedModCount)
				 throw new ConcurrentModificationException();

			// remove lastReturned by calling remove() in Hash.
			// this call will increment modCount
			HashAVL.this.remove(lastReturned);
			expectedModCount = modCount;
			lastReturned = null;
		}
	}
		
}

