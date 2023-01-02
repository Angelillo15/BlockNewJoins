package es.angelillo15.bnj.listener;

import es.angelillo15.bnj.BNJ;
import es.angelillo15.bnj.config.Config;
import es.angelillo15.bnj.utils.BungeeUtils;
import es.angelillo15.bnj.utils.TextUtils;
import es.angelillo15.bnj.utils.TitleUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.nio.file.Path;
import java.util.UUID;

public class OnPreLogin implements Listener {
    @EventHandler
    public void onPreLogin(AsyncPlayerPreLoginEvent event){
        UUID playerUUID = event.getUniqueId();
        Path essentialsUserData = Path.of(BNJ.getPlugin().getDataFolder().getParent() + "/Essentials/userdata/" + playerUUID.toString()+ ".yml");
        BNJ.getPlugin().getLogger().info(essentialsUserData.toString());
        File userData = new File(essentialsUserData.toString());
        if(!userData.exists()){
            BNJ.getPlugin().getLogger().info("User not found");
            BNJ.addPlayer(playerUUID);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        UUID playerUUID = event.getPlayer().getUniqueId();
        Path essentialsUserData = Path.of(BNJ.getPlugin().getDataFolder().getParent() + "/Essentials/userdata/" + playerUUID.toString()+ ".yml");
        File userData = new File(essentialsUserData.toString());

        if(!userData.exists()){
            if(Config.isEnableTitle()){
                TitleUtils.sendTitle(
                        event.getPlayer(),
                        Config.getTittleMessage(),
                        Config.getSubtitleMessage(),
                        20,
                        Config.timeBeforeKick() * 20,
                        20
                );
            }

            Config.getWarningNewPlayers().forEach(text -> {
                event.getPlayer().sendMessage(TextUtils.colorize(text));
            });

            if(Config.isEnableBlindness()) {
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,
                        Config.timeBeforeKick() * 200,
                        1)
                );
            }

            if(Config.isDisableMovement()){
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW,
                        Config.timeBeforeKick() * 200,
                        10000)
                );
            }

            deleteFileAsync(userData, event.getPlayer().getUniqueId(), Config.timeBeforeKick());
        } else {
            Config.getWarningOldPlayers().forEach(text -> {
                event.getPlayer().sendMessage(TextUtils.colorize(text));
            });
        }
    }

    public void deleteFileAsync(File file, UUID uuid, int timeOut){
        Bukkit.getScheduler().runTaskLaterAsynchronously(BNJ.getPlugin(), () -> {
            if(Bukkit.getPlayer(uuid) != null){
                BungeeUtils.sendToServer(Bukkit.getPlayer(uuid), Config.redirectServer());
            }

            Bukkit.getScheduler().runTaskLaterAsynchronously(BNJ.getPlugin(), () -> {
                if(file.exists()){
                    file.delete();
                }
            }, 80L);


        }, timeOut * 20);
    }
}
