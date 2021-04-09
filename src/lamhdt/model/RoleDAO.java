/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamhdt.model;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lamhdt.db.MyConnection;
import lamhdt.dtos.RoleDTO;

/**
 *
 * @author HL
 */
public class RoleDAO {
    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

    public RoleDAO() {
    }
    private String clearUTF(String name) {
        String s1 = name; 
        s1 = s1.replaceAll("[^\\p{ASCII}]", "");
        s1 = s1.replaceAll("[ ]", "_");
        return s1;
    }
    private void initFolder()
    {
        File f = new File("RoleContent");
        if(f.exists())
        {
            if(f.isFile()) f.mkdir();
            if(f.isDirectory()) return;
        } else
            f.mkdir();
    }
    private void closeConnection() throws Exception{
        if(rs != null)  rs.close();
        if(preStm != null) preStm.close();
        if(conn != null) conn.close();
    }
    
    public List<RoleDTO> getAllRole() throws Exception{
        List<RoleDTO> result = null;
        RoleDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select roleName from Role";
            preStm = conn.prepareStatement(sql);
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
    
    public List<RoleDTO> getRoleByName(String name) throws Exception{
          List<RoleDTO> result = null;
        RoleDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select roleName from Role where roleName like ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + name + "%");
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
    public List<RoleDTO> getRoleByUsername(String username) throws Exception{
        List<RoleDTO> result = null;
        RoleDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select roleName From Role A JOIN Actor B on A.IDActor = B.actorID Where username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
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
    
    public RoleDTO getRole(String roleName) throws Exception{
        RoleDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select description From Role Where roleName = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, roleName);
            rs = preStm.executeQuery();
            if(rs.next())
            {
                String description = rs.getString("description");
                dto = new RoleDTO(roleName, description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return dto;
    }
    
    
    public boolean createRole(RoleDTO dto) throws Exception{
        boolean check = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "insert into Role(roleName) Values(?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getRoleName());
            check = preStm.executeUpdate() > 0;
            initFolder();
            sql = "Select description From Role where roleName = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getRoleName());
            rs = preStm.executeQuery();
            if(rs.next())
            {
                String link = "RoleContent/" + rs.getInt("description") + ".txt";
                FileDAO.writeFile(link, dto.getDescription());
            }
        }finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean updateRoleByName(String roleName, RoleDTO dto) throws Exception{
        boolean check = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select tribulationID From usedRole where roleName = ?";
            int tribulationID = 0;
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, roleName);
            rs = preStm.executeQuery();
            if(rs.next())
                tribulationID = rs.getInt("tribulationID");
            sql = "Delete From usedRole where roleName = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, roleName);
            check = preStm.executeUpdate() > 0;
            sql = "Update Role Set roleName = ? Where roleName = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, dto.getRoleName());
            preStm.setNString(2, roleName);
            check = preStm.executeUpdate() > 0;
            sql = "Insert Into usedRole(roleName, tribulationID) Values(?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, dto.getRoleName());
            preStm.setInt(2, tribulationID);
            sql = "Select description From Role Where roleName = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, roleName);
            rs = preStm.executeQuery();
            if(rs.next())
            {
                FileDAO.writeFile("RoleContent/" + rs.getInt("description") + ".txt", dto.getDescription());
            }
        }finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteRoleByName(String roleName) throws Exception{
        boolean check = false;
        boolean checkFile = false;
        try{
            String fileName = "RoleContent/";
            conn = MyConnection.getConnection();
            String sql = "Delete From usedRole Where roleName = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, roleName);
            check = preStm.executeUpdate() > 0;
            sql = "Select description From Role Where roleName = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, roleName);
            rs = preStm.executeQuery();
            if(rs.next())
            {
                fileName += rs.getInt("description") + ".txt";
            }
            File f = new File(fileName);
            if(f.exists())
                if(f.isFile())
                    checkFile = true;
            sql = "Delete From Role Where roleName = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, roleName);
            check = preStm.executeUpdate() > 0;
            if(checkFile)
                FileDAO.deleteFile(fileName);
        }finally{
            closeConnection();
        }
        return check;
    }
    
      public int countRole() throws Exception {
        int count = 0;
        try {
            conn = MyConnection.getConnection();
           String sql = "Select COUNT(rolename) as CRole FROM Role";
           preStm = conn.prepareStatement(sql);
           rs = preStm.executeQuery();
           if(rs.next())
               count = rs.getInt("CRole");
        } finally {
            closeConnection();
        }
        return count;
    }
   
}
