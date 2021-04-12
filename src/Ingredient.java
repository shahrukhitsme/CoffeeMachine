//This class has item and quantity. A list of ingredients forms a recipe, which is a property of the Drink object.
class Ingredient {

    private Item item;
    private float quantity;

    Ingredient(){}

    Ingredient(Item item, float quantity){
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem(){
        return this.item;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public float getQuantity(){
        return this.quantity;
    }

    public void setQuantity(float quantity){
        this.quantity = quantity;
    }
}