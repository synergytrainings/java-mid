package com.synisys.generics;

/**
 * Created by arpine on 6/15/15.
 */
public class PriorityQueueMain {

	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<String>();

		pq.push("A1");
		pq.push("A");
		pq.push("C");
		pq.push("B");
		pq.push("a");


		PriorityQueue<Integer> pqI = new PriorityQueue<Integer>();

		pqI.push(1);
		pqI.push(7);
		pqI.push(6);
		pqI.push(11);
		pqI.push(2);

		System.out.println("____Sorted  String____");
		System.out.println(pq.heapExtractMax());
		System.out.println(pq.heapExtractMax());
		System.out.println(pq.heapExtractMax());
		System.out.println(pq.heapExtractMax());
		System.out.println(pq.heapExtractMax());

		System.out.println("____Sorted  Integere");
		System.out.println(pqI.heapExtractMax());
		System.out.println(pqI.heapExtractMax());
		System.out.println(pqI.heapExtractMax());
		System.out.println(pqI.heapExtractMax());
		System.out.println(pqI.heapExtractMax());
	}
}
