package com.synisys.training.test;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import com.mockrunner.mock.jdbc.MockResultSet;
import com.synisys.training.List.ListComparator;
import com.synisys.training.Tree.Donor;
import com.synisys.training.Tree.DonorAnalyzer;

public class TestCollections {
	
	@Test
	public void TestArraysRunningTime() {
		ListComparator listComparator = new ListComparator();
		listComparator.putRandomElementsInLists();
		long arrayListRunningTime = listComparator.getRunningTimeOfArrayList(99999);
		long linkedListRunningTime = listComparator.getRunningTimeOfLinkedList(99999);
		assertThat("running time compare",linkedListRunningTime, greaterThan(arrayListRunningTime));
	}
	
	@Test
	public void TestTreeSet() {
		MockResultSet rs = new MockResultSet("myMock");
		Integer[] donorIdsArray = {12,16,9,6,3};
		List<Integer> donorIds = new LinkedList(Arrays.asList(donorIdsArray));
		String[] donorNamesArray = {"USAID", "UNESCO", "GoRT", "ASDF", "QWERTY"};
		List<Integer> donorNames = new LinkedList(Arrays.asList(donorNamesArray));
		Integer[] projectsCountArray = {32,24,7,10,7};
		List<Integer> projectsCounts = new LinkedList(Arrays.asList(projectsCountArray));
		Double[] investmentsArray = {(double) 120000000, (double) 15000000, (double) 90005000, 
				(double) 567778000, (double) 23000000};
		List<Double> investments = new LinkedList(Arrays.asList(investmentsArray));
		rs.addColumn("DonorId", donorIds);
		rs.addColumn("DonorName", donorNames);
		rs.addColumn("ProjectsCount", projectsCounts);
		rs.addColumn("Investment", investments);
		
		DonorAnalyzer analyzer = new DonorAnalyzer();
		analyzer.addDonors(rs);
		TreeSet sortedDonors = analyzer.getDonorsSortedList();
		List<Donor> sortedDonorsArray = new ArrayList(Arrays.asList(sortedDonors.toArray()));
		int expectedIds[] = {16, 3, 12, 9, 6};
		int ids[] = new int[5];
		for (int i =0; i < 5 ; i++) {
			ids[i] = sortedDonorsArray.get(i).getDonorId();
		} 
		assert(expectedIds.equals(ids));
		
	}
	
}
