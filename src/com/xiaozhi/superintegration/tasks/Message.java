package com.xiaozhi.superintegration.tasks;

import org.bukkit.Bukkit;
import com.xiaozhi.superintegration.Superintegration;
import org.bukkit.scheduler.BukkitRunnable;

public class Message extends BukkitRunnable {
    Superintegration plugin = com.xiaozhi.superintegration.Superintegration.getPlugin(Superintegration.class);
    private int i = 0;
    public static int list(int i) {
        ++i;
        return i;
    }
    public void run() {
        if (this.i < this.plugin.getConfig().getStringList("Message-list").size()) {
            this.plugin.getServer().broadcastMessage((String)this.plugin.getConfig().getStringList("Message-list").get(this.i));
            this.i = list(this.i);
        } else {
            this.i = 0;
            Bukkit.getServer().broadcastMessage((String)this.plugin.getConfig().getStringList("Message-list").get(this.i));
            this.i = list(this.i);
        }

    }
}

