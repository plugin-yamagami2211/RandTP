package jp.yama2211.randtp;

import jp.yama2211.randtp.cmd.randTP;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        loadCMD();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadCMD(){
        getCommand("randtp").setExecutor(new randTP(this));
    }
}
