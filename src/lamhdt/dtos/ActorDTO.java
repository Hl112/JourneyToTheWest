/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamhdt.dtos;

import java.util.Vector;

/**
 *
 * @author HL
 */
public class ActorDTO {
    private int id;
    private String actorName;
    private String actorUsername;
    private String description;
    private String phone;
    private String email;
    private String image = "imgActor/noimg";;

    public ActorDTO() {
    }

    public ActorDTO(int id, String actorName, String actorUsername) {
        this.id = id;
        this.actorName = actorName;
        this.actorUsername = actorUsername;
    }

    public ActorDTO(int id, String actorName, String description, String phone, String email, String image) {
        this.id = id;
        this.actorName = actorName;
        this.description = description;
        this.phone = phone;
        this.email = email;
        this.image = image;
    }

    public ActorDTO(String actorName, String description, String phone, String email, String image) {
        this.actorName = actorName;
        this.description = description;
        this.phone = phone;
        this.email = email;
        this.image = image;
    }

    
    
    
    public Vector toVector()
    {
        Vector v = new Vector();
        v.add(id);
        v.add(actorName);
        v.add(actorUsername);
        return v;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) throws Exception{
        if(actorName.equals("")) throw new Exception(" ! Please Input Actor Name");
        this.actorName = actorName;
    }

    public String getActorUsername() {
        return actorUsername;
    }

    public void setActorUsername(String actorUsername) {
        this.actorUsername = actorUsername;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws Exception{
        if(!phone.equals("") && !phone.matches("[0-9]{10,11}")) throw new Exception("Phone is Number has 10, 11 number");
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception{
        if(!email.equals("") && !email.matches("\\w+@\\w+.\\w+")) throw new Exception("Email has format (abc@fpt.vn)"); 
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
