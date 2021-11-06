package com.gmail.furkanaxx34.duels.api.room.participant;

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * an interface to determine room participants.
 */
public interface Participant {

  /**
   * creates a simple participant.
   *
   * @param player the player to create.
   *
   * @return a newly created participant.
   */
  static Participant of(@NotNull final OfflinePlayer player) {
    return Participant.of(player.getUniqueId());
  }

  /**
   * creates a simple participant.
   *
   * @param player the player to create.
   *
   * @return a newly created participant.
   */
  static Participant of(@NotNull final Player player) {
    return Participant.of(player.getUniqueId());
  }

  /**
   * creates a simple participant.
   *
   * @param uniqueId the unique id to create.
   *
   * @return a newly created participant.
   */
  static Participant of(@NotNull final UUID uniqueId) {
    return Participants.get(uniqueId);
  }

  /**
   * obtains the member as offline player.
   *
   * @return member as offline player.
   */
  @NotNull
  default OfflinePlayer getAsOfflinePlayer() {
    return Bukkit.getOfflinePlayer(this.getUniqueId());
  }

  /**
   * obtains the member as player.
   *
   * @return member as player.
   */
  @Nullable
  default Player getAsPlayer() {
    return Bukkit.getPlayer(this.getUniqueId());
  }

  /**
   * obtains the unique id of the participant.
   *
   * @return the unique id of the participant.
   */
  @NotNull
  UUID getUniqueId();
}
