package com.gmail.furkanaxx34.duels.api.arena;

import com.gmail.furkanaxx34.duels.api.match.Match;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents an Arena loaded on the server.
 */
public interface Arena {

    /**
     * The name of this arena. Will not contain a dash character ("-").
     *
     * @return Never-null {@link String} that is the name of this arena.
     */
    @NotNull
    String getName();


    /**
     * Whether or not this arena is currently disabled.
     *
     * @return True if this arena is disabled. False otherwise.
     * @see #setDisabled(CommandSender, boolean)
     */
    boolean isDisabled();


    /**
     * Disables this arena which prevents it from being used in duels.
     *
     * @param disabled True to disable the arena, False to enable.
     */
    boolean setDisabled(@Nullable final CommandSender source, final boolean disabled);


    /**
     * Calls {@link #setDisabled(CommandSender, boolean)} with the source being null.
     *
     * @see #setDisabled(CommandSender, boolean)
     */
    boolean setDisabled(final boolean disabled);


    /**
     * The spawnpoint set for the position number.
     *
     * @param pos Position number associated with the spawnpoint
     * @return {@link Location} associated with the position number or null if position is unset.
     */
    @Nullable
    Location getPosition(final int pos);


    /**
     * Sets a spawnpoint with the given position and location.
     *
     * @param pos      Position number for the spawnpoint.
     * @param location Location to be the spawnpoint. Should not be null!
     */
    boolean setPosition(@Nullable final Player source, final int pos, @NotNull final Location location);


    /**
     * Calls {@link #setPosition(Player, int, Location)} with the source being null.
     *
     * @see #setPosition(Player, int, Location)
     */
    boolean setPosition(final int pos, @NotNull final Location location);


    /**
     * Whether or not a duel is currently being played in this arena. If returned true, {@link #getMatch()} is guaranteed to return a {@link Match} instance.
     *
     * @return True if this arena is in use. False otherwise.
     */
    boolean isUsed();


    /**
     * The {@link Match} being played in this arena. May be null if no match is being played.
     *
     * @return {@link Match} instance if a duel is currently being played in this arena. null otherwise.
     */
    @Nullable
    Match getMatch();


    /**
     * Whether or not the player is playing in this arena.
     *
     * @param player {@link Player} to check if in this arena. Should not be null!
     * @return True if the player is in this arena. False otherwise.
     */
    boolean has(@NotNull final Player player);


    /**
     * Whether or not this {@link Arena} has been removed.
     *
     * @return True if this {@link Arena} has been removed. False otherwise.
     */
    boolean isRemoved();
}
