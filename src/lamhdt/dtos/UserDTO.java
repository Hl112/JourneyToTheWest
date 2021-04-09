/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamhdt.dtos;

/**
 *
 * @author HL
 */
public class UserDTO {
    private String username;
    private String password;
    private int permision;

    public UserDTO() {
    }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDTO(String username, String password, int permision) {
        this.username = username;
        this.password = password;
        this.permision = permision;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermision() {
        return permision;
    }

    public void setPermision(int permision) {
        this.permision = permision;
    }
    
    
}
