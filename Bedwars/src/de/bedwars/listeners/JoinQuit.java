package de.bedwars.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerQuitEvent;

import de.bedwars.utils.Methods;
import de.bedwars.utils.holo;
import de.bedwars.api.ItemCreator;
import de.bedwars.api.LocationApi;
import de.bedwars.main.Bedwars;
import de.bedwars.mysql.SQLStats;
import de.bedwars.api.TablistAPI;
import de.bedwars.utils.GameManager;


public class JoinQuit implements Listener{

	Bedwars pl = Bedwars.plugin;
	
	@EventHandler
	public void onJoin(final PlayerJoinEvent e){
		Player p  = e.getPlayer();
		if(p.isOp()){
		e.setJoinMessage("§7> §4"+p.getDisplayName()+" §7hat das Spiel betreten!");
		}else if(p.hasPermission("Premium")){
			e.setJoinMessage("§7> §6"+p.getDisplayName()+" §7hat das Spiel betreten!");
		}else if(p.hasPermission("Youtube")){
			e.setJoinMessage("§7> §5"+p.getDisplayName()+" §7hat das Spiel betreten!");
		}else{
			e.setJoinMessage("§7> §2"+p.getDisplayName()+" §7hat das Spiel betreten!");
		}

		p.teleport(LocationApi.getLocation("Lobby"));
		
		TablistAPI.sendTabTitle(p, "§8Du spielst auf §b"+Bukkit.getServerName()+"-4x4", "§7-----[ §bBedwars§7 ]-----");
		
		String[] text = {
			
				"§7- §bStats von "+p.getName()+" §7-",
				"§7Punkte: "+SQLStats.getPoints(p.getUniqueId().toString()),
				"§7Kills:"+SQLStats.getKills(p.getUniqueId().toString()),
				"§7Deaths:"+SQLStats.getDeaths(p.getUniqueId().toString()),
				"§7Spiele gewonnen:"+SQLStats.getWins(p.getUniqueId().toString()),
				"§7Spiele gespielt:"+SQLStats.getPlayed(p.getUniqueId().toString()),
				"§7Zerstörte Betten:"+SQLStats.getZerstört(p.getUniqueId().toString()),
				
		};
		holo h = new holo(text, LocationApi.getLocation("Holo"));
		h.showPlayer(p);
		p.getInventory().clear();
		p.getInventory().addItem(ItemCreator.CreateItemwithMaterial(Material.NOTE_BLOCK, 0, 1, "§bTeam auswählen", null));
	}
	
	
	
	@EventHandler
	public void onLogin(PlayerLoginEvent e){
		
		if(e.getResult().equals(Result.KICK_FULL)){
			
			e.setKickMessage(Bedwars.pr+"Der Server ist voll!");
			
		}
		
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		e.setQuitMessage("");
		Methods.ClearFromArray(p);
		trySettingWinner();
		
	}
	public void trySettingWinner(){
		if(pl.rot.size() == 0 && pl.gelb.size() == 0 && pl.Lila.size() == 0&& pl.blau.size() >=1){
			for(Player p2: Bukkit.getOnlinePlayers() ){					p2.setHealth(20.0);
				p2.teleport(LocationApi.getLocation("Lobby"));
				GameManager.setState(GameManager.Restart);
			}
		
			Bukkit.broadcastMessage(pl.pr+"Team§9§l Blau "+pl.n+"hat gewonnen");
			for(String winner : Bedwars.blau){
				Player winner2 = Bukkit.getPlayer(winner);
			
			SQLStats.addWins(winner2.getUniqueId().toString(), 1);
			}
				return;
		}else
			if(pl.blau.size() == 0 && pl.gelb.size() == 0 && pl.Lila.size() == 0&& pl.rot.size() >=1){
				for(Player p2: Bukkit.getOnlinePlayers() ){					p2.setHealth(20.0);
					p2.teleport(LocationApi.getLocation("Lobby"));
					GameManager.setState(GameManager.Restart);
				}
				for(String winner : Bedwars.rot){
					Player winner2 = Bukkit.getPlayer(winner);
				
				SQLStats.addWins(winner2.getUniqueId().toString(), 1);
				}
				Bukkit.broadcastMessage(pl.pr+"Team§4§l Rot "+pl.n+"hat gewonnen");
					return;
			}else
		
				if(pl.rot.size() == 0 && pl.blau.size() == 0 && pl.Lila.size() == 0&& pl.gelb.size() >=1){
					for(Player p2: Bukkit.getOnlinePlayers() ){					p2.setHealth(20.0);
						p2.teleport(LocationApi.getLocation("Lobby"));
						GameManager.setState(GameManager.Restart);
					}
					for(String winner : Bedwars.gelb){
						Player winner2 = Bukkit.getPlayer(winner);
					
					SQLStats.addWins(winner2.getUniqueId().toString(), 1);
					}
					Bukkit.broadcastMessage(pl.pr+"Team§e§l Gelb "+pl.n+"hat gewonnen");
						return;
				}else
		
		
					if(pl.rot.size() == 0 && pl.gelb.size() == 0 && pl.blau.size() == 0&& pl.Lila.size() >=1){
						for(Player p2: Bukkit.getOnlinePlayers() ){					p2.setHealth(20.0);
							p2.teleport(LocationApi.getLocation("Lobby"));
							GameManager.setState(GameManager.Restart);
						}
						for(String winner : Bedwars.Lila){
							Player winner2 = Bukkit.getPlayer(winner);
						
						SQLStats.addWins(winner2.getUniqueId().toString(), 1);
						}
						Bukkit.broadcastMessage(pl.pr+"Team§5§l Lila "+pl.n+"hat gewonnen");
							return;
					}
	}
	
	

}
