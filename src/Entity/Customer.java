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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByCustid", query = "SELECT c FROM Customer c WHERE c.custid = :custid")
    , @NamedQuery(name = "Customer.findByCustname", query = "SELECT c FROM Customer c WHERE c.custname = :custname")
    , @NamedQuery(name = "Customer.findByCustaddress", query = "SELECT c FROM Customer c WHERE c.custaddress = :custaddress")
    , @NamedQuery(name = "Customer.findByCustphone", query = "SELECT c FROM Customer c WHERE c.custphone = :custphone")
    , @NamedQuery(name = "Customer.findByCustdob", query = "SELECT c FROM Customer c WHERE c.custdob = :custdob")
    , @NamedQuery(name = "Customer.findByCustregdate", query = "SELECT c FROM Customer c WHERE c.custregdate = :custregdate")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CUSTID")
    private Integer custid;
    @Basic(optional = false)
    @Column(name = "CUSTNAME")
    private String custname;
    @Column(name = "CUSTADDRESS")
    private String custaddress;
    @Column(name = "CUSTPHONE")
    private String custphone;
    @Column(name = "CUSTDOB")
    @Temporal(TemporalType.DATE)
    private Date custdob;
    @Column(name = "CUSTREGDATE")
    @Temporal(TemporalType.DATE)
    private Date custregdate;
    @OneToMany(mappedBy = "custid")
    private List<Bill> billList;

    public Customer() {
    }

    public Customer(Integer custid) {
        this.custid = custid;
    }

    public Customer(Integer custid, String custname) {
        this.custid = custid;
        this.custname = custname;
    }

    public Integer getCustid() {
        return custid;
    }

    public void setCustid(Integer custid) {
        this.custid = custid;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustaddress() {
        return custaddress;
    }

    public void setCustaddress(String custaddress) {
        this.custaddress = custaddress;
    }

    public String getCustphone() {
        return custphone;
    }

    public void setCustphone(String custphone) {
        this.custphone = custphone;
    }

    public Date getCustdob() {
        return custdob;
    }

    public void setCustdob(Date custdob) {
        this.custdob = custdob;
    }

    public Date getCustregdate() {
        return custregdate;
    }

    public void setCustregdate(Date custregdate) {
        this.custregdate = custregdate;
    }

    @XmlTransient
    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (custid != null ? custid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.custid == null && other.custid != null) || (this.custid != null && !this.custid.equals(other.custid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.custid+"";
    }
    
}
