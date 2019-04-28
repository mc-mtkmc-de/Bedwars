package de.bedwars.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.bedwars.api.LocationApi;
import de.bedwars.main.Bedwars;


public class SetRanking implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2,
			String[] args) {
		Player p = (Player) sender;
		if(args.length == 0){
			
			p.sendMessage(Bedwars.pr+" Bitte gebe eine Zahl von 1-3 an!");
			
		}else if(args.length >= 1){
			
		
			try{
			int i = Integer.parseInt(args[0]);
			
			p.sendMessage(Bedwars.pr+"Du hast Ranking-Platz "+Bedwars.a+i+Bedwars.n+" gesetzt!");
	
			LocationApi.setLocation("Ranking."+i, p);
			
			}catch(NumberFormatException e){
				p.sendMessage(Bedwars.pr+"Du musst eine Zahl angeben!");
			}
		
		}
		
		return true;
	}

}
