package me.anthonylouis.utils.exceptions;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

import javax.ws.rs.WebApplicationException;

/**
 * Exception thrown when is passed a parameter that is not allowed or has an invalid format inside a
 * resource
 */
public class WrongMetadataException extends WebApplicationException {

  public WrongMetadataException(final Throwable cause, final String message) {
    super(message, cause, BAD_REQUEST);
  }
}
