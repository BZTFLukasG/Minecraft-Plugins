package ch.tudll.plugin1.Plugin1.listeners;

import ch.tudll.plugin1.Plugin1.scoreboard.TestScoreboard;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();

        event.setJoinMessage(ChatColor.DARK_PURPLE.toString()+ ChatColor.UNDERLINE + player.getName() + " Hat den Server betreten.");

        player.sendMessage(ChatColor.GOLD + " Willkommen auf dem Server");


        new TestScoreboard(player);
    }

}
