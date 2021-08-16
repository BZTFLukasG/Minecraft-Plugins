package ch.tudll.plugin1.Plugin1.tablist;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TablistManager {

    public void setPlayerlist(Player player) {
        player.setPlayerListHeaderFooter(ChatColor.DARK_GRAY.toString() + ChatColor.STRIKETHROUGH + "----------" +
                ChatColor.DARK_GRAY + "[ " + ChatColor.BLUE + "Projektarbeit 2021" + ChatColor.DARK_GRAY + " ]" +
                ChatColor.DARK_GRAY.toString() + ChatColor.STRIKETHROUGH + "----------" + ChatColor.RESET +
                "\n" + ChatColor.GRAY + "von Swen und Lukas", ChatColor.BLUE + "Danke fürs Spielen");
    }

    public void setAllPlayerTeams(){
        Bukkit.getOnlinePlayers().forEach(this::setPlayerTeams);
    }

    public void setPlayerTeams(Player player){
        Scoreboard scoreboard = player.getScoreboard();

        Team players = scoreboard.getTeam("010players");

        if (players == null){
            players = scoreboard.registerNewTeam("010players");
        }

        Team operators = scoreboard.getTeam("001admins");

        if (operators == null){
            operators = scoreboard.registerNewTeam("001admins");
        }


        players.setPrefix(ChatColor.GRAY + "Player |" + ChatColor.DARK_GRAY + " ");
        players.setColor(ChatColor.GRAY);

        operators.setPrefix(ChatColor.DARK_RED + "OP |" + ChatColor.DARK_GRAY + " ");
        operators.setColor(ChatColor.DARK_RED);

        for (Player target : Bukkit.getOnlinePlayers()) {
            if (target.isOp()){
                operators.addEntry(target.getName());
                continue;
            }

            players.addEntry(target.getName());
            
        }
    }

}
