/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package services;

import external.FileHandling;
import external.Trip;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author thomasdennis
 */
@Path("interest")
public class InterestResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("parameterJson") String parameterJson) {
        
        System.out.println("location string from inside resource: " + parameterJson);

        FileHandling fileHandler = new FileHandling();
        String data = fileHandler.ReadFromFile("trip.txt");
                        
        Trip trip = new Trip();
        
        return trip.getInterestedUsers(data, parameterJson);

    }


}