import java.util.HashMap;
import java.util.List;

//This is a singleton class, as we don't want to have multiple instance of Inventory. It holds details about current stock, threshold values of items, and provides functionalities such as
//adding new Item to inventory, refill an item in the inventory, consume all items of recipe from the inventory, check availability of all items of recipe, check quantities > threshold or not
class Inventory {

    private HashMap<Item, Float> stock;
    private HashMap<Item, Float> threshold;

    private static Inventory single_instance = null;
    Indicator indicator;
    Display display;

    private Inventory()
    {
    	this.indicator = Indicator.getInstance();
    	this.display = Display.getInstance();
    }

    public static Inventory getInstance()
    {
        if (single_instance == null)
            single_instance = new Inventory();
  
        return single_instance;
    }
    
    public void setStock(HashMap<Item, Float> stock) {
    	this.stock = stock;
    }
    
    public void setThreshold(HashMap<Item, Float> threshold) {
    	this.threshold = threshold;
    }

    public void addItem(Item item, float quantity, float thresholdValue) {
    	if(this.stock==null)
    		this.stock = new HashMap<>();
    	if(this.threshold==null)
    		this.threshold = new HashMap<>();
        if(item!=null){
            this.stock.put(item, quantity);
            this.threshold.put(item, thresholdValue);
        } else throw new IllegalArgumentException("Item should not be null");
    }

    public void refill(Item item, int quantity){
    	if(this.stock==null || this.threshold==null) {
    		this.display.show("Please initialize stock and threshold data in Inventory");
    		return;
    	}
        if(item!=null && this.stock.containsKey(item)){
            stock.put(item, this.stock.get(item)+quantity);
            if(stock.get(item) >= this.threshold.get(item)){
            	this.indicator.indicateOff(item);
            }
        } else throw new IllegalArgumentException("Either the item refilled in null, or it is not currently supported by the inventory. You have to add the item first.");
    }
    
    public void consume(List<Ingredient> recipe){
    	if(this.stock==null || this.threshold==null) {
    		this.display.show("Please initialize stock and threshold data in Inventory");
    		return;
    	}
        if(recipe!=null){
            float quantity;
            Item item;
            for(int index=0; index<recipe.size(); index++){
            	Ingredient ingredient = recipe.get(index);
                quantity = ingredient.getQuantity();
                item = ingredient.getItem();
                this.stock.put(item, this.stock.get(item)-quantity);
            }
        } else throw new IllegalArgumentException("Recipe should not be null");
    }
    
    public void checkQuantities(){
    	if(this.stock==null || this.threshold==null) {
    		this.display.show("Please initialize stock and threshold data in Inventory");
    		return;
    	}
        for(Item item: stock.keySet()) {
        	float quantityLeft = stock.getOrDefault(item, (float)0);
        	if(quantityLeft <= this.threshold.getOrDefault(item, (float)0)){
            	this.indicator.indicateOn(item, this.stock.get(item));
            }
        }
    }

    public Boolean checkAvailability(List<Ingredient> recipe) {
    	if(this.stock==null || this.threshold==null) {
    		this.display.show("Please initialize stock and threshold data in Inventory");
    		return false;
    	}
        if(recipe!=null){
            Boolean ingredients_are_sufficient = true;
            for(int index=0; index<recipe.size(); index++){
                Ingredient ingredient = recipe.get(index);
                if(ingredient.getQuantity() > this.stock.getOrDefault(ingredient.getItem(), (float)0)){
                	this.indicator.indicateOn(ingredient.getItem(), this.stock.getOrDefault(ingredient.getItem(), (float)0));
                    ingredients_are_sufficient = false;
                }
            }
            return ingredients_are_sufficient;
        } else throw new IllegalArgumentException("Recipe should not be null");
    }
}