package com.gmail.furkanaxx34.duels.api.room.setting;

import java.util.Map;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

public interface Settable {

  /**
   * adds the setting.
   *
   * @param id the id to add.
   */
  default void addSetting(@NotNull final String id) {
    Settings.get(id).ifPresent(this::addSetting);
  }

  /**
   * adds the setting.
   *
   * @param setting the setting to add.
   */
  default void addSetting(@NotNull final Setting setting) {
    this.addSetting(setting, Setting.Status.ENABLED);
  }

  /**
   * adds the setting.
   *
   * @param setting the setting to add.
   * @param status the status to add.
   */
  void addSetting(@NotNull Setting setting, @NotNull Setting.Status status);

  /**
   * gets the status of the setting.
   *
   * @param setting the setting to get.
   *
   * @return status of the setting.
   */
  @NotNull
  default Optional<Setting.Status> getSetting(@NotNull final Setting setting) {
    return Optional.ofNullable(this.getSettings().get(setting));
  }

  /**
   * obtains settings.
   *
   * @return settings.
   */
  @NotNull
  Map<Setting, Setting.Status> getSettings();

  /**
   * removes the setting.
   *
   * @param id the id to remove.
   */
  default void removeSetting(@NotNull final String id) {
    Settings.get(id).ifPresent(this::removeSetting);
  }

  /**
   * removes the setting.
   *
   * @param setting the setting to remove.
   */
  void removeSetting(@NotNull Setting setting);
}
