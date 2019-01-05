/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainForm;

import Services.entity;
import Entity.Category;
import Entity.Product;
import Services.ImagePreviewPanel;
import Services.JPAPaginController;
import Services.PaginationController;
import static Services.entity.factory;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.ArrayList;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.eclipse.persistence.config.QueryHints;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author KIENDINH
 */
public class ProductManager extends javax.swing.JFrame implements entity, ActionListener {

    JFileChooser chooser = new JFileChooser();
    JPopupMenu popupMenu = new JPopupMenu();
    JMenuItem menuItemDelete = new JMenuItem("Delete This");
    JPAPaginController controller = new JPAPaginController(factory, Entity.Product.class);
    PaginationController pagination;
    List<Product> lst;

    /**
     * Creates new form ProductManager
     */
    public ProductManager() {
        //refreshEntity();
        initComponents();
        this.setLocationRelativeTo(null);
        popupMenu.add(menuItemDelete);
        menuItemDelete.addActionListener(this);
        //loadData();
        btnOpenImage.setVisible(false);
        int size = Integer.parseInt(this.cbbPage.getSelectedItem().toString());
        pagination = new PaginationController(size, controller.getCount());
        setCate();
        refreshTable();

    }

    private void setCate() {
        Query CQuery = this.entityManager.createQuery("SELECT c FROM Category c").setHint(QueryHints.REFRESH, true);
        List<Category> lstEmp = CQuery.getResultList();
        this.cbbCategory.addItem("All");
        for (Category e : lstEmp) {
            this.cbbCategory.addItem(e.toString());
        }
    }

    private void refreshTable() {
        if (this.cbbCategory.getSelectedItem() == "All") {

            if ("".equals(txtName.getText())) {
                if (lst == null) {
                    lst = controller.findSortEntities(pagination.getPageSize(), pagination.getCurrentItem());
                } else {
                    lst.clear();
                    lst.addAll(controller.findSortEntities(pagination.getPageSize(), pagination.getCurrentItem()));
                }
                setDataProduct(lst);
                btnFirst.setEnabled(pagination.isHasPrevPage());
                btnPrev.setEnabled(pagination.isHasPrevPage());
                btnNext.setEnabled(pagination.isHasNextPage());
                btnLast.setEnabled(pagination.isHasNextPage());
            } else {
                refreshTable(null, this.txtName.getText());
            }
        } else {
            String a = txtName.getText();
            String id = cbbCategory.getSelectedItem().toString();
            String[] param = id.split("\\.");
            String pa = param[0];
            if (!"".equals(txtName.getText())) {
                refreshTable(pa, this.txtName.getText());
            } else {
                refreshTable(pa, null);
            }

        }

    }

    private void refreshTable(String cat, String name) {

        if (lst == null) {
            lst = controller.findSortEntitiesProduct(cat, name, pagination.getPageSize(), pagination.getCurrentItem());
        } else {
            lst.clear();
            lst.addAll(controller.findSortEntitiesProduct(cat, name, pagination.getPageSize(), pagination.getCurrentItem()));
        }
        setDataProduct(lst);
        btnFirst.setEnabled(pagination.isHasPrevPage());
        btnPrev.setEnabled(pagination.isHasPrevPage());
        btnNext.setEnabled(pagination.isHasNextPage());
        btnLast.setEnabled(pagination.isHasNextPage());

    }

    private void loadData() {
        Query pQuery = entityManager.createNamedQuery("Product.findAll").setHint(QueryHints.REFRESH, true);
        List<Product> lst = pQuery.getResultList();
        setDataProduct(lst);
        List<Category> cate = entityManager.createNamedQuery("Category.findAll").getResultList();
        ArrayList<String> cateList = new ArrayList<String>();
        for (Category c : cate) {
            cateList.add(c.toString());
        }
        this.cbbCate.setModel(new javax.swing.DefaultComboBoxModel(cateList.toArray()));

    }

