package development.legacyCloud.randomHashTags.yoyo.randomHashTags;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import development.legacyCloud.randomHashTags.yoyo.api.LegacyCloudAPI;

public class playerDeathEvents implements Listener {
	@EventHandler
	private void playerDeathEvent(PlayerDeathEvent event) {
		LegacyCloudAPI.giveAllPlayersDeathSign(event.getEntity(), event.getEntity().getKiller());
	}

}
