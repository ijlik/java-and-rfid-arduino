package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import libs.Koneksi;

public class Device {

    private String cardId;
    private String name;
    private String numId;
    private String jabatan;
    private String jamAbsen;
    private String tanggalAbsen;
    private String status;
    private Koneksi conn;

    public Device() throws SQLException {
        this.conn = new Koneksi();
    }

    //==============================================================
    public void setCardId(String s) {
        this.cardId = s;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void setNumId(String s) {
        this.numId = s;
    }

    public void setJabatan(String s) {
        this.jabatan = s;
    }

    public void setJamAbsen(String s) {
        this.jamAbsen = s;
    }

    public void setTanggalAbsen(String s) {
        this.tanggalAbsen = s;
    }

    public void setStatus(String s) throws SQLException, SQLException, SQLException {
        this.status = s;
    }

    //================================================================
    public void setData(String card, String tgl) throws SQLException {
        String sql = "select a.cardNum, p.name, p.numId, a.status, p.status as jabatan, a.date, a.time from absens a join penggunas p on a.cardNum = p.cardNum where a.cardNum = '" + card + "' and a.date = '" + tgl + "'";
        ResultSet rs = conn.getResult(sql);
        rs.next();
        this.cardId = rs.getString("cardNum");
        this.name = rs.getString("name");
        this.numId = rs.getString("numId");
        this.status = rs.getString("status");
        this.jabatan = rs.getString("jabatan");
        this.tanggalAbsen = rs.getString("date");
        this.jamAbsen = rs.getString("time");
    }

    public String getCardId() {
        return this.cardId;
    }

    public String getName() {
        return (this.name == null) ? "default" : this.name;
    }

    public String getNumId() {
        return (this.numId == null) ? "-" : this.numId;
    }

    public String getJabatan() {
        return (this.jabatan == null) ? "-" : this.jabatan;
    }

    public String getJamAbsen() {
        return (this.jamAbsen == null) ? "-" : this.jamAbsen;
    }

    public String getTanggalAbsen() {
        return (this.tanggalAbsen == null) ? "-" : this.tanggalAbsen;
    }

    public String getStatus() {
        return (this.status == null) ? "-" : this.status;
    }
    //================================================================

    public boolean cekAbsen(String card, String tanggal) throws SQLException {
        String sql = "select * from absens where cardNum = '" + card + "' and date = '" + tanggal + "'";
        ResultSet rs = conn.getResult(sql);
        return rs.last();
    }

    public void isiData(String card, String tanggal, String jam) throws SQLException {
        String sql = "select * from penggunas where cardNum = '" + card + "'";
        ResultSet rs = conn.getResult(sql);
        rs.next();
        this.cardId = card;
        this.name = rs.getString("name");
        this.numId = rs.getString("numId");
        this.jabatan = rs.getString("status");
        this.tanggalAbsen = tanggal;
        this.jamAbsen = jam;
        isiStatus(tanggal, jam);
        Save();
        setData(card, tanggal);
    }

    public void Save() throws SQLException {
        String sql = "insert into absens values (null , '" + tanggalAbsen + "', '" + jamAbsen + "', '" + cardId + "', '" + status + "', NOW(), NOW())";
        conn.execute(sql);
    }

    public boolean cekPengguna(String s) throws SQLException {
        String sql = "select * from penggunas where cardNum = '" + s + "'";
        ResultSet rs = conn.getResult(sql);
        return rs.last();
    }
    
    public boolean cekJadwal(String s) throws SQLException{
        String sql = "select * from jadwals where tanggal = '"+s+"'";
        ResultSet rs = conn.getResult(sql);
        return !rs.last();
    }

    public void isiStatus(String tanggal, String jam) throws SQLException {
        String query = "select jam from jadwals where tanggal = '" + tanggal + "'";
        ResultSet stat = conn.getResult(query);
        stat.next();
        String today[] = stat.getString("jam").split(":");
        String skr[] = jam.split(":");
        if (Integer.parseInt(skr[0]) == Integer.parseInt(today[0])) {
            if (Integer.parseInt(skr[1]) == Integer.parseInt(today[1])) {
                if (Integer.parseInt(skr[2]) == Integer.parseInt(today[2])) {
                    this.status = "Masuk";
                } else if (Integer.parseInt(skr[2]) < Integer.parseInt(today[2])) {
                    this.status = "Masuk";
                } else {
                    this.status = "Telat";
                }
            } else if (Integer.parseInt(skr[1]) < Integer.parseInt(today[1])) {
                this.status = "Masuk";
            } else {
                this.status = "Telat";
            }
        } else if (Integer.parseInt(skr[0]) < Integer.parseInt(today[0])) {
            this.status = "Masuk";
        } else {
            this.status = "Telat";
        }
    }

    public String getJadwal(String Tanggal) throws SQLException {
        String sql = "select jam from jadwals where tanggal = '"+Tanggal+"'";
        ResultSet rs = conn.getResult(sql);
        rs.next();
        return rs.getString("jam");
    }
}
