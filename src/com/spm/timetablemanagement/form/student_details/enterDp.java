/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spm.timetablemanagement.form.student_details;

import com.spm.timetablemanagement.models.degreeProgram;
import com.spm.timetablemanagement.util.Constant;
import com.spm.timetablemanagement.util.CreateQuery;
import com.spm.timetablemanagement.util.DBconnection;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author hvdil
 */
public class enterDp extends javax.swing.JPanel {

    private Connection connection;
    private int dpId;
    PreparedStatement pstDp;
    ResultSet rs;
    /**
     * Creates new form enterDp
     */
    public enterDp() {
        initComponents();
        showDPList();
        txt_id.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_dp = new javax.swing.JTextField();
        txt_error = new javax.swing.JLabel();
        btn_addDp = new javax.swing.JButton();
        btn_editDp = new javax.swing.JButton();
        btn_deleteDp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Dp = new javax.swing.JTable();
        txt_id = new javax.swing.JTextField();

        setBackground(new java.awt.Color(100, 149, 237));
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(100, 149, 237));
        jPanel1.setToolTipText("");

        jPanel2.setBackground(new java.awt.Color(100, 149, 237));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Enter Degree Program");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txt_dp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_dp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dpActionPerformed(evt);
            }
        });

        txt_error.setForeground(new java.awt.Color(255, 0, 0));
        txt_error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_addDp.setBackground(new java.awt.Color(0, 102, 255));
        btn_addDp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_addDp.setForeground(new java.awt.Color(255, 255, 255));
        btn_addDp.setText("Insert");
        btn_addDp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_addDp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_addDp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addDpActionPerformed(evt);
            }
        });

        btn_editDp.setBackground(new java.awt.Color(0, 102, 255));
        btn_editDp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_editDp.setForeground(new java.awt.Color(255, 255, 255));
        btn_editDp.setText("Update");
        btn_editDp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_editDp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editDpActionPerformed(evt);
            }
        });

        btn_deleteDp.setBackground(new java.awt.Color(153, 0, 0));
        btn_deleteDp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_deleteDp.setForeground(java.awt.Color.white);
        btn_deleteDp.setText("Delete");
        btn_deleteDp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_deleteDp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteDpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_dp, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(240, 240, 240))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_addDp, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btn_editDp, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btn_deleteDp, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_error, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_dp, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(txt_error, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_addDp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_editDp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_deleteDp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tbl_Dp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_Dp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Degree Program"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Dp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbl_Dp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Dp);
        if (tbl_Dp.getColumnModel().getColumnCount() > 0) {
            tbl_Dp.getColumnModel().getColumn(0).setResizable(false);
            tbl_Dp.getColumnModel().getColumn(1).setResizable(false);
        }

        txt_id.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(868, 868, 868))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(299, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_dpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dpActionPerformed

    private void btn_addDpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addDpActionPerformed
        // TODO add your handling code here:
        try{
            DefaultTableModel model = (DefaultTableModel)tbl_Dp.getModel();
            Connection connection = DBconnection.getConnection();
            
            if(txt_dp.getText().equals("")){
                txt_error.setText("Enter Degree Program*");
            }
            else{
                txt_error.setText("");

            PreparedStatement statement = connection.prepareStatement(CreateQuery.getQuery(Constant.INSERT_DEGREE_PROGRAM_TABLE));

            statement.setString(1, txt_dp.getText().toUpperCase());

            statement.executeUpdate();
            model.setRowCount(0);
            showDPList();
            txt_dp.setText("");
            JOptionPane.showMessageDialog(null, "Inserting Successful!");
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btn_addDpActionPerformed

    private void tbl_DpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DpMouseClicked
        // TODO add your handling code here:
         int i = tbl_Dp.getSelectedRow();
        TableModel model = tbl_Dp.getModel();
        txt_id.setText(model.getValueAt(i, 0).toString());
        txt_dp.setText(model.getValueAt(i, 1).toString());
    }//GEN-LAST:event_tbl_DpMouseClicked

    private void btn_editDpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editDpActionPerformed
        // TODO add your handling code here:
        String id = txt_id.getText();

        try
        {
            DefaultTableModel model = (DefaultTableModel)tbl_Dp.getModel();
            Statement smt = connection.createStatement();
            
            if(txt_dp.getText().equals("")){
                txt_error.setText("Select Degree Program*");
            }
            else{
                txt_error.setText("");
                
            smt.execute("UPDATE degree_program SET dp = '"+txt_dp.getText().toUpperCase()+"' WHERE id = "+id); 
            model.setRowCount(0);
            showDPList();
            txt_dp.setText("");
            JOptionPane.showMessageDialog(this, "Record Updated!");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_editDpActionPerformed

    private void btn_deleteDpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteDpActionPerformed
        // TODO add your handling code here:
        
        String id = txt_id.getText();
        int whileWorking = 0;

        try
        {
            DefaultTableModel model = (DefaultTableModel)tbl_Dp.getModel();
            Statement smt = connection.createStatement();
            
            if(txt_dp.getText().equals("")){
                txt_error.setText("Select Degree Program*");
            }
            else{
                txt_error.setText("");
             
            
            String getDpQuery = "select gId from generated_group_id WHERE dpId = '"+id+"'";
            pstDp = connection.prepareStatement(getDpQuery);
            rs = pstDp.executeQuery();
            while(rs.next())
            {    

                    int x = JOptionPane.showConfirmDialog(this,"You have this related data,is it ok?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (x == 0){
                        ResultSet rs = smt.executeQuery("select id from generated_group_id where dpId = "+id);
                        String id_G="";
                        while(rs.next()){
                            id_G = rs.getString(1);
                            System.out.println(id_G);
                        }
                        smt.execute("DELETE FROM generated_sub_group_id WHERE gId = '"+id_G+"'");
                        smt.execute("DELETE FROM generated_group_id WHERE dpId = "+id); 
                        smt.execute("DELETE FROM degree_program WHERE id = "+id);
                        smt.execute("DELETE FROM all_details WHERE dp = '"+txt_dp.getText().toString()+"'");
                        
                        JOptionPane.showMessageDialog(this, "Record Deleted!");

                        
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Delete Canceled!");
                        
                    }
                    whileWorking++;
                
            }
            if(whileWorking == 0){
                smt.execute("DELETE FROM degree_program WHERE id = "+id);
                JOptionPane.showMessageDialog(this, "Record Deleted!");

            }
            model.setRowCount(0);
            showDPList();
            txt_dp.setText("");

            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_deleteDpActionPerformed

    public ArrayList<degreeProgram> getDPList()
    {
        ArrayList<degreeProgram> list = new ArrayList<degreeProgram>();
        try{
        connection = DBconnection.getConnection();
        String querry = "select * from degree_program";
        Statement st;
        ResultSet rs;
        
        st = connection.createStatement();
        rs= st.executeQuery(querry);
        degreeProgram degreeP;
        while(rs.next())
        {
            degreeP = new degreeProgram(rs.getInt("id"), rs.getString("dp"));
            list.add(degreeP);
        }
        
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    
    public void showDPList()
    {
        ArrayList<degreeProgram> list = getDPList();
        DefaultTableModel model = (DefaultTableModel)tbl_Dp.getModel();
        Object[] row = new Object[2];
        for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getDP();
            
            model.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addDp;
    private javax.swing.JButton btn_deleteDp;
    private javax.swing.JButton btn_editDp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Dp;
    private javax.swing.JTextField txt_dp;
    private javax.swing.JLabel txt_error;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}