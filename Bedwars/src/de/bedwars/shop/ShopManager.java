package de.bedwars.shop;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.bedwars.api.ItemCreator;

public class ShopManager {

	public static Inventory MainInv;
	public static Inventory WaffenInv;
	public static Inventory BogenInv;
	public static Inventory BlöckeInv;
	public static Inventory SPitzhacken;
	public static Inventory Tränke;
	public static Inventory Spezial;
	public static Inventory EssenInv;
	public static Inventory RüstungInv;
	public static Inventory Chest;
	
	
	
	public static void openShopInv(Player p){
		
		Inventory inv = MainInv;
		
		inv.setItem(0, ItemCreator.CreateItemwithMaterial(Material.HARD_CLAY, 0, 1, "§6> Blöcke", null));
		inv.setItem(10, ItemCreator.CreateItemwithMaterial(Material.IRON_PICKAXE, 0, 1, "§5> Spitzhacken", null));
		inv.setItem(2, ItemCreator.CreateItemwithMaterial(Material.DIAMOND_SWORD, 0, 1, "§3> Waffen", null));
		inv.setItem(12, ItemCreator.CreateItemwithMaterial(Material.BOW, 0, 1, "§9> Bögen", null));
		inv.setItem(4, ItemCreator.CreateItemwithMaterial(Material.CHAINMAIL_CHESTPLATE, 0, 1, "§8> Rüstung", null));
		inv.setItem(13, ItemCreator.CreateItemwithID(373, 8235, 1,"§a> Tränke" , null));
		inv.setItem(8, ItemCreator.CreateItemwithMaterial(Material.CHEST, 0, 1, "§2> Kisten", null));
		inv.setItem(15, ItemCreator.CreateItemwithMaterial(Material.FIREWORK, 0, 1, "§3§k:: §fSpezial §3§k::", null));

		
		p.openInventory(inv);
	}
	
	public static void openBlöcke(Player p){
		
		Inventory inv = BlöckeInv;
		
		inv.setItem(0, ItemCreator.CreateItemwithMaterial(Material.HARD_CLAY, 0, 1, "§6> Harter Clay", null));
		inv.setItem(2, ItemCreator.CreateItemwithMaterial(Material.ENDER_STONE, 0, 1, "§5> Endstein", null));
		inv.setItem(4, ItemCreator.CreateItemwithMaterial(Material.GLASS, 0, 1, "§3> Glass", null));
		inv.setItem(6, ItemCreator.CreateItemwithMaterial(Material.GLOWSTONE, 0, 1, "§9> Glowstone", null));
		inv.setItem(8, ItemCreator.CreateItemwithMaterial(Material.IRON_BLOCK, 0, 1, "§8> Eisenblock", null));


		
		p.openInventory(inv);
	}
	
	
	public static void openPickaxe(Player p){
		
		Inventory inv = SPitzhacken;
		
		inv.setItem(2, ItemCreator.CreateItemwithMaterial(Material.WOOD_PICKAXE, 0, 1, "§6> Holzspitzhacke", null));
		inv.setItem(4, ItemCreator.CreateItemwithMaterial(Material.STONE_PICKAXE, 0, 1, "§5> Steinspitzhacke", null));
		inv.setItem(6, ItemCreator.CreateItemwithMaterial(Material.IRON_PICKAXE, 0, 1, "§3> Eisenspitzhacke", null));



		
		p.openInventory(inv);
	}
	public static void openWaffe(Player p){
		
		Inventory inv = WaffenInv;
		
		inv.setItem(1, ItemCreator.CreateItemwithMaterial(Material.STICK, 0, 1, "§6> KnockbackStick", null));
		inv.setItem(3, ItemCreator.CreateItemwithMaterial(Material.GOLD_SWORD, 0, 1, "§5> Schwert Lvl.1", null));
		inv.setItem(5, ItemCreator.CreateItemwithMaterial(Material.GOLD_SWORD, 0, 1, "§3> Schwert Lvl.2", null));
		inv.setItem(7, ItemCreator.CreateItemwithMaterial(Material.IRON_SWORD, 0, 1, "§3> Schwert Lvl.3", null));


		p.openInventory(inv);
	}
	
	public static void openBogen(Player p){
		
		Inventory inv = BogenInv;
		
		ItemStack Bogen1 = new ItemStack(Material.BOW);
		Bogen1.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		ItemMeta bm1 = Bogen1.getItemMeta();
		bm1.setDisplayName("§3> Bogen Lvl.1");
		Bogen1.setItemMeta(bm1);
		
		ItemStack Bogen11 = new ItemStack(Material.BOW);
		Bogen11.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		Bogen11.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
		ItemMeta bm11 = Bogen11.getItemMeta();
		bm11.setDisplayName("§3> Bogen Lvl.2");
		Bogen11.setItemMeta(bm11);
		
		ItemStack Bogen111 = new ItemStack(Material.BOW);
		Bogen111.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		Bogen111.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
		Bogen111.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 1);

		ItemMeta bm111 = Bogen111.getItemMeta();
		bm111.setDisplayName("§3> Bogen Lvl.3");
		Bogen111.setItemMeta(bm111);
		
		ItemStack A = new ItemStack(Material.ARROW);
		ItemMeta am = A.getItemMeta();
		am.setDisplayName("§3> Pfeil");
		A.setItemMeta(am);
		


		

