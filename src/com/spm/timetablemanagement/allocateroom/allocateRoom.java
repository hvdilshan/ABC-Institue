/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spm.timetablemanagement.allocateroom;

import com.spm.timetablemanagement.util.DBconnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tiran Harsha
 */
public class allocateRoom extends javax.swing.JPanel {

    private String ID;
    private String Type;
    private String Sub;
    allocateProcess rp;
    private DefaultTableModel dtm;
    
    /**
     * Creates new form InsertWorkingHours
     */
    public allocateRoom() throws ClassNotFoundException {
        initComponents();
        rp = new allocateProcess();
        getRoom();
        getsubRoom();
        getgroupRoom();
        getlectRoom();
        getsessionRoom();
        getconssessionRoom();
        gettimeRoom();
        reset();
        
        try{
            Connection con = DBconnection.getConnection();
            Statement stat = con.createStatement();    
            String selectQuery="select Tag from tag";
            ResultSet rs=stat.executeQuery(selectQuery);
            while(rs.next())
            {
                tag.addItem(rs.getString("Tag"));
                t1.addItem(rs.getString("Tag"));
            }
                    
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
//-------------------------------------------------------------------------------------------------------
        try{
            
            Connection con = DBconnection.getConnection();
            Statement stat2 = con.createStatement();    
            String selectQuery="select name from room";
            ResultSet rs=stat2.executeQuery(selectQuery);
            while(rs.next())
            {
                room.addItem(rs.getString("name"));
                r1.addItem(rs.getString("name"));
                rfl_room.addItem(rs.getString("name"));
                rfg_room.addItem(rs.getString("name"));
                rfg_room1.addItem(rs.getString("name"));
                rfg_room2.addItem(rs.getString("name"));
                rroom.addItem(rs.getString("name"));
                
            }
                    
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
//-------------------------------------------------------------------------------------------------------
        try{
            Connection con = DBconnection.getConnection();
            Statement stat2 = con.createStatement();    
            String selectQuery="select subject_name from subject";
            ResultSet rs=stat2.executeQuery(selectQuery);
            while(rs.next())
            {
                sub1.addItem(rs.getString("subject_name"));
            }
                    
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
 //-------------------------------------------------------------------------------------------------------
        try{
            Connection con = DBconnection.getConnection();
            Statement stat2 = con.createStatement();    
            String selectQuery="select name from lecturer";
            ResultSet rs=stat2.executeQuery(selectQuery);
            while(rs.next())
            {
                rfl_lect.addItem(rs.getString("name"));
               
            }
                    
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }   
        
//-------------------------------------------------------------------------------------------------------
        try{
            Connection con = DBconnection.getConnection();
            Statement stat2 = con.createStatement();    
            String selectQuery="select gId from generated_group_id";
            ResultSet rs=stat2.executeQuery(selectQuery);
            while(rs.next())
            {
                rfg_group.addItem(rs.getString("gId"));
               
                
            }
                    
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }  

//-------------------------------------------------------------------------------------------------------
        try{
           Connection con = DBconnection.getConnection();
            Statement stat2 = con.createStatement();    
            String selectQuery="select id from session";
            ResultSet rs=stat2.executeQuery(selectQuery);
            while(rs.next())
            {
                rfg_group1.addItem(rs.getString("id"));
               
                
            }
                    
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
//-------------------------------------------------------------------------------------------------------
        try{
            Connection con = DBconnection.getConnection();
            Statement stat2 = con.createStatement();    
            String selectQuery="select id from sp2_consecutive_session";
            ResultSet rs=stat2.executeQuery(selectQuery);
            while(rs.next())
            {
                rfg_group2.addItem(rs.getString("id"));
               
                
            }
                    
        
        }
        catch(Exception e)
        {
            System.out.println(e);
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

        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        RoomsForTags = new javax.swing.JPanel();
        tag = new javax.swing.JComboBox<>();
        room = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lbl_Id = new javax.swing.JLabel();
        RoomsForSubNTags = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        r1 = new javax.swing.JComboBox<>();
        t1 = new javax.swing.JComboBox<>();
        sub1 = new javax.swing.JComboBox<>();
        add1 = new javax.swing.JButton();
        delete1 = new javax.swing.JButton();
        lbl_Id1 = new javax.swing.JLabel();
        RoomsForLecturers = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        add2 = new javax.swing.JButton();
        delete2 = new javax.swing.JButton();
        rfl_room = new javax.swing.JComboBox<>();
        rfl_lect = new javax.swing.JComboBox<>();
        lbl_Id4 = new javax.swing.JLabel();
        RoomsForGroups = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        add3 = new javax.swing.JButton();
        delete3 = new javax.swing.JButton();
        rfg_room = new javax.swing.JComboBox<>();
        rfg_group = new javax.swing.JComboBox<>();
        lbl_Id2 = new javax.swing.JLabel();
        RoomsForSession = new javax.swing.JPanel();
        rfg_room1 = new javax.swing.JComboBox<>();
        rfg_group1 = new javax.swing.JComboBox<>();
        add4 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        delete4 = new javax.swing.JButton();
        lbl_Id3 = new javax.swing.JLabel();
        RoomsForConsSession = new javax.swing.JPanel();
        add5 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        delete5 = new javax.swing.JButton();
        rfg_group2 = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        rfg_room2 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbl_Id5 = new javax.swing.JLabel();
        ReserveRooms = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        add6 = new javax.swing.JButton();
        rroom = new javax.swing.JComboBox<>();
        delete6 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        stime = new javax.swing.JTextField();
        etime = new javax.swing.JTextField();
        lbl_Id6 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(100, 149, 237));
        setPreferredSize(new java.awt.Dimension(1000, 689));

        jScrollPane8.setBorder(null);
        jScrollPane8.setPreferredSize(new java.awt.Dimension(1400, 1400));

        jPanel1.setBackground(new java.awt.Color(100, 149, 237));
        jPanel1.setToolTipText("");
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 910));

        RoomsForTags.setBackground(new java.awt.Color(100, 149, 237));
        RoomsForTags.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Allocate Rooms for Tags");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tag");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Room");

        add.setBackground(new java.awt.Color(0, 102, 0));
        add.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Allocate");
        add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(153, 0, 0));
        delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(100, 149, 237));
        jScrollPane2.setBorder(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Room", "Tag"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setMaximumSize(new java.awt.Dimension(225, 0));
        jTable1.setMinimumSize(new java.awt.Dimension(225, 0));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        lbl_Id.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout RoomsForTagsLayout = new javax.swing.GroupLayout(RoomsForTags);
        RoomsForTags.setLayout(RoomsForTagsLayout);
        RoomsForTagsLayout.setHorizontalGroup(
            RoomsForTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RoomsForTagsLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lbl_Id)
                .addGap(288, 288, 288)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(RoomsForTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RoomsForTagsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(RoomsForTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(RoomsForTagsLayout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addGroup(RoomsForTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tag, javax.swing.GroupLayout.Alignment.LEADING, 0, 160, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, RoomsForTagsLayout.createSequentialGroup()
                                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(room, javax.swing.GroupLayout.Alignment.LEADING, 0, 160, Short.MAX_VALUE))))
                    .addContainerGap(354, Short.MAX_VALUE)))
        );
        RoomsForTagsLayout.setVerticalGroup(
            RoomsForTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RoomsForTagsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(RoomsForTagsLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lbl_Id)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(RoomsForTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RoomsForTagsLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(RoomsForTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(RoomsForTagsLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(31, 31, 31)
                            .addGroup(RoomsForTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(tag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(29, 29, 29)
                            .addComponent(jLabel3))
                        .addComponent(room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(22, 22, 22)
                    .addGroup(RoomsForTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(40, Short.MAX_VALUE)))
        );

        RoomsForSubNTags.setBackground(new java.awt.Color(100, 149, 237));
        RoomsForSubNTags.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane3.setBorder(null);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tag", "Room", "Subject"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(255, 255, 255));
        jTable2.setMaximumSize(new java.awt.Dimension(225, 0));
        jTable2.setMinimumSize(new java.awt.Dimension(225, 0));
        jTable2.setPreferredSize(new java.awt.Dimension(225, 0));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Add Rooms for Subjects and Tags");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tag");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Room");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Subject");

        add1.setBackground(new java.awt.Color(0, 102, 0));
        add1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add1.setForeground(new java.awt.Color(255, 255, 255));
        add1.setText("Allocate");
        add1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        add1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });

        delete1.setBackground(new java.awt.Color(153, 0, 0));
        delete1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete1.setForeground(new java.awt.Color(255, 255, 255));
        delete1.setText("Delete");
        delete1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete1ActionPerformed(evt);
            }
        });

        lbl_Id1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout RoomsForSubNTagsLayout = new javax.swing.GroupLayout(RoomsForSubNTags);
        RoomsForSubNTags.setLayout(RoomsForSubNTagsLayout);
        RoomsForSubNTagsLayout.setHorizontalGroup(
            RoomsForSubNTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoomsForSubNTagsLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(RoomsForSubNTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RoomsForSubNTagsLayout.createSequentialGroup()
                        .addGroup(RoomsForSubNTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sub1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(lbl_Id1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RoomsForSubNTagsLayout.createSequentialGroup()
                        .addComponent(add1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(RoomsForSubNTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RoomsForSubNTagsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(RoomsForSubNTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7))
                    .addContainerGap(333, Short.MAX_VALUE)))
        );
        RoomsForSubNTagsLayout.setVerticalGroup(
            RoomsForSubNTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoomsForSubNTagsLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(r1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(sub1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_Id1)
                .addGap(18, 18, 18)
                .addGroup(RoomsForSubNTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RoomsForSubNTagsLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(33, 33, 33))
            .addGroup(RoomsForSubNTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RoomsForSubNTagsLayout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addComponent(jLabel4)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel6)
                    .addGap(26, 26, 26)
                    .addComponent(jLabel5)
                    .addGap(26, 26, 26)
                    .addComponent(jLabel7)
                    .addContainerGap(79, Short.MAX_VALUE)))
        );

        RoomsForLecturers.setBackground(new java.awt.Color(100, 149, 237));
        RoomsForLecturers.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Room", "Lecturer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setMaximumSize(new java.awt.Dimension(225, 0));
        jTable3.setMinimumSize(new java.awt.Dimension(225, 0));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable3);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Rooms for Lecturers");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Room");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Lecturer");

        add2.setBackground(new java.awt.Color(0, 102, 0));
        add2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add2.setForeground(new java.awt.Color(255, 255, 255));
        add2.setText("Allocate");
        add2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        add2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add2ActionPerformed(evt);
            }
        });

        delete2.setBackground(new java.awt.Color(153, 0, 0));
        delete2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete2.setForeground(new java.awt.Color(255, 255, 255));
        delete2.setText("Delete");
        delete2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete2ActionPerformed(evt);
            }
        });

        lbl_Id4.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout RoomsForLecturersLayout = new javax.swing.GroupLayout(RoomsForLecturers);
        RoomsForLecturers.setLayout(RoomsForLecturersLayout);
        RoomsForLecturersLayout.setHorizontalGroup(
            RoomsForLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoomsForLecturersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RoomsForLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RoomsForLecturersLayout.createSequentialGroup()
                        .addComponent(add2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rfl_lect, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(RoomsForLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RoomsForLecturersLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(RoomsForLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addGroup(RoomsForLecturersLayout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addComponent(rfl_room, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(427, Short.MAX_VALUE)))
            .addGroup(RoomsForLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RoomsForLecturersLayout.createSequentialGroup()
                    .addContainerGap(219, Short.MAX_VALUE)
                    .addComponent(lbl_Id4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(384, Short.MAX_VALUE)))
        );
        RoomsForLecturersLayout.setVerticalGroup(
            RoomsForLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoomsForLecturersLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RoomsForLecturersLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(RoomsForLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rfl_lect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RoomsForLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
            .addGroup(RoomsForLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RoomsForLecturersLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabel8)
                    .addGap(18, 18, 18)
                    .addGroup(RoomsForLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(rfl_room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(175, Short.MAX_VALUE)))
            .addGroup(RoomsForLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RoomsForLecturersLayout.createSequentialGroup()
                    .addContainerGap(96, Short.MAX_VALUE)
                    .addComponent(lbl_Id4)
                    .addContainerGap(97, Short.MAX_VALUE)))
        );

        RoomsForGroups.setBackground(new java.awt.Color(100, 149, 237));
        RoomsForGroups.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Rooms for Groups");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Room", "Group"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setMaximumSize(new java.awt.Dimension(225, 0));
        jTable4.setMinimumSize(new java.awt.Dimension(225, 0));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Room");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Group");

        add3.setBackground(new java.awt.Color(0, 102, 0));
        add3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add3.setForeground(new java.awt.Color(255, 255, 255));
        add3.setText("Allocate");
        add3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        add3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add3ActionPerformed(evt);
            }
        });

        delete3.setBackground(new java.awt.Color(153, 0, 0));
        delete3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete3.setForeground(new java.awt.Color(255, 255, 255));
        delete3.setText("Delete");
        delete3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        delete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete3ActionPerformed(evt);
            }
        });

        lbl_Id2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout RoomsForGroupsLayout = new javax.swing.GroupLayout(RoomsForGroups);
        RoomsForGroups.setLayout(RoomsForGroupsLayout);
        RoomsForGroupsLayout.setHorizontalGroup(
            RoomsForGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoomsForGroupsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RoomsForGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RoomsForGroupsLayout.createSequentialGroup()
                        .addGroup(RoomsForGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(33, 33, 33)
                        .addGroup(RoomsForGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rfg_group, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rfg_room, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(RoomsForGroupsLayout.createSequentialGroup()
                                .addComponent(add3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(delete3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Id2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        RoomsForGroupsLayout.setVerticalGroup(
            RoomsForGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoomsForGroupsLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(RoomsForGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(RoomsForGroupsLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(21, 21, 21)
                        .addGroup(RoomsForGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(rfg_room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(RoomsForGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RoomsForGroupsLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(RoomsForGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(rfg_group, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(RoomsForGroupsLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_Id2)))
                        .addGap(31, 31, 31)
                        .addGroup(RoomsForGroupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );

        RoomsForSession.setBackground(new java.awt.Color(100, 149, 237));
        RoomsForSession.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RoomsForSession.setPreferredSize(new java.awt.Dimension(200, 222));

        add4.setBackground(new java.awt.Color(0, 102, 0));
        add4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add4.setForeground(new java.awt.Color(255, 255, 255));
        add4.setText("Allocate");
        add4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        add4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add4ActionPerformed(evt);
            }
        });

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Room", "Session"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.setMaximumSize(new java.awt.Dimension(225, 0));
        jTable5.setMinimumSize(new java.awt.Dimension(225, 0));
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Room");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Rooms for Session");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Session");

        delete4.setBackground(new java.awt.Color(153, 0, 0));
        delete4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete4.setForeground(new java.awt.Color(255, 255, 255));
        delete4.setText("Delete");
        delete4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        delete4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete4ActionPerformed(evt);
            }
        });

        lbl_Id3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout RoomsForSessionLayout = new javax.swing.GroupLayout(RoomsForSession);
        RoomsForSession.setLayout(RoomsForSessionLayout);
        RoomsForSessionLayout.setHorizontalGroup(
            RoomsForSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoomsForSessionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RoomsForSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RoomsForSessionLayout.createSequentialGroup()
                        .addGroup(RoomsForSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(33, 33, 33)
                        .addGroup(RoomsForSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rfg_group1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rfg_room1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(RoomsForSessionLayout.createSequentialGroup()
                                .addComponent(add4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(delete4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(lbl_Id3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        RoomsForSessionLayout.setVerticalGroup(
            RoomsForSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoomsForSessionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RoomsForSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(RoomsForSessionLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(21, 21, 21)
                        .addGroup(RoomsForSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(rfg_room1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(RoomsForSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RoomsForSessionLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(RoomsForSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(rfg_group1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbl_Id3))
                        .addGap(18, 18, 18)
                        .addGroup(RoomsForSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(59, 59, 59))
        );

        RoomsForConsSession.setBackground(new java.awt.Color(100, 149, 237));
        RoomsForConsSession.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RoomsForConsSession.setPreferredSize(new java.awt.Dimension(300, 209));

        add5.setBackground(new java.awt.Color(0, 102, 0));
        add5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add5.setForeground(new java.awt.Color(255, 255, 255));
        add5.setText("Allocate");
        add5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        add5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add5ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Rooms for Cons.Sessions");

        delete5.setBackground(new java.awt.Color(153, 0, 0));
        delete5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete5.setForeground(new java.awt.Color(255, 255, 255));
        delete5.setText("Delete");
        delete5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        delete5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete5ActionPerformed(evt);
            }
        });

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Room", "Cons.Session"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.setMaximumSize(new java.awt.Dimension(225, 0));
        jTable6.setMinimumSize(new java.awt.Dimension(225, 0));
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable6);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Room");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Cons.Session");

        lbl_Id5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout RoomsForConsSessionLayout = new javax.swing.GroupLayout(RoomsForConsSession);
        RoomsForConsSession.setLayout(RoomsForConsSessionLayout);
        RoomsForConsSessionLayout.setHorizontalGroup(
            RoomsForConsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoomsForConsSessionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RoomsForConsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RoomsForConsSessionLayout.createSequentialGroup()
                        .addGroup(RoomsForConsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19))
                        .addGap(33, 33, 33)
                        .addGroup(RoomsForConsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rfg_group2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rfg_room2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(RoomsForConsSessionLayout.createSequentialGroup()
                                .addComponent(add5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(delete5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(RoomsForConsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RoomsForConsSessionLayout.createSequentialGroup()
                    .addContainerGap(180, Short.MAX_VALUE)
                    .addComponent(lbl_Id5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(511, Short.MAX_VALUE)))
        );
        RoomsForConsSessionLayout.setVerticalGroup(
            RoomsForConsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoomsForConsSessionLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(RoomsForConsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(RoomsForConsSessionLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(21, 21, 21)
                        .addGroup(RoomsForConsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(rfg_room2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(RoomsForConsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(rfg_group2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(RoomsForConsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38))
            .addGroup(RoomsForConsSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RoomsForConsSessionLayout.createSequentialGroup()
                    .addContainerGap(126, Short.MAX_VALUE)
                    .addComponent(lbl_Id5)
                    .addContainerGap(127, Short.MAX_VALUE)))
        );

        ReserveRooms.setBackground(new java.awt.Color(100, 149, 237));
        ReserveRooms.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Room");

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Reserve Rooms");

        add6.setBackground(new java.awt.Color(0, 102, 0));
        add6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add6.setForeground(new java.awt.Color(255, 255, 255));
        add6.setText("Allocate");
        add6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        add6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add6ActionPerformed(evt);
            }
        });

        delete6.setBackground(new java.awt.Color(153, 0, 0));
        delete6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete6.setForeground(new java.awt.Color(255, 255, 255));
        delete6.setText("Delete");
        delete6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        delete6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete6ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Start Time");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("End Time");

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Room", "Start", "End"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable7);

        stime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stimeActionPerformed(evt);
            }
        });

        etime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etimeActionPerformed(evt);
            }
        });

        lbl_Id6.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout ReserveRoomsLayout = new javax.swing.GroupLayout(ReserveRooms);
        ReserveRooms.setLayout(ReserveRoomsLayout);
        ReserveRoomsLayout.setHorizontalGroup(
            ReserveRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReserveRoomsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Id6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ReserveRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ReserveRoomsLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(add6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ReserveRoomsLayout.createSequentialGroup()
                        .addGroup(ReserveRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(62, 62, 62)
                        .addGroup(ReserveRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etime, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stime, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel20)
                    .addGroup(ReserveRoomsLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(88, 88, 88)
                        .addComponent(rroom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(461, 461, 461))
        );
        ReserveRoomsLayout.setVerticalGroup(
            ReserveRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReserveRoomsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ReserveRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ReserveRoomsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ReserveRoomsLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ReserveRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(rroom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ReserveRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(stime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Id6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ReserveRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ReserveRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RoomsForLecturers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RoomsForSubNTags, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RoomsForTags, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RoomsForSession, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                                    .addComponent(RoomsForConsSession, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(RoomsForGroups, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ReserveRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(811, 811, 811)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(5, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RoomsForTags, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(RoomsForGroups, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RoomsForSession, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(RoomsForSubNTags, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RoomsForLecturers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RoomsForConsSession, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ReserveRooms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        jScrollPane8.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        try {
            addRoom();
            
        } catch (SQLException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        getRoom();
       
    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        deleteRoom();
        getRoom();
         
    }//GEN-LAST:event_deleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        tableClicked();
    }//GEN-LAST:event_jTable1MouseClicked

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        try {
            addsubRoom();
        } catch (SQLException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        getsubRoom();
    }//GEN-LAST:event_add1ActionPerformed

    private void delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete1ActionPerformed
        deletesubRoom();
        getsubRoom();
    }//GEN-LAST:event_delete1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        tableClicked1();
    }//GEN-LAST:event_jTable2MouseClicked

    private void add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add2ActionPerformed
        try {
            addlectRoom();
        } catch (SQLException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        getlectRoom();
    }//GEN-LAST:event_add2ActionPerformed

    private void delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete2ActionPerformed
        deletelectRoom();
        getlectRoom();
    }//GEN-LAST:event_delete2ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        tableClickedgroup();
    }//GEN-LAST:event_jTable4MouseClicked

    private void add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add3ActionPerformed
        
        try {
            addgroupRoom();
        } catch (SQLException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        getgroupRoom();
    }//GEN-LAST:event_add3ActionPerformed

    private void delete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete3ActionPerformed
        deletegroupRoom();
        getgroupRoom();
    }//GEN-LAST:event_delete3ActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        tableClickedsession();
    }//GEN-LAST:event_jTable5MouseClicked

    private void add4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add4ActionPerformed
        try {
          addsessionRoom();  
            
            
        } catch (SQLException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        getsessionRoom();
    }//GEN-LAST:event_add4ActionPerformed

    private void delete4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete4ActionPerformed
        deletesessionRoom();
        getsessionRoom();
    }//GEN-LAST:event_delete4ActionPerformed

    private void add5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add5ActionPerformed
        try {
//            if(rfg_room2.getSelectedItem().toString().isEmpty() && rfg_group2.getSelectedItem().toString().isEmpty()){
//                JOptionPane.showMessageDialog(null, "Please Select Room & Cons.Session", "Reserve Rooms", JOptionPane.ERROR_MESSAGE);
//            } else{
                addconssessionRoom();
//            }
        } catch (SQLException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        getconssessionRoom();
    }//GEN-LAST:event_add5ActionPerformed

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        tableClickedconssession();
    }//GEN-LAST:event_jTable6MouseClicked

    private void delete5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete5ActionPerformed
        deleteconssessionRoom();
        getconssessionRoom();
    }//GEN-LAST:event_delete5ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        tableClickedlect();
    }//GEN-LAST:event_jTable3MouseClicked

    private void add6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add6ActionPerformed
        if(rroom.getSelectedItem().toString().isEmpty() && stime.getText().isEmpty() && etime.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Please Enter All Details", "Reserve Rooms", JOptionPane.ERROR_MESSAGE);
        }else {
            try {
                addtimeRoom();
            } catch (SQLException ex) {
                Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        gettimeRoom();
    }//GEN-LAST:event_add6ActionPerformed

    private void delete6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete6ActionPerformed
        deletetimeRoom();
        gettimeRoom();
    }//GEN-LAST:event_delete6ActionPerformed

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        tableClickedtime();
    }//GEN-LAST:event_jTable7MouseClicked

    private void stimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stimeActionPerformed

    private void etimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etimeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ReserveRooms;
    private javax.swing.JPanel RoomsForConsSession;
    private javax.swing.JPanel RoomsForGroups;
    private javax.swing.JPanel RoomsForLecturers;
    private javax.swing.JPanel RoomsForSession;
    private javax.swing.JPanel RoomsForSubNTags;
    private javax.swing.JPanel RoomsForTags;
    private javax.swing.JButton add;
    private javax.swing.JButton add1;
    private javax.swing.JButton add2;
    private javax.swing.JButton add3;
    private javax.swing.JButton add4;
    private javax.swing.JButton add5;
    private javax.swing.JButton add6;
    private javax.swing.JButton delete;
    private javax.swing.JButton delete1;
    private javax.swing.JButton delete2;
    private javax.swing.JButton delete3;
    private javax.swing.JButton delete4;
    private javax.swing.JButton delete5;
    private javax.swing.JButton delete6;
    private javax.swing.JTextField etime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JLabel lbl_Id;
    private javax.swing.JLabel lbl_Id1;
    private javax.swing.JLabel lbl_Id2;
    private javax.swing.JLabel lbl_Id3;
    private javax.swing.JLabel lbl_Id4;
    private javax.swing.JLabel lbl_Id5;
    private javax.swing.JLabel lbl_Id6;
    private javax.swing.JComboBox<String> r1;
    private javax.swing.JComboBox<String> rfg_group;
    private javax.swing.JComboBox<String> rfg_group1;
    private javax.swing.JComboBox<String> rfg_group2;
    private javax.swing.JComboBox<String> rfg_room;
    private javax.swing.JComboBox<String> rfg_room1;
    private javax.swing.JComboBox<String> rfg_room2;
    private javax.swing.JComboBox<String> rfl_lect;
    private javax.swing.JComboBox<String> rfl_room;
    private javax.swing.JComboBox<String> room;
    private javax.swing.JComboBox<String> rroom;
    private javax.swing.JTextField stime;
    private javax.swing.JComboBox<String> sub1;
    private javax.swing.JComboBox<String> t1;
    private javax.swing.JComboBox<String> tag;
    // End of variables declaration//GEN-END:variables

//--------------------------------------------------------------------------------------
       public void addRoom() throws SQLException, ClassNotFoundException, IOException{
        String STag = tag.getSelectedItem().toString();
        String SRoom = room.getSelectedItem().toString();
        String query = "Select id FROM roomsForATag WHERE tag = ? AND room = ?";
        String colName = "id";
        
        if (STag.isEmpty() || SRoom.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select details");
        }else if(isExist(STag, SRoom, query, colName)){
            JOptionPane.showMessageDialog(null, "Already Reserved This Room!", "Validation", JOptionPane.ERROR_MESSAGE);
        }else{
        
            try {
                ID = STag;
                Type = SRoom;
                rp.addRoom(ID, Type);
                JOptionPane.showMessageDialog(this, "Successfully Added");
            } catch (SQLException ex) {
                Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error");
            }
        }
    }

    
    public void deleteRoom(){
        String id = lbl_Id.getText().toString();
        String STag = tag.getSelectedItem().toString();
        
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select Row The You Want To Delete!");
        }else{
                
            try {
                ID = id;
                
                rp.deleteRoom(ID);
                JOptionPane.showMessageDialog(this, "Deleted!");
                reset();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Failed!");
                Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
   
    

    
    public void getRoom(){
        try {
            dtm = (DefaultTableModel)jTable1.getModel();
            dtm.setRowCount(0);
            rp.getRoom(dtm);
            jTable1.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tableClicked(){
        
        
        
       lbl_Id.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
       tag.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
       room.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
    }
    
//--------------------------------------------------------------------------------------
       public void addsubRoom() throws SQLException, ClassNotFoundException, IOException{
        String STag = t1.getSelectedItem().toString();
        String SRoom = r1.getSelectedItem().toString();
        String SSub = sub1.getSelectedItem().toString();
        String query = "Select id FROM roomssubtags WHERE tag = ? AND room = ? AND subject = ? ";
        String colName = "id";
        
        if (STag.isEmpty() || SRoom.isEmpty() || SSub.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select details");
        }else if(isExist1(STag, SRoom, SSub, query, colName)){
            JOptionPane.showMessageDialog(null, "Already Reserved This Room!", "Validation", JOptionPane.ERROR_MESSAGE);
        }else{
        
            try {
                ID = STag;
                Type = SRoom;
                Sub = SSub;
                rp.addsubRoom(ID, Type, Sub);
                JOptionPane.showMessageDialog(this, "Successfully Added");
            } catch (SQLException ex) {
                Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error");
            }
        }
    }

    
    public void deletesubRoom(){
        String STag = t1.getSelectedItem().toString();
        String SRoom = r1.getSelectedItem().toString();
        String SSub = sub1.getSelectedItem().toString();
        String id = lbl_Id1.getText();
        
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select Row The You Want To Delete!");
        }else{
                
            try {
                ID = id;
                Type = SRoom;
                Sub = SSub;
                
                rp.deletesubRoom(ID);
                JOptionPane.showMessageDialog(this, "Deleted!");
                reset();
                getsubRoom();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Failed!");
                Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    

    

    
    public void getsubRoom(){
        try {
            dtm = (DefaultTableModel)jTable2.getModel();
            dtm.setRowCount(0);
            rp.getsubRoom(dtm);
            jTable2.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tableClicked1(){
       lbl_Id1.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString());
       t1.setSelectedItem(jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString());
       r1.setSelectedItem(jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString());
       sub1.setSelectedItem(jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString());
       
    }
    
    
//--------------------------------------------------------------------------------------
       public void addlectRoom() throws SQLException, ClassNotFoundException, IOException{
        String STag = rfl_room.getSelectedItem().toString();
        String SRoom = rfl_lect.getSelectedItem().toString();
        String query = "Select id FROM roomsforlecturer WHERE room = ? AND lecturer = ? ";
        String colName = "id";
        
        if (STag.isEmpty() || SRoom.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select details");
        }else if(isExist(STag, SRoom, query, colName)){
            JOptionPane.showMessageDialog(null, "Already Reserved This Room!", "Validation", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                ID = STag;
                Type = SRoom;
                rp.addlectRoom(ID, Type);
                JOptionPane.showMessageDialog(this, "Successfully Added");
            } catch (SQLException ex) {
                Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error");
            }
        }
    }
  
    public void deletelectRoom(){
        String STag = rfl_room.getSelectedItem().toString();
        String SRoom = rfl_lect.getSelectedItem().toString();
        String id = lbl_Id4.getText();
        
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select Row The You Want To Delete!");
        }else{
                
            try {
                ID = id;
                Type = SRoom;
                
                rp.deletelectRoom(ID);
                JOptionPane.showMessageDialog(this, "Deleted!");
                reset();
                getlectRoom();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Failed!");
                Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
    public void getlectRoom(){
        try {
            dtm = (DefaultTableModel)jTable3.getModel();
            dtm.setRowCount(0);
            rp.getlectRoom(dtm);
            jTable3.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tableClickedlect(){
       lbl_Id4.setText(jTable3.getValueAt(jTable3.getSelectedRow(), 0).toString());
       rfl_room.setSelectedItem(jTable3.getValueAt(jTable3.getSelectedRow(), 1).toString());
       rfl_lect.setSelectedItem(jTable3.getValueAt(jTable3.getSelectedRow(), 2).toString());
    }
    
//--------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------
       public void addgroupRoom() throws SQLException, ClassNotFoundException, IOException{
        String STag = rfg_room.getSelectedItem().toString();
        String SRoom = rfg_group.getSelectedItem().toString();
        String query = "Select id FROM roomsforgroup WHERE room = ? AND groups = ?";
        String colName = "id";
        
        if (STag.isEmpty() || SRoom.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select details");
        }else if(isExist(STag, SRoom, query, colName)){
            JOptionPane.showMessageDialog(null, "Already Reserved This Room!", "Validation", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                ID = STag;
                Type = SRoom;
                rp.addgroupRoom(ID, Type);
                JOptionPane.showMessageDialog(this, "Successfully Added");
            } catch (SQLException ex) {
                Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error");
            }
        }
    }
  
    public void deletegroupRoom(){
        String STag = rfg_room.getSelectedItem().toString();
        String SRoom = rfg_group.getSelectedItem().toString();
        String id = lbl_Id2.getText();
        
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select Row The You Want To Delete!");
        }else{
                
            try {
                ID = id;
                Type = SRoom;
                
                rp.deletegroupRoom(ID);
                JOptionPane.showMessageDialog(this, "Deleted!");
                reset();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Failed!");
                Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
    public void getgroupRoom(){
        try {
            dtm = (DefaultTableModel)jTable4.getModel();
            dtm.setRowCount(0);
            rp.getgroupRoom(dtm);
            jTable4.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tableClickedgroup(){
       lbl_Id2.setText(jTable4.getValueAt(jTable4.getSelectedRow(), 0).toString());
       rfg_room.setSelectedItem(jTable4.getValueAt(jTable4.getSelectedRow(), 1).toString());
       rfg_group.setSelectedItem(jTable4.getValueAt(jTable4.getSelectedRow(), 2).toString());
    }
    
//--------------------------------------------------------------------------------------
    
//--------------------------------------------------------------------------------------
       public void addsessionRoom() throws SQLException, ClassNotFoundException, IOException{
        String STag = rfg_room1.getSelectedItem().toString();
        String SRoom = rfg_group1.getSelectedItem().toString();
        String query = "Select id FROM roomsforsession WHERE room = ? AND session = ? ";
        String colName = "id";
        
        if (STag.isEmpty() || SRoom.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select details");
        }else if(isExist(STag, SRoom, query, colName)){
            JOptionPane.showMessageDialog(null, "Already Reserved This Room!", "Validation", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                ID = STag;
                Type = SRoom;
                rp.addsesRoom(ID, Type);
                JOptionPane.showMessageDialog(this, "Successfully Added");
            } catch (SQLException ex) {
                Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error");
            }
        }
    }
  
    public void deletesessionRoom(){
        String STag = rfg_room1.getSelectedItem().toString();
        String SRoom = rfg_group1.getSelectedItem().toString();
        String id = lbl_Id3.getText();
        
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select Row The You Want To Delete!");
        }else{
                
            try {
                ID = id;
                Type = SRoom;
                
                rp.deletesesRoom(ID);
                JOptionPane.showMessageDialog(this, "Deleted!");
                reset();
                getsessionRoom();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Failed!");
                Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
    public void getsessionRoom(){
        try {
            dtm = (DefaultTableModel)jTable5.getModel();
            dtm.setRowCount(0);
            rp.getsesRoom(dtm);
            jTable5.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tableClickedsession(){
       lbl_Id3.setText(jTable5.getValueAt(jTable5.getSelectedRow(), 0).toString());
       rfg_room1.setSelectedItem(jTable5.getValueAt(jTable5.getSelectedRow(), 1).toString());
       rfg_group1.setSelectedItem(jTable5.getValueAt(jTable5.getSelectedRow(), 2).toString());
    }
//--------------------------------------------------------------------------------------
       public void addconssessionRoom() throws SQLException, ClassNotFoundException, IOException{
        String STag = rfg_room2.getSelectedItem().toString();
        String SRoom = rfg_group2.getSelectedItem().toString();
        String query = "Select id FROM roomsforconssession WHERE room = ? AND consSession = ? ";
        String colName = "id";
        
        if (STag.isEmpty() || SRoom.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select details");
        }else if(isExist(STag, SRoom, query, colName)){
            JOptionPane.showMessageDialog(null, "Already Reserved This Room!", "Validation", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                ID = STag;
                Type = SRoom;
                rp.addcsesRoom(ID, Type);
                JOptionPane.showMessageDialog(this, "Successfully Added");
            } catch (SQLException ex) {
                Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error");
            }
        }
    }
  
    public void deleteconssessionRoom(){
        String STag = rfg_room2.getSelectedItem().toString();
        String SRoom = rfg_group2.getSelectedItem().toString();
        String id = lbl_Id5.getText();
        
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select Row The You Want To Delete!");
        }else{
                
            try {
                ID = id;
                Type = SRoom;
                
                rp.deletecsesRoom(ID);
                JOptionPane.showMessageDialog(this, "Deleted!");
                reset();
                getconssessionRoom();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Failed!");
                Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
    public void getconssessionRoom(){
        try {
            dtm = (DefaultTableModel)jTable6.getModel();
            dtm.setRowCount(0);
            rp.getcsesRoom(dtm);
            jTable6.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tableClickedconssession(){
       lbl_Id5.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 0).toString());
       rfg_room2.setSelectedItem(jTable6.getValueAt(jTable6.getSelectedRow(), 1).toString());
       rfg_group2.setSelectedItem(jTable6.getValueAt(jTable6.getSelectedRow(), 2).toString());
    }
  
//--------------------------------------------------------------------------------------
       public void addtimeRoom() throws SQLException, ClassNotFoundException, IOException{
        String STag = rroom.getSelectedItem().toString();
        Type = stime.getText();
        Sub = etime.getText();
        String query = "Select id FROM reservedrooms WHERE room = ? AND stime = ? AND etime = ?";
        String colName = "id";
        
        if (STag.isEmpty() || stime.getText().isEmpty() || etime.getText().isEmpty() ){
            JOptionPane.showMessageDialog(this, "Please Select details");
        }else if(isExist1(STag, Type, Sub, query, colName)){
            JOptionPane.showMessageDialog(null, "Already Reserved This Room!", "Validation", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                ID = STag;
                
                
                rp.addtimeRoom(ID, Type, Sub);
                JOptionPane.showMessageDialog(this, "Successfully Added");
            } catch (SQLException ex) {
                Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error");
            }
        }
    }

    
    public void deletetimeRoom(){
        String STag = rroom.getSelectedItem().toString();
        String id = lbl_Id6.getText();
        
        
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select Row The You Want To Delete!");
        }else{
                
            try {
                ID = id;
                if(id == ""){
                    
                }
                Type = stime.getText();
                Sub = etime.getText();
                
                rp.deletetimeRoom(ID);
                JOptionPane.showMessageDialog(this, "Deleted!");
                reset();
                gettimeRoom();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Failed!");
                Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void gettimeRoom(){
        try {
            dtm = (DefaultTableModel)jTable7.getModel();
            dtm.setRowCount(0);
            rp.gettimeRoom(dtm);
            jTable7.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(allocateRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tableClickedtime(){
       lbl_Id6.setText(jTable7.getValueAt(jTable7.getSelectedRow(), 0).toString());
       rroom.setSelectedItem(jTable7.getValueAt(jTable7.getSelectedRow(), 1).toString());
       stime.setText(jTable7.getValueAt(jTable7.getSelectedRow(), 2).toString());
       etime.setText(jTable7.getValueAt(jTable7.getSelectedRow(), 3).toString());
       
    }
    
    /*
     check whether any location is exist by passing  query,id & Column name
     */
    public boolean isExist(String col1, String col2, String query, String colName) throws SQLException, ClassNotFoundException, IOException {
        
        Connection connection = DBconnection.getConnection();
        PreparedStatement ps = null;
        
        boolean isAvailable = false;
        
        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, col1);
            ps.setString(2, col2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (!rs.getString(colName).isEmpty()) {
                isAvailable = true;
            }
//                
            }
        } catch (SQLException ex) {
            throw ex;
        }finally {
            try {
                if(ps != null){
                    ps.close();
                }
            } catch (Exception ex) {
                throw ex;
            }
            
        }
        return isAvailable;
    }
    
    public boolean isExist1(String col1, String col2, String col3, String query, String colName) throws SQLException, ClassNotFoundException, IOException {
        
        Connection connection = DBconnection.getConnection();
        PreparedStatement ps = null;
        
        boolean isAvailable = false;
        
        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, col1);
            ps.setString(2, col2);
            ps.setString(3, col3);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (!rs.getString(colName).isEmpty()) {
                isAvailable = true;
            }
//                
            }
        } catch (SQLException ex) {
            throw ex;
        }finally {
            try {
                if(ps != null){
                    ps.close();
                }
            } catch (Exception ex) {
                throw ex;
            }
            
        }
        return isAvailable;
    }
    
    public void reset(){
        lbl_Id.setText("");
        lbl_Id1.setText("");
        lbl_Id2.setText("");
        lbl_Id3.setText("");
        lbl_Id4.setText("");
        lbl_Id5.setText("");
        lbl_Id6.setText("");
        stime.setText("");
        etime.setText("");
        
        lbl_Id.setVisible(false);
        lbl_Id1.setVisible(false);
        lbl_Id2.setVisible(false);
        lbl_Id3.setVisible(false);
        lbl_Id4.setVisible(false);
        lbl_Id5.setVisible(false);
        lbl_Id6.setVisible(false);
    }
}
