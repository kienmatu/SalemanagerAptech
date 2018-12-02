/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author KIENDINH
 */
public class Customer {
    private int CustID;
    private String CustName,CustAddress,CustPhone;
    private Date CustDOB,CustRegDate;

    public Customer(int CustID, String CustName, String CustAddress, String CustPhone, Date CustDOB, Date CustRegDate) {
        this.CustID = CustID;
        this.CustName = CustName;
        this.CustAddress = CustAddress;
        this.CustPhone = CustPhone;
        this.CustDOB = CustDOB;
        this.CustRegDate = CustRegDate;
    }

    public int getCustID() {
        return CustID;
    }

    public String getCustName() {
        return CustName;
    }

    public String getCustAddress() {
        return CustAddress;
    }

    public String getCustPhone() {
        return CustPhone;
    }

    public Date getCustDOB() {
        return CustDOB;
    }

    public Date getCustRegDate() {
        return CustRegDate;
    }

    public void setCustID(int CustID) {
        this.CustID = CustID;
    }

    public void setCustName(String CustName) {
        this.CustName = CustName;
    }

    public void setCustAddress(String CustAddress) {
        this.CustAddress = CustAddress;
    }

    public void setCustPhone(String CustPhone) {
        this.CustPhone = CustPhone;
    }

    public void setCustDOB(Date CustDOB) {
        this.CustDOB = CustDOB;
    }

    public void setCustRegDate(Date CustRegDate) {
        this.CustRegDate = CustRegDate;
    }
    
}

//-------------------------------------------
//CREATE TABLE CUSTOMER(
//	CUSTID	int identity(1,1) PRIMARY KEY not null,	
//	CUSTNAME	nvarchar(40) NOT NULL,
//	CUSTADDRESS	nvarchar(50),
//	CUSTPHONE	varchar(20),
//	CUSTDOB	smalldatetime, -- ngày sinh
//	CUSTREGDATE	smalldatetime, -- ngày đăng ký
//)
//-----------------------------------------------
//-- NHANVIEN

