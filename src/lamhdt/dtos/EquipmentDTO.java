/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamhdt.dtos;

import java.sql.Date;
import java.text.ParseException;
import java.util.Vector;

/**
 *
 * @author HL
 */
public class EquipmentDTO {
    private String equipmentName;
    private int quantity;
    private String status = "Unused : 0";
    private String description;
    private String image = "imgEquipment/noimg.jpg";
    private Date startDate;
    private Date endDate;
    private int equipmentID;
    
    public EquipmentDTO() {
    }

    public EquipmentDTO(int equipmentID, String equipmentName, int quantity, String status) {
        this.equipmentID = equipmentID;
        this.equipmentName = equipmentName;
        this.quantity = quantity;
        this.status = status;
    }

    public EquipmentDTO(String equipmentName, int quantity, String description, String image) {
        this.equipmentName = equipmentName;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
    }
    
     public EquipmentDTO(String equipmentName, String quantity, String description, String image) throws Exception{
        this.equipmentName = equipmentName;
         setQuantity(quantity);
        this.description = description;
        this.image = image;
    }
    public EquipmentDTO(String equipmentName, String status, Date startDate, Date endDate){
        this.equipmentName = equipmentName;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public EquipmentDTO(String equipmentName) {
        this.equipmentName = equipmentName;
    }
    
    
    
    public Vector toVector(){
        Vector v = new Vector();
        v.add(equipmentID);
        v.add(equipmentName);
        v.add(status);
        return v;
    }
    
    public Vector toVectorShow(){
        Vector v = new Vector();
        v.add(equipmentName);
        v.add(quantity);
        return v;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) throws Exception{
        if(equipmentName.equals("")) throw new Exception(" ! Please Input Equipment Name.");
        this.equipmentName = equipmentName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
     public void setQuantity(String quantity) throws Exception{
        if(quantity.equals("")) throw new Exception("Please Input Number Quantity.");
         try {
            
            this.quantity = Integer.parseInt(quantity);
            if(this.quantity < 1) throw new Exception(" ! Quantity must more than 1");
        } catch (ParseException e) {
            throw new Exception(" Please Input Quantity is Number");
        }
            
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
