package me.FieldZ.MushroomJump;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MushroomJump extends JavaPlugin{
	
	Logger log = Logger.getLogger("Minecraft");
	
	private final MushroomJumpPlayerListener playerListener = new MushroomJumpPlayerListener(this);
	private final MushroomJumpEntityListener entityListener = new MushroomJumpEntityListener(this);
	
	@Override
	public void onDisable(){
		log.info("MushroomJump is disabled!");
		
	}
	
	@Override
	public void onEnable(){
		log.info("MushroomJump is enabled!");
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_MOVE, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.ENTITY_DAMAGE, entityListener, Event.Priority.Normal, this);
		
		
	}

}
