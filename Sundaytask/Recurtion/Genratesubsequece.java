import java.io.*;

class Genratesubsequece{
	
// Recursive function to print all
// possible subsequences for given array
public static void printSubsequences(int[] arr, int index, 
									int[] path, int len)
{
	
	// Print the subsequence when reach
	// the leaf of recursion tree
	if (index == arr.length)
	{
		
		// Condition to avoid printing
		// empty subsequence
		if (len > 0) {
		    for (int i = 0; i < len; i++) {
		        System.out.print(path[i] + " ");
		    }
		    System.out.println();
		}
	}
	
	else
	{
		
		// Subsequence without including
		// the element at current index
		printSubsequences(arr, index + 1, path, len);
		
		path[len] = arr[index];
		
		// Subsequence including the element
		// at current index
		printSubsequences(arr, index + 1, path, len + 1);
		
		// Backtrack to remove the recently 
		// inserted element
		path[len] = 0; // Reset the value
	}
	return;
}

// Driver code
public static void main(String[] args)
{
	int[] arr = { 1, 2, 2 };
	
	// Auxiliary space to store each path
	int[] path = new int[arr.length];
	
	printSubsequences(arr, 0, path, 0);
}
}

// This code is contributed by Mukul Sharma
