/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ij Lik
 */
public class V_Scedule extends View {

    public V_Scedule() {
        initComponents();
        disableMenu();
        disablePanel();
        disableEditAndDelete();
        disableTanggal();
        tanggal31.setVisible(true);
        bulan.setEnabled(false);
    }

    public final void disablePanel() {
        editPanel.setVisible(false);
        addPanel.setVisible(true);
        viewPanel.setVisible(true);
    }

    public final void disableTanggal() {
        tanggal28.setVisible(false);
        tanggal29.setVisible(false);
        tanggal30.setVisible(false);
        tanggal31.setVisible(false);
        tanggal28.setEnabled(false);
        tanggal29.setEnabled(false);
        tanggal30.setEnabled(false);
        tanggal31.setEnabled(false);
    }

    public void enableBulan() {
        bulan.setEnabled(true);
    }

    public void enableTanggal28() {
        tanggal28.setVisible(true);
        tanggal28.setEnabled(true);
    }

    public void enableTanggal29() {
        tanggal29.setVisible(true);
        tanggal29.setEnabled(true);
    }

    public void enableTanggal30() {
        tanggal30.setVisible(true);
        tanggal30.setEnabled(true);
    }

    public void enableTanggal31() {
        tanggal31.setVisible(true);
        tanggal31.setEnabled(true);
    }

    @Override
    protected void disableMenu() {
        homeButton1.setVisible(false);
        pengButton1.setVisible(false);
        reportButton1.setVisible(false);
        settingButton1.setVisible(false);
        infoButton1.setVisible(false);
        accountButton1.setVisible(false);
        logout1.setVisible(false);
        logout.setVisible(false);
    }

    //-------------------------------------------
    public void addTahunListener(ActionListener e) {
        tahun.addActionListener(e);
    }

    public void addBulanListener(ActionListener e) {
        bulan.addActionListener(e);
    }

    //=============================================
    public String getIdJadwal() {
        return this.idJadwal.getText();
    }

    public String getHari() {
        return this.hari.getSelectedItem().toString();
    }

    public int getPeriode() {
        switch (this.periode.getSelectedItem().toString()) {
            case "1 Minggu":
                return 1;
            case "1 Bulan":
                return 4;
            default:
                return 0;
        }
    }

    public String getTanggal() {
        String tanggal;
        if (tahun.getSelectedItem().toString().equals("2020") || tahun.getSelectedItem().toString().equals("2024")) {
            switch (bulan.getSelectedItem().toString()) {
                case "02":
                    tanggal = tahun.getSelectedItem().toString() + "-" + bulan.getSelectedItem().toString() + "-" + tanggal29.getSelectedItem().toString();
                    break;
                case "01":
                case "03":
                case "05":
                case "07":
                case "08":
                case "10":
                case "12":
                    tanggal = tahun.getSelectedItem().toString() + "-" + bulan.getSelectedItem().toString() + "-" + tanggal31.getSelectedItem().toString();
                    break;
                default:
                    tanggal = tahun.getSelectedItem().toString() + "-" + bulan.getSelectedItem().toString() + "-" + tanggal30.getSelectedItem().toString();
                    break;
            }
        } else {
            switch (bulan.getSelectedItem().toString()) {
                case "02":
                    tanggal = tahun.getSelectedItem().toString() + "-" + bulan.getSelectedItem().toString() + "-" + tanggal28.getSelectedItem().toString();
                    break;
                case "01":
                case "03":
                case "05":
                case "07":
                case "08":
                case "10":
                case "12":
                    tanggal = tahun.getSelectedItem().toString() + "-" + bulan.getSelectedItem().toString() + "-" + tanggal31.getSelectedItem().toString();
                    break;
                default:
                    tanggal = tahun.getSelectedItem().toString() + "-" + bulan.getSelectedItem().toString() + "-" + tanggal30.getSelectedItem().toString();
                    break;
            }

        }
        return tanggal;
    }

    public String getJam() {
        return this.jam.getSelectedItem().toString() + ":" + this.menit.getSelectedItem().toString() + ":00";
    }

    //==============================================
    public void setIdJadwal(String s) {
        this.idJadwal.setText(s);
    }

    public void setHari(String s) {
        this.hari.setSelectedItem(s);
    }

    public void setTanggal(String s) {
        String[] tanggal = s.split("-");
        this.tahun.setSelectedItem(tanggal[0]);
        this.bulan.setSelectedItem(tanggal[1]);
        this.tanggal28.setSelectedItem(tanggal[2]);
        if (tanggal[0].equals("2020") || tanggal[0].equals("2024")) {
            switch (tanggal[1]) {
                case "02":
                    this.tanggal29.setSelectedItem(tanggal[2]);
                    break;
                case "01":
                case "03":
                case "05":
                case "07":
                case "08":
                case "10":
                case "12":
                    this.tanggal31.setSelectedItem(tanggal[2]);
                    break;
                default:
                    this.tanggal30.setSelectedItem(tanggal[2]);
                    break;
            }
        } else {
            switch (tanggal[1]) {
                case "02":
                    this.tanggal28.setSelectedItem(tanggal[2]);
                    break;
                case "01":
                case "03":
                case "05":
                case "07":
                case "08":
                case "10":
                case "12":
                    this.tanggal31.setSelectedItem(tanggal[2]);
                    break;
                default:
                    this.tanggal30.setSelectedItem(tanggal[2]);
                    break;
            }
        }
    }

