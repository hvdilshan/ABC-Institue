/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spm.timetablemanagement.form.lecturer;

import com.spm.timetablemanagement.models.Building;
import com.spm.timetablemanagement.models.Lecturer;
import com.spm.timetablemanagement.util.CharecterSizeFilter;
import com.spm.timetablemanagement.util.Constant;
import com.spm.timetablemanagement.util.CreateQuery;
import com.spm.timetablemanagement.util.DBconnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Tiran Harsha
 */
public class AddLecturer extends javax.swing.JPanel {

    private ArrayList<Building> buildingList = new ArrayList();
    private ArrayList<String> faculty = new ArrayList();
    private ArrayList<String> center = new ArrayList();
    private ArrayList<String> level = new ArrayList();
    private ArrayList<String> department = new ArrayList();
    
    private static String buildings[];
    private static String faculties[];
    private static String centers[];
    private static String levels[];
    private static String departments[];
        
    private static PreparedStatement statement1, statement2, statement3, statement4, statement5;;
    private static ResultSet resultSet;

    /**
     * Creates new form AddLecturer
     */
    public AddLecturer() {
        initComponents();
        txt_lec_id.setDocument(new CharecterSizeFilter((6)));
        execute();

    }
    
    private void execute(){
        try {
            try {
                statement1 = DBconnection.getConnection().prepareStatement(CreateQuery.getQuery(Constant.GET_BUILDINGS));
                statement2 = DBconnection.getConnection().prepareStatement(CreateQuery.getQuery(Constant.GET_FACULTY));
                statement3 = DBconnection.getConnection().prepareStatement(CreateQuery.getQuery(Constant.GET_CENTER));
                statement4 = DBconnection.getConnection().prepareStatement(CreateQuery.getQuery(Constant.GET_LEVEL));
                statement5 = DBconnection.getConnection().prepareStatement(CreateQuery.getQuery(Constant.GET_DEPARTMENT));
                
                resultSet = statement1.executeQuery();
                
                while(resultSet.next()){
                    Building building = new Building();
                    
                    building.setId(resultSet.getInt(1));
                    building.setName(resultSet.getString(2));
                    buildingList.add(building);
                    
                }
                resultSet.close();
                resultSet = statement2.executeQuery();
                
                while(resultSet.next()){
                    faculty.add(resultSet.getString("name"));
                }
                resultSet.close();
                resultSet = statement3.executeQuery();
                
                while(resultSet.next()){
                    center.add(resultSet.getString("name"));
                }
                resultSet.close();
                resultSet = statement4.executeQuery();
                
                while(resultSet.next()){
                    level.add(resultSet.getString("name"));
                }
                
                resultSet.close();
                statement5.setString(1, "1");
                resultSet = statement5.executeQuery(); 
                    
                while(resultSet.next()){
                    department.add(resultSet.getString("name")); 
                }
                
                resultSet.close();
                
        } catch (ParserConfigurationException | SAXException ex) {
            Logger.getLogger(AddLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(AddLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
        buildings = new String[buildingList.size()];
        for(int i = 0; i < buildingList.size();i++){
            buildings[i] = buildingList.get(i).getName();
        }
        cmb_lec_building.setModel(new DefaultComboBoxModel<>(buildings));
        
        faculties = new String[faculty.size()];
        for(int i = 0; i < faculty.size();i++){
            faculties[i] = faculty.get(i);
        }
        cmb_lec_faculty.setModel(new DefaultComboBoxModel<>(faculties));
        
        centers = new String[center.size()];
        for(int i = 0; i < center.size();i++){
            centers[i] = center.get(i);
        }
        cmb_lec_center.setModel(new DefaultComboBoxModel<>(centers));
        
        levels = new String[level.size()];
        for(int i = 0; i < level.size();i++){
            levels[i] = level.get(i);
        }
        cmb_lec_level.setModel(new DefaultComboBoxModel<>(levels));
        
        departments = new String[department.size()];
            for(int i = 0; i < department.size();i++){                
                departments[i] = department.get(i);
            }
        cmb_lec_dept.setModel(new DefaultComboBoxModel<>(departments));
        
        cmb_lec_faculty.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_save = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_lec_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmb_lec_building = new javax.swing.JComboBox<>();
        cmb_lec_level = new javax.swing.JComboBox<>();
        cmb_lec_dept = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmb_lec_center = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmb_lec_faculty = new javax.swing.JComboBox<>();
        txt_lec_id = new javax.swing.JTextField();
        generateRank = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_reset = new javax.swing.JButton();
        txt_lec_rank = new javax.swing.JTextField();

        setBackground(new java.awt.Color(100, 149, 237));

        jPanel1.setBackground(new java.awt.Color(100, 149, 237));

        jPanel4.setBackground(new java.awt.Color(100, 149, 237));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ADD LECTURER");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1095, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(100, 149, 237));

        btn_save.setBackground(new java.awt.Color(0, 102, 0));
        btn_save.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setText("Save");
        btn_save.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_save.setPreferredSize(new java.awt.Dimension(60, 30));
        btn_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_saveMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_saveMouseReleased(evt);
            }
        });
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lecturer Name");
        jLabel1.setPreferredSize(new java.awt.Dimension(60, 30));

        txt_lec_name.setMinimumSize(new java.awt.Dimension(60, 20));
        txt_lec_name.setName(""); // NOI18N
        txt_lec_name.setPreferredSize(new java.awt.Dimension(140, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Employee ID");
        jLabel2.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Center");
        jLabel5.setPreferredSize(new java.awt.Dimension(60, 30));

        cmb_lec_building.setMinimumSize(new java.awt.Dimension(100, 20));
        cmb_lec_building.setPreferredSize(new java.awt.Dimension(140, 30));

        cmb_lec_level.setMinimumSize(new java.awt.Dimension(100, 20));
        cmb_lec_level.setPreferredSize(new java.awt.Dimension(100, 30));

        cmb_lec_dept.setMinimumSize(new java.awt.Dimension(100, 20));
        cmb_lec_dept.setPreferredSize(new java.awt.Dimension(140, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Level");
        jLabel8.setPreferredSize(new java.awt.Dimension(60, 30));

        cmb_lec_center.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cmb_lec_center.setMinimumSize(new java.awt.Dimension(100, 20));
        cmb_lec_center.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Building");
        jLabel6.setPreferredSize(new java.awt.Dimension(60, 30));

        cmb_lec_faculty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cmb_lec_faculty.setMinimumSize(new java.awt.Dimension(100, 20));
        cmb_lec_faculty.setPreferredSize(new java.awt.Dimension(140, 30));
        cmb_lec_faculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_lec_facultyActionPerformed(evt);
            }
        });

        txt_lec_id.setMinimumSize(new java.awt.Dimension(60, 20));
        txt_lec_id.setName(""); // NOI18N
        txt_lec_id.setPreferredSize(new java.awt.Dimension(100, 30));

        generateRank.setBackground(new java.awt.Color(204, 204, 204));
        generateRank.setText("Generate Rank");
        generateRank.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        generateRank.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        generateRank.setMaximumSize(new java.awt.Dimension(80, 20));
        generateRank.setMinimumSize(new java.awt.Dimension(80, 20));
        generateRank.setPreferredSize(new java.awt.Dimension(80, 20));
        generateRank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                generateRankMousePressed(evt);
            }
        });
        generateRank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateRankActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Faculty");
        jLabel3.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Department");
        jLabel4.setPreferredSize(new java.awt.Dimension(60, 30));

