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
import javax.swing.JOptionPane;
import lamhdt.db.MyConnection;
import lamhdt.dtos.EquipmentDTO;
import lamhdt.dtos.UsedEquipmentDTO;

/**
 *
 * @author HL
 */
public class UsedEquipmentDAO {

    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

    public UsedEquipmentDAO() {
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

    public List<UsedEquipmentDTO> getAllUsedEquipment() throws Exception {
        List<UsedEquipmentDTO> result = null;
        UsedEquipmentDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "select A.equipmentName, C.tribulationName , B.quantity From Equipment A, usedEquipment "
                    + "B, Tribulation C where A.equipmentID = B.equipmentID and B.tribulationID = C.tribulationID";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next())
            {
                String equipmentName = rs.getNString("equipmentName");
                String tribulationName = rs.getNString("tribulationName");
                int quantity = rs.getInt("quantity");
                dto = new UsedEquipmentDTO(tribulationName, equipmentName, quantity);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }
    
    
    public List<UsedEquipmentDTO> getAllUsedEquipmentByName(String search) throws Exception {
        List<UsedEquipmentDTO> result = null;
        UsedEquipmentDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "select A.equipmentName, C.tribulationName , B.quantity From Equipment A, usedEquipment "
                    + "B, Tribulation C where A.equipmentID = B.equipmentID and B.tribulationID = C.tribulationID and equipmentName like ?";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next())
            {
                String equipmentName = rs.getNString("equipmentName");
                String tribulationName = rs.getNString("tribulationName");
                int quantity = rs.getInt("quantity");
                dto = new UsedEquipmentDTO(tribulationName, equipmentName, quantity);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }
    
    
    public List<EquipmentDTO> getAllEquipmentByTribulationID(int id) throws Exception{
        List<EquipmentDTO> result = null;
        EquipmentDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select equipmentName, A.quantity From usedEquipment A JOIN Equipment B on A.equipmentID = B.equipmentID Where tribulationID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next())
            {
                String equipmentName = rs.getNString("equipmentName");
                int quantity = rs.getInt("quantity");
                dto = new EquipmentDTO(equipmentName);
                dto.setQuantity(quantity);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return result;
    }
    
    public List<UsedEquipmentDTO> getUsedEquipmentByName(String name) throws Exception{
        List<UsedEquipmentDTO> result = null;
        UsedEquipmentDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "select A.equipmentName, C.tribulationName , B.quantity From Equipment A, usedEquipment "
                    + "B, Tribulation C where A.equipmentID = B.equipmentID and B.tribulationID = C.tribulationID and A.equipmentName LIKE ?";
             preStm = conn.prepareStatement(sql);
             preStm.setString(1, name);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next())
            {
                String equipmentName = rs.getNString("equipmentName");
                String tribulationName = rs.getNString("tribulationName");
                int quantity = rs.getInt("quantity");
                dto = new UsedEquipmentDTO(tribulationName, equipmentName, quantity);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return result;
    }
    
    public boolean addUsedEquipment(UsedEquipmentDTO dto) throws Exception{
        boolean check = false;
        try {
            int quantityOld = 0 ;
            conn = MyConnection.getConnection();
           String sql = "Select quantity From Equipment where equipmentID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getEquipmentID());
            rs = preStm.executeQuery();
            if(rs.next())
            {
                quantityOld = rs.getInt("quantity");
            }
             try {
                   if(quantityOld < dto.getQuantity()) throw new Exception("! We have " + quantityOld + ". \nPlease Input quantity less than " + quantityOld +".");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                return false;
            }
            sql = "Insert Into usedEquipment(tribulationID, equipmentID, quantity) values(?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getTribulationID());
            preStm.setInt(2, dto.getEquipmentID());
            preStm.setInt(3, dto.getQuantity());
            check = preStm.executeUpdate() > 0;
           
        } finally
        {
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteUsedEquipment(UsedEquipmentDTO dto) throws Exception{
        boolean check = false;
        try {
           
            conn = MyConnection.getConnection();
           
            String sql = "Delete From usedEquipment Where tribulationID = ?  and equipmentID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getTribulationID());
            preStm.setInt(2, dto.getEquipmentID());
            check = preStm.executeUpdate() > 0;
        } finally
        {
            closeConnection();
        }
        return  check;
    }
    
    public boolean deleteAllEquipmentByTribulationID(int id) throws Exception{
        boolean check = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete From usedEquipment Where tribulationID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            check = preStm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
}
