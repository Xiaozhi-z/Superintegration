package com.xiaozhi.superintegration.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class level implements CommandExecutor {
    public boolean onCommand(CommandSender Sender, Command command, String s, String[] strings) {
        if (Sender instanceof Player) {
            if (strings.length == 1) {
                String message = ChatColor.YELLOW + "已为你查询[%player_name%]的等级为：%player_level%";
                Player target = Bukkit.getPlayer(strings[0]);
                message = PlaceholderAPI.setPlaceholders(target, message);
                Player player = (Player)Sender;
                player.sendMessage(message);
                return false;
            }
        } else {
            Sender.sendMessage(ChatColor.RED + "[Error]该指令只能由玩家执行");
        }

        return false;
    }
}
