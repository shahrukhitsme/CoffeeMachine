//It is an item and is a singleton class
class SugarSyrup implements Item {

    String itemName;
    String measuringUnit;

    private static SugarSyrup single_instance = null;

    private SugarSyrup()
    {
        itemName = "Sugar Syrup";
        measuringUnit = "ML";
    }

    public static SugarSyrup getInstance()
    {
        if (single_instance == null)
            single_instance = new SugarSyrup();
  
        return single_instance;
    }

    public String getItemName(){
        return this.itemName;
    }

    public String getMeasuringUnit(){
        return this.measuringUnit;
    }
}