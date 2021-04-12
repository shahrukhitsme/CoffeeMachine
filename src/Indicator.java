import java.util.HashMap;

//It is a singleton class for indicating low stock of a particular item, and also maintain its indication state. It is used in many places using dependency injection.
class Indicator {
    //Singleton class
    private static Indicator single_instance = null;
    private static HashMap<Item, Boolean> itemIndicationStates = null;
    Display display;

    private Indicator()
    {
        display = Display.getInstance();
    }

    public static Indicator getInstance()
    {
        if (single_instance == null) {
            single_instance = new Indicator();
            itemIndicationStates = new HashMap<>();
        }
        return single_instance;
    }

    public void indicateOn(Item item, float quantity){
    	synchronized(itemIndicationStates) {
    	if(!itemIndicationStates.getOrDefault(item, false))
    		display.show("INDICATOR: "+item.getItemName()+" is running low! Quantity Left: "+quantity+" "+item.getMeasuringUnit()+" Please refill! Indicator On!");
		itemIndicationStates.put(item, true);
    	}
    }

    public void indicateOff(Item item){
    	display.show("INDICATOR: "+item.getItemName()+" is refilled sufficiently! Indicator Off!");
    	itemIndicationStates.put(item, false);
    }
}