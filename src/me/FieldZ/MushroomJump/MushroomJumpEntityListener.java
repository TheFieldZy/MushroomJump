package me.FieldZ.MushroomJump;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityListener;

public class MushroomJumpEntityListener extends EntityListener{
	 MushroomJump plugin;
	 
	 public MushroomJumpEntityListener(MushroomJump instance){
		 plugin = instance;
	 }
	 
	 public void onEntityDamage(EntityDamageEvent ev){
		 if(ev.getEntity() instanceof Player) {
			 Player player = (Player) ev.getEntity();
			 if(ev.getCause().equals((DamageCause.FALL))){
				 Block b = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
				 if(b.getType() == Material.HUGE_MUSHROOM_1 || b.getType() == Material.HUGE_MUSHROOM_2){
					 ev.setCancelled(true);
				 }
			 }
		 }
		 
		 
	 }

}
