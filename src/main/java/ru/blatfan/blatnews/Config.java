package ru.blatfan.blatnews;

import org.bukkit.plugin.java.JavaPlugin;
import ru.blatfan.blatlibs.config.BaseConfig;

public class Config extends BaseConfig {
    public Config(JavaPlugin plugin) {
        super(plugin, "config.yml", true);
    }
}
