package com.synisys.training.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Implementation of the comparison of <i>ArrayList</i> and <i>LinkedList</i>
 */
public class ListComparator {
	
	List<Integer> IntegerArrayList = new ArrayList<Integer>();
	List<Integer> IntegerLinkedList = new LinkedList<Integer>();
	
	/**
	 * Puts randomly generated integers in the ArrayList and LinkedList
	 */
	public void putRandomElementsInLists() {
		Random generator = new Random();
		for(int i = 0; i < 100000; ++i) {
			Integer randomInt = generator.nextInt();
			this.IntegerArrayList.add(randomInt);
			this.IntegerLinkedList.add(randomInt);
		}
	}
	
	/**
	 * Finds the element by the index in the <i>ArrayList</i>
	 * and check running time of the method.
	 * @param index of the element, should be find.
	 * @return running time of the get method by the index for <i>ArrayList</i>
	 */
	public long getRunningTimeOfArrayList(int index) {
		long startTime = System.currentTimeMillis();
		Integer wantedInteger = IntegerArrayList.get(index);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		return totalTime;
	}
	
	/**
	 * Finds the element by the index in the <i>Linked List</i>
	 * and check running time of the method.
	 * @param index of the element, should be find.
	 * @return running time of the get method by the index for <i>Linked List</i>
	 */
	public long getRunningTimeOfLinkedList(int index) {
		long startTime = System.currentTimeMillis();
		Integer wantedInteger = IntegerLinkedList.get(index);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		return totalTime;
	}
}
