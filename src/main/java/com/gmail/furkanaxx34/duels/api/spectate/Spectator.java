package com.gmail.furkanaxx34.duels.api.spectate;

import com.gmail.furkanaxx34.duels.api.arena.Arena;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Represents a Spectator joined in the match.
 */
public interface Spectator {

    /**
     * The {@link UUID} of this spectator.
     *
     * @return {@link UUID} of this spectator.
     */
    @NotNull
    UUID getUuid();

    /**
     * The {@link Arena} this spectator is spectating.
     *
     * @return {@link Arena} this spectator is spectating.
     */
    @NotNull
    Arena getArena();
}
