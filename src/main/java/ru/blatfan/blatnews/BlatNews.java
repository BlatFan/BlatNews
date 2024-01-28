package ru.blatfan.blatnews;

import org.bukkit.plugin.java.JavaPlugin;

public final class BlatNews extends JavaPlugin {
    public static Config config;
    public static BlatNews blatNews;

    @Override
    public void onEnable() {
        blatNews=this;

        config=new Config(this);
        config.save();

        saveResource("news.txt", false);

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
