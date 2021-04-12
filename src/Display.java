//It is a singleton class for printing any message to console. If we have a different kind of display in the future, we can just update here. It is used in many places using dependency injection.
class Display {

    private static Display single_instance = null;

    public static Display getInstance()
    {
        if (single_instance == null)
            single_instance = new Display();
  
        return single_instance;
    }

    public void show(String message){
        System.out.println(message);
    }
}