package com.moaiscoool;

import com.moaiscoool.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Grilledcheese implements ModInitializer {
	public static final String MOD_ID = "grilled-cheese";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
        ModItems.initialize();
		LOGGER.info("Thanks for letting me in. 0101100101101111011101010010011101101100011011000010000001110010011001010110011101110010011001010111010000100000011010010111010000101110");
	}
}