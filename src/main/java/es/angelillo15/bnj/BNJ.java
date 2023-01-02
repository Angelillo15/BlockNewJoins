package es.angelillo15.bnj;

import es.angelillo15.bnj.config.ConfigLoader;
import es.angelillo15.bnj.listener.OnPreLogin;
import lombok.Getter;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public class BNJ extends JavaPlugin {
    @Getter
    private static ArrayList<UUID> players = new ArrayList<>();
    @Getter
    private static BNJ plugin;
    @Override
    public void onEnable() {
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        plugin = this;
    }

    public void loadConfig(){
        new ConfigLoader().load();
    }

    public void loadListeners(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new OnPreLogin(), this);
    }

    public static void addPlayer(UUID uuid){
        players.add(uuid);
    }

    public static void removePlayer(UUID uuid){
        players.remove(uuid);
    }
}
