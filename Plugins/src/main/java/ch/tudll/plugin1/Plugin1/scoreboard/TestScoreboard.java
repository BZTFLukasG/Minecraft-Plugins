package ch.tudll.plugin1.Plugin1.scoreboard;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TestScoreboard extends ScoreboardBuilder{
    public TestScoreboard(Player player) {
        super(player, ChatColor.DARK_PURPLE.toString() + ChatColor.BOLD + "  github.com/BZTFLukasG");
    }

    @Override
    public void createScoreboard() {
        setScore(ChatColor.DARK_GRAY.toString(), 7);
        setScore( ChatColor.GRAY + "7Dein Rang" + ChatColor.DARK_GRAY + ":", 6);

        if (player.isOp()){
            setScore(ChatColor.RED + "Operator", 5);
        } else {
            setScore(ChatColor.GRAY + "Spieler", 5);
        }



        setScore(ChatColor.GRAY.toString(), 3);
        setScore(ChatColor.LIGHT_PURPLE + "instagram.com/_.lukasg._/", 3);
        setScore(ChatColor.RED.toString(), 2);
        setScore(ChatColor.RED + player.getAddress().getHostName(), 1);
        setScore(ChatColor.AQUA.toString(), 0);


    }

    @Override
    public void update() {

    }
}
