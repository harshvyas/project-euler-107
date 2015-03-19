package com.harsh.projecteuler;

/*
 * Edge class to describe an edge in the graph
 */
public class Edge implements Comparable<Edge>{
	
	private int node1,node2,weight;

	public Edge(int node1, int node2, int weight) {
		this.node1 = node1;
		this.node2 = node2;
		if(weight<0){
			this.weight=0;
		}else{
			this.weight = weight;	
		}
	}

	public int getWeight() {
		return this.weight;
	}

	public int getNode1() {
		return this.node1;
	}

	public int getNode2() {
		return this.node2;
	}

	// To enable sorting by edge weight
	public int compareTo(Edge edge) {
		return this.weight-edge.getWeight();
	}

}
