package es.angelillo15.bnj.config;

import es.angelillo15.bnj.BNJ;
import es.angelillo15.configmanager.ConfigManager;
import lombok.Getter;

public class ConfigLoader {
    @Getter
    private static ConfigManager config;

    public void load(){
        config = new ConfigManager(BNJ.getPlugin().getDataFolder().toPath(), "config.yml", "config.yml");
        config.registerConfig();
    }

}
