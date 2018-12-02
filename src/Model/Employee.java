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
public class Employee {
    private String UserName,Pass,EmpName,EmpPhone;
    private int isAdmin = 0;
    private Date EmpStartDate;

    public Employee(String UserName, String Pass, String EmpName, String EmpPhone, Date EmpStartDate) {
        this.UserName = UserName;
        this.Pass = Pass;
        this.EmpName = EmpName;
        this.EmpPhone = EmpPhone;
        this.EmpStartDate = EmpStartDate;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPass() {
        return Pass;
    }

    public String getEmpName() {
        return EmpName;
    }

    public String getEmpPhone() {
        return EmpPhone;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public Date getEmpStartDate() {
        return EmpStartDate;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }

    public void setEmpPhone(String EmpPhone) {
        this.EmpPhone = EmpPhone;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setEmpStartDate(Date EmpStartDate) {
        this.EmpStartDate = EmpStartDate;
    }
    
}
//CREATE TABLE EMPLOYEE(
//    --EMPID	int identity(1,1) PRIMARY KEY not null,	
//	USERNAME varchar(10) not null primary key,
//	PASS varchar(30) not null,
//	ISADMIN int, -- 1 là admin, 0 hoặc null là employee
//	EMPNAME	nvarchar(40) NOT NULL,
//	EMPPHONE	nvarchar(20),
//	EMPSTARTDATE	smalldatetime	
//)
//-----------------------------------------------
