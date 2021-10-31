package com.gmail.furkanaxx34.duels.api.kit;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a Kit loaded on the server.
 */
public interface Kit {

    /**
     * The name of this kit. Will not contain a dash character ("-").
     *
     * @return Never-null {@link String} that is the name of this kit.
     */
    @NotNull
    String getName();

    /**
     * Whether or not this kit requires a permission.
     * If usePermission is enabled, players must have the permission 'duels.kit.[name] (space in name replaced to dash)' to use the kit.
     *
     * @return True if usePermission is enabled for this kit. False otherwise.
     */
    boolean isUsePermission();


    /**
     * Enables or disables usePermission for this kit.
     *
     * @param usePermission True to enable usePermission. False otherwise.
     */
    void setUsePermission(final boolean usePermission);


    /**
     * Whether or not this kit has arenaSpecific enabled.
     * If arenaSpecific is enabled, only arenas with their name starting with this kit's name appended with an underscore will be available when playing with this kit.
     *
     * @return True if arenaSpecific is enabled. False otherwise.
     */
    boolean isArenaSpecific();


    /**
     * Enables or disables arenaSpecific for this kit.
     *
     * @param arenaSpecific True to enable arenaSpecific. False otherwise.
     */
    void setArenaSpecific(final boolean arenaSpecific);

    /**
     * Whether or not this kit has Characteristic property which specified.
     *
     * @param characteristic Characteristic enum to check.
     * @return True if it has the Characteristic property, False otherwise.
     */
    boolean hasCharacteristic(final Characteristic characteristic);

    /**
     * Toggles the Characteristic property which specified
     * @param characteristic Characteristic property to be toggled.
     */
    void toggleCharacteristic(final Characteristic characteristic);

    /**
     * Equips the {@link Player} with the contents of this kit.
     *
     * @param player {@link Player} to equip this kit.
     * @return True if {@link Player} has successfully equipped this kit. False otherwise.
     */
    boolean equip(@NotNull final Player player);

    enum Characteristic {
        SOUP,
        SUMO,
        UHC,
        COMBO;
    }
}
