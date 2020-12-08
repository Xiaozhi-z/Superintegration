package com.xiaozhi.superintegration.event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class EnterBed implements Listener {
    @EventHandler
    public void Enterbed(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.YELLOW + "你躺在了床上");
    }
}
