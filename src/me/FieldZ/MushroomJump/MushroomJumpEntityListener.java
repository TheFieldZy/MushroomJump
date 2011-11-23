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
	 
	 /**
	  * Constructor for EntityListener
	  * @param instance grabs an instance of MushroomJump
	  */
	 public MushroomJumpEntityListener(MushroomJump instance){
		 plugin = instance;
	 }
	 
	 /**
	  * Called when an entity is damaged
	  * Checks if player and if true, will not deal fall damage on hugemushrooms
	  * @param ev A EntityDamageEvent object
	  */
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
