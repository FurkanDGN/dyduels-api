package com.gmail.furkanaxx34.duels.api.room;

import java.util.UUID;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface RoomProvider extends Function<@NotNull UUID, @NotNull Room> {

}
