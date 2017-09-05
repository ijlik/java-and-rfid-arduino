package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAdmin extends User {

    public UserAdmin() throws SQLException {
        super();
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
    
    @Override
    public boolean cekLogin() throws SQLException {
        String sql = "select * from logins where username = '" + username +"' and password = md5('" + password + "')";
        ResultSet rs = conn.getResult(sql);
        return rs.last();
    }

    @Override
    public boolean cekLevel() throws SQLException {
        String sql = "select level from logins where username = '" + username +"' and password = md5('" + password + "')";
        ResultSet rs = conn.getResult(sql);
        rs.next();
        return rs.getString("level").equals("Administrator");
    }
    
}
