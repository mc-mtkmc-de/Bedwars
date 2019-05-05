package de.bedwars.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.block.Skull;

import de.bedwars.api.LocationApi;



public class Ranking {
	
	static HashMap<Integer, String> rang = new HashMap<Integer, String>();
	
	public static void set(){

		ResultSet rs = MySQL.query("SELECT UUID FROM BedWarsStats ORDER BY Points DESC LIMIT 3");
		
		int in = 0;
		
	
			try {
				while(rs.next()){
					in++;
					rang.put(in, rs.getString("UUID"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		

		
		Location loc = LocationApi.getLocation("Ranking.1");
		Location loc2 = LocationApi.getLocation("Ranking.2");
		Location loc3 = LocationApi.getLocation("Ranking.3");
		Location loc4 = LocationApi.getLocation("Ranking.3");
		
		
		List<Location> LOC = new ArrayList<Location>();
		LOC.add(loc);
		LOC.add(loc2);
		LOC.add(loc3);
		LOC.add(loc4);
		int id = 0;
		for(int i = 0; i < LOC.size(); i++){
			 id = i+1;
			try{

			if(rang.get(id) == null){
				if(LOC.get(i).getBlock().getType() != Material.SKULL){
					return;
				}
				Skull s = (Skull) LOC.get(i).getBlock().getState();
				s.setSkullType(SkullType.ZOMBIE);
				s.update();
				
				Location newloc = new Location(LOC.get(i).getWorld(), LOC.get(i).getX(), LOC.get(i).getY() -1, LOC.get(i).getZ());
				if(!(newloc.getBlock().getState() instanceof Sign)){
					return;
				}
				if(newloc.getBlock().getType() == Material.WALL_SIGN){
					BlockState b = newloc.getBlock().getState();
					Sign S = (Sign) b;
					
					
					S.setLine(0, "§9Platz – #" + id);
					S.setLine(1, "§2§lKein Spieler");
					S.setLine(2, "");
					S.setLine(3, "");
					S.update();
				}
				return;
			}
			if(LOC.get(i).getBlock().getType() != Material.SKULL){
				return;
			}
			Skull s = (Skull) LOC.get(i).getBlock().getState();
			s.setSkullType(SkullType.PLAYER);
			String name = Bukkit.getOfflinePlayer(UUID.fromString(rang.get(id))).getName();
			s.setOwner(name);
			s.update();
			
			Location newloc = new Location(LOC.get(i).getWorld(), LOC.get(i).getX(), LOC.get(i).getY() -1, LOC.get(i).getZ());
			if(!(newloc.getBlock().getState() instanceof Sign)){
				newloc.getBlock().setType(Material.WALL_SIGN);
			}
			if(newloc.getBlock().getType() == Material.WALL_SIGN){
				BlockState b = newloc.getBlock().getState();
				Sign S = (Sign) b;
				
				
				S.setLine(0, "§9Platz – #" + id);
				S.setLine(1, "§2§l"+name);
				S.setLine(2, "§9Wins –§7§l "+SQLStats.getWins(rang.get(id)));
				S.setLine(3, "§9Punkte –§7§l "+SQLStats.getPoints(rang.get(id)));
				S.update();
			}
		}catch(Exception e){
			if(LOC.get(i).getBlock().getType() != Material.SKULL){
				return;
			}
			Skull s = (Skull) LOC.get(i).getBlock().getState();
			s.setSkullType(SkullType.ZOMBIE);
			s.update();
			
			Location newloc = new Location(LOC.get(i).getWorld(), LOC.get(i).getX(), LOC.get(i).getY() -1, LOC.get(i).getZ());
			if(!(newloc.getBlock().getState() instanceof Sign)){
				return;
			}
			if(newloc.getBlock().getType() == Material.WALL_SIGN){
				BlockState b = newloc.getBlock().getState();
				Sign S = (Sign) b;
				
				
				S.setLine(0, "§9Platz – #" + id);
				S.setLine(1, "§2§lKein Spieler");
				S.setLine(2, "");
				S.setLine(3, "");
				S.update();
			}
		}
		}
	}

}
