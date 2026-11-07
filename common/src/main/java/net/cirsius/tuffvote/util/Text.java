package net.cirsius.tuffvote.util;

import com.velocitypowered.api.proxy.Player;
import lombok.experimental.UtilityClass;
import net.md_5.bungee.api.connection.ProxiedPlayer;

@UtilityClass
public class Text {

    @SafeVarargs
    public String format(String message, Tuple<String, Object>... args) {
        String result = message;

        for (Tuple<String, Object> token : args) {
            if (token.getSecond() instanceof ProxiedPlayer player) {
                result = result.replace(token.getFirst(), player.getDisplayName());
            }
            if (token.getSecond() instanceof Player player) {
                result = result.replace(token.getFirst(), player.getUsername());
            }
            if (token.getSecond() instanceof String string) {
                result = result.replace(token.getFirst(), string);
            }
        }
        return "";
    }
}
