package de.bedwars.listeners;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import de.bedwars.teams.TeamInventory;

public class NatureHandler implements Listener{

	
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent e){
		
		
		if(e.getEntity().equals(EntityType.VILLAGER)){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onChange(WeatherChangeEvent e){
		
		e.setCancelled(true);
		
	}
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		try{
			
			if(e.getItem().getType() == Material.NOTE_BLOCK){
				TeamInventory.openInventory(p);
			}
			
		}catch(Exception e1){
			
		}
		
	}
	
}
