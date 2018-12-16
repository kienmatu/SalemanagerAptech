/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KIENDINH
 */
@Entity
@Table(name = "COMPANYINFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companyinfo.findAll", query = "SELECT c FROM Companyinfo c")
    , @NamedQuery(name = "Companyinfo.findByCompanyname", query = "SELECT c FROM Companyinfo c WHERE c.companyname = :companyname")
    , @NamedQuery(name = "Companyinfo.findByCompanyaddress", query = "SELECT c FROM Companyinfo c WHERE c.companyaddress = :companyaddress")
    , @NamedQuery(name = "Companyinfo.findByCompanyphone", query = "SELECT c FROM Companyinfo c WHERE c.companyphone = :companyphone")
    , @NamedQuery(name = "Companyinfo.findByConcurency", query = "SELECT c FROM Companyinfo c WHERE c.concurency = :concurency")})
public class Companyinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COMPANYNAME")
    private String companyname;
    @Column(name = "COMPANYADDRESS")
    private String companyaddress;
    @Column(name = "COMPANYPHONE")
    private String companyphone;
    @Column(name = "CONCURENCY")
    private String concurency;

    public Companyinfo() {
    }

    public Companyinfo(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyaddress() {
        return companyaddress;
    }

    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress;
    }

    public String getCompanyphone() {
        return companyphone;
    }

    public void setCompanyphone(String companyphone) {
        this.companyphone = companyphone;
    }

    public String getConcurency() {
        return concurency;
    }

    public void setConcurency(String concurency) {
        this.concurency = concurency;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyname != null ? companyname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Companyinfo)) {
            return false;
        }
        Companyinfo other = (Companyinfo) object;
        if ((this.companyname == null && other.companyname != null) || (this.companyname != null && !this.companyname.equals(other.companyname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Companyinfo[ companyname=" + companyname + " ]";
    }
    
}
