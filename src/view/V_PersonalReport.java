package view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class V_PersonalReport extends View {

    public V_PersonalReport() {
        initComponents();
        disableMenu();
    }

    @Override
    protected final void disableMenu(){
        homeButton1.setVisible(false);
        pengButton1.setVisible(false);
        reportButton1.setVisible(false);
        settingButton1.setVisible(false);
        infoButton1.setVisible(false);
        accountButton1.setVisible(false);
        logout1.setVisible(false);
        logout.setVisible(false);
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jabatan = new javax.swing.JLabel();
        nama = new javax.swing.JLabel();
        nim = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        homeButton = new javax.swing.JLabel();
        homeButton1 = new javax.swing.JLabel();
        pengButton = new javax.swing.JLabel();
        pengButton1 = new javax.swing.JLabel();
        reportButton = new javax.swing.JLabel();
        reportButton1 = new javax.swing.JLabel();
        settingButton = new javax.swing.JLabel();
        settingButton1 = new javax.swing.JLabel();
        infoButton = new javax.swing.JLabel();
        infoButton1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        accountButton = new javax.swing.JLabel();
        accountButton1 = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        logout1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(333, 144));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jLabel2.setText("Nama          :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jLabel3.setText("NIM              :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jLabel4.setText("Jabatan      :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        jLabel6.setFont(new java.awt.Font("Play", 0, 18)); // NOI18N
        jLabel6.setText("Informasi Pribadi");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jabatan.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jabatan.setText("Informasi Pribadi");
        jPanel3.add(jabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, -1));

        nama.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        nama.setText("Informasi Pribadi");
        jPanel3.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        nim.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        nim.setText("Informasi Pribadi");
        jPanel3.add(nim, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 630, 270));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 85, 670, 395));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/homeButton.png"))); // NOI18N
        homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeButtonMouseEntered(evt);
            }
        });
        jPanel2.add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, -1));

        homeButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/homeButton-hover.png"))); // NOI18N
        homeButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeButton1MouseExited(evt);
            }
        });
        jPanel2.add(homeButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, -1));

        pengButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/pengButton.png"))); // NOI18N
        pengButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pengButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pengButtonMouseEntered(evt);
            }
        });
        jPanel2.add(pengButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 50, -1));

        pengButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/pengButton-hover.png"))); // NOI18N
        pengButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pengButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pengButton1MouseExited(evt);
            }
        });
        jPanel2.add(pengButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 50, -1));

        reportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/reportButton.png"))); // NOI18N
        reportButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportButtonMouseEntered(evt);
            }
        });
        jPanel2.add(reportButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 50, -1));

        reportButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/reportButton-hover.png"))); // NOI18N
        reportButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportButton1MouseExited(evt);
            }
        });
        jPanel2.add(reportButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 50, -1));

        settingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/settingButton.png"))); // NOI18N
        settingButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingButtonMouseEntered(evt);
            }
        });
        jPanel2.add(settingButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 50, -1));

        settingButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/settingButton-hover.png"))); // NOI18N
        settingButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingButton1MouseExited(evt);
            }
        });
        jPanel2.add(settingButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 50, -1));

        infoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/infoButton.png"))); // NOI18N
        infoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        infoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                infoButtonMouseEntered(evt);
            }
        });
        jPanel2.add(infoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 50, -1));

        infoButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/infoButton-hover.png"))); // NOI18N
        infoButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        infoButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                infoButton1MouseExited(evt);
            }
        });
        jPanel2.add(infoButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 50, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, 420));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        accountButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/accountButton.png"))); // NOI18N
        accountButton.setText("jLabel2");
        accountButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accountButtonMouseEntered(evt);
            }
        });
        jPanel1.add(accountButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 90, -1));

        accountButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/accountButton-hover.png"))); // NOI18N
        accountButton1.setText("jLabel2");
        accountButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accountButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountButton1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accountButton1MouseExited(evt);
            }
        });
        jPanel1.add(accountButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 90, -1));

        logout.setBackground(new java.awt.Color(255, 51, 51));
        logout.setFont(new java.awt.Font("Play", 1, 12)); // NOI18N
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/logout.png"))); // NOI18N
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
        });
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 55, 90, 30));

        logout1.setBackground(new java.awt.Color(255, 51, 51));
        logout1.setFont(new java.awt.Font("Play", 1, 12)); // NOI18N
        logout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/logout-hover.png"))); // NOI18N
        logout1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logout1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logout1MouseExited(evt);
            }
        });
        jPanel1.add(logout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 55, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/Dashboard.jpg"))); // NOI18N
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseEntered
        // TODO add your handling code here:
        homeButton1.setVisible(true);
        homeButton.setVisible(false);
    }//GEN-LAST:event_homeButtonMouseEntered

    private void pengButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pengButtonMouseEntered
        // TODO add your handling code here:
        pengButton1.setVisible(true);
        pengButton.setVisible(false);
    }//GEN-LAST:event_pengButtonMouseEntered

    private void reportButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportButtonMouseEntered
        // TODO add your handling code here:
        reportButton1.setVisible(true);
        reportButton.setVisible(false);
    }//GEN-LAST:event_reportButtonMouseEntered

    private void settingButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingButtonMouseEntered
        // TODO add your handling code here:
        settingButton1.setVisible(true);
        settingButton.setVisible(false);
    }//GEN-LAST:event_settingButtonMouseEntered

    private void infoButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoButtonMouseEntered
        // TODO add your handling code here:
        infoButton1.setVisible(true);
        infoButton.setVisible(false);
    }//GEN-LAST:event_infoButtonMouseEntered

    private void homeButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButton1MouseExited
        // TODO add your handling code here:
        homeButton1.setVisible(false);
        homeButton.setVisible(true);
    }//GEN-LAST:event_homeButton1MouseExited

    private void pengButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pengButton1MouseExited
        // TODO add your handling code here:
        pengButton1.setVisible(false);
        pengButton.setVisible(true);
    }//GEN-LAST:event_pengButton1MouseExited

    private void reportButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportButton1MouseExited
        // TODO add your handling code here:
        reportButton1.setVisible(false);
        reportButton.setVisible(true);
    }//GEN-LAST:event_reportButton1MouseExited

    private void settingButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingButton1MouseExited
        // TODO add your handling code here:
        settingButton1.setVisible(false);
        settingButton.setVisible(true);
    }//GEN-LAST:event_settingButton1MouseExited

    private void infoButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoButton1MouseExited
        // TODO add your handling code here:
        infoButton1.setVisible(false);
        infoButton.setVisible(true);
    }//GEN-LAST:event_infoButton1MouseExited

    private void accountButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountButtonMouseEntered
        // TODO add your handling code here:
        accountButton.setVisible(false);
        accountButton1.setVisible(true);
    }//GEN-LAST:event_accountButtonMouseEntered

    private void accountButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountButton1MouseExited
        // TODO add your handling code here:
        accountButton.setVisible(true);
        accountButton1.setVisible(false);
        logout.setVisible(false);
        logout1.setVisible(false);
    }//GEN-LAST:event_accountButton1MouseExited

    private void accountButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountButton1MouseClicked
        // TODO add your handling code here:
        logout.setVisible(true);
    }//GEN-LAST:event_accountButton1MouseClicked

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        // TODO add your handling code here:
        logout1.setVisible(true);
        logout.setVisible(false);
    }//GEN-LAST:event_logoutMouseEntered

    private void logout1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout1MouseExited
        // TODO add your handling code here:
        logout1.setVisible(false);
        logout.setVisible(false);
    }//GEN-LAST:event_logout1MouseExited

    private void logout1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout1MouseClicked
        try {
            new main.Main().Login();
        } catch (SQLException ex) {
            Logger.getLogger(V_PersonalReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }//GEN-LAST:event_logout1MouseClicked

    public void setNama(String s){
        nama.setText(s);
    }
    public void setNim(String s){
        nim.setText(s);
    }
    public void setJabatan(String s){
        jabatan.setText(s);
    }
    public void setTableModel(DefaultTableModel tm) {
        tabel.setModel(tm);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountButton;
    private javax.swing.JLabel accountButton1;
    private javax.swing.JLabel homeButton;
    private javax.swing.JLabel homeButton1;
    private javax.swing.JLabel infoButton;
    private javax.swing.JLabel infoButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jabatan;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel logout1;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel nim;
    private javax.swing.JLabel pengButton;
    private javax.swing.JLabel pengButton1;
    private javax.swing.JLabel reportButton;
    private javax.swing.JLabel reportButton1;
    private javax.swing.JLabel settingButton;
    private javax.swing.JLabel settingButton1;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
