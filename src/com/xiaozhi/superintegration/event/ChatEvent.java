package com.xiaozhi.superintegration.event;

import com.xiaozhi.superintegration.Superintegration;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {
    Superintegration plugin = Superintegration.getPlugin(Superintegration.class);
    @EventHandler
    public void ChatEvent(AsyncPlayerChatEvent event) {
            String Message = event.getMessage();
            Player player = event.getPlayer();
            for (int i = 0 ; i < plugin.getConfig().getStringList("Shieldingwords").size() ; i++){
                if (Message.contains(plugin.getConfig().getStringList("Shieldingwords").get(i))){
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "请注意个人发言");
                }
            }
        }
    }

