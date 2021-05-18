/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spm.timetablemanagement.statistics;

import com.spm.timetablemanagement.util.DBconnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author Nawod
 */
public class pnl_Statisticals extends javax.swing.JPanel {
    /**
     * Creates new form pnl_Statisticals
     */
    public pnl_Statisticals() throws SQLException, Exception {
        initComponents();
        showLecturerList();
        showRoomSList();
        showStdList();
        showModuleList();
        getLecCount();
    }

    //Getting statistical Details
    public void getLecCount() throws Exception{
        try {
            String colName = "count";
            //Get Total Registered Lecturer Count
            String queryLec = "SELECT COUNT(*) as count FROM lecturer";
            String totLec = getRowCount(queryLec, colName);
            txt_TotLec.setText(totLec);
            
            //Get Total Registered Room Count
            String queryRoom = "SELECT COUNT(*) as count FROM room";
            String totRoom = getRowCount(queryRoom, colName);
            txt_Tot.setText(totRoom);
            
            //Get Total Registered Labarotaory Count
            String queryLabs = "SELECT COUNT(*) as count FROM room WHERE type = 'Laboratory'";
            String totLabs = getRowCount(queryLabs, colName);
            txt_TotLabs.setText(totLabs);
            
            //Get Total Registered Lecture Hall Count
            String queryLecRoom = "SELECT COUNT(*) as count FROM room WHERE type = 'Lecture Hall'";
            String totLecR = getRowCount(queryLecRoom, colName);
            txt_TotLecRoom.setText(totLecR);
            
            //Get Total Registered Student Count
            String queryStd = "SELECT COUNT(*) as count FROM all_details";
            String totStd = getRowCount(queryStd, colName);
            txt_TotStud.setText(totStd);
//            
            //Get Total Registered Module Count
            String querySub = "SELECT COUNT(*) as count FROM subject";
            String totSub = getRowCount(querySub, colName);
            txt_TotSub.setText(totSub);
            
//            //Get Total Registered Lecturer Count(Professor)
//            String queryLec1 = "SELECT COUNT(*) as count FROM Lecture WHERE level = 1";
//            String totLec1 = getRowCount(queryLec1, colName);
//            txt_professor.setText(totLec1);
//            
//            //Get Total Registered Lecturer Count(Assistant Professor)
//            String queryLec2 = "SELECT COUNT(*) as count FROM Lecture WHERE level = 2";
//            String totLec2 = getRowCount(queryLec2, colName);
//            txt_Astprofessor.setText(totLec2);
//            
//            //Get Total Registered Lecturer Count(Senior Lecturer(HG))
//            String queryLec3 = "SELECT COUNT(*) as count FROM Lecture WHERE level = 3";
//            String totLec3 = getRowCount(queryLec3, colName);
//            txt_HG.setText(totLec3);
//            
//            //Get Total Registered Lecturer Count(Senior Lecturer)
//            String queryLec4 = "SELECT COUNT(*) as count FROM Lecture WHERE level = 4";
//            String totLec4 = getRowCount(queryLec4, colName);
//            txt_seniorLec.setText(totLec4);
//            
//            //Get Total Registered Lecturer Count(Lecturer)
//            String queryLec5 = "SELECT COUNT(*) as count FROM Lecture WHERE level = 5";
//            String totLec5 = getRowCount(queryLec5, colName);
//            txt_lec.setText(totLec5);
//            
//            //Get Total Registered Lecturer Count(Assistant Lecturer)
//            String queryLec6 = "SELECT COUNT(*) as count FROM Lecture WHERE level = 6";
//            String totLec6 = getRowCount(queryLec6, colName);
//            txt_AsLec.setText(totLec6);
//            
            //Get Total Registered Subject Count(year1)
            String querySub1 = "SELECT COUNT(*) as count FROM subject WHERE offered_year = 'Y1'";
            String totSub1 = getRowCount(querySub1, colName);
            txt_Year1Sub.setText(totSub1);
            
            //Get Total Registered Subject Count(year2)
            String querySub2 = "SELECT COUNT(*) as count FROM subject WHERE offered_year = 'Y2'";
            String totSub2 = getRowCount(querySub2, colName);
            txt_Year2Sub.setText(totSub2);
            
            //Get Total Registered Subject Count(year3)
            String querySub3 = "SELECT COUNT(*) as count FROM subject WHERE offered_year = 'Y3'";
            String totSub3 = getRowCount(querySub3, colName);
            txt_Year3Sub.setText(totSub3);
            
            //Get Total Registered Subject Count(year4)
            String querySub4 = "SELECT COUNT(*) as count FROM subject WHERE offered_year = 'Y4'";
            String totSub4 = getRowCount(querySub4, colName);
            txt_Year4Sub.setText(totSub4);
            
            //Get Total Registered Student Count as Year1
            String queryStdY1 = "SELECT COUNT(*) as count FROM all_details WHERE yNs = 'Y1.S1' OR yNs = 'Y1.S2'";
            String totStdY1 = getRowCount(queryStdY1, colName);
            txt_Year1Std.setText(totStdY1);
            
            //Get Total Registered Student Count as Year2
            String queryStdY2 = "SELECT COUNT(*) as count FROM all_details WHERE yNs = 'Y2.S1' OR yNs = 'Y2.S2'";
            String totStdY2 = getRowCount(queryStdY2, colName);
            txt_Year2Std.setText(totStdY2);
            
            //Get Total Registered Student Count as Year3
            String queryStdY3 = "SELECT COUNT(*) as count FROM all_details WHERE yNs = 'Y3.S1' OR yNs = 'Y3.S2'";
            String totStdY3 = getRowCount(queryStdY3, colName);
            txt_Year3Std.setText(totStdY3);
            
            //Get Total Registered Student Count as Year4
            String queryStdY4 = "SELECT COUNT(*) as count FROM all_details WHERE yNs = 'Y4.S1' OR yNs = 'Y4.S2'";
            String totStdY4 = getRowCount(queryStdY4, colName);
            txt_Year4Std.setText(totStdY4);
        } catch (Exception e) {
            throw(e); 
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btn_Rooms = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Locations = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txt_TotLecRoom = new javax.swing.JLabel();
        txt_TotLabs = new javax.swing.JLabel();
        txt_Tot = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_lec = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_TotLec = new javax.swing.JLabel();
        btn_Std1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btn_Std = new javax.swing.JButton();
        txt_TotStud = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_all_details = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txt_Year1Std = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txt_Year2Std = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        lbl_HG5 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        txt_Year3Std = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txt_Year4Std = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btn_Module = new javax.swing.JButton();
        txt_TotSub = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_module = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_Year1Sub = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_Year2Sub = new javax.swing.JLabel();
        lbl_HG1 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_Year3Sub = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_Year4Sub = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(100, 149, 237));

        jTabbedPane1.setBackground(new java.awt.Color(100, 149, 237));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(100, 149, 237));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Registered Rooms");

