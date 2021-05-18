/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spm.timetablemanagement.statistics;

import com.spm.timetablemanagement.util.DBconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class LoadTable {

    private final JTable table;
    private final String query;
    private final LinkedHashMap<String, String> hashMap;
    private final int columnCount;

    public LoadTable(JTable table, String query, LinkedHashMap<String, String> hashMap) {
        this.table = table;
        this.query = query;
        this.hashMap = hashMap;
        columnCount = this.hashMap.size();
//        System.out.println(columnCount);

        setData();
    }

    public void setData() {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);

        try {
            Connection connection = DBconnection.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rst = stmt.executeQuery(query);

            while (rst.next()) {
                Object[] row = new Object[columnCount];
                int i = 0;
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
//                    System.out.println("x");
                    String columnName = entry.getKey();
                    String type = entry.getValue();
                    
//                    System.out.println(columnName + " " + type);

                    if (type.equals("int")) {
                        row[i] = rst.getInt(columnName);
//                        System.out.println(row[i]);
                    } else if (type.equals("String")) {
                        row[i] = rst.getString(columnName);
//                        System.out.println(row[i]);
                    } else {
                        System.out.println("Type Error!");
                    }
                    i++;
                }
                tableModel.addRow(row);
//                System.out.println(tableModel);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
