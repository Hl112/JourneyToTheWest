/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamhdt.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lamhdt.db.MyConnection;
import lamhdt.dtos.UserDTO;

/**
 *
 * @author HL
 */
public class UserDAO {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public UserDAO() {
    }

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public int checkLogin(UserDTO dto) throws Exception {
        int permission = -1;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select Permission From \"User\" Where Username = ? And Password = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            rs = preStm.executeQuery();
            if (rs.next()) {
                permission = rs.getInt("Permission");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return permission;
    }

    public UserDTO AutoRegistration() throws Exception {
        boolean check = false;
        UserDTO dto = null;
        String username = "actor";
        String password = "123";
        try {
            int id = 0;
            conn = MyConnection.getConnection();
            String sql = "Select Top 1 actorID From Actor Order BY actorID DESC";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if (rs.next()) {
                id = rs.getInt("actorID");
            }
            username += (++id);
            dto = new UserDTO(username, password);
            sql = "Insert Into \"User\"(Username, Password) Values(?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean deleteUser(String username) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete From \"User\" Where Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateInfo(String newUsername, String username) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "ALTER TABLE Actor DROP CONSTRAINT FK_Actor_User";
            preStm = conn.prepareStatement(sql);
            preStm.execute();
            sql = "Update \"User\" SET username = ? WHERE username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, newUsername);
            preStm.setString(2, username);
            check = preStm.executeUpdate() > 0;
            sql = "Update Actor SET username = ?  WHERE username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, newUsername);
            preStm.setString(2, username);
            check = preStm.executeUpdate() > 0;
        } finally {
            String sql = "ALTER TABLE Actor ADD CONSTRAINT FK_Actor_User FOREIGN KEY (username) REFERENCES \"User\"(username)";
            preStm = conn.prepareStatement(sql);
            preStm.execute();
            closeConnection();
        }
        return check;
    }

    public boolean changePassword(UserDTO dto) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "Update \"User\" SET password = ? Where username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getPassword());
            preStm.setString(2, dto.getUsername());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

}
