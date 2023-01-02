package es.angelillo15.bnj.utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import es.angelillo15.bnj.BNJ;
import org.bukkit.entity.Player;

public class BungeeUtils {
    /**
     * @param player The player to send the message to
     * @param server The server to send the player to
     */
    public static void sendToServer(Player player, String server){
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server);

        player.sendPluginMessage(BNJ.getPlugin(), "BungeeCord", out.toByteArray());
    }
}
