package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Scedule;
import view.V_Scedule;

public class SceduleController {

    private V_Scedule theView;
    private Scedule theModel;
    private String thn;
    private String bulan;

    public SceduleController(V_Scedule theView, Scedule theModel) throws SQLException {
        this.theView = theView;
        this.theModel = theModel;
        this.theView.setVisible(true);
        this.theView.setTableModel(this.theModel.getTableModel());
        this.theView.addTableListener(new TableListener());
        this.theView.addSaveListener(new SaveListener());
        this.theView.addEditListener(new EditListener());
        this.theView.addDeleteListener(new DeleteListener());
        this.theView.addUpdateListener(new UpdateListener());
        this.theView.addTahunListener(new TahunListener());
        this.theView.addBulanListener(new BulanListener());
    }

    private class BulanListener implements ActionListener {

        public BulanListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String[] getTanggal = theView.getTanggal().split("-");
            bulan = getTanggal[1];
            if ("kabisat".equals(thn)) {
                if (null != bulan) {
                    switch (bulan) {
                        case "02":
                            theView.disableTanggal();
                            theView.enableTanggal29();
                            break;
                        case "01":
                        case "03":
                        case "05":
                        case "07":
                        case "08":
                        case "10":
                        case "12":
                            theView.disableTanggal();
                            theView.enableTanggal31();
                            break;
                        default:
                            theView.disableTanggal();
                            theView.enableTanggal30();
                            break;
                    }
                }
            } else {
                switch (bulan) {
                    case "02":
                        theView.disableTanggal();
                        theView.enableTanggal28();
                        break;
                    case "01":
                    case "03":
                    case "05":
                    case "07":
                    case "08":
                    case "10":
                    case "12":
                        theView.disableTanggal();
                        theView.enableTanggal31();
                        break;
                    default:
                        theView.disableTanggal();
                        theView.enableTanggal30();
                        break;
                }
            }
        }
    }

    private class TahunListener implements ActionListener {

        public TahunListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String[] getTanggal = theView.getTanggal().split("-");
            int tahun = Integer.parseInt(getTanggal[0]);
            if (tahun % 4 == 0) {
                thn = "kabisat";
            } else {
                thn = "biasa";
            }
            theView.enableBulan();
        }
    }

    private class UpdateListener implements ActionListener {

        public UpdateListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            theModel.setTanggal(theView.getLabelTanggal());
            theModel.setJam(theView.getLabelJam());
            try {
                theModel.edit();
                JOptionPane.showMessageDialog(theView, "Data berhasil diperbarui");
                theView.setTableModel(theModel.getTableModel());
                theView.disablePanel();
                theView.clearInput();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(theView, "Data gagal diubah");
                System.err.println("Error update query");
            }
        }
    }

    private class TableListener implements MouseListener {

        public TableListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            theView.enableEditAndDelete();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class SaveListener implements ActionListener {

        public SaveListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int periode = theView.getPeriode();
            String hari = theView.getHari();
            String jam = theView.getJam();
            String[] tgl = theView.getTanggal().split("-");
            int[] bln = new int[5];
            int[] tanggal = {Integer.parseInt(tgl[2]), Integer.parseInt(tgl[2]) + 7, Integer.parseInt(tgl[2]) + 14, Integer.parseInt(tgl[2]) + 21, Integer.parseInt(tgl[2]) + 28};
            bln[0] = Integer.parseInt(tgl[1]);
            bln[1] = Integer.parseInt(tgl[1]);
            bln[2] = Integer.parseInt(tgl[1]);
            bln[3] = Integer.parseInt(tgl[1]);
            bln[4] = Integer.parseInt(tgl[1]);

            switch (bln[0]) {
                case 2:
                    if (tanggal[0] > 28) {
                        bln[0] = bln[0] + 1;
                        bln[1] = bln[1] + 1;
                        bln[2] = bln[2] + 1;
                        bln[3] = bln[3] + 1;
                        bln[4] = bln[4] + 1;
                        tanggal[1] = tanggal[1] - 28;
                        tanggal[2] = tanggal[2] - 28;
                        tanggal[3] = tanggal[3] - 28;
                        tanggal[4] = tanggal[4] - 28;
                    }
                case 4:
                case 6:
                case 9:
                case 11:
                    if (tanggal[0] > 30) {
                        bln[0] = bln[0] + 1;
                        bln[1] = bln[1] + 1;
                        bln[2] = bln[2] + 1;
                        bln[3] = bln[3] + 1;
                        bln[4] = bln[4] + 1;
                        tanggal[0] = tanggal[0] - 30;
                        tanggal[1] = tanggal[1] - 30;
                        tanggal[2] = tanggal[2] - 30;
                        tanggal[3] = tanggal[3] - 30;
                        tanggal[4] = tanggal[4] - 30;
                    }
                    break;
                default:
                    if (tanggal[0] > 31) {
                        bln[0] = bln[0] + 1;
                        bln[1] = bln[1] + 1;
                        bln[2] = bln[2] + 1;
                        bln[3] = bln[3] + 1;
                        bln[4] = bln[4] + 1;
                        tanggal[0] = tanggal[0] - 31;
                        tanggal[1] = tanggal[1] - 31;
                        tanggal[2] = tanggal[2] - 31;
                        tanggal[3] = tanggal[3] - 31;
                        tanggal[4] = tanggal[4] - 31;
                    }
                    break;
            }

            switch (bln[1]) {
                case 2:
                    if (tanggal[1] > 28) {
                        bln[1] = bln[1] + 1;
                        bln[2] = bln[2] + 1;
                        bln[3] = bln[3] + 1;
                        bln[4] = bln[4] + 1;
                        tanggal[1] = tanggal[1] - 28;
                        tanggal[2] = tanggal[2] - 28;
                        tanggal[3] = tanggal[3] - 28;
                        tanggal[4] = tanggal[4] - 28;
                    }
                case 4:
                case 6:
                case 9:
                case 11:
                    if (tanggal[1] > 30) {
                        bln[1] = bln[1] + 1;
                        bln[2] = bln[2] + 1;
                        bln[3] = bln[3] + 1;
                        bln[4] = bln[4] + 1;
                        tanggal[1] = tanggal[1] - 30;
                        tanggal[2] = tanggal[2] - 30;
                        tanggal[3] = tanggal[3] - 30;
                        tanggal[4] = tanggal[4] - 30;
                    }
                    break;
                default:
                    if (tanggal[1] > 31) {
                        bln[1] = bln[1] + 1;
                        bln[2] = bln[2] + 1;
                        bln[3] = bln[3] + 1;
                        bln[4] = bln[4] + 1;
                        tanggal[1] = tanggal[1] - 31;
                        tanggal[2] = tanggal[2] - 31;
                        tanggal[3] = tanggal[3] - 31;
                        tanggal[4] = tanggal[4] - 31;
                    }
                    break;
            }

            switch (bln[2]) {
                case 2:
                    if (tanggal[2] > 28) {
                        bln[2] = bln[2] + 1;
                        bln[3] = bln[3] + 1;
                        bln[4] = bln[4] + 1;
                        tanggal[2] = tanggal[2] - 28;
                        tanggal[3] = tanggal[3] - 28;
                        tanggal[4] = tanggal[4] - 28;
                    }
                case 4:
                case 6:
                case 9:
                case 11:
                    if (tanggal[2] > 30) {
                        bln[2] = bln[2] + 1;
                        bln[3] = bln[3] + 1;
                        bln[4] = bln[4] + 1;
                        tanggal[2] = tanggal[2] - 30;
                        tanggal[3] = tanggal[3] - 30;
                        tanggal[4] = tanggal[4] - 30;
                    }
                    break;
                default:
                    if (tanggal[2] > 31) {
                        bln[2] = bln[2] + 1;
                        bln[3] = bln[3] + 1;
                        bln[4] = bln[4] + 1;
                        tanggal[2] = tanggal[2] - 31;
                        tanggal[3] = tanggal[3] - 31;
                        tanggal[4] = tanggal[4] - 31;
                    }
                    break;
            }

            switch (bln[3]) {
                case 2:
                    if (tanggal[3] > 28) {
                        bln[3] = bln[3] + 1;
                        bln[4] = bln[4] + 1;
                        tanggal[3] = tanggal[3] - 28;
                        tanggal[4] = tanggal[4] - 28;
                    }
                case 4:
                case 6:
                case 9:
                case 11:
                    if (tanggal[3] > 30) {
                        bln[3] = bln[3] + 1;
                        bln[4] = bln[4] + 1;
                        tanggal[3] = tanggal[3] - 30;
                        tanggal[4] = tanggal[4] - 30;
                    }
                    break;
                default:
                    if (tanggal[3] > 31) {
                        bln[3] = bln[3] + 1;
                        bln[4] = bln[4] + 1;
                        tanggal[3] = tanggal[3] - 31;
                        tanggal[4] = tanggal[4] - 31;
                    }
                    break;
            }

            switch (bln[4]) {
                case 2:
                    if (tanggal[4] > 28) {
                        bln[4] = bln[4] + 1;
                        tanggal[4] = tanggal[4] - 28;
                    }
                case 4:
                case 6:
                case 9:
                case 11:
                    if (tanggal[4] > 30) {
                        bln[4] = bln[4] + 1;
                        tanggal[4] = tanggal[4] - 30;
                    }
                    break;
                default:
                    if (tanggal[4] > 31) {
                        bln[4] = bln[4] + 1;
                        tanggal[4] = tanggal[4] - 31;
                    }
                    break;
            }
            String inTgl[] = new String[5];
            for (int i = 0; i < tanggal.length; i++) {
                inTgl[i] = (Integer.toString(tanggal[i]).length() == 2) ? Integer.toString(tanggal[i]) : "0" + Integer.toString(tanggal[i]);
            }
            String inBln[] = new String[5];
            for (int i = 0; i < bln.length; i++) {
                inBln[i] = (Integer.toString(bln[i]).length() == 2) ? Integer.toString(bln[i]) : "0" + Integer.toString(bln[i]);
            }
            String[] inputTanggal = new String[5];
            for (int i = 0; i < inputTanggal.length; i++) {
                inputTanggal[i] = tgl[0] + "-" + inBln[i] + "-" + inTgl[i];
            }

            try {
                if (periode > 1) {
                    theModel.setHari(theView.getHari());
                    theModel.setJam(theView.getJam());
                    theModel.save(inputTanggal);
                    
                    theView.setTableModel(theModel.getTableModel());
                    theView.disablePanel();
                    theView.clearInput();
                } else {
                    theModel.setHari(theView.getHari());
                    theModel.setJam(theView.getJam());
                    theModel.setTanggal(theView.getTanggal());
                    if (!theModel.cekJadwal(theView.getTanggal())) {
                        theModel.save();
                    } else {
                        JOptionPane.showMessageDialog(theView, "Jadwal untuk tanggal " + theView.getTanggal() + " sudah ada");
                    }
                    theView.setTableModel(theModel.getTableModel());
                    theView.disablePanel();
                    theView.clearInput();
                }
            } catch (SQLException ex) {
                System.err.println("Error saving query");
                System.err.println(ex);
            }
        }
    }

    private class EditListener implements ActionListener {

        public EditListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.viewEdit();
            theModel.setSelectedRow(theView.getSelectedRow());
            theView.setLabelTanggal(theModel.getTanggal());
            theView.setLabelJam(theModel.getJam());
        }
    }

    private class DeleteListener implements ActionListener {

        public DeleteListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            theModel.setSelectedRow(theView.getSelectedRow());
            try {
                theModel.delete();
                theView.disableEditAndDelete();
                theView.setTableModel(theModel.getTableModel());
            } catch (SQLException ex) {
                System.err.println("Error deleting query");
            }
        }
    }
}
