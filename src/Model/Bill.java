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
public class Bill {

    private String USERNAME,PRODUCT;
    private int BillID;
    private int CustID;
    private Date BillDate;

    public Bill(String USERNAME, String PRODUCT, int BillID, int CustID, Date BillDate) {
        this.USERNAME = USERNAME;
        this.PRODUCT = PRODUCT;
        this.BillID = BillID;
        this.CustID = CustID;
        this.BillDate = BillDate;
    }
    
    public String getUSERNAME() {
        return USERNAME;
    }

    public String getPRODUCT() {
        return PRODUCT;
    }

    public int getBillID() {
        return BillID;
    }

    public int getCustID() {
        return CustID;
    }

    public Date getBillDate() {
        return BillDate;
    }

    public void setUserName(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public void setProduct(String PRODUCT) {
        this.PRODUCT = PRODUCT;
    }

    public void setBillID(int BillID) {
        this.BillID = BillID;
    }

    public void setCustID(int CustID) {
        this.CustID = CustID;
    }

    public void setBillDate(Date BillDate) {
        this.BillDate = BillDate;
    }
}
// ----HOADON
//CREATE TABLE BILL(
//	BILLID	int identity(1,1) PRIMARY KEY not null,
//	BILLDATE 	smalldatetime,
//	CUSTID INT,
//	USERNAME 	varchar(10) foreign key  references EMPLOYEE(USERNAME),
//	PRODUCT ntext,-- LIÊN KẾT TỚI INTERFACE PRODUCT TRONG ĐÓ, XÀI ARRAYLIST tostring.
//	-- BAO GOM ID, SO LUONG, GIA TIEN,...
//	----AMOUNT	money,
//)

