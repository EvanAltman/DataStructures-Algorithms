import java.util.*;

public class Tester extends BinarySearchTree {
	
	
	// Uses preorder to balance the tree. rLR. root Left Right
	public void seq(int low, int high, BinarySearchTree<Integer> T )
    {
        if(low <= high)
        {
            int mid = (low + high)/2;
            T.insert(mid);
            seq(low, mid -1, T);
            seq(mid +1, high, T);
        }
    }
	
	
	
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		
		
		// Skewed Tree
		BinarySearchTree<Integer> S = new BinarySearchTree<Integer>(); 
        System.out.println("Enter an integer for skewed tree:");
        int n = scan.nextInt();
        //For loop inserting values into skewed tree.
        for(int i=1;i<=n;i++){
        	S.insert(i);
        }   
        //Start the timer.
        long startTimeSkewed = System.nanoTime();
        // Find integer in the skewed tree.
        boolean find = S.contains(n+1); 
        //Print results and end the timer.
        System.out.println("Time = " + (System.nanoTime() - startTimeSkewed) + " nanosecs");         
        
        //Balanced tree
        BinarySearchTree<Integer> B = new BinarySearchTree<Integer>(); 
        Tester X = new Tester();
        System.out.println("Enter an integer for balanced tree:");
        
        int x = scan.nextInt();
        //Using the seq method to do preorder of the balanced tree. Low=1. High= user inputed integer.
        X.seq(1, x, B); 
        //Start the timer.
        long startTimeBalanced = System.nanoTime();
        //Find integer in the balanced tree.
        boolean find2 = B.contains(x+1); 
        //Print results and end the timer.
        System.out.println("Time = " + (System.nanoTime() - startTimeBalanced) + " nanosecs"); 
        
        scan.close();
    }
        
		

}