package nu.neonet.framework;

import org.bukkit.plugin.java.JavaPlugin;

public final class Framework extends JavaPlugin {

    private static Framework api;

    @Override
    public void onEnable() {
        api = this;
    }

    @Override
    public void onDisable() {

    }

    public static Framework getAPI() {
        return api;
    }
}
