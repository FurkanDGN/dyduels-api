package com.gmail.furkanaxx34.duels.api.room.participant;

import java.util.UUID;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface ParticipantProvider extends Function<@NotNull UUID, @NotNull Participant> {

}
