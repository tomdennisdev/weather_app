/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package external;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author thomasdennis
 */
public class RandomIDService {
    
    private String body;
    
    public RandomIDService (String body){
        this.body = body;
    }
    
    public String getIDJSON (){
        
        String response = "";
        
        try{
            URL url = new URL("https://api.random.org/json-rpc/2/invoke");

            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");

            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            dos.writeBytes(body);

            BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = bf.readLine()) != null) {
                response += line + "\r\n";
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
        
        return response;

    }
    
    public static void main (String args[]){
        
    }
    
    
    
}
