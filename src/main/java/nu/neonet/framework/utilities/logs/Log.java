package nu.neonet.framework.utilities.logs;

import nu.neonet.framework.Framework;
import nu.neonet.framework.utilities.color.ColorTranslator;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Log {

    public static void info(String message) {
        Framework.getAPI().getLogger().info(ColorTranslator.string(message));
    }

    public static void warning(String message) {
        Framework.getAPI().getLogger().warning(ColorTranslator.string(message));
    }

    public static void error(String message) {
        Framework.getAPI().getLogger().severe(ColorTranslator.string(message));
    }

    public static void startup() {
        Bukkit.getConsoleSender().sendMessage(ColorTranslator.string("&f\n&b  _   _            _   _      _     _____  _             _           \n" +
                "&b | \\ | |          | \\ | |    | |   |  __ \\| |           (_)          \n" +
                "&b |  \\| | ___  ___ |  \\| | ___| |_  | |__) | |_   _  __ _ _ _ __  ___ \n" +
                "&b | . ` |/ _ \\/ _ \\| . ` |/ _ \\ __| |  ___/| | | | |/ _` | | '_ \\/ __|\n" +
                "&b | |\\  |  __/ (_) | |\\  |  __/ |_  | |    | | |_| | (_| | | | | \\__ \\\n" +
                "&b |_| \\_|\\___|\\___/|_| \\_|\\___|\\__| |_|    |_|\\__,_|\\__, |_|_| |_|___/\n" +
                "&b                                                    __/ |            \n" +
                "&b                                                   |___/             "));
    }
}
