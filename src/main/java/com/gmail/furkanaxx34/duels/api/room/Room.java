package com.gmail.furkanaxx34.duels.api.room;

import com.gmail.furkanaxx34.duels.api.room.participant.Participant;
import com.gmail.furkanaxx34.duels.api.room.setting.Settable;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * an interface to determine rooms.
 */
public interface Room extends Settable {

  /**
   * adds the id to invitation.
   *
   * @param invite the invite to add.
   */
  static void addInvitation(@NotNull final Invite invite) {
    Rooms.addInvitation(invite);
  }

  /**
   * obtains the invited player.
   *
   * @param id the id to get.
   *
   * @return invited player's unique id.
   */
  @NotNull
  static Optional<Invite> getInvitation(@NotNull final String id) {
    return Rooms.getInvitation(id);
  }

  /**
   * adds the participant to the room.
   *
   * @param uniqueId the unique id to add.
   */
  default void addParticipant(@NotNull final UUID uniqueId) {
    this.addParticipant(Participant.of(uniqueId));
  }

  /**
   * adds the participant to the room.
   *
   * @param participant the participant to add.
   */
  void addParticipant(@NotNull Participant participant);

  /**
   * obtains the owner.
   *
   * @return owner.
   */
  @NotNull
  UUID getOwner();

  /**
   * obtains the owner as offline player.
   *
   * @return owner as offline player.
   */
  @NotNull
  default OfflinePlayer getOwnerAsOfflinePlayer() {
    return Bukkit.getOfflinePlayer(this.getOwner());
  }

  /**
   * obtains the owner as player.
   *
   * @return owner as player.
   */
  @Nullable
  default Player getOwnerAsPlayer() {
    return Bukkit.getPlayer(this.getOwner());
  }

  /**
   * gets the participant via unique id.
   *
   * @param uniqueId the unique id to get.
   *
   * @return participant.
   */
  @NotNull
  Optional<Participant> getParticipant(@NotNull UUID uniqueId);

  /**
   * obtains the participants of the room.
   *
   * @return participants of the room.
   */
  @NotNull
  Collection<Participant> getParticipants();

  /**
   * obtains the unique id of the room.
   *
   * @return unique id of the room.
   */
  @NotNull
  UUID getUniqueId();

  /**
   * checks if the player is the participant of the room.
   *
   * @param uniqueId the unique id to check
   *
   * @return {@code true} if the player is a part of the participants of room.
   */
  default boolean isParticipant(@NotNull final UUID uniqueId) {
    return this.getParticipant(uniqueId).isPresent();
  }

  /**
   * checks if the player is the participant of the room.
   *
   * @param player the player to check
   *
   * @return {@code true} if the player is a part of the participants of room.
   */
  default boolean isParticipant(@NotNull final Player player) {
    return this.getParticipant(player.getUniqueId()).isPresent();
  }

  /**
   * removes the participant from the room.
   *
   * @param uniqueId the unique id to remove.
   */
  default void removeParticipant(@NotNull final UUID uniqueId) {
    this.removeParticipant(Participant.of(uniqueId));
  }

  /**
   * removes the participant from the room.
   *
   * @param participant the participant to remove.
   */
  void removeParticipant(@NotNull Participant participant);
}
