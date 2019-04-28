package de.bedwars.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.bedwars.api.LocationApi;
import de.bedwars.main.Bedwars;

public class Spawner implements CommandExecutor{

	static Bedwars pl = Bedwars.plugin;
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2,
			String[] args) {

		Player p = (Player) sender;
		
		if(args.length == 0){
			p.sendMessage(Bedwars.pr+"/Spawner add <type>");
			p.sendMessage(Bedwars.pr+"/Spawner remove <type> <id>");
		}else if(args.length >= 1){
			
			if(args[0].equalsIgnoreCase("add")){
				
				String type = args[1];
				if(type.equalsIgnoreCase("Bronze") || type.equalsIgnoreCase("Silber") || type.equalsIgnoreCase("Gold")){
					int spawnercount;
					try{
					spawnercount = pl.getConfig().getInt(type.toLowerCase()+"SpawnerCount");
					}catch(Exception e){
						pl.getConfig().addDefault(type.toLowerCase()+"SpawnerCount", 0);
						spawnercount = 0;
						pl.saveConfig();
					}
					int newcount = spawnercount +1;
					pl.getConfig().set(type.toLowerCase()+"SpawnerCount", newcount);
					pl.saveConfig();
					LocationApi.setLocation("Spawner."+type.toLowerCase()+"."+newcount, p);
					p.sendMessage(Bedwars.pr+"Du hast Spawner "+type.toLowerCase()+" mit ID "+newcount+" gesetzt!");
					
				}else{
					p.sendMessage(Bedwars.pr+" Gebe bitte Bronze,Silber,Gold an!");
				}
				
			}else if(args[0].equalsIgnoreCase("remove")){
				
				String type = args[1];
				if(type.equalsIgnoreCase("Bronze") || type.equalsIgnoreCase("Silber") || type.equalsIgnoreCase("Gold")){
					
				
						
						try{
							
							int id = Integer.parseInt(args[2]);
							
							if(pl.getConfig().contains("Spawner."+type.toLowerCase()+"."+id)){
								
								pl.getConfig().set("Spawner."+type.toLowerCase()+"."+id, null);
								
							}else{
								p.sendMessage(Bedwars.pr+"Diese Spawner-ID gibt es nicht!");
							}
							
						}catch(NumberFormatException e){
							p.sendMessage(Bedwars.pr+"Das ist keine Zahl!");
						}
					
					
				}else{
					p.sendMessage(Bedwars.pr+" Gebe bitte Bronze,Silber,Gold an!");
				}
				
			}
			
		}
		
		
		return true;
	}

	
	public static void StartSpawning(){
		
		
		
		
		
		Bukkit.getScheduler().runTaskTimer(pl, new Runnable() {
			
			@Override
			public void run() {
				String type = "bronze";
				int spawners = pl.getConfig().getInt(type+"SpawnerCount");
				
				for(int i = 1; i <= spawners; i++){
					try{
					Location Spawner = LocationApi.getLocation("Spawner."+type+"."+i);
					
					Bukkit.getWorld(Spawner.getWorld().getName()).dropItemNaturally(Spawner, new ItemStack(336));
					}catch(Exception e){
						
					}
				}
				
				
			}
		}, 0, 20);
		
		
		Bukkit.getScheduler().runTaskTimer(pl, new Runnable() {
			
			@Override
			public void run() {
				
				String type = "silber";
				int spawners = pl.getConfig().getInt(type.toLowerCase()+"SpawnerCount");
				
				for(int i = 1; i <= spawners; i++){
					try{
					Location Spawner = LocationApi.getLocation("Spawner."+type.toLowerCase()+"."+i);
					
					Bukkit.getWorld(Spawner.getWorld().getName()).dropItemNaturally(Spawner, new ItemStack(Material.IRON_INGOT));
					}catch(Exception e){
						
					}
				}
				
			}
		}, 0, 10*20);
		
		Bukkit.getScheduler().runTaskTimer(pl, new Runnable() {
			
			@Override
			public void run() {
				
				String type = "gold";
				int spawners = pl.getConfig().getInt(type.toLowerCase()+"SpawnerCount");
				
				for(int i = 1; i <= spawners; i++){
					try{
					Location Spawner = LocationApi.getLocation("Spawner."+type.toLowerCase()+"."+i);
					
					Bukkit.getWorld(Spawner.getWorld().getName()).dropItemNaturally(Spawner, new ItemStack(Material.GOLD_INGOT));
					}catch(Exception e){
						
					}
				}
				
			}
		}, 0, 25*20);
		
		
	}
	
	
}
