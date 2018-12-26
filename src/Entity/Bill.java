/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author KIENDINH
 */
@Entity
@Table(name = "BILL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b")
    , @NamedQuery(name = "Bill.findByBillid", query = "SELECT b FROM Bill b WHERE b.billid = :billid")
    , @NamedQuery(name = "Bill.findByBilldate", query = "SELECT b FROM Bill b WHERE b.billdate = :billdate")})
public class Bill implements Serializable {

    @JoinColumn(name = "CUSTID", referencedColumnName = "CUSTID")
    @ManyToOne
    private Customer custid;
    @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
    @ManyToOne
    private Employee username;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BILLID")
    private Integer billid;
    @Column(name = "BILLDATE")
    @Temporal(TemporalType.DATE)
    private Date billdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private List<Billdetail> billdetailList;

    public Bill() {
    }

    public Bill(Integer billid) {
        this.billid = billid;
    }

    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
    }

    public Date getBilldate() {
        return billdate;
    }

    public void setBilldate(Date billdate) {
        this.billdate = billdate;
    }

    @XmlTransient
    public List<Billdetail> getBilldetailList() {
        return billdetailList;
    }

    public void setBilldetailList(List<Billdetail> billdetailList) {
        this.billdetailList = billdetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billid != null ? billid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.billid == null && other.billid != null) || (this.billid != null && !this.billid.equals(other.billid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Bill[ billid=" + billid + " ]";
    }

    public Customer getCustid() {
        return custid;
    }

    public void setCustid(Customer custid) {
        this.custid = custid;
    }

    public Employee getUsername() {
        return username;
    }

    public void setUsername(Employee username) {
        this.username = username;
    }

}
