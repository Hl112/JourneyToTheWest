/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamhdt.valid;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import lamhdt.dtos.ActorDTO;
import lamhdt.dtos.EquipmentDTO;
import lamhdt.dtos.RoleDTO;
import lamhdt.dtos.TribulationDTO;

/**
 *
 * @author HL
 */
public class MyValidation {
   
    private static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static Calendar cal = Calendar.getInstance();
    private Date d = new Date(0);
    public MyValidation() {
    }
    
    public static boolean validDate(String dateStr)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    
    public static boolean validDate(Date date)
    {
        return validDate(date.toLocalDate().format(df));
    }
    
    public  static  TribulationDTO validTribulation(String tribulationName, String place, String startDate, String endDate, String numOfShoot, String descrip) throws Exception {
        TribulationDTO dto = new TribulationDTO();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        boolean  check = false;
        String valid = "";
        dto.setTribulationName(tribulationName);
        dto.setPlace(place);
        try {
            dto.setStartDate(new Date(sdf.parse(startDate).getTime()));
        } catch (ParseException ee) {
            throw new Exception(" ! Invalid Start Date format(dd/mm/yyyy)");   
        }
        try {
            dto.setEndDate(new Date(sdf.parse(endDate).getTime()));
        } catch (ParseException eee) {
           throw new Exception("! Invalid End Date format(dd/mm/yyyy)");
        }
        if (dto.getEndDate().getTime() - dto.getStartDate().getTime() < 0) {
            throw new Exception(" ! Start Date must be less than End Date");
           // valid += "! Start Date must be less than End Date\n";
        }
        System.out.println(dto.getStartDate().toString());
        System.out.println(dto.getEndDate().toString());
        if(check)
            throw new Exception(valid);
        dto.setNumberOfShoot(numOfShoot);
        dto.setDescription(descrip);
        return dto;
    }
    
    public static ActorDTO validActor(String name, String phone, String email, String description, String image) throws Exception{
         ActorDTO dto = new ActorDTO();
         dto.setActorName(name);
         dto.setDescription(description);
         dto.setPhone(phone);
         dto.setEmail(email);
         dto.setImage(image);
        return dto;
    }
    
    public static EquipmentDTO validEquipment(String name, String quantity, String description, String image) throws Exception{
        EquipmentDTO dto = new EquipmentDTO();
        dto.setEquipmentName(name);
        dto.setQuantity(quantity);
        dto.setDescription(description);
        dto.setImage(image);
        return dto;
        
    }
    public static RoleDTO validRole(String roleName, String description) throws Exception{
        RoleDTO dto = new RoleDTO();
        dto.setRoleName(roleName);
        dto.setDescription(description);
        return dto;
    }
    
}
