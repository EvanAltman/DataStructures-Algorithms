// Source: https://www.geeksforgeeks.org/quick-sort/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

//QuickSort with pivot at first position.
public class QuickSort {
	
	public void QuickSort(int array[], int first, int last)
	{
		if (first < last)
		{
		 int q = partition(array, first, last);
		 //Sort elements before and after partition.
		 QuickSort(array, first, q-1);
		 QuickSort(array, q+1, last);
		}
	}

	//Takes first value as pivot, places all smaller to left and all greater to the right.
	public int partition(int array[], int first, int last)
	{
		int pivot = array[first]; //Pivot at first position.
		int i = last+1;
		for (int j = last; j > first; j--)
		{
			//If current element smaller then pivot.
			if (array[j] > pivot)
			{
				i--;
				
				int temp1 = array[i];
				array[i] = array[j];
				array[j] = temp1;
			}
		}
		
		int temp2 = array[i-1];
		array[i-1] = array[first];
		array[first] = temp2;
		
		return i - 1;
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
		//Tests and finds runtime for Quick Sort with an Increasing Array, Pivot at First
		 QuickSort test1 = new QuickSort();
		 int array1[]= new int[100];
		 inputIncrease(array1, 100);
		 long startTime = System.nanoTime();
		 test1.QuickSort(array1, 0, array1.length-1);
		 System.out.println("Time for Increasing QS with pivot @ first = " + (System.nanoTime() - startTime) + " nanosecs");
		 
		//Tests and finds runtime for Quick Sort with an Decreasing Array, Pivot at First
		 QuickSort test2 = new QuickSort();
		 int array2[]= new int[100];
		 inputDecrease(array2, 100);
		 startTime = System.nanoTime();
		 test2.QuickSort(array2, 0, array2.length-1);
		 System.out.println("Time for Decreasing QS with pivot @ first  = " + (System.nanoTime() - startTime) + " nanosecs"); 

		//Tests and finds runtime for Quick Sort with an Random Array, Pivot at First
		 QuickSort test3 = new QuickSort();
		 int array3[]= new int[100];
		 inputRandom(array3, 100);
		 startTime = System.nanoTime();
		 test3.QuickSort(array3, 0, array3.length-1);
		 System.out.println("Time for Random QS with pivot @ first  = " + (System.nanoTime() - startTime) + " nanosecs");
		 
		 //Tests and finds runtime for Quick Sort of the COVIDcases.txt file, Pivot at First
		 QuickSort covid= new QuickSort();
		 int array4[]= new int[100];
		 inputCOVID(array4, 100);
		 
		//prints contents of text file 
		/*for(int i=0;i<100;i++) {
		           System.out.println(array4[i]);
		   }*/
		 
		 startTime = System.nanoTime();
		 covid.QuickSort(array4, 0, array4.length-1);
		 
		//prints sorted contents of text file
		/* for(int i=0;i<100;i++) {
             System.out.println(array4[i]);
         }*/
	
		 System.out.println("Time for Covid QS with pivot @ first = " + (System.nanoTime() - startTime) + " nanosecs");
	 }
	 

}

