package de.bedwars.listeners;




import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


import de.bedwars.api.LocationApi;
import de.bedwars.main.Bedwars;
import de.bedwars.mysql.SQLStats;
import de.bedwars.utils.GameManager;
import de.bedwars.utils.Methods;


public class DeathHandler implements Listener {

	Bedwars pl = Bedwars.plugin;
	
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		
		if(e.getEntity() instanceof Player){

			

			e.getDrops().clear();
			e.setDroppedExp(0);
			
			if(e.getEntity() instanceof Player && e.getEntity().getKiller() instanceof Player){
				final Player p = (Player) e.getEntity();
				Player k = (Player) p.getKiller();
				
				e.setDeathMessage(Bedwars.pr+Methods.getColor(p)+p.getDisplayName()+" §7wurde von "+Methods.getColor(k)+k.getDisplayName()+"§7 getötet!");
				Bukkit.getScheduler().runTaskLater(pl, new Runnable() {
					
					@Override
					public void run() {
						p.setHealth(20.0);
						Methods.tptoTeamSpawn(p);
					}
				}, 1);
				
				TryKickOut(p, k);
				
				trySettingWinner();
				return;
			}else if(e.getEntity() instanceof Player && e.getEntity().getLastDamageCause().getEntity() instanceof Player){
				
				final Player p = (Player) e.getEntity();
				Player k = (Player) p.getKiller();
				if(p != k){
					
					e.setDeathMessage(Bedwars.pr+Methods.getColor(p)+p.getDisplayName()+" §7wurde von "+Methods.getColor(k)+k.getDisplayName()+"§7 getötet!");
					TryKickOut(p, k);
					trySettingWinner();
					
				}else{
					e.setDeathMessage(Bedwars.pr+Methods.getColor(p)+p.getDisplayName()+" §7ist gestorben!");
					TryKickOut(p, k);
					trySettingWinner();
				}
				Bukkit.getScheduler().runTaskLater(pl, new Runnable() {
					
					@Override
					public void run() {
						
						p.setHealth(20.0);
						Methods.tptoTeamSpawn(p);
						
					}
				}, 1);
				
			}
			
			
			
		}
		
	}
	

	
	public void trySettingWinner(){
		if(Bedwars.rot.size() == 0 && Bedwars.gelb.size() == 0 && Bedwars.Lila.size() == 0&& Bedwars.blau.size() >=1){
			for(Player p2: Bukkit.getOnlinePlayers() ){					p2.setHealth(20.0);
				p2.teleport(LocationApi.getLocation("Lobby"));
				GameManager.setState(GameManager.Restart);
			}
		
			Bukkit.broadcastMessage(Bedwars.pr+"Team§9§l Blau "+Bedwars.n+"hat gewonnen");
			for(String winner : Bedwars.blau){
				Player winner2 = Bukkit.getPlayer(winner);
			
			SQLStats.addWins(winner2.getUniqueId().toString(), 1);
			SQLStats.addPoints(winner2.getUniqueId().toString(), 30);
			}
				return;
		}else
			if(Bedwars.blau.size() == 0 && Bedwars.gelb.size() == 0 && Bedwars.Lila.size() == 0&& Bedwars.rot.size() >=1){
				for(Player p2: Bukkit.getOnlinePlayers() ){					p2.setHealth(20.0);
					p2.teleport(LocationApi.getLocation("Lobby"));
					GameManager.setState(GameManager.Restart);
				}
				for(String winner : Bedwars.rot){
					Player winner2 = Bukkit.getPlayer(winner);
				
				SQLStats.addWins(winner2.getUniqueId().toString(), 1);
				SQLStats.addPoints(winner2.getUniqueId().toString(), 30);
				}
				Bukkit.broadcastMessage(Bedwars.pr+"Team§4§l Rot "+Bedwars.n+"hat gewonnen");
					return;
			}else
		
				if(Bedwars.rot.size() == 0 && Bedwars.blau.size() == 0 && Bedwars.Lila.size() == 0&& Bedwars.gelb.size() >=1){
					for(Player p2: Bukkit.getOnlinePlayers() ){					p2.setHealth(20.0);
						p2.teleport(LocationApi.getLocation("Lobby"));
						GameManager.setState(GameManager.Restart);
					}
					for(String winner : Bedwars.gelb){
						Player winner2 = Bukkit.getPlayer(winner);
					
					SQLStats.addWins(winner2.getUniqueId().toString(), 1);
					SQLStats.addPoints(winner2.getUniqueId().toString(), 30);
					}
					Bukkit.broadcastMessage(Bedwars.pr+"Team§e§l Gelb "+Bedwars.n+"hat gewonnen");
						return;
				}else
		
		
					if(Bedwars.rot.size() == 0 && Bedwars.gelb.size() == 0 && Bedwars.blau.size() == 0&& Bedwars.Lila.size() >=1){
						for(Player p2: Bukkit.getOnlinePlayers() ){					p2.setHealth(20.0);
							p2.teleport(LocationApi.getLocation("Lobby"));
							GameManager.setState(GameManager.Restart);
						}
						for(String winner : Bedwars.Lila){
							Player winner2 = Bukkit.getPlayer(winner);
						
						SQLStats.addWins(winner2.getUniqueId().toString(), 1);
						SQLStats.addPoints(winner2.getUniqueId().toString(), 30);
						}
						Bukkit.broadcastMessage(Bedwars.pr+"Team§5§l Lila "+Bedwars.n+"hat gewonnen");
							return;
					}
	}
	
	
	public void TryKickOut(Player p, Player k){
		String TeamP = Methods.getExactTeam(p);
		if(TeamP.equalsIgnoreCase("Blau")){
			if(Bedwars.canRespawnBlau == false){
					
					Methods.ClearFromArray(p);
					SQLStats.addKills(k.getUniqueId().toString(), 1);
					SQLStats.addDeaths(p.getUniqueId().toString(), 1);
					SQLStats.addPoints(k.getUniqueId().toString(), 5);
				}
			if(Bedwars.blau.size() == 0){
				for(Player p1 : Bukkit.getOnlinePlayers()){
					p1.playSound(p1.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 50, 50);

				}
				Bukkit.broadcastMessage( Bedwars.pr+"Team §9Blau "+Bedwars.n+"ist ausgeschieden!");
				
			}
		}else if(TeamP.equalsIgnoreCase("Rot")){
			if(Bedwars.canRespawnRot == false){
				
				Methods.ClearFromArray(p);
				SQLStats.addKills(k.getUniqueId().toString(), 1);
				SQLStats.addPoints(k.getUniqueId().toString(), 5);
				SQLStats.addDeaths(p.getUniqueId().toString(), 1);
			}
			if(Bedwars.rot.size() == 0){
				for(Player p1 : Bukkit.getOnlinePlayers()){
					p1.playSound(p1.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 50, 50);

				}
				Bukkit.broadcastMessage( Bedwars.pr+"Team §4Rot "+Bedwars.n+"ist ausgeschieden!");
			}
		}else if(TeamP.equalsIgnoreCase("Lila")){
			if(Bedwars.canRespawnLila == false){
				
				Methods.ClearFromArray(p);
				SQLStats.addKills(k.getUniqueId().toString(), 1);
				SQLStats.addPoints(k.getUniqueId().toString(), 5);
				SQLStats.addDeaths(p.getUniqueId().toString(), 1);
			}
			if(Bedwars.Lila.size() == 0){
				for(Player p1 : Bukkit.getOnlinePlayers()){
					p1.playSound(p1.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 50, 50);

				}
				Bukkit.broadcastMessage( Bedwars.pr+"Team §5Lila "+Bedwars.n+"ist ausgeschieden!");
			}
		}else if(TeamP.equalsIgnoreCase("Gelb")){
			if(Bedwars.canRespawnGelb == false){
				Methods.ClearFromArray(p);
				SQLStats.addKills(k.getUniqueId().toString(), 1);
				SQLStats.addPoints(k.getUniqueId().toString(), 5);
				SQLStats.addDeaths(p.getUniqueId().toString(), 1);
				}
			if(Bedwars.gelb.size() == 0){
				for(Player p1 : Bukkit.getOnlinePlayers()){
					p1.playSound(p1.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 50, 50);

				}
				Bukkit.broadcastMessage( Bedwars.pr+"Team §eGelb "+Bedwars.n+"ist ausgeschieden!");
			}
		
		}
	}
}
