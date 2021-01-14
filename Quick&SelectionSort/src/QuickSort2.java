// Source: https://www.geeksforgeeks.org/quick-sort/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

//QuickSort with pivot at median of three random positions.
public class QuickSort2 {
	
	public void QuickSort(int array[], int first, int last)
	{
		if (first < last)
		{
		 int q = partition(array, first, last);
		 //Sort elements before and after partition
		 QuickSort(array, first, q-1);
		 QuickSort(array, q+1, last);
		}
	}
	
	public int partition(int array[], int first, int last)
	{
		//Generates three random positions.
	    Random a = new Random();
	    int firstNum = a.nextInt(array.length-1);
	    Random b = new Random();
	    int secondNum = b.nextInt(array.length-1);
	    Random c = new Random();
	    int thirdNum = c.nextInt(array.length-1);
	    
	    //Find the median of these positions.
	    int median;
	    if ((firstNum<secondNum&& secondNum<thirdNum) || (thirdNum<secondNum && secondNum<firstNum)) 
	    {
	    	median = secondNum; //If a<b and b<c OR if c<b and b<a: b is the median.
	    }
        else if ((secondNum<firstNum && firstNum<thirdNum) || (thirdNum<firstNum && firstNum<secondNum)) 
        {
        	median = firstNum;//If b<a and a<c OR if c<a and a<b: a is the median.
        }
        else
        {
        	median = thirdNum; //If above do not apply, c is median (a<c and c<b OR b<c and c<a.
        }
	  //Make the median of these values the pivot.
		int pivot = array[median]; 
		int i = first-1;
		for (int j = first; j < last; j++)
		{
			//If current element smaller then pivot.
			if (array[j] <= pivot)
			{
				i++;
				
				int temp1 = array[i];
				array[i] = array[j];
				array[j] = temp1;
			}
		}
		
		int temp2 = array[i+1];
		array[i+1] = array[last];
		array[last] = temp2;
		
		return i + 1;
	}
	
	//Creates a sorted array of increasing order.
	 public static int[] inputIncrease(int[]array, int size)
	 {
		 for(int k = 0; k < size; k++)
		 {
			 array[k] = k+1;
		 }
		 return array;
	 }
	//Creates a sorted array of decreasing order.
	 public static int[] inputDecrease(int[]array, int size)
    {
        for(int l = size; l > 0; l--)
        {
            array[size-l] = l;
        }
        return array;
    }
	//Creates an array with numbers added at random.
	 public static int[] inputRandom(int[]array, int size)
	 {
		 Random value = new Random();
		 for(int m = 0; m < size; m++)
		 {
			 array[m] = value.nextInt();
		 }
		 return array;
	 }
	 
	 // Puts the contents of COVIDcases.txt into an array which will be later be sorted in the main
	 public static int[] inputCOVID(int[]array, int size) throws FileNotFoundException {
		 Scanner input = new Scanner(new File("C:/Users/evana/Desktop/COVIDcases.txt"));
		 for(int x = 0; x < size; x++)
		 {
			 array[x] = input.nextInt();
		 }
		 return array;
		 
	 }
	
	
	 public static void main(String args[]) throws FileNotFoundException
	 {
		 	//Tests and finds runtime for Quick Sort with an Increasing Array, Pivot at Median of Three Random
		 	 QuickSort test1 = new QuickSort();
			 int array1[]= new int[100];
			 inputIncrease(array1, 100);
			 long startTime = System.nanoTime();
			 test1.QuickSort(array1, 0, array1.length-1);
			 System.out.println("Time for Increasing QS with pivot @ median = " + (System.nanoTime() - startTime) + " nanosecs");
			 
			//Tests and finds runtime for Quick Sort with an Decreasing Array, Pivot at Median of Three Random
			 QuickSort test2 = new QuickSort();
			 int array2[]= new int[100];
			 inputDecrease(array2, 100);
			 startTime = System.nanoTime();
			 test2.QuickSort(array2, 0, array2.length-1);
			 System.out.println("Time for Decreasing QS with pivot @ median  = " + (System.nanoTime() - startTime) + " nanosecs"); 

			//Tests and finds runtime for Quick Sort with a Random Array, Pivot at Median of Three Random
			 QuickSort test3 = new QuickSort();
			 int array3[]= new int[100];
			 inputRandom(array3, 100);
			 startTime = System.nanoTime();
			 test3.QuickSort(array3, 0, array3.length-1);
			 System.out.println("Time for Random QS with pivot @ median  = " + (System.nanoTime() - startTime) + " nanosecs");
			 
			 //Tests and finds runtime for Quick Sort of COVIDcases.txt file, Pivot at Median of Three Random
			 QuickSort covid= new QuickSort();
			 int array4[]= new int[100];
			 
			//prints contents of text file 
			/* for(int i=0;i<100;i++) {
		            System.out.println(array4[i]);
		         }*/
			 
			 inputCOVID(array4, 100);
			 startTime = System.nanoTime();
			 covid.QuickSort(array4, 0, array4.length-1);
			 
			 //prints sorted contents of text file
			/* for(int i=0;i<100;i++) {
	             System.out.println(array4[i]);
	         }*/

			 System.out.println("Time for Covid QS with pivot @ median = " + (System.nanoTime() - startTime) + " nanosecs");
		 }
			 
	 

}


