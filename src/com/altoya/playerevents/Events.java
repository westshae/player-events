package com.altoya.playerevents;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class Events implements Listener {

    @EventHandler
    public void enterBed(PlayerBedEnterEvent event){
        Player player = event.getPlayer();

        if(!event.isCancelled()){
            player.sendMessage(ChatColor.LIGHT_PURPLE + "You have entered a bed.");

        }
    }

    @EventHandler
    public void leaveBed(PlayerBedLeaveEvent event){
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.LIGHT_PURPLE + "You have exited a bed.");
    }

    @EventHandler
    public void changeWorld(PlayerChangedWorldEvent event){
        Player player = event.getPlayer();
        if (event.getPlayer().getLocation().getWorld().getName().endsWith("_nether")){
            player.sendMessage(ChatColor.LIGHT_PURPLE + "You have entered the nether");
        }
        if (event.getPlayer().getLocation().getWorld().getName().endsWith("_end")){
            player.sendMessage(ChatColor.LIGHT_PURPLE + "You have entered the end");
        }
        if (event.getPlayer().getLocation().getWorld().getName().equalsIgnoreCase("world")){
            player.sendMessage(ChatColor.LIGHT_PURPLE + "You have entered the Overworld");
        }
    }
}