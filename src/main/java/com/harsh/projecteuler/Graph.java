package com.harsh.projecteuler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/*
 * Graph class represents a sorted list of weighted edges and disjoint set of nodes
 */
public class Graph {
	
	private DisJointSet nodes;
	private ArrayList<Edge> edges;
	private int graphWeight;

	public Graph(String inputFile) {
		this.generateGraph(inputFile);
	}

	/*
	 * generate a graph from the input file of Euler problem 107. 
	 * TODO generalize for input file data format
	 */
	private void generateGraph(String inputFile) {
		ArrayList<String> lines=new ArrayList<String>();
		try {
			File file = new File(inputFile);
			FileReader fileReader;
			String line;
			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line.trim());
			}
			fileReader.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1){
			e1.printStackTrace();
		}
		
		int nodeCount = lines.size();
		this.nodes = new DisJointSet(nodeCount);
		this.edges = new ArrayList<Edge>();
		this.graphWeight=0;
		for(int j=0;j<nodeCount;j++){
			String edge[] = lines.get(j).split(",");
			for(int k=0;k<j;k++){
				// input file for Euler problem 107 contains "-" for non-edges. skip them
				if(!edge[k].equals("-")){ 
					int weight = Integer.parseInt(edge[k]);
					this.edges.add(new Edge(j,k,weight));
					this.graphWeight += weight;
				}
			}
		}
	}
	
	/*
	 * Sort graph edges in ascending order of its weight
	 */
	public void sortEdgeWeightsByAsc(){
		Collections.sort(this.edges);
	}

	public void printSortedEdges(){
		for(Edge e:this.edges){
			System.out.println("sorted edges = "+e.getWeight()+"-"+e.getNode1()+"-"+e.getNode2());
		}
	}
	
	public DisJointSet getNodes() {
		return this.nodes;
	}

	public ArrayList<Edge> getEdges(){
		return this.edges;
	}

	public int getGraphWeight() {
		return this.graphWeight;
	}

}

