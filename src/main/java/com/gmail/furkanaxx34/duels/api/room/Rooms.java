package com.gmail.furkanaxx34.duels.api.room;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@UtilityClass
public final class Rooms {

  /**
   * the invitations.
   * <p>
   * id-player unique id,claim unique id.
   */
  private final Map<String, Invite> INVITATIONS = new ConcurrentHashMap<>();

  /**
   * the rooms by unique id.
   */
  private final Map<UUID, Room> ROOMS = new ConcurrentHashMap<>();

  private final Set<Room> ROOMS_SET = ConcurrentHashMap.newKeySet();

  /**
   * the room by owner.
   */
  private final Object2ObjectMap<UUID, Room> ROOM_CACHE_BY_OWNER = Object2ObjectMaps.synchronize(new Object2ObjectOpenHashMap<>());

  /**
   * the room provider.
   */
  @Nullable
  private static RoomProvider roomProvider;

  /**
   * adds the id to invitation.
   *
   * @param invite the invite to add.
   */
  public void addInvitation(@NotNull final Invite invite) {
    Rooms.INVITATIONS.put(invite.getId(), invite);
  }

  /**
   * gets all rooms.
   *
   * @return all rooms.
   */
  @NotNull
  public Collection<Room> all() {
    return Collections.unmodifiableSet(Rooms.ROOMS_SET);
  }

  /**
   * deletes the room from cache.
   *
   * @param room the room to delete.
   *
   * @return completable future.
   */
  @NotNull
  public CompletableFuture<Void> delete(@NotNull final Room room) {
    Rooms.ROOMS_SET.remove(room);
    Rooms.ROOMS.remove(room.getUniqueId());
    Rooms.removeCache(room);
    return CompletableFuture.completedFuture(null);
  }

  /**
   * gets room of the player.
   *
   * @param uniqueId the unique id to get.
   *
   * @return room of the player.
   */
  @NotNull
  public Optional<Room> getByOwner(@NotNull final UUID uniqueId) {
    final var cache = Rooms.ROOM_CACHE_BY_OWNER.get(uniqueId);
    if (cache != null) {
      return Optional.of(cache);
    }
    for (final var room : Rooms.ROOMS_SET) {
      final var roomOwner = room.getOwner();
      if (roomOwner.equals(uniqueId)) {
        Rooms.addCache(uniqueId, room);
        return Optional.of(room);
      }
    }
    return Optional.empty();
  }

  /**
   * obtains the invited player.
   *
   * @param id the id to get.
   *
   * @return invited player's unique id.
   */
  @NotNull
  public Optional<Invite> getInvitation(@NotNull final String id) {
    return Optional.ofNullable(Rooms.INVITATIONS.get(id));
  }

  /**
   * gets room via unique id.
   *
   * @param uuid the unique id to get.
   *
   * @return completable future for room.
   */
  @NotNull
  public CompletableFuture<@Nullable Room> getOrCreate(@NotNull final UUID uuid) {
    if (Rooms.ROOMS.containsKey(uuid)) {
      return CompletableFuture.completedFuture(Rooms.ROOMS.get(uuid));
    }
    return Rooms.provideRoom(uuid).whenComplete((room, throwable) -> {
      if (throwable != null) {
        throwable.printStackTrace();
      }
      if (room != null) {
        Rooms.ROOMS.put(uuid, room);
        Rooms.ROOMS_SET.add(room);
        Rooms.addCache(uuid, room);
      }
    });
  }

  /**
   * checks if there is room owner of player uuid.
   *
   * @param uuid player uuid the uuid to check.
   *
   * @return {@code true} if there is a room owner of player uuid.
   */
  public boolean hasRoom(UUID uuid) {
    if (Rooms.ROOM_CACHE_BY_OWNER.containsKey(uuid)) {
      return true;
    }
    for (Room room : Rooms.ROOMS_SET) {
      if (room.getOwner().equals(uuid)) {
        Rooms.addCache(uuid, room);
      }
      return true;
    }
    return false;
  }

  /**
   * provides room from {@link #roomProvider}.
   *
   * @param uniqueId the unique id to get.
   *
   * @return room.
   */
  @NotNull
  public static CompletableFuture<@Nullable Room> provideRoom(@NotNull final UUID uniqueId) {
    return CompletableFuture.supplyAsync(() -> Rooms.getRoomProvider().apply(uniqueId));
  }

  /**
   * removes the invitation.
   *
   * @param id the id to remove.
   */
  public void removeInvitation(@NotNull final String id) {
    Rooms.INVITATIONS.remove(id);
  }

  /**
   * sets the room provider if it's not set yet.
   *
   * @param roomProvider the provider to set.
   */
  public void setRoomProvider(@NotNull final RoomProvider roomProvider) {
    if (Rooms.roomProvider == null) {
      Rooms.roomProvider = roomProvider;
    }
  }

  /**
   * adds owner and room to {@link #ROOM_CACHE_BY_OWNER}.
   *
   * @param owner the owner to add.
   * @param room the room to add.
   */
  private void addCache(@NotNull final UUID owner, @NotNull final Room room) {
    Rooms.ROOM_CACHE_BY_OWNER.put(owner, room);
  }

  @NotNull
  private static RoomProvider getRoomProvider() {
    return Objects.requireNonNull(Rooms.roomProvider, "room provider");
  }

  /**
   * removes the cache.
   *
   * @param room the room to remove.
   */
  private void removeCache(@NotNull final Room room) {
    Rooms.ROOM_CACHE_BY_OWNER.entrySet().removeIf(entry -> room.getOwner().equals(entry.getKey()));
  }
}
