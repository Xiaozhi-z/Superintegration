package com.xiaozhi.superintegration.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GPS implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            String GPS = ChatColor.YELLOW + "已为你查询玩家(%player_name%)当前位置[%player_x%,%player_y%,%player_z%]";
            GPS = PlaceholderAPI.setPlaceholders(player, GPS);
            player.sendMessage(GPS);
            return false;
        }
        if (strings.length != 1) {
           commandSender.sendMessage(ChatColor.RED + "您使用的指令语法不正确");
           commandSender.sendMessage(ChatColor.RED + "正确方法为：/kick <Player>");
           return false;
        } else {
            commandSender.sendMessage(ChatColor.RED + "[Error]该指令只能由玩家执行");
            }
        return false;
    }
}

