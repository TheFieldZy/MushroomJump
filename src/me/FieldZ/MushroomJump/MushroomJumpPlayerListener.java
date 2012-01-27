package me.FieldZ.MushroomJump;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.util.Vector;

public class MushroomJumpPlayerListener implements Listener{
	public MushroomJump plugin;
	/**
	 * Constructor for PlayerListener
	 * @param instance Grabs an instance of MushroomJump
	 */
	public MushroomJumpPlayerListener(MushroomJump instance){
		plugin = instance;
	}

	/**
	 * Calls when player moves
	 * If a player moves on to a mushroom block he is catapulted up in the air! 
	 * @param ev A PlayerMoveEvent object
	 */
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent ev){
		if (!ev.getFrom().getBlock().getLocation().equals(ev.getTo().getBlock().getLocation())) {
			Player player = ev.getPlayer();
			if (plugin.hasPermissions(player, "MushroomJump.affected")) {
				Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
				if (block.getType() == Material.HUGE_MUSHROOM_1) {
					Vector dir = player.getLocation().getDirection().multiply(1.75);
					Vector vec = new Vector(dir.getX(), 1.5D, dir.getZ());
					player.setVelocity(vec);
				} else if(block.getType() == Material.HUGE_MUSHROOM_2) {
					Vector dir = player.getLocation().getDirection().multiply(1.75);
					Vector vec = new Vector(dir.getX(), 2.0D, dir.getZ());
					player.setVelocity(vec);
				}
			}
		}
	}

}
