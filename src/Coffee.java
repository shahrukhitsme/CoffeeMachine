import java.util.ArrayList;
import java.util.List;

//It is an Drink, it holds its recipe and is a singleton class
class Coffee implements Drink {

    List<Ingredient> recipe;
    String drinkName;

    private static Coffee single_instance = null;

    private Coffee()
    {
        drinkName = "COFFEE";
        recipe = new ArrayList<>();
        recipe.add(new Ingredient(HotWater.getInstance(), (float)100));
        recipe.add(new Ingredient(GingerSyrup.getInstance(), (float)30));
        recipe.add(new Ingredient(HotMilk.getInstance(), (float)400));
        recipe.add(new Ingredient(SugarSyrup.getInstance(), (float)50));
        recipe.add(new Ingredient(TeaLeavesSyrup.getInstance(), (float)30));
    }

    public static Coffee getInstance()
    {
        if (single_instance == null)
            single_instance = new Coffee();
  
        return single_instance;
    }

    public void setRecipe(List<Ingredient> recipe) {
        this.recipe = recipe;
    }
    public List<Ingredient> getRecipe(){
        return this.recipe;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }
    public String getDrinkName(){
        return this.drinkName;
    }

}