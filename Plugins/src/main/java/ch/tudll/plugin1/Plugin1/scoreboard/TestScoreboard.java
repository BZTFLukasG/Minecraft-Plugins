package ch.tudll.plugin1.Plugin1.scoreboard;

import ch.tudll.plugin1.Plugin1.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class TestScoreboard extends ScoreboardBuilder{

    private int socialId;


    public TestScoreboard(Player player) {
        super(player, ChatColor.DARK_PURPLE.toString() + ChatColor.BOLD + "  github.com/BZTFLukasG  ");

        run();
    }

    @Override
    public void createScoreboard() {
        setScore(ChatColor.DARK_GRAY.toString(), 7);
        setScore( ChatColor.GRAY + "  Dein Rang" + ChatColor.DARK_GRAY + ":", 6);

        if (player.isOp()){
            setScore(ChatColor.RED + "  Operator", 5);
        } else {
            setScore(ChatColor.GRAY + "  Spieler", 5);
        }



        setScore(ChatColor.GRAY.toString(), 4);
        setScore(ChatColor.LIGHT_PURPLE + "  instagram.com/_.lukasg._/", 3);
        setScore(ChatColor.RED.toString(), 2);
        setScore(ChatColor.RED + "  " + Objects.requireNonNull(player.getAddress()).getHostName(), 1);
        setScore(ChatColor.AQUA.toString(), 0);


    }

    @Override
    public void update() {
        switch (socialId) {
            case 0 -> setScore(ChatColor.LIGHT_PURPLE + "  instagram.com/_.lukasg._/  ", 3);
            case 1 -> setScore(ChatColor.GOLD + "  instagram.com/swen.andermatt/  ", 3);
        }

        socialId++;

        if (socialId >= 2){
            socialId = 0;
        }
    }

    public void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                update();
            }
        }.runTaskTimer(Main.getInstance(), 20 , 20 );
    }
}
