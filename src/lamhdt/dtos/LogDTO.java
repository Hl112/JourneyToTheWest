/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamhdt.dtos;

import java.sql.Timestamp;

/**
 *
 * @author HL
 */
public class LogDTO implements Comparable<LogDTO>{
   private int id;
   private String roleNew;
   private int actorID;
   private String event;
   private int isNew;
   private Timestamp time;

    public LogDTO() {
    }

    public LogDTO(int id, String roleNew, int actorID, String event, int isNew, Timestamp time) {
        this.id = id;
        this.roleNew = roleNew;
        this.actorID = actorID;
        this.event = event;
        this.isNew = isNew;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleNew() {
        return roleNew;
    }

    public void setRoleNew(String roleNew) {
        this.roleNew = roleNew;
    }

    public int getActorID() {
        return actorID;
    }

    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "LogDTO{" + "id=" + id + ", roleNew=" + roleNew + ", actorID=" + actorID + ", event=" + event + ", isNew=" + isNew + ", time=" + time + '}';
    }

    @Override
    public int compareTo(LogDTO o) {
        
    return (time.compareTo(o.time));
//        if(getIsNew() > o.getIsNew()) return -1;
//        if(getIsNew() < o.getIsNew()) return 1;
      
    }
   
    
   
}
