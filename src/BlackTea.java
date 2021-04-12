import java.util.*;

//It is an Drink, it holds its recipe and is a singleton class
class BlackTea implements Drink {

    List<Ingredient> recipe;
    String drinkName;

    private static BlackTea single_instance = null;

    private BlackTea()
    {
        drinkName = "BLACK TEA";
        recipe = new ArrayList<>();
        recipe.add(new Ingredient(HotWater.getInstance(), (float)300));
        recipe.add(new Ingredient(GingerSyrup.getInstance(), (float)30));
        recipe.add(new Ingredient(SugarSyrup.getInstance(), (float)50));
        recipe.add(new Ingredient(TeaLeavesSyrup.getInstance(), (float)30));
    }

    public static BlackTea getInstance()
    {
        if (single_instance == null)
            single_instance = new BlackTea();
  
        return single_instance;
    }

	public void setRecipe(List<Ingredient> recipe) {
        this.recipe = recipe;
    }
    
    @Override
    public List<Ingredient> getRecipe(){
        return this.recipe;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }
    
    @Override
    public String getDrinkName(){
        return this.drinkName;
    }

}