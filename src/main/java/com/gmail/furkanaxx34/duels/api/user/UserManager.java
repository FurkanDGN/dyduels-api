package com.gmail.furkanaxx34.duels.api.user;

import com.gmail.furkanaxx34.duels.api.util.Loadable;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Represents the UserManager singleton used by Duels.
 */
public interface UserManager extends Loadable {


    /**
     * Whether or not had all users completed loading to the memory.
     *
     * @return True if all users have completed loading to the memory. False otherwise.
     */
    boolean isLoaded();


    /**
     * Gets a {@link User} with the given name.
     * Note: If {@link #isLoaded()} returns false, this may return null even if userdata file exists.
     *
     * @param name Name of the user to get.
     * @return {@link User} with the given name or null if not exists.
     */
    @Nullable
    User get(@NotNull final String name);


    /**
     * Gets a {@link User} with the given {@link UUID}.
     * Note: If {@link #isLoaded()} returns false, this may return null even if userdata file exists.
     *
     * @param uuid {@link UUID} of the user to get.
     * @return {@link User} with the given {@link UUID} or null if not exists.
     */
    @Nullable
    User get(@NotNull final UUID uuid);


    /**
     * Calls {@link #get(UUID)} with {@link Player#getUniqueId()}.
     *
     * @see #get(UUID)
     */
    @Nullable
    User get(@NotNull final Player player);
}