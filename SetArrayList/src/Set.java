import java.util.*;

public class Set<T>{
    private ArrayList<T> myList;
    Set(){
    	myList= new ArrayList<T>();
    	
    }
    // Adds item if it's currently not in the set. To check if item is not in set use the membership method which searches through the whole set. 
    public void add(T item){
    	if(!membership(item)){
    		myList.add(item); 
    	}
    }
    // Removes item if it's in the set. To check if item is in set use the membership method which searches through the whole set. 
    public void remove(T item){
    	if(membership(item)) { 
    		myList.remove(item); 
    	}
    }
    // Checks if item is in the set using a for loop. Returns true if item is in the set. Returns false if not. 
    public Boolean membership(T item){
    	for(int i=0; i<myList.size();i++){
    		if(myList.get(i).equals(item)){
    			return true; 
    		}
    	}
    	return false; 
    }
    // Displays a list of the set.
    public String toString(){
    	String string="List of items in the set: "; 
    	for(int i=0;i<myList.size();i++) {
    		string+=myList.get(i).toString()+" ";
    	}
    	return string;
    }
    
    public static void main(String [] args) {
		
		Set<Integer> x = new Set<Integer>(); 
		Scanner scan = new Scanner(System.in); 
		
		// Asking user to type 3 integers. Uses for loop to insert the integers into Set x. Tests the add method. 
        System.out.println("Enter 3 integers: "); 
        for(int i=0; i<3;i++) { 
        	int s=scan.nextInt();
        	x.add(s); 
        }
        System.out.println(x);
        
        // Tests the remove method.
        System.out.println("Which integer you want to remove: "); 
    	x.remove(scan.nextInt()); 
    	System.out.println(x);
    	
    	// Tests the membership method.
    	System.out.println("Enter an integer to check if it's in the set: "); 
    	int y=scan.nextInt();
    	if(x.membership(y)==true) {
    		System.out.println(y+" is in the set.");
    	}
    	if(x.membership(y)==false) {
    		System.out.println(y+" is not the set.");
    	}
    	System.out.println(x);
    	
    	scan.close();
        
     
        
	}
}
