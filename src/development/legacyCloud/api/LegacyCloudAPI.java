package development.legacyCloud.randomHashTags.yoyo.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LegacyCloudAPI {
	private static ItemStack item = new ItemStack(Material.APPLE, 1);
	private static ItemMeta itemMeta = item.getItemMeta();
	private static ArrayList<String> lore = new ArrayList<String>();
	
	
	public static void giveAllPlayersDeathSign(Player player_that_died, LivingEntity killer) {
		lore.clear(); resetItemMeta();
		item = new ItemStack(Material.SIGN);
		itemMeta.setDisplayName(player_that_died.getName() + " death sign");
		lore.add(player_that_died.getName());
		lore.add("was killed by");
		lore.add(killer.getName());
		DateFormat df = new SimpleDateFormat("MMMM dd, yyyy");
		Date date = new Date();
		lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + df.format(date));
		itemMeta.setLore(lore);
		item.setItemMeta(itemMeta);
		for(Player player : Bukkit.getOnlinePlayers()) {
			if(player.getInventory().firstEmpty() < 0) {
				player.getWorld().dropItem(player.getLocation(), item);
			} else {
				player.getInventory().addItem(item);
				player.updateInventory();
			}
		}
		lore.clear();
	}
	
	
	
	
	private static void resetItemMeta() {
		itemMeta.spigot().setUnbreakable(false);
		for(Enchantment enchant : itemMeta.getEnchants().keySet()) { itemMeta.removeEnchant(enchant); }
		for(ItemFlag itemFlag : itemMeta.getItemFlags()) { itemMeta.removeItemFlags(itemFlag); }
	}
	
}
