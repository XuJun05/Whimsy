package gay.xujun.whimsy;

import gay.xujun.whimsy.block.BlockRegistry;
import gay.xujun.whimsy.effect.RedWedgieEffect;
import gay.xujun.whimsy.effect.WhiteWedgieEffect;
import gay.xujun.whimsy.event.RedWedgieEvents;
import gay.xujun.whimsy.item.ItemRegistry;
import gay.xujun.whimsy.utility.WhimsyTab;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Whimsy implements ModInitializer {
	public static final String MOD_ID = "whimsy";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
        WhimsyTab.initialize();
        ItemRegistry.initialize();
        BlockRegistry.initialize();
        WhiteWedgieEffect.initialize();
        RedWedgieEffect.initialize();
        RedWedgieEvents.initialize();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
