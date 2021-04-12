public interface OutletState {
    void next(Outlet outlet);
    void prev(Outlet outlet);
    void printStatus(Outlet outlet);
    String getState(Outlet outlet);
}