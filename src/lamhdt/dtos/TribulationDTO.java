/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamhdt.dtos;

import java.sql.Date;
import java.util.Vector;
import lamhdt.valid.MyValidation;

/**
 *
 * @author HL
 */
public class TribulationDTO {
    private int id;
    private String tribulationName;
    private String description;
    private String place;
    private Date startDate;
    private Date endDate;
    private int numberOfShoot;
    public TribulationDTO() {
    }

    public TribulationDTO(int id, String tribulationName, String description) {
        this.id = id;
        this.tribulationName = tribulationName;
        this.description = description;
    }

    public TribulationDTO(int id, String tribulationName) {
        this.id = id;
        this.tribulationName = tribulationName;
    }
    

    public TribulationDTO(int id, String tribulationName, String description, String place, Date startDate, Date endDate, int numberOfShoot) {
        this.id = id;
        this.tribulationName = tribulationName;
        this.description = description;
        this.place = place;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfShoot = numberOfShoot;
    }
    
    
    public Vector toVector(){
        Vector v = new Vector();
        v.add(id);
        v.add(tribulationName);
        v.add(description);
        return v;
    }
    public Vector toVectorHistory()
    {
        Vector v = new Vector();
        v.add(id);
        v.add(tribulationName);
        return v;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTribulationName() {
        return tribulationName;
    }

    public void setTribulationName(String tribulationName) throws Exception{
        if(tribulationName.equals("")) throw new Exception(" ! Please input Tribulation Name");
        this.tribulationName = tribulationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) throws Exception{
        if(place.equals("")) throw new Exception(" ! Please input Place");
        this.place = place;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) throws Exception{
        if(!MyValidation.validDate(startDate)) throw new Exception(" ! Invalid Start Date. Please Input Again(dd/mm/yyyy).");
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) throws Exception{
        if(!MyValidation.validDate(endDate)) throw new Exception(" ! Invalid End Date. Please Input Again(dd/mm/yyyy).");
        this.endDate = endDate;
    }

    public int getNumberOfShoot() {
        return numberOfShoot;
    }

    public void setNumberOfShoot(String numberOfShoot) throws Exception{
        try {
            this.numberOfShoot = Integer.parseInt(numberOfShoot);
        } catch (NumberFormatException e) {
            throw new Exception(" ! Please Input Number at Number Of Shoot");
        }
        if(this.numberOfShoot < 1) throw new Exception(" ! Number of Shoot must be positive number");
    }
    
}
