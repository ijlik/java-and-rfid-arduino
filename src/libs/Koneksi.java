package libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Koneksi {

    private Connection conn;
    private Statement stm;

    public Koneksi() throws SQLException {
        String url = "jdbc:mysql://47.88.156.168:3306/estafed_db";
        String user ="root";
        String Password= "bismillah";
        try {
            conn = DriverManager.getConnection(url, user, Password);
            stm = conn.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void execute(String sql) throws SQLException{
        stm.executeUpdate(sql);
    }
    public ResultSet getResult(String sql) throws SQLException{
        ResultSet rs = stm.executeQuery(sql);
        return rs;
    }
}
