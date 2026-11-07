package net.cirsius.tuffvote.models;

import java.util.List;

public record BaseConfig(
        List<String> serviceNames,
        List<String> commandAliases,
        String broadcastMessage,
        Platform platform
) {

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof BaseConfig config)) return false;

        if (serviceNames.equals(config.serviceNames) &&
            commandAliases.equals(config.commandAliases) &&
            broadcastMessage.equals(config.broadcastMessage) &&
            platform.equals(config.platform)
        ) {
            return true;
        }
        return false;
    }

}
