package com.zhidian.server.model;
// default package



/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account  implements java.io.Serializable {


    // Fields    

     private String accountId;
     private Integer accountType;
     private String accountOwnerId;
     private Double accountBalance;
     private Double accountMarginBalance;


    // Constructors

    /** default constructor */
    public Account() {
    }

    
    /** full constructor */
    public Account(Integer accountType, String accountOwnerId, Double accountBalance, Double accountMarginBalance) {
        this.accountType = accountType;
        this.accountOwnerId = accountOwnerId;
        this.accountBalance = accountBalance;
        this.accountMarginBalance = accountMarginBalance;
    }

   
    // Property accessors

    public String getAccountId() {
        return this.accountId;
    }
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public Double getAccountBalance() {
        return this.accountBalance;
    }
    
    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Double getAccountMarginBalance() {
        return this.accountMarginBalance;
    }
    
    public void setAccountMarginBalance(Double accountMarginBalance) {
        this.accountMarginBalance = accountMarginBalance;
    }
   








}