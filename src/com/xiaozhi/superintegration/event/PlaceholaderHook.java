package com.xiaozhi.superintegration.event;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class PlaceholaderHook implements Listener {
    public String parse(Player player, String text) {
        return PlaceholderAPI.setPlaceholders(player, text);
    }
}