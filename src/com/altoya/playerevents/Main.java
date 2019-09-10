package com.altoya.playerevents;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override   
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new Events(), this);

    }

    @Override
    public void onDisable() {

    }
}