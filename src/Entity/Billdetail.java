/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KIENDINH
 */
@Entity
@Table(name = "BILLDETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Billdetail.findAll", query = "SELECT b FROM Billdetail b")
    , @NamedQuery(name = "Billdetail.findByBillid", query = "SELECT b FROM Billdetail b WHERE b.billdetailPK.billid = :billid")
    , @NamedQuery(name = "Billdetail.findByProductid", query = "SELECT b FROM Billdetail b WHERE b.billdetailPK.productid = :productid")
    , @NamedQuery(name = "Billdetail.findByAmount", query = "SELECT b FROM Billdetail b WHERE b.amount = :amount")})
public class Billdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BilldetailPK billdetailPK;
    @Column(name = "AMOUNT")
    private Integer amount;
    @JoinColumn(name = "BILLID", referencedColumnName = "BILLID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bill bill;
    @JoinColumn(name = "PRODUCTID", referencedColumnName = "PRODUCTID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public Billdetail() {
    }

    public Billdetail(BilldetailPK billdetailPK) {
        this.billdetailPK = billdetailPK;
    }

    public Billdetail(int billid, int productid) {
        this.billdetailPK = new BilldetailPK(billid, productid);
    }

    public BilldetailPK getBilldetailPK() {
        return billdetailPK;
    }

    public void setBilldetailPK(BilldetailPK billdetailPK) {
        this.billdetailPK = billdetailPK;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billdetailPK != null ? billdetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Billdetail)) {
            return false;
        }
        Billdetail other = (Billdetail) object;
        if ((this.billdetailPK == null && other.billdetailPK != null) || (this.billdetailPK != null && !this.billdetailPK.equals(other.billdetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Billdetail[ billdetailPK=" + billdetailPK + " ]";
    }
    
}
