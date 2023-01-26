package dev.tim.rankstutorial.managers;

import dev.tim.rankstutorial.Main;
import dev.tim.rankstutorial.storage.Rank;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.UUID;

public class RankManager {

    public static void setRank(Rank rank, Player player){
        Main main = Main.getMain();
        FileConfiguration config = main.getConfig();
        String uuid = player.getUniqueId().toString();

        if(config.contains(uuid)){
            removePermissions(player);
        }
        config.set(uuid, rank.name());
        main.saveConfig();
        setPermissions(player);

        NametagManager.setNametag(player);
        NametagManager.newTag(player);
    }

    public static Rank getRank(Player player){
        Main main = Main.getMain();
        FileConfiguration config = main.getConfig();

        return Rank.valueOf(config.getString(player.getUniqueId().toString()));
    }

    public static void setPermissions(Player player){
        Main main = Main.getMain();
        UUID uuid = player.getUniqueId();
        Rank rank = getRank(player);

        PermissionAttachment attachment = player.addAttachment(main);
        Main.getPerms().put(uuid, attachment);

        for(String perm : rank.getPermissions()){
            attachment.setPermission(perm, true);
        }
    }

    public static void removePermissions(Player player){
        UUID uuid = player.getUniqueId();
        Rank rank = getRank(player);

        for(String perm : rank.getPermissions()){
            Main.getPerms().get(uuid).unsetPermission(perm);
        }
    }

}
