package net.racialgamer.cheese;

import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.racialgamer.cheese.commands.UpsideDownToggle;

public enum Init {
    INSTANCE;

    private static boolean enabled = true;

    private Init() {
    }

    public void init() {
        UpsideDownToggle.register(ClientCommandManager.DISPATCHER);
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
