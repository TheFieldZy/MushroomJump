package me.FieldZ.MushroomJump;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class MushroomJumpPlayerListener extends PlayerListener{
	public MushroomJump plugin;
	
	public MushroomJumpPlayerListener(MushroomJump instance){
		plugin = instance;
	}

	@Override
	public void onPlayerMove(PlayerMoveEvent ev){
		Player player = ev.getPlayer();
		
		if(ev.isCancelled()||ev.getFrom().getBlock().getLocation()==ev.getFrom().getBlock().getLocation())
		    return;
		
		Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
		
		if(block.getType() == Material.HUGE_MUSHROOM_1){
			Vector dir = player.getLocation().getDirection();
			Vector vec = new Vector(dir.getX() * 0.5D, 1.5D, dir.getZ() * 0.5D);
			player.setVelocity(vec);
		}
		if(block.getType() == Material.HUGE_MUSHROOM_2){
			Vector vec = new Vector(0D, 2.0D, 0D);
			player.setVelocity(vec);
		}
		
	}

}
