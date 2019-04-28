package de.bedwars.teams;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.bedwars.utils.Methods;
import de.bedwars.main.Bedwars;

public class TeamListener implements Listener{

	Bedwars pl = Bedwars.plugin;
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		
		
		try{
			
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Blaues Team")){
				e.setCancelled(true);
				
				if(pl.blau.size() == 0){
					

						Methods.ClearFromArray(p);
						pl.blau.add(p.getName());
						p.sendMessage(pl.pr+"Du bist nun in Team §9Blau"+pl.n+"!");
					
					
				}else if(pl.blau.size() >= 1){
					if(Bukkit.getOnlinePlayers().size() >= 8){
						Methods.ClearFromArray(p);
						pl.blau.add(p.getName());
						p.sendMessage(pl.pr+"Du bist nun in Team §9Blau"+pl.n+"!");
					}else{
						p.sendMessage(pl.pr+"Dieses Team ist momentan Voll!");
					}
				}else{
					
				}
				
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Rotes Team")){
				e.setCancelled(true);
				if(pl.rot.size() == 0){
					

						Methods.ClearFromArray(p);
						pl.rot.add(p.getName());
						p.sendMessage(pl.pr+"Du bist nun in Team §4Rot"+pl.n+"!");
						

					
				}else if(pl.rot.size() >= 1){
					if(Bukkit.getOnlinePlayers().size() >= 8){
						Methods.ClearFromArray(p);
						pl.rot.add(p.getName());
						p.sendMessage(pl.pr+"Du bist nun in Team §4Rot"+pl.n+"!");
					}else{
						p.sendMessage(pl.pr+"Dieses Team ist momentan Voll!");
					}
				}else{
					
				}
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eGelbes Team")){
				e.setCancelled(true);
				if(pl.gelb.size() == 0){
					

						Methods.ClearFromArray(p);
						pl.gelb.add(p.getName());
						p.sendMessage(pl.pr+"Du bist nun in Team §eGelb"+pl.n+"!");

					
				}else if(pl.gelb.size() >= 1){
					if(Bukkit.getOnlinePlayers().size() >= 8){
						Methods.ClearFromArray(p);
						pl.gelb.add(p.getName());
						p.sendMessage(pl.pr+"Du bist nun in Team §eGelb"+pl.n+"!");
					}else{
						p.sendMessage(pl.pr+"Dieses Team ist momentan Voll!");
					}
				}else{
					
				}
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Lilanes Team")){
				e.setCancelled(true);
				if(pl.Lila.size() == 0){
					

						Methods.ClearFromArray(p);
						pl.Lila.add(p.getName());
						p.sendMessage(pl.pr+"Du bist nun in Team §5Lila"+pl.n+"!");
						

					
				}else if(pl.Lila.size() >= 1){
					if(Bukkit.getOnlinePlayers().size() >= 8){
						Methods.ClearFromArray(p);
						pl.Lila.add(p.getName());
						p.sendMessage(pl.pr+"Du bist nun in Team §5Lila"+pl.n+"!");
					}else{
						p.sendMessage(pl.pr+"Dieses Team ist momentan Voll!");
					}
				}else{
					
				}
			}
			
			
		}catch(Exception e1){
			
		}
		
		
		
	}
	
	
	
}

