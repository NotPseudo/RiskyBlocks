package main.java.me.notpseudo.riskyblocks;

import main.java.me.notpseudo.riskyblocks.listeners.BlockBreak;
import main.java.me.notpseudo.riskyblocks.listeners.LifeSteal;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        new BlockBreak(this);
        new LifeSteal(this);
    }
}