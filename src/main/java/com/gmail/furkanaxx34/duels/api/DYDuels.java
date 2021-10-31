package com.gmail.furkanaxx34.duels.api;

import com.gmail.furkanaxx34.duels.api.arena.ArenaManager;
import com.gmail.furkanaxx34.duels.api.command.SubCommand;
import com.gmail.furkanaxx34.duels.api.kit.KitManager;
import com.gmail.furkanaxx34.duels.api.spectate.SpectateManager;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public interface DYDuels extends Plugin {

    /**
     * Gets the ArenaManager singleton used by Duels.
     *
     * @return ArenaManager singleton
     */
    @NotNull
    ArenaManager getArenaManager();

    /**
     * Gets the KitManager singleton used by Duels.
     *
     * @return KitManager singleton
     */
    @NotNull
    KitManager getKitManager();

    /**
     * Gets the SpectateManager singleton used by Duels.
     *
     * @return SpectateManager singleton
     */
    @NotNull
    SpectateManager getSpectateManager();

    /**
     * Registers a {@link SubCommand} to a Command registered by Duels.
     *
     * @param command    Name of the parent command to register the {@link SubCommand}.
     * @param subCommand {@link SubCommand} to register.
     * @return True if sub command was successfully registered. False otherwise.
     */
    boolean registerSubCommand(@NotNull final String command, @NotNull final SubCommand subCommand);

    /**
     * Registers a {@link Listener} that will be automatically unregistered on unload of Duels.
     *
     * @param listener {@link Listener} to register.
     * @since 3.1.2
     */
    void registerListener(@NotNull final Listener listener);

    /**
     * Reloads the plugin.
     *
     * @return True if reload was successful. False otherwise.
     */
    boolean reload();
}
