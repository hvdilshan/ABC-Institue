/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allocateTime_modifySessions;

/**
 *
 * @author RPsandeepa
 */
public class NonOverlappingSession {
    
    private int id;
    private String sGid;
    private String cSession;
    private String SessionID;
    
    public NonOverlappingSession(){
        
    }
    
    public NonOverlappingSession(int id, String sGid, String cSession, String SessionID) {
        this.id = id;
        this.sGid = sGid;
        this.cSession = cSession;
        this.SessionID = SessionID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getsGid() {
        return sGid;
    }

    public void setsGid(String sGid) {
        this.sGid = sGid;
    }

    public String getcSession() {
        return cSession;
    }

    public void setcSession(String cSession) {
        this.cSession = cSession;
    }

    public String getSessionID() {
        return SessionID;
    }

    public void setSessionID(String SessionID) {
        this.SessionID = SessionID;
    }
    
}
