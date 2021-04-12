//It is a class representing Preparing state of Outlet
class PreparingOutletState implements OutletState {

    @Override
    public void next(Outlet outlet) {
        outlet.setState(new DispensingOutletState());
    }

    @Override
    public void prev(Outlet outlet) {
        outlet.setState(new FreeOutletState());
    }

    @Override
    public void printStatus(Outlet outlet) {
        System.out.println("Outlet "+outlet.outletNumber+": Beverage is being prepared");
    }

    @Override
    public String getState(Outlet outlet) {
        return "PREPARING";
    }
}