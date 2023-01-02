package es.angelillo15.bnj;

public class BNJLoader extends BNJ {
    @Override
    public void onEnable() {
        super.onEnable();
        getLogger().info("Loading...");
        loadConfig();
        loadListeners();
    }
}
