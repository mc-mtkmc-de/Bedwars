package de.bedwars.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import de.bedwars.utils.GameManager;

public class FoodHandler implements Listener {

	
	
	@EventHandler
	public void onFood(FoodLevelChangeEvent e){
		
		if(GameManager.isState(GameManager.LOBBY) || GameManager.isState(GameManager.Restart))e.setCancelled(true);
		
	}
	
	
}
