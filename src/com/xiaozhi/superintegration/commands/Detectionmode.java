package com.xiaozhi.superintegration.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Detectionmode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (commandSender instanceof Player) {
        Player player = (Player) commandSender;
        String mode = ChatColor.YELLOW + "已为你查询玩家(%player_name%)当前模式为(%player_gamemode%)";
        mode = PlaceholderAPI.setPlaceholders(player, mode);
        player.sendMessage(mode);
        return false;
    }else {
        if (strings.length != 1) {
            commandSender.sendMessage(ChatColor.RED + "您使用的指令语法不正确");
            commandSender.sendMessage(ChatColor.RED + "正确方法为：/Detectionmode <Player>");
            return false;
        } else {
            commandSender.sendMessage(ChatColor.RED + "[Error]该指令只能由玩家执行");
        }
      }
        return false;
    }
}
