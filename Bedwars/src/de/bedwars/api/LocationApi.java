package de.bedwars.api;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import de.bedwars.main.Bedwars;



	

public class LocationApi{

	static Bedwars pl = Bedwars.plugin;
	
	public static void setLocation(String LocationName,Player p){
		pl.getConfig().set(LocationName+".X", p.getLocation().getBlockX());
		pl.getConfig().set(LocationName+".Y", p.getLocation().getBlockY());
		pl.getConfig().set(LocationName+".Z", p.getLocation().getBlockZ());
		pl.getConfig().set(LocationName+".Yaw", p.getLocation().getYaw());
		pl.getConfig().set(LocationName+".Pitch", p.getLocation().getPitch());
		pl.getConfig().set(LocationName+".World", p.getWorld().getName());
		
		pl.saveConfig();
	}
	
	public static Location getLocation(String LocationName){

		double x = pl.getConfig().getDouble(LocationName+".X");
		double y = pl.getConfig().getDouble(LocationName+".Y");
		double z = pl.getConfig().getDouble(LocationName+".Z");
		pl.getConfig().getDouble(LocationName+".Yaw");
		pl.getConfig().getDouble(LocationName+".Pitch");
		String World = pl.getConfig().getString(LocationName+".World");
		World w = Bukkit.getWorld(World);
		Location l = new Location(w,x,y,z);
		return l;
	}
	
}