    public void setJam(String s) {
        String[] jam = s.split(":");
        this.jam.setSelectedItem(jam[0]);
        this.menit.setSelectedItem(jam[1]);
    }

    public void setLabelTanggal(String s) {
        lblTanggal.setText(s);
    }

    public void setLabelJam(String s) {
        String[] jam = s.split(":");
        lblJam.setSelectedItem(jam[0]);
        lblMenit.setSelectedItem(jam[1]);
    }

    public String getLabelJam() {
        return lblJam.getSelectedItem().toString() + ":" + lblMenit.getSelectedItem().toString() + ":00";
    }

    public String getLabelTanggal() {
        return lblTanggal.getText();
    }

    //===============================================
    public void addTableListener(MouseListener listener) {
        tabelPengguna.addMouseListener(listener);
    }

    public void setTableModel(DefaultTableModel tm) {
        tabelPengguna.setModel(tm);
    }

    public int getSelectedRow() {
        return tabelPengguna.getSelectedRow();
    }

    public void addEditListener(ActionListener listener) {
        edit.addActionListener(listener);
    }

    public void addSaveListener(ActionListener listener) {
        save.addActionListener(listener);
    }

    public void addDeleteListener(ActionListener listener) {
        delete.addActionListener(listener);
    }

    public void addUpdateListener(ActionListener listener) {
        update.addActionListener(listener);
    }

    //=================================================
    public void enableHariAndPeriode() {
        hari.setEnabled(true);
        periode.setEnabled(true);
    }

    public void disableHariAndPeriode() {
        hari.setEnabled(false);
        periode.setEnabled(false);
    }

    public void enableEditAndDelete() {
        edit.setEnabled(true);
        delete.setEnabled(true);
    }

    public final void disableEditAndDelete() {
        edit.setEnabled(false);
        delete.setEnabled(false);
    }

    public void clearInput() {
        idJadwal.setText("");
        lblTanggal.setText("");
    }

    public void viewEdit() {
        editPanel.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
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
        pengguna = new javax.swing.JPanel();
        editPanel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        cancel1 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblTanggal = new javax.swing.JLabel();
        lblJam = new javax.swing.JComboBox();
        lblMenit = new javax.swing.JComboBox();
        viewPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPengguna = new javax.swing.JTable();
        delete = new javax.swing.JButton();
        idJadwal = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        addPanel = new javax.swing.JPanel();
        save = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        periode = new javax.swing.JComboBox();
        hari = new javax.swing.JComboBox();
        tahun = new javax.swing.JComboBox();
        bulan = new javax.swing.JComboBox();
        tanggal28 = new javax.swing.JComboBox();
        tanggal29 = new javax.swing.JComboBox();
        tanggal30 = new javax.swing.JComboBox();
        tanggal31 = new javax.swing.JComboBox();
        jam = new javax.swing.JComboBox();
        menit = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        accountButton = new javax.swing.JLabel();
        accountButton1 = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        logout1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel10.setFont(new java.awt.Font("Play", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pengaturan Jadwal");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(333, 144));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pengButton1MouseClicked(evt);
            }
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportButton1MouseClicked(evt);
            }
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingButton1MouseClicked(evt);
            }
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

