package com.xiaozhi.superintegration;

import org.bukkit.Bukkit;
import com.xiaozhi.superintegration.commands.*;
import com.xiaozhi.superintegration.event.*;
import com.xiaozhi.superintegration.tasks.Message;
import org.bukkit.plugin.java.JavaPlugin;

public class Superintegration extends JavaPlugin{
    public void onLoad() {
        System.out.println("[superintegration]Command package reading...");
        System.out.println("[superintegration]Event   package reading...");
        System.out.println("[Superintegration]GUI     package reading...");
        System.out.println("[Superintegration]Plugin  package reading...");
        System.out.println("[Superintegration]author: xiaozhi_z");
    }
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            this.getConfig().options().copyDefaults();
            this.saveDefaultConfig();
            int time = this.getConfig().getInt("Message-time");
            (new Message()).runTaskTimer(this, 0L, (long) (time * 20));
            this.getServer().getPluginManager().registerEvents(new ChatEvent(), this);
            this.getServer().getPluginManager().registerEvents(new Playerjoin(), this);
            this.getServer().getPluginManager().registerEvents(new LeaveBed(), this);
            this.getServer().getPluginManager().registerEvents(new EnterBed(), this);
            this.getCommand("servershout").setExecutor(new servershout());
            this.getCommand("kick").setExecutor(new kick());
            this.getCommand("ping").setExecutor(new ping());
            this.getCommand("skull").setExecutor(new skull());
            this.getCommand("level").setExecutor(new level());
            this.getCommand("GPS").setExecutor(new GPS());
            this.getCommand("Detectionmode").setExecutor(new Detectionmode());
            System.out.println("[Superintegration]Command package loaded...");
            System.out.println("[Superintegration]Event   package loaded...");
            System.out.println("[Superintegration]GUI     package loaded...");
            System.out.println("[Superintegration]Plugin  package loaded...");
            System.out.println("[Superintegration]The PlaceholderAPI is connected");
            System.out.println("[Superintegration]author: xiaozhi_z");
        } else {
            Bukkit.shutdown();
            throw new RuntimeException("Placeholder API not found, server shut down");
        }
    }
    public void onDisable() {
        System.out.println("[Superintegration]Command package unloaded...");
        System.out.println("[Superintegration]Event   package unloaded...");
        System.out.println("[Superintegration]GUI     package unloaded...");
        System.out.println("[Superintegration]Plugin  package unloaded...");
        System.out.println("[Superintegration]author: xiaozhi_z");
    }
}