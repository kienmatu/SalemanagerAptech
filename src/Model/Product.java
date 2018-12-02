/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author KIENDINH
 */
public class Product {
    private int ProductID;
    private String ProductName,Unit,Company;
    private float money;
    private int amount;

    public Product(int ProductID, String ProductName, String Unit, String Company, float money, int amount) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.Unit = Unit;
        this.Company = Company;
        this.money = money;
        this.amount = amount;
    }

    public int getProductID() {
        return ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getUnit() {
        return Unit;
    }

    public String getCompany() {
        return Company;
    }

    public float getMoney() {
        return money;
    }

    public int getAmount() {
        return amount;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
//-- SANPHAM
//CREATE TABLE PRODUCT(
//	PRODUCTID int identity(1,1) PRIMARY KEY not null,
//	PRODUCTNAME	nvarchar(40),
//	UNIT	nvarchar(20),
//	AMOUNT int, -- tồn kho
//	COMPANY	varchar(40),
//	PRICE	money,
//)
