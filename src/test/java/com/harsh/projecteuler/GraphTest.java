package com.harsh.projecteuler;

import static org.junit.Assert.*;

import org.junit.Test;

public class GraphTest {

	@Test
	public void shouldBeAbleToCalculateGraphWeight() {
		String inputFile = "/Users/vyash/Documents/p107_network.txt";
		Graph g = new Graph(inputFile);
		assertEquals("The graph weight of EulerProblem 107 is 261832",261832,g.getGraphWeight());
	}

}
