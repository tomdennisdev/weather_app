/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package external;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author thomasdennis
 */
public class TripListServer {
    
    private String jsonInFile;
    
    public TripListServer(String jsonInFile){
        this.jsonInFile = jsonInFile;
    }
    
    public String addUserToInterestedUsers(String requestJson){
        
        
        System.out.println("json already in file = " + jsonInFile);

        Map<String, Object> respMap = jsonToMap (jsonInFile);
        
        ArrayList<Map<String, Object>> allTrips = (ArrayList<Map<String, Object>>)respMap.get("tripList");
        

        
        Map<String, Object> mapToBeAdded = jsonToMap (requestJson);
        
        String userId = (String) mapToBeAdded.get("userId");
        String tripId = (String) mapToBeAdded.get("tripId");
        
        System.out.println("inserted user id = " + userId);
        System.out.println("inserted trip id = " + tripId);
        
        boolean alreadyInList = false;
        
        int tripCounter = 0;
        for (Map<String, Object> trip : allTrips){
            
            if (trip.get("tripId").equals(tripId)){
                
                ArrayList<String> interestedUsers = (ArrayList<String>) trip.get("interestedUsers");
                /*
                for (String user : interestedUsers){
                    if (userId.equals(user)){
                    }
                }
                */
                
                interestedUsers.add(userId);
                
                trip.put("interestedUsers", interestedUsers);
                
                allTrips.set(tripCounter, trip);
                
            }
            tripCounter += 1;
            
        }
            
        
        TripList newTripList = new TripList(allTrips);
        
        Gson gson = new Gson();
            
        String json = gson.toJson(newTripList);
        
        //System.out.println("new json: " + json);
        
        return json;
        
        
    }
  
    public String addTripToJSON(String tripJson){

        Map<String, Object> respMap = jsonToMap (jsonInFile);
        
        ArrayList<Map<String, Object>> allTrips = (ArrayList<Map<String, Object>>)respMap.get("tripList");
        

        
        Map<String, Object> mapToBeAdded = jsonToMap (tripJson);
        
        boolean alreadyInList = false;
        
        int tripCounter = 0;
        for (Map<String, Object> trip : allTrips){
            
            if (trip.get("tripId").equals(mapToBeAdded.get("tripId"))){
                alreadyInList = true;
                allTrips.set(tripCounter, mapToBeAdded);
                
            }
            tripCounter += 1;
            
        }
            
        
        if (alreadyInList == false){
            allTrips.add(mapToBeAdded);
        }  
        
        
        TripList newTripList = new TripList(allTrips);
        
        Gson gson = new Gson();
            
        String json = gson.toJson(newTripList);
        
        return json;
        
    }
    
    public static Map<String, Object> jsonToMap (String str) {
        Map<String, Object> map = new Gson().fromJson (
        str, new TypeToken<HashMap<String, Object>> () {}.getType ()
        );
    return map;

    }
    
}
