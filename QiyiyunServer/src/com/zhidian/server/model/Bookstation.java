package com.zhidian.server.model;
// default package



/**
 * Bookstation entity. @author MyEclipse Persistence Tools
 */

public class Bookstation  implements java.io.Serializable {


    // Fields    

     private String bookstationId;
     private String bookstationName;
     private String bookstationPhone;
     private String bookstationEmail;


    // Constructors

    /** default constructor */
    public Bookstation() {
    }

	/** minimal constructor */
    public Bookstation(String bookstationName, String bookstationPhone) {
        this.bookstationName = bookstationName;
        this.bookstationPhone = bookstationPhone;
    }
    
    /** full constructor */
    public Bookstation(String bookstationName, String bookstationPhone, String bookstationEmail) {
        this.bookstationName = bookstationName;
        this.bookstationPhone = bookstationPhone;
        this.bookstationEmail = bookstationEmail;
    }

   
    // Property accessors

    public String getBookstationId() {
        return this.bookstationId;
    }
    
    public void setBookstationId(String bookstationId) {
        this.bookstationId = bookstationId;
    }

    public String getBookstationName() {
        return this.bookstationName;
    }
    
    public void setBookstationName(String bookstationName) {
        this.bookstationName = bookstationName;
    }

    public String getBookstationPhone() {
        return this.bookstationPhone;
    }
    
    public void setBookstationPhone(String bookstationPhone) {
        this.bookstationPhone = bookstationPhone;
    }

    public String getBookstationEmail() {
        return this.bookstationEmail;
    }
    
    public void setBookstationEmail(String bookstationEmail) {
        this.bookstationEmail = bookstationEmail;
    }
   








}