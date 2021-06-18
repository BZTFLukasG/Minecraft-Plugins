package ch.tudll.plugin1.Plugin1.backpack;

import ch.tudll.plugin1.Plugin1.utils.Base64;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.io.IOException;
import java.util.UUID;

public class Backpack {

    private final UUID uuid;

    private final Inventory inventory;

    public Backpack(UUID uuid) {
        this.uuid = uuid;
        this.inventory = Bukkit.createInventory(null, 27 /*vielfaches von 9*/, "Backpack");
    }

    public Backpack(UUID uuid, String Base64) throws IOException {
        this.uuid = uuid;
        this.inventory = Bukkit.createInventory(null, 27 /*vielfaches von 9*/, "Backpack");
        this.inventory.setContents(ch.tudll.plugin1.Plugin1.utils.Base64.itemStackArrayFromBase64(Base64));
    }

    public UUID getUuid() {
        return uuid;
    }

    public Inventory getInventory() {
        return inventory;
    }


    public String toBasic64() {
        return Base64.itemStackArrayToBase64(inventory.getContents());
    }


}

