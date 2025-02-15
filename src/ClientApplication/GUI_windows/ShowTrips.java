/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_windows;

import static GUI_windows.ShowWeather.jsonToMap;
import clientApplication.GetRequestClient;
import clientApplication.PutRequestClient;
import clientApplication.Trip;
import clientApplication.Weather;
import com.google.gson.Gson;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.ComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author thomasdennis
 */
public class ShowTrips extends javax.swing.JFrame {

    /**
     * Creates new form ShowTrips
     */
    private ArrayList<Trip> allTripList;
    private ArrayList<Trip> queriedTripList = new ArrayList<Trip>();
    private int currentTripIndex = 0;
    private int noOfTrips;
    private String currentLocation;
    String userId;
    boolean showMyTrips;
    
    private String encodeJsonString(String jsonString){
        
        try{
            String encodedJson = URLEncoder.encode(jsonString, StandardCharsets.UTF_8.toString());
            return encodedJson;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e, "Error",JOptionPane.ERROR_MESSAGE);
            return e.toString();
        }

    }  
    
    public ShowTrips(String queriedLocation, String userId, boolean showMyTrips) {
        this.userId = userId;
        this.showMyTrips = showMyTrips;
        
        initComponents();
        
        
        Trip getTrip = new Trip();
        
        Map<String, Object> jsonForGetRequest;
        
        if (queriedLocation != null){
            jsonForGetRequest = Map.of("location", queriedLocation);
        }
        else{
            jsonForGetRequest = Map.of("location", "all");
        }
        
        String encodedJson = encodeJsonString(jsonForGetRequest.toString());
        
        allTripList = getTrip.getTripsFromServer(encodedJson);
        
        
        for (Trip trip : allTripList){
            
            if (showMyTrips == true && trip.userId.equals(userId)){
                queriedTripList.add(trip);
                
            }
            
            else if (showMyTrips == false && !trip.userId.equals(userId)){
                queriedTripList.add(trip);
            }
        }
           
        noOfTrips = queriedTripList.size();
        
        if (noOfTrips > 0){
           
            if (noOfTrips == 1){
                nextTripButton.setEnabled(false);
                previousTripButton.setEnabled(false);
            }
            
        
            updateTripWindow();
            this.setVisible(true);
            
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(), "No available trips. Try again.", "Dialog",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void updateTripWindow(){
        
        int tripCount = currentTripIndex + 1;
        
        tripCountLabel.setText(tripCount + "/" + noOfTrips);
        
        Trip tripToDisplay = queriedTripList.get(currentTripIndex);
        
        tripIdLabel.setText("Trip id: " + tripToDisplay.tripId);
        userIdLabel.setText(" Created by: " + tripToDisplay.userId);
        
        currentLocation = tripToDisplay.location;
        locationLabel.setText("Location: " + currentLocation);
        dateLabel.setText("Date: " + tripToDisplay.date);
        
        int noOfInterests;
        

        noOfInterests = tripToDisplay.interestedUsers.size();        
        
        noOfInterestsLabel.setText("Interested: " + noOfInterests);
        
        expressInterestButton.setEnabled(true);
        
        for (String user : tripToDisplay.interestedUsers){
            if (user.equals(userId)){
                expressInterestButton.setEnabled(false);
            }
        }
        
        if (showMyTrips == true){
            expressInterestButton.setEnabled(false);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        locationLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        tripIdLabel = new javax.swing.JLabel();
        userIdLabel = new javax.swing.JLabel();
        showWeatherButton = new javax.swing.JButton();
        expressInterestButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        previousTripButton = new javax.swing.JButton();
        nextTripButton = new javax.swing.JButton();
        noOfInterestsLabel = new javax.swing.JLabel();
        tripCountLabel = new javax.swing.JLabel();
        showInterestedUsersButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        locationLabel.setText("Location:");

        dateLabel.setText("Date:");

        tripIdLabel.setText("Trip id:");

        userIdLabel.setText("Created by:");

        showWeatherButton.setText("Show weather");
        showWeatherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showWeatherButtonActionPerformed(evt);
            }
        });

        expressInterestButton.setText("Express interest");
        expressInterestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expressInterestButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        previousTripButton.setText("Previous");
        previousTripButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousTripButtonActionPerformed(evt);
            }
        });

        nextTripButton.setText("Next");
        nextTripButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTripButtonActionPerformed(evt);
            }
        });

        noOfInterestsLabel.setText("Interested:");

        tripCountLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        tripCountLabel.setText("1/1");

        showInterestedUsersButton.setText("Show interested users");
        showInterestedUsersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showInterestedUsersButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(previousTripButton)
                .addGap(104, 104, 104)
                .addComponent(tripCountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nextTripButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(closeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noOfInterestsLabel)
                            .addComponent(locationLabel)
                            .addComponent(dateLabel)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(tripIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(userIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addComponent(expressInterestButton))
                            .addComponent(showWeatherButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(showInterestedUsersButton)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextTripButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previousTripButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tripCountLabel))
                .addGap(18, 18, 18)
                .addComponent(tripIdLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userIdLabel)
                .addGap(28, 28, 28)
                .addComponent(locationLabel)
                .addGap(18, 18, 18)
                .addComponent(dateLabel)
                .addGap(18, 18, 18)
                .addComponent(noOfInterestsLabel)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expressInterestButton)
                    .addComponent(showWeatherButton))
                .addGap(27, 27, 27)
                .addComponent(showInterestedUsersButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextTripButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTripButtonActionPerformed
        
        currentTripIndex += 1;
        
        if (currentTripIndex == noOfTrips){
            currentTripIndex = 0;
        }
        
        updateTripWindow();
        
        
    }//GEN-LAST:event_nextTripButtonActionPerformed

    private void previousTripButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousTripButtonActionPerformed
               
        if (currentTripIndex == 0){
            currentTripIndex = noOfTrips - 1;
        }
        else{
            currentTripIndex -= 1;
        }
        
        updateTripWindow();
    }//GEN-LAST:event_previousTripButtonActionPerformed

    private void showWeatherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showWeatherButtonActionPerformed
        Weather weather = new Weather(currentLocation);
        String myValidJSON = weather.getValidJSON();
        
        if (myValidJSON != null){
            ShowWeather newWeatherPanel = new ShowWeather(queriedTripList.get(currentTripIndex).weather);
            newWeatherPanel.showWindow();
        }  
    }//GEN-LAST:event_showWeatherButtonActionPerformed

    private class ExpressInterestRequest{
        
        private String userId;
        private String tripId;
        public ExpressInterestRequest(String userId, String tripId){
            this.userId = userId;
            this.tripId = tripId;
        }
        
    }
    
    private void expressInterestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expressInterestButtonActionPerformed
        
        ExpressInterestRequest newExpressInterestRequest = new ExpressInterestRequest(userId, queriedTripList.get(currentTripIndex).tripId);
        
        Gson gson = new Gson();
        String json = gson.toJson(newExpressInterestRequest);
        
        PutRequestClient newPutRequest = new PutRequestClient("trip", json);
        
        newPutRequest.sendPutRequest();
        
        queriedTripList.get(currentTripIndex).interestedUsers.add(userId);
        
        updateTripWindow();
        
    }//GEN-LAST:event_expressInterestButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
   
        dispose();
        
    }//GEN-LAST:event_closeButtonActionPerformed

    private void showInterestedUsersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showInterestedUsersButtonActionPerformed
       
        Map<String, String> queryMap = Map.of("userId", userId, "tripId", queriedTripList.get(currentTripIndex).tripId);
        
        String queryParamJson = queryMap.toString();
        
        String paramJsonEncoded = encodeJsonString(queryParamJson);
        
        GetRequestClient newGetRequest = new GetRequestClient("interest?parameterJson=",encodeJsonString(queryMap.toString()));
        
        String interestedUsersJson = newGetRequest.sendGetRequest();
        
        Map<String, Object> interestedUsersMap = jsonToMap(interestedUsersJson);
        
        ArrayList<String> interestedUsersList = (ArrayList<String>) interestedUsersMap.get("interestedUsers");
        
        String interestedUsersString = "";
        
        for (String userId : interestedUsersList){
            interestedUsersString = interestedUsersString + userId + "\n";
        }

        JOptionPane.showMessageDialog(new JFrame(), interestedUsersString, "Interested Users",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_showInterestedUsersButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ShowTrips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowTrips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowTrips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowTrips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ShowTrips().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton expressInterestButton;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JButton nextTripButton;
    private javax.swing.JLabel noOfInterestsLabel;
    private javax.swing.JButton previousTripButton;
    private javax.swing.JButton showInterestedUsersButton;
    private javax.swing.JButton showWeatherButton;
    private javax.swing.JLabel tripCountLabel;
    private javax.swing.JLabel tripIdLabel;
    private javax.swing.JLabel userIdLabel;
    // End of variables declaration//GEN-END:variables
}
