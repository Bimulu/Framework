package nu.neonet.framework.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private final JavaPlugin plugin;
    private final Map<String, FCommand> commands = new HashMap<>();
    private CommandMap commandMap;

    public CommandManager(JavaPlugin plugin) {
        this.plugin = plugin;

        try {
            Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            field.setAccessible(true);
            commandMap = (CommandMap) field.get(Bukkit.getServer());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerCommand(FCommand command) {
        commands.put(command.getName(), command);
        commandMap.register(plugin.getName(), command);
    }

    public void registerCommandsFromClass(Object object) {
        for (var method : object.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(CommandInfo.class)) {
                CommandInfo commandInfo = method.getAnnotation(CommandInfo.class);

                FCommand command = new FCommand(commandInfo.name()) {
                    @Override
                    public boolean run(CommandSender sender, String[] args) {
                        try {
                            return (boolean) method.invoke(object, sender, args);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }
                };

                registerCommand(command);
            }
        }
    }
}
