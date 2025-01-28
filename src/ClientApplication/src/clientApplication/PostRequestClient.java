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
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PostRequestClient {
    
    private String serviceToPostTo;
    private String request;
    
    public PostRequestClient (String serviceToPostTo, String request){
        this.serviceToPostTo = serviceToPostTo;
        this.request = request;
        
    }
    
    public String sendPostRequest(){
        
        
        try {
            String serverUrl = ("http://localhost:8080/RESTService02/webresources/" + serviceToPostTo);

            return makeConnection(serverUrl, request);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "An error occurred: " + e.getMessage(), "Dialog",JOptionPane.ERROR_MESSAGE);
            return e.toString();
        }
    }

    private String makeConnection(String url, String postData){
        
        try{
            URL serverUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) serverUrl.openConnection();

            connection.setRequestMethod("POST");

            connection.setDoOutput(true);

            connection.setRequestProperty("Content-Type", "application/json");

            OutputStream outputStream = connection.getOutputStream();
            byte[] dataBytes = postData.getBytes(StandardCharsets.UTF_8);
            outputStream.write(dataBytes);

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                String serverResponse = readResponse(connection);
                connection.disconnect();
                return serverResponse;
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "An error occurred. Response code:" + responseCode, "Dialog",JOptionPane.ERROR_MESSAGE);
                connection.disconnect();
                return "An error occurred. Response code:" + responseCode;
            }            
        }
        catch (Exception e){
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

