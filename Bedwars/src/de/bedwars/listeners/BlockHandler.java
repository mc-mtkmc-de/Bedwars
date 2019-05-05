package de.bedwars.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import de.bedwars.utils.GameManager;
import de.bedwars.utils.MapReseter;
import de.bedwars.api.LocationApi;
import de.bedwars.main.Bedwars;
import de.bedwars.mysql.SQLStats;

public class BlockHandler implements Listener {

	/*
	 * ToDo:
	 *  - Mapreseter einbauen!
	 * 
	 */
	
	
	@EventHandler
	public void onBlock(BlockPlaceEvent e){
		Player p = e.getPlayer();
		if(GameManager.isState(GameManager.LOBBY)){
		if(Bedwars.build.contains(p.getName())){
		
			e.setCancelled(false);
			
		}else{
			e.setCancelled(true);
		}
		}else{
			e.setCancelled(false);
			
			
			MapReseter.locations.add(e.getBlock().getLocation());
			
			
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		Player p = e.getPlayer();
		if(GameManager.isState(GameManager.LOBBY)){
			if(Bedwars.build.contains(p.getName())){
			
				e.setCancelled(false);
				
			}else{
				e.setCancelled(true);
			}
			
			
			}else{
				
				
				if(e.getBlock().getType() == Material.GLOWSTONE ||e.getBlock().getType() == Material.GLASS ||e.getBlock().getType() == Material.IRON_BLOCK ||e.getBlock().getType() == Material.CHEST || e.getBlock().getType() == Material.NOTE_BLOCK || e.getBlock().getType() == Material.SANDSTONE || e.getBlock().getType() == Material.ENDER_STONE){
				
					if(e.getBlock().getType() == Material.NOTE_BLOCK){
						
					if(e.getBlock().getLocation().equals(LocationApi.getLocation("Bett.Blau"))){
						
						if(Bedwars.blau.contains(p)){
							
							p.sendMessage(Bedwars.pr+"Du kannst dein eigenes Bett nicht abbauen!");
							e.setCancelled(true);
							return;
						}

						Bedwars.canRespawnBlau = false;
						Bukkit.broadcastMessage(Bedwars.pr+"Das Bett von Team Blau wurde abgebaut!");
						SQLStats.addZerstört(p.getUniqueId().toString(), 1);
						SQLStats.addPoints(p.getUniqueId().toString(), 15);
						e.getBlock().getDrops().clear();
						
						for(Player p1 : Bukkit.getOnlinePlayers()){
							p1.playSound(p1.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 10, 10);

						}
						
						
					}else if(e.getBlock().getLocation().equals(LocationApi.getLocation("Bett.Rot"))){
						
						if(Bedwars.rot.contains(p)){
							
							p.sendMessage(Bedwars.pr+"Du kannst dein eigenes Bett nicht abbauen!");
							e.setCancelled(true);
							return;
						}

						Bedwars.canRespawnRot = false;
						Bukkit.broadcastMessage(Bedwars.pr+"Das Bett von Team Rot wurde abgebaut!");												SQLStats.addZerstört(p.getUniqueId().toString(), 1);
						SQLStats.addPoints(p.getUniqueId().toString(), 15);
						e.getBlock().getDrops().clear();
						
						for(Player p1 : Bukkit.getOnlinePlayers()){
							p1.playSound(p1.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 10, 10);

						}
						
					}else if(e.getBlock().getLocation().equals(LocationApi.getLocation("Bett.Gelb"))){
						
						if(Bedwars.gelb.contains(p)){
							
							p.sendMessage(Bedwars.pr+"Du kannst dein eigenes Bett nicht abbauen!");
							e.setCancelled(true);
							return;
						}

						Bedwars.canRespawnGelb = false;
						Bukkit.broadcastMessage(Bedwars.pr+"Das Bett von Team Gelb wurde abgebaut!");												SQLStats.addZerstört(p.getUniqueId().toString(), 1);
						SQLStats.addPoints(p.getUniqueId().toString(), 15);
						e.getBlock().getDrops().clear();
						
						for(Player p1 : Bukkit.getOnlinePlayers()){
							p1.playSound(p1.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 10, 10);

						}
						
					}else if(e.getBlock().getLocation().equals(LocationApi.getLocation("Bett.Lila"))){
						
						if(Bedwars.Lila.contains(p)){
							
							p.sendMessage(Bedwars.pr+"Du kannst dein eigenes Bett nicht abbauen!");
							e.setCancelled(true);
							return;
						}

						Bedwars.canRespawnLila = false;
						Bukkit.broadcastMessage(Bedwars.pr+"Das Bett von Team Lila wurde abgebaut!");											SQLStats.addZerstört(p.getUniqueId().toString(), 1);
						SQLStats.addPoints(p.getUniqueId().toString(), 15);
						e.getBlock().getDrops().clear();
						
						for(Player p1 : Bukkit.getOnlinePlayers()){
							p1.playSound(p1.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 10, 10);

						}
						
					}
						
					}else{
						if(MapReseter.locations.contains(e.getBlock().getLocation())){
						MapReseter.locations.remove(e.getBlock().getLocation());
						}
					}
					
				}else{
					e.setCancelled(true);
				}
				
			}
		
	}
	
	
}
