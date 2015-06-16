package com.synisys.generics;

import sun.plugin.dom.exception.InvalidStateException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arpine on 6/15/15.
 */
public class PriorityQueue <E extends Comparable> {
	private List<E> list = new ArrayList<E>();


	/**
	 * Add new element into priority queue
	 * @param element
	 */
	public void push (E element) {
		this.list.add(element);

		int i = getHeapSize()-1;

		while (i > 0 && compare(this.list.get(parent(i)), element)< 0){
			this.list.set(i , this.list.get(parent(i)));
			i = parent(i);
		}

		this.list.set(i ,element);

	}

	public E heapExtractMax (){
		if (getHeapSize() == 0) {
			throw new InvalidStateException("The heap is empty");
		}

		E max = this.list.get(0);

		this.list.set(0, this.list.get(this.getHeapSize() - 1));

		this.list.remove(this.getHeapSize() - 1);

		this.heapify(0);

		return max;
	}

	/**
	 * Return left element for element which index is i
	 * @param i
	 * @return
	 */
	private int left (int i){
		return i*2 + 1;
	}

	/**
	 * Return left element for element which index is i
	 * @param i
	 * @return
	 */
	private int right (int i){
		return i*2 + 2;
	}

	/**
	 * Return left element for element which index is i
	 * @param i
	 * @return
	 */
	private int parent (int i){
		return (i -1)/2;
 	}

	/**
	 * heapify array
	 * @param i the start point
	 */
	private void heapify (int i) {
		int largest = i;
		int l = this.left(i);
		int r = this.right(i);


		if (l < getHeapSize() && compare(this.list.get(l), this.list.get(largest)) > 0 ){
			largest = l;

		}
		if (r < getHeapSize() && compare(this.list.get(r), this.list.get(largest)) > 0 ){
			largest = r;
		}

		if (largest != i) {
			this.swap(i, largest);
			this.heapify(largest);
		}
	}


	private int getHeapSize(){
		return list.size();
	}



	private void swap(int i, int j) {
		E el = this.list.get(i);
		this.list.set(i ,this.list.get(j));
		this.list.set(j ,el);
	}


	private int compare(E var1, E var2) {
		return var1.compareTo(var2); //var1.toString().compareTo( var2.toString())));
	}

	}






