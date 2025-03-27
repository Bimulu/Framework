package nu.neonet.framework.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public abstract class FCommand extends Command {

    protected FCommand(String name) {
        super(name);
    }

    public abstract boolean run(CommandSender sender, String[] args);

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String s, @NotNull String @NotNull [] args) {
        return run(sender, args);
    }
}
