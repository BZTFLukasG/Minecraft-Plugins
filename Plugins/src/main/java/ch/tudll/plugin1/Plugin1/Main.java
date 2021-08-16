package ch.tudll.plugin1.Plugin1;
import ch.tudll.plugin1.Plugin1.backpack.BackpackManager;
import ch.tudll.plugin1.Plugin1.commands.BackpackCommand;
import ch.tudll.plugin1.Plugin1.commands.TimerCommand;
import ch.tudll.plugin1.Plugin1.listeners.JoinListener;
import ch.tudll.plugin1.Plugin1.listeners.QuitListener;
import ch.tudll.plugin1.Plugin1.tablist.TablistManager;
import ch.tudll.plugin1.Plugin1.timer.Timer;
import ch.tudll.plugin1.Plugin1.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import java.io.File;


public final class Main extends JavaPlugin {


    private static Main instance;

    private Timer timer;
    private Config config;
    private BackpackManager backpackManager;
    private TablistManager tablistManager;

    @Override
    public void onLoad() {
        instance = this;
        config = new Config();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        PluginManager manager = Bukkit.getPluginManager();

        manager.registerEvents(new JoinListener(), this);
        manager.registerEvents(new QuitListener(), this);

        getCommand("timer").setExecutor(new TimerCommand());
        getCommand("backpack").setExecutor(new BackpackCommand());

        timer = new Timer();
        backpackManager = new BackpackManager();
        tablistManager = new TablistManager();
    }

    @Override
    public void onDisable() {
        timer.save();
        backpackManager.save();
        config.save();

    }

    public static Main getInstance()
    {
        return instance;
    }

    public Config getConfiguration() {
        return config;
    }

    public Timer getTimer() {

        return timer;
    }

    public BackpackManager getBackpackManager() {
        return backpackManager;
    }

    public TablistManager getTablistManager() {
        return tablistManager;
    }

}
