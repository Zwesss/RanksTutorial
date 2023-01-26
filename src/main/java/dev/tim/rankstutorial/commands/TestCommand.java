package dev.tim.rankstutorial.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            if (player.hasPermission("test.use")) {
                player.sendMessage(ChatColor.GREEN + "TEST!");
            } else {
                player.sendMessage(ChatColor.RED + "You dont have permission to use this command!");
            }
        }
        return true;
    }
}
