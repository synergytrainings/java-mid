package com.synisys.collections.test;

import com.synisys.collections.ListPerformanceEx;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by arpine on 5/14/15.
 */
public class ListPerformanceTest {
	private ListPerformanceEx listPerformanceEx;

	/**
	 * Create dummy listPerformance class
	 */
	@Before
	public void setUp() {
		this.listPerformanceEx = new ListPerformanceEx();

	}

	/**
	 * Test difference of of arrayList and linkedList Add operation
	 */
	@Test
	public void testAddDifference() {
		long dif = listPerformanceEx.getAddDifference();

		assertTrue(dif < 0);
		assertTrue(Math.abs(dif) > 1000);
	}

	/**
	 * Test difference of of arrayList and linkedList Get operation
	 */
	@Test
	public void testGetDifference() {

		long dif = listPerformanceEx.getGetDifference();
		assertTrue(dif < 0);
		assertTrue(Math.abs(dif) > 10000000);
	}

	/**
	 * Test difference of of arrayList and linkedList Remove operation
	 */
	@Test
	public void testRemoveDifference() {

		assertTrue(listPerformanceEx.getRemoveDifference() > 1000000);
	}

}
