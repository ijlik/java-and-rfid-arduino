package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Report;
import view.V_Report;

public class ReportController {

    private final V_Report theView;
    private final Report theModel;
    
    public ReportController(V_Report View, Report Model) throws SQLException{
        this.theView = View;
        this.theModel = Model;
        this.theView.setVisible(true);
        this.theView.addTableListener(new TableListener());
        this.theView.addEditListener(new EditListener());
        this.theView.addUpdateListener(new UpdateListener());
        this.theView.setTableModel(this.theModel.getTableModel());
    }

    private class UpdateListener implements ActionListener {

        public UpdateListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            theModel.setTanggal(theView.getEditTanggal());
            theModel.setName(theView.getEditName());
            theModel.setStatus(theView.getEditStatus());
            try {
                theModel.edit();
                JOptionPane.showMessageDialog(theView, "Data berhasil diperbarui");
                theView.setTableModel(theModel.getTableModel());
                theView.disablePanel();
                theView.clearInput();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(theView, "Data gagal diubah");
                System.err.println(ex+" Error update query");
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

    private class EditListener implements ActionListener {

        public EditListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            theModel.setSelectedRow(theView.getSelectedRow());
            theView.setEditTanggal(theModel.getTanggal());
            theView.setEditName(theModel.getName());
            theView.setEditStatus(theModel.getStatus());
        }
    }

}
