package es.angelillo15.bnj.config;

import es.angelillo15.bnj.utils.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class Config {

    public static Boolean isEnable(){
        return getBoolean("Config.enable");
    }

    public static Boolean isEnableRedirect(){
        return getBoolean("Config.enableRedirectServer");
    }

    public static int timeBeforeKick(){
        return ConfigLoader.getConfig().getConfig().getInt("Config.timeBeforeKick");
    }

    public static String redirectServer(){
        return get("Config.redirectServer");
    }

    public static Boolean isDisableMovement(){
        return getBoolean("Config.disableMovement");
    }

    public static Boolean isEnableBlindness(){
        return getBoolean("Config.enableBlindness");
    }

    public static Boolean isEnableTitle(){
        return getBoolean("Config.enableTitle");
    }

    public static String getPrefix(){
        return get("Messages.prefix");
    }

    public static String getReloadMessage(){
        return get("Messages.reload");
    }

    public static String getTittleMessage(){
        return get("Messages.title.title");
    }

    public static String getSubtitleMessage(){
        return get("Messages.title.subtitle");
    }

    public static List<String> getWarningNewPlayers(){
        return ConfigLoader.getConfig().getConfig().getStringList("Messages.warningNewPlayers");
    }

    public static List<String> getWarningOldPlayers(){
        return ConfigLoader.getConfig().getConfig().getStringList("Messages.warningOldPlayers");
    }

    public static String get(String path){
        return TextUtils.colorize(ConfigLoader.getConfig().getConfig().getString(path)
                .replace("{prefix}", getPrefix()));
    }

    public static Boolean getBoolean(String path){
        return ConfigLoader.getConfig().getConfig().getBoolean(path);
    }
}
