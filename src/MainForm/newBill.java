/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainForm;

import Services.entity;
import Entity.Bill;
import Entity.Category;
import Entity.Employee;
import Entity.Product;
import Services.JPAPaginController;
import Services.PaginationController;
import static Services.entity.factory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.DefaultCellEditor;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author KIENDINH
 */
public class newBill extends javax.swing.JFrame implements ActionListener, entity {

    JPAPaginController controller = new JPAPaginController(factory, Entity.Product.class);
    PaginationController pagination;
    List<Product> lst;
    JPopupMenu popupMenu = new JPopupMenu();
    JPopupMenu popupSelect = new JPopupMenu();
    JPopupMenu popupCustomer = new JPopupMenu();
    JMenuItem menuItemAdd = new JMenuItem("Add This");
    JMenuItem menuItemRemove = new JMenuItem("Remove This");
    JMenuItem menuItemRemoveAll = new JMenuItem("Remove All");
    JMenuItem menuItemSelect = new JMenuItem("Select This Customer");
    JTextField textBox = new JTextField();
    String[] headerSelected = new String[]{"ID", "Product Code", "Name", "Price", "Quantity"};
    DefaultTableModel ProductSelectedModel = new DefaultTableModel(headerSelected, 0);

    /**
     * Creates new form newBill
     */
    public newBill() {
        initComponents();
        //loadProduct();
        int size = Integer.parseInt(this.cbbPage.getSelectedItem().toString());
        pagination = new PaginationController(size, controller.getCount());
        this.setLocationRelativeTo(null);
        // <editor-fold defaultstate="collapsed" desc="POPUP-ITEM">   
        popupMenu.add(menuItemAdd);
        popupSelect.add(menuItemRemove);
        popupSelect.add(menuItemRemoveAll);
        popupCustomer.add(menuItemSelect);
        menuItemAdd.addActionListener(this);
        menuItemRemove.addActionListener(this);
        menuItemRemoveAll.addActionListener(this);
        menuItemSelect.addActionListener(this);
        //</editor-fold>
        setCate();
        refreshTable();

        textBox.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblProductFocusLost(evt);
            }
        });

    }

    private void setCate() {
        Query CQuery = SaleManagerProjectPUEntityManager.createQuery("SELECT c FROM Category c").setHint(QueryHints.REFRESH, true);
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

    private void loadProduct() {
        Query q = entityManager.createNamedQuery("Product.findAll").setHint(QueryHints.REFRESH, true);
        List<Product> lst = (List<Product>) q.getResultList();
        setDataProduct(lst);
        // <editor-fold defaultstate="collapsed" desc="NATIVE CODE">   
//        try {
//            String sql = "SELECT PRODUCTID,PRODUCTCODE,PRODUCTNAME,UNIT,PRICE,COMPANY,AMOUNT FROM PRODUCT";
//            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=SALE", "sa", "123456");
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            String[] header = new String[]{"ID", "Product Code", "Name", "UNIT", "Price", "Company", "Amount"};
//            DefaultTableModel dataModel = new DefaultTableModel(header, 0);
//            while (rs.next()) {
//                Object[] columns = new Object[]{rs.getInt(1),
//                    rs.getString(2),
//                    rs.getString(3),
//                    rs.getString(4),
//                    rs.getFloat(5),
//                    rs.getString(6),
//                    rs.getInt(7)
//                };
//                dataModel.addRow(columns);
//            }
//
//            this.tblOrder.setModel(dataModel);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//</editor-fold>
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        SaleManagerProjectPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SaleManagerProjectPU").createEntityManager();
        customerQuery = java.beans.Beans.isDesignTime() ? null : SaleManagerProjectPUEntityManager.createQuery("SELECT c FROM Customer c");
        customerList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : customerQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jScrollOrder = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduct =  new javax.swing.JTable(){
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        btnSubmit = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCost = new javax.swing.JLabel("",SwingConstants.RIGHT);
        cbbCategory = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCusttomer =  new javax.swing.JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        txtCustName = new javax.swing.JTextField();
        btnSearchCust = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lbCustName = new javax.swing.JLabel("",SwingConstants.LEFT);
        lbAddessPhone = new javax.swing.JLabel("",SwingConstants.LEFT);
        lbCustID = new javax.swing.JLabel("",SwingConstants.RIGHT);
        txtDate = new com.toedter.calendar.JDateChooser();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        cbbPage = new javax.swing.JComboBox();
        btnPrev = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CREATE NEW ORDER");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollOrder.setBackground(new java.awt.Color(255, 255, 255));
        jScrollOrder.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tblOrder.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblOrder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblOrder.setGridColor(new java.awt.Color(255, 255, 255));
        tblOrder.setRowHeight(30);
        tblOrder.setRowMargin(5);
        tblOrder.setShowHorizontalLines(false);
        tblOrder.setShowVerticalLines(false);
        tblOrder.getTableHeader().setReorderingAllowed(false);
        jScrollOrder.setViewportView(tblOrder);
        if (tblOrder.getColumnModel().getColumnCount() > 0) {
            tblOrder.getColumnModel().getColumn(0).setMinWidth(10);
            tblOrder.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblOrder.getColumnModel().getColumn(0).setMaxWidth(50);
            tblOrder.getColumnModel().getColumn(0).setHeaderValue("ID");
            tblOrder.getColumnModel().getColumn(1).setMinWidth(30);
            tblOrder.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblOrder.getColumnModel().getColumn(1).setMaxWidth(100);
            tblOrder.getColumnModel().getColumn(1).setHeaderValue("CODE");
            tblOrder.getColumnModel().getColumn(2).setHeaderValue("NAME");
            tblOrder.getColumnModel().getColumn(3).setMinWidth(30);
            tblOrder.getColumnModel().getColumn(3).setPreferredWidth(70);
            tblOrder.getColumnModel().getColumn(3).setMaxWidth(70);
            tblOrder.getColumnModel().getColumn(3).setHeaderValue("Unit");
            tblOrder.getColumnModel().getColumn(4).setMinWidth(40);
            tblOrder.getColumnModel().getColumn(4).setPreferredWidth(70);
            tblOrder.getColumnModel().getColumn(4).setMaxWidth(80);
            tblOrder.getColumnModel().getColumn(4).setHeaderValue("Price");
            tblOrder.getColumnModel().getColumn(5).setHeaderValue("Company");
            tblOrder.getColumnModel().getColumn(6).setMinWidth(30);
            tblOrder.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblOrder.getColumnModel().getColumn(6).setMaxWidth(70);
            tblOrder.getColumnModel().getColumn(6).setHeaderValue("Amount");
        }
        this.tblOrder.setComponentPopupMenu(popupMenu);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Select Product:");

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODE", "Name", "Price", "Quantity"
            }
        ) );
        tblProduct.setAutoResizeMode(javax.swing.JTable.WIDTH);
        tblProduct.setRowHeight(30);
        tblProduct.getTableHeader().setReorderingAllowed(false);
        tblProduct.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblProductFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(tblProduct);
        this.tblProduct.setComponentPopupMenu(popupSelect);
        tblProduct.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
                    textBox.setEditable(false);
                }
                else {
                    textBox.setEditable(true);
                }
            }

        });
        tblProduct.putClientProperty("terminateEditOnFocusLost", true);
        if (tblProduct.getColumnModel().getColumnCount() > 0) {
            tblProduct.getColumnModel().getColumn(0).setMinWidth(10);
            tblProduct.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblProduct.getColumnModel().getColumn(0).setMaxWidth(50);

        }

        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/point-of-service.png"))); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubmitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSubmitMouseEntered(evt);
            }
        });

        btnPrint.setLabel("Print Order");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Search Customer by Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Product in order:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Total Cost:");

        txtCost.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtCost.setForeground(new java.awt.Color(0, 51, 204));
        txtCost.setText("0.0000");

        cbbCategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Category:");

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

        tblCusttomer.setAutoResizeMode(javax.swing.JTable.WIDTH);
        tblCusttomer.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, customerList, tblCusttomer);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${custid}"));
        columnBinding.setColumnName("ID");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${custname}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${custphone}"));
        columnBinding.setColumnName("Phone");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${custaddress}"));
        columnBinding.setColumnName("Address");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane3.setViewportView(tblCusttomer);
        if (tblCusttomer.getColumnModel().getColumnCount() > 0) {
            tblCusttomer.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblCusttomer.getColumnModel().getColumn(0).setMaxWidth(40);
        }
        this.tblCusttomer.setComponentPopupMenu(popupCustomer);

        txtCustName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnSearchCust.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnSearchCust.setText("SEARCH");
        btnSearchCust.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchCustMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setText("Selected Customer:");

        lbCustName.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbCustName.setText("not choosen");

        lbAddessPhone.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbAddessPhone.setText("not choosen");

        lbCustID.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbCustID.setText(".");

        txtDate.setFocusable(false);

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        cbbPage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "50" }));
        cbbPage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbPageItemStateChanged(evt);
            }
        });

        btnPrev.setText("<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearchCust, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(19, 19, 19))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnFirst)
                                .addGap(14, 14, 14)
                                .addComponent(btnPrev)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbPage, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNext)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLast)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollOrder, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbCustID, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbCustName, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                    .addComponent(lbAddessPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnFirst)
                                .addComponent(btnPrev)
                                .addComponent(cbbPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnNext)
                                .addComponent(btnLast))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbCategory)
                                .addComponent(txtName)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearchCust, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbCustID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAddessPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtDate.getDateEditor().setEnabled(false);

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

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Tìm kiếm khách hàng
     *
     * @param evt
     */
    private void btnSearchCustMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchCustMouseClicked

        if (this.txtCustName.getText() == null || "".equals(txtCustName.getText())) {
            JOptionPane.showMessageDialog(null, "PLEASE ENTER NAME !");
        } else {
            custQuery = java.beans.Beans.isDesignTime() ? null
                    : SaleManagerProjectPUEntityManager.createNativeQuery("SELECT * FROM Customer  WHERE custname LIKE LOWER(?)", Entity.Customer.class);
            custQuery.setParameter(1, "%" + txtCustName.getText().toLowerCase() + "%");
            customerList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : (List<Entity.Customer>) custQuery.getResultList();
            setCustomerData(customerList);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchCustMouseClicked
    /**
     * Tìm kiếm sản phẩm
     *
     * @param evt
     */
    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        refreshTable();
//        String id = cbbCategory.getSelectedItem().toString();
//        String[] param = id.split("\\.");
//        int pa = Integer.parseInt(param[0]);
//        Query prQuery;
//
//        List<Product> list;
//        try {
//            //Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=SALE", "sa", "123456");
//            if (txtName.getText() == null || "".equals(txtName.getText())) {
//                // <editor-fold defaultstate="collapsed" desc="NATIVE CODE">   
////                String sql = "SELECT PRODUCTID,PRODUCTCODE,PRODUCTNAME,UNIT,PRICE,COMPANY,AMOUNT FROM PRODUCT WHERE Product.categoryid = '" + pa + "'";
////                Statement stmt = con.createStatement();
////                ResultSet rs = stmt.executeQuery(sql);
////                String[] header = new String[]{"ID", "Product Code", "Name", "UNIT", "Price", "Company", "Amount"};
////                DefaultTableModel dataModel = new DefaultTableModel(header, 0);
////                while (rs.next()) {
////                    Object[] columns = new Object[]{rs.getInt(1),
////                        rs.getString(2),
////                        rs.getString(3),
////                        rs.getString(4),
////                        rs.getFloat(5),
////                        rs.getString(6),
////                        rs.getInt(7)
////                    };
////                    dataModel.addRow(columns);
////                }
////
////                this.tblOrder.setModel(dataModel);
////</editor-fold>
//                prQuery = entityManager.createNativeQuery("SELECT * FROM Product WHERE Product.categoryid = ? and Product.Status = 1", Product.class).setHint(QueryHints.REFRESH, true);
//                prQuery.setParameter(1, pa);
//                list = prQuery.getResultList();
//                setDataProduct(list);
//            } else {
//                // <editor-fold defaultstate="collapsed" desc="NATIVE CODE">   
//
////                String sql = "SELECT PRODUCTID,PRODUCTCODE,PRODUCTNAME,UNIT,PRICE,COMPANY,AMOUNT FROM PRODUCT WHERE Product.categoryid = '" + pa + "' and and Product.PRODUCTNAME LIKE LOWER(?)";
////                PreparedStatement stmt = con.prepareStatement(sql);
////                stmt.setString(1, "%" + txtName.getText().toLowerCase() + "%");
////                ResultSet rs = stmt.executeQuery(sql);
////                String[] header = new String[]{"ID", "Product Code", "Name", "UNIT", "Price", "Company", "Amount"};
////                DefaultTableModel dataModel = new DefaultTableModel(header, 0);
////                while (rs.next()) {
////                    Object[] columns = new Object[]{rs.getInt(1),
////                        rs.getString(2),
////                        rs.getString(3),
////                        rs.getString(4),
////                        rs.getFloat(5),
////                        rs.getString(6),
////                        rs.getInt(7)
////                    };
////                    dataModel.addRow(columns);
////                }
////
////                this.tblOrder.setModel(dataModel);
////</editor-fold>
//                prQuery = entityManager.createNativeQuery("SELECT * FROM Product WHERE Product.categoryid = ? and Product.PRODUCTNAME LIKE LOWER(?) and Product.Status = 1", Product.class).setHint(QueryHints.REFRESH, true);;
//                prQuery.setParameter(1, pa);
//                prQuery.setParameter(2, "%" + txtName.getText().toLowerCase() + "%");
//                list = prQuery.getResultList();
//                setDataProduct(list);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchMouseClicked

    private void tblProductFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblProductFocusLost
        // TODO add your handling code here:
        caculatePrice();
    }//GEN-LAST:event_tblProductFocusLost
    /**
     * Kiểm tra đơn hàng, check số lượng trong kho và hoàn thành đơn hàng.
     *
     * @param evt
     * @see checkQuantityWarehouse()
     */
    private void btnSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseClicked
        // TODO add your handling code here:
        List<Product> prd = new ArrayList<>();
        TableModel model = tblProduct.getModel();
        EntityManager entityManager2 = factory.createEntityManager();
        EntityTransaction tran = null;
        /**
         * Lấy danh sách id cho storedprocedure.
         */
        String param = "";
        for (int i = 0; i < model.getRowCount(); i++) {
//            if(i != 0)
//            {
//                param =  "," +param + model.getValueAt(i, 0) ;
//            }
//            else
//            {
//                param = param + model.getValueAt(i, 0);
//            }
            param = param + model.getValueAt(i, 0) + ",";
        }
