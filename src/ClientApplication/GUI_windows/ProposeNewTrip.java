/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_windows;

import clientApplication.Trip;
import clientApplication.RandomID;
import clientApplication.Weather;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author thomasdennis
 */
public class ProposeNewTrip extends javax.swing.JFrame {
    
    private String userId;

    /**
     * Creates new form ProposeNewTrip
     */
    public ProposeNewTrip(String userId) {
        this.userId = userId;
        this.setVisible(true);
        initComponents();
        userIdLabel.setText("user id = " + userId);
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        weatherInfoButton = new javax.swing.JButton();
        locationTextField = new javax.swing.JTextField();
        proposeNewTripLabel = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        submitTripButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        dateChooser = new com.toedter.calendar.JDateChooser();
        userIdLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        weatherInfoButton.setText("Search weather info");
        weatherInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weatherInfoButtonActionPerformed(evt);
            }
        });

        locationTextField.setText("London");
        locationTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationTextFieldActionPerformed(evt);
            }
        });

        proposeNewTripLabel.setText("Propose new trip");

        locationLabel.setText("Location:");

        dateLabel.setText("Date:");

        submitTripButton.setText("Submit trip proposal");
        submitTripButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitTripButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        userIdLabel.setText("user id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(locationLabel)
                        .addGap(18, 18, 18)
                        .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(submitTripButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateLabel)
                        .addGap(18, 18, 18)
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(weatherInfoButton)))
                .addGap(74, 74, 74))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(closeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(proposeNewTripLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(userIdLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(userIdLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(weatherInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(proposeNewTripLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationLabel)
                    .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateLabel)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(submitTripButton)
                .addGap(36, 36, 36)
                .addComponent(closeButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void weatherInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weatherInfoButtonActionPerformed
        
        SelectLocation selectLocation = new SelectLocation(userId);
        
        selectLocation.showWindow();
        
        
    }//GEN-LAST:event_weatherInfoButtonActionPerformed

    private void locationTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locationTextFieldActionPerformed

    private boolean isValidDate(String pDateString) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(pDateString);
        return new Date().before(date);
    }
    
    private String parseDate(String dateFromChooser){
        
        LocalDateTime datetime = LocalDateTime.parse(dateFromChooser, DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss z yyyy"));
        return datetime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    private boolean isValidDate(){
        
        try {
            String dateString = parseDate(dateChooser.getDate().toString());

            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
            if (new Date().before(date)){
                return true;

            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), "Invalid date. Please choose a date which is after today.", "Dialog",JOptionPane.ERROR_MESSAGE);
                return false;
            }
            //System.out.println("is valid date = " + isValidDate(dateChooser.getDate().toString()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Please choose a date.", "Dialog",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }
    
    private void postTripJSON(String json){

        try{

            URL url = new URL ("http://localhost:8080/RESTService02/webresources/trip?json=" + json);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty ("Content-Type", "application/json;charset=utf-g");
            connection. setRequestMethod("POST");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        }
        catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(new JFrame(), "Connection refused. Please make sure you are running TomCat", "Dialog",JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    private void addObject(String json) throws MalformedURLException, IOException{
        String body = json;
        URL url = new URL("http://localhost:8080/RESTService02/webresources/trip");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
            dos.writeBytes(body);
            System.out.println("dos = " + dos);
        }

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
        }                
    }
        

    
    private void submitTripButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitTripButtonActionPerformed
        
        String location = locationTextField.getText().replace(' ', '+');
        
        Weather weather = new Weather(location);
        String weatherJSON = weather.getValidJSON();
        
        if (weatherJSON != null && isValidDate()){

            RandomID newIdObject = new RandomID();

            String tripId = newIdObject.getValidRandomID();
            String date = parseDate(dateChooser.getDate().toString());
            
            Trip newTrip = new Trip();
            
            newTrip.sendTripToServer(tripId,userId, location, date, weatherJSON, new ArrayList<String>());
            
            dispose();
            
        }
        
        
    }//GEN-LAST:event_submitTripButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void showWindow() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelectLocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectLocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectLocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectLocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ProposeNewTrip().setVisible(true);
            }
        });
    }
    
    public static void main(String args[]) {
        
        //showWindow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel dateLabel;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JTextField locationTextField;
    private javax.swing.JLabel proposeNewTripLabel;
    private javax.swing.JButton submitTripButton;
    private javax.swing.JLabel userIdLabel;
    private javax.swing.JButton weatherInfoButton;
    // End of variables declaration//GEN-END:variables
}
