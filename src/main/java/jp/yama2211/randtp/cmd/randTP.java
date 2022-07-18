package jp.yama2211.randtp.cmd;

import jp.yama2211.randtp.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class randTP implements CommandExecutor {
    public Main plugin;
    public randTP(Main plugin){this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "ゲーム内から実行してください。");
            return true;
        }
        if(sender.hasPermission("randtp.use")){
            Player player = (Player)sender;

            Random rand = new Random();
            int x = rand.nextInt(40000) -20000;
            int y = 200;
            int z = rand.nextInt(40000) -20000;

            sender.sendMessage("x: " + x + " z: " + z);
            try{
                World w = player.getWorld();

                Location loc = new Location(w,x,y,z);
                loc.setPitch(player.getLocation().getPitch());
                loc.setYaw(player.getLocation().getYaw());

                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,200,100));

                player.teleport(loc);
                player.sendMessage("x: " + x + " y: " + y + " z: "+ z + " にTPしました。");
            }catch (Exception e){
                player.sendMessage(ChatColor.RED + "TPに失敗しました。");
            }

            return true;

        } else {
            sender.sendMessage(ChatColor.RED + "権限がありません。");
            return true;
        }
    }
}
