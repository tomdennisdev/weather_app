/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientApplication;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
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
    
    public void InitialiseTrip(String tripId, String userId, String location, String date, String weather, ArrayList<String> interestedUsers){
        
        this.tripId = tripId;
        this.userId = userId;
        this.location = location;
        this.date = date;
        this.weather = weather;   
        this.interestedUsers = interestedUsers;
        
    }
    
    public void sendTripToServer(String tripId, String userId, String location, String date, String weather, ArrayList<String> interestedUsers){
        
        InitialiseTrip(tripId, userId, location, date, weather, interestedUsers);
        
        Gson gson = new Gson();
            
        String json = gson.toJson(this);
        
        PostRequestClient newPostRequest = new PostRequestClient("trip",json);
        String userIdJSON = newPostRequest.sendPostRequest();
        
    }
    
    public ArrayList<Trip> getTripsFromServer(String encodedJson){
        
        GetRequestClient newGetRequest = new GetRequestClient("trip?location=", encodedJson);

        String tripListJson = newGetRequest.sendGetRequest();
        
        ArrayList<Trip> tripList = new ArrayList<Trip>();
        
        Map<String, Object> jsonMap = jsonToMap (tripListJson);
        
        ArrayList<Map<String, Object>> allTriplist = (ArrayList<Map<String, Object>>)jsonMap.get("tripList");
        
        for (Map<String, Object> trip : allTriplist){

            Trip tripObject = new Trip();

            tripObject.tripId = (String) trip.get("tripId");
            
            System.out.println("trip id = " + trip.get("tripId"));
            
            tripObject.userId = (String) trip.get("userId");
            tripObject.location = (String) trip.get("location");
            tripObject.date = (String) trip.get("date");
            tripObject.weather = (String) trip.get("weather");
            
            tripObject.interestedUsers =  (ArrayList<String>) trip.get("interestedUsers");

            tripList.add(tripObject);                      
        }
        
        return tripList;
        
    }
    public static Map<String, Object> jsonToMap (String str) {
        Map<String, Object> map = new Gson().fromJson (
        str, new TypeToken<HashMap<String, Object>> () {}.getType ()
        );
    return map;

    }    
    
}
