/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_windows;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author thomasdennis
 */




public class ShowWeather extends javax.swing.JFrame {

    private String forecastJSON;
    ArrayList<Map<String, Object>> allForecasts;
    Map<String, Object> locationInfo;

    ArrayList<Map<String, Object>> todayForecasts = new ArrayList<Map<String, Object>>();
    ArrayList<Map<String, Object>> tomorrowForecasts = new ArrayList<Map<String, Object>>();
    ArrayList<Map<String, Object>> dayThreeForecasts = new ArrayList<Map<String, Object>>();
    ArrayList<Map<String, Object>> dayFourForecasts = new ArrayList<Map<String, Object>>();
    ArrayList<Map<String, Object>> dayFiveForecasts = new ArrayList<Map<String, Object>>();
    ArrayList<Map<String, Object>> daySixForecasts = new ArrayList<Map<String, Object>>();
    
    
    String getDate(Map<String, Object> forecastMap){

        String currentDateTime = (String) forecastMap.get ("dt_txt");
        LocalDateTime datetime = LocalDateTime.parse(currentDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return datetime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    }
    
    String getTime(Map<String, Object> forecastMap){

        String currentDateTime = (String) forecastMap.get ("dt_txt");
        LocalDateTime datetime = LocalDateTime.parse(currentDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return datetime.format(DateTimeFormatter.ofPattern("HH:mm"));

    }
    
    String getDescription(Map<String, Object> forecastMap){
        
        ArrayList<Map<String, Object>> weather = (ArrayList<Map<String, Object>>)forecastMap.get("weather");
        Map<String, Object> weatherMap = weather.get(0);
        return (String) weatherMap.get ("description");
        
    }
    
    String roundNumber(Double unroundedTemperature){
        
        int roundedInt = (int) Math.round(unroundedTemperature);
        
        return (String.valueOf(roundedInt));
        
    }
    
    String getTemperature(Map<String, Object> forecastMap){
        
        Map<String, Object> mainMap = jsonToMap (forecastMap. get ("main") .toString () );
        
        Double temperature = (Double) mainMap.get ("temp");
        
        String tempString = roundNumber(temperature);
        
        return (tempString + "°C");
        
    }
    
    void addForecastsToDailyLists(int numberOfForecasts, ArrayList<Map<String, Object>> mapToAddTo){
        for (int i = 0; i<numberOfForecasts; i++){
            mapToAddTo.add(allForecasts.get(0));
            allForecasts.remove(0);
        }
        
    }

    
    /**
     * Creates new form ShowWeather
     */
    @SuppressWarnings("empty-statement")
    public ShowWeather(String forecastJSON) {
        
        this.setVisible(true);
        
        this.forecastJSON = forecastJSON;

        initComponents();
        
        Map<String, Object> respMap = jsonToMap (forecastJSON);
        
        allForecasts = (ArrayList<Map<String, Object>>)respMap.get("list");
        
        locationInfo = (Map<String, Object>)respMap.get("city");
        
        locationLabel.setText(locationInfo.get("name") + ", " + locationInfo.get("country"));
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date todaysDate = new Date();
        String todaysDateString = dateFormat.format(todaysDate);

        int todayForecastCount = 0;
        
        for (Map<String, Object> forecastMap : allForecasts){
                        
            if (getDate(forecastMap).equals(todaysDateString)){
                todayForecastCount ++;
                
            }
            else{
                break;
            }
                       
        }
                
        addForecastsToDailyLists(todayForecastCount, todayForecasts);
        addForecastsToDailyLists(8, tomorrowForecasts);
        addForecastsToDailyLists(8, dayThreeForecasts);
        addForecastsToDailyLists(8, dayFourForecasts);
        addForecastsToDailyLists(8, dayFiveForecasts);
        addForecastsToDailyLists(8 - todayForecastCount, daySixForecasts);
        
        dayThreeButton.setText(getDate(dayThreeForecasts.get(0)).substring(0, 5));
        dayFourButton.setText(getDate(dayFourForecasts.get(0)).substring(0, 5));
        dayFiveButton.setText(getDate(dayFiveForecasts.get(0)).substring(0, 5));
        daySixButton.setText(getDate(daySixForecasts.get(0)).substring(0, 5));
        
        

        showDate(todaysDateString);

        updateWeatherFields(todayForecasts);
        
    }
    
    public static Map<String, Object> jsonToMap (String str) {
        Map<String, Object> map = new Gson().fromJson (
        str, new TypeToken<HashMap<String, Object>> () {}.getType ()
        );
    return map;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel10 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        todayButton = new javax.swing.JButton();
        tomorrowButton = new javax.swing.JButton();
        dayFiveButton = new javax.swing.JButton();
        dayFourButton = new javax.swing.JButton();
        dayThreeButton = new javax.swing.JButton();
        daySixButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ThreeAMDescriptionLabel = new javax.swing.JLabel();
        ThreeAMTempLabel = new javax.swing.JLabel();
        SixAMDescriptionLabel = new javax.swing.JLabel();
        SixAMTempLabel = new javax.swing.JLabel();
        NineAMDescriptionLabel = new javax.swing.JLabel();
        NineAMTempLabel = new javax.swing.JLabel();
        TwelvePMDescriptionLabel = new javax.swing.JLabel();
        TwelvePMTempLabel = new javax.swing.JLabel();
        ThreePMDescriptionLabel = new javax.swing.JLabel();
        ThreePMTempLabel = new javax.swing.JLabel();
        SixPMDescriptionLabel = new javax.swing.JLabel();
        SixPMTempLabel = new javax.swing.JLabel();
        NinePMDescriptionLabel = new javax.swing.JLabel();
        NinePMTempLabel = new javax.swing.JLabel();
        TwelveAMDescriptionLabel = new javax.swing.JLabel();
        TwelveAMTempLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();

        jLabel10.setText("jLabel10");

        jLabel23.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel23.setText("description");

        jLabel24.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel24.setText("temp");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        todayButton.setText("Today");
        todayButton.setPreferredSize(new java.awt.Dimension(87, 63));
        todayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todayButtonActionPerformed(evt);
            }
        });

        tomorrowButton.setText("Tomorrow");
        tomorrowButton.setPreferredSize(new java.awt.Dimension(87, 63));
        tomorrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tomorrowButtonActionPerformed(evt);
            }
        });

        dayFiveButton.setPreferredSize(new java.awt.Dimension(87, 63));
        dayFiveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayFiveButtonActionPerformed(evt);
            }
        });

        dayFourButton.setPreferredSize(new java.awt.Dimension(87, 63));
        dayFourButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayFourButtonActionPerformed(evt);
            }
        });

        dayThreeButton.setPreferredSize(new java.awt.Dimension(87, 63));
        dayThreeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayThreeButtonActionPerformed(evt);
            }
        });

        daySixButton.setPreferredSize(new java.awt.Dimension(87, 63));
        daySixButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daySixButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setText("06:00");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel2.setText("21:00");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setText("18:00");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel4.setText("03:00");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel5.setText("15:00");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel6.setText("09:00");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel7.setText("12:00");

        ThreeAMDescriptionLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        ThreeAMDescriptionLabel.setText("-");

        ThreeAMTempLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        ThreeAMTempLabel.setText("-");

        SixAMDescriptionLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        SixAMDescriptionLabel.setText("-");

        SixAMTempLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        SixAMTempLabel.setText("-");

        NineAMDescriptionLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        NineAMDescriptionLabel.setText("-");

        NineAMTempLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        NineAMTempLabel.setText("-");

        TwelvePMDescriptionLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        TwelvePMDescriptionLabel.setText("-");

        TwelvePMTempLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        TwelvePMTempLabel.setText("-");

        ThreePMDescriptionLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        ThreePMDescriptionLabel.setText("-");

        ThreePMTempLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        ThreePMTempLabel.setText("-");

        SixPMDescriptionLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        SixPMDescriptionLabel.setText("-");

        SixPMTempLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        SixPMTempLabel.setText("-");

        NinePMDescriptionLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        NinePMDescriptionLabel.setText("-");

        NinePMTempLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        NinePMTempLabel.setText("-");

        TwelveAMDescriptionLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        TwelveAMDescriptionLabel.setText("-");

        TwelveAMTempLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        TwelveAMTempLabel.setText("-");

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel9.setText("00:00");

        locationLabel.setText("location");

        dateLabel.setText("date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(423, 423, 423)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel9)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(todayButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tomorrowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(TwelvePMTempLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(77, 77, 77)
                                    .addComponent(TwelvePMDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(NineAMTempLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(77, 77, 77)
                                    .addComponent(NineAMDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(ThreePMTempLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(77, 77, 77)
                                    .addComponent(ThreePMDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SixPMTempLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(SixPMDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NinePMTempLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(NinePMDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dayThreeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dayFourButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dayFiveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(daySixButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(SixAMTempLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ThreeAMTempLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TwelveAMTempLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(locationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TwelveAMDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ThreeAMDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SixAMDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationLabel)
                    .addComponent(dateLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TwelveAMDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TwelveAMTempLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThreeAMDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThreeAMTempLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SixAMDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SixAMTempLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NineAMDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NineAMTempLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TwelvePMDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TwelvePMTempLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThreePMDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThreePMTempLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SixPMDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SixPMTempLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NinePMDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(NinePMTempLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(todayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tomorrowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dayThreeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dayFourButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dayFiveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(daySixButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showDate(String date){
        dateLabel.setText(date); 
    }
    
    private void clearWeatherFields(){
        
        TwelveAMTempLabel.setText("-");
        TwelveAMDescriptionLabel.setText("-");

        ThreeAMTempLabel.setText("-");
        ThreeAMDescriptionLabel.setText("-");

        SixAMTempLabel.setText("-");
        SixAMDescriptionLabel.setText("-");

        NineAMTempLabel.setText("-");
        NineAMDescriptionLabel.setText("-");

        TwelvePMTempLabel.setText("-");
        TwelvePMDescriptionLabel.setText("-");

        ThreePMTempLabel.setText("-");
        ThreePMDescriptionLabel.setText("-");

        SixPMTempLabel.setText("-");
        SixPMDescriptionLabel.setText("-");

        NinePMTempLabel.setText("-");
        NinePMDescriptionLabel.setText("-");
        
    }
    
    private void updateWeatherFields(ArrayList<Map<String, Object>> dayOfForecasts){
        
        clearWeatherFields();
        
        for (Map<String, Object> forecastMap : dayOfForecasts){
            
            String time = getTime(forecastMap);
            
            if (time.equals("00:00")){
                TwelveAMTempLabel.setText(getTemperature(forecastMap));
                TwelveAMDescriptionLabel.setText(getDescription(forecastMap));
            }
            else if (time.equals("03:00")){
                ThreeAMTempLabel.setText(getTemperature(forecastMap));
                ThreeAMDescriptionLabel.setText(getDescription(forecastMap));
            }
            else if (time.equals("06:00")){
                SixAMTempLabel.setText(getTemperature(forecastMap));
                SixAMDescriptionLabel.setText(getDescription(forecastMap));
            }
            else if (time.equals("09:00")){
                NineAMTempLabel.setText(getTemperature(forecastMap));
                NineAMDescriptionLabel.setText(getDescription(forecastMap));
            }   
            else if (time.equals("12:00")){
                TwelvePMTempLabel.setText(getTemperature(forecastMap));
                TwelvePMDescriptionLabel.setText(getDescription(forecastMap));
            }
            else if (time.equals("15:00")){
                ThreePMTempLabel.setText(getTemperature(forecastMap));
                ThreePMDescriptionLabel.setText(getDescription(forecastMap));
            }   
            else if (time.equals("18:00")){
                SixPMTempLabel.setText(getTemperature(forecastMap));
                SixPMDescriptionLabel.setText(getDescription(forecastMap));
            }   
            else if (time.equals("21:00")){
                NinePMTempLabel.setText(getTemperature(forecastMap));
                NinePMDescriptionLabel.setText(getDescription(forecastMap));
            }   
        }
        
        
        
    }
    
    
    private void todayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todayButtonActionPerformed
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String stringDate = dateFormat.format(date);
        showDate(stringDate);
        
        updateWeatherFields(todayForecasts);

    }//GEN-LAST:event_todayButtonActionPerformed

    private void updateWeatherAndDate(ArrayList<Map<String, Object>> dayOfForecasts){
        String date = getDate(dayOfForecasts.get(0));        
        showDate(date);        
        updateWeatherFields(dayOfForecasts);
    }
    
    private void tomorrowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tomorrowButtonActionPerformed
        
        updateWeatherAndDate(tomorrowForecasts);        
    }//GEN-LAST:event_tomorrowButtonActionPerformed

    private void dayThreeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayThreeButtonActionPerformed
        updateWeatherAndDate(dayThreeForecasts);
    }//GEN-LAST:event_dayThreeButtonActionPerformed

    private void dayFourButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayFourButtonActionPerformed
        updateWeatherAndDate(dayFourForecasts);
    }//GEN-LAST:event_dayFourButtonActionPerformed

    private void dayFiveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayFiveButtonActionPerformed
        updateWeatherAndDate(dayFiveForecasts);
    }//GEN-LAST:event_dayFiveButtonActionPerformed

    private void daySixButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daySixButtonActionPerformed
        updateWeatherAndDate(daySixForecasts);
    }//GEN-LAST:event_daySixButtonActionPerformed

    
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
                //new ShowWeather().setVisible(true);
            }
        });
    }
    
    public static void main(String args[]) {
        
        //showWindow();
        
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NineAMDescriptionLabel;
    private javax.swing.JLabel NineAMTempLabel;
    private javax.swing.JLabel NinePMDescriptionLabel;
    private javax.swing.JLabel NinePMTempLabel;
    private javax.swing.JLabel SixAMDescriptionLabel;
    private javax.swing.JLabel SixAMTempLabel;
    private javax.swing.JLabel SixPMDescriptionLabel;
    private javax.swing.JLabel SixPMTempLabel;
    private javax.swing.JLabel ThreeAMDescriptionLabel;
    private javax.swing.JLabel ThreeAMTempLabel;
    private javax.swing.JLabel ThreePMDescriptionLabel;
    private javax.swing.JLabel ThreePMTempLabel;
    private javax.swing.JLabel TwelveAMDescriptionLabel;
    private javax.swing.JLabel TwelveAMTempLabel;
    private javax.swing.JLabel TwelvePMDescriptionLabel;
    private javax.swing.JLabel TwelvePMTempLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton dayFiveButton;
    private javax.swing.JButton dayFourButton;
    private javax.swing.JButton daySixButton;
    private javax.swing.JButton dayThreeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JButton todayButton;
    private javax.swing.JButton tomorrowButton;
    // End of variables declaration//GEN-END:variables
}