        btn_reset.setBackground(new java.awt.Color(255, 153, 0));
        btn_reset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setText("Clear");
        btn_reset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_resetMousePressed(evt);
            }
        });
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        txt_lec_rank.setEditable(false);
        txt_lec_rank.setMinimumSize(new java.awt.Dimension(60, 20));
        txt_lec_rank.setName(""); // NOI18N
        txt_lec_rank.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(generateRank, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(51, 51, 51)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_lec_rank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmb_lec_level, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_lec_name, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                .addComponent(txt_lec_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmb_lec_faculty, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmb_lec_dept, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmb_lec_center, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmb_lec_building, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(18, Short.MAX_VALUE)))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_reset, btn_save});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_lec_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_lec_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmb_lec_faculty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmb_lec_dept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(24, 24, 24)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmb_lec_center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmb_lec_building, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmb_lec_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(generateRank, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_lec_rank, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(23, Short.MAX_VALUE)))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_reset, btn_save});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void generateRankMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generateRankMousePressed
        
    }//GEN-LAST:event_generateRankMousePressed

    private void cmb_lec_facultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_lec_facultyActionPerformed
        int faculty = cmb_lec_faculty.getSelectedIndex()+1;
        department.clear();
        try {
             statement1 = DBconnection.getConnection().prepareStatement(CreateQuery.getQuery(Constant.GET_DEPARTMENT));
             statement1.setInt(1, faculty);
             
             resultSet = statement1.executeQuery();
             
             while(resultSet.next()){
                 department.add(resultSet.getString("name"));
             }
             
             resultSet.close();
             departments = new String[department.size()];
             
            for(int i = 0; i < department.size();i++){
                departments[i] = department.get(i);
            }
            cmb_lec_dept.setModel(new DefaultComboBoxModel<>(departments));
             
        } catch (ParserConfigurationException | SAXException | SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(AddLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmb_lec_facultyActionPerformed

    private void btn_resetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetMousePressed
        resetAll();
    }//GEN-LAST:event_btn_resetMousePressed

    private void btn_saveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMousePressed
        
        boolean error = false;
        
        if(txt_lec_rank.getText().contentEquals("")){
            JOptionPane.showMessageDialog(AddLecturer.this, "Rank cannot be empty!", "Data missing", JOptionPane.ERROR_MESSAGE);
            error = true;
        }
        else if(txt_lec_name.getText().contentEquals("")){
            JOptionPane.showMessageDialog(AddLecturer.this, "Name cannot be empty!", "Data missing", JOptionPane.ERROR_MESSAGE);
            error = true;
        }
        
        if(!error){
            Lecturer lec = new Lecturer();
            
            lec.setName(txt_lec_name.getText());
            lec.setLec_id(txt_lec_id.getText());
            lec.setFaculty(cmb_lec_faculty.getSelectedItem().toString());
            lec.setDepartment(cmb_lec_dept.getSelectedItem().toString());
            lec.setCenter(cmb_lec_center.getSelectedItem().toString());
            lec.setBuilding(cmb_lec_building.getSelectedItem().toString());
            lec.setLevel(cmb_lec_level.getSelectedItem().toString());
            lec.setRank(txt_lec_rank.getText());
            
            try { 
                Connection connection = DBconnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(CreateQuery.getQuery(Constant.INSERT_LECTURER));
                
                statement.setString(1, lec.getName());
                statement.setString(2, lec.getLec_id());
                statement.setString(3, lec.getFaculty());
                statement.setString(4, lec.getDepartment());
                statement.setString(5, lec.getCenter());
                statement.setString(6, lec.getBuilding());
                statement.setString(7, lec.getLevel());
                statement.setString(8, lec.getRank());
                
                statement.execute();
                
                JOptionPane.showMessageDialog(AddLecturer.this, "Lecturer Added", "Lecturer Added", JOptionPane.DEFAULT_OPTION);
                resetAll();
            } catch (SQLException | ClassNotFoundException | IOException | 
                    ParserConfigurationException | SAXException ex) {
                Logger.getLogger(AddLecturer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_saveMousePressed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_resetActionPerformed

    private void generateRankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateRankActionPerformed
        // TODO add your handling code here:
        generateRank();
    }//GEN-LAST:event_generateRankActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_saveMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_saveMouseReleased

    public void generateRank(){
        if(txt_lec_id.getText().contentEquals("")){
            JOptionPane.showMessageDialog(AddLecturer.this, "Lecture id cannot be empty!", "Data missing", JOptionPane.ERROR_MESSAGE);
        }
        else if(txt_lec_id.getText().length()!= 6){
            JOptionPane.showMessageDialog(AddLecturer.this, "Lecture id Should be 6 characters", "Data missing", JOptionPane.ERROR_MESSAGE);
        }
        else{
            
            txt_lec_rank.setText(cmb_lec_level.getSelectedItem().toString() + "." + txt_lec_id.getText());
        }
    }
    private void resetAll(){
        txt_lec_name.setText("");
        txt_lec_id.setText("");
        txt_lec_rank.setText("");
        cmb_lec_building.setSelectedIndex(0);
        cmb_lec_center.setSelectedIndex(0);
        cmb_lec_dept.setSelectedIndex(0);
        cmb_lec_faculty.setSelectedIndex(0);
        cmb_lec_level.setSelectedIndex(0);
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox<String> cmb_lec_building;
    private javax.swing.JComboBox<String> cmb_lec_center;
    private javax.swing.JComboBox<String> cmb_lec_dept;
    private javax.swing.JComboBox<String> cmb_lec_faculty;
    private javax.swing.JComboBox<String> cmb_lec_level;
    private javax.swing.JButton generateRank;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_lec_id;
    private javax.swing.JTextField txt_lec_name;
    private javax.swing.JTextField txt_lec_rank;
    // End of variables declaration//GEN-END:variables
}