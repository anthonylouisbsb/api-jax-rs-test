package me.anthonylouis.server.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.ok;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import me.anthonylouis.server.dao.DaoManager;
import me.anthonylouis.server.entity.Country;
import me.anthonylouis.utils.json.JsonUtils;

@Path("countries")
public class CountryResource {

  @Path("{countryId}")
  @GET
  @Produces(APPLICATION_JSON)
  public Response getCountry(@PathParam("countryId") final int countryId) {
    final var countryDao = DaoManager.INSTANCE.getCountryDao();

    final var countryById = countryDao.getCountryById(countryId);

    final var countryAsJson = countryById
        .map(Country::toJson)
        .orElse("");

    return ok(countryAsJson, APPLICATION_JSON).build();
  }

  @GET
  @Produces(APPLICATION_JSON)
  public Response getCountries() throws JsonProcessingException {
    final var countryDao = DaoManager.INSTANCE.getCountryDao();

    final List<Country> listOfCountries = countryDao.getListOfCountries();

    final String listOfCountriesAsJson = JsonUtils.INSTANCE
        .writeObjectAsJsonString(listOfCountries);

    return ok(listOfCountriesAsJson, APPLICATION_JSON).build();
  }
}
