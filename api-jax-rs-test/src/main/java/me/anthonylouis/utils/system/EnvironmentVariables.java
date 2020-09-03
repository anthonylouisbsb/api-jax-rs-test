package me.anthonylouis.utils.system;

import javax.validation.constraints.NotNull;

/**
 * Responsible to retrieve all program necessary environment variables
 */
public abstract class EnvironmentVariables {

  public static String getEnvironmentVariable(@NotNull final String environmentVariable) {
    return System.getenv(environmentVariable);
  }
}
