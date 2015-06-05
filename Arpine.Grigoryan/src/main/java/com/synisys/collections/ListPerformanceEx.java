package com.synisys.collections;

import com.synisys.collections.util.Operations;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by arpine on 6/5/15.
 */
public class ListPerformanceEx {

	private ArrayList<Integer> arrayList = new ArrayList<Integer>();
	private LinkedList<Integer> linkedList = new LinkedList<Integer>();


	private void addElements (){
		for (int i = 0; i < 100000; i++) {
			arrayList.add(i);
		}
		for (int i = 0; i < 100000; i++) {
			linkedList.add(i);
		}
	}

	private void reInit (){
		this.arrayList = new ArrayList<Integer>();
		this.linkedList = new LinkedList<Integer>();

	}

	public static void main (String[] args) {
		ListPerformanceEx  listPerformanceEx= new ListPerformanceEx();

		System.out.println("ArrayList and Linked List Add operation difference is  " + listPerformanceEx.getAddDifference()) ;
		System.out.println("ArrayList and Linked List Get operation difference is  " + listPerformanceEx.getGetDifference()) ;
		System.out.println("ArrayList and Linked List Remove operation difference is  " + listPerformanceEx.getRemoveDifference()) ;


	}

	/**
	 *
	 * @return The difference of arrayList and linkedList Add operation
	 */
	public long getAddDifference(){
		this.reInit();

		// ArrayList add
		long arrayAdd = printArrayListPerformanec(Operations.ADD, arrayList);

		// LinkedList add
		long linkedAdd = printLinkedListPerformanec(Operations.ADD, linkedList);

		System.out.print(arrayAdd - linkedAdd);
		return arrayAdd - linkedAdd;
	}

	/**
	 *
	 * @return The difference of of arrayList and linkedList Get operation
	 */
	public long getGetDifference(){
		reInit();
		addElements();
		// ArrayList get
		long arrayGet = printArrayListPerformanec(Operations.GET, arrayList);


		// LinkedList get
		long linkedGet = printLinkedListPerformanec(Operations.GET, linkedList);

		return arrayGet - linkedGet;
	}


	/**
	 *
	 * @return The difference of of arrayList and linkedList Remove operation
	 */
	public long getRemoveDifference(){
		reInit();
		addElements();

		// ArrayList remove
		long arrayRemove = printArrayListPerformanec(Operations.REMOVE, arrayList);

		// LinkedList remove
		long likedRemove = printLinkedListPerformanec(Operations.REMOVE, linkedList);

		return arrayRemove - likedRemove;
	}


	private long  printArrayListPerformanec(Operations operation, ArrayList<Integer> arrayList){
		long startTime = System.nanoTime();

		switch (operation) {
			case ADD:
				for (int i = 0; i < 100000; i++) {
					arrayList.add(i);
				}
				break;
			case GET:
				for (int i = 0; i < 10000; i++) {
					arrayList.get(i);
				}
				break;
			case REMOVE:
				for (int i = 9999; i >=0; i--) {
					arrayList.remove(i);
				}
				break;

		}

		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("ArrayList " + operation + " duration is  " + duration) ;

		return duration;

	}

	private long printLinkedListPerformanec(Operations operation, LinkedList<Integer> linkedList) {
		long startTime = System.nanoTime();

		switch (operation) {
			case ADD:
				for (int i = 0; i < 100000; i++) {
					linkedList.add(i);
				}
				break;
			case GET:
				for (int i = 0; i < 10000; i++) {
					linkedList.get(i);
				}
				break;
			case REMOVE:
				for (int i = 9999; i >=0; i--) {
					linkedList.remove(i);
				}
				break;

		}

		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("LinkedList  " + operation + " duration is  " + duration) ;
		return duration;

	}

}
