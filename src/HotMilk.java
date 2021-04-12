//It is an item and is a singleton class
class HotMilk implements Item {

    String itemName;
    String measuringUnit;

    private static HotMilk single_instance = null;

    private HotMilk()
    {
        itemName = "Hot Milk";
        measuringUnit = "ML";
    }

    public static HotMilk getInstance()
    {
        if (single_instance == null)
            single_instance = new HotMilk();
  
        return single_instance;
    }

    public String getItemName(){
        return this.itemName;
    }

    public String getMeasuringUnit(){
        return this.measuringUnit;
    }
}