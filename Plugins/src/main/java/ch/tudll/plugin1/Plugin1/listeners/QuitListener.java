package ch.tudll.plugin1.Plugin1.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {


    @EventHandler

    public void onQuit(PlayerQuitEvent event)
    {

        Player player = event.getPlayer();

        event.setQuitMessage(ChatColor.AQUA + player.getName() + " hat kein Swag mehr");
    }


}
