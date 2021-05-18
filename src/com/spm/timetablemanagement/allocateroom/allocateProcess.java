/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spm.timetablemanagement.allocateroom;

import com.spm.timetablemanagement.form.room.*;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ysraf
 */
public class allocateProcess extends allocate{
    public allocateProcess(){
        allocate();
    }
public void addRoom (String id, String type) throws SQLException{
        String sql = "INSERT INTO roomsForATag (tag,room) VALUES('"+id+"','"+type+"')";
        st.executeUpdate(sql);
    }

    
    
    public void getRoom(DefaultTableModel dtm) throws SQLException{
        String sql = "SELECT * FROM roomsForATag";
        
        rs = st.executeQuery(sql);
        Object[] data = new Object[3];
        
        while (rs.next()){
            data[0] = rs.getString("id");
            data[1] = rs.getString("tag");
            data[2] = rs.getString("room");
            dtm.addRow(data);
        }
        
    }
    public void deleteRoom (String id) throws SQLException{
        String sql = "DELETE FROM roomsForATag WHERE id = '"+id+"'" ;
        st.executeUpdate(sql);
    }
    
//-------------------------------------------------------------------------------------------------------------    
    
    
   public void addsubRoom (String id, String type,String sub) throws SQLException{
        String sql = "INSERT INTO roomssubtags (tag,room,subject) VALUES('"+id+"','"+type+"','"+sub+"')";
        st.executeUpdate(sql);
    }
   
  
    
    public void getsubRoom(DefaultTableModel dtm) throws SQLException{
        String sql = "SELECT * FROM roomssubtags";
        
        rs = st.executeQuery(sql);
        Object[] data = new Object[4];
        
        while (rs.next()){
            data[0] = rs.getString("id");
            data[1] = rs.getString("tag");
            data[2] = rs.getString("room");
            data[3] = rs.getString("subject");
            dtm.addRow(data);
        }
        
    }
    public void deletesubRoom (String id) throws SQLException{
        String sql = "DELETE FROM roomssubtags WHERE id = '"+id+"'" ;
        st.executeUpdate(sql);
    }
    
    
//-------------------------------------------------------------------------------------------------------------    
    
    
   public void addlectRoom (String id, String type) throws SQLException{
        String sql = "INSERT INTO roomsforlecturer (room,lecturer) VALUES('"+id+"','"+type+"')";
        st.executeUpdate(sql);
    }
   
  
    
    public void getlectRoom(DefaultTableModel dtm) throws SQLException{
        String sql = "SELECT * FROM roomsforlecturer";
        
        rs = st.executeQuery(sql);
        Object[] data = new Object[3];
        
        while (rs.next()){
            data[0] = rs.getString("id");
            data[1] = rs.getString("room");
            data[2] = rs.getString("lecturer");
            
            dtm.addRow(data);
        }
        
    }
    public void deletelectRoom (String id) throws SQLException{
        String sql = "DELETE FROM roomsforlecturer WHERE id = '"+id+"'" ;
        st.executeUpdate(sql);
    }
    
    
//-------------------------------------------------------------------------------------------------------------    
    
    
   public void addgroupRoom (String id, String type) throws SQLException{
        String sql = "INSERT INTO roomsforgroup (room,groups) VALUES('"+id+"','"+type+"')";
        st.executeUpdate(sql);
    }
   
  
    
    public void getgroupRoom(DefaultTableModel dtm) throws SQLException{
        String sql = "SELECT * FROM roomsforgroup";
        
        rs = st.executeQuery(sql);
        Object[] data = new Object[3];
        
        while (rs.next()){
            data[0] = rs.getString("id");
            data[1] = rs.getString("room");
            data[2] = rs.getString("groups");
            
            dtm.addRow(data);
        }
        
    }
    public void deletegroupRoom (String id) throws SQLException{
        String sql = "DELETE FROM roomsforgroup WHERE id = '"+id+"'" ;
        st.executeUpdate(sql);
    }
    
//-------------------------------------------------------------------------------------------------------------    
    
    
   public void addsesRoom (String id, String type) throws SQLException{
        String sql = "INSERT INTO roomsforsession (room,session) VALUES('"+id+"','"+type+"')";
        st.executeUpdate(sql);
    }
   
  
    
    public void getsesRoom(DefaultTableModel dtm) throws SQLException{
        String sql = "SELECT * FROM roomsforsession";
        
        rs = st.executeQuery(sql);
        Object[] data = new Object[2];
        
        while (rs.next()){
            data[0] = rs.getString("id");
            data[1] = rs.getString("room");
            data[2] = rs.getString("session");
            
            dtm.addRow(data);
        }
        
    }
    public void deletesesRoom (String id) throws SQLException{
        String sql = "DELETE FROM roomsforsession WHERE id = '"+id+"'" ;
        st.executeUpdate(sql);
    }
    
//-------------------------------------------------------------------------------------------------------------    
    
    
   public void addcsesRoom (String id, String type) throws SQLException{
        String sql = "INSERT INTO roomsforconssession (room,consSession) VALUES('"+id+"','"+type+"')";
        st.executeUpdate(sql);
    }
   
  
    
    public void getcsesRoom(DefaultTableModel dtm) throws SQLException{
        String sql = "SELECT * FROM roomsforconssession";
        
        rs = st.executeQuery(sql);
        Object[] data = new Object[3];
        
        while (rs.next()){
            data[0] = rs.getString("id");
            data[1] = rs.getString("room");
            data[2] = rs.getString("consSession");
            
            dtm.addRow(data);
        }
        
    }
    public void deletecsesRoom (String id) throws SQLException{
        String sql = "DELETE FROM roomsforconssession WHERE id = '"+id+"'" ;
        st.executeUpdate(sql);
    }

    
    
//-------------------------------------------------------------------------------------------------------------    
    
    
   public void addtimeRoom (String id, String type, String end) throws SQLException{
        String sql = "INSERT INTO reservedrooms (room,stime,etime) VALUES('"+id+"','"+type+"','"+end+"')";
        st.executeUpdate(sql);
    }
   
  
    
    public void gettimeRoom(DefaultTableModel dtm) throws SQLException{
        String sql = "SELECT * FROM reservedrooms";
        
        rs = st.executeQuery(sql);
        Object[] data = new Object[4];
        
        while (rs.next()){
            data[0] = rs.getString("id");
            data[1] = rs.getString("room");
            data[2] = rs.getString("stime");
            data[3] = rs.getString("etime");
            
            dtm.addRow(data);
        }
        
    }
    public void deletetimeRoom (String id) throws SQLException{
        String sql = "DELETE FROM reservedrooms WHERE id = '"+id+"'" ;
        st.executeUpdate(sql);
    }

    
}
