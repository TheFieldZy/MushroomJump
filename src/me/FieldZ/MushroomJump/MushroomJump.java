package me.FieldZ.MushroomJump;

import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

public class MushroomJump extends JavaPlugin{
	
	Logger log = Logger.getLogger("MushroomJump");
	
	private final MushroomJumpPlayerListener playerListener = new MushroomJumpPlayerListener(this);
	private final MushroomJumpEntityListener entityListener = new MushroomJumpEntityListener(this);
	
	// Permissions Integration
	private static PermissionHandler Permissions;
	/**
	 * Method for when the plugin disables
	 */
	@Override
	public void onDisable() {
		log.info("MushroomJump is disabled!");
	}
	
	/**
	 * Method for when MushroomJump is enabled; Listeners Enabled as well
	 */
	@Override
	public void onEnable() {
		// Registering events
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(playerListener, this);
		pm.registerEvents(entityListener, this);
		
		// Connect with the permissions system
		setupPermissions();
		
		PluginDescriptionFile pdfFile = this.getDescription();
		log.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!");
	}
	
	// Permissions Methods
	private void setupPermissions() {
        Plugin permissions = this.getServer().getPluginManager().getPlugin("Permissions");

        if (Permissions == null) {
            if (permissions != null) {
                Permissions = ((Permissions) permissions).getHandler();
            } else {
            }
        }
    }
    
    protected boolean hasPermissions(Player player, String node) {
        if (Permissions != null) {
        	return Permissions.has(player, node);
        } else {
            return player.hasPermission(node);
        }
    }

}
