/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientApplication;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author thomasdennis
 */

public class PutRequestClient {
    
    private String serviceToSendTo;
    private String request;
    
    public PutRequestClient (String serviceToSendTo, String request){
        this.serviceToSendTo = serviceToSendTo;
        this.request = request;
        
    }

    public void sendPutRequest() {
        try {
            String serverUrl = "http://localhost:8080/RESTService02/webresources/" + serviceToSendTo;

            makeConnection(serverUrl, request);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "An error occurred: " + e.getMessage(), "Dialog",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void makeConnection(String url, String putData){
        
        try{
            URL serverUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) serverUrl.openConnection();

            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            OutputStream outputStream = connection.getOutputStream();
                byte[] dataBytes = putData.getBytes(StandardCharsets.UTF_8);
                outputStream.write(dataBytes);

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                String serverResponse = readResponse(connection);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "An error occurred: " + responseCode, "Dialog",JOptionPane.ERROR_MESSAGE);
            }
            connection.disconnect();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(new JFrame(), "An error occurred: " + e.getMessage(), "Dialog",JOptionPane.ERROR_MESSAGE);
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

