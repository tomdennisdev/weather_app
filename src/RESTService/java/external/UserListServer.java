/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package external;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author thomasdennis
 */
public class UserListServer {
    
    private String jsonInFile;
    
    public UserListServer(String jsonInFile){
        this.jsonInFile = jsonInFile;
    }
  
    public String addUserToJSON(String userJson){
        

        Map<String, Object> respMap = jsonToMap (jsonInFile);

        ArrayList<Map<String, Object>> allUsers = (ArrayList<Map<String, Object>>)respMap.get("userList");
        
        Map<String, Object> mapToBeAdded = jsonToMap (userJson);
        
        allUsers.add(mapToBeAdded);
        
        UserList newUserList = new UserList(allUsers);
        
        Gson gson = new Gson();
            
        String json = gson.toJson(newUserList);
        
        return json;
        
    }
    
    public static Map<String, Object> jsonToMap (String str) {
        Map<String, Object> map = new Gson().fromJson (
        str, new TypeToken<HashMap<String, Object>> () {}.getType ()
        );
    return map;

    }
    
}
