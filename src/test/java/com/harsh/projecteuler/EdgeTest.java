package com.harsh.projecteuler;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import com.harsh.projecteuler.Edge;

import static org.junit.Assert.*;

public class EdgeTest {
	
    @Test
    public void anEdgeShouldHaveNonNegativeWeight() {
    	final int node1=1;
    	final int node2=2;
    	final int weight=-20;
    	Edge edge = new Edge(node1,node2,weight);
    	assertTrue("weight of edge should be greater than -1",edge.getWeight()>-1);
    }
    
    @Test
    public void anEdgeShouldHaveTwoNonNegIntNodes(){
    	final int node1=1;
    	final int node2=2;
    	final int weight=20;
    	Edge edge = new Edge(node1,node2,weight);
    	assertTrue("Node 1 is represented by non-neg integer",edge.getNode1()>-1);
    	assertTrue("Node 2 is represented by non-neg integer",edge.getNode2()>-1);
    }
    
    @Test
    public void constructorShouldCreateAnEdgeTest(){
    	final int node1=1;
    	final int node2=2;
    	final int weight=20;
    	Edge edge = new Edge(node1,node2,weight);
    	assertFalse("Valid Edge is created",edge.equals(null));
    	assertEquals("node1 of edge is 1",1,edge.getNode1());
    	assertEquals("node2 of edge is 2",2,edge.getNode2());
    	assertEquals("weight of edge is 20",20,edge.getWeight());
    }
    
    @Test
    public void aCollectionOfEdgesShouldBeSortableByAscWeight(){
    	ArrayList<Edge> edges = new ArrayList();
    	edges.add(new Edge(2,3,23));
    	edges.add(new Edge(3,5,2));
    	edges.add(new Edge(4,2,8));
    	edges.add(new Edge(0,2,0));
    	Collections.sort(edges);
    	int expecteds[] = {0,2,8,23};
    	int results[] = new int[4];
    	for(int i=0;i<edges.size();i++){
    		results[i] = edges.get(i).getWeight();
    	}
    			
    	assertArrayEquals(expecteds, results);
    }
}
