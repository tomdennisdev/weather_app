/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package services;

import external.FileHandling;
import external.UserListServer;
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
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author thomasdennis
 */
@Path("user")
public class UserResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        FileHandling fileHandler = new FileHandling();
        String data = fileHandler.ReadFromFile("user.txt");
        
        if (data.equals("")){
            fileHandler.WriteToFile("user.txt", "{\"userList\":[]}");
            data = fileHandler.ReadFromFile("user.txt");
        } 

        return data;
    }

    @POST
    @Consumes("application/json")
    public String handlePostRequest(InputStream requestBody) {
        String postData = readRequestBody(requestBody);
        
        FileHandling fileHandler = new FileHandling();
        String dataFromFile = fileHandler.ReadFromFile("user.txt");
        
        if (dataFromFile.equals("")){
            fileHandler.WriteToFile("user.txt", "{\"userList\":[]}");
            dataFromFile = fileHandler.ReadFromFile("user.txt");
        } 
        
        UserListServer userListServer = new UserListServer(dataFromFile);
        String newJson = userListServer.addUserToJSON(postData);
    
        fileHandler.WriteToFile("user.txt", newJson);

        return "POST request received successfully!";
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
