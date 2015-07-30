package com.zhidian.server.model;
// default package



/**
 * MemberRelRecord entity. @author MyEclipse Persistence Tools
 */

public class MemberRelRecord  implements java.io.Serializable {


    // Fields    

     private String memberRelRecordId;
     private String memberId;
     private String organId;
     private Integer recordDirection;
     private Integer recordStatus;
     private String recordCreateTime;
     private String recordRespondTime;
     private Integer recordIsDelete;


    // Constructors

    /** default constructor */
    public MemberRelRecord() {
    }

	/** minimal constructor */
    public MemberRelRecord(String memberId, String organId, Integer recordDirection, Integer recordStatus, String recordCreateTime, Integer recordIsDelete) {
        this.memberId = memberId;
        this.organId = organId;
        this.recordDirection = recordDirection;
        this.recordStatus = recordStatus;
        this.recordCreateTime = recordCreateTime;
        this.recordIsDelete = recordIsDelete;
    }
    
    /** full constructor */
    public MemberRelRecord(String memberId, String organId, Integer recordDirection, Integer recordStatus, String recordCreateTime, String recordRespondTime, Integer recordIsDelete) {
        this.memberId = memberId;
        this.organId = organId;
        this.recordDirection = recordDirection;
        this.recordStatus = recordStatus;
        this.recordCreateTime = recordCreateTime;
        this.recordRespondTime = recordRespondTime;
        this.recordIsDelete = recordIsDelete;
    }

   
    // Property accessors

    public String getMemberRelRecordId() {
        return this.memberRelRecordId;
    }
    
    public void setMemberRelRecordId(String memberRelRecordId) {
        this.memberRelRecordId = memberRelRecordId;
    }

    public String getMemberId() {
        return this.memberId;
    }
    
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getOrganId() {
        return this.organId;
    }
    
    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public Integer getRecordDirection() {
        return this.recordDirection;
    }
    
    public void setRecordDirection(Integer recordDirection) {
        this.recordDirection = recordDirection;
    }

    public Integer getRecordStatus() {
        return this.recordStatus;
    }
    
    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getRecordCreateTime() {
        return this.recordCreateTime;
    }
    
    public void setRecordCreateTime(String recordCreateTime) {
        this.recordCreateTime = recordCreateTime;
    }

    public String getRecordRespondTime() {
        return this.recordRespondTime;
    }
    
    public void setRecordRespondTime(String recordRespondTime) {
        this.recordRespondTime = recordRespondTime;
    }

    public Integer getRecordIsDelete() {
        return this.recordIsDelete;
    }
    
    public void setRecordIsDelete(Integer recordIsDelete) {
        this.recordIsDelete = recordIsDelete;
    }
   








}