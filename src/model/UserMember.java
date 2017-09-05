package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class UserMember extends User implements SystemBehavior{

    private String cardNum;
    private String name;
    private String numId;
    private String status;
    private DefaultTableModel tableModels;

    public UserMember() throws SQLException {
        super();
        String header[] = {"Card Number", "Name", "Number ID", "Status"};
        tableModels = new DefaultTableModel(null, header);
    }

    public void setUsername(String s) {
        this.username = s;
    }

    public void setPassword(String s) {
        this.password = s;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setCardNum(String s) {
        this.cardNum = s;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void setNumId(String s) {
        this.numId = s;
    }

    public void setStatus(String s) {
        this.status = s;
    }

    public String getCardNum() {
        return this.cardNum;
    }

    public String getName() {
        return this.name;
    }

    public String getNumId() {
        return this.numId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setSelectedRow(int baris) {
        this.cardNum = tableModels.getValueAt(baris, 0).toString();
        this.name = tableModels.getValueAt(baris, 1).toString();
        this.numId = tableModels.getValueAt(baris, 2).toString();
        this.status = tableModels.getValueAt(baris, 3).toString();
    }

    @Override
    public DefaultTableModel getTableModel() throws SQLException {
        for (int i = tableModels.getRowCount() - 1; i >= 0; i--) {
            tableModels.removeRow(i);
        }
        String sql = "select * from penggunas order by name";
        ResultSet rs = conn.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[4];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 2);
            }
            tableModels.addRow(kolom);
        }
        return tableModels;
    }

    @Override
    public void save() throws SQLException {
        String sql = "insert into penggunas values (null , '" + cardNum + "', '" + name + "', '" + numId + "', 'Mahasiswa', NOW(), NOW())";
        String sql1 = "insert into logins values (null , '" + numId + "', md5('" + cardNum + "'), 'Mahasiswa', NOW(), NOW())";
        conn.execute(sql);
        conn.execute(sql1);
    }

    @Override
    public void edit() throws SQLException {
        String sql = "update penggunas set name = '" + name + "', numId = '" + numId + "', status = '" +status+ "' where cardNum = '" + cardNum +"'";
        conn.execute(sql);
    }

    @Override
    public void delete() throws SQLException {
        String sql = "delete from logins where username = (select numId from penggunas where cardNum = '"+cardNum+"')";
        String sql1 = "delete from penggunas where cardNum = '" + cardNum + "'";
        String sql2 = "delete from absens where cardNum = '" + cardNum + "'";
        conn.execute(sql);
        conn.execute(sql1);
        conn.execute(sql2);
    }

    @Override
    public boolean cekLogin() throws SQLException{
        String sql = "select * from logins where username = '" + username +"' and password = md5('" + password + "')";
        ResultSet rs = conn.getResult(sql);
        return rs.last();
    }

    @Override
    public boolean cekLevel() throws SQLException {
        String sql = "select level from logins where username = '" + username +"' and password = md5('" + password + "')";
        ResultSet rs = conn.getResult(sql);
        rs.next();
        return rs.getString("level").equals("Mahasiswa");
    }
}
