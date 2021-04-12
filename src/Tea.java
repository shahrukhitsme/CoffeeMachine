import java.util.ArrayList;
import java.util.List;

//It is an Drink, it holds its recipe and is a singleton class
class Tea implements Drink {

    List<Ingredient> recipe;
    String drinkName;

    private static Tea single_instance = null;

    private Tea()
    {
        drinkName = "TEA";
        recipe = new ArrayList<>();
        recipe.add(new Ingredient(HotWater.getInstance(), (float)200));
        recipe.add(new Ingredient(HotMilk.getInstance(), (float)100));
        recipe.add(new Ingredient(GingerSyrup.getInstance(), (float)10));
        recipe.add(new Ingredient(SugarSyrup.getInstance(), (float)10));
        recipe.add(new Ingredient(TeaLeavesSyrup.getInstance(), (float)30));
    }

    public static Tea getInstance()
    {
        if (single_instance == null)
            single_instance = new Tea();
  
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