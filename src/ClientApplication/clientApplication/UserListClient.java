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
public class UserListClient {
    
    private String jsonFromRequest;
    
    public UserListClient(String jsonFromRequest){
        this.jsonFromRequest = jsonFromRequest;
    }
  
    public boolean isUserPresent(String userJson, String userId){

        Map<String, Object> respMap = jsonToMap (jsonFromRequest);
        
        if (respMap != null){
            ArrayList<Map<String, Object>> allUsers = (ArrayList<Map<String, Object>>)respMap.get("userList");

            for (Map<String, Object> user : allUsers){
                String id = (String) user.get("userId");

                if (id.equals(userId)){
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    public static Map<String, Object> jsonToMap (String str) {
        Map<String, Object> map = new Gson().fromJson (
        str, new TypeToken<HashMap<String, Object>> () {}.getType ()
        );
    return map;

    }
    
}
