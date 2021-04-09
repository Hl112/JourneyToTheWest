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
public class CastRoleDTO {
    private String roleName;
    private String actorName;
    private int IDActor;
    public CastRoleDTO() {
    }

    public CastRoleDTO(String roleName, String actorName) {
        this.roleName = roleName;
        this.actorName = actorName;
    }

    public CastRoleDTO(String actorName, int IDActor) {
        this.actorName = actorName;
        this.IDActor = IDActor;
    }
    

   
    
    
    
    public Vector toVector(){
        Vector v = new Vector();
        v.add(roleName);
        v.add(IDActor +" - "+ actorName);
        return v;
    }
    public Vector toVectorSelection(){
        Vector v = new Vector();
        v.add(IDActor);
        v.add(IDActor + " - " + actorName);
        return v;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public int getIDActor() {
        return IDActor;
    }

    public void setIDActor(int IDActor) {
        this.IDActor = IDActor;
    }
    
}
