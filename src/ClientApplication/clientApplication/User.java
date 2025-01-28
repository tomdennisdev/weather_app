/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientApplication;

import com.google.gson.Gson;

/**
 *
 * @author thomasdennis
 */
public class User {
    
    private String userId;
    
    public User (String userId){
        
        this.userId = userId;
        sendToServer();
    }
    
    private void sendToServer(){
        
        Gson gson = new Gson();
            
        String json = gson.toJson(this);
        
        PostRequestClient newPostRequest = new PostRequestClient("user",json);
        String userIdJSON = newPostRequest.sendPostRequest();

    }
    
}
