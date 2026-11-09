package net.cirsius.tuffvote.listener;

import com.vexsoftware.votifier.bungee.events.VotifierEvent;
import com.vexsoftware.votifier.model.Vote;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import net.cirsius.tuffvote.TuffVoteBungee;
import net.cirsius.tuffvote.VoteService;
import net.cirsius.tuffvote.config.Config;
import net.cirsius.tuffvote.models.BaseConfig;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class VoteListener implements Listener {
    private final TuffVoteBungee plugin;
    private VoteService service;
    @EventHandler
    public void onVote(VotifierEvent event) {
        this.service = new VoteService();
        Vote vote = event.getVote();
        service.handleVote(new BaseConfig(
                           Config.i().getServices(),
                           Config.i().getCommands(),
                           Config.i().getBroadcastMessage(),
                           plugin),
       vote.getUsername(), vote.getServiceName());
    }

}
