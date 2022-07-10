package me.NotPseudo.RiskyBlocks.listeners;

import me.NotPseudo.RiskyBlocks.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.List;

public class BlockBreak implements Listener {

    private static final List<EntityType> entityTypes = Arrays.stream(EntityType.values()).filter(EntityType::isSpawnable).toList();
    private static final PotionEffectType[] potionEffects = PotionEffectType.values();

    public BlockBreak(Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public static void onBlockBreak(BlockBreakEvent event) {
        if (Math.random() < 0.5) {
            Location location = event.getBlock().getLocation();
            EntityType entityType = entityTypes.get((int) (Math.random() * entityTypes.size()));
            event.getBlock().getWorld().spawnEntity(location, entityType);
        } else {
            PotionEffectType effectType = potionEffects[(int) (Math.random() * PotionEffectType.values().length)];
            int duration = ((int) (Math.random() * 116) + 5) * 20;
            int amplifier = (int) (Math.random() * 10) + 1;
            event.getPlayer().addPotionEffect(new PotionEffect(effectType, duration, amplifier));
        }
    }
}