        btn_Rooms.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Rooms.setText("Show Statistics");
        btn_Rooms.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_Rooms.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Rooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RoomsActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(":");

        tbl_Locations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Building Name", "Room Name", "Room Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_Locations);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total Registered Laboratories");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(":");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Total Registered Lecture Room");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText(":");

        txt_TotLecRoom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_TotLecRoom.setForeground(new java.awt.Color(255, 255, 255));

        txt_TotLabs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_TotLabs.setForeground(new java.awt.Color(255, 255, 255));

        txt_Tot.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Tot.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_TotLabs, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Tot, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                .addComponent(txt_TotLecRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(290, 290, 290))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Rooms, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Rooms, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_Tot, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_TotLabs, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_TotLecRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel29)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Registered Rooms", jPanel5);

        jPanel1.setBackground(new java.awt.Color(100, 149, 237));

        jPanel3.setBackground(new java.awt.Color(100, 149, 237));

        tbl_lec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Employee Id", "Employee Name", "Faculty", "Department", "Center", "Building", "Level", "Rank"
            }
        ));
        jScrollPane6.setViewportView(tbl_lec);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total Registered Lecturers");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText(":");

        txt_TotLec.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_TotLec.setForeground(new java.awt.Color(255, 255, 255));

        btn_Std1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Std1.setText("Show Statistics");
        btn_Std1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Std1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Std1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane6)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addGap(27, 27, 27)
                        .addComponent(txt_TotLec, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 587, Short.MAX_VALUE)
                        .addComponent(btn_Std1)
                        .addGap(53, 53, 53))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_TotLec, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_Std1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Registered Lectures", jPanel1);

        jPanel7.setBackground(new java.awt.Color(100, 149, 237));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total Registered Student Groups");

        btn_Std.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Std.setText("Show Statistics");
        btn_Std.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Std.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_StdActionPerformed(evt);
            }
        });

        txt_TotStud.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_TotStud.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(":");

        tbl_all_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Year & Sem", "Degree Program", "Group Number", "Group Id", "SubGroup Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbl_all_details);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Year 1 Students");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText(":");

        txt_Year1Std.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Year1Std.setForeground(new java.awt.Color(255, 255, 255));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Year 2 Students");

        txt_Year2Std.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Year2Std.setForeground(new java.awt.Color(255, 255, 255));

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText(":");

        lbl_HG5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_HG5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_HG5.setText("Year 3 Students");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText(":");

        txt_Year3Std.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Year3Std.setForeground(new java.awt.Color(255, 255, 255));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Year 4 Students");

        txt_Year4Std.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Year4Std.setForeground(new java.awt.Color(255, 255, 255));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText(":");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel53)
                        .addGap(6, 6, 6)
                        .addComponent(txt_Year1Std, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel54)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel55)
                        .addGap(6, 6, 6)
                        .addComponent(txt_Year2Std, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lbl_HG5)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel56)
                        .addGap(6, 6, 6)
                        .addComponent(txt_Year3Std, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel57)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel58)
                        .addGap(6, 6, 6)
                        .addComponent(txt_Year4Std, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(345, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27)
                        .addComponent(txt_TotStud, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Std)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Std, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_TotStud, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Year1Std, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Year2Std, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Year3Std, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Year4Std, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54)
                            .addComponent(lbl_HG5)
                            .addComponent(jLabel57)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Registered Students", jPanel7);

        jPanel6.setBackground(new java.awt.Color(100, 149, 237));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total Registered Subjects");

        btn_Module.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Module.setText("Show Statistics");
        btn_Module.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Module.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModuleActionPerformed(evt);
            }
        });

        txt_TotSub.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_TotSub.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(":");

        tbl_module.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Offered Year", "Offered Sem", "Module Name", "Module Code", "Total Lec Hrs", "Total Tute Hrs", "Total Lab hrs", "Total Evalution Hrs"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tbl_module);
        if (tbl_module.getColumnModel().getColumnCount() > 0) {
            tbl_module.getColumnModel().getColumn(0).setPreferredWidth(15);
            tbl_module.getColumnModel().getColumn(1).setPreferredWidth(45);
            tbl_module.getColumnModel().getColumn(2).setHeaderValue("Offered Sem");
            tbl_module.getColumnModel().getColumn(3).setHeaderValue("Module Name");
            tbl_module.getColumnModel().getColumn(4).setHeaderValue("Module Code");
            tbl_module.getColumnModel().getColumn(5).setHeaderValue("Total Lec Hrs");
            tbl_module.getColumnModel().getColumn(6).setHeaderValue("Total Tute Hrs");
            tbl_module.getColumnModel().getColumn(7).setHeaderValue("Total Lab hrs");
            tbl_module.getColumnModel().getColumn(8).setHeaderValue("Total Evalution Hrs");
        }

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Year 1 Subjects");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText(":");

        txt_Year1Sub.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Year1Sub.setForeground(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Year 2 Subjects");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText(":");

        txt_Year2Sub.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Year2Sub.setForeground(new java.awt.Color(255, 255, 255));

        lbl_HG1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_HG1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_HG1.setText("Year 3 Subjects");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText(":");

        txt_Year3Sub.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Year3Sub.setForeground(new java.awt.Color(255, 255, 255));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Year 4 Subjects");

        txt_Year4Sub.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Year4Sub.setForeground(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText(":");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel23)
                        .addGap(6, 6, 6)
                        .addComponent(txt_Year1Sub, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel24)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel25)
                        .addGap(6, 6, 6)
                        .addComponent(txt_Year2Sub, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lbl_HG1)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel26)
                        .addGap(6, 6, 6)
                        .addComponent(txt_Year3Sub, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel27)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel28)
                        .addGap(6, 6, 6)
                        .addComponent(txt_Year4Sub, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(txt_TotSub, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Module)
                        .addGap(53, 53, 53))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Module, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_TotSub, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Year1Sub, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Year2Sub, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Year3Sub, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Year4Sub, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(lbl_HG1)
                                    .addComponent(jLabel27)))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Registered Subjects", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RoomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RoomsActionPerformed
        // TODO add your handling code here:
        int Count = Integer.parseInt(txt_Tot.getText());
        int lecRoomCount = Integer.parseInt(txt_TotLecRoom.getText());
        int labCount = Integer.parseInt(txt_TotLabs.getText());
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(Count, "Overall", "Overall");
        dataset.setValue(lecRoomCount, "Lecture Hall", "Lecture Hall");
        dataset.setValue(labCount, "Laboratory", "Laboratory");
        
        JFreeChart chart = ChartFactory.createBarChart3D("Locations", "Building Type", "Number Of Rooms", dataset, PlotOrientation.HORIZONTAL, true, true, true);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
        
        ChartFrame frame = new ChartFrame("Bar chart for Registered Rooms",chart);
        frame.setSize(450, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_btn_RoomsActionPerformed

    private void btn_ModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModuleActionPerformed
        int TotSubCount = Integer.parseInt(txt_TotSub.getText());
        int TotSubCountYear1 = Integer.parseInt(txt_Year1Sub.getText());
        int TotSubCountYear2 = Integer.parseInt(txt_Year2Sub.getText());
        int TotSubCountYear3 = Integer.parseInt(txt_Year3Sub.getText());
        int TotSubCountYear4 = Integer.parseInt(txt_Year4Sub.getText());
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(TotSubCount, "Overall", "Overall");
        dataset.setValue(TotSubCountYear1, "Year1", "Year1");
        dataset.setValue(TotSubCountYear2, "Year2", "Year2");
        dataset.setValue(TotSubCountYear3, "Year3", "Year3");
        dataset.setValue(TotSubCountYear4, "Year4", "Year4");
        
        JFreeChart chart = ChartFactory.createBarChart3D("Subjects", "Year", "Count", dataset, PlotOrientation.HORIZONTAL, true, true, true);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
        
        ChartFrame frame = new ChartFrame("Bar chart for Registered Modules",chart);
        frame.setSize(450, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_btn_ModuleActionPerformed

    private void btn_StdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_StdActionPerformed
        int TotStdCount = Integer.parseInt(txt_TotStud.getText());
        int TotStdCountY1 = Integer.parseInt(txt_Year1Std.getText());
        int TotStdCountY2 = Integer.parseInt(txt_Year2Std.getText());
        int TotStdCountY3 = Integer.parseInt(txt_Year3Std.getText());
        int TotStdCountY4 = Integer.parseInt(txt_Year4Std.getText());
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(TotStdCount, "Overall", "Overall");
        dataset.setValue(TotStdCountY1, "Year 1", "Year 1");
        dataset.setValue(TotStdCountY2, "Year 2", "Year 2");
        dataset.setValue(TotStdCountY3, "Year 3", "Year 3");
        dataset.setValue(TotStdCountY4, "Year 4", "Year 4");
        
        JFreeChart chart = ChartFactory.createBarChart3D("Students", "Student", "Count", dataset, PlotOrientation.HORIZONTAL, true, true, true);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
        
        ChartFrame frame = new ChartFrame("Bar chart for Locatios",chart);
        frame.setSize(450, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_btn_StdActionPerformed

    private void btn_Std1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Std1ActionPerformed
        int TotLecLecurerCount = Integer.parseInt(txt_TotLec.getText());
//        int LecurerCount1 = Integer.parseInt(txt_professor.getText());
//        int LecurerCount2 = Integer.parseInt(txt_Astprofessor.getText());
//        int LecurerCount3 = Integer.parseInt(txt_HG.getText());
//        int LecurerCount4 = Integer.parseInt(txt_seniorLec.getText());
//        int LecurerCount5 = Integer.parseInt(txt_lec.getText());
//        int LecurerCount6 = Integer.parseInt(txt_AsLec.getText());

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(TotLecLecurerCount, "Overall", "Overall");
//        dataset.setValue(LecurerCount1, "1", "1");
//        dataset.setValue(LecurerCount2, "2", "2");
//        dataset.setValue(LecurerCount3, "3", "3");
//        dataset.setValue(LecurerCount4, "4", "4");
//        dataset.setValue(LecurerCount5, "5", "5");
//        dataset.setValue(LecurerCount6, "6", "6");

        JFreeChart chart = ChartFactory.createBarChart3D("Lecturers", "Rank Number", "Count", dataset, PlotOrientation.HORIZONTAL, true, true, true);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);

        ChartFrame frame = new ChartFrame("Bar chart for Registered lecturers",chart);
        frame.setSize(450, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_btn_Std1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Module;
    private javax.swing.JButton btn_Rooms;
    private javax.swing.JButton btn_Std;
    private javax.swing.JButton btn_Std1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_HG1;
    private javax.swing.JLabel lbl_HG5;
    private javax.swing.JTable tbl_Locations;
    private javax.swing.JTable tbl_all_details;
    private javax.swing.JTable tbl_lec;
    private javax.swing.JTable tbl_module;
    private javax.swing.JLabel txt_Tot;
    private javax.swing.JLabel txt_TotLabs;
    private javax.swing.JLabel txt_TotLec;
    private javax.swing.JLabel txt_TotLecRoom;
    private javax.swing.JLabel txt_TotStud;
    private javax.swing.JLabel txt_TotSub;
    private javax.swing.JLabel txt_Year1Std;
    private javax.swing.JLabel txt_Year1Sub;
    private javax.swing.JLabel txt_Year2Std;
    private javax.swing.JLabel txt_Year2Sub;
    private javax.swing.JLabel txt_Year3Std;
    private javax.swing.JLabel txt_Year3Sub;
    private javax.swing.JLabel txt_Year4Std;
    private javax.swing.JLabel txt_Year4Sub;
    // End of variables declaration//GEN-END:variables

    public void showLecturerList() {
        LinkedHashMap hm = new LinkedHashMap();
        hm.put("id", "int");
        hm.put("name", "String");
        hm.put("emp_id", "String");
        hm.put("faculty", "String");
        hm.put("department", "String");
        hm.put("center", "String");
        hm.put("building", "String");
        hm.put("level", "String");
        hm.put("rank", "String");

        new LoadTable(tbl_lec, "SELECT * FROM lecturer", hm);
    }
    
    public void showRoomSList() {
        LinkedHashMap hm = new LinkedHashMap();
        hm.put("id", "int");
        hm.put("building", "String");
        hm.put("name", "String");
        hm.put("type", "String");

        new LoadTable(tbl_Locations, "SELECT * FROM room", hm);
    }
    public void showStdList() {
        LinkedHashMap hm = new LinkedHashMap();
        hm.put("id", "int");
        hm.put("yNs", "String");
        hm.put("dp", "String");
        hm.put("gNo", "String");
        hm.put("gId", "String");
        hm.put("sGid", "String");

        new LoadTable(tbl_all_details, "Select * from all_details", hm);
    }
    
    public void showModuleList() {
        LinkedHashMap hm = new LinkedHashMap();
        hm.put("id", "int");
        hm.put("offered_year", "String");
        hm.put("offered_semester", "String");
        hm.put("subject_name", "String");
        hm.put("subject_code", "String");
        hm.put("lec_hr", "String");
        hm.put("tute_hr", "String");
        hm.put("lab_hr", "String");
        hm.put("eva_hr", "String");

        new LoadTable(tbl_module, "Select * from subject", hm);
    }
    
    //getting total row count by passing query and colName
    public String getRowCount(String query, String colName) throws Exception{
        String tot = null;
        try {
            PreparedStatement ps = null;
            Connection connection = DBconnection.getConnection();
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tot = rs.getString(colName);
            }
        } catch (Exception e) {
            throw(e); 
        }     
        return tot;
    }
}
