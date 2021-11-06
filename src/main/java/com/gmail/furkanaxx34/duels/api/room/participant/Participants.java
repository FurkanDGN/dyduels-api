package com.gmail.furkanaxx34.duels.api.room.participant;

import java.util.Objects;
import java.util.UUID;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@UtilityClass
public final class Participants {

  /**
   * the participant provider.
   */
  @Nullable
  private static ParticipantProvider participantProvider;

  /**
   * gets or creates the participant via unique id.
   *
   * @param uniqueId the unique id to get.
   *
   * @return participant.
   */
  @NotNull
  static Participant get(@NotNull final UUID uniqueId) {
    return Objects.requireNonNull(Participants.participantProvider, "participant provider").apply(uniqueId);
  }

  /**
   * sets the participant provider if it's not set yet.
   *
   * @param participantProvider the provider to set.
   */
  public static void setParticipantProvider(@NotNull final ParticipantProvider participantProvider) {
    if (Participants.participantProvider == null) {
      Participants.participantProvider = participantProvider;
    }
  }
}
