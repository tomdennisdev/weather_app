/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package external;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author thomasdennis
 */
public class FileHandling {


    public void WriteToFile(String filename, String newItem){
        
        try {
          FileWriter myWriter = new FileWriter(filename);
          myWriter.write(newItem);
          myWriter.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
        
    }
    
    public String ReadFromFile(String filename){   
        
        String text = "";
        try {
          File myObj = new File(filename);
          Scanner myReader = new Scanner(myObj);         
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            text += data + "\n";
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        return text;
    }
    
    
        
    
    
}
