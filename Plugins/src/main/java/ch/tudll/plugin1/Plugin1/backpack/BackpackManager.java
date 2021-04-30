package ch.tudll.plugin1.Plugin1.backpack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BackpackManager {

    private final Map<UUID, Backpack> map;

    public BackpackManager() {
        map = new HashMap<>();
    }

    public Backpack getbackpack(UUID uuid) {

        return map.getOrDefault(uuid, new Backpack(uuid));
    }

    public void setBackpack(UUID uuid, Backpack backpack) {

        map.put(uuid, backpack);
    }



}
