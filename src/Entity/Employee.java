/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "EMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByUsername", query = "SELECT e FROM Employee e WHERE e.username = :username")
    , @NamedQuery(name = "Employee.findByPass", query = "SELECT e FROM Employee e WHERE e.pass = :pass")
    , @NamedQuery(name = "Employee.findByIsadmin", query = "SELECT e FROM Employee e WHERE e.isadmin = :isadmin")
    , @NamedQuery(name = "Employee.findByEmpname", query = "SELECT e FROM Employee e WHERE e.empname = :empname")
    , @NamedQuery(name = "Employee.findByEmpphone", query = "SELECT e FROM Employee e WHERE e.empphone = :empphone")
    , @NamedQuery(name = "Employee.findByEmpstartdate", query = "SELECT e FROM Employee e WHERE e.empstartdate = :empstartdate")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASS")
    private String pass;
    @Column(name = "ISADMIN")
    private Integer isadmin = 0;
    @Basic(optional = false)
    @Column(name = "EMPNAME")
    private String empname;
    @Column(name = "EMPPHONE")
    private String empphone;
    @Column(name = "EMPSTARTDATE")
    @Temporal(TemporalType.DATE)
    private Date empstartdate;
    @OneToMany(mappedBy = "username")
    private Collection<Bill> billCollection;

    public Employee() {
    }

    public Employee(String username) {
        this.username = username;
    }

    public Employee(String user, String pass, String name, String phone, Date date) {
        this.username = user;
        this.pass = pass;
        this.empname = name;
        this.empphone = phone;
        this.empstartdate = date;

    }

    public Employee(String username, String pass, String empname) {
        this.username = username;
        this.pass = pass;
        this.empname = empname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Integer isadmin) {
        this.isadmin = isadmin;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpphone() {
        return empphone;
    }

    public void setEmpphone(String empphone) {
        this.empphone = empphone;
    }

    public Date getEmpstartdate() {
        return empstartdate;
    }

    public void setEmpstartdate(Date empstartdate) {
        this.empstartdate = empstartdate;
    }

    @XmlTransient
    public Collection<Bill> getBillCollection() {
        return billCollection;
    }

    public void setBillCollection(Collection<Bill> billCollection) {
        this.billCollection = billCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return username;
    }

}
