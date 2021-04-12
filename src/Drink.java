import java.util.List;

interface Drink {
	List<Ingredient> recipe = null;
    String DrinkName = "";
    public void setRecipe(List<Ingredient> recipe);
    public List<Ingredient> getRecipe();
    public void setDrinkName(String drinkName);
    public String getDrinkName();
}