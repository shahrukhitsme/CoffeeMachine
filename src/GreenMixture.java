//It is an item and is a singleton class
class GreenMixture implements Item {

    String itemName;
    String measuringUnit;

    private static GreenMixture single_instance = null;

    private GreenMixture()
    {
        itemName = "Green Mixture";
        measuringUnit = "GM";
    }

    public static GreenMixture getInstance()
    {
        if (single_instance == null)
            single_instance = new GreenMixture();
  
        return single_instance;
    }

    public String getItemName(){
        return this.itemName;
    }

    public String getMeasuringUnit(){
        return this.measuringUnit;
    }
}