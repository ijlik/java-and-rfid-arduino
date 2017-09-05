package model;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public interface SystemBehavior {
    
    public DefaultTableModel getTableModel() throws SQLException;

    public void save() throws SQLException;
    
    public void edit() throws SQLException;
    
    public void delete() throws SQLException;

}
