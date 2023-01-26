package dev.tim.rankstutorial.commands;

import dev.tim.rankstutorial.managers.RankManager;
import dev.tim.rankstutorial.storage.Rank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetRankCommand implements CommandExecutor {

    //          /setrank <player> <rank>

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            if(args.length == 2){
                if(Bukkit.getPlayer(args[0]) != null){
                    Player target = Bukkit.getPlayer(args[0]);

                    switch (args[1]){
                        case "owner":
                            RankManager.setRank(Rank.OWNER, target);
                            target.sendMessage(ChatColor.GREEN + "You now have the rank: " + RankManager.getRank(target).getPrefix());
                            return true;
                        case "admin":
                            RankManager.setRank(Rank.ADMIN, target);
                            target.sendMessage(ChatColor.GREEN + "You now have the rank: " + RankManager.getRank(target).getPrefix());
                            return true;
                        case "moderator":
                            RankManager.setRank(Rank.MODERATOR, target);
                            target.sendMessage(ChatColor.GREEN + "You now have the rank: " + RankManager.getRank(target).getPrefix());
                            return true;
                        case "member":
                            RankManager.setRank(Rank.MEMBER, target);
                            target.sendMessage(ChatColor.GREEN + "You now have the rank: " + RankManager.getRank(target).getPrefix());
                            return true;
                        default:
                            player.sendMessage(ChatColor.RED + "Player not found!");
                            player.sendMessage(ChatColor.RED + "Options for ranks are: OWNER, ADMIN, MODERATOR, MEMBER");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Player not found!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Use: /setrank <player> <rank>");
            }
        }

        return true;
    }
}
