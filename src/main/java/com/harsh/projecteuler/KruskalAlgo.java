package com.harsh.projecteuler;

import java.util.ArrayList;

/*
 * KruskalAlgo class computes a minimum spanning tree from
 * an edge weighted graph
 */
public class KruskalAlgo {
	
	private int mstWeight;
	private Graph graph;

	public KruskalAlgo(Graph g) {
		this.graph = g;
		this.executeAlgo();
	}

	private void executeAlgo() {
		int counter = 0;
		this.mstWeight = 0;
		this.graph.sortEdgeWeightsByAsc();
		DisJointSet nodes = this.graph.getNodes();
		ArrayList<Edge> edges = this.graph.getEdges();
		while(!nodes.isSpanning()){	
			int cut1 = edges.get(counter).getNode1();
			int cut2 = edges.get(counter).getNode2();
			int cutWeight = edges.get(counter).getWeight();
			//if two nodes of an edge are in disjoint sets then merge them
			if(nodes.find(cut1)!=nodes.find(cut2)){
				nodes.union(cut1, cut2);
				this.mstWeight += cutWeight;
			}
			counter++;
		}
	}

	public int getSaving() {
		return this.graph.getGraphWeight() - this.mstWeight;
	}
	
	public int getMSTWeight(){
		return this.mstWeight;
	}

}