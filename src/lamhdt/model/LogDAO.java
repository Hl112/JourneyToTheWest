/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamhdt.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import lamhdt.db.MyConnection;
import lamhdt.dtos.LogDTO;

/**
 *
 * @author HL
 */
public class LogDAO {
    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

    public LogDAO() {
    }
    
    private void closeConnection() throws Exception{
        if(rs != null) rs.close();
        if(preStm != null) preStm.close();
        if(conn != null) conn.close();
    }
    
    public List<LogDTO> getAllLogByID(int id) throws Exception{
        List<LogDTO> result = null;
        LogDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "SELECT  MIN(logID) AS id, roleNew, actorID, event , MIN(new) as new , Max(timeOfUpdate) AS time "
                    + "From logRole "
                    + "Where actorID = ? "
                    + "Group By roleNew, actorID,event "
                    + "Order By Max(timeOfUpdate) DESC";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next())
            {
                int logId = rs.getInt("id");
                String roleNew = rs.getNString("roleNew");
                String event = rs.getString("event");
                int isNew = rs.getInt("new");
                Timestamp time = rs.getTimestamp("time");
                dto = new LogDTO(logId, roleNew, id, event, isNew, time);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return result;
    }
    
    public boolean makeRead(int id) throws Exception{
        boolean check = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "Update logRole SET new = 0 Where logID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            check = preStm.executeUpdate() > 0;
        } finally
        {
            closeConnection();
        }
        return check;
    }
    
    public int getUnreadByID(int id) throws Exception{
        int unread = 0;
          List<LogDTO> list = getAllLogByID(id);
            for (LogDTO logDTO : list) {
                if(logDTO.getIsNew() == 1) unread++;
            }
        return unread;
    }
    
     public int getTotalByID(int id) throws Exception{
        int total = 0;
       List<LogDTO> list = getAllLogByID(id);
       total = list.size();
        return total;
    }
    
}
