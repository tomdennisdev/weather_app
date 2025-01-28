/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package services;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import external.ForecastService;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author thomasdennis
 */
@Path("forecast")
public class ForecastResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ForecastResource
     */
    public ForecastResource() {
    }

    /**
     * Retrieves representation of an instance of services.ForecastResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("location") String location) {
        
        try{
            ForecastService newForecast = new ForecastService();
            
            return newForecast.getForecastJSON(location);
            
                  
        }
        catch (Exception ex){
            return "there was an error";
        }

    }

    /**
     * PUT method for updating or creating an instance of ForecastResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
