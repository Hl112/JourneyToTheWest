/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamhdt.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lamhdt.db.MyConnection;
import lamhdt.dtos.RoleDTO;
import lamhdt.dtos.UsedRoleDTO;

/**
 *
 * @author HL
 */
public class UsedRoleDAO {
    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

    public UsedRoleDAO() {
    }
    
    private void closeConnection() throws Exception{
        if(rs != null) rs.close();
        if(preStm != null) preStm.close();
        if(conn != null) conn.close();
    }
    
    public List<UsedRoleDTO> getAllUsedRole() throws Exception{
        List<UsedRoleDTO> result = null;
        UsedRoleDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "select B.tribulationName, A.roleName from usedRole A JOIN Tribulation B on A.tribulationID = B.tribulationID";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next())
            {
                String tribulationName = rs.getNString("tribulationName");
                String roleName = rs.getNString("roleName");
                dto = new UsedRoleDTO(tribulationName, roleName);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return result;
    }
    
     public List<UsedRoleDTO> getAllUsedRoleByName(String search) throws Exception{
        List<UsedRoleDTO> result = null;
        UsedRoleDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "select B.tribulationName, A.roleName from usedRole A JOIN Tribulation B on A.tribulationID = B.tribulationID where roleName like ?";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next())
            {
                String tribulationName = rs.getNString("tribulationName");
                String roleName = rs.getNString("roleName");
                dto = new UsedRoleDTO(tribulationName, roleName);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return result;
    }
     
    public List<RoleDTO> getAllRoleByTribulationID(int id) throws Exception{
        List<RoleDTO> result = null;
        RoleDTO dto = null;
        try {
            conn  = MyConnection.getConnection();
            String sql = "Select roleName From usedRole Where tribulationID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next())
            {
                String roleName = rs.getNString("roleName");
                dto = new RoleDTO(roleName);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return result;
    }
    
    public boolean addUsedRole(UsedRoleDTO dto) throws Exception{
        boolean check = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "Insert Into usedRole(roleName, tribulationID) Values(?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getRoleName());
            preStm.setInt(2, dto.getId());
            check = preStm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteUsedRole(UsedRoleDTO dto) throws Exception{
        boolean check = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete From usedRole Where roleName = ? and tribulationID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getRoleName());
            preStm.setInt(2, dto.getId());
            check = preStm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
    public boolean deleteAllRoleByTribulationID(int id) throws Exception{
        boolean check = false;
        try{
            conn = MyConnection.getConnection();
            String sql = "Delete From usedRole Where tribulationID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            check = preStm.executeUpdate() > 0;
        }finally
        {
            closeConnection();
        }
        return check;
    }
}
