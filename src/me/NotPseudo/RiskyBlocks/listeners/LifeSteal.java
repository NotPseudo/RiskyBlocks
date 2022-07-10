package me.NotPseudo.RiskyBlocks.listeners;

import me.NotPseudo.RiskyBlocks.Main;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class LifeSteal implements Listener {

    public LifeSteal(Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player player) {
            player.setHealth(Math.min(player.getHealth() + event.getDamage(), player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue()));
        }
    }
}
