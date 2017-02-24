package development.legacyCloud.randomHashTags.yoyo.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import development.legacyCloud.randomHashTags.yoyo.api.LegacyCloudAPI;

public class playerDeathEvents implements Listener {
	/*
	 * Made by RandomHashTags
	 */
	@EventHandler
	private void playerDeathEvent(PlayerDeathEvent event) {
		LegacyCloudAPI.giveAllPlayersDeathSign(event.getEntity(), event.getEntity().getKiller());
	}

}
