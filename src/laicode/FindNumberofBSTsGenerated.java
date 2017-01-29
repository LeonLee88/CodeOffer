package laicode;

public class FindNumberofBSTsGenerated {

	/*
		Find the number of different Binary Search Trees generated from 1-n.
	
		Example:
		
		Input: 3, Return: 5
	*/
	public static void main(String[] args) {
		FindNumberofBSTsGenerated sol = new FindNumberofBSTsGenerated();
		System.out.println(sol.numOfTrees(3));
		System.out.println(sol.numOfTreesII(3));
	}

	public int numOfTrees(int n) {
		if (n == 0) {
			return 1;
		}
		int[] M = new int[n + 1];
		M[0] = 1; // empty tree is a BST?
		M[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				M[i] += M[j] * M[i - j - 1];
			}
		}
		return M[n];
	}
	
	/* Optimized
	 * */
	public int numOfTreesII(int n) {
		if (n == 0) {
			return 1;
		}
		int[] M = new int[n + 1];
		M[0] = 1;
		M[1] = 1;
		for (int i = 2; i <= n; i++) {
			// Since the shapes of BST are symmetric (2 nodes in left subtree, 3 nodes in right subtree is the same
			// as 3 nodes in left subtree, 2 nodes in right subtree), so we only need to calculate i/2 nodes, and double the result
			for (int j = 0; j < i / 2; j++) {
				M[i] += M[j] * M[i - j - 1];
			}
			int temp = (i % 2 == 1 ? M[(i - 1) / 2] * M[(i - 1) / 2] : 0); // handle special case when left subtree and right subtree has the same numbers of nodes
			M[i] = M[i] * 2 + temp; 
		}
		return M[n];
	}

}
