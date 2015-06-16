package arm.synisys.training.set;

import java.util.HashMap;

/**
 * Describes specific type of a data structure called disjoint-set.
 * Each set has its representative, which is some member of that set.
 * Disjoint-set is described with the forests by the means of the graph. 
 * Each connected structure is a tree(graph).
 * Each data element is stored in the node(vertex) - {@link Node}
 * @param <T> - type of the value that can contain a node(vertex) of the structure.
 */
public class  DisjointSet<T> {
	
	private final HashMap<Node<T>, Node<T>> objectNodes = new HashMap<Node<T>, Node<T>>();
	
	/**
	 * Finds the set of the node.
	 * @param parent
	 * @return the representative of the set.
	 */
	public Node<T> findSet(Node<T> parent) {
		
		Node<T> node = objectNodes.get(parent);
		if (node == null) {
			return null;
		}
		if (parent!= node.parent) {
			node.parent = findSet(node.parent);
		}
		return node.parent;
	}
	
	/**
	 * Unions two sets, that contain the respective nodes.
	 * If the nodes belong to the same tree set, that method will be terminated.
	 * @param object - node of the first set
	 * @param object2 - node of the second set
	 */
	public void union(Node<T> vertexX, Node<T> vertexY) {
		Node<T> setX = findSet(vertexX);
		Node<T> setY = findSet(vertexY);
		if (setX == null || setY == null || setX == setY) {
			return;
		}
		Node<T> nodeX = objectNodes.get(setX);
		Node<T> nodeY = objectNodes.get(setY);
		//join the two sets by pointing the root of one to the root of the other
		if (nodeX.rank > nodeY.rank) {
			nodeY.parent = vertexX;
		} else {
			nodeX.parent = vertexY;
			if (nodeX.rank == nodeY.rank) {
				nodeY.rank++;
			}
//			objectNodes.remove(nodeX);
		}
		
	}
	
	/**
	 * Creates a new tree set with the single node with the given value and 0 rank.
	 * @param value - value of the node
	 */
	public  void makeSet(T value) {
		Node<T> node = this.createNode(value);
		objectNodes.put(node, node);
	}
	
	public HashMap<Node<T>, Node<T>> getDisjointSets() {
		return objectNodes;
	}
	
	public Node<T> createNode(T value) {
		Node<T> node = new Node<T>(0, value);
		return node;
	}
	
	
	/**
	 * Denotes nodes(vertices) of the trees in the data set
	 * @param <T> - type of the value that node can handle
	 */
	public static class Node<T> {
		int rank;
		T value;
		Node<T> parent;
	
		public Node(int rank, T value) {
			this.rank = rank;
			this.value = value;
			this.parent = this;
		}
		
		public Node(T value) {
			this.value = value;
			this.parent = this;
			this.rank = 0;
		}
		
		private T getValue() {
			return this.value;
		}
		
		public String toString() {
			if(this.parent == this) {
				return "Rank = " + this.rank + " ; " + "Value = " + this.value + ";\n";
			}
			return "Rank = " + this.rank + " ; " + "Value = " + this.value + ";\n" + "Parent = {\n" + this.parent.toString() + "}";
		}
		
		
		public boolean equals(Object node) {
			if (node == null) {
				return false;
			}
		    if (node == this) {
		    	return true;
		    }
		    if (!(node instanceof Node)) {
		    	return false;
		    }
		    //This cast is correct, as if the node is not the instance of Node, 
		    //then the method must be terminated above.
		    @SuppressWarnings("unchecked") 
		    boolean isEqual = this.value.equals(((Node<T>) node).getValue());
		    
			return  isEqual;
			
		}
	}


}
