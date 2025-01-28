/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package external;

import com.google.gson.Gson;
import static external.TripListServer.jsonToMap;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author thomasdennis
 */
public class Trip {
    
    
    public String tripId;
    public String userId;
    public String location;
    public String date;
    public String weather;
    public ArrayList<String> interestedUsers;
    
    public String getInterestedUsers(String jsonFromFile, String idParamJson){
        
        Map<String, Object> idMap = jsonToMap (idParamJson);        
        String queriedTripId = (String) idMap.get("tripId");
        
        Map<String, Object> jsonMap = jsonToMap (jsonFromFile);        
        ArrayList<Map<String, Object>> allTripList = (ArrayList<Map<String, Object>>)jsonMap.get("tripList");
                
        for (Map<String, Object> eachTrip : allTripList){

            String id = (String) eachTrip.get("tripId");

            if (id.equals(queriedTripId)){
                interestedUsers = (ArrayList<String>) eachTrip.get("interestedUsers");
                
                Gson gson = new Gson();

                String json = gson.toJson(interestedUsers);

                Map<String, Object> interestedUsersMap = Map.of("interestedUsers", json);
                
                return interestedUsersMap.toString();
                
            }    
        }
        return null;
    }
    
    public String getTripsFromServer(String jsonFromFile, String locationParamJson){
        
        Map<String, Object> locationMap = jsonToMap (locationParamJson);        
        String queriedLocation = (String) locationMap.get("location");
        
        Map<String, Object> jsonMap = jsonToMap (jsonFromFile);        
        ArrayList<Map<String, Object>> allTripList = (ArrayList<Map<String, Object>>)jsonMap.get("tripList");
        
        ArrayList<Trip> queriedTripList = new ArrayList<Trip>();
        
        for (Map<String, Object> eachTrip : allTripList){


            String tripLocation = (String) eachTrip.get("location");

            if (tripLocation.equals(queriedLocation) || queriedLocation.equals("all")){
                Trip trip = new Trip();
                trip.tripId = (String) eachTrip.get("tripId");
                trip.userId = (String) eachTrip.get("userId");
                trip.location = (String) eachTrip.get("location");
                trip.date = (String) eachTrip.get("date");
                trip.weather = (String) eachTrip.get("weather");
                trip.interestedUsers = (ArrayList<String>) eachTrip.get("interestedUsers");

                queriedTripList.add(trip); 
            }
            
            
                     
        }
        
        Gson gson = new Gson();
            
        String json = gson.toJson(queriedTripList);
        
        Map<String, Object> tripListMap = Map.of("tripList", json);
        
        return tripListMap.toString();
        
    }    
}
