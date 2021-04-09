/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamhdt.dtos;

import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author HL
 */
public class UsedEquipmentDTO {
    private String tribulationName;
    private String equipmentName;
    private int quantity;
    private int tribulationID;
    private int equipmentID;
    private Date startDate;
    private Date endDate;
    
    public UsedEquipmentDTO() {
    }

    public UsedEquipmentDTO(String tribulationName, String equipmentName, int quantity) {
        this.tribulationName = tribulationName;
        this.equipmentName = equipmentName;
        this.quantity = quantity;
    }

    public UsedEquipmentDTO(int quantity, int tribulationID, int equipmentID) {
        this.quantity = quantity;
        this.tribulationID = tribulationID;
        this.equipmentID = equipmentID;
    }

    public UsedEquipmentDTO(int quantity, int equipmentID, Date startDate, Date endDate) {
        this.quantity = quantity;
        this.equipmentID = equipmentID;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    
    
    
    public Vector toVector()
    {
        Vector v = new Vector();
        v.add(equipmentName);
        v.add(tribulationName);
        v.add(quantity);
        return v;
    }

    public String getTribulationName() {
        return tribulationName;
    }

    public void setTribulationName(String tribulationName) {
        this.tribulationName = tribulationName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
   
    public int getTribulationID() {
        return tribulationID;
    }

    public void setTribulationID(int tribulationID) {
        this.tribulationID = tribulationID;
    }

    public int getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
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
