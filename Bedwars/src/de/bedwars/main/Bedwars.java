package de.bedwars.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import de.bedwars.utils.GameManager;
import de.bedwars.utils.MapReseter;
import de.bedwars.utils.Methods;
import de.bedwars.utils.ScoreboardManager;
import de.bedwars.utils.Spawner;
import de.bedwars.api.LocationApi;
import de.bedwars.commands.BW;
import de.bedwars.commands.SetRanking;
import de.bedwars.listeners.BlockHandler;
import de.bedwars.mysql.MySQL;
import de.bedwars.mysql.Ranking;
import de.bedwars.mysql.SQLStats;
import de.bedwars.listeners.Chat;
import de.bedwars.listeners.DamageHandler;
import de.bedwars.listeners.FoodHandler;
import de.bedwars.listeners.Interact;
import de.bedwars.listeners.JoinQuit;
import de.bedwars.listeners.NatureHandler;
import de.bedwars.listeners.DeathHandler;
import de.bedwars.shop.ShopInteract;
import de.bedwars.shop.ShopManager;
import de.bedwars.shop.VillagerInteract;
import de.bedwars.teams.TeamListener;


public class Bedwars extends JavaPlugin{

	public static ArrayList<String> build = new ArrayList<>();
	
	public static ArrayList<String> rot = new ArrayList<>();
	public static ArrayList<String> blau = new ArrayList<>();
	public static ArrayList<String> gelb = new ArrayList<>();
	public static ArrayList<String> Lila = new ArrayList<>();
	
	public static boolean canRespawnRot = true;
	public static boolean canRespawnBlau = true;
	public static boolean canRespawnGelb = true;	
	public static boolean canRespawnLila = true;
	
	public static String pr = "§f[§bBedwars§f] §b";	
	public static String a = "§b";
	public static String n = "§7";
	public static Bedwars plugin;
	MySQL mysql;
	int i = 31;
	BukkitTask task;
	
	public void onEnable(){
		plugin = this;	
		loadConfig();
		for(World w : Bukkit.getWorlds()){
			
			w.setThundering(false);
			w.setStorm(false);
			w.setTime(0);
			
		}
		Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
			
			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()){
					
					ScoreboardManager.setScoreBoard(p);
					ScoreboardManager.UpdateScoreboard(p);
				}

			}
		}, 20, 60);
		GameManager.setState(GameManager.LOBBY);

		this.getServer().getPluginManager().registerEvents(new JoinQuit(), this);
		this.getServer().getPluginManager().registerEvents(new ShopInteract(), this);
		this.getServer().getPluginManager().registerEvents(new VillagerInteract(), this);
		this.getServer().getPluginManager().registerEvents(new BlockHandler(), this);
		this.getServer().getPluginManager().registerEvents(new TeamListener(), this);
		this.getServer().getPluginManager().registerEvents(new Chat(), this);
		this.getServer().getPluginManager().registerEvents(new FoodHandler(), this);
		this.getServer().getPluginManager().registerEvents(new Interact(), this);
		this.getServer().getPluginManager().registerEvents(new NatureHandler(), this);
		this.getServer().getPluginManager().registerEvents(new DeathHandler(), this);
		this.getServer().getPluginManager().registerEvents(new DamageHandler(), this);
		this.getCommand("Spawner").setExecutor(new Spawner());
		this.getCommand("Bw").setExecutor(new BW());
		this.getCommand("setranking").setExecutor(new SetRanking());
		CD();
		ShopManager.MainInv = Bukkit.createInventory(null, 27, "§3§lShop");
		ShopManager.BogenInv = Bukkit.createInventory(null, 18, "§f【§3Bögen§f】");
		ShopManager.Chest = Bukkit.createInventory(null, 18, "§f【§3Kisten§f】");
		ShopManager.EssenInv = Bukkit.createInventory(null, 18, "§f【§3Essen§f】");
		ShopManager.Spezial = Bukkit.createInventory(null, 18, "§f【§3Spezial - 1§f】");
		ShopManager.SPitzhacken = Bukkit.createInventory(null, 18, "§f【§3Spitzhacken§f】");
		ShopManager.Tränke = Bukkit.createInventory(null, 18, "§f【§aTränke§f】");
		ShopManager.WaffenInv = Bukkit.createInventory(null, 18, "§f【§3Waffen§f】");
		ShopManager.BlöckeInv = Bukkit.createInventory(null, 18, "§f【§3Blöcke§f】");
		ShopManager.RüstungInv = Bukkit.createInventory(null, 18, "§f【§3Rüstung§f】");
		GameManager.setState(GameManager.LOBBY);
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		ConnectToMYSQL();
		Ranking.set();
	
	}
	
	public void onDisable(){
		
		String w = this.getConfig().getString("World");
		World wo = Bukkit.getWorld(w);
		
		for(Entity e : wo.getEntities()){
			if(e.getType() == EntityType.DROPPED_ITEM || e.getType() == EntityType.VILLAGER){
				
				e.remove();
				
			}
		}
		MapReseter.ResetMap();
	}
	
	public void loadConfig(){
		FileConfiguration cfg = this.getConfig();
		
		cfg.options().copyDefaults(true);
		cfg.addDefault("MySQL.Host", "");
		cfg.addDefault("MySQL.User", "");
		cfg.addDefault("MySQL.PW", "");
		cfg.addDefault("MySQL.Database", "");
		cfg.addDefault("World", "respawn");
		saveConfig();
		
	}
	
	public void ConnectToMYSQL(){
		mysql = new MySQL(this.getConfig().getString("MySQL.Host"), this.getConfig().getString("MySQL.Database"), this.getConfig().getString("MySQL.User"), this.getConfig().getString("MySQL.PW"));
		MySQL.update("CREATE TABLE IF NOT EXISTS BedWarsStats(UUID varchar(64), Played int, Wins int, Points int, Kills int, Deaths int, zB int);");
	}
	
	
	 
	
	public void CD(){
		
		task = Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
			
			@Override
			public void run() {
				
				if(Bukkit.getOnlinePlayers().size() == 2){
					i--;
					for(Player p : Bukkit.getOnlinePlayers() ){
						
						p.setLevel(i);
						
					}
					if(i == 90 || i == 60 || i == 45|| i== 30||i==20||i==10||i==5||i==4||i==3||i==2||i==1){
						
						Bukkit.broadcastMessage(pr+"Das Spiel startet in "+a+i+n+" Sekunde(n).");
						
					}else if( i == 0){
						GameManager.setState(GameManager.GAME);
						for(Player p : Bukkit.getOnlinePlayers() ){
							
							if(Methods.hasTeam(p)){

							}else{
								
								if(blau.size() <= Lila.size() && blau.size() <= rot.size() && blau.size() <= gelb.size()){
									blau.add(p.getName());
								}else if(Lila.size() <= blau.size() && Lila.size() <= rot.size() && Lila.size() <= gelb.size()){
									Lila.add(p.getName());
								}else if(rot.size() <= blau.size() && rot.size() <= Lila.size() && rot.size() <= gelb.size()){
									rot.add(p.getName());
								}else if(gelb.size() <= blau.size() && gelb.size() <= Lila.size() && gelb.size() <= rot.size()){
									gelb.add(p.getName());
								}
								
							}
							String team = Methods.getExactTeam(p).toLowerCase();
							p.teleport(LocationApi.getLocation("Spawn."+team));
							SQLStats.addPlayed(p.getUniqueId().toString(), 1);
						}
						
						Spawner.StartSpawning();
						Methods.SetupGame();
					}
					
				}else{
					i = 31;
				}
				
			}
		}, 0, 20);
		
	}
	
	
	
}
