/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamhdt.dtos;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;

/**
 *
 * @author HL
 */
public class StatisticEquipmentDTO {
    private String equipmentName;
    private int totalQuantity;
    private int usingQuantity;
    private Date startDate;
    private Date endDate;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public StatisticEquipmentDTO() {
    }

    public StatisticEquipmentDTO(String equipmentName, int totalQuantity, int usingQuantity, Date startDate, Date endDate) {
        this.equipmentName = equipmentName;
        this.totalQuantity = totalQuantity;
        this.usingQuantity = usingQuantity;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public Vector toVector()
    {
        Vector v = new Vector();
        v.add(equipmentName);
        v.add((usingQuantity == 0) ? "Unusing : " + totalQuantity : "Using : " + usingQuantity);
        v.add(startDate != null ? sdf.format(startDate) : "No Start Date");
        v.add(endDate != null ? sdf.format(endDate) : "No End Date");
        return v;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getUsingQuantity() {
        return usingQuantity;
    }

    public void setUsingQuantity(int usingQuantity) {
        this.usingQuantity = usingQuantity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    
}