    private void setDataProduct(List<Product> lst) {
        String[] header = new String[]{"ID", "Name", "Price", "Amount"};
        DefaultTableModel dataModel = new DefaultTableModel(header, 0);
        if (lst.size() > 0) {

            for (Product p : lst) {
                Object[] columns = new Object[]{p.getProductid(), p.getProductname(), p.getPrice(), p.getAmount()};
                dataModel.addRow(columns);
            }

        } else {
        }

        this.tblProduct.setModel(dataModel);
        tblProduct.setRowHeight(20);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct =  new javax.swing.JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        cbbCategory = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        txtProductCode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtUnit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbbCate = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCompany = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtProductAmount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnOpenImage = new javax.swing.JButton();
        btnNewProduct = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnSelectImage = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetail = new javax.swing.JTextArea();
        listImage = new java.awt.List();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        cbbPage = new javax.swing.JComboBox();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PRODUCT MANAGER");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProduct.getTableHeader().setReorderingAllowed(false);
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);
        this.tblProduct.setComponentPopupMenu(popupMenu);

        cbbCategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Category:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Product Management");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Search By Name:");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnSearch.setText("SEARCH");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Name:");

        txtProductName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtProductCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Code:");

        txtID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtID.setEnabled(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtUnit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Unit:");

        txtPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Category:");

        cbbCate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbCate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Price:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Company:");

        txtCompany.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Images:");

        txtProductAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Amount:");

        btnOpenImage.setText("Open Folder");
        btnOpenImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOpenImageMouseClicked(evt);
            }
        });

        btnNewProduct.setText("Add");
        btnNewProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewProductMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Detail:");

        btnEdit.setText("Edit");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });

        btnSelectImage.setText("Select Image");
        btnSelectImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSelectImageMouseClicked(evt);
            }
        });

        txtDetail.setColumns(20);
        txtDetail.setRows(5);
        jScrollPane2.setViewportView(txtDetail);

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setText("<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        cbbPage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "50" }));
        cbbPage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbPageItemStateChanged(evt);
            }
        });

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnFirst)
                                        .addGap(14, 14, 14)
                                        .addComponent(btnPrev)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbbPage, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnNext)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLast)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(txtCompany))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(txtUnit))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtProductCode)
                                    .addComponent(txtProductName)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbCate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPrice)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtProductAmount)
                                            .addComponent(jScrollPane2)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnOpenImage, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addComponent(btnSelectImage, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(listImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbCate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProductAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnOpenImage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSelectImage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(listImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtName)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFirst)
                            .addComponent(btnPrev)
                            .addComponent(cbbPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNext)
                            .addComponent(btnLast))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowClosed

    private void btnSelectImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectImageMouseClicked
        // TODO add your handling code here:
        ImagePreviewPanel preview = new ImagePreviewPanel();
        chooser.setAccessory(preview);
        chooser.addPropertyChangeListener(preview);
        chooser.setMultiSelectionEnabled(true);
        chooser.addChoosableFileFilter(new Services.ImageFilter());
        chooser.setAcceptAllFileFilterUsed(false);
        int c = chooser.showDialog(null, "Select");
        if (c == JFileChooser.APPROVE_OPTION) {
            File[] selectedFile = chooser.getSelectedFiles();
            if (selectedFile.length > 0) {
                listImage.clear();
                for (File f : selectedFile) {
                    this.listImage.add(f.getAbsolutePath());
                }
            }
        }
    }//GEN-LAST:event_btnSelectImageMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // TODO add your handling code here:
        resetField();
    }//GEN-LAST:event_btnResetMouseClicked
    private boolean checkPrice() {
        String pattern = "\\d+(\\.\\d+)*";
        if (this.txtPrice.getText().matches(pattern)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Please enter Price as digit. !");
            return false;

        }
    }

    private boolean checkNumber() {
        if (!this.txtProductAmount.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Please enter Amount as digit. !");
            return false;
        }
        return true;
    }

    private boolean checkNull() {
        if ((this.txtProductName.getText() == null) && this.txtPrice.getText() == null) {
            return true;
        }
        return false;
    }
    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        // TODO add your handling code here:
        if ((!"".equals(this.txtID.getText()))) {
            if (checkNull()) {
                if (checkPrice() && checkNumber()) {
                    String x = txtID.getText();
                    String id = this.cbbCate.getSelectedItem().toString();
                    String[] param = id.split("\\.");
                    int pa = Integer.parseInt(param[0]);
                    entityManager.getTransaction().begin();
                    Product p = entityManager.find(Product.class, Integer.parseInt(txtID.getText()));
                    p.setAmount(Integer.parseInt(txtProductAmount.getText()));
                    Category c = entityManager.find(Category.class, pa);
                    p.setCategoryid(c);
                    p.setPrice(Float.parseFloat(txtPrice.getText()));
                    p.setCompany(txtCompany.getText());
                    p.setProductcode(txtProductCode.getText());
                    p.setProductname(txtProductName.getText());
                    p.setUnit(txtUnit.getText());
                    p.setDetails(txtDetail.getText());
                    entityManager.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "Edit Sucessfully ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter required field !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please choose an Product first");
        }
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnNewProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewProductMouseClicked
        // TODO add your handling code here:
        if (("".equals(this.txtID.getText()) || this.txtID.getText() != null)) {
            if (checkNull()) {
                if (checkPrice() && checkNumber()) {
                    String id = this.cbbCate.getSelectedItem().toString();
                    String[] param = id.split("\\.");
                    int pa = Integer.parseInt(param[0]);

                    Product p = new Product();
                    p.setAmount(Integer.parseInt(txtProductAmount.getText()));
                    Category c = entityManager.find(Category.class, pa);
                    p.setCategoryid(c);
                    p.setPrice(Float.parseFloat(txtPrice.getText()));
                    p.setCompany(txtCompany.getText());
                    p.setProductcode(txtProductCode.getText());
                    p.setProductname(txtProductName.getText());
                    p.setStatus(true);
                    p.setUnit(txtUnit.getText());
                    p.setDetails(txtDetail.getText());
                    entityManager.getTransaction().begin();
                    entityManager.persist(p);
                    entityManager.getTransaction().commit();
                    // copy file
                    if (this.listImage.countItems() > 0) {
                        try {
                            String des = "C:\\Salemanager\\image\\" + p.getProductid();
                            Path path = Paths.get(des);
                            if (!Files.exists(path)) {

                                Files.createDirectories(path);

                            }
                            for (String x : listImage.getItems()) {
                                copyFile(x, des);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Add Sucessfully ");
                    resetField();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter required field !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Reset all field first");
        }
    }//GEN-LAST:event_btnNewProductMouseClicked

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
//        String id = cbbCategory.getSelectedItem().toString();
//        String[] param = id.split("\\.");
//        int pa = Integer.parseInt(param[0]);
//        //Query prQuery;
//
//        List<Product> list;
//        try {
//            if (txtName.getText() == null || "".equals(txtName.getText())) {
//
//                Query q = entityManager.createNativeQuery("SELECT * FROM Product WHERE Product.categoryid = ? and Product.Status = 1", Product.class);
//                q.setParameter(1, pa);
//                list = q.getResultList();
//                setDataProduct(list);
//            } else {
//                Query q = java.beans.Beans.isDesignTime() ? null
//                        : entityManager.createNativeQuery("SELECT * FROM Product WHERE Product.categoryid = ? and Product.PRODUCTNAME LIKE LOWER(?) and Product.Status = 1", Product.class);
//                q.setParameter(1, pa);
//                q.setParameter(2, "%" + txtName.getText().toLowerCase() + "%");
//                list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : q.getResultList();
//                setDataProduct(list);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        refreshTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchMouseClicked

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        // TODO add your handling code here:
        TableModel model = tblProduct.getModel();
        int row = tblProduct.getSelectedRow();
        int ID = (int) model.getValueAt(row, 0);
        Product product = entityManager.find(Product.class, ID);
        setDataTextBox(product);
        this.btnSelectImage.setVisible(false);
        btnOpenImage.setVisible(true);
        listImage.removeAll();
        File folder = new File("C:\\Salemanager\\image\\" + product.getProductid() + "\\");
        if (folder.isDirectory()) {
            File[] listOfFiles = folder.listFiles();

            for (File file : listOfFiles) {
                if (file.isFile()) {
                    this.listImage.add(file.getAbsolutePath());
                }
            }
        }
    }//GEN-LAST:event_tblProductMouseClicked

    private void btnOpenImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpenImageMouseClicked
        // TODO add your handling code here:
        String FolderName = "C:/Salemanager/image/" + txtID.getText();//Write your complete path here
        try {
            Desktop.getDesktop().open(new File(FolderName));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error !");
        }
    }//GEN-LAST:event_btnOpenImageMouseClicked

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        pagination.firstPage();
        refreshTable();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        pagination.prevPage();
        refreshTable();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void cbbPageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbPageItemStateChanged
        // TODO add your handling code here:
        int size = Integer.parseInt(cbbPage.getSelectedItem().toString());
        pagination = new PaginationController(size, lst.size());
        refreshTable();
    }//GEN-LAST:event_cbbPageItemStateChanged

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        pagination.nextPage();
        refreshTable();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        pagination.lastPage();
        refreshTable();
    }//GEN-LAST:event_btnLastActionPerformed
    private void resetField() {
        btnOpenImage.setVisible(false);
        this.btnSelectImage.setVisible(true);
        this.txtID.setText(null);
        this.txtProductName.setText(null);
        this.txtProductCode.setText(null);
        this.txtCompany.setText(null);
        this.txtUnit.setText(null);
        this.txtProductAmount.setText(null);
        this.txtPrice.setText(null);
        this.listImage.removeAll();
        List<Category> cate = entityManager.createNamedQuery("Category.findAll").getResultList();
        ArrayList<String> cateList = new ArrayList<String>();
        this.txtDetail.setText(null);
        for (Category c : cate) {
            cateList.add(c.toString());
        }
        this.cbbCate.setModel(new javax.swing.DefaultComboBoxModel(cateList.toArray()));
    }

    public void copyFile(String source, String dest) throws FileNotFoundException, IOException {
//        file nguồn
        File sourceFile = new File(source);
//        file đích
        File destFile = new File(dest + "\\" + sourceFile.getName());
//        kiem tra file nguồn có tồn tại không
        if (sourceFile.exists()) {
            Files.copy(sourceFile.toPath(), destFile.toPath(), REPLACE_EXISTING);
            //return true;
        } else {
            System.out.println("Upload image error");
            //return false;
        }
    }

    private void setDataTextBox(Product p) {
        this.txtID.setText(p.getProductid() + "");
        this.txtProductName.setText(p.getProductname());
        this.txtProductCode.setText(p.getProductcode());
        this.txtCompany.setText(p.getCompany());
        this.txtUnit.setText(p.getUnit());
        this.txtProductAmount.setText(p.getAmount() + "");
        this.txtPrice.setText(p.getPrice() + "");
        List<Category> cate = entityManager.createNamedQuery("Category.findAll").getResultList();
        ArrayList<String> cateList = new ArrayList<String>();
        this.txtDetail.setText(p.getDetails());
        for (Category c : cate) {
            if (c == p.getCategoryid()) {
                cateList.add(0, c.toString());
            } else {
                cateList.add(c.toString());
            }

        }
        this.cbbCate.setModel(new javax.swing.DefaultComboBoxModel(cateList.toArray()));

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNewProduct;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOpenImage;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSelectImage;
    private javax.swing.JComboBox<String> cbbCate;
    private javax.swing.JComboBox<String> cbbCategory;
    private javax.swing.JComboBox cbbPage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.List listImage;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtCompany;
    private javax.swing.JTextArea txtDetail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductAmount;
    private javax.swing.JTextField txtProductCode;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables

    public void refreshEntity() {
        entityManager.getEntityManagerFactory().getCache().evictAll();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem menu = (JMenuItem) e.getSource();
        if (menu == menuItemDelete) {
            int choose = JOptionPane.showConfirmDialog(null, "Are you sure to delete this ? \n All detail will be delete !");
            if (choose == 0) {
                int row = tblProduct.getSelectedRow();
                if (DeleteProduct(row)) {
                    JOptionPane.showMessageDialog(null, "Delete successfully !");
                    loadData();
                } else {
                    JOptionPane.showMessageDialog(null, "An error occured !");
                }
            }
        }
    }

    private boolean DeleteProduct(int row) {
        EntityTransaction tran = null;
        try {
            tran = entityManager.getTransaction();
            tran.begin();
            TableModel tb = tblProduct.getModel();
            int pid = (int) tb.getValueAt(row, 0);
            Product p = entityManager.find(Product.class, pid);
            p.setStatus(false);
            tran.commit();
            return true;
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
