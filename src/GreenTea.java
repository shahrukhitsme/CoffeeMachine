import java.util.ArrayList;
import java.util.List;

//It is an Drink, it holds its recipe and is a singleton class
class GreenTea implements Drink {

    List<Ingredient> recipe;
    String drinkName;

    private static GreenTea single_instance = null;

    private GreenTea()
    {
        drinkName = "Green Tea";
        recipe = new ArrayList<>();
        recipe.add(new Ingredient(HotWater.getInstance(), (float)100));
        recipe.add(new Ingredient(GingerSyrup.getInstance(), (float)30));
        recipe.add(new Ingredient(SugarSyrup.getInstance(), (float)50));
        recipe.add(new Ingredient(GreenMixture.getInstance(), (float)30));
    }

    public static GreenTea getInstance()
    {
        if (single_instance == null)
            single_instance = new GreenTea();
  
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