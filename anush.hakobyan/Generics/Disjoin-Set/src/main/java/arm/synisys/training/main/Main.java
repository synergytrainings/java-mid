package arm.synisys.training.main;

import java.util.ArrayList;
import java.util.HashMap;

import arm.synisys.training.set.DisjointSet;
import arm.synisys.training.set.DisjointSet.Node;
import arm.synisys.training.set.Edge;



public class Main {
	
	public static void main(String[] args) {
		 //items of the data set
		 String[] vertices = {"a", "b", "c", "d", "f", "g", "h", "i", "j", "e"};
		 
		 //relations between items - which define disjoint sets
		
		 ArrayList<Edge<String>> edges= new ArrayList<Edge<String>>();
		 edges.add(new Edge<String>(vertices[1], vertices[3]));
		 edges.add(new Edge<String>(vertices[9], vertices[5]));
		 edges.add(new Edge<String>(vertices[0], vertices[2]));
		 edges.add(new Edge<String>(vertices[6], vertices[7]));
		 edges.add(new Edge<String>(vertices[0], vertices[1]));
		 edges.add(new Edge<String>(vertices[9], vertices[4]));
		 edges.add(new Edge<String>(vertices[1], vertices[2]));
		 
		 //set with the singleton item objects
		 DisjointSet<String> set = new DisjointSet<String>();
		 for (int i = 0; i < vertices.length; i++) {
			 set.makeSet(vertices[i]);
		 }
		 
		 //all the item-objects
		 HashMap<Node<String>, Node<String>> disjointSets  = set.getDisjointSets();
		 
		//creates connected components using relations given by the edges.
	    int relations = edges.size();
	    for (int i = 0; i < relations; i++) {
	    	String mem1 = edges.get(i).getMem1();
	    	String mem2 = edges.get(i).getMem2();
	    	Node<String> node1 = null ;
	    	Node<String>  node2 = null;
	    	for(Node<String> key : disjointSets.keySet()) {
	    		if(disjointSets.get(key).equals(set.createNode(mem1))) {
	    			node1 = disjointSets.get(key);
	    		} else if(disjointSets.get(key).equals(set.createNode(mem2))){
	    			node2 = disjointSets.get(key);
	    		}
	    	}
	    	set.union(node1, node2);
	    }
	    
	  //Scan through disjoint-set and prints for each tree and subtree its hierarchy
	    for (Object key : disjointSets.keySet()) {
	        System.out.println(disjointSets.get(key).toString());
	    }
		 
	 }
}
