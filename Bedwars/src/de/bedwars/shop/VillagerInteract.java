package de.bedwars.shop;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class VillagerInteract implements Listener{

	
	
	@EventHandler
	public void oninteractentity(PlayerInteractEntityEvent e){
		Player p = e.getPlayer();
		if(e.getRightClicked().getType() == EntityType.VILLAGER){
			
			ShopManager.openShopInv(p);
			
		}
		
	}
	
	
}
