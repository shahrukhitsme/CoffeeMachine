//It is a class representing Dispensing state of Outlet
class DispensingOutletState implements OutletState {

    @Override
    public void next(Outlet outlet) {
        outlet.setState(new FreeOutletState());
    }

    @Override
    public void prev(Outlet outlet) {
        outlet.setState(new PreparingOutletState());
    }

    @Override
    public void printStatus(Outlet outlet) {
        System.out.println("Outlet "+outlet.outletNumber+": Beverage is being dispensed");
    }

    @Override
    public String getState(Outlet outlet) {
        return "DISPENSING";
    }
}