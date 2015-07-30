package com.zhidian.server.model;
// default package



/**
 * ActivityRegisterRecord entity. @author MyEclipse Persistence Tools
 */

public class ActivityRegisterRecord  implements java.io.Serializable {


    // Fields    

     private String activityRegisterId;
     private String activityRegisterName;
     private String activityRegisterPhone;
     private String activityOrganId;
     private Integer activityRegisterIsDelete;


    // Constructors

    /** default constructor */
    public ActivityRegisterRecord() {
    }

    
    /** full constructor */
    public ActivityRegisterRecord(String activityRegisterName, String activityRegisterPhone, String activityOrganId, Integer activityRegisterIsDelete) {
        this.activityRegisterName = activityRegisterName;
        this.activityRegisterPhone = activityRegisterPhone;
        this.activityOrganId = activityOrganId;
        this.activityRegisterIsDelete = activityRegisterIsDelete;
    }

   
    // Property accessors

    public String getActivityRegisterId() {
        return this.activityRegisterId;
    }
    
    public void setActivityRegisterId(String activityRegisterId) {
        this.activityRegisterId = activityRegisterId;
    }

    public String getActivityRegisterName() {
        return this.activityRegisterName;
    }
    
    public void setActivityRegisterName(String activityRegisterName) {
        this.activityRegisterName = activityRegisterName;
    }

    public String getActivityRegisterPhone() {
        return this.activityRegisterPhone;
    }
    
    public void setActivityRegisterPhone(String activityRegisterPhone) {
        this.activityRegisterPhone = activityRegisterPhone;
    }

    public String getActivityOrganId() {
        return this.activityOrganId;
    }
    
    public void setActivityOrganId(String activityOrganId) {
        this.activityOrganId = activityOrganId;
    }

    public Integer getActivityRegisterIsDelete() {
        return this.activityRegisterIsDelete;
    }
    
    public void setActivityRegisterIsDelete(Integer activityRegisterIsDelete) {
        this.activityRegisterIsDelete = activityRegisterIsDelete;
    }
   








}