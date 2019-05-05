package de.bedwars.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.bedwars.main.Bedwars;
import de.bedwars.utils.GameManager;
import de.bedwars.utils.Methods;

public class Chat implements Listener{

	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		
		Player p = e.getPlayer();
		

		e.setFormat("");
		
		if(GameManager.isState(GameManager.LOBBY)){
			if(p.isOp()){
				e.setFormat("§7> §4"+p.getDisplayName()+": "+e.getMessage());
				}else if(p.hasPermission("Premium")){
					e.setFormat("§7> §6"+p.getDisplayName()+": "+e.getMessage());
				}else if(p.hasPermission("Youtube")){
					e.setFormat("§7> §5"+p.getDisplayName()+": "+e.getMessage());
				}else{
					e.setFormat("§7> §2"+p.getDisplayName()+": "+e.getMessage());
				}
		}else{
			
			if(e.getMessage().startsWith("@all") || e.getMessage().startsWith("#")){
				e.setFormat("§7[§bGlobal§7] "+Methods.getTeam(p).replace("➥", "")+" §7│ "+p.getDisplayName()+": "+e.getMessage());
			}else{
				e.setFormat("");
				if(Bedwars.blau.contains(p)){
				for(String s : Bedwars.blau){
					Player p1 = Bukkit.getPlayer(s);
					p1.sendMessage("§7["+Methods.getTeam(p)+"§7] "+p.getDisplayName()+": "+e.getMessage());
				}
				}else if(Bedwars.rot.contains(p)){
					for(String s : Bedwars.rot){
						Player p1 = Bukkit.getPlayer(s);
						p1.sendMessage("§7["+Methods.getTeam(p)+"§7] "+p.getDisplayName()+": "+e.getMessage());
					}
					}else if(Bedwars.gelb.contains(p)){
						for(String s : Bedwars.gelb){
							Player p1 = Bukkit.getPlayer(s);
							p1.sendMessage("§7["+Methods.getTeam(p)+"§7] "+p.getDisplayName()+": "+e.getMessage());
						}
						}else if(Bedwars.Lila.contains(p)){
							for(String s : Bedwars.Lila){
								Player p1 = Bukkit.getPlayer(s);
								p1.sendMessage("§7["+Methods.getTeam(p)+"§7] "+p.getDisplayName()+": "+e.getMessage());
							}
							}
			}
			
		}
		
	}
	
	
	
	
	
}
