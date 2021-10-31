package com.gmail.furkanaxx34.duels.api.queue;

import com.gmail.furkanaxx34.duels.api.kit.Kit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface DQueue {

    /**
     * The {@link Kit} set for this {@link DQueue}.
     *
     * @return {@link Kit} set for this {@link DQueue} or null if no kit was set.
     */
    @Nullable
    Kit getKit();


    /**
     * The bet amount for this {@link DQueue}.
     *
     * @return Bet amount for this {@link DQueue} or 0 if no bet was specified.
     */
    int getBet();


    /**
     * Whether or not the given {@link Player} is in this {@link DQueue}.
     *
     * @param player Player to check if in this {@link DQueue}. Must not be null!
     * @return True if player is in this {@link DQueue}. False otherwise.
     */
    boolean isInQueue(@NotNull final Player player);


    /**
     * An UnmodifiableList of {@link Player}s in this queue.
     *
     * @return Never-null UnmodifiableList of {@link Player}s in this queue.
     */
    @NotNull
    List<Player> getQueuedPlayers();
}
