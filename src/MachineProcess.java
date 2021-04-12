//This is a class which will be instantiated for each request in a separate thread
class MachineProcess implements Runnable{
	Outlet outlet;
	Drink drink;
	Thread t;
	MachineProcess(Outlet outlet, Drink drink){
	    this.outlet = outlet; 
	    this.drink = drink;
	}

	public void run() {
		this.outlet.getDrink(this.drink);
	}
}
