//Outlet class is a class representing the outlet of the coffee machine. The number of objects of this class is equal to the number of outlets in the machine.
//This class is implemented in state pattern. It has 3 states: Free, Preparing and Dispensing.
class Outlet {

    private OutletState state;
    protected int outletNumber;
    Inventory inventory;
    Display display;

    Outlet(){
        this.state = new FreeOutletState();
        this.inventory = Inventory.getInstance();
        this.display = Display.getInstance();
    }

    Outlet(int outletNumber){
        this.outletNumber = outletNumber;
        this.state = new FreeOutletState();
        this.inventory = Inventory.getInstance();
        this.display = Display.getInstance();
    }

    public void previousState() {
        state.prev(this);
    }

    public void nextState() {
        state.next(this);
    }

    public void printStatus() {
        state.printStatus(this);
    }

    public String getState() {
        return state.getState(this);
    }
    
    public void setState(OutletState state) {
        this.state = state;
    }
    
    public int getOutletNumber() {
    	return this.outletNumber;
    }

    public void getDrink(Drink drink){
    	if(drink==null) {
    		this.display.show("Please provide a valid drink");
    		return;
    	}
    	this.display.show("Outlet "+this.outletNumber+": Request for "+drink.getDrinkName()+" received.");
    	synchronized (this) {
    		if(getState()!="FREE") {
        		this.display.show("Outlet "+this.outletNumber+" is currently being used. Please use another outlet or wait for the outlet to finish processing.");
        		return;
        	}
        	nextState();
		}
    	
    	synchronized(inventory){
            if(!this.inventory.checkAvailability(drink.getRecipe())) {
            	this.display.show("Outlet "+this.outletNumber+": Insufficient ingredients to prepare "+drink.getDrinkName()+". Please Refill.");
            	previousState();
            	return;
            }
            this.inventory.consume(drink.getRecipe());
    	}
        prepare(drink);
        dispense(drink);
        this.inventory.checkQuantities();
    }

    public void prepare(Drink drink){
    	this.display.show("Outlet "+this.outletNumber+": Preparing "+drink.getDrinkName()+".");
        nextState();
    }

    public void dispense(Drink drink){
    	this.display.show("Outlet "+this.outletNumber+": Dispensing "+drink.getDrinkName()+".");
        nextState();
    }
}