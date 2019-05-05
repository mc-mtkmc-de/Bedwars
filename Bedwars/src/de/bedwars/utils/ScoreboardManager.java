package de.bedwars.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import de.bedwars.main.Bedwars;

public class ScoreboardManager {

	
	
	
	
	public static void setScoreBoard(Player p){
		
		org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
		Scoreboard s = sm.getNewScoreboard();
		
		Objective o = s.registerNewObjective("Teams", "dummy");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("§f«§3Bedwars§f»");
		
		p.setScoreboard(s);
		
	}
	
	
	
	public static void UpdateScoreboard(Player p){
		Scoreboard s =p.getScoreboard();
		Objective o = s.getObjective("Teams");
		if(GameManager.isState(GameManager.GAME)){
			
			if(Bedwars.canRespawnBlau == true){
			o.getScore("§2✔ §7│ §9Blau").setScore(Bedwars.blau.size());
			}else{
				if(Bedwars.blau.size() != 0){
			o.getScore("§4✘ §7│ §9Blau").setScore(Bedwars.blau.size());
				}else{
					
				}
			}
			if(Bedwars.canRespawnRot == true){
			o.getScore("§2✔ §7│ §4Rot").setScore(Bedwars.rot.size());
			}else{
				if(Bedwars.blau.size() != 0){
			o.getScore("§4✘ §7│ §4Rot").setScore(Bedwars.rot.size());
				}else{
					
				}
			}
			if(Bedwars.canRespawnGelb == true){
			o.getScore("§2✔ §7│ §eGelb").setScore(Bedwars.gelb.size());
			}else{
				if(Bedwars.blau.size() != 0){
			o.getScore("§4✘ §7│ §eGelb").setScore(Bedwars.gelb.size());
				}else{
					
				}
			}
			if(Bedwars.canRespawnLila == true){
			o.getScore("§2✔ §7│ §5Lila").setScore(Bedwars.Lila.size());
			}else{
				if(Bedwars.blau.size() != 0){
			o.getScore("§4✘ §7│ §5Lila").setScore(Bedwars.Lila.size());
				}else{
					
				}
			}
			o.getScore("§3Map:").setScore(10);

			
			p.setScoreboard(s);
		}else if(GameManager.isState(GameManager.LOBBY)){
			

			o.getScore("§3Map:").setScore(10);
			o.getScore("§7➥ §e<Map>").setScore(9);
			o.getScore("    ").setScore(8);
			o.getScore("§7Bedwars").setScore(7);
			o.getScore("§7➥ §e<ServerName/IP>").setScore(6);
				
				
			p.setScoreboard(s);
		}
		
	}
	
	
	
	
	
}
