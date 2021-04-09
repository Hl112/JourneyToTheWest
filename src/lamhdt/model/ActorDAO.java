/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamhdt.model;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lamhdt.db.MyConnection;
import lamhdt.dtos.ActorDTO;

/**
 *
 * @author HL
 */
public class ActorDAO {

    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

    public ActorDAO() {
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

    public List<ActorDTO> getAllActor() throws Exception {
        List<ActorDTO> result = null;
        ActorDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select actorID, actorName, username From Actor";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int actorID = rs.getInt("actorID");
                String actorName = rs.getNString("actorName");
                String username = rs.getString("username");
                dto = new ActorDTO(actorID, actorName, username);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ActorDTO> getActorByName(String name) throws Exception {
        List<ActorDTO> result = null;
        ActorDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select actorID, actorName, username From Actor Where actorName Like ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + name + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int actorID = rs.getInt("actorID");
                String actorName = rs.getNString("actorName");
                String username = rs.getString("username");
                dto = new ActorDTO(actorID, actorName, username);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public String getNameByUsername(String username) throws Exception {
        String name = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select actorName From Actor Where username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if (rs.next()) {
                name = rs.getNString("actorName");
            }
        } finally {
            closeConnection();
        }
        return name;
    }

    public ActorDTO getActorByID(int actorID) throws Exception {
        ActorDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select actorName, phone, email, description, image From Actor Where actorID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, actorID);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String actorName = rs.getNString("actorName");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String description = rs.getNString("description");
                String image = rs.getString("image");
                dto = new ActorDTO(actorID, actorName, description, phone, email, image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public int getIDByUsername(String username) throws Exception{
        int id = -1;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select actorID From Actor Where Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if(rs.next())
                id = rs.getInt("actorID");
        } finally{
            closeConnection();
        }
        return id;
    }

    public boolean createActor(ActorDTO dto) throws Exception {
        boolean check = false;
        String linkImg = null;
        boolean checkLink = false;
        try {

            File f = new File(dto.getImage());
            if (f.exists()) {
                if (f.isFile()) {
                    linkImg = "imgActor/" + dto.getActorUsername();
                    checkLink = true;
                } else {
                    linkImg = "imgActor/noimg.jpg";
                    checkLink = false;
                }
            }
            conn = MyConnection.getConnection();
            String sql = "Insert Into Actor(username, actorName, image, description, phone, email) VALUES(?,?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getActorUsername());
            preStm.setString(2, dto.getActorName());
            preStm.setString(3, linkImg);
            preStm.setString(4, dto.getDescription());
            preStm.setString(5, dto.getPhone());
            preStm.setString(6, dto.getEmail());
            check = preStm.executeUpdate() > 0;
            if (checkLink) {
                FileDAO.copyFile(dto.getImage(), "imgActor", dto.getActorUsername());
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateActorByID(int actorID, ActorDTO dto) throws Exception {
        boolean check = false;
        boolean checkLink = false;
        String linkImg = null;
        try {

            File f = new File(dto.getImage());
            if (f.exists()) {
                if (f.isFile()) {
                    linkImg = "imgActor/" + dto.getActorUsername();
                    checkLink = true;
                } else {
                    linkImg = "imgActor/noimg.jpg";
                    checkLink = false;
                }
            }

            conn = MyConnection.getConnection();
            String sql = "Update Actor Set actorName = ?, image = ?, description = ?, phone = ?,email = ? Where actorID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getActorName());
            preStm.setString(2, linkImg);
            preStm.setString(3, dto.getDescription());
            preStm.setString(4, dto.getPhone());
            preStm.setString(5, dto.getEmail());
            preStm.setInt(6, actorID);
            check = preStm.executeUpdate() > 0;
            if (checkLink) {
                FileDAO.copyFile(dto.getImage(), "imgActor", dto.getActorUsername());
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean deleteActorByID(int actorID, String username, String fileName) throws Exception {
        boolean check = false;
        boolean checkImg = false;
        try {
            File f = new File("imgActor/" + fileName);
            if (f.exists()) {
                if (f.isFile()) {
                    checkImg = true;
                }
            }
            conn = MyConnection.getConnection();
            String sql = "Update Role set IDActor = null where IDActor = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, actorID);
            check = preStm.executeUpdate() > 0;
            sql = "Delete From Actor Where actorID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, actorID);
            check = preStm.executeUpdate() > 0;
            UserDAO userDAO = new UserDAO();
            check = userDAO.deleteUser(username);
            if (checkImg) {
                FileDAO.deleteFile("imgActor/" + fileName);
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    
       public int countActor() throws Exception {
        int count = 0;
        try {
            conn = MyConnection.getConnection();
           String sql = "Select COUNT(actorID) as CActor FROM Actor";
           preStm = conn.prepareStatement(sql);
           rs = preStm.executeQuery();
           if(rs.next())
               count = rs.getInt("CActor");
        } finally {
            closeConnection();
        }
        return count;
    }
}
