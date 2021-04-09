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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import lamhdt.db.MyConnection;
import lamhdt.dtos.TribulationDTO;

/**
 *
 * @author HL
 */
public class TribulationDAO {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    private DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TribulationDAO() {
    }

    public List<TribulationDTO> getAllTribulation() throws Exception {
        List<TribulationDTO> result = null;
        TribulationDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select tribulationID, tribulationName, tribulationDescription From Tribulation";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int tribulationID = rs.getInt("tribulationID");
                String tribulationName = rs.getNString("tribulationName");
                String tribulationDescription = rs.getNString("tribulationDescription");
                dto = new TribulationDTO(tribulationID, tribulationName, tribulationDescription);
                result.add(dto);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<TribulationDTO> getTribulationByName(String nameToSeach) throws Exception {
        List<TribulationDTO> result = null;
        TribulationDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select tribulationID, tribulationName, tribulationDescription From Tribulation where tribulationName LIKE ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + nameToSeach + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int tribulationID = rs.getInt("tribulationID");
                String tribulationName = rs.getNString("tribulationName");
                String tribulationDescription = rs.getNString("tribulationDescription");
                dto = new TribulationDTO(tribulationID, tribulationName, tribulationDescription);
                result.add(dto);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<TribulationDTO> getAllTribulationByIDActor(int id) throws Exception {
        List<TribulationDTO> result = null;
        TribulationDTO dto = null;
        List<Integer> tribulationID = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select B.tribulationID From Role A JOIN usedRole B on A.roleName = B.roleName Where A.IDActor = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            tribulationID = new ArrayList<>();
            while (rs.next()) {
                tribulationID.add(rs.getInt("tribulationID"));
            }

        } finally {
            closeConnection();
        }
        if (tribulationID != null) {
            result = new ArrayList<>();
            for (Integer integer : tribulationID) {
               result.add(getTribulationByID(integer));
            }
        }
        return result;
    }

    public TribulationDTO getTribulationByID(int tribulationID) throws Exception {
        TribulationDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select tribulationName, tribulationDescription, place, startDate, endDate, numOfShoot From Tribulation Where tribulationID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, tribulationID);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String tribulationName = rs.getNString("tribulationName");
                String tribulationDescription = rs.getNString("tribulationDescription");
                String place = rs.getNString("place");
                Date startDate = rs.getDate("startDate");
                Date endDate = rs.getDate("endDate");
                int numOfShoot = rs.getInt("numOfShoot");
                dto = new TribulationDTO(tribulationID, tribulationName, tribulationDescription, place, startDate, endDate, numOfShoot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public List getTribulationByEquipmentID(int id) throws Exception{
        List result = null;
        Vector dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select tribulationName, startDate, endDate, quantity "
                    + "From Tribulation A JOIN usedEquipment B on A.tribulationID = B.tribulationID "
                    + "Where B.equipmentID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                String tribulationName = rs.getNString("tribulationName");
                Date startDate = rs.getDate("startDate");
                Date endDate = rs.getDate("endDate");
                int quantity = rs.getInt("quantity");
                dto = new Vector();
                dto.add(tribulationName);
                dto.add(startDate.toLocalDate().format(df));
                dto.add(endDate.toLocalDate().format(df));
                dto.add(quantity);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            closeConnection();
        }
        return result;
    }

    public int getIDbyName(String name) throws Exception {
        int id = -1;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select tribulationID From Tribulation Where tribulationName = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, name);
            rs = preStm.executeQuery();
            if (rs.next()) {
                id = rs.getInt("tribulationID");
            }
        } finally {
            closeConnection();
        }
        return id;
    }

    public boolean createTribulation(TribulationDTO dto) throws Exception {
        boolean check = false;
        boolean exist = false;
        try {
            conn = MyConnection.getConnection();
           String sql = "Select startDate, endDate From Tribulation";
           preStm = conn.prepareStatement(sql);
           rs = preStm.executeQuery();
           while(rs.next())
           {
                LocalDate sd = rs.getDate("startDate").toLocalDate();
                LocalDate ed = rs.getDate("endDate").toLocalDate();
               if((dto.getStartDate().toLocalDate().compareTo(sd) <= 0 && sd.compareTo(dto.getEndDate().toLocalDate()) <= 0) || (dto.getStartDate().toLocalDate().compareTo(ed) <= 0 && ed.compareTo(dto.getEndDate().toLocalDate()) <=0)){
                   {
                       exist = true;
                       throw new Exception("Date is duplicate in other Tribulation");
                   } 
               }
           }
           if(exist) return false;
             sql = "Insert into Tribulation(tribulationName, tribulationDescription, place, startDate, endDate, numOfShoot) VALUES(?,?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getTribulationName());
            preStm.setString(2, dto.getDescription());
            preStm.setString(3, dto.getPlace());
            preStm.setDate(4, dto.getStartDate());
            preStm.setDate(5, dto.getEndDate());
            preStm.setInt(6, dto.getNumberOfShoot());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateTribulation(int tribulationID, TribulationDTO dto) throws Exception {
        boolean check = false;
        boolean exist = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select startDate, endDate From Tribulation Where tribulationID <> ?";
           preStm = conn.prepareStatement(sql);
           preStm.setInt(1, tribulationID);
           rs = preStm.executeQuery();
           while(rs.next())
           {
                LocalDate sd = rs.getDate("startDate").toLocalDate();
                LocalDate ed = rs.getDate("endDate").toLocalDate();
               if((dto.getStartDate().toLocalDate().compareTo(sd) <= 0 && sd.compareTo(dto.getEndDate().toLocalDate()) <= 0) || (dto.getStartDate().toLocalDate().compareTo(ed) <= 0 && ed.compareTo(dto.getEndDate().toLocalDate()) <=0)){
                   {
                       exist = true;
                       throw new Exception("Date is duplicate in other Tribulation");
                   } 
               }
           }
           if(exist) return false;
            
             sql = "Update Tribulation Set tribulationName = ? ,tribulationDescription = ? ,place = ? "
                    + ",startDate = ? ,endDate = ? ,numOfShoot = ? Where tribulationID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getTribulationName());
            preStm.setString(2, dto.getDescription());
            preStm.setString(3, dto.getPlace());
            preStm.setDate(4, dto.getStartDate());
            preStm.setDate(5, dto.getEndDate());
            preStm.setInt(6, dto.getNumberOfShoot());
            preStm.setInt(7, tribulationID);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean deleteTribulation(int tribulationID) throws Exception {
        boolean check = false;
        try {
            UsedRoleDAO usedRoleDAO = new UsedRoleDAO();
            UsedEquipmentDAO usedEquipmentDAO = new UsedEquipmentDAO();
            usedRoleDAO.deleteAllRoleByTribulationID(tribulationID);
            usedEquipmentDAO.deleteAllEquipmentByTribulationID(tribulationID);
            conn = MyConnection.getConnection();
            String sql = "Delete From Tribulation Where tribulationID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, tribulationID);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public int countTribulation() throws Exception {
        int count = 0;
        try {
            conn = MyConnection.getConnection();
           String sql = "Select COUNT(tribulationID) as CTribulation FROM Tribulation";
           preStm = conn.prepareStatement(sql);
           rs = preStm.executeQuery();
           if(rs.next())
               count = rs.getInt("CTribulation");
        } finally {
            closeConnection();
        }
        return count;
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
}
