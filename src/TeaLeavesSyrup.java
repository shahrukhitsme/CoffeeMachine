//It is an item and is a singleton class
class TeaLeavesSyrup implements Item {

    String itemName;
    String measuringUnit;

    private static TeaLeavesSyrup single_instance = null;

    private TeaLeavesSyrup()
    {
        itemName = "Tea Leaves Syrup";
        measuringUnit = "ML";
    }

    public static TeaLeavesSyrup getInstance()
    {
        if (single_instance == null)
            single_instance = new TeaLeavesSyrup();
  
        return single_instance;
    }

    public String getItemName(){
        return this.itemName;
    }

    public String getMeasuringUnit(){
        return this.measuringUnit;
    }
}