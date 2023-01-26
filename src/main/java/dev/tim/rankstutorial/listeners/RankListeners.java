package dev.tim.rankstutorial.listeners;

import dev.tim.rankstutorial.Main;
import dev.tim.rankstutorial.managers.NametagManager;
import dev.tim.rankstutorial.managers.RankManager;
import dev.tim.rankstutorial.storage.Rank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class RankListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Main main = Main.getMain();
        FileConfiguration config = main.getConfig();
        Player player = e.getPlayer();
        String uuid = player.getUniqueId().toString();

        if(!config.contains(uuid)){
            RankManager.setRank(Rank.MEMBER, player);
        } else {
            RankManager.removePermissions(player);
            RankManager.setPermissions(player);
        }

        NametagManager.setNametag(player);
        NametagManager.newTag(player);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        NametagManager.removeTag(e.getPlayer());
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();
        String message = e.getMessage();
        String name = player.getDisplayName();

        e.setCancelled(true);
        Bukkit.broadcastMessage(RankManager.getRank(player).getPrefix() + ChatColor.WHITE + " | " + name + ": " + ChatColor.GRAY + message);
    }

}
