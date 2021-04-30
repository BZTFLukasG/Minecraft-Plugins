package ch.tudll.plugin1.Plugin1.backpack;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.util.UUID;

public class Backpack {

    private final UUID uuid;

    private Inventory inventory;

    public Backpack(UUID uuid) {
        this.uuid = uuid;
        this.inventory = Bukkit.createInventory(null, 27 /*vielfaches von 9*/, "Backpack");
    }

    public Backpack(UUID uuid, String Data) {
        this.uuid = uuid;
        this.inventory = Bukkit.createInventory(null, 27 /*vielfaches von 9*/, "Backpack");
    }
}

