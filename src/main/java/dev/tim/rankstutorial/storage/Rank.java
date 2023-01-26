package dev.tim.rankstutorial.storage;

import org.bukkit.ChatColor;

public enum Rank {

    OWNER(ChatColor.RED + "Owner", new String[]{"test.use"}),
    ADMIN(ChatColor.YELLOW + "Admin", new String[]{"test.use"}),
    MODERATOR(ChatColor.BLUE + "Moderator", new String[]{"fly.use", "heal.use"}),
    MEMBER(ChatColor.GRAY + "Member", new String[]{});

    private String prefix;
    private String[] permissions;

    Rank(String prefix, String[] permissions){
        this.prefix = prefix;
        this.permissions = permissions;
    }

    public String getPrefix(){
        return prefix;
    }

    public String[] getPermissions(){
        return permissions;
    }

}