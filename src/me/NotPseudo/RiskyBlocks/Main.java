package me.NotPseudo.RiskyBlocks;

import me.NotPseudo.RiskyBlocks.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        new blockBreak(this);
        new lifesteal(this);
    }
}