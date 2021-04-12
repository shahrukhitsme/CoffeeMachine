//It is a class representing Free state of Outlet
class FreeOutletState implements OutletState {

    @Override
    public void next(Outlet outlet) {
        outlet.setState(new PreparingOutletState());
    }

    @Override
    public void prev(Outlet outlet) {
        System.out.println("The package is in its root state.");
    }

    @Override
    public void printStatus(Outlet outlet) {
        System.out.println("Outlet "+outlet.outletNumber+" is free to use.");
    }

    @Override
    public String getState(Outlet outlet) {
        return "FREE";
    }
}