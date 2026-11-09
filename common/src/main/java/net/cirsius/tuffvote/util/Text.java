package net.cirsius.tuffvote.util;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class Text {

    @SafeVarargs
    public String format(@NotNull String message, @NotNull Tuple<String, Object>... args) {
        if (args.length == 0) return message;
        
        String result = message;
        
        for (Tuple<String, Object> token : args) {
            if (token.getSecond() instanceof String string) {
                result = result.replace(token.getFirst(), string);
            }
        }
        return result;
    }
}
