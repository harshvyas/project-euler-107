package com.harsh.projecteuler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DisJointSetTest {

	@Test
	public void shouldBeAbleToCreateDisJointSet(){
		int elements = 2;
		DisJointSet ds = new DisJointSet(elements);
		assertFalse("Disjoint Set object created",ds.equals(null));
	}
	
	@Test
	public void shouldBeAbleToPerformFind(){
		int elements = 2;
		DisJointSet ds = new DisJointSet(elements);
		assertEquals("Find root of node 0 in set is 0",0, ds.find(0));
		assertEquals("Find root of node 1 in set is 1",1, ds.find(1));
	}
	
	@Test
	public void shouldBeAbleToPerformUnion(){
		int elements = 2;
		DisJointSet ds = new DisJointSet(elements);
		ds.union(0,1);
		assertTrue("Union of two disjoint sets 0 and 1 is 0,1",ds.find(0)==ds.find(1));
	}
	
	@Test
	public void areTwoTreesSpanning(){
		int elements = 3;
		DisJointSet ds = new DisJointSet(elements);
		ds.union(2,0);
		ds.union(1,2);
		assertTrue("This is spanning nodes 0,1,2 by edges between 2,0 and 2,1",ds.isSpanning());
	}

}
