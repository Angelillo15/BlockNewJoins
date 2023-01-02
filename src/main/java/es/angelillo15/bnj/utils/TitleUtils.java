package es.angelillo15.bnj.utils;

import org.bukkit.entity.Player;

public class TitleUtils {
    /**
     * @param player The player to send the title to
     * @param title The title to send
     * @param subtitle The subtitle to send
     * @param fadeIn The time in ticks for the title to fade in
     * @param stay The time in ticks for the title to stay
     * @param fadeOut The time in ticks for the title to fade out
     */
    public static void sendTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut){
        player.sendTitle(TextUtils.colorize(title),
                TextUtils.colorize(subtitle),
                fadeIn, stay, fadeOut
        );
    }

    /**
     * @param player The player to send the title to
     * @param title The title to send
     * @param subtitle The subtitle to send
     */
    public static void sendTitle(Player player, String title, String subtitle){
        sendTitle(player, title, subtitle, 20, 1000, 20);
    }
}
