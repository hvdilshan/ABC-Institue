/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spm.timetablemanagement.form.lecturer;

import com.spm.timetablemanagement.models.Building;
import com.spm.timetablemanagement.models.Lecturer;
import com.spm.timetablemanagement.util.Constant;
import com.spm.timetablemanagement.util.CreateQuery;
import com.spm.timetablemanagement.util.DBconnection;
import java.awt.Dimension;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Tiran Harsha
 */
public class ViewLecturer extends javax.swing.JPanel {

    ArrayList<Lecturer> lecturers = new ArrayList<>();
    TableModel model;
    int row ;
    int col ;
    
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
    private int id = 0;
    private int isReset = 0;
    
    private static PreparedStatement statement1, statement2, statement3, statement4, statement5;
    private static ResultSet resultSet;
    /**
     * Creates new form ViewLecturer
     */
    public ViewLecturer() {
        initComponents();
        txt_id.setVisible(false);
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

            departments = new String[department.size()];
            for(int i = 0; i < department.size();i++){                
                departments[i] = department.get(i);
            }
            cmb_lec_dept.setModel(new DefaultComboBoxModel<>(departments));

            levels = new String[level.size()];
            for(int i = 0; i < level.size();i++){
                levels[i] = level.get(i);
            }
            cmb_lec_level.setModel(new DefaultComboBoxModel<>(levels));
            
            Connection connection =  DBconnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(CreateQuery.getQuery(Constant.GET_LECTURER));
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                DefaultTableModel mod = (DefaultTableModel) jTable1.getModel();
                Lecturer l = new Lecturer();
                
                l.setId(resultSet.getInt("id"));
                l.setName(resultSet.getString("name"));
                l.setLec_id(resultSet.getString("emp_id"));
                l.setFaculty(resultSet.getString("faculty"));
                l.setDepartment(resultSet.getString("department"));
                l.setCenter(resultSet.getString("center"));
                l.setBuilding(resultSet.getString("building"));
                l.setLevel(resultSet.getString("level"));
                l.setRank(resultSet.getString("rank"));
                
                lecturers.add(l);
                
                mod.setRowCount(0);
                
                createTable();
            }
        } catch (SQLException | ClassNotFoundException | IOException | 
                ParserConfigurationException | SAXException ex) {
            Logger.getLogger(ViewLecturer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error on data Load", "Data error", JOptionPane.ERROR_MESSAGE);
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

        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_lec_rank = new javax.swing.JTextField();
        txt_lec_name = new javax.swing.JTextField();
        txt_lec_id = new javax.swing.JTextField();
        cmb_lec_faculty = new javax.swing.JComboBox<>();
        cmb_lec_dept = new javax.swing.JComboBox<>();
        cmb_lec_center = new javax.swing.JComboBox<>();
        cmb_lec_building = new javax.swing.JComboBox<>();
        cmb_lec_level = new javax.swing.JComboBox<>();
        txt_id = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_update = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();

        setBackground(new java.awt.Color(100, 149, 237));
        setToolTipText("");
        setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(100, 149, 237));
        jPanel4.setForeground(new java.awt.Color(100, 149, 237));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("MANAGE LECTURERS");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1392, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jScrollPane3.setBorder(null);

        jPanel2.setBackground(new java.awt.Color(100, 149, 237));
        jPanel2.setForeground(new java.awt.Color(100, 149, 237));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Lecturer Name", "Employee ID", "Faculty", "Department", "Center", "Building", "Level", "Rank"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        jPanel3.setBackground(new java.awt.Color(100, 149, 237));
        jPanel3.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name");
        jLabel1.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Employee ID");
        jLabel2.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Faculty");
        jLabel3.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Department");
        jLabel4.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Center");
        jLabel5.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Building");
        jLabel6.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Level");
        jLabel8.setPreferredSize(new java.awt.Dimension(60, 30));

        txt_lec_rank.setEditable(false);
        txt_lec_rank.setMinimumSize(new java.awt.Dimension(60, 20));
        txt_lec_rank.setName(""); // NOI18N
        txt_lec_rank.setPreferredSize(new java.awt.Dimension(100, 20));

        txt_lec_name.setMinimumSize(new java.awt.Dimension(60, 20));
        txt_lec_name.setName(""); // NOI18N
        txt_lec_name.setPreferredSize(new java.awt.Dimension(140, 30));

        txt_lec_id.setMinimumSize(new java.awt.Dimension(60, 20));
        txt_lec_id.setName(""); // NOI18N
        txt_lec_id.setPreferredSize(new java.awt.Dimension(100, 30));

        cmb_lec_faculty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cmb_lec_faculty.setMinimumSize(new java.awt.Dimension(100, 20));
        cmb_lec_faculty.setPreferredSize(new java.awt.Dimension(140, 30));
        cmb_lec_faculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_lec_facultyActionPerformed(evt);
            }
        });

        cmb_lec_dept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cmb_lec_dept.setMinimumSize(new java.awt.Dimension(100, 20));
        cmb_lec_dept.setPreferredSize(new java.awt.Dimension(140, 30));

        cmb_lec_center.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cmb_lec_center.setMinimumSize(new java.awt.Dimension(100, 20));
        cmb_lec_center.setPreferredSize(new java.awt.Dimension(100, 30));

        cmb_lec_building.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cmb_lec_building.setMinimumSize(new java.awt.Dimension(100, 20));
        cmb_lec_building.setPreferredSize(new java.awt.Dimension(140, 30));

        cmb_lec_level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cmb_lec_level.setMinimumSize(new java.awt.Dimension(100, 20));
        cmb_lec_level.setPreferredSize(new java.awt.Dimension(100, 30));
        cmb_lec_level.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_lec_levelItemStateChanged(evt);
            }
        });

        txt_id.setEditable(false);
        txt_id.setAutoscrolls(false);
        txt_id.setEnabled(false);
        txt_id.setFocusable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Rank");
        jLabel9.setPreferredSize(new java.awt.Dimension(60, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmb_lec_dept, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_lec_building, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_lec_center, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_lec_level, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_lec_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_lec_faculty, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_lec_name, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_lec_rank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_lec_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_lec_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_lec_faculty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_lec_dept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_lec_center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_lec_building, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_lec_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_lec_rank, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(100, 149, 237));

        btn_update.setBackground(new java.awt.Color(0, 102, 255));
        btn_update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Update");
        btn_update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_update.setPreferredSize(new java.awt.Dimension(60, 30));
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_clear.setBackground(new java.awt.Color(255, 153, 0));
        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Clear");
        btn_clear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_clear.setPreferredSize(new java.awt.Dimension(60, 30));
        btn_clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_clearMousePressed(evt);
            }
        });
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(153, 0, 0));
        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Delete");
        btn_delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_delete.setPreferredSize(new java.awt.Dimension(60, 30));
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_deleteMousePressed(evt);
            }
        });
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 886, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel2);

        add(jScrollPane3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        int row = jTable1.getSelectedRow();
        model = jTable1.getModel();
        txt_id.setText(model.getValueAt(row, 0).toString());
        txt_lec_name.setText(model.getValueAt(row, 1).toString());
        txt_lec_id.setText(model.getValueAt(row, 2).toString());
        cmb_lec_faculty.setSelectedItem(model.getValueAt(row, 3).toString());
        cmb_lec_dept.setSelectedItem(model.getValueAt(row, 4).toString());
        cmb_lec_center.setSelectedItem(model.getValueAt(row, 5).toString());
        cmb_lec_building.setSelectedItem(model.getValueAt(row, 6).toString());
        cmb_lec_level.setSelectedItem(model.getValueAt(row, 7).toString());
        txt_lec_rank.setText(model.getValueAt(row, 8).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

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

    private void btn_clearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clearMousePressed

    private void btn_deleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteMousePressed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        if (txt_id.getText().isEmpty()){
            JOptionPane.showMessageDialog(ViewLecturer.this, "Select Lecturer", "Data missing", JOptionPane.ERROR_MESSAGE);
        }else{
        
            boolean error = false;

            if(txt_lec_rank.getText().contentEquals("")){
                JOptionPane.showMessageDialog(ViewLecturer.this, "Rank cannot be empty!", "Data missing", JOptionPane.ERROR_MESSAGE);
                error = true;
            }
            else if(txt_lec_name.getText().contentEquals("")){
                JOptionPane.showMessageDialog(ViewLecturer.this, "Name cannot be empty!", "Data missing", JOptionPane.ERROR_MESSAGE);
                error = true;
            }
            else if(txt_lec_id.getText().contentEquals("")){
                JOptionPane.showMessageDialog(ViewLecturer.this, "Employee ID cannot be empty!", "Data missing", JOptionPane.ERROR_MESSAGE);
                error = true;
            }

            if(!error){
                Lecturer lec = new Lecturer();

                lec.setId(Integer.parseInt(txt_id.getText()));
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
                    PreparedStatement statement = connection.prepareStatement(CreateQuery.getQuery(Constant.UPDATE_LECTURER));

                    statement.setString(1, lec.getName());
                    statement.setString(2, lec.getLec_id());
                    statement.setString(3, lec.getFaculty());
                    statement.setString(4, lec.getDepartment());
                    statement.setString(5, lec.getCenter());
                    statement.setString(6, lec.getBuilding());
                    statement.setString(7, lec.getLevel());
                    statement.setString(8, lec.getRank());
                    statement.setString(9, Integer.toString(lec.getId()));

                    statement.execute();

                    JOptionPane.showMessageDialog(ViewLecturer.this, "Lecturer Updated", "Lecturer Updated", JOptionPane.DEFAULT_OPTION);

                    refreshData();
                    
                } catch (SQLException | ClassNotFoundException | IOException |
                    ParserConfigurationException | SAXException ex) {
                    Logger.getLogger(AddLecturer.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(ViewLecturer.this, "Lecturer Updating Error"+ex.getMessage(), "Lecturer Update Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        isReset = 1;
        refreshData();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        isReset = 1;
        if(txt_id.getText().isEmpty()){
            JOptionPane.showMessageDialog(ViewLecturer.this, "Select Lecturer", "Data missing", JOptionPane.ERROR_MESSAGE);
        }else{
            int x = JOptionPane.showConfirmDialog(ViewLecturer.this, "Are you sure to Delete", "Delete", JOptionPane.YES_NO_OPTION);
            
            if(x == 0){
                deleteData(Integer.parseInt(txt_id.getText()));
            }else{
                refreshData();
            }
        }

    }//GEN-LAST:event_btn_deleteActionPerformed

    private void cmb_lec_levelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_lec_levelItemStateChanged
        // TODO add your handling code here:
        if (isReset == 0){
            generateRank();
        }
    }//GEN-LAST:event_cmb_lec_levelItemStateChanged

    private void deleteData(int row){
        boolean error = false;
        DefaultTableModel mod = (DefaultTableModel) jTable1.getModel();
        
         try {
            
            Connection connection =  DBconnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(CreateQuery.getQuery(Constant.DELETE_LECTURER));
            
            statement.setInt(1, row);
            statement.execute();
            refreshData();
            
        } catch (SQLException | ClassNotFoundException | IOException | 
                ParserConfigurationException | SAXException ex) {
            Logger.getLogger(ViewLecturer.class.getName()).log(Level.SEVERE, null, ex);
            error = true;
            
             JOptionPane.showMessageDialog(ViewLecturer.this, "Delete Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
         
         if(!error){
             JOptionPane.showMessageDialog(ViewLecturer.this, "Delete Succes", "Succes", JOptionPane.DEFAULT_OPTION);
             refreshData();
         }
    }

    private void createTable(){
        DefaultTableModel mod = (DefaultTableModel) jTable1.getModel();
        
        Object [] data = new Object[9];
        
        for(int i = 0;i < lecturers.size(); i++){
            data[0] = lecturers.get(i).getId();
            data[1] = lecturers.get(i).getName();
            data[2] = lecturers.get(i).getLec_id();
            data[3] = lecturers.get(i).getFaculty();
            data[4] = lecturers.get(i).getDepartment();
            data[5] = lecturers.get(i).getCenter();
            data[6] = lecturers.get(i).getBuilding();
            data[7] = lecturers.get(i).getLevel();
            data[8] = lecturers.get(i).getRank();
            
            mod.addRow(data);
           
        }
        
    }
    /**
     * Refresh data table
     */
    protected void refreshData(){
        DefaultTableModel mod = (DefaultTableModel) jTable1.getModel();
        mod.setRowCount(0);
        try {
            Connection connection =  DBconnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(CreateQuery.getQuery(Constant.GET_LECTURER));
            ResultSet resultSet = statement.executeQuery();
            
            Object [] data = new Object[9];
                
            while(resultSet.next()){
                Lecturer l = new Lecturer();
        
                data[0] = resultSet.getInt("id");
                data[1] = resultSet.getString("name");
                data[2] = resultSet.getString("emp_id");
                data[3] = resultSet.getString("faculty");
                data[4] = resultSet.getString("department");
                data[5] = resultSet.getString("center");
                data[6] = resultSet.getString("building");
                data[7] = resultSet.getString("level");
                data[8] = resultSet.getString("rank");

                mod.addRow(data);
            }
            
            txt_id.setText("");            
            txt_lec_name.setText("");
            txt_lec_id.setText("");
            txt_lec_rank.setText("");
            cmb_lec_faculty.setSelectedIndex(0);
            cmb_lec_dept.setSelectedIndex(0);
            cmb_lec_center.setSelectedIndex(0);
            cmb_lec_building.setSelectedIndex(0);
            cmb_lec_level.setSelectedIndex(0);
            
        } catch (SQLException | ClassNotFoundException | IOException | 
                ParserConfigurationException | SAXException ex) {
            Logger.getLogger(ViewLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public void generateRank(){
        
        if(!txt_lec_id.getText().isEmpty()){
            if(txt_lec_id.getText().length()!= 6){
                JOptionPane.showMessageDialog(ViewLecturer.this, "Lecture id Should be 6 characters", "Data missing", JOptionPane.ERROR_MESSAGE);
            }else{
                txt_lec_rank.setText(cmb_lec_level.getSelectedItem().toString() + "." + txt_lec_id.getText());
            } 
        }
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btn_clear;
    protected javax.swing.JButton btn_delete;
    protected javax.swing.JButton btn_update;
    protected javax.swing.JComboBox<String> cmb_lec_building;
    protected javax.swing.JComboBox<String> cmb_lec_center;
    protected javax.swing.JComboBox<String> cmb_lec_dept;
    protected javax.swing.JComboBox<String> cmb_lec_faculty;
    protected javax.swing.JComboBox<String> cmb_lec_level;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    protected javax.swing.JTable jTable1;
    protected javax.swing.JTextField txt_id;
    protected javax.swing.JTextField txt_lec_id;
    protected javax.swing.JTextField txt_lec_name;
    protected javax.swing.JTextField txt_lec_rank;
    // End of variables declaration//GEN-END:variables
}
