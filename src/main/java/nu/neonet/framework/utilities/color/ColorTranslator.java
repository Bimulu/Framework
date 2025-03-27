package nu.neonet.framework.utilities.color;

import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorTranslator {
    public static final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
    private static final Pattern HEX_PATTERN = Pattern.compile("(&#[0-9a-fA-F]{6})");

    public static String string(@NotNull String text) {

        Matcher matcher = HEX_PATTERN.matcher(text);
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String hex = matcher.group(1).substring(1);
            matcher.appendReplacement(buffer, "" + ChatColor.of(hex));
        }

        matcher.appendTail(buffer);

        String hexColored = buffer.toString();

        return ChatColor.translateAlternateColorCodes('&', hexColored);
    }

    public static TextComponent component(@NotNull String text) {
        String colored = string(text);

        TextComponent base = new TextComponent();
        BaseComponent[] converted = TextComponent.fromLegacyText(colored);

        for (BaseComponent comp : converted) {
            base.addExtra(comp);
        }

        return base;
    }

    public static Component adventure(String text) {
        return Component.text(string(text));
    }
}
