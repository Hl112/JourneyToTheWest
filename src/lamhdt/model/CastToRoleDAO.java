/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamhdt.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import lamhdt.db.MyConnection;
import lamhdt.dtos.CastRoleDTO;

/**
 *
 * @author HL
 */
public class CastToRoleDAO {
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    private final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+7:00"));
    private final Timestamp ts = new Timestamp(cal.getTimeInMillis());
    private String username = "admin";
    public CastToRoleDAO() {
        
    }
    public CastToRoleDAO(String username) {
        this.username = username;
    }
    private void closeConnection() throws Exception{
        if(rs != null) rs.close();
        if(preStm != null) preStm.close();
        if(conn != null) conn.close();
    }
    
    public List<CastRoleDTO> getAllCastRole() throws Exception{
        List<CastRoleDTO> result = null;
        CastRoleDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select roleName, actorName, A.IDActor From Role A Join Actor B on A.IDActor = B.actorID";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                String roleName = rs.getNString("roleName");
                String actorName = rs.getNString("actorName");
                int id = rs.getInt("IDActor");
                dto = new CastRoleDTO(roleName, actorName);
                dto.setIDActor(id);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return result;
    }
    
    public List<CastRoleDTO> getAllCastRoleByActorName(String search) throws Exception{
        List<CastRoleDTO> result = null;
        CastRoleDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select roleName, actorName, A.IDActor From Role A Join Actor B on A.IDActor = B.actorID Where actorName Like ?";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                String roleName = rs.getNString("roleName");
                String actorName = rs.getNString("actorName");
                int id = rs.getInt("IDActor");
                dto = new CastRoleDTO(roleName, actorName);
                dto.setIDActor(id);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return result;
    }
    
    
    
    public List<CastRoleDTO> getAllActor() throws Exception{
        List<CastRoleDTO> result = null;
        CastRoleDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select actorID, actorName From Actor";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next())
            {
                int actorID = rs.getInt("actorID");
                String actorName = rs.getNString("actorName");
                dto = new CastRoleDTO(actorName, actorID);
                result.add(dto);
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    
    
    
    
    public boolean createCastRole(CastRoleDTO dto) throws Exception{
        boolean check = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "Insert Into logRole(roleNew, actorID, username, event) Values(?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, dto.getRoleName());
            preStm.setInt(2, dto.getIDActor());
            preStm.setString(3, username);
            preStm.setString(4, "Update");
            check = preStm.executeUpdate() > 0;
            sql = "Select IDActor From Role Where roleName = ? AND IDActor <> ?";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, dto.getRoleName());
            preStm.setInt(2, dto.getIDActor());
            rs = preStm.executeQuery();
            int oldId = -1;
            if(rs.next())
             oldId = rs.getInt("IDActor");
            if(oldId != -1 && oldId != dto.getIDActor()){
                 sql = "Insert Into logRole(roleNew, actorID, username, event) Values(?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, dto.getRoleName());
            preStm.setInt(2, oldId);
            preStm.setString(3, username);
            preStm.setString(4, "Delete");
            check = preStm.executeUpdate() > 0;
            }
             sql = "Update Role Set IDActor = ? Where roleName = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getIDActor());
            preStm.setNString(2, dto.getRoleName());
            check = preStm.executeUpdate() > 0;
            
        } finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteCastRole(String roleName) throws Exception{
        boolean check = false;
        try {
            conn = MyConnection.getConnection();
            int id = 0;
            String sql = "Select IDActor From Role Where roleName = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, roleName);
            rs = preStm.executeQuery();
            if(rs.next())
                id = rs.getInt("IDActor");
            
            sql = "Insert Into logRole(roleNew, actorID, username, timeOfUpdate , event) Values(?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, roleName);
            preStm.setInt(2, id);
            preStm.setString(3, username);
            preStm.setTimestamp(4, ts, cal);
            preStm.setString(5, "Delete");
            check = preStm.executeUpdate() > 0; 
           
            sql = "Update Role Set IDActor = null Where roleName = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, roleName);
            check = preStm.executeUpdate() > 0;
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return check;
    }
}
