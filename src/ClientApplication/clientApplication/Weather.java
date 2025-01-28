/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientApplication;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author thomasdennis
 */
public class Weather {
    private String location;
    
    public Weather (String location){
        
        this.location = location;
        
    } 
    
    public String encodeJsonString(String jsonString){
        
        try{
            String encodedJson = URLEncoder.encode(jsonString, StandardCharsets.UTF_8.toString());
            return encodedJson;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e, "Error",JOptionPane.ERROR_MESSAGE);
            return e.toString();
        }

    } 

    
    public String getValidJSON(){
        try{
            
            Gson json = new Gson();
            
            String locationJson = json.toJson(this);
            
            String encodedJson = encodeJsonString(locationJson.toString());

            URL url = new URL ("http://localhost:8080/RESTService02/webresources/forecast?location=" + encodedJson);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty ("Content-Type", "application/json;charset=utf-g");
            connection. setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String response = in.readLine();
           
            if (response == null){
                    JOptionPane.showMessageDialog(new JFrame(), "Location not recognised. Try again.", "Dialog",JOptionPane.ERROR_MESSAGE);
                    return null;
            }
            else{
                return response;
            }

        }
        catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(new JFrame(), "Connection refused. Please make sure you are running TomCat", "Dialog",JOptionPane.ERROR_MESSAGE);
            return null;
        }        
    }
    
}
