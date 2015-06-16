package com.synisys.generics;

/**
 * Created by arpine on 6/16/15.
 */
public class Node implements Comparable {
	private String name;
	private Integer weight;

	public Node(String value, Integer weight){
		this.weight = weight;
		this.name = value;

	}

	@Override
	public int compareTo(Object o) {
		Node n = (Node)o;
		return this.weight.compareTo(n.weight);
	}
}
