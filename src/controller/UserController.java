package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.PersonalReport;
import model.UserAdmin;
import model.UserMember;
import view.V_Login;
import view.V_Member;
import view.V_PersonalReport;

/**
 *
 * @author Ij Lik
 */
public class UserController {

    private view.V_Login vLogin;
    private V_Member vMember;
    private model.UserAdmin mAdmin;
    private model.UserMember mMember;

    public UserController(V_Login view, UserAdmin admin, UserMember member) {
        vLogin = view;
        mAdmin = admin;
        mMember = member;
        vLogin.setVisible(true);
        vLogin.addLoginListener(new LoginListener());
    }

    public UserController(V_Member theView, UserMember theModel) throws SQLException {
        this.vMember = theView;
        this.mMember = theModel;
        this.vMember.setVisible(true);
        this.vMember.setTableModel(this.mMember.getTableModel());
        this.vMember.addTableListener(new TableListener());
        this.vMember.addSaveListener(new SaveListener());
        this.vMember.addEditListener(new EditListener());
        this.vMember.addDeleteListener(new DeleteListener());
        this.vMember.addUpdateListener(new UpdateListener());
    }

    private class UpdateListener implements ActionListener {

        public UpdateListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            mMember.setCardNum(vMember.getEditCardNum());
            mMember.setName(vMember.getEditName());
            mMember.setNumId(vMember.getEditNIM());

            try {
                if (vMember.getEditName().equals("") || vMember.getEditNIM().equals("")) {
                    JOptionPane.showMessageDialog(vMember, "Data tidak boleh kosong");
                } else {
                    mMember.edit();
                    JOptionPane.showMessageDialog(vMember, "Data berhasil diperbarui");
                    vMember.setTableModel(mMember.getTableModel());
                    vMember.disablePanel();
                    vMember.clearInput();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(vMember, "Data gagal diubah");
                System.err.println("Error update query");
            }
        }
    }

    private class DeleteListener implements ActionListener {

        public DeleteListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            mMember.setSelectedRow(vMember.getSelectedRow());
            try {
                mMember.delete();
                vMember.setTableModel(mMember.getTableModel());
            } catch (SQLException ex) {
                System.err.println("Error deleting query");
            }
        }
    }

    private class EditListener implements ActionListener {

        public EditListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            mMember.setSelectedRow(vMember.getSelectedRow());
            vMember.setEditCardNum(mMember.getCardNum());
            vMember.setEditName(mMember.getName());
            vMember.setEditNIM(mMember.getNumId());
        }
    }

    private class SaveListener implements ActionListener {

        public SaveListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            mMember.setCardNum(vMember.getAddCardNum());
            mMember.setName(vMember.getAddName());
            mMember.setNumId(vMember.getAddNIM());
            try {
                if (vMember.getAddCardNum().equals("") || vMember.getAddName().equals("") || vMember.getAddNIM().equals("")) {
                    JOptionPane.showMessageDialog(vMember, "Data tidak boleh kosong");
                } else {
                    mMember.save();
                    vMember.setTableModel(mMember.getTableModel());
                    vMember.disablePanel();
                    vMember.clearInput();
                }
            } catch (SQLException ex) {
                System.err.println("Error saving query");
                System.err.println(ex);
            }
        }
    }

    private class TableListener implements MouseListener {

        public TableListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            vMember.enableEditAndDelete();
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

    class LoginListener implements MouseListener {

        public LoginListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            String username = vLogin.getUsername();
            String password = vLogin.getPassword();
            boolean aman = true;
            if (username.isEmpty() || password.isEmpty()) {
                vLogin.setMessages("Username and Password can't be null");
                aman = false;
            }

            if (aman) {
                try {
                    mAdmin.setUsername(MysqlRealScapeString(username));
                    mAdmin.setPassword(MysqlRealScapeString(password));
                    mMember.setUsername(MysqlRealScapeString(username));
                    mMember.setPassword(MysqlRealScapeString(password));

                    if (mAdmin.cekLogin()) {
                        if (mMember.cekLevel()) {
                            model.PersonalReport m = new PersonalReport();
                            view.V_PersonalReport v = new V_PersonalReport();
                            m.setLogin(username);
                            controller.PersonalReportController c = new PersonalReportController(v, m);
                            vLogin.setVisible(false);
                        } else {
                            new main.Main().Pengguna();
                            vLogin.setVisible(false);
                        }
                    } else {
                        vLogin.setMessages("Username and Password doesn't match");
                    }
                    System.out.println(mAdmin.cekLogin());
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        private String MysqlRealScapeString(String str) {
            String data = null;
            if (str != null && str.length() > 0) {
                str = str.replace("\\", "\\\\");
                str = str.replace("'", "\\'");
                str = str.replace("\0", "\\0");
                str = str.replace("\n", "\\n");
                str = str.replace("\r", "\\r");
                str = str.replace("\"", "\\\"");
                str = str.replace("\\x1a", "\\Z");
                data = str;
            }
            return data;
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }
    }

}
