package model;

import java.sql.SQLException;
import libs.Koneksi;

public abstract class User {
    protected String username;
    protected String password;
    protected Koneksi conn;
    
    public User() throws SQLException{
        this.conn = new Koneksi();
    }
    
    public abstract boolean cekLogin() throws SQLException;
    public abstract boolean cekLevel() throws SQLException;
}
