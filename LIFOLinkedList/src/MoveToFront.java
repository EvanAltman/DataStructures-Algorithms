import java.util.*;

public class MoveToFront<T>{
	
    private LinkedList<T> myList;
    
    public MoveToFront(){
        myList = new LinkedList<T>();
    }
    // Adds the item to the list and removes any previous occurrences. Uses contains, remove, and push from LinkedList API. If given item is in list remove it and add it to the end of the list.
    public void push(T item){ 
        if(contains(item) == true)
        {
        myList.remove(item); 
        }
        myList.push(item);   
    }
    // Removes the most recent item added to the list. Uses pop from LinkedList API.
    public void pop(){ 
        myList.pop(); 
    }
    // Returns true if if the given item is in the list and false if not. Uses contains from LinkedList API.
    public Boolean contains(T item){
        if(myList.contains(item))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    // Returns true if the list is empty and false if not. Uses isEmpty from LinkedList API.
    public Boolean isEmpty(){ 
        if(myList.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    // Displays a list of the set.
    public String toString(){ 
        String print = "";
        for(T item : myList)
        {
            print+= item.toString() + " ";
        } 
        return print;
    }

    public static void main(String[] args){
        MoveToFront<Integer> A = new MoveToFront<Integer>();
        // Check if list is empty. True
        System.out.println(A.isEmpty());
        // Pushing 6 now to check the removal of previous instances later.
        A.push(6);  
        System.out.println(A.toString());
        // Check if list contains value. False
        System.out.println(A.contains(5));
        // Pushes values into list; if value is already in list removes all previous instances and adds
        A.push(5); 
        A.push(10);
        A.push(6); // Removes previous 6. adds this 6 between 20 and 10.
        A.push(15);
        A.push(20);
        A.push(15);
        // Prints out String
        System.out.println(A.toString());
        // Check if list contains value. True
        System.out.println(A.contains(5));
        // Pops the item last added to list
        A.pop(); // Deletes 15
        // Prints out String
        System.out.println(A.toString());
        // Check if list is empty. False
        System.out.println(A.isEmpty());

    }
}