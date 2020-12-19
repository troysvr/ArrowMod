package com.vj.arrowmod.infinity;

import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {
	
    @Override
    public void onEnable() {
        // TODO Insert logic to be performed when the plugin is enabled
    	getLogger().info("ArrowMod Infinity is enabled!");
    	getServer().getPluginManager().registerEvents(new ArrowFireListener(), this);
    }
    
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    	getLogger().info("ArrowMod Infinity is disabled!");
    }

}
