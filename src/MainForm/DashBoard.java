/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainForm;

import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author KIENDINH
 */
public class DashBoard extends javax.swing.JFrame {

    /**
     * Creates new form DashBoard
     */
    public DashBoard() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lbCheck = new javax.swing.JLabel();
        btnEmp = new javax.swing.JPanel();
        btnEmployee = new javax.swing.JLabel();
        btnCustomer = new javax.swing.JPanel();
        btnEmployee1 = new javax.swing.JLabel();
        btnOrder = new javax.swing.JPanel();
        btnEmployee2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 153, 255));
        jLabel9.setText("MANAGEMENT");

        lbCheck.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbCheck.setForeground(new java.awt.Color(255, 0, 51));

        btnEmp.setBackground(new java.awt.Color(45, 118, 232));
        btnEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEmpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEmpMouseExited(evt);
            }
        });

        btnEmployee.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEmployee.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployee.setText("Employee manager");

        javax.swing.GroupLayout btnEmpLayout = new javax.swing.GroupLayout(btnEmp);
        btnEmp.setLayout(btnEmpLayout);
        btnEmpLayout.setHorizontalGroup(
            btnEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEmpLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnEmployee)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnEmpLayout.setVerticalGroup(
            btnEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEmpLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEmployee)
                .addContainerGap())
        );

        btnCustomer.setBackground(new java.awt.Color(45, 118, 232));
        btnCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCustomerMouseExited(evt);
            }
        });

        btnEmployee1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEmployee1.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployee1.setText("Customer manager");

        javax.swing.GroupLayout btnCustomerLayout = new javax.swing.GroupLayout(btnCustomer);
        btnCustomer.setLayout(btnCustomerLayout);
        btnCustomerLayout.setHorizontalGroup(
            btnCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCustomerLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnEmployee1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnCustomerLayout.setVerticalGroup(
            btnCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCustomerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEmployee1)
                .addContainerGap())
        );

        btnOrder.setBackground(new java.awt.Color(45, 118, 232));
        btnOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOrderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOrderMouseExited(evt);
            }
        });

        btnEmployee2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEmployee2.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployee2.setText("Order manager");

        javax.swing.GroupLayout btnOrderLayout = new javax.swing.GroupLayout(btnOrder);
        btnOrder.setLayout(btnOrderLayout);
        btnOrderLayout.setHorizontalGroup(
            btnOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnOrderLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnEmployee2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnOrderLayout.setVerticalGroup(
            btnOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnOrderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEmployee2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEmp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(lbCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(49, 49, 49)
                .addComponent(lbCheck)
                .addGap(197, 197, 197))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpMouseClicked
        EmployeeFrm x = new EmployeeFrm();
        x.setVisible(true);
//        this.setEnabled(false);
////        JDialog dialog = new JDialog(x, true);
////
////        dialog.setVisible(true);
    }//GEN-LAST:event_btnEmpMouseClicked
    private void setColor(JPanel panel) {
        panel.setBackground(new java.awt.Color(0, 51, 255));
    }

    private void resetColor(JPanel panel) {
        panel.setBackground(new java.awt.Color(45, 118, 232));
    }
    private void btnEmpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpMouseEntered
        // TODO add your handling code here:
        setColor(btnEmp);
    }//GEN-LAST:event_btnEmpMouseEntered

    private void btnEmpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpMouseExited
        // TODO add your handling code here:
        resetColor(btnEmp);
    }//GEN-LAST:event_btnEmpMouseExited

    private void btnCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomerMouseClicked
      CustomerFrm x = new CustomerFrm();
        x.setVisible(true);
    }//GEN-LAST:event_btnCustomerMouseClicked

    private void btnCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomerMouseEntered
        // TODO add your handling code here:
        setColor(btnCustomer);
    }//GEN-LAST:event_btnCustomerMouseEntered

    private void btnCustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomerMouseExited
        // TODO add your handling code here:
        resetColor(btnCustomer);
    }//GEN-LAST:event_btnCustomerMouseExited

    private void btnOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrderMouseClicked
        // TODO add your handling code here:
        OrderFrm o = new OrderFrm();
        o.setVisible(true);
    }//GEN-LAST:event_btnOrderMouseClicked

    private void btnOrderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrderMouseEntered
        // TODO add your handling code here:
        setColor(btnOrder);
    }//GEN-LAST:event_btnOrderMouseEntered

    private void btnOrderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrderMouseExited
        // TODO add your handling code here:
        resetColor(btnOrder);
    }//GEN-LAST:event_btnOrderMouseExited

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
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnCustomer;
    private javax.swing.JPanel btnEmp;
    private javax.swing.JLabel btnEmployee;
    private javax.swing.JLabel btnEmployee1;
    private javax.swing.JLabel btnEmployee2;
    private javax.swing.JPanel btnOrder;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbCheck;
    // End of variables declaration//GEN-END:variables
}
