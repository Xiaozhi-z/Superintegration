package com.xiaozhi.superintegration.commands;

import com.xiaozhi.superintegration.event.PlaceholaderHook;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerCommands extends JavaPlugin {
    private PlaceholaderHook papiHook;
    public void onEnable() {
        if (this.getServer().getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            this.papiHook = new PlaceholaderHook();
        }
    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("PlayerCommands.admin")) {
            return true;
        } else if (args.length == 0) {
            sender.sendMessage(ChatColor.AQUA + "/manipulation <玩家> <指令>");
            return true;
        } else if (args.length < 2) {
            sender.sendMessage(ChatColor.RED + "参数错误.");
            return true;
        } else {
            Player target = this.getServer().getPlayer(args[0]);
            if (target == null) {
                sender.sendMessage(ChatColor.RED + "目标玩家不存在或不在线.");
                return true;
            } else {
                StringBuilder builder = new StringBuilder();
                for(int i = 1; i < args.length; ++i) {
                    builder.append(args[i] + " ");
                }
                String text = builder.toString();
                text = this.papiHook.parse(target, text).trim().replace("&", "§").replace("[player]", target.getName()).replace("%player%", target.getName());
                String[] var11;
                int var10 = (var11 = text.split(";")).length;

                for(int var9 = 0; var9 < var10; ++var9) {
                    String cmd = var11[var9];
                    this.executeCommand(target, cmd);
                }
                return true;
            }
        }
    }

    private void executeCommand(Player player, String command) {
        String cmd;
        label99: {
            label98: {
                String[] args = command.split(":", 2);
                String type = args.length == 2 ? args[0] : "player";
                cmd = args.length == 2 ? args[1] : args[0];
                String var6;
                switch((var6 = type.toLowerCase()).hashCode()) {
                    case -985752863:
                        if (!var6.equals("player")) {
                        }
                        break label99;
                    case 99:
                        if (!var6.equals("c")) {
                            break label99;
                        }
                        break label98;
                    case 109:
                        if (!var6.equals("m")) {
                            break label99;
                        }
                        break;
                    case 112:
                        if (!var6.equals("p")) {
                        }
                        break label99;
                    case 108417:
                        if (!var6.equals("msg")) {
                            break label99;
                        }
                        break;
                    case 3556273:
                        if (!var6.equals("tell")) {
                            break label99;
                        }
                        break;
                    case 951510359:
                        if (!var6.equals("console")) {
                            break label99;
                        }
                        break label98;
                    default:
                        break label99;
                }

                player.sendMessage(cmd);
                return;
            }

            this.getServer().dispatchCommand(this.getServer().getConsoleSender(), cmd);
            return;
        }

        boolean isOp = player.isOp();

        try {
            player.setOp(true);
            player.chat(cmd);
        } finally {
            player.setOp(isOp);
        }

    }
}
