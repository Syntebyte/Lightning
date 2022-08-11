package com.syntebyte.lightning;

import org.bukkit.plugin.java.JavaPlugin;

public class Lightning extends JavaPlugin {

    private final boolean debugEnabled = true;
    private Debug debug;

    public Debug getDebug() {
        return debug;
    }

    public boolean isDebugEnabled() {
        return this.debugEnabled;
    }

    public void onEnable() {

        debug = new Debug();
        getLogger().info("Lightning " + getDescription().getVersion() + " loaded successfully.");
    }

    public void onDisable() {

        getLogger().info("Lightning stopped.");
    }
}
