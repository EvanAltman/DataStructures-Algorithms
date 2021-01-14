//Source: https://www.geeksforgeeks.org/selection-sort/
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Random;

public class SelectionSort  {
	public void SelectSort(int array[])
	{
		int length = array.length;
		//Sort array one by one via Selection Sort.
		for (int i=0; i < length-1; i++)
		{
			//Find minimum value of array.
			int minimum = i;
			for (int j = i+1; j < length; j++)
			{
				if (array[j] < array[minimum])
				{
					minimum = j;
				}
			}
			//Swap minimum with first element.
			int temp = array[minimum];
			array[minimum] = array[i];
			array[i] = temp;
		}
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
	 
	 //Puts the contents of COVIDcases.txt into an array which will be later be sorted in the main.
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
		 //Tests and finds runtime for Selection Sort with an Increasing Array.
		 SelectionSort test1= new SelectionSort();
		 int array1[]= new int[100];
		 inputIncrease(array1, 100);
		 long startTime = System.nanoTime();
		 test1.SelectSort(array1);
		 System.out.println("Time for Increasing SS = " + (System.nanoTime() - startTime) + " nanosecs");
		 
		//Tests and finds runtime for Selection Sort with a Decreasing Array.
		 SelectionSort test2= new SelectionSort();
		 int array2[]= new int[100];
		 inputDecrease(array2, 100);
		 
		 startTime = System.nanoTime();
		 test2.SelectSort(array2);
		 System.out.println("Time for Decreasing SS = " + (System.nanoTime() - startTime) + " nanosecs"); 
		
		//Tests and finds runtime for Selection Sort with a Random Array.
		 SelectionSort test3= new SelectionSort();
		 int array3[]= new int[100];
		 inputRandom(array3, 100);

		 startTime = System.nanoTime();
		 test3.SelectSort(array3);
		 System.out.println("Time for Random SS = " + (System.nanoTime() - startTime) + " nanosecs"); 
		 
		 //Tests and finds runtime for Selection Sort of COVIDcases.txt file. 
		 SelectionSort covid= new SelectionSort();
		 int array4[]= new int[100];
		 inputCOVID(array4, 100);
		 
		//prints contents of text file 
		/*for(int i=0;i<100;i++) {
		     System.out.println(array4[i]);
		  }*/
		 startTime = System.nanoTime();
		 covid.SelectSort(array4);
		 
		//prints sorted contents of text file
		 /*for(int i=0;i<100;i++) {
             System.out.println(array4[i]);
         }*/
		 
		 System.out.println("Time for Covid SS = " + (System.nanoTime() - startTime) + " nanosecs");
	 }
    
}
