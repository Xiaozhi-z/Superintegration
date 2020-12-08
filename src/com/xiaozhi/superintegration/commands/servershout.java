package com.xiaozhi.superintegration.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class servershout implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player)commandSender;
            String playername = player.getName();
            player.sendMessage("插件正在制作中...");
        } else {
            System.out.println("[Error]该指令只能由玩家执行");
        }

        return false;
    }
}

