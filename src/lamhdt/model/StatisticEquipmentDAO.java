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
import java.util.ArrayList;
import java.util.List;
import lamhdt.db.MyConnection;
import lamhdt.dtos.StatisticEquipmentDTO;

/**
 *
 * @author HL
 */
public class StatisticEquipmentDAO {
    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

    public StatisticEquipmentDAO() {
    }
    
    private void closeConnection() throws Exception{
        if(rs != null) rs.close();
        if(preStm != null)  preStm.close();
        if(conn != null) conn.close();
    }
    
    public List<StatisticEquipmentDTO> getAllStatistic() throws Exception{
        List<StatisticEquipmentDTO> result = null;
        StatisticEquipmentDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select equipmentName,C.quantity as 'totalQuantity', D.quantity as 'usingQuantity' ,startDate,endDate From Equipment C LEFT OUTER JOIN (Select equipmentID, quantity, startDate, endDate \n" +
"From usedEquipment A JOIN Tribulation B on A.tribulationID = B.tribulationID) D on C.equipmentID = D.equipmentID\n" +
"";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next())
            {
              String equipmentName = rs.getNString("equipmentName");
              int totalQuantity = rs.getInt("totalQuantity");
              int usingQuantity = rs.getInt("usingQuantity");
              Date startDate = rs.getDate("startDate");
              Date endDate = rs.getDate("endDate");
              dto = new StatisticEquipmentDTO(equipmentName, totalQuantity, usingQuantity, startDate, endDate);
              result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            closeConnection();
        }
        return result;
    }
    
    
    
    
}
