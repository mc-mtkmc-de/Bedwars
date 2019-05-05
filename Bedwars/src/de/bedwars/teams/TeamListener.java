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
				
				if(Bedwars.blau.size() == 0){
					

						Methods.ClearFromArray(p);
						Bedwars.blau.add(p.getName());
						p.sendMessage(Bedwars.pr+"Du bist nun in Team §9Blau"+Bedwars.n+"!");
					
					
				}else if(Bedwars.blau.size() >= 1){
					if(Bukkit.getOnlinePlayers().size() >= 8){
						Methods.ClearFromArray(p);
						Bedwars.blau.add(p.getName());
						p.sendMessage(Bedwars.pr+"Du bist nun in Team §9Blau"+Bedwars.n+"!");
					}else{
						p.sendMessage(Bedwars.pr+"Dieses Team ist momentan Voll!");
					}
				}else{
					
				}
				
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Rotes Team")){
				e.setCancelled(true);
				if(Bedwars.rot.size() == 0){
					

						Methods.ClearFromArray(p);
						Bedwars.rot.add(p.getName());
						p.sendMessage(Bedwars.pr+"Du bist nun in Team §4Rot"+Bedwars.n+"!");
						

					
				}else if(Bedwars.rot.size() >= 1){
					if(Bukkit.getOnlinePlayers().size() >= 8){
						Methods.ClearFromArray(p);
						Bedwars.rot.add(p.getName());
						p.sendMessage(Bedwars.pr+"Du bist nun in Team §4Rot"+Bedwars.n+"!");
					}else{
						p.sendMessage(Bedwars.pr+"Dieses Team ist momentan Voll!");
					}
				}else{
					
				}
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eGelbes Team")){
				e.setCancelled(true);
				if(Bedwars.gelb.size() == 0){
					

						Methods.ClearFromArray(p);
						Bedwars.gelb.add(p.getName());
						p.sendMessage(Bedwars.pr+"Du bist nun in Team §eGelb"+Bedwars.n+"!");

					
				}else if(Bedwars.gelb.size() >= 1){
					if(Bukkit.getOnlinePlayers().size() >= 8){
						Methods.ClearFromArray(p);
						Bedwars.gelb.add(p.getName());
						p.sendMessage(Bedwars.pr+"Du bist nun in Team §eGelb"+Bedwars.n+"!");
					}else{
						p.sendMessage(Bedwars.pr+"Dieses Team ist momentan Voll!");
					}
				}else{
					
				}
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Lilanes Team")){
				e.setCancelled(true);
				if(Bedwars.Lila.size() == 0){
					

						Methods.ClearFromArray(p);
						Bedwars.Lila.add(p.getName());
						p.sendMessage(Bedwars.pr+"Du bist nun in Team §5Lila"+Bedwars.n+"!");
						

					
				}else if(Bedwars.Lila.size() >= 1){
					if(Bukkit.getOnlinePlayers().size() >= 8){
						Methods.ClearFromArray(p);
						Bedwars.Lila.add(p.getName());
						p.sendMessage(Bedwars.pr+"Du bist nun in Team §5Lila"+Bedwars.n+"!");
					}else{
						p.sendMessage(Bedwars.pr+"Dieses Team ist momentan Voll!");
					}
				}else{
					
				}
			}
			
			
		}catch(Exception e1){
			
		}
		
		
		
	}
	
	
	
}
