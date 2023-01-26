package dev.tim.rankstutorial.managers;

import dev.tim.rankstutorial.storage.Rank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

public class NametagManager {

    public static void setNametag(Player player){
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        for(Rank rank : Rank.values()){
            Team team = player.getScoreboard().registerNewTeam(rank.name());
            team.setPrefix(rank.getPrefix() + ChatColor.WHITE + " | ");
        }

        for(Player target : Bukkit.getOnlinePlayers()){
            if(player.getUniqueId() != target.getUniqueId()){
                player.getScoreboard().getTeam(RankManager.getRank(target).name()).addEntry(target.getName());
            }
        }
    }

    public static void newTag(Player player){
        Rank rank = RankManager.getRank(player);
        for(Player target : Bukkit.getOnlinePlayers()){
            target.getScoreboard().getTeam(rank.name()).addEntry(player.getName());
        }
    }

    public static void removeTag(Player player){
        for(Player target : Bukkit.getOnlinePlayers()){
            target.getScoreboard().getEntryTeam(player.getName()).removeEntry(player.getName());
        }
    }

}
