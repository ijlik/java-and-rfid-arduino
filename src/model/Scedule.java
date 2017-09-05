package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Scedule extends SystemFeatures {

    private String idJadwal;
    private String hari;
    private String tanggal;
    private String jam;

    public Scedule() throws SQLException {
        super();
        String header[] = {"Hari", "Tanggal", "Jam"};
        tableModels = new DefaultTableModel(null, header);
    }

    public void setIdJadwal(String s) {
        idJadwal = s;
    }

    public void setHari(String s) {
        hari = s;
    }

    public void setTanggal(String s) {
        tanggal = s;
    }

    public void setJam(String s) {
        jam = s;
    }

    public String getIdJadwal() {
        return idJadwal;
    }

    public String getHari() {
        return hari;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setSelectedRow(int baris) {
        this.hari = tableModels.getValueAt(baris, 0).toString();
        this.tanggal = tableModels.getValueAt(baris, 1).toString();
        this.jam = tableModels.getValueAt(baris, 2).toString();
    }

    @Override
    public DefaultTableModel getTableModel() throws SQLException {
        for (int i = tableModels.getRowCount() - 1; i >= 0; i--) {
            tableModels.removeRow(i);
        }
        String sql = "select * from jadwals order by tanggal";
        ResultSet rs = conn.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[3];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 2);
            }
            tableModels.addRow(kolom);
        }
        return tableModels;
    }

    // @Overloading
    public void save(String[] a) throws SQLException {
        for (String i : a) {
            if (!cekJadwal(i)) {
                String sql = "insert into jadwals values (null , '" + hari + "', '" + i + "', '" + jam + "', NOW(), NOW())";
                conn.execute(sql);
            }
        }
    }

    @Override
    public void save() throws SQLException {
        String sql = "insert into jadwals values (null , '" + hari + "', '" + tanggal + "', '" + jam + "', NOW(), NOW())";
        conn.execute(sql);
    }

    @Override
    public void edit() throws SQLException {
        String sql = "update jadwals set jam = '" + jam + "' where tanggal = '" + tanggal + "'";
        conn.execute(sql);
    }

    @Override
    public void delete() throws SQLException {
        String sql = "delete from jadwals where tanggal = '" + tanggal + "'";
        conn.execute(sql);
    }

    public boolean cekJadwal(String tgl) throws SQLException {
        String sql = "select * from jadwals where tanggal = '" + tgl + "'";
        ResultSet rs = conn.getResult(sql);
        return rs.last();
    }
}
