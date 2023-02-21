package net.racialgamer.cheese.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.racialgamer.cheese.Init;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v1.FabricClientCommandSource;

public class UpsideDownToggle {
    public UpsideDownToggle() {
    }

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register((LiteralArgumentBuilder)ClientCommandManager.literal("upsidedown").executes((ctx) -> {
            return Init.toggleEnabled();
        }));
    }
}
