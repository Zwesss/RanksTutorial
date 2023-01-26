package dev.tim.rankstutorial;

import dev.tim.rankstutorial.commands.SetRankCommand;
import dev.tim.rankstutorial.commands.TestCommand;
import dev.tim.rankstutorial.listeners.RankListeners;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;


public final class Main extends JavaPlugin {

    private static HashMap<UUID, PermissionAttachment> perms = new HashMap<>();

    private static Main main;

    @Override
    public void onEnable() {
        main = this;

        getConfig().options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(new RankListeners(), this);
        getCommand("setrank").setExecutor(new SetRankCommand());
        getCommand("test").setExecutor(new TestCommand());
    }

    @Override
    public void onDisable() {
        main = null;
        perms.clear();
    }

    public static Main getMain(){
        return main;
    }

    public static HashMap<UUID, PermissionAttachment> getPerms(){
        return perms;
    }
}
