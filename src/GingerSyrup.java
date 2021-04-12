//It is an item and is a singleton class
class GingerSyrup implements Item {

    String itemName;
    String measuringUnit;

    private static GingerSyrup single_instance = null;

    private GingerSyrup()
    {
        itemName = "Ginger Syrup";
        measuringUnit = "ML";
    }

    public static GingerSyrup getInstance()
    {
        if (single_instance == null)
            single_instance = new GingerSyrup();
  
        return single_instance;
    }

    public String getItemName(){
        return this.itemName;
    }

    public String getMeasuringUnit(){
        return this.measuringUnit;
    }
}