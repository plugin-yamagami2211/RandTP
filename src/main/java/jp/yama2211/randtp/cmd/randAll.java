package jp.yama2211.randtp.cmd;

import jp.yama2211.randtp.Main;
import org.bukkit.Bukkit;
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

public class randAll implements CommandExecutor {
        public Main plugin;
        public randAll(Main plugin){this.plugin = plugin;}

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if(!(sender instanceof Player)){
                sender.sendMessage(ChatColor.RED + "ゲーム内から実行してください！");
                return false;
            } else {
                if(sender.hasPermission("randtp.alltp")){
                    Player player = (Player)sender;
                    int Conf = plugin.getConfig().getInt("Int");

                    Random rand = new Random();
                    int x = rand.nextInt(Conf * 2) - Conf;
                    int y = 200;
                    int z = rand.nextInt(Conf * 2) - Conf;

                    try{
                        World w = player.getWorld();

                        Location loc = new Location(w,x,y,z);
                        loc.setPitch(player.getLocation().getPitch());
                        loc.setYaw(player.getLocation().getYaw());

                        for(Player ps : Bukkit.getOnlinePlayers()){
                            ps.teleport(loc);
                            ps.sendMessage("x: " + x + " y: " + y + " z: "+ z + " にTPしました。");
                            ps.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,200,100));
                        }
                        return false;
                    }catch (Exception e){
                        player.sendMessage(ChatColor.RED + "TPに失敗しました。");
                    }
                }
            }
            return false;
    }
}
