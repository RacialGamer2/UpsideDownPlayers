package net.racialgamer.cheese;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.CommandRegistryAccess;
import net.racialgamer.cheese.commands.UpsideDownToggle;

public enum Init {
    INSTANCE;

    private static boolean enabled = true;

    private Init() {
    }

    public void init() {
        ClientCommandRegistrationCallback.EVENT.register(Init::registerCommands);
    }

    public static void registerCommands(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
        UpsideDownToggle.register(dispatcher);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public static int toggleEnabled() {
        enabled = !enabled;
        if (enabled) {
            MinecraftClient.getInstance().inGameHud.getChatHud().addMessage	(Text.of("Toggled UpsideDownPlayers §aON"));
        }

        if (!enabled) {
            MinecraftClient.getInstance().inGameHud.getChatHud().addMessage	(Text.of("Toggled UpsideDownPlayers §cOFF"));
        }

        return 0;
    }
}
