/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package services;

import external.FileHandling;
import external.Trip;
import external.TripListServer;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author thomasdennis
 */
@Path("trip")
public class TripResource {
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("location") String location) {
        
        System.out.println("location string from inside resource: " + location);
        
        Trip trip = new Trip();

        
        FileHandling fileHandler = new FileHandling();
        String data = fileHandler.ReadFromFile("trip.txt");
        
        if (data.equals("")){
            fileHandler.WriteToFile("trip.txt", "{\"tripList\":[]}");
            data = fileHandler.ReadFromFile("trip.txt");
        } 
                
        return trip.getTripsFromServer(data, location);

    }
    
    @POST
    @Consumes("application/json")
    public String handlePostRequest(InputStream requestBody) {
        String postData = readRequestBody(requestBody);
        
        FileHandling fileHandler = new FileHandling();
        String dataFromFile = fileHandler.ReadFromFile("trip.txt");
        
        if (dataFromFile.equals("")){
            fileHandler.WriteToFile("trip.txt", "{\"tripList\":[]}");
            dataFromFile = fileHandler.ReadFromFile("trip.txt");
        }
        
        TripListServer tripListServer = new TripListServer(dataFromFile);
        String newJson = tripListServer.addTripToJSON(postData);
    
        fileHandler.WriteToFile("trip.txt", newJson);

        return "POST request received successfully!";
    }
    
    @PUT
    @Consumes("application/json")
    public String handlePutRequest(InputStream putData) {
        String jsonData = readRequestBody(putData);

        FileHandling fileHandler = new FileHandling();
        String dataFromFile = fileHandler.ReadFromFile("trip.txt");
        
        TripListServer tripListServer = new TripListServer(dataFromFile);
        String newJson = tripListServer.addUserToInterestedUsers(jsonData);
    
        fileHandler.WriteToFile("trip.txt", newJson);

        return "PUT request received successfully!";
    }

    private String readRequestBody(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder requestBody = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
            return requestBody.toString();
        } catch (Exception e) {
            return null;
        }
    }
}