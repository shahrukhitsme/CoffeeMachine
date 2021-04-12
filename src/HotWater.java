//It is an item and is a singleton class
class HotWater implements Item {

    String itemName;
    String measuringUnit;

    private static HotWater single_instance = null;

    private HotWater()
    {
        itemName = "Hot Water";
        measuringUnit = "ML";
    }

    public static HotWater getInstance()
    {
        if (single_instance == null)
            single_instance = new HotWater();
  
        return single_instance;
    }

    public String getItemName(){
        return this.itemName;
    }

    public String getMeasuringUnit(){
        return this.measuringUnit;
    }
}