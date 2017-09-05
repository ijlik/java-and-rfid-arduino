package main;

import controller.ReportController;
import view.V_Login;
import controller.UserController;
import controller.SceduleController;
import controller.DeviceController;
import java.sql.SQLException;
import model.Report;
import model.Scedule;
import model.UserMember;
import model.Device;
import model.UserAdmin;
import view.V_Report;
import view.V_Scedule;
import view.V_Member;
import view.V_Device;

public class Main {
    public static void main(String[] args) throws SQLException {
        new main.Main().Standby();
    }
    
    public void Login() throws SQLException{
        UserAdmin admin = new UserAdmin();
        UserMember member = new UserMember();
        V_Login view = new V_Login();
        UserController TheController = new UserController(view, admin, member);
    }
    
    public void Pengguna() throws SQLException{
        model.UserMember model = new UserMember();
        view.V_Member view = new V_Member();
        controller.UserController TheController = new UserController(view, model);
    }
    
    public void Standby() throws SQLException {
        model.Device model = new Device();
        view.V_Device view = new V_Device();
        controller.DeviceController TheController = new DeviceController(view, model);
    }
    
    public void Absensi() throws SQLException{
        model.Report model = new Report();
        view.V_Report view = new V_Report();
        controller.ReportController TheController = new ReportController(view, model);
    }

    public void Pengaturan() throws SQLException{  
        model.Scedule model = new Scedule();
        view.V_Scedule view = new V_Scedule();
        controller.SceduleController TheController = new SceduleController(view, model);
    }
}