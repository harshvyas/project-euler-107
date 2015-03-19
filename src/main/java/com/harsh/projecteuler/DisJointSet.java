package com.harsh.projecteuler;

/*
 * DisJointSet class to perform Union-Find operations
 */
public class DisJointSet {
	
	private int elements;
	private int parent[];
	private int rank[];
	
	public DisJointSet(int elements){
		this.elements = elements;
		this.parent = new int[this.elements];
		this.rank = new int[this.elements];
		
		for(int i=0;i<this.elements;i++){
			this.parent[i] = i;
			this.rank[i] = 0;
		}
	}
	
	/*
	 * Find the root of the node
	 */
	public int find(int node){
		if(parent[node] == node)
		{
			return node;
		}else{
			int result = find(parent[node]);
			parent[node] = result;
			return result;
		}
	}

	/*
	 * Merge two disjoint trees
	 */
	public void union(int tree1, int tree2){
		int root1 = this.find(tree1);
		int root2 = this.find(tree2);
		int root1rank = rank[root1];
		int root2rank = rank[root2];
		
		if(root1 == root2){
			return;
		}
		if(root1rank<root2rank){
			this.parent[root1] = root2;
		}else if(root1rank>root2rank){
			this.parent[root2] = root1;
		}else{
			this.parent[root1] = root2;
			this.rank[root2]++;
		}
	}

	/*
	 * Check if it is no more a disjoint set
	 */
	public boolean isSpanning() {
		for(int i=1;i<this.elements;i++){
			if(this.find(0)!=this.find(i)){
				return false;
			}
		}
		return true;
	}
}
