package jp.yama2211.randtp.cmd;

import jp.yama2211.randtp.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class randSet implements CommandExecutor {
    public Main plugin;
    public randSet(Main plugin){this.plugin = plugin;}

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.hasPermission("randtp.admin")){
            try{
                int i = Integer.parseInt(args[0]);
                this.plugin.getConfig().set("Int",i);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "保存しました。");
            } catch (Exception e) {
                sender.sendMessage(ChatColor.RED + "保存に失敗しました。数字以外が入力された可能性があります。: " + args[0]);
            }
        } else {
            sender.sendMessage(ChatColor.RED + "権限がありません。");
        }

        return false;
    }

}
