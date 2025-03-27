package nu.neonet.framework.plugin;

import nu.neonet.framework.utilities.logs.Log;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class FrameworkPlugin extends JavaPlugin {

    public abstract void start();
    public abstract void stop();

    @Override
    public void onEnable() {
        Log.startup();

        start();
    }

    @Override
    public void onDisable() {
        stop();
    }

    protected void registerListeners(Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) Bukkit.getPluginManager().registerEvents(listener, plugin);
    }
}
