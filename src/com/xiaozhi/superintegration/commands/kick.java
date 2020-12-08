package com.xiaozhi.superintegration.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class kick implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender.hasPermission("Superintegration.Commands.kick")) {
            if (strings.length == 2) {
                String Message = strings[1];
                Player player = Bukkit.getServer().getPlayer(strings[0]);
                if (player == null) {
                    commandSender.sendMessage(ChatColor.RED + strings[0] + "该玩家不存在");
                    return false;
                }
                player.kickPlayer(Message);
            } else {
                if (strings.length != 1) {
                    commandSender.sendMessage(ChatColor.RED + "您使用的指令语法不正确");
                    commandSender.sendMessage(ChatColor.RED + "正确方法为：/kick <Player> <Message>");
                    return false;
                }

                Player player = Bukkit.getServer().getPlayer(strings[0]);
                if (player == null) {
                    commandSender.sendMessage(ChatColor.RED + strings[0] + "该玩家不存在");
                    return false;
                }
                player.kickPlayer("你被踢出服务器");
            }
        } else {
            commandSender.sendMessage(ChatColor.RED + "你没有使用该指令的权限");
         }
        return false;
    }
}
