package org.lemonkingdommods.magicplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class MagicPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("pig").setExecutor(new Command());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
