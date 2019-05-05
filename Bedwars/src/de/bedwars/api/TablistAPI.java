package de.bedwars.api;

import java.lang.reflect.Field;

import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_12_R1.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_12_R1.PlayerConnection;

import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class TablistAPI {

	
	
	public static void sendTabTitle(Player player, String header, String footer) {
		if (header == null) header = "";
	
		if (footer == null) footer = "";
		
		PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
		
		IChatBaseComponent tabTitle = ChatSerializer.a("{\"text\": \"" + header + "\"}");
		
		IChatBaseComponent tabFoot = ChatSerializer.a("{\"text\": \"" + footer + "\"}");
		
		PacketPlayOutPlayerListHeaderFooter headerPacket = new PacketPlayOutPlayerListHeaderFooter();
		
	try {
	
		Field field = headerPacket.getClass().getDeclaredField("b");
		field.setAccessible(true);
		field.set(headerPacket, tabFoot);

	} catch (Exception e) {
	
	e.printStackTrace();
	
	} finally {
	
	connection.sendPacket(headerPacket);
		
	}
	}

}
