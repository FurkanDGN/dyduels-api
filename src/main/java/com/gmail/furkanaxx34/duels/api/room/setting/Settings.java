package com.gmail.furkanaxx34.duels.api.room.setting;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

/**
 * a class that contains default settings for rooms.
 */
@UtilityClass
public class Settings {

  /**
   * the actions.
   */
  private final Map<String, Setting> SETTINGS = new ConcurrentHashMap<>();

  /**
   * obtains all registered settings.
   *
   * @return all registered settings
   */
  @NotNull
  public Collection<Setting> all() {
    return Settings.SETTINGS.values();
  }

  /**
   * gets the setting by id.
   *
   * @param id the id to get.
   *
   * @return setting.
   */
  @NotNull
  public Optional<Setting> get(@NotNull final String id) {
    return Optional.ofNullable(Settings.SETTINGS.get(id));
  }

  /**
   * obtains settings.
   *
   * @return setting.
   */
  @NotNull
  public Collection<Setting> getSettings() {
    return Collections.unmodifiableCollection(Settings.SETTINGS.values());
  }

  /**
   * registers the settings.
   *
   * @param setting the setting to register.
   */
  void register(@NotNull final Setting setting) {
    Settings.SETTINGS.put(setting.getId(), setting);
  }
}
