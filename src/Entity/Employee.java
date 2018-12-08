/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
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

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASS")
    private String pass;
    @Column(name = "ISADMIN")
    private Integer isadmin;
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

    public Employee(String username, String pass, String empname) {
        this.username = username;
        this.pass = pass;
        this.empname = empname;
    }

    public Employee(String username, String pass, String empname, String phone, Date date) {
        this.username = username;
        this.pass = pass;
        this.empname = empname;
        this.empstartdate = date;
        this.empphone = phone;
        this.isadmin = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        changeSupport.firePropertyChange("username", oldUsername, username);
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        String oldPass = this.pass;
        this.pass = pass;
        changeSupport.firePropertyChange("pass", oldPass, pass);
    }

    public Integer getIsadmin() {
        if(isadmin !=null)
        {
        return isadmin;
        }
        else
        {
            return 0;
        }
    }

    public void setIsadmin(Integer isadmin) {
        Integer oldIsadmin = this.isadmin;
        this.isadmin = isadmin;
        changeSupport.firePropertyChange("isadmin", oldIsadmin, isadmin);
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        String oldEmpname = this.empname;
        this.empname = empname;
        changeSupport.firePropertyChange("empname", oldEmpname, empname);
    }

    public String getEmpphone() {
        return empphone;
    }

    public void setEmpphone(String empphone) {
        String oldEmpphone = this.empphone;
        this.empphone = empphone;
        changeSupport.firePropertyChange("empphone", oldEmpphone, empphone);
    }

    public Date getEmpstartdate() {
        return empstartdate;
    }

    public void setEmpstartdate(Date empstartdate) {
        Date oldEmpstartdate = this.empstartdate;
        this.empstartdate = empstartdate;
        changeSupport.firePropertyChange("empstartdate", oldEmpstartdate, empstartdate);
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
        return "Entity.Employee[ username=" + username + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
