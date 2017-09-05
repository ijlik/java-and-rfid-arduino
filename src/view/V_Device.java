
package view;

import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class V_Device extends View {

    public V_Device() {
        initComponents();
    }
    
    public void setCardId(String s){
        this.cardId.setText(s);
    }
    
    public void setFoto(String s){
        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/" +s+".jpg")));
    }
    
    @Override
    public void setName(String s){
        this.nama.setText(s);
    }
    
    public void setNumId(String s){
        this.numId.setText(s);
    }
    
    public void setJabatan(String s){
        this.jabatan.setText(s);
    }
    
    public void setJadwal(String s){
        this.jadwal.setText(s);
    }
    
    public void setJamAbsen(String s){
        this.jamAbsen.setText(s);
    }
    
    public void setTanggal(String s){
        this.tanggal.setText(s);
    }
    
    public void setStatus(String s){
        this.status.setText(s);
    }
    
    public void setMessages(String s){
        JOptionPane.showMessageDialog(this, s);
    }
    
    public void setJam(String s){
        this.jam.setText(s);
    }
    
    public void addLoginListener(MouseListener e){
        this.login.addMouseListener(e);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jadwal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        login = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        numId = new javax.swing.JLabel();
        jabatan = new javax.swing.JLabel();
        jamAbsen = new javax.swing.JLabel();
        cardId = new javax.swing.JLabel();
        nama = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        jam = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(333, 144));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jadwal.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jadwal.setForeground(new java.awt.Color(255, 255, 255));
        jadwal.setText("00:00");
        jPanel1.add(jadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, -1, -1));

        jLabel2.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Jadwal hari ini jam");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));

        login.setFont(new java.awt.Font("Play", 0, 12)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("click here to login");
        login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 417, -1, -1));

        status.setFont(new java.awt.Font("Play", 0, 17)); // NOI18N
        status.setForeground(new java.awt.Color(255, 255, 255));
        status.setText("XXXXXXXX");
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 348, -1, -1));

        numId.setFont(new java.awt.Font("Play", 0, 17)); // NOI18N
        numId.setForeground(new java.awt.Color(255, 255, 255));
        numId.setText("XXXXXXXX");
        jPanel1.add(numId, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 233, -1, -1));

        jabatan.setFont(new java.awt.Font("Play", 0, 17)); // NOI18N
        jabatan.setForeground(new java.awt.Color(255, 255, 255));
        jabatan.setText("XXXXXXXX");
        jPanel1.add(jabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 271, -1, -1));

        jamAbsen.setFont(new java.awt.Font("Play", 0, 17)); // NOI18N
        jamAbsen.setForeground(new java.awt.Color(255, 255, 255));
        jamAbsen.setText("XXXXXXXX");
        jPanel1.add(jamAbsen, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, -1, -1));

        cardId.setFont(new java.awt.Font("Play", 0, 17)); // NOI18N
        cardId.setForeground(new java.awt.Color(255, 255, 255));
        cardId.setText("XXXXXXXX");
        jPanel1.add(cardId, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 157, -1, -1));

        nama.setFont(new java.awt.Font("Play", 0, 17)); // NOI18N
        nama.setForeground(new java.awt.Color(255, 255, 255));
        nama.setText("XXXXXXXX");
        jPanel1.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 195, -1, -1));

        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/default.jpg"))); // NOI18N
        jPanel1.add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 183, 225));

        tanggal.setFont(new java.awt.Font("Play", 0, 24)); // NOI18N
        tanggal.setForeground(new java.awt.Color(255, 255, 255));
        tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tanggal.setText("17/8/1945");
        jPanel1.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 220, 30));

        jam.setFont(new java.awt.Font("Play", 1, 36)); // NOI18N
        jam.setForeground(new java.awt.Color(255, 255, 255));
        jam.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jam.setText("00:00:00");
        jPanel1.add(jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 220, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/Standby.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cardId;
    private javax.swing.JLabel foto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jabatan;
    private javax.swing.JLabel jadwal;
    private javax.swing.JLabel jam;
    private javax.swing.JLabel jamAbsen;
    private javax.swing.JLabel login;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel numId;
    private javax.swing.JLabel status;
    private javax.swing.JLabel tanggal;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void disableMenu() {
        //nothing
    }
}
