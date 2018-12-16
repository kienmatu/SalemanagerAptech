/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author KIENDINH
 */
@Embeddable
public class BilldetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "BILLID")
    private int billid;
    @Basic(optional = false)
    @Column(name = "PRODUCTID")
    private int productid;

    public BilldetailPK() {
    }

    public BilldetailPK(int billid, int productid) {
        this.billid = billid;
        this.productid = productid;
    }

    public int getBillid() {
        return billid;
    }

    public void setBillid(int billid) {
        this.billid = billid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) billid;
        hash += (int) productid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BilldetailPK)) {
            return false;
        }
        BilldetailPK other = (BilldetailPK) object;
        if (this.billid != other.billid) {
            return false;
        }
        if (this.productid != other.productid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.BilldetailPK[ billid=" + billid + ", productid=" + productid + " ]";
    }
    
}
