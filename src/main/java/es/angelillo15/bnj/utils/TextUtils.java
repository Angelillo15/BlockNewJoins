package es.angelillo15.bnj.utils;

import net.md_5.bungee.api.ChatColor;

public class TextUtils {
    public static String colorize(String text){
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
