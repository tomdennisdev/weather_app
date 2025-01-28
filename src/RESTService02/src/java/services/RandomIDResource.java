/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package services;

import external.RandomIDService;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
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



//@Path("randomID")
//public class RandomIDResource {
//
//    @Context
//    private UriInfo context;
//
//    /**
//     * Creates a new instance of RandomIDResource
//     */
//    public RandomIDResource() {
//    }
//
//    /**
//     * Retrieves representation of an instance of services.RandomIDResource
//     * @return an instance of java.lang.String
//     */
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getJson() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
//    
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public String postJson() {
//        try{
//            RandomIDService newRandomID = new RandomIDService();            
//            return newRandomID.getIDJSON();
//                              
//        }
//        catch (Exception ex){
//            return "there was an error";
//        }
//
//    }    
//
//    /**
//     * PUT method for updating or creating an instance of RandomIDResource
//     * @param content representation for the resource
//     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }
//}
//


@Path("randomID")
public class RandomIDResource {

    @POST
    @Consumes("application/json")
    public String handlePostRequest(InputStream requestBody) {
        String postData = readRequestBody(requestBody);
        System.out.println("Received POST request with data: " + postData);
        
        try{
            RandomIDService newRandomID = new RandomIDService(postData);            
            return newRandomID.getIDJSON();
                              
        }
        catch (Exception ex){
            return "there was an error";
        }
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
            e.printStackTrace();
            return null;
        }
    }
}
