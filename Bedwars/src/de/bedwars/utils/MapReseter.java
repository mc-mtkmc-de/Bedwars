package de.bedwars.utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;



public class MapReseter {

	
	public static ArrayList<Location> locations = new ArrayList<>();
	
	public static void ResetMap(){
		
		try{
			
			for(Location loc : locations){
				
				if(loc.getBlock().getType() == Material.AIR){
					return;
				}else{
					loc.getBlock().setType(Material.AIR);
				}
				
			}
			
		}catch(Exception e){
			Bukkit.broadcastMessage("§4§l::: §fFehler beim Mapreseten §4§:::");
		}
		
	}
	
	
}