		inv.setItem(1, Bogen1);
		inv.setItem(3, Bogen11);
		inv.setItem(5, Bogen111);
		inv.setItem(7, A);


		p.openInventory(inv);
	}
	
	public static void openRüstung(Player p){
		
		
		Inventory inv = RüstungInv;
		
		ItemStack Bogen1 = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemMeta bm1 = Bogen1.getItemMeta();
		bm1.setDisplayName("§b〔Leder-Hose〕");
		Bogen1.setItemMeta(bm1);
		
		ItemStack Bogen11 = new ItemStack(Material.LEATHER_BOOTS);
		ItemMeta bm11 = Bogen11.getItemMeta();
		bm11.setDisplayName("§b〔Leder-Schuhe〕");
		Bogen11.setItemMeta(bm11);
		
		ItemStack Bogen111 = new ItemStack(Material.LEATHER_HELMET);
		ItemMeta bm111 = Bogen111.getItemMeta();
		bm111.setDisplayName("§b〔Leder-Helm〕");
		Bogen111.setItemMeta(bm111);
		
		ItemStack Bogen1111 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		Bogen1111.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
		Bogen1111.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		ItemMeta bm1111 = Bogen1111.getItemMeta();
		bm1111.setDisplayName("§b〔BrustPanzer Lvl.1〕");

		Bogen1111.setItemMeta(bm1111);
		ItemStack Bogen11111 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		Bogen11111.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
		Bogen11111.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		Bogen11111.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);

		ItemMeta bm11111 = Bogen11111.getItemMeta();
		bm11111.setDisplayName("§b〔BrustPanzer Lvl.2〕");
		Bogen11111.setItemMeta(bm11111);
		ItemStack Bogen111111 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		Bogen111111.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
		Bogen111111.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		Bogen111111.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
		ItemMeta bm111111 = Bogen111111.getItemMeta();
		bm111111.setDisplayName("§b〔BrustPanzer Lvl.3〕");
		Bogen111111.setItemMeta(bm111111);
		

		

		


		inv.setItem(0, Bogen11);
		inv.setItem(1, Bogen1);
		inv.setItem(2, Bogen111);
		

		inv.setItem(6, Bogen1111);
		
		inv.setItem(7, Bogen11111);
		inv.setItem(8, Bogen111111);


				
					
		p.openInventory(inv);
	}
	
	public static void openTränke(Player p){
		
		
		ItemStack Bogen1 = new ItemStack(373,1,(short)8261);
		ItemMeta bm1 = Bogen1.getItemMeta();
		bm1.setDisplayName("§b〔Heil-Trank〕");
		Bogen1.setItemMeta(bm1);
		
		ItemStack Bogen11 = new ItemStack(373,1,(short)8257);
		ItemMeta bm11 = Bogen11.getItemMeta();
		bm11.setDisplayName("§b〔Regenerations-Trank〕");
		Bogen11.setItemMeta(bm11);
		
		ItemStack Bogen111 = new ItemStack(373,1,(short)8194);
		ItemMeta bm111 = Bogen111.getItemMeta();
		bm111.setDisplayName("§b〔Schnelligkeits-Trank〕");
		Bogen111.setItemMeta(bm111);
		
		ItemStack Bogen1111 = new ItemStack(373,1,(short)8201);
		ItemMeta bm1111 = Bogen1111.getItemMeta();
		bm1111.setDisplayName("§b〔Stärke-Trank〕");
		Bogen1111.setItemMeta(bm1111);
		ItemStack Bogen11111 = new ItemStack(373,1,(short)8235);
		ItemMeta bm11111 = Bogen11111.getItemMeta();
		bm11111.setDisplayName("§b〔Jump-Trank〕");
		Bogen11111.setItemMeta(bm11111);

		

		

		
		Inventory inv = Tränke;
		ItemStack i = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta im = i.getItemMeta();
		
		im.setDisplayName("§3§k> §4Zurück §3§k<");
		
		i.setItemMeta(im);
		inv.setItem(13, i);
		inv.setItem(1, Bogen1);
		inv.setItem(3, Bogen11);
		inv.setItem(5, Bogen111);
		
		
		inv.setItem(7, Bogen1111);
		
		inv.setItem(4, Bogen11111);



				
					
		p.openInventory(Tränke);
	}
	public static void openChest(Player p){
		
		Inventory inv = Chest;
		
		inv.setItem(3, ItemCreator.CreateItemwithMaterial(Material.CHEST, 0, 1, "§6> Kiste", null));
		inv.setItem(6, ItemCreator.CreateItemwithMaterial(Material.ENDER_CHEST, 0, 1, "§5> TeamKiste", null));



		
		p.openInventory(inv);
	}
	
	public static void openEssen(Player p){
		
		Inventory inv = EssenInv;
		//ArrayList<String> InfosZumItem = new ArrayList<>();
		//InfosZumItem.add("§9Für dieses Item brauchst du 1 Bronze! | Dieser Goldene Apfel kostet 1 Gold");
		inv.setItem(2, ItemCreator.CreateItemwithMaterial(Material.COOKIE, 0, 1, "§6> Cookie", null));
		inv.setItem(4, ItemCreator.CreateItemwithMaterial(Material.COOKED_BEEF, 0, 1, "§5> Steak", null));
		inv.setItem(6, ItemCreator.CreateItemwithMaterial(Material.GOLDEN_APPLE, 0, 1, "§6> Goldener Apfel", null));


		
		p.openInventory(inv);
	}
	
}
