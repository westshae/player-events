package com.altoya.playerevents;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
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
    
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
    	if(event.getEntity() instanceof EnderDragon) {
    		String playerName = event.getEntity().getKiller().getName();
    		
    		if(event.getEntity().getKiller() == null) {
    			return;
    		}
    		
    		for(Player allPlayer : Bukkit.getOnlinePlayers()) {
    			allPlayer.sendMessage(ChatColor.LIGHT_PURPLE + playerName +" has killed the enderdragon");
    		}
    	}
    	
    	if(event.getEntity() instanceof Wither) {
    		String playerName = event.getEntity().getKiller().getName();
    		
    		if(event.getEntity().getKiller() == null) {
    			return;
    		}
    		
    		for(Player allPlayer : Bukkit.getOnlinePlayers()) {
    			allPlayer.sendMessage(ChatColor.LIGHT_PURPLE + playerName + " has killed the wither");
    		}
    	}
    }
}