import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

//This class is the entry point of the machine
class CoffeeMachine {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException{
    	
    	//Reading input.txt file for the inputs. Check Readme.md for details on how to provide input.
    	String filePath = new File("input.txt").getAbsolutePath();
    	File file = new File(filePath);
    	
	    Scanner sc = new Scanner(file);
	    int testCases = Integer.parseInt(sc.nextLine().substring(11).trim());
	    while(testCases-- >0) {
	    	System.out.println("Initializing Coffee Machine");
		    System.out.println("Taking Inputs");
		    
	    	//Getting number of outlets.
	    	int num_of_outlets = Integer.parseInt(sc.nextLine().substring(18).trim());
	    	Outlet[] outlets = new Outlet[num_of_outlets];
	        for(int index = 1; index <= num_of_outlets; index++){
	            outlets[index-1] = new Outlet(index);
	        }
	        
	        //Getting number of items like milk, water, etc to be supported in the inventory. All items are singleton objects.
		    int number_of_Items = Integer.parseInt(sc.nextLine().substring(15).trim());
		    HashMap<Item, Float> stock = new HashMap<>();
	        HashMap<Item, Float> threshold = new HashMap<>();
		    for(int index=0; index<number_of_Items; index++) {
		    	String input = sc.nextLine();
		    	String itemName = input.substring(0, input.indexOf(':'));
		    	float quantity = Float.parseFloat(input.substring(input.indexOf(':')+2));
		    	Item item = null;
		    	switch(itemName) {
		    	case "hot_water":
		    		item = HotWater.getInstance();
		    		break;
		    	case "hot_milk":
		    		item = HotMilk.getInstance();
		    		break;
		    	case "ginger_syrup":
		    		item = GingerSyrup.getInstance();
		    		break;
		    	case "sugar_syrup":
		    		item = SugarSyrup.getInstance();
		    		break;
		    	case "tea_leaves_syrup":
		    		item = TeaLeavesSyrup.getInstance();
		    		break;
		    	case "green_mixture":
		    		item = GreenMixture.getInstance();
		    		break;
		    	default:
		    		Display.getInstance().show("Please provide the item class for "+itemName+" to be able to use it.");
		    	}
		    	if(item!=null) {
		    		stock.put(item, quantity);
		    		threshold.put(item, quantity/4);
		    	}
		    }
		    
		    //Updating inventory stock and setting threshold as current quantity/4. If item stock is lesser than or equal to the threshold, low quantity indicator will be on for that item.
	        Inventory inventory = Inventory.getInstance();
	        inventory.setStock(stock);
	        inventory.setThreshold(threshold);
	        inventory.checkQuantities();
	        
	        //Getting all singleton instances of drinks which can be ordered and storing in hashmap.
	        HashMap<String, Drink> drinkInstances = new HashMap<>();
	        drinkInstances.put("Coffee", Coffee.getInstance());
	        drinkInstances.put("Tea", Tea.getInstance());
	        drinkInstances.put("Green Tea", GreenTea.getInstance());
	        drinkInstances.put("Black Tea", BlackTea.getInstance());
	        
	        //Creating a thread for each request as all should work in parallel. Outlet is implemented in state pattern, so need not worry about multiple parallel orders on same outlet.
	        List<Thread> arrThreads = new ArrayList<>();
	        int number_of_Beverage_Requests = Integer.parseInt(sc.nextLine().substring(28).trim());
	        for(int index=0; index<number_of_Beverage_Requests; index++) {
	        	int outletNumber = Integer.parseInt(sc.nextLine().substring(7).trim());
	        	String drinkName = sc.nextLine().substring(7);
		        Thread T = new Thread(new MachineProcess(outlets[outletNumber-1], drinkInstances.getOrDefault(drinkName, null)));
		        arrThreads.add(T);
		        T.start();
	        }
	        
	        //Waiting for all threads to finish executing before we execute the next test case and re-initialize the coffee machine.
	        for (int i = 0; i < arrThreads.size(); i++) 
	            arrThreads.get(i).join();
	        
	        System.out.println("Finished executing test case");
	        System.out.println("-----------------------------");
	    }
    }

}