package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class PersonalReport extends SystemFeatures{

    private String tanggal;
    private String hari;
    private String jamJadwal;
    private String jamAbsen;
    private String status;
    private String login;
    private String nama;
    private String jabatan;


    public PersonalReport() throws SQLException {
        super();
        String header[] = {"Hari", "Tanggal", "Jam Jadwal", "Jam Absen", "Status"};
        tableModels = new DefaultTableModel(null, header);
    }

    
    public void setTanggal(String s) {
        this.tanggal = s;
    }

    public void setHari(String s) {
        this.hari = s;
    }

    public void setJamJadwal(String s) {
        this.jamJadwal = s;
    }

    public void setJamAbsen(String s){
        this.jamAbsen = s;
    }
    
    public void setStatus(String s) {
        this.status = s;
    }

    public String getTanggal() {
        return this.tanggal;
    }

    public String getHari() {
        return this.hari;
    }

    public String getJamJadWal() {
        return this.jamJadwal;
    }

    public String getJamAbsen(){
        return this.jamAbsen;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setLogin(String s){
        login = s;
    }
    
    public String getNama() throws SQLException{
        String sql = "select name from penggunas where numId = '"+login+"'";
        ResultSet rs = conn.getResult(sql);
        rs.next();
        return rs.getString("name");
    }
    
    public String getNim(){
        return login;
    }
    
    public String getJabatan() throws SQLException{
        String sql = "select status from penggunas where numId = '"+login+"'";
        ResultSet rs = conn.getResult(sql);
        rs.next();
        return rs.getString("status");
    }
    
    @Override
    public DefaultTableModel getTableModel() throws SQLException {
        for (int i = tableModels.getRowCount() - 1; i >= 0; i--) {
            tableModels.removeRow(i);
        }
        String sql = "select j.day,a.date, j.jam as jamJadwal, a.time as jamAbsen, a.status from absens a join penggunas p on a.cardNum = p.cardNum join jadwal j on a.date = j.tanggal where p.numId = '"+login+"'";
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
    public void save() throws SQLException {
        
    }

    @Override
    public void edit() throws SQLException {
        
    }

    @Override
    public void delete() throws SQLException {
        
    }

}
