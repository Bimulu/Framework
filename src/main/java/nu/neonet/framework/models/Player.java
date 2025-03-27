package nu.neonet.framework.models;

import nu.neonet.framework.utilities.color.ColorTranslator;

public abstract class Player implements org.bukkit.entity.Player {

    public void test() {
        sendMessage(ColorTranslator.string("&dDu sutter"));
    }
}
