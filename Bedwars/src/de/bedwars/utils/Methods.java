package de.bedwars.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.scheduler.BukkitRunnable;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import de.bedwars.api.LocationApi;
import de.bedwars.main.Bedwars;

public class Methods {

	
    static int i = 16;
	private static boolean b = false;
	static Bedwars pl = Bedwars.plugin;
	
	public static void setEnd(){
		

		if(b == false){
			b= true;
			
			new BukkitRunnable() {
				
				@Override
				public void run() {
					i--;
					if(i == 15 || i == 10 || i == 5 || i == 4 || i == 3 || i == 2 || i == 1){
						Bukkit.broadcastMessage(Bedwars.pr+"Der Server restartet in "+Bedwars.a+i+Bedwars.n+" Sekunde(n)!");
					}else if( i == 0){
						Bukkit.broadcastMessage(Bedwars.pr+"Der Server restartet in "+Bedwars.a+"Jetzt!");
							for(Player p: Bukkit.getOnlinePlayers()){
								ByteArrayDataOutput out = ByteStreams.newDataOutput();
								out.writeUTF("Connect");
								out.writeUTF("lobby"); // Euer main Server!
								p.sendPluginMessage(Bedwars.plugin, "BungeeCord", out.toByteArray());
							}
							Bukkit.shutdown();
					}
					cancel();
				}
			}.runTaskTimer(pl, 20, 20);
			
		}
		
	}
	
	public static String getTeam(Player p){
		
		String s;
		
		if(Bedwars.blau.contains(p.getName())){
			s="�7�9Blau";
		}else if(Bedwars.rot.contains(p.getName())){
			s="�7�4Rot";
		}else if(Bedwars.gelb.contains(p.getName())){
			s="§7➥ §eGelb";
		}else if(Bedwars.Lila.contains(p.getName())){
			s="�7�5Lila";
		}else{
			
			s="�7�cKein Team";
			
		}
		
		return s;
		
	}
	public static void SetupGame(){
		
		Location bettblau = LocationApi.getLocation("Bett.blau");
		Location bettrot = LocationApi.getLocation("Bett.rot");
		Location bettgelb = LocationApi.getLocation("Bett.gelb");
		Location bettlila = LocationApi.getLocation("Bett.lila");
		
		
		bettblau.getBlock().setType(Material.NOTE_BLOCK);
		bettrot.getBlock().setType(Material.NOTE_BLOCK);
		bettgelb.getBlock().setType(Material.NOTE_BLOCK);
		bettlila.getBlock().setType(Material.NOTE_BLOCK);
		
		
		Location Villagerblau = LocationApi.getLocation("Villager.blau");
		Location Villagerrot = LocationApi.getLocation("Villager.rot");
		Location Villagergelb = LocationApi.getLocation("Villager.gelb");
		Location Villagerlila = LocationApi.getLocation("Villager.lila");
		String path = pl.getConfig().getString("World");
		Villager v1 = (Villager) Bukkit.getWorld(path).spawnCreature(Villagerblau, EntityType.VILLAGER);
		v1.setCustomName("§3Shop");
		v1.setCustomNameVisible(true);
		Villager v11 = (Villager) Bukkit.getWorld(path).spawnCreature(Villagerrot, EntityType.VILLAGER);
		v11.setCustomName("§3Shop");
		v11.setCustomNameVisible(true);
		Villager v111 = (Villager) Bukkit.getWorld(path).spawnCreature(Villagergelb, EntityType.VILLAGER);
		v111.setCustomName("§3Shop");
		v111.setCustomNameVisible(true);
		Villager v1111 = (Villager) Bukkit.getWorld(path).spawnCreature(Villagerlila, EntityType.VILLAGER);
		v1111.setCustomName("§3Shop");
		v1111.setCustomNameVisible(true);

	}
	
	public static boolean hasTeam(Player p){
		 boolean b;
		if(Bedwars.blau.contains(p.getName())){
			b=true;
		}else if(Bedwars.rot.contains(p.getName())){
			b=true;
		}else if(Bedwars.gelb.contains(p.getName())){
			b=true;
		}else if(Bedwars.Lila.contains(p.getName())){
			b=true;
		}else{
			
			b=false;
			
		}
		
		return b;
		
	}
	
public static String getColor(Player p){
		
		String s;
		
		if(Bedwars.blau.contains(p.getName())){
			s="§9";
		}else if(Bedwars.rot.contains(p.getName())){
			s="§4";
		}else if(Bedwars.gelb.contains(p.getName())){
			s="§e";
		}else if(Bedwars.Lila.contains(p.getName())){
			s="§5";
		}else{
			
			s="§c";
			
		}
		
		return s;
		
	}
	
	public static String getExactTeam(Player p){
		
		String s;
		
		if(Bedwars.blau.contains(p.getName())){
			s="Blau";
		}else if(Bedwars.rot.contains(p.getName())){
			s="Rot";
		}else if(Bedwars.gelb.contains(p.getName())){
			s="Gelb";
		}else if(Bedwars.Lila.contains(p.getName())){
			s="Lila";
		}else{
			
			s="§7➥ §cKein Team";
			
		}
		
		return s;
		
	}
	
	
	
	
	public static void ClearFromArray(Player p){
		
		Bedwars.blau.remove(p.getName());
		Bedwars.rot.remove(p.getName());
		Bedwars.gelb.remove(p.getName());
		Bedwars.Lila.remove(p.getName());
	}
	public static void tptoTeamSpawn(Player p) {

		String team = Methods.getExactTeam(p).toLowerCase();
		p.teleport(LocationApi.getLocation("Spawn."+team));
		
	}
	

	
}
