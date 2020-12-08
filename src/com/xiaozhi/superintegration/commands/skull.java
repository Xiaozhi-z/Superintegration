package com.xiaozhi.superintegration.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class skull implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player)commandSender;
            ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
            SkullMeta meta = (SkullMeta)skull.getItemMeta();
            meta.setDisplayName(ChatColor.YELLOW + player.getName());
            meta.setOwner(player.getName());
            skull.setItemMeta(meta);
            player.getInventory().addItem(new ItemStack[]{skull});
            return false;
        } else {
            commandSender.sendMessage(ChatColor.RED + "[Error]该指令只能由玩家执行！");
            return false;
        }
    }
}

