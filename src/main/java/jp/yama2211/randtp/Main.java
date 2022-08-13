package jp.yama2211.randtp;

import jp.yama2211.randtp.cmd.randAll;
import jp.yama2211.randtp.cmd.randSet;
import jp.yama2211.randtp.cmd.randTP;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        loadCMD();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadCMD(){
        getCommand("randtp").setExecutor(new randTP(this));
        getCommand("randtpall").setExecutor(new randAll(this));
        getCommand("randset").setExecutor(new randSet(this));
    }
}
