package com.xiaozhi.superintegration.event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class LeaveBed implements Listener {
    @EventHandler
    public void LeaveBed(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.YELLOW + "你离开了床");
    }
}

