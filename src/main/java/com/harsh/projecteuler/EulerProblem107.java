package com.harsh.projecteuler;

import java.util.Date;
import java.util.Scanner;

public class EulerProblem107 {

	public static void main(String[] args) {

		// /path/to/euler107/inputfile.txt
		System.out.println("Enter inputsource for Euler Problem 107:");
		String inputFile=new Scanner(System.in).nextLine();
		
		long startTime = new Date().getTime();
		Graph g = new Graph(inputFile);
		KruskalAlgo mst = new KruskalAlgo(g);
		long stopTime = new Date().getTime();
		
		System.out.println("Result of Euler Problem 107 = "+ mst.getSaving());
		System.out.println("Execution Time = "+(stopTime-startTime)+" milliseconds");
	}
}
