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
public class RoleDTO {
    private String roleName;
    private int actorID;
    private String description = "";

    public RoleDTO() {
    }

    public RoleDTO(String roleName) {
        this.roleName = roleName;
    }

    
    public RoleDTO(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }
    public Vector toVector(){
        Vector v = new Vector();
        v.add(roleName);
        return v;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) throws Exception{
        if(roleName.equals("")) throw new Exception("Please Input Role Name");
        this.roleName = roleName;
    }

    public int getActorID() {
        return actorID;
    }

    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description.equals("")) this.description = "No Description";
        this.description = description;
    }
    
    
    
}
