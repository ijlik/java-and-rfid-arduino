package model;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import libs.Koneksi;

public abstract class SystemFeatures {
    protected Koneksi conn;
    protected DefaultTableModel tableModels;
    
    public SystemFeatures() throws SQLException{
        this.conn = new Koneksi();
    }
    
    public abstract DefaultTableModel getTableModel() throws SQLException;
    public abstract void save() throws SQLException;
    public abstract void edit() throws SQLException;
    public abstract void delete() throws SQLException;
}
