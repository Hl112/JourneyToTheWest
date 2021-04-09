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
import lamhdt.dtos.EquipmentDTO;

/**
 *
 * @author HL
 */
public class EquipmentDAO {

    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

    public EquipmentDAO() {
    }

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public List<EquipmentDTO> getAllEquipment() throws Exception {
        List<EquipmentDTO> result = null;
        EquipmentDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select A.equipmentID, A.equipmentName, A.quantity, B.status\n" +
"From Equipment A LEFT OUTER JOIN (select equipmentID, sum(quantity) as 'status'\n" +
"							From usedEquipment\n" +
"							Group by equipmentID) B on A.equipmentID = B.equipmentID";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int equipmentID = rs.getInt("equipmentID");
                String equipmentName = rs.getNString("equipmentName");
                int quantity = rs.getInt("quantity");
                int status = rs.getInt("status");
                dto = new EquipmentDTO(equipmentID, equipmentName, quantity, (status == 0) ? "Unusing : " + quantity : "Using : " + status);
                result.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }
    public List<EquipmentDTO> getAllEquipmentByName(String name) throws Exception{
        List<EquipmentDTO> result = null;
        EquipmentDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select A.equipmentID, A.equipmentName, A.quantity, B.status\n" +
"From Equipment A LEFT OUTER JOIN (select equipmentID, sum(quantity) as 'status'\n" +
"							From usedEquipment\n" +
"							Group by equipmentID) B on A.equipmentID = B.equipmentID Where equipmentName Like ?";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, "%" + name + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int equipmentID = rs.getInt("equipmentID");
                String equipmentName = rs.getNString("equipmentName");
                int quantity = rs.getInt("quantity");
                int status = rs.getInt("status");
                dto = new EquipmentDTO(equipmentID, equipmentName, quantity, "Total : " + quantity + " Used : " + status);
                result.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public EquipmentDTO getEquipmentByID(int equipmentID) throws Exception{
        EquipmentDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select equipmentName, quantity, description, image FROM Equipment Where equipmentID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, equipmentID);
            rs = preStm.executeQuery();
            if(rs.next())
            {
                String equipmentName = rs.getNString("equipmentName");
                int quantity = rs.getInt("quantity");
                String description = rs.getNString("description");
                String image = rs.getString("image");
                dto = new EquipmentDTO(equipmentName, quantity, description, image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return dto;
    }
    
    public int getIDByName(String name) throws Exception{
        int id = -1;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select equipmentID From Equipment Where equipmentName = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, name);
            rs = preStm.executeQuery();
            if(rs.next())
                id = rs.getInt("equipmentID");
        } finally{
            closeConnection();
        }
        return id;
    }
    
    public boolean createEquipment(EquipmentDTO dto) throws Exception{
        boolean check = false;
        String linkImg = null;
        boolean checkLink = false;
        try {
            File f = new File(dto.getImage());
            if(f.exists())
            {
                if(f.isFile())
                {
                    linkImg = "imgEquipment/" + f.getName();
                    checkLink = true;
                }
                else{
                    linkImg = "imgEquipment/noimg.jpg";
                    checkLink = false;
                }
            }
            conn = MyConnection.getConnection();
            String sql = "insert into Equipment(equipmentName, description, image, quantity) Values(?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getEquipmentName());
            preStm.setString(2, dto.getDescription());
            preStm.setString(3, linkImg);
            preStm.setInt(4, dto.getQuantity());
            check = preStm.executeUpdate() > 0;
            if(checkLink)
                FileDAO.copyFile(dto.getImage(), "imgEquipment", f.getName());
        }finally{
            closeConnection();
        }
        return check;
    } 
    
    public boolean updateEquipmentByID(int equipmentID, EquipmentDTO dto) throws Exception{
        boolean check = false;
        boolean checkLink = false;
        String linkImg = null;
        try {
            File f = new File(dto.getImage());
            if(f.exists())
                if(f.isFile())
                {
                 linkImg = "imgEquipment/" + f.getName();
                 checkLink = true;
                }
                else{
                    linkImg = "imgEquipment/noimg.jpg";
                    checkLink = false;
                }
            conn = MyConnection.getConnection();
            String sql = "Update Equipment Set equipmentName = ?, description = ?, image = ? , quantity = ? where equipmentID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getEquipmentName());
            preStm.setString(2, dto.getDescription());
            preStm.setString(3, linkImg);
            preStm.setInt(4, dto.getQuantity());
            preStm.setInt(5, equipmentID);
            check = preStm.executeUpdate() > 0;
             if(checkLink)
                FileDAO.copyFile(dto.getImage(), "imgEquipment", f.getName());
        }finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteEquipmentByID(int equipmentID, String fileName) throws Exception{
        boolean check = false;
        boolean checkImg = false;
        try {
            File f = new File("imgEquipment/" + fileName);
            if(f.exists())
                if(f.isFile())
                    checkImg = true;
            conn = MyConnection.getConnection();
            String sql = "Delete From usedEquipment where equipmentID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, equipmentID);
            check = preStm.executeUpdate() > 0;
            sql = "Delete From Equipment where equipmentID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, equipmentID);
            check = preStm.executeUpdate() > 0;
            if(checkImg)
                FileDAO.deleteFile("imgEquipment/" + fileName);
        }finally{
            closeConnection();
        }
        return check;
    }
    
       public int countEquipment() throws Exception {
        int count = 0;
        try {
            conn = MyConnection.getConnection();
           String sql = "Select COUNT(equipmentID) as CEquipment FROM Equipment";
           preStm = conn.prepareStatement(sql);
           rs = preStm.executeQuery();
           if(rs.next())
               count = rs.getInt("CEquipment");
        } finally {
            closeConnection();
        }
        return count;
    }
    
    
    
}