//        try {
//            String SPsql = "EXEC getProductSelected ?";   // for stored proc taking 2 parameters
//            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=SALE", "sa", "123456");   // java.sql.Connection
//            PreparedStatement ps = con.prepareStatement(SPsql);
//            ps.setEscapeProcessing(true);
//            ps.setString(1, param);
//            ResultSet rs = ps.executeQuery();
//            if(rs.next())
//            {
//                Product p = new Product();
//                p.setProductid(rs.getInt("PRODUCTID"));
//                p.setProductname(rs.getNString("PRODUCTNAME"));
//                p.setAmount(rs.getInt("AMOUNT"));
//                prd.add(p);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "AN ERROR OCCURED ");
//
//        }
        Query query = entityManager2.createNamedStoredProcedureQuery("getProductSelected");//.setHint(QueryHints.REFRESH, true);
    //    query.
        query.setParameter("product_id", param);
        prd = query.getResultList();
        String idcust = this.lbCustID.getText();
        if (".".equals(idcust)) { // check khách hàng
            JOptionPane.showMessageDialog(null, "Please choose a customer !");
        } else {
            if (tblProduct.getModel().getRowCount() > 0) { // check sản phẩm
                int check = checkQuantityWarehouse(prd);
                if (check == -1) {
                    //INSERT VÀO BẢNG ORDER VÀ ORDER DETAIL
                    tran = entityManager.getTransaction();
                    try {
                        tran.begin();
                        Entity.Customer cust = entityManager.find(Entity.Customer.class, Integer.parseInt(idcust));
                        Entity.Employee emp = entityManager.find(Employee.class, ClassData.LoginUser.User.getUsername());
                        Bill bill = new Bill();
                        bill.setBilldate(txtDate.getDate() != null ? txtDate.getDate() : new Date());
                        bill.setCustid(cust);
                        bill.setUsername(emp);
                        entityManager.persist(bill);
                        tran.commit();
                        int id = bill.getBillid();
                        int i = 0;

                        // Thêm detail
                        for (Product p : prd) {
                            tran.begin();
                            int amt = Integer.parseInt(model.getValueAt(i, 4).toString());
                            int pid = p.getProductid();
                            String ins = "INSERT INTO BILLDETAIL VALUES('" + id + "','" + pid + "','" + amt + "')";
                            Query insquery = entityManager.createNativeQuery(ins);
                            insquery.executeUpdate();
                            // Trừ đi số lượng hàng trong kho.
                            Product prod = entityManager.find(Product.class, pid);
                            int newamount = prod.getAmount() - amt;
                            prod.setAmount(newamount);
                            tran.commit();
                            i++;
                        }

                        //entityManager.close();
                        JOptionPane.showMessageDialog(null, "Successfully!");
                        resetProduct();
                    } catch (Exception e) {
                        if (tran != null && tran.isActive()) {
                            tran.rollback();
                            JOptionPane.showMessageDialog(null, "AN ERROR OCCURED ");

                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "OUT OF STOCK PRODUCT ID " + check);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cart is emty !");
            }
        }

    }//GEN-LAST:event_btnSubmitMouseClicked
    private void resetProduct() {
        removeAllRows();
        this.lbCustID.setText(".");
        this.lbCustName.setText("not choosen");
        this.lbAddessPhone.setText("not choosen");

    }
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSubmitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubmitMouseEntered

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        pagination.lastPage();
        refreshTable();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        pagination.nextPage();
        refreshTable();
    }//GEN-LAST:event_btnNextActionPerformed

    private void cbbPageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbPageItemStateChanged
        // TODO add your handling code here:
        int size = Integer.parseInt(cbbPage.getSelectedItem().toString());
        pagination = new PaginationController(size, lst.size());
        refreshTable();
    }//GEN-LAST:event_cbbPageItemStateChanged

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        pagination.prevPage();
        refreshTable();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        pagination.firstPage();
        refreshTable();
    }//GEN-LAST:event_btnFirstActionPerformed
    /**
     * Kiểm tra trong kho có còn hàng hay không
     *
     * @param model
     * @return
     */
    private int checkQuantityWarehouse(List<Product> list) {

        TableModel model = tblProduct.getModel();
        int i = model.getRowCount() - 1;
        for (Product p : list) {
            if (Integer.parseInt(model.getValueAt(i, 4) + "") > p.getAmount()) {
                return p.getProductid();
            }
            i--;
        }

        return -1;
    }

    /**
     * Set data to tblCusttomer
     *
     * @param cust
     * @see setDataProduct()
     */
    private void setCustomerData(List<Entity.Customer> cust) {

        String[] header = new String[]{"ID", "Name", "Phone", "Address"};
        DefaultTableModel dataModel = new DefaultTableModel(header, 0);
        if (cust.size() > 0) {

            for (Entity.Customer p : cust) {
                String[] columns = new String[]{p.getCustid().toString(), p.getCustname(), p.getCustphone(), p.getCustaddress()};
                dataModel.addRow(columns);
            }
        } else {
        }

        this.tblCusttomer.setModel(dataModel);
    }

    /**
     * Set data to tblOrder
     *
     * @param prod
     * @see setCustomerData()
     */
    private void setDataProduct(List<Product> prod) {

        String[] header = new String[]{"ID", "Product Code", "Name", "UNIT", "Price", "Company"};
        DefaultTableModel dataModel = new DefaultTableModel(header, 0);
        if (prod.size() > 0) {

            for (Product p : prod) {
                Object[] columns = new Object[]{p.getProductid(), p.getProductcode(), p.getProductname(), p.getUnit(), p.getPrice(), p.getCompany()};
                dataModel.addRow(columns);
            }
        } else {
//            String[] none = new String[]{"NOTHING MATCHES YOUR SEARCH !"};
//            dataModel.addRow(none);
        }

        this.tblOrder.setModel(dataModel);
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
            java.util.logging.Logger.getLogger(newBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newBill().setVisible(true);
            }
        });
    }
    //<editor-fold defaultstate="collapsed" desc="KHAI BAO MAC DINH">

    private javax.persistence.Query custQuery;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager SaleManagerProjectPUEntityManager;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchCust;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cbbCategory;
    private javax.swing.JComboBox cbbPage;
    private java.util.List<Entity.Customer> customerList;
    private javax.persistence.Query customerQuery;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollOrder;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbAddessPhone;
    private javax.swing.JLabel lbCustID;
    private javax.swing.JLabel lbCustName;
    private javax.swing.JTable tblCusttomer;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTable tblProduct;
    private javax.swing.JLabel txtCost;
    private javax.swing.JTextField txtCustName;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtName;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
    @Override
    public void actionPerformed(ActionEvent event) {
        JMenuItem menu = (JMenuItem) event.getSource();
        if (menu == menuItemAdd) {
            //JOptionPane.showMessageDialog(null, "just clicked");
            addNewRow();
        } else if (menu == menuItemRemove) {
            //JOptionPane.showMessageDialog(null, "just clicked");
            removeCurrentRow();
        } else if (menu == menuItemRemoveAll) {
            // JOptionPane.showMessageDialog(null, "just clicked");
            removeAllRows();
        } else if (menu == menuItemSelect) {
            //JOptionPane.showMessageDialog(null, "just clicked");
            selectCust();
        }
    }

    /**
     * Chọn khách hàng từ bảng khách hàng
     */
    private void selectCust() {
        // tableModel.addRow(new String[0]);
        TableModel model = this.tblCusttomer.getModel();
        int r = tblCusttomer.getSelectedRow();
        if (r != -1) {
            this.lbCustID.setText(model.getValueAt(r, 0).toString());
            this.lbCustName.setText(model.getValueAt(r, 1).toString());
            this.lbAddessPhone.setText(model.getValueAt(r, 2) + ", " + model.getValueAt(r, 3));
        }
    }

    /**
     *
     * Add product to the selected list. if existed a product in the list, just
     * increase the quantity .<br />
     * Nếu đã tồn tại sản phẩm trong bảng chọn, chỉ tăng số lượng lên, không
     * thêm row.
     *
     * @see checkRowExist()
     */
    private void addNewRow() {
        TableModel model = tblOrder.getModel();
        int r = (tblOrder.getSelectedRow());
        Object[] row = new Object[]{model.getValueAt(r, 0), model.getValueAt(r, 1), model.getValueAt(r, 2), model.getValueAt(r, 4), 1};
        int rowduplicate = checkRowExist(model, Integer.parseInt(row[0] + ""));
        if (rowduplicate == -1) {
            ProductSelectedModel.addRow(row);
            tblProduct.setModel(ProductSelectedModel);
        } else {
            int oldQuantity = (int) tblProduct.getModel().getValueAt(rowduplicate, 4);
            oldQuantity++;
            tblProduct.setValueAt(oldQuantity, rowduplicate, 4);
        }

        caculatePrice();
        TableColumn quantitycol = this.tblProduct.getColumnModel().getColumn(4);
        quantitycol.setCellEditor(new DefaultCellEditor(textBox));
        addListener();
    }

    /**
     * Check if the product have existed in the list.
     *
     * @param model
     * @param id
     * @return -1 if not found or - nếu không tìm thấy
     * @return the row of the list that have existed - nếu tìm thấy trả về dòng
     * mà đã tìm thấy.
     * @see addNewRow()
     */
    private int checkRowExist(TableModel model, int id) {
        for (int i = 0; i < tblProduct.getModel().getRowCount(); i++) {
            if ((int) tblProduct.getModel().getValueAt(i, 0) == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Remove the product selected in selected list
     * <br> Xóa sản phẩm vừa chọn khỏi danh sách.
     *
     * @see removeAllRows()
     */
    private void removeCurrentRow() {
        int selectedRow = tblProduct.getSelectedRow();
        ProductSelectedModel.removeRow(selectedRow);
    }

    /**
     * Remove all product in the selected list
     * <br> Xóa tẩ cả sản phẩm khỏi danh sách đã chọn
     *
     * @see removeCurrentRow()
     */
    private void removeAllRows() {
        ProductSelectedModel = new DefaultTableModel(headerSelected, 0);
        tblProduct.setModel(ProductSelectedModel);
    }

    /**
     *
     * Caculating total amount of order from table tblProduct
     * <BR> Tính tổng tiền trong hóa đơn.
     */
    private void caculatePrice() {
        TableModel model = this.tblProduct.getModel();
        float total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            float c = Float.parseFloat(model.getValueAt(i, 3).toString()) * Float.parseFloat(model.getValueAt(i, 4).toString());
            total += c;
        }
        txtCost.setText(total + "");
    }

    /**
     * Add key listener to allow only numeric data on quantity column.<br>
     * Ngăn chặn việc nhập các ký tự không phải số vào trường quantity.
     *
     */
    private void addListener() {
        textBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    caculatePrice();
                } else if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != KeyEvent.VK_ENTER && e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
                    textBox.setEditable(false);
                } else {
                    textBox.setEditable(true);
                }
            }

        });

    }
}
