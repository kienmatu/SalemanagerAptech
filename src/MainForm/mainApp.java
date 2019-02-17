/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainForm;

import ClassData.LoginUser;
import Entity.Product;
import Services.entity;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author KIENDINH
 */
public class mainApp extends javax.swing.JFrame implements entity {

    /**
     * Creates new form mainApp
     */
    static int countp = 10;
    static String label = "today";

    public mainApp() {
        initComponents();
        this.setLocationRelativeTo(null);
        if (LoginUser.User.getIsadmin() == 1 || LoginUser.User.getIsadmin() == null) {
            this.menuAd.setVisible(true);
            this.menuProfile.setVisible(false);
        } else {
            this.menuAd.setVisible(false);
            this.menuProfile.setVisible(true);
        }
        
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, 1);
        reportTable(c.getTime(), new Date(), 10);
    }

    /**
     * Select top @count product to display top sale product
     *
     * @param start
     * @param end
     * @param count
     */
    private void reportTable(Date start, Date end, int count) {
        List<Product> prd = new ArrayList<>();
        try {
            String SPsql = "EXEC GetDashBoardData ?, ?,?";   // for stored proc taking 2 parameters
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=SALE", "sa", "123456");   // java.sql.Connection
            PreparedStatement ps = con.prepareStatement(SPsql);
            ps.setEscapeProcessing(true);
            ps.setDate(1, new java.sql.Date(start.getTime()));
            ps.setDate(2, new java.sql.Date(end.getTime()));
            ps.setInt(3, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductid(rs.getInt("PRODUCTID"));
                p.setProductname(rs.getNString("PRODUCTNAME"));
                p.setAmount(rs.getInt("AMOUNT"));
                p.setPrice(rs.getFloat("PRICE"));
                prd.add(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "AN ERROR OCCURED ");

        }
//        EntityManager entityManager2 = factory.createEntityManager();
//        Query query = entityManager2.createNamedStoredProcedureQuery("GetDashBoardData");
////        Calendar c = Calendar.getInstance();
////        c.set(Calendar.DAY_OF_WEEK, 1);
//        query.setParameter("startdate", start);
//        query.setParameter("enddate", end);
//        query.setParameter("count", count);
//        List<Product> prd = query.getResultList();

        String[] header = new String[]{"ID", "Product Name", "Sale Count", "Total Revenue"};
        DefaultTableModel dataModel = new DefaultTableModel(header, 0);
        double totalamount = 0;
        double totalproduct = 0;
        prd.sort(Comparator.comparing(Product::getAmount).reversed());
        for (Product p : prd) {
            Object[] columns = new Object[]{p.getProductid(), p.getProductname(), p.getAmount(), p.getPrice()};
            dataModel.addRow(columns);
            totalamount += p.getPrice();
            totalproduct += p.getAmount();
        }
        Object[] columns = new Object[]{"TOTAL", "", totalproduct, totalamount};
        dataModel.addRow(columns);
        this.tblReport.setModel(dataModel);
        if (tblReport.getColumnModel().getColumnCount() > 0) {
            tblReport.getColumnModel().getColumn(0).setMinWidth(10);
            tblReport.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblReport.getColumnModel().getColumn(0).setMaxWidth(150);
            tblReport.getColumnModel().getColumn(2).setMinWidth(40);
            tblReport.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblReport.getColumnModel().getColumn(2).setMaxWidth(200);
        }
//        entityManager2.clear();
//        entityManager.clear();
//        entityManager2.close();
//        this.lbsumtotalamount.setText(Double.toString(totalamount));
//        this.lbsumproduct.setText(Double.toString(totalproduct));
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
        tblReport = new javax.swing.JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        jLabel1 = new javax.swing.JLabel();
        Datefrom = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Dateto = new com.toedter.calendar.JDateChooser();
        btnWeek = new javax.swing.JButton();
        btnMonth = new javax.swing.JButton();
        btnToday = new javax.swing.JButton();
        btnToday1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnExport = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        menuNewOrde = new javax.swing.JMenu();
        menuOrderMng = new javax.swing.JMenu();
        menuAd = new javax.swing.JMenu();
        menuEmployee = new javax.swing.JMenu();
        menuCompInfo = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        menuCustomer = new javax.swing.JMenu();
        menuProduct = new javax.swing.JMenu();
        menuCategory = new javax.swing.JMenu();
        menuProfile = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblReport.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblReport.setRowHeight(18);
        tblReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReport.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblReport);
        if (tblReport.getColumnModel().getColumnCount() > 0) {
            tblReport.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Revenue Report ");

        Datefrom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("From Date:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("To Date:");

        Dateto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnWeek.setText("This Week");
        btnWeek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnWeekMouseClicked(evt);
            }
        });
        btnWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWeekActionPerformed(evt);
            }
        });

        btnMonth.setText("This Month");
        btnMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMonthMouseClicked(evt);
            }
        });

        btnToday.setText("Today");
        btnToday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTodayMouseClicked(evt);
            }
        });
        btnToday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodayActionPerformed(evt);
            }
        });

        btnToday1.setText("OK");
        btnToday1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnToday1MouseClicked(evt);
            }
        });
        btnToday1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToday1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Or");

        btnExport.setText("Export");
        btnExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportMouseClicked(evt);
            }
        });
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1279, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Datefrom, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Dateto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnToday1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnToday, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMonth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnToday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(btnWeek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnToday1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Datefrom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Dateto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        Datefrom.getDateEditor().setEnabled(false);
        Dateto.getDateEditor().setEnabled(false);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        jMenu2.setText("File");

        jMenu5.setText("Logout");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenu2.add(jMenu5);

        jMenu1.setText("Exit");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu2.add(jMenu1);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Order");

        menuNewOrde.setText("New Order");
        menuNewOrde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuNewOrdeMouseClicked(evt);
            }
        });
        jMenu3.add(menuNewOrde);

        menuOrderMng.setText("Order Manager");
        menuOrderMng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuOrderMngMouseClicked(evt);
            }
        });
        menuOrderMng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOrderMngActionPerformed(evt);
            }
        });
        jMenu3.add(menuOrderMng);

        jMenuBar1.add(jMenu3);

        menuAd.setText("Admin");
        menuAd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAdActionPerformed(evt);
            }
        });

        menuEmployee.setText("Employee Manager");
        menuEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEmployeeMouseClicked(evt);
            }
        });
        menuEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEmployeeActionPerformed(evt);
            }
        });
        menuAd.add(menuEmployee);

        menuCompInfo.setText("Company Info");
        menuCompInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCompInfoMouseClicked(evt);
            }
        });
        menuAd.add(menuCompInfo);

        jMenuBar1.add(menuAd);

        jMenu10.setText("Store Manager");
        jMenu10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu10ActionPerformed(evt);
            }
        });

        menuCustomer.setText("Customer Manager");
        menuCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCustomerMouseClicked(evt);
            }
        });
        menuCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCustomerActionPerformed(evt);
            }
        });
        jMenu10.add(menuCustomer);

        menuProduct.setText("Product Manager");
        menuProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuProductMouseClicked(evt);
            }
        });
        menuProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProductActionPerformed(evt);
            }
        });
        jMenu10.add(menuProduct);

        menuCategory.setText("Category Manager");
        menuCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCategoryMouseClicked(evt);
            }
        });
        jMenu10.add(menuCategory);

        jMenuBar1.add(jMenu10);

        menuProfile.setText("Profile Info");
        menuProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuProfileMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuProfile);

        setJMenuBar(jMenuBar1);

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

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        int c = JOptionPane.showConfirmDialog(null, "Are you sure to logout ?");
        if (c == JOptionPane.OK_OPTION) {
            this.dispose();
            MainFrm login = new MainFrm();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
            ClassData.LoginUser.disposeAll();

        }
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        int c = JOptionPane.showConfirmDialog(null, "Are you sure to exit ?");
        if (c == JOptionPane.OK_OPTION) {
            this.dispose();
            System.exit(0);

        }

    }//GEN-LAST:event_jMenu1MouseClicked

    private void menuOrderMngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOrderMngActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_menuOrderMngActionPerformed

    private void menuEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuEmployeeActionPerformed

    private void menuAdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAdActionPerformed
        // TODO add your handling code here:
        EmployeeFrm x = new EmployeeFrm();
        x.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        x.setVisible(true);
    }//GEN-LAST:event_menuAdActionPerformed

    private void menuCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCustomerActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_menuCustomerActionPerformed

    private void menuProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProductActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_menuProductActionPerformed

    private void jMenu10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu10ActionPerformed
        // TODO add your handling code here:
        CategoryFrm c = new CategoryFrm();
        c.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        c.setVisible(true);
    }//GEN-LAST:event_jMenu10ActionPerformed

    private void menuEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEmployeeMouseClicked
        // TODO add your handling code here:
        EmployeeFrm c = new EmployeeFrm();
        c.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        c.setVisible(true);
    }//GEN-LAST:event_menuEmployeeMouseClicked

    private void menuCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCustomerMouseClicked
        // TODO add your handling code here:
        CustomerFrm x = new CustomerFrm();
        x.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        x.setVisible(true);
    }//GEN-LAST:event_menuCustomerMouseClicked

    private void menuProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuProductMouseClicked
        // TODO add your handling code here:
        ProductManager p = new ProductManager();
        p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        p.setVisible(true);
    }//GEN-LAST:event_menuProductMouseClicked

    private void menuCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCategoryMouseClicked
        // TODO add your handling code here:
        CategoryFrm p = new CategoryFrm();
        p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        p.setVisible(true);
    }//GEN-LAST:event_menuCategoryMouseClicked

    private void menuProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuProfileMouseClicked
        // TODO add your handling code here:
        ProfileInformation p = new ProfileInformation();
        p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        p.setVisible(true);
    }//GEN-LAST:event_menuProfileMouseClicked

    private void menuNewOrdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuNewOrdeMouseClicked
        // TODO add your handling code here:
        newBill p = new newBill();
        p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        p.setVisible(true);
    }//GEN-LAST:event_menuNewOrdeMouseClicked

    private void menuOrderMngMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuOrderMngMouseClicked
        // TODO add your handling code here:
        OrderFrm x = new OrderFrm();
        x.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        x.setVisible(true);
    }//GEN-LAST:event_menuOrderMngMouseClicked

    private void btnWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWeekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnWeekActionPerformed

    private void btnTodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTodayActionPerformed

    private void btnToday1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToday1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnToday1ActionPerformed

    private void btnToday1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnToday1MouseClicked
        if (this.Datefrom.getDate() != null && this.Dateto.getDate() != null) {
            try {
                Date from = this.Datefrom.getDate();
                Date to = this.Dateto.getDate();
                reportTable(from, to, 10);
                label = "today";
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "An error occured");
            }
        } else {
            JOptionPane.showMessageDialog(null, "An error occured");
        }
    }//GEN-LAST:event_btnToday1MouseClicked

    private void btnExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMouseClicked
        // TODO add your handling code here:
        exportExcel(this.tblReport);
    }//GEN-LAST:event_btnExportMouseClicked

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMonthMouseClicked
        // TODO add your handling code here:
        try {
            Calendar c = Calendar.getInstance();
            c.set(Calendar.DAY_OF_MONTH, 1);
            reportTable(c.getTime(), new Date(), 10);
            label = "this month";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occured");
        }
    }//GEN-LAST:event_btnMonthMouseClicked

    private void btnWeekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWeekMouseClicked
        // TODO add your handling code here:
        try {
            Calendar c = Calendar.getInstance();
            c.set(Calendar.DAY_OF_WEEK, 1);
            reportTable(c.getTime(), new Date(), 10);
            label = "this week";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occured");
        }
    }//GEN-LAST:event_btnWeekMouseClicked

    private void btnTodayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTodayMouseClicked
        // TODO add your handling code here:
        try {
            reportTable(new Date(), new Date(), 10);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occured");
        }
    }//GEN-LAST:event_btnTodayMouseClicked

    private void menuCompInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCompInfoMouseClicked
        // TODO add your handling code here:
        Company c;
        try {
            c = new Company();
             c.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(mainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_menuCompInfoMouseClicked
    public void exportExcel(JTable table) {
        JFileChooser chooser = new JFileChooser();
        TableModel model = this.tblReport.getModel();
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet sheet = workbook.createSheet("Report sheet");
                int rownum = 0;
                Cell cell;
                Row row;

                HSSFCellStyle style = createStyleForTitle(workbook);
                row = sheet.createRow(rownum);
                //Header
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("Report " + label);
                HSSFCellStyle style2 = getHeaderStyle(workbook);
                cell.setCellStyle(style2);
                rownum++;
                row = sheet.createRow(rownum);
                // ID
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue("PRODUCTID");
                cell.setCellStyle(style);
                // NAME
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("NAME");
                cell.setCellStyle(style);
                // COUNT
                cell = row.createCell(2, CellType.NUMERIC);
                cell.setCellValue("Sale Count");
                cell.setCellStyle(style);
                // TOTAL
                cell = row.createCell(3, CellType.NUMERIC);
                cell.setCellValue("Total Revenue");
                cell.setCellStyle(style);
                for (int y = 0; y < model.getRowCount(); y++) {
                    rownum++;
                    row = sheet.createRow(rownum);
                    // ID
                    cell = row.createCell(0, CellType.STRING);
                    cell.setCellValue(model.getValueAt(y, 0).toString());
                    // NAME (B)
                    cell = row.createCell(1, CellType.STRING);
                    cell.setCellValue(model.getValueAt(y, 1).toString());
                    // SALECOUNT (C)
                    cell = row.createCell(2, CellType.NUMERIC);
                    cell.setCellValue(model.getValueAt(y, 2).toString());
                    // REVENUE (D)
                    cell = row.createCell(3, CellType.NUMERIC);
                    cell.setCellValue(model.getValueAt(y, 3).toString());
                    sheet.autoSizeColumn(1);
                }
                FileOutputStream outFile = new FileOutputStream(file + ".xls");
                workbook.write(outFile);
                JOptionPane.showMessageDialog(null, "Export successfully!");
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "An error occured!");
            }
        }
    }

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    private static HSSFCellStyle getHeaderStyle(HSSFWorkbook workbook) {
        // Font
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setItalic(true);

        // Font Height
        font.setFontHeightInPoints((short) 18);

        // Font Color
        font.setColor(IndexedColors.BLUE.index);

        // Style
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);

        return style;
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
            java.util.logging.Logger.getLogger(mainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Datefrom;
    private com.toedter.calendar.JDateChooser Dateto;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnMonth;
    private javax.swing.JButton btnToday;
    private javax.swing.JButton btnToday1;
    private javax.swing.JButton btnWeek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuAd;
    private javax.swing.JMenu menuCategory;
    private javax.swing.JMenu menuCompInfo;
    private javax.swing.JMenu menuCustomer;
    private javax.swing.JMenu menuEmployee;
    private javax.swing.JMenu menuNewOrde;
    private javax.swing.JMenu menuOrderMng;
    private javax.swing.JMenu menuProduct;
    private javax.swing.JMenu menuProfile;
    private javax.swing.JTable tblReport;
    // End of variables declaration//GEN-END:variables
}
