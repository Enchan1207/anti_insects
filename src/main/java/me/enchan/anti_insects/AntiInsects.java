//
// Anti-insects
//
package me.enchan.anti_insects;

import org.bukkit.plugin.java.JavaPlugin;

public class AntiInsects extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Anti-insects plugin enabled.");
        getServer().getPluginManager().registerEvents(new MobSpawnListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Anti-insects plugin disabled.");
    }
}
