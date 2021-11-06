package com.gmail.furkanaxx34.duels.api.room;

import java.util.Optional;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * an interface to determine invites.
 */
public interface Invite {

  /**
   * creates a simple invite.
   *
   * @param inviter the inviter to create.
   * @param invited the invited to create.
   * @param invitedRoom the invited room to create.
   *
   * @return a newly created invite.
   */
  @NotNull
  static Invite of(@NotNull final Player inviter, @NotNull final Player invited,
                   @NotNull final Room invitedRoom) {
    return Invite.of(inviter.getUniqueId(), invited.getUniqueId(), invitedRoom);
  }

  /**
   * creates a simple invite.
   *
   * @param inviter the inviter to create.
   * @param invited the invited to create.
   * @param invitedRoom the invited room to create.
   *
   * @return a newly created invite.
   */
  @NotNull
  static Invite of(@NotNull final UUID inviter, @NotNull final UUID invited, @NotNull final Room invitedRoom) {
    return Invite.of(inviter, invited, UUID.randomUUID().toString(), invitedRoom);
  }

  /**
   * creates a simple invite.
   *
   * @param inviter the inviter to create.
   * @param invited the invited to create.
   * @param id the id to create.
   * @param invitedRoom the invited room to create.
   *
   * @return a newly created invite.
   */
  @NotNull
  static Invite of(@NotNull final Player inviter, @NotNull final Player invited, @NotNull final String id,
                   @NotNull final Room invitedRoom) {
    return Invite.of(inviter.getUniqueId(), invited.getUniqueId(), id, invitedRoom);
  }

  /**
   * creates a simple invite.
   *
   * @param inviter the inviter to create.
   * @param invited the invited to create.
   * @param id the id to create.
   * @param invitedRoom the invited room to create.
   *
   * @return a newly created invite.
   */
  @NotNull
  static Invite of(@NotNull final UUID inviter, @NotNull final UUID invited, @NotNull final String id,
                   @NotNull final Room invitedRoom) {
    return new Impl(id, invited, invitedRoom, inviter);
  }

  /**
   * obtains the id.
   *
   * @return id.
   */
  @NotNull
  String getId();

  /**
   * obtains the invited.
   *
   * @return invited.
   */
  @NotNull
  UUID getInvited();

  /**
   * obtains the invited room.
   *
   * @return invited room.
   */
  @NotNull
  Room getInvitedRoom();

  /**
   * obtains the inviter.
   *
   * @return inviter.
   */
  @NotNull
  UUID getInviter();

  /**
   * obtains the inviter as player.
   *
   * @return inviter as player.
   */
  @NotNull
  default Optional<Player> getInviterAsPlayer() {
    return Optional.ofNullable(Bukkit.getPlayer(this.getInviter()));
  }

  /**
   * gets name of the inviter.
   *
   * @return name of the inviter.
   */
  @NotNull
  default String getInviterName() {
    final var inviter = this.getInviter();
    final var name = Bukkit.getOfflinePlayer(inviter).getName();
    if (name != null) {
      return name;
    }
    return inviter.toString();
  }

  /**
   * sends the message to the invited.
   *
   * @param message the message to send.
   */
  default void sendMessageToInvited(@NotNull final Component message) {
    Optional.ofNullable(Bukkit.getPlayer(this.getInvited())).ifPresent(player ->
      player.sendMessage(message));
  }

  /**
   * a class that represents a simple implementation for {@link Invite}.
   */
  @Getter
  @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
  final class Impl implements Invite {

    /**
     * the id.
     */
    @NotNull
    private final String id;

    /**
     * the invited.
     */
    @NotNull
    private final UUID invited;

    /**
     * the invited room.
     */
    @NotNull
    private final Room invitedRoom;

    /**
     * the inviter.
     */
    @NotNull
    private final UUID inviter;
  }
}