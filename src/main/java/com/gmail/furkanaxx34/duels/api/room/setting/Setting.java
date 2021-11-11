package com.gmail.furkanaxx34.duels.api.room.setting;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

public interface Setting {

  /**
   * registers the permission.
   *
   * @param setting the permission to register.
   */
  static void register(@NotNull final Setting setting) {
    Settings.register(setting);
  }

  /**
   * obtains the description.
   *
   * @return description.
   */
  @NotNull
  List<String> getDescription();

  /**
   * obtains the id.
   *
   * @return id.
   */
  @NotNull
  String getId();

  /**
   * obtains the name.
   *
   * @return name.
   */
  @NotNull
  String getName();

  default void setValue(int i) {}

  default int getValue() {
    return 0;
  }

  /**
   * registers the permission.
   */
  default void register() {
    Setting.register(this);
  }

  /**
   * an enum class that contains status of a setting.
   */
  @Getter
  @RequiredArgsConstructor(access = AccessLevel.PACKAGE)
  enum Status {
    /**
     * the enabled.
     */
    ENABLED("on"),
    /**
     * the disabled.
     */
    DISABLED("off");

    /**
     * the values.
     */
    private static final Status[] VALUES = Status.values();

    /**
     * the id.
     */
    @NotNull
    private final String id;

    /**
     * gets status by id, unless {@link #ENABLED}.
     *
     * @param id the id to get.
     *
     * @return status.
     */
    @NotNull
    public static Status getById(@NotNull final String id) {
      for (final var status : Status.VALUES) {
        if (status.getId().equalsIgnoreCase(id)) {
          return status;
        }
      }
      return Status.ENABLED;
    }
  }
}
