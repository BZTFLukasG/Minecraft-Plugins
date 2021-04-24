package ch.tudll.plugin1.Plugin1;


import ch.tudll.plugin1.Plugin1.commands.TimerCommand;
import ch.tudll.plugin1.Plugin1.listeners.JoinListener;
import ch.tudll.plugin1.Plugin1.listeners.QuitListener;
import ch.tudll.plugin1.Plugin1.timer.Timer;
import ch.tudll.plugin1.Plugin1.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {


    private static Main instance;

    private Timer timer;
    private Config config;

    @Override
    public void onLoad() {
        instance = this;
        config = new Config();
    }

    public Config getConfiguration() {
        return config;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        PluginManager manager = Bukkit.getPluginManager();

        manager.registerEvents(new JoinListener(), this);
        manager.registerEvents(new QuitListener(), this);

        getCommand("timer").setExecutor(new TimerCommand());

        timer = new Timer();
    }

    @Override
    public void onDisable() {
        timer.save();
        config.save();
    }

    public static Main getInstance()
    {
        return instance;
    }

    public Timer getTimer() {

        return timer;
    }
}
