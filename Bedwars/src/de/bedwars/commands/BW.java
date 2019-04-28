package de.bedwars.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.bedwars.api.LocationApi;
import de.bedwars.main.Bedwars;

public class BW implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2,
			String[] args) {
		Player p= (Player) sender;
		
		if(p.isOp()){
		if(args.length == 0){
			
			sendHelp(p);
		}else if(args[0].equalsIgnoreCase("setSpawn")){
			
			if(args.length == 1){
				sendHelp(p);
			}else{
				if(args[1].equalsIgnoreCase("Blau") ||args[1].equalsIgnoreCase("Rot") ||args[1].equalsIgnoreCase("Lila") ||args[1].equalsIgnoreCase("Gelb")  ){
					try{
					LocationApi.setLocation("Spawn."+args[1].toLowerCase(), p);
					p.sendMessage(Bedwars.pr+"Die Location(Spawn-"+args[1]+") wurde gesetzt!");
					}catch(Exception e){
						p.sendMessage(Bedwars.pr+"Bei der Speicherung einer Location(Spawn-"+args[1]+") ist etwas schief gelaufen! Bitte kontaktiere den Developer!");
					}
				}else{
					p.sendMessage(Bedwars.pr+"Dieses Team ist nicht vorhanden! Bitte gebe Blau,Rot,Lila,Gelb an!");
				}
			}
			
		}else if(args[0].equalsIgnoreCase("setlobby")){
			
			LocationApi.setLocation("Lobby", p);
			
		}else if(args[0].equalsIgnoreCase("setBett")){
			
			if(args.length == 1){
				sendHelp(p);
			}else{
				if(args[1].equalsIgnoreCase("Blau") ||args[1].equalsIgnoreCase("Rot") ||args[1].equalsIgnoreCase("Lila") ||args[1].equalsIgnoreCase("Gelb")  ){
					try{
					LocationApi.setLocation("Bett."+args[1].toLowerCase(), p);
					p.sendMessage(Bedwars.pr+"Die Location(Bett-"+args[1]+") wurde gesetzt!");
					}catch(Exception e){
						p.sendMessage(Bedwars.pr+"Bei der Speicherung einer Location(Bett-"+args[1]+") ist etwas schief gelaufen! Bitte kontaktiere den Developer!");
					}
				}else{
					p.sendMessage(Bedwars.pr+"Dieses Team ist nicht vorhanden! Bitte gebe Blau,Rot,Lila,Gelb an!");
				}
			}
			
		}else if(args[0].equalsIgnoreCase("build")){
			
			if(Bedwars.build.contains(p.getName())){
				Bedwars.build.remove(p.getName());
			}else{
				Bedwars.build.add(p.getName());
			}
			
		}else if(args[0].equalsIgnoreCase("setHolo")){
			try{
			LocationApi.setLocation("Holo", p);
			p.sendMessage(Bedwars.pr+"Die Location(Hologramm) wurde gesetzt!");
			}catch(Exception e){
				p.sendMessage(Bedwars.pr+"Bei der Speicherung einer Location(Hologramm) ist etwas schief gelaufen! Bitte kontaktiere den Developer!");
			}
		}else if(args[0].equalsIgnoreCase("setRanking")){
			try{
				int i = Integer.parseInt(args[1]);
			LocationApi.setLocation("Ranking."+i, p);
			p.sendMessage(Bedwars.pr+"Die Location(Ranking-"+i+") wurde gesetzt!");
			}catch(NumberFormatException e){
				p.sendMessage(Bedwars.pr+"Bei der Speicherung einer Location(Ranking) ist etwas schief gelaufen! Bitte kontaktiere den Developer!");
			}
		}else if(args[0].equalsIgnoreCase("setVillager")){
			if(args.length == 1){
				sendHelp(p);
			}else{
				if(args[1].equalsIgnoreCase("Blau") ||args[1].equalsIgnoreCase("Rot") ||args[1].equalsIgnoreCase("Lila") ||args[1].equalsIgnoreCase("Gelb")  ){
					try{
					LocationApi.setLocation("Villager."+args[1].toLowerCase(), p);
					p.sendMessage(Bedwars.pr+"Die Location(Villager-"+args[1]+") wurde gesetzt!");
					}catch(Exception e){
						p.sendMessage(Bedwars.pr+"Bei der Speicherung einer Location(Villager-"+args[1]+") ist etwas schief gelaufen! Bitte kontaktiere den Developer!");
					}
				}else{
					p.sendMessage(Bedwars.pr+"Dieses Team ist nicht vorhanden! Bitte gebe Blau,Rot,Lila,Gelb an!");
				}
			}
		
		}

	}
		return true;
	}
	
	public void sendHelp(Player p){
		p.sendMessage("§7----- [§bBedwars§7] -----");
		p.sendMessage("§7- /bw setSpawn <Team>");
		p.sendMessage("§7- /bw setVillager <Teamname>");
		p.sendMessage("§7- /bw setBett <Team>");
		p.sendMessage("§7- /bw setHolo");
		p.sendMessage("§7- /bw setRanking <1-3>");
	}

}
