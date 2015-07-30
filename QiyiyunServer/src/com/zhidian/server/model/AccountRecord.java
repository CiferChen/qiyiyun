package com.zhidian.server.model;
// default package



/**
 * AccountRecord entity. @author MyEclipse Persistence Tools
 */

public class AccountRecord  implements java.io.Serializable {


    // Fields    

     private String accountRecordId;
     private Integer accountType;
     private String accountOwnerId;
     private String operatorId;
     private String operateTime;
     private String operateReason;
     private Integer operateWay;
     private Double operateCount;
     private Integer operateType;


    // Constructors

    /** default constructor */
    public AccountRecord() {
    }

    
    /** full constructor */
    public AccountRecord(Integer accountType, String accountOwnerId, String operatorId, String operateTime, String operateReason, Integer operateWay, Double operateCount, Integer operateType) {
        this.accountType = accountType;
        this.accountOwnerId = accountOwnerId;
        this.operatorId = operatorId;
        this.operateTime = operateTime;
        this.operateReason = operateReason;
        this.operateWay = operateWay;
        this.operateCount = operateCount;
        this.operateType = operateType;
    }

   
    // Property accessors

    public String getAccountRecordId() {
        return this.accountRecordId;
    }
    
    public void setAccountRecordId(String accountRecordId) {
        this.accountRecordId = accountRecordId;
    }

    public Integer getAccountType() {
        return this.accountType;
    }
    
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getAccountOwnerId() {
        return this.accountOwnerId;
    }
    
    public void setAccountOwnerId(String accountOwnerId) {
        this.accountOwnerId = accountOwnerId;
    }

    public String getOperatorId() {
        return this.operatorId;
    }
    
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperateTime() {
        return this.operateTime;
    }
    
    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateReason() {
        return this.operateReason;
    }
    
    public void setOperateReason(String operateReason) {
        this.operateReason = operateReason;
    }

    public Integer getOperateWay() {
        return this.operateWay;
    }
    
    public void setOperateWay(Integer operateWay) {
        this.operateWay = operateWay;
    }

    public Double getOperateCount() {
        return this.operateCount;
    }
    
    public void setOperateCount(Double operateCount) {
        this.operateCount = operateCount;
    }

    public Integer getOperateType() {
        return this.operateType;
    }
    
    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }
   








}