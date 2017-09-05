package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Report extends SystemFeatures {

    private String tanggal;
    private String name;
    private String numId;
    private String jabatan;
    private String status;

    public Report() throws SQLException {
        super();
        String header[] = {"Tanggal", "Name", "Number ID", "Jabatan", "Status"};
        tableModels = new DefaultTableModel(null, header);
    }

    public void setTanggal(String s) {
        this.tanggal = s;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void setNumId(String s) {
        this.numId = s;
    }

    public void setJabatan(String s){
        this.jabatan = s;
    }
    
    public void setStatus(String s) {
        this.status = s;
    }

    public String getTanggal() {
        return this.tanggal;
    }

    public String getName() {
        return this.name;
    }

    public String getNumId() {
        return this.numId;
    }

    public String getJabatan(){
        return this.jabatan;
    }
    
    public String getStatus() {
        return this.status;
    }

    public void setSelectedRow(int baris) {
        this.tanggal = tableModels.getValueAt(baris, 0).toString();
        this.name = tableModels.getValueAt(baris, 1).toString();
        this.numId = tableModels.getValueAt(baris, 2).toString();
        this.jabatan = tableModels.getValueAt(baris, 3).toString();
        this.status = tableModels.getValueAt(baris, 4).toString();
    }

    @Override
    public DefaultTableModel getTableModel() throws SQLException {
        for (int i = tableModels.getRowCount() - 1; i >= 0; i--) {
            tableModels.removeRow(i);
        }
        String sql = "select a.date, p.name, p.numId, p.status as jabatan, a.status from absens a join penggunas p on a.cardNum = p.cardNum";
        ResultSet rs = conn.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[5];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModels.addRow(kolom);
        }
        return tableModels;
    }

    @Override
    public void edit() throws SQLException {
        String sql = "update absens set status = '" +status+ "' where date = '" + tanggal +"' and cardNum = (select cardNum from penggunas where name = '"+name+"')";
        conn.execute(sql);
    }

    @Override
    public void save() throws SQLException {
        // nothing
    }

    @Override
    public void delete() throws SQLException {
        // nothing
    }

}
