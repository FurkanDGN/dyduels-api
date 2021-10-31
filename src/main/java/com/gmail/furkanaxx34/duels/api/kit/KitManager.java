package com.gmail.furkanaxx34.duels.api.kit;

import com.gmail.furkanaxx34.duels.api.loadable.Loadable;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Represents the KitManager singleton used by Duels.
 */
public interface KitManager extends Loadable {

    /**
     * Attempts to find an {@link Kit} instance associated with the given name.
     *
     * @param name Name to search through the loaded kits. Should not be null!
     * @return {@link Kit} instance that has a name matching with the given name or null if not exists.
     */
    @Nullable
    Kit get(@NotNull final String name);


    /**
     * Creates a kit with given name and {@link Player}'s inventory contents.
     *
     * @param creator {@link Player} who is the creator of this kit.
     * @param name    Name of the newly created {@link Kit}. Requires to be alphanumeric (underscore is allowed).
     * @return The newly created {@link Kit} or null if a kit with given name already exists.
     */
    @Nullable
    Kit create(@NotNull final Player creator, @NotNull final String name);


    /**
     * Removes a kit with given name.
     *
     * @param source {@link CommandSender} who is the source of this call.
     * @param name   Name of the kit to remove.
     * @return The removed {@link Kit} or null if no {@link Kit} was found with the given name.
     */
    @Nullable
    Kit remove(@NotNull CommandSender source, @NotNull final String name);


    /**
     * Calls {@link #remove(CommandSender, String)} with source being null.
     *
     * @see #remove(CommandSender, String)
     */
    @Nullable
    Kit remove(@NotNull final String name);


    /**
     * An UnmodifiableList of {@link Kit}s that are currently loaded.
     *
     * @return Never-null UnmodifiableList of {@link Kit}s that are currently loaded.
     */
    @Nullable
    List<Kit> getKits();
}
