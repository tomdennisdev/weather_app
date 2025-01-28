/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientApplication;

/**
 *
 * @author thomasdennis
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GetRequestClient {
    
    private String serviceToGetFrom;
    private String parameters;
    
    public GetRequestClient (String serviceToGetFrom, String parameters){
        this.serviceToGetFrom = serviceToGetFrom;
        this.parameters = parameters;
        
    }
   

    public String sendGetRequest() {
        try {
            String serverUrl = "http://localhost:8080/RESTService02/webresources/" + serviceToGetFrom + parameters;

            return makeConnection(serverUrl);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "An error occurred: " + e.getMessage(), "Dialog",JOptionPane.ERROR_MESSAGE);
            return e.toString();
        }
    }

    private String makeConnection(String url){
        
        try{
            URL serverURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) serverURL.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                String responseFromServer = readResponse(connection);
                connection.disconnect();
                return responseFromServer;
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "An error occured. Response code: " + responseCode, "Dialog",JOptionPane.ERROR_MESSAGE);
                connection.disconnect();
                return "error";
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(new JFrame(), "An error occurred: " + e.getMessage(), "Dialog",JOptionPane.ERROR_MESSAGE);
            return e.getMessage();
        }
    }

    private String readResponse(HttpURLConnection connection){        

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            return response.toString();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(new JFrame(), "An error occurred: " + e.getMessage(), "Dialog",JOptionPane.ERROR_MESSAGE);
            return e.getMessage();
        }
    }
}
