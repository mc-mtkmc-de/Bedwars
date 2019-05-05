package de.bedwars.shop;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.bedwars.api.ItemCreator;
import de.bedwars.main.Bedwars;


public class ShopInteract implements Listener {

	
	
	@EventHandler
	public void onInteractinInv(InventoryClickEvent e){
		try{
			Player p = (Player) e.getWhoClicked();
			if(e.getInventory() == ShopManager.BlöckeInv || e.getInventory() == ShopManager.BogenInv ||e.getInventory() == ShopManager.Chest ||e.getInventory() == ShopManager.EssenInv ||e.getInventory() == ShopManager.MainInv ||e.getInventory() == ShopManager.RüstungInv ||e.getInventory() == ShopManager.Spezial ||e.getInventory() == ShopManager.SPitzhacken ||e.getInventory() == ShopManager.Tränke ||e.getInventory() == ShopManager.WaffenInv){
				
				
				
				
				if(e.getInventory() == ShopManager.MainInv){
					//Wenn es nicht klappt:
					//if(e.getCurrentItem().getType() == Material.HARD_CLAY) // blabal
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6> Blöcke")){
						ShopManager.openBlöcke(p);
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5> Spitzhacken")){
						ShopManager.openPickaxe(p);
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3> Waffen")){
						ShopManager.openWaffe(p);
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9> Bögen")){
						ShopManager.openBogen(p);
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8> Rüstung")){
						ShopManager.openRüstung(p);
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a> Tränke")){
						ShopManager.openTränke(p);
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2> Kisten")){
						ShopManager.openChest(p);
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§k:: §fSpezial §3§k::")){
						p.sendMessage("§4Bald verfügbar!");
					}else{
						
					}
					
				}else if(e.getInventory() == ShopManager.BlöckeInv){
					
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6> Harter Clay")){
						e.setCancelled(true);
						if(p.getInventory().contains(new ItemStack(366), 1)){
							
							int place = getBestMaterialItemPlaceIDS(p, 366);
							
							p.getInventory().getItem(place).setAmount(p.getInventory().getItem(place).getAmount()-1);
							p.getInventory().addItem(ItemCreator.CreateItemwithID(366, 0, 1, "", null));
							p.updateInventory();
							
						}else{
							
							p.sendMessage(Bedwars.pr+"Du hast nicht genügend Bronze");
							
						}
						
					}
					
				}else if(e.getInventory() == ShopManager.WaffenInv){
					
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6> KnockbackStick")){
						e.setCancelled(true);
						if(p.getInventory().contains(new ItemStack(366), 10)){
							
							int place = getBestMaterialItemPlaceIDS(p, 366);
							
							p.getInventory().getItem(place).setAmount(p.getInventory().getItem(place).getAmount()-10);
							ItemStack knockback = new ItemStack(Material.STICK);
							knockback.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
							ItemMeta im = knockback.getItemMeta();
							im.setDisplayName("§6Knockback-Stick");
							knockback.setItemMeta(im);
							p.getInventory().addItem(knockback);
							p.updateInventory();
							
						}else{
							
							p.sendMessage(Bedwars.pr+"Du hast nicht genügend Bronze");
							
						}
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5> Schwert Lvl.1")){
						e.setCancelled(true);
						if(p.getInventory().contains(Material.IRON_INGOT, 1)){
							
							int place = getBestMaterialItemPlaceID(p, Material.IRON_INGOT);
							
							p.getInventory().getItem(place).setAmount(p.getInventory().getItem(place).getAmount()-1);
							ItemStack knockback = new ItemStack(Material.GOLD_SWORD);
							knockback.addUnsafeEnchantment(Enchantment.DURABILITY, 20);
							ItemMeta im = knockback.getItemMeta();
							im.setDisplayName("§5Schwert LvL.1");
							knockback.setItemMeta(im);
							p.getInventory().addItem(knockback);
							p.updateInventory();
							
						}else{
							
							p.sendMessage(Bedwars.pr+"Du hast nicht genügend Silber");
							
						}
						
					}
					
				}else if(e.getInventory() == ShopManager.BogenInv){
					
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3> Bogen Lvl.3")){
						e.setCancelled(true);
						if(p.getInventory().contains(Material.GOLD_INGOT, 12)){
							
							int place = getBestMaterialItemPlaceID(p, Material.GOLD_INGOT);
							
							p.getInventory().getItem(place).setAmount(p.getInventory().getItem(place).getAmount()-12);
							ItemStack knockback = new ItemStack(Material.BOW);
							knockback.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
							knockback.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
							knockback.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
							ItemMeta im = knockback.getItemMeta();
							im.setDisplayName("§3Bogen Lvl.3");
							knockback.setItemMeta(im);
							p.getInventory().addItem(knockback);
							p.updateInventory();
							
						}else{
							
							p.sendMessage(Bedwars.pr+"Du hast nicht genügend Bronze");
							
						}
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3> Pfeil")){
						e.setCancelled(true);
						if(p.getInventory().contains(Material.GOLD_INGOT, 1)){
							
							int place = getBestMaterialItemPlaceID(p, Material.GOLD_INGOT);
							
							p.getInventory().getItem(place).setAmount(p.getInventory().getItem(place).getAmount()-1);
							ItemStack knockback = new ItemStack(Material.ARROW);
							ItemMeta im = knockback.getItemMeta();
							im.setDisplayName("§3Pfeil");
							knockback.setItemMeta(im);
							p.getInventory().addItem(knockback);
							p.updateInventory();
							
						}else{
							
							p.sendMessage(Bedwars.pr+"Du hast nicht genügend Bronze");
							
						}
						
					}
					
				}
				
				
				
				
				
				
				
				
				
				
				
				
			}
			
		}catch(Exception e1){
			
		}
	}
	
	
	
	private int getBestMaterialItemPlaceID(Player p, Material m){
		int i = 0;
		int bestMaterial = 0;
		
		for(int i2 = 0; i2<27; i2++){
			
			if(p.getInventory().getItem(i2) != null){
				
				if(p.getInventory().getItem(i2).getType() == m && p.getInventory().getItem(i2).getAmount() >= bestMaterial){
					
					i = i2;
					
				}
				
			}
			
		}
		
		return i;
	}
	
	@SuppressWarnings("deprecation")
	private int getBestMaterialItemPlaceIDS(Player p, int ID){
		int i = 0;
		int bestMaterial = 0;
		
		for(int i2 = 0; i2<27; i2++){
			
			if(p.getInventory().getItem(i2) != null){
				
				if(p.getInventory().getItem(i2).getTypeId() == ID && p.getInventory().getItem(i2).getAmount() >= bestMaterial){
					
					i = i2;
					
				}
				
			}
			
		}
		
		return i;
	}
}
