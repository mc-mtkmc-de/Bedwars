package de.bedwars.teams;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

import de.bedwars.api.ItemCreator;
import de.bedwars.main.Bedwars;

public class TeamInventory implements Listener{

	

public static void openInventory(Player p){
		
		Inventory inv = Bukkit.createInventory(null, 9, "§3Waehle dein §fTeam:");
		
		ArrayList<String> blau = new ArrayList<>();
		ArrayList<String> gelb = new ArrayList<>();
		ArrayList<String> lila = new ArrayList<>();
		ArrayList<String> rot = new ArrayList<>();
		
		
		for(String s : Bedwars.blau){
			
			blau.add("Â§7âž¥Â§9 "+s);
			
		}
		
	for(String s : Bedwars.gelb){
			
		gelb.add("§7§e "+s);
			
		}
	
	for(String s : Bedwars.rot){
		
		rot.add("§7§4 "+s);
		
	}
	
	for(String s : Bedwars.Lila){
		
		lila.add("§7§5 "+s);
		
	}
		
		
		inv.setItem(1, ItemCreator.CreateItemwithMaterial(Material.WOOL, 11, 1,"§9Blaues Team", blau));
		inv.setItem(3, ItemCreator.CreateItemwithMaterial(Material.WOOL, 14, 1,"§4Rotes Team", rot));
		inv.setItem(5, ItemCreator.CreateItemwithMaterial(Material.WOOL, 4, 1,"§eGelbes Team", gelb));
		inv.setItem(7, ItemCreator.CreateItemwithMaterial(Material.WOOL, 10, 1,"§5Lilanes Team", lila));
		
		p.openInventory(inv);
		
	}
	

	
	
	
}
