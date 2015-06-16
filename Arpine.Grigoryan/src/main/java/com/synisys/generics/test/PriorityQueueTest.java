package com.synisys.generics.test;

import com.synisys.excaptions.exceptions.ExistingCustomerIdException;

import static org.junit.Assert.assertArrayEquals;

import com.synisys.generics.Node;
import com.synisys.generics.PriorityQueue;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by arpine on 5/29/15.
 */
public class PriorityQueueTest {
	private PriorityQueue<String> pqString;
	private PriorityQueue<Integer> pqInteger;
	private PriorityQueue<Node> pqNode;

	/**
	 * Create new dummy priorityQueue
	**/
	@Before
	public void setUp()
			throws ExistingCustomerIdException {
		this.pqString = new PriorityQueue<String>();
		this.pqInteger = new PriorityQueue<Integer>();
		this.pqNode = new PriorityQueue<Node>();

	}

	/**
	 * Sort queue with Strings
	 */

	@Test
	public void testStringQueue (){
		String[] sorted = {"a", "C", "B", "A1", "A"};

		String[] result = new String[5];

		this.pqString.push("A1");
		this.pqString.push("A");
		this.pqString.push("C");
		this.pqString.push("B");
		this.pqString.push("a");

		for (int i = 0 ; i < 5; i ++) {
			result[i] = pqString.heapExtractMax();
		}

		assertArrayEquals(sorted, result);

	}

	/**
	 * Sort queue with Integer
	 */
	@Test
	public void testIntegereQueue (){
		Integer[] sorted = {11, 7,6, 2, 0};

		Integer[] result = new Integer[5];

		this.pqInteger.push(0);
		this.pqInteger.push(11);
		this.pqInteger.push(7);
		this.pqInteger.push(2);
		this.pqInteger.push(6);

		for (int i = 0 ; i < 5; i ++) {
			result[i] = pqInteger.heapExtractMax();
		}

		assertArrayEquals(sorted, result);

	}


	/**
	 * Sort queue with Integer
	 */
	@Test
	public void testNodeQueue (){
		Node node1 = new Node("C", 27);
		Node node2 = new Node("z", 7);
		Node node3 = new Node("A",133 );

		Node[] sorted = {node3, node1, node2};

		Node[] result = new Node[3];

		this.pqNode.push(node1);
		this.pqNode.push(node2);
		this.pqNode.push(node3);

		for (int i = 0 ; i < 3; i ++) {
			result[i] = pqNode.heapExtractMax();
		}

		assertArrayEquals(sorted, result);

	}

}