        pengguna.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editPanel.setBackground(new java.awt.Color(204, 204, 255));
        editPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        editPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 210, 10));

        cancel1.setText("Cancel");
        cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel1ActionPerformed(evt);
            }
        });
        editPanel.add(cancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 30));

        update.setText("Update");
        editPanel.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 90, 30));

        jLabel9.setText("Edit jam untuk tanggal");
        editPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        lblTanggal.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        lblTanggal.setText("1945/08/17");
        editPanel.add(lblTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 90, 30));

        lblJam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        editPanel.add(lblJam, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 70, 30));

        lblMenit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        editPanel.add(lblMenit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 70, 30));

        pengguna.add(editPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 260, 190));

        viewPanel.setBackground(new java.awt.Color(231, 244, 252));
        viewPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelPengguna.setBackground(new java.awt.Color(231, 244, 252));
        tabelPengguna.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabelPengguna.setFont(new java.awt.Font("Play", 0, 12)); // NOI18N
        tabelPengguna.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPengguna.setGridColor(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(tabelPengguna);

        viewPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 270, 230));

        delete.setFont(new java.awt.Font("Play", 0, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(19, 121, 206));
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/delete.png"))); // NOI18N
        delete.setText("delete");
        delete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewPanel.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 80, 30));
        viewPanel.add(idJadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        edit.setFont(new java.awt.Font("Play", 0, 12)); // NOI18N
        edit.setForeground(new java.awt.Color(19, 121, 206));
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/edit.png"))); // NOI18N
        edit.setText("edit");
        edit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewPanel.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        pengguna.add(viewPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 390));

        addPanel.setBackground(new java.awt.Color(231, 244, 252));
        addPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        save.setText("Save");
        addPanel.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 90, 30));

        jLabel3.setText("Tanggal mulai");
        addPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, 30));

        jLabel4.setText("Jam");
        addPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, -1, 30));

        jLabel5.setText("selama");
        addPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 50, -1, 30));

        jLabel11.setText("Set Jadwal untuk hari");
        addPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 50, -1, 30));

        periode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 Minggu", "1 Bulan" }));
        addPanel.add(periode, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 90, 30));

        hari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu" }));
        addPanel.add(hari, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 90, 30));

        tahun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" }));
        addPanel.add(tahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 70, 30));

        bulan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        addPanel.add(bulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 70, 30));

        tanggal28.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28" }));
        addPanel.add(tanggal28, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 70, 30));

        tanggal29.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29" }));
        addPanel.add(tanggal29, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 70, 30));

        tanggal30.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        addPanel.add(tanggal30, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 70, 30));

        tanggal31.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        addPanel.add(tanggal31, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 70, 30));

        jam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        addPanel.add(jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 70, 30));

        menit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        addPanel.add(menit, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 70, 30));
        addPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 230, 10));

        pengguna.add(addPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 520, 390));

        getContentPane().add(pengguna, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 670, 390));

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

    private void accountButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountButton1MouseClicked
        // TODO add your handling code here:
        logout.setVisible(true);
    }//GEN-LAST:event_accountButton1MouseClicked

    private void accountButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountButton1MouseExited
        // TODO add your handling code here:
        accountButton.setVisible(true);
        accountButton1.setVisible(false);
        logout.setVisible(false);
        logout1.setVisible(false);
    }//GEN-LAST:event_accountButton1MouseExited

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        // TODO add your handling code here:
        logout1.setVisible(true);
        logout.setVisible(false);
    }//GEN-LAST:event_logoutMouseEntered

    private void logout1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout1MouseClicked
        try {
            // TODO add your handling code here:
            this.setVisible(false);
            new main.Main().Login();
        } catch (SQLException ex) {
            Logger.getLogger(V_Scedule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logout1MouseClicked

    private void logout1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout1MouseExited
        // TODO add your handling code here:
        logout1.setVisible(false);
        logout.setVisible(false);
    }//GEN-LAST:event_logout1MouseExited

    private void cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel1ActionPerformed
        // TODO add your handling code here:
        editPanel.setVisible(false);
        viewPanel.setVisible(true);
        addPanel.setVisible(true);
    }//GEN-LAST:event_cancel1ActionPerformed

    private void reportButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportButton1MouseClicked
        try {
            new main.Main().Absensi();
        } catch (SQLException ex) {
            Logger.getLogger(V_Scedule.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }//GEN-LAST:event_reportButton1MouseClicked

    private void settingButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingButton1MouseClicked
        try {
            new main.Main().Pengaturan();
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(V_Member.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_settingButton1MouseClicked

    private void pengButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pengButton1MouseClicked
        try {
            new main.Main().Pengguna();
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(V_Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pengButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountButton;
    private javax.swing.JLabel accountButton1;
    private javax.swing.JPanel addPanel;
    private javax.swing.JComboBox bulan;
    private javax.swing.JButton cancel1;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JPanel editPanel;
    private javax.swing.JComboBox hari;
    private javax.swing.JLabel homeButton;
    private javax.swing.JLabel homeButton1;
    private javax.swing.JLabel idJadwal;
    private javax.swing.JLabel infoButton;
    private javax.swing.JLabel infoButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox jam;
    private javax.swing.JComboBox lblJam;
    private javax.swing.JComboBox lblMenit;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel logout1;
    private javax.swing.JComboBox menit;
    private javax.swing.JLabel pengButton;
    private javax.swing.JLabel pengButton1;
    private javax.swing.JPanel pengguna;
    private javax.swing.JComboBox periode;
    private javax.swing.JLabel reportButton;
    private javax.swing.JLabel reportButton1;
    private javax.swing.JButton save;
    private javax.swing.JLabel settingButton;
    private javax.swing.JLabel settingButton1;
    private javax.swing.JTable tabelPengguna;
    private javax.swing.JComboBox tahun;
    private javax.swing.JComboBox tanggal28;
    private javax.swing.JComboBox tanggal29;
    private javax.swing.JComboBox tanggal30;
    private javax.swing.JComboBox tanggal31;
    private javax.swing.JButton update;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
