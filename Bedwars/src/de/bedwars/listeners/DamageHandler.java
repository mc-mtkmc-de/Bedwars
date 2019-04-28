package de.bedwars.listeners;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import de.bedwars.utils.GameManager;
import de.bedwars.utils.Methods;

public class DamageHandler implements Listener{

	
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			
		if(GameManager.isState(GameManager.LOBBY) || GameManager.isState(GameManager.Restart)) {
			e.setCancelled(true);
		}else if(GameManager.isState(GameManager.GAME)){
			
			
			if(e.getDamager() instanceof Player){
			Player d = (Player) e.getDamager();
			String TeamD = Methods.getExactTeam(d);
			String TeamP = Methods.getExactTeam(p);
			if(TeamD.equalsIgnoreCase(TeamP)){
				e.setCancelled(true);
			}else{
				e.setCancelled(false);
			}
			}
			
			if(e.getDamager() instanceof Arrow){
				Arrow a = (Arrow) e.getDamager();
				Player d = (Player) a.getShooter();
				String TeamD = Methods.getExactTeam(d);
				String TeamP = Methods.getExactTeam(p);
				if(TeamD.equalsIgnoreCase(TeamP)){
					e.setCancelled(true);
				}else{
					e.setCancelled(false);
				}
			}
			
		}
		}
	}
	@EventHandler
	public void onDamageVillage(EntityDamageEvent e){
		
		if(GameManager.isState(GameManager.LOBBY) || GameManager.isState(GameManager.Restart)) {
			e.setCancelled(true);
		}else if(GameManager.isState(GameManager.GAME)){
			if(e.getEntity() instanceof Villager){
				
				e.setCancelled(true);
				
			}
		}
		
	}
	
}
