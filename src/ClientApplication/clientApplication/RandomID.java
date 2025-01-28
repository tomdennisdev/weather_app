/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientApplication;

import GUI_windows.MainMenu;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author thomasdennis
 */
public class RandomID {
    
    
    public static Map<String, Object> jsonToMap (String str) {
        Map<String, Object> map = new Gson().fromJson (
        str, new TypeToken<HashMap<String, Object>> () {}.getType ()
        );
    return map;

    }
    
    public String getValidRandomID(){
        
        String request = "{\"jsonrpc\":\"2.0\",\"method\":\"generateUUIDs\",\"params\":{\"apiKey\":\"7d6ef362-729b-4a8c-b70a-76c78d4a005c\",\"n\":1},\"id\":24158}";
        PostRequestClient newPostRequest = new PostRequestClient("randomID",request);
        String userIdJSON = newPostRequest.sendPostRequest();
        
        Map<String, Object> jsonMap = jsonToMap (userIdJSON);
        Map<String, Object> resultMap = (Map<String, Object>)jsonMap.get("result");        
        Map<String, Object> randomMap = (Map<String, Object>)resultMap.get("random");             
        ArrayList<String> dataList = (ArrayList<String>)randomMap.get("data");

        return dataList.get(0).toString();
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        
        
        
    }
    
}
