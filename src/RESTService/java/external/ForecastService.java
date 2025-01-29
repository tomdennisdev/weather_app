/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package external;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thomasdennis
 */
public class ForecastService {
    
        
    public ForecastService(){
        
        
    }
    
    public static Map<String, Object> jsonToMap (String str) {
        Map<String, Object> map = new Gson().fromJson (
        str, new TypeToken<HashMap<String, Object>> () {}.getType ()
        );
    return map;

    }
    
    private final String path = "https://api.openweathermap.org/data/2.5/forecast?";

    private final String apiKey = System.getenv("WEATHER_API_KEY");

    if (apiKey == null || secretKey == null) {
        throw new IllegalStateException("API keys not set in environment variables");
    }

    private final String pathAfter = "&appid=" + apiKey + "&units=metric";
    
    public String getForecastJSON (String location){
        
        Map<String, Object> locationMap = jsonToMap(location);
        
        location = (String) locationMap.get("location");

        
        String response = "";
        try {
            String request = "q=" + location;
            URL url = new URL (path + request + pathAfter);           

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty ("Content-Type", "application/json;charset=utf-g");
            connection. setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line = in.readLine();

                while (line != null)
                {

                    response += line + "\r\n";
                    line = in.readLine();
                }


        } catch (IOException ex) {
            Logger.getLogger(ForecastService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }
    
    
    
    
    public static void main (String args[]){
        
        ForecastService newWeatherService = new ForecastService();
        
        String result = newWeatherService.getForecastJSON("London");
        
        System.out.println(result);
        
        
        Map<String, Object> respMap = jsonToMap (result);
        
        ArrayList<Map<String, Object>> allForecasts = (ArrayList<Map<String, Object>>)respMap.get("list");

        
        for (Map<String, Object> forecastMap : allForecasts){
            
            System.out.println ("\nTime/Date: " + forecastMap.get ("dt_txt"));
            
            Map<String, Object> mainMap = jsonToMap (forecastMap. get ("main") .toString () );
            System.out.println ("Temperature: " + mainMap.get ("temp"));
            
            
        }


    }
    
}
