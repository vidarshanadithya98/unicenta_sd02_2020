/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import com.Amasha.Maintenance.Maintenance;
import com.Kethaki.Users.UserHome;

import com.Miyuru.attendance.AttendenceInterfave;
import com.Vidarshan.sales.Sales;
import com.Miyuru.login.LogIn;
import com.Miyuru.login.SignIn;
import com.Savindu.inventory.Views.InventoryPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.Miyuru.login.SignIn;

/**
 *
 * @author vidar
 */
public class AppInterface extends javax.swing.JFrame {

    /**
     * Creates new form Sales
     */
    Home interface_home = new Home();
    //Attendance int_attendance = new Attendance();
    AttendenceInterfave int_attendance = new AttendenceInterfave();
    Sales interface_Sales = new Sales();
    InventoryPanel interface_Inventory = new InventoryPanel();
    UserHome int_user = new UserHome();
    Maintenance int_maintenance = new Maintenance();
     
    public AppInterface() {
        initComponents();
        clock();
        //getContentPane().setBackground(new Color(0,51,51));
        getContentPane().setBackground(Color.WHITE);
        
        //Load home panel
        panelNavigator(interface_home, "Home");
        sideNavBtnEvents(this.jLabel1);
        
        if(SignIn.username == "Emp" )
        {
            btn_Maintenance.setVisible(false);
            btn_Users.setVisible(false);
            
        }else if(SignIn.username == "Admin"){
            btn_Maintenance.setVisible(true);
            btn_Users.setVisible(true);

        }else if(SignIn.username == "Man"){
            btn_Maintenance.setVisible(true);
            btn_Users.setVisible(true);

        }
        
        try {
            URL resource = this.getClass().getResource("/appIcon.png");
            BufferedImage image = ImageIO.read(resource);
            this.setIconImage(image);
           // this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/appIcon.png")));
            this.setTitle("Unicenta");
        } catch (Exception ex) {
            Logger.getLogger(AppInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      this.setExtendedState(this.MAXIMIZED_BOTH);
   
    }

    public void clock(){
     Thread th = new Thread(){
         public void run(){
             try{
                 for(;;){
                     Calendar c1 = new GregorianCalendar();
                     int day = c1.get(Calendar.DAY_OF_MONTH);
                     //temporary fix
                     int month = c1.get(Calendar.MONTH) + 1;
                     int year = c1.get(Calendar.YEAR);
                     
                     int second = c1.get(Calendar.SECOND);
                     int min = c1.get(Calendar.MINUTE);
                     int hour = c1.get(Calendar.HOUR);
                     int am_pm = c1.get(Calendar.AM_PM);
                     
                     String d_n = "";
                     if(am_pm == 1)
                         d_n = "PM";
                     else
                         d_n = "AM";
                     
                     jLabel3.setText(" " + hour+" : " + min + " : " + second + " "+d_n);
                     jLabel2.setText("" + day + " - " + month + " - " + year + " ");
                     sleep(1000);
                 }
             }catch(Exception e){
                 e.printStackTrace();
             }
         }
     };
     th.start();
    }

    public void panelNavigator(JPanel panel, String name){
        contentLayout.removeAll();
        contentLayout.add(panel);
        contentLayout.repaint();
        contentLayout.revalidate();
        this.navbar.setText(name);
          
      
    }
    
      public void sideNavBtnEvents(JLabel btn){
        btn_Maintenance.setForeground(new Color(0xF4F4F4));
        btn_Users.setForeground(new Color(0xF4F4F4));
        btn_attendance.setForeground(new Color(0xF4F4F4));
        btn_inventory.setForeground(new Color(0xF4F4F4));
        btn_salse.setForeground(new Color(0xF4F4F4));
        jLabel1.setForeground(new Color(0xF4F4F4));
        btn.setForeground(new Color(0x2ECC71));
        
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
        jLabel1 = new javax.swing.JLabel();
        btn_Users = new javax.swing.JLabel();
        btn_logout = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btn_salse = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btn_inventory = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        btn_Maintenance = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        btn_attendance = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        navbar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        contentLayout = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(1280, 960));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home24_1.png"))); // NOI18N
        jLabel1.setText("Home");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        btn_Users.setBackground(new java.awt.Color(255, 255, 255));
        btn_Users.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_Users.setForeground(new java.awt.Color(255, 255, 255));
        btn_Users.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user36_1.png"))); // NOI18N
        btn_Users.setText("Users");
        btn_Users.setToolTipText("");
        btn_Users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_UsersMouseClicked(evt);
            }
        });

        btn_logout.setBackground(new java.awt.Color(255, 255, 255));
        btn_logout.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout32_1.png"))); // NOI18N
        btn_logout.setText("Logout");
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_logoutMouseClicked(evt);
            }
        });

        btn_salse.setBackground(new java.awt.Color(255, 255, 255));
        btn_salse.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_salse.setForeground(new java.awt.Color(255, 255, 255));
        btn_salse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pos/images/sales34.png"))); // NOI18N
        btn_salse.setText("Sales");
        btn_salse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_salseMouseClicked(evt);
            }
        });

        btn_inventory.setBackground(new java.awt.Color(255, 255, 255));
        btn_inventory.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_inventory.setForeground(new java.awt.Color(255, 255, 255));
        btn_inventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pos/images/box24.png"))); // NOI18N
        btn_inventory.setText("Inventory");
        btn_inventory.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_inventoryFocusGained(evt);
            }
        });
        btn_inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_inventoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_inventoryMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_inventoryMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_inventoryMouseReleased(evt);
            }
        });

        btn_Maintenance.setBackground(new java.awt.Color(255, 255, 255));
        btn_Maintenance.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_Maintenance.setForeground(new java.awt.Color(255, 255, 255));
        btn_Maintenance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maintenance36_1.png"))); // NOI18N
        btn_Maintenance.setText("Maintenance");
        btn_Maintenance.setToolTipText("");
        btn_Maintenance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_MaintenanceMouseClicked(evt);
            }
        });

        btn_attendance.setBackground(new java.awt.Color(255, 255, 255));
        btn_attendance.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_attendance.setForeground(new java.awt.Color(255, 255, 255));
        btn_attendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendance36_1.png"))); // NOI18N
        btn_attendance.setText("Attendance");
        btn_attendance.setToolTipText("");
        btn_attendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_attendanceMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator5)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator4)
                            .addComponent(jSeparator6)
                            .addComponent(btn_inventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_salse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator7)
                            .addComponent(btn_attendance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_Maintenance, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                .addGap(22, 22, 22))
                            .addComponent(btn_Users, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btn_salse, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_attendance, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Users, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Maintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(55, 71, 79));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("jLabel3");
        jPanel2.add(jLabel3);

        navbar.setBackground(new java.awt.Color(0, 51, 51));
        navbar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        navbar.setForeground(new java.awt.Color(255, 255, 255));
        navbar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navbar.setText("SALES");
        jPanel2.add(navbar);

        jLabel2.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2);

        contentLayout.setBackground(new java.awt.Color(28, 35, 51));
        contentLayout.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentLayout))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentLayout)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salseMouseClicked
        // TODO add your handling code here:
        
        panelNavigator(interface_Sales, "Sales Management");
        sideNavBtnEvents(this.btn_salse);
        
    }//GEN-LAST:event_btn_salseMouseClicked

    private void btn_inventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_inventoryMouseClicked
        // TODO add your handling code here:
        
        panelNavigator(interface_Inventory, "Inventory Management");
        sideNavBtnEvents(this.btn_inventory);
    }//GEN-LAST:event_btn_inventoryMouseClicked

    private void btn_attendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_attendanceMouseClicked
        // TODO add your handling code here:
        
        panelNavigator(int_attendance, "Attendance Management");
        sideNavBtnEvents(this.btn_attendance);
    }//GEN-LAST:event_btn_attendanceMouseClicked

    private void btn_UsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UsersMouseClicked
        // TODO add your handling code here:
        
        panelNavigator(int_user, "User Management");
        sideNavBtnEvents(this.btn_Users);
    }//GEN-LAST:event_btn_UsersMouseClicked

    private void btn_MaintenanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MaintenanceMouseClicked
        // TODO add your handling code here:
       
        panelNavigator(int_maintenance, "Maintenance");
        sideNavBtnEvents(this.btn_Maintenance);
    }//GEN-LAST:event_btn_MaintenanceMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        panelNavigator(interface_home, "Home");
        sideNavBtnEvents(this.jLabel1);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btn_inventoryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_inventoryFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_inventoryFocusGained

    private void btn_inventoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_inventoryMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_inventoryMousePressed

    private void btn_inventoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_inventoryMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_inventoryMouseReleased

    private void btn_inventoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_inventoryMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_inventoryMouseEntered

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
        // TODO add your handling code here:
        
        SignIn i = new SignIn();
        this.setVisible(false);
        i.setVisible(true);
        
        //panelNavigator(int_login, "LogIn");
    }//GEN-LAST:event_btn_logoutMouseClicked

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
            java.util.logging.Logger.getLogger(AppInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppInterface().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_Maintenance;
    private javax.swing.JLabel btn_Users;
    private javax.swing.JLabel btn_attendance;
    private javax.swing.JLabel btn_inventory;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JLabel btn_salse;
    private javax.swing.JLayeredPane contentLayout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel navbar;
    // End of variables declaration//GEN-END:variables
}
