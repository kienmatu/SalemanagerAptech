/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author KIENDINH
 */
public class CustomProductViewModel {
//    private Integer productid;
//    private String productname;
//    private String unit;
//    private Integer billamount;
//    //private String company;
//    private float price;
//    private String productcode;
//    private String details;
//    private Category categoryid;
    private Integer productid;
    private String productname;
    private String unit;
    private Integer billamount;
    private String company;
    private float price;
    private String productcode;
    private String details;

    public CustomProductViewModel(String productname, String unit, Integer billamount, float price, String productcode) {
        this.productname = productname;
        this.unit = unit;
        this.billamount = billamount;
        this.price = price;
        this.productcode = productcode;
    }
    
    
    
    
    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setBillamount(Integer billamount) {
        this.billamount = billamount;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public void setDetails(String details) {
        this.details = details;
    }

//    public void setCategoryid(Category categoryid) {
//        this.categoryid = categoryid;
//    }

    public Integer getProductid() {
        return productid;
    }

    public String getProductname() {
        return productname;
    }

    public String getUnit() {
        return unit;
    }

    public Integer getBillamount() {
        return billamount;
    }

    public float getPrice() {
        return price;
    }

    public String getProductcode() {
        return productcode;
    }

    public String getDetails() {
        return details;
    }

//    public Category getCategoryid() {
//        return categoryid;
//    }
}
