package net.cirsius.tuffvote.models;

import java.util.List;

public record BaseConfig(
        List<String> serviceNames,
        List<String> commandAliases,
        String broadcastMessage,
        Platform platform
) {}
