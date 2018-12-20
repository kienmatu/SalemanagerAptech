/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author KIENDINH
 */
@Entity
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findByProductid", query = "SELECT p FROM Product p WHERE p.productid = :productid")
    , @NamedQuery(name = "Product.findByProductname", query = "SELECT p FROM Product p WHERE p.productname = :productname")
    , @NamedQuery(name = "Product.findByUnit", query = "SELECT p FROM Product p WHERE p.unit = :unit")
    , @NamedQuery(name = "Product.findByAmount", query = "SELECT p FROM Product p WHERE p.amount = :amount")
    , @NamedQuery(name = "Product.findByCompany", query = "SELECT p FROM Product p WHERE p.company = :company")
    , @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price")
    , @NamedQuery(name = "Product.findByProductcode", query = "SELECT p FROM Product p WHERE p.productcode = :productcode")
    , @NamedQuery(name = "Product.findByDetails", query = "SELECT p FROM Product p WHERE p.details = :details")
    , @NamedQuery(name = "Product.findByCategoryid", query = "SELECT p FROM Product p WHERE p.categoryid = :categoryid")
})

//String productname, String unit, Integer billamount, float price, String productcode
//    @SqlResultSetMapping(name="ProductViewModelMapping",classes = {
//     @ConstructorResult(targetClass = CustomProductViewModel.class,
//       columns = {@ColumnResult(name="PRODUCTNAME"), @ColumnResult(name="UNIT"),
//           @ColumnResult(name="AMOUNT"), @ColumnResult(name="PRICE"), @ColumnResult(name="PRODUCTCODE")}
//     )}
//)
public class Product implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "PRODUCTID")
    private Integer productid;
    @Column(name = "PRODUCTNAME")
    private String productname;
    @Column(name = "UNIT")
    private String unit;
    @Column(name = "AMOUNT")
    private Integer amount;
    @Column(name = "COMPANY")
    private String company;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private float price;
    @Column(name = "PRODUCTCODE")
    private String productcode;
    @Column(name = "DETAILS")
    private String details;
    @JoinColumn(name = "CATEGORYID", referencedColumnName = "CATEGORYID")
    @ManyToOne
    private Category categoryid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")

    private Collection<Billdetail> billdetailCollection;

    public Product() {
    }

    public Product(Integer productid) {
        this.productid = productid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        Integer oldProductid = this.productid;
        this.productid = productid;
        changeSupport.firePropertyChange("productid", oldProductid, productid);
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        String oldProductname = this.productname;
        this.productname = productname;
        changeSupport.firePropertyChange("productname", oldProductname, productname);
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        String oldUnit = this.unit;
        this.unit = unit;
        changeSupport.firePropertyChange("unit", oldUnit, unit);
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        Integer oldAmount = this.amount;
        this.amount = amount;
        changeSupport.firePropertyChange("amount", oldAmount, amount);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        String oldCompany = this.company;
        this.company = company;
        changeSupport.firePropertyChange("company", oldCompany, company);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        float oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        String oldProductcode = this.productcode;
        this.productcode = productcode;
        changeSupport.firePropertyChange("productcode", oldProductcode, productcode);
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        String oldDetails = this.details;
        this.details = details;
        changeSupport.firePropertyChange("details", oldDetails, details);
    }

    public Category getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Category categoryid) {
        Category oldCategoryid = this.categoryid;
        this.categoryid = categoryid;
        changeSupport.firePropertyChange("categoryid", oldCategoryid, categoryid);
    }

    @XmlTransient
    public Collection<Billdetail> getBilldetailCollection() {
        return billdetailCollection;
    }

    public void setBilldetailCollection(Collection<Billdetail> billdetailCollection) {
        this.billdetailCollection = billdetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productid != null ? productid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productid == null && other.productid != null) || (this.productid != null && !this.productid.equals(other.productid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Product[ productid=" + productid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
