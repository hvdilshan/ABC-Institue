/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spm.timetablemanagement.form.session;

import allocateTime_modifySessions.addConsecutiveSession;
import com.spm.timetablemanagement.models.Lecturer;
import com.spm.timetablemanagement.models.Session;
import com.spm.timetablemanagement.util.Constant;
import com.spm.timetablemanagement.util.CreateQuery;
import com.spm.timetablemanagement.util.DBconnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Tiran Harsha
 */
public class ViewSession extends javax.swing.JPanel {

    PreparedStatement statement, statement1;
    Connection connection;
    ResultSet resultSet;
    TableModel tableModel;
    DefaultTableModel dtm;

    Map<Integer, Lecturer> lecturerList;
    Map<Integer, Session> sessionList;
    Map<Integer, Integer> session_lecList;
    List<String> lecList;
    String[] lecture;
    Object[] data;
    int i = 0;
    int a = 0;

    /**
     * Creates new form ViewSession
     */
    public ViewSession() {
        initComponents();

        txt_id.setVisible(false);
        this.lecturerList = new Hashtable<>();
        this.sessionList = new Hashtable<>();
        this.session_lecList = new Hashtable<>();
        this.lecList = new ArrayList<>();
        dtm = (DefaultTableModel) jTable1.getModel();
        tableModel = jTable1.getModel();

        try {
            connection = DBconnection.getConnection();
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(ViewSession.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error on connection create" + ex.getMessage(), "Data error", JOptionPane.ERROR_MESSAGE);
        }
        loadData();
        createTable();
    }

    private void createTable() {
        dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        for (Session s : sessionList.values()) {
            data = new Object[9];

            data[0] = s.getId();
            data[1] = Arrays.toString(s.getLec());
            data[2] = s.getSub();
            data[3] = s.getSubc();
            data[4] = s.getTag();
            data[5] = s.getDuration();
            data[6] = s.getGroupID();
            data[7] = s.getSubgroupID();
            data[8] = s.getStu_count();

            dtm.addRow(data);
        }
    }

    private void loadData() {
        i = 0;
        loadLecturers();

        Session session;

        try {
            statement = connection.prepareStatement(CreateQuery.getQuery(Constant.GET_SESSION));
            statement1 = connection.prepareStatement(CreateQuery.getQuery(Constant.GET_SESSION_LECT_BY_ID));

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                session = new Session();

                session.setId(resultSet.getInt("id"));
                session.setSub(resultSet.getString("subject"));
                session.setSubc(resultSet.getString("sub_code"));
                session.setTag(resultSet.getString("tag"));
                session.setDuration(resultSet.getString("tag_duration"));
                session.setGroupID(resultSet.getString("group_id"));
                session.setSubgroupID(resultSet.getString("subgroup_id"));
                session.setStu_count(resultSet.getInt("stu_count"));

                sessionList.put(session.getId(), session);
            }
            resultSet.close();

            for (Session s : sessionList.values()) {
                i = 0;
                lecture = new String[10];
                statement1.setInt(1, s.getId());
                resultSet = statement1.executeQuery();
                lecList.clear();

                while (resultSet.next()) {

                    lecture[i] = resultSet.getString("lec_id");
                    i++;
                }
                for (String lec : lecture) {
                    if (lec != null) {

                        if (lecturerList.containsKey(Integer.parseInt(lec))) {
                            lecList.add(lecturerList.get(Integer.parseInt(lec)).getName());
                        }
                    }
                }
                lecture = lecList.toArray(new String[lecList.size()]);
                s.setLec(lecture);
            }

            resultSet.close();
            statement1.close();
            statement.close();
            createTable();
        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NumberFormatException | NullPointerException | ClassCastException ex) {
            Logger.getLogger(ViewSession.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error on data Load" + ex.getMessage(), "Data error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadLecturers() {
        try {
            statement = connection.prepareStatement(CreateQuery.getQuery(Constant.GET_LECTURER));
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Lecturer l = new Lecturer();

                l.setId(resultSet.getInt("id"));
                l.setName(resultSet.getString("name"));
                l.setLec_id(resultSet.getString("emp_id"));

                lecturerList.put(l.getId(), l);
            }

            statement.close();
            resultSet.close();
        } catch (ParserConfigurationException | SAXException | IOException | SQLException ex) {
            Logger.getLogger(AddSession.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(this, "Error on load lecturers data", "Data load error" + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btn_refresh = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        txt_id = new javax.swing.JTextField();

        setBackground(new java.awt.Color(186, 148, 243));
        setToolTipText("");
        setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(100, 149, 237));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("MANAGE SESSIONS");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jScrollPane2.setBackground(new java.awt.Color(100, 149, 237));
        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(100, 149, 237));

        jPanel2.setBackground(new java.awt.Color(100, 149, 237));
        jPanel2.setForeground(new java.awt.Color(100, 149, 237));
        jPanel2.setToolTipText("");

        jPanel3.setBackground(new java.awt.Color(100, 149, 237));
        jPanel3.setMinimumSize(new java.awt.Dimension(1, 0));

        jPanel1.setBackground(new java.awt.Color(100, 149, 237));

        jScrollPane3.setBackground(new java.awt.Color(100, 149, 237));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Lecturer(s)", "Subject", "Subject Code", "Tag", "Duration", "GroupID", "SubgroupID", "Student Count"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(60);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel5.setBackground(new java.awt.Color(100, 149, 237));

        btn_refresh.setBackground(new java.awt.Color(255, 153, 0));
        btn_refresh.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_refresh.setForeground(new java.awt.Color(255, 255, 255));
        btn_refresh.setText("Refresh");
        btn_refresh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_refresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(153, 0, 0));
        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Delete");
        btn_delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(300, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(187, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane2.setViewportView(jPanel2);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        txt_id.setText(model.getValueAt(row, 0).toString());

    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        if (txt_id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(ViewSession.this, "Select Session!", "Data missing", JOptionPane.ERROR_MESSAGE);
        } else {

            int result = JOptionPane.showConfirmDialog(this, "Are you sure to delete", "Delete session", JOptionPane.YES_NO_OPTION);

            if (result == 0) {
                deleteSession(Integer.parseInt(txt_id.getText()));
            }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        // TODO add your handling code here:
        createTable();
        txt_id.setText("");
    }//GEN-LAST:event_btn_refreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public static javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables

    private void deleteSession(int row) {
        boolean lock = false;
        try {
            tableModel = jTable1.getModel();

            int sessionID = (int) tableModel.getValueAt(row, 0);

            statement = connection.prepareStatement(CreateQuery.getQuery(Constant.DELETE_SESSION));
            statement1 = connection.prepareStatement(CreateQuery.getQuery(Constant.DELETE_SESSION_LECT));

            statement.setInt(1, sessionID);
            statement1.setInt(1, sessionID);

            statement.execute();
            statement1.execute();

            sessionList.remove(sessionID);

        } catch (SQLException | ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(ViewSession.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error on delete session" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            lock = true;
        }
        if (!lock) {
            dtm.removeRow(row);
            dtm.setRowCount(0);
            createTable();
        }
    }
}
