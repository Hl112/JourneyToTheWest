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
public class UsedRoleDTO {

    private String tribulationName;
    private String roleName;
    private int tribulationID;

    public UsedRoleDTO() {
    }

    public UsedRoleDTO(String tribulationName, String roleName) {
        this.tribulationName = tribulationName;
        this.roleName = roleName;
    }

    public UsedRoleDTO(String roleName, int id) {
        this.roleName = roleName;
        this.tribulationID = id;
    }

    public String getTribulationName() {
        return tribulationName;
    }

    public void setTribulationName(String tribulationName) {
        this.tribulationName = tribulationName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getId() {
        return tribulationID;
    }

    public void setId(int id) {
        this.tribulationID = id;
    }

    public Vector toVector() {
        Vector v = new Vector();
        v.add(roleName);
        v.add(tribulationName);
        return v;
    }

}
