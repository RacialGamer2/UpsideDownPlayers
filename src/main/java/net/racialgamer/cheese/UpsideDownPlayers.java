package net.racialgamer.cheese;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpsideDownPlayers implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("FastCrystals-Client");

	public UpsideDownPlayers() {
	}

	public void onInitialize() {
		Init.INSTANCE.init();
		LOGGER.info("Initializing UpsideDownPlayers");
	}
}
