/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import model.PersonalReport;
import view.V_PersonalReport;

/**
 *
 * @author Ij Lik
 */
public class PersonalReportController {

    private final V_PersonalReport theView;
    private final PersonalReport theModel;

    public PersonalReportController(V_PersonalReport View, PersonalReport Model) throws SQLException {
        this.theView = View;
        this.theModel = Model;
        this.theView.setVisible(true);
        this.theView.setNama(theModel.getNama());
        this.theView.setNim(theModel.getNim());
        this.theView.setJabatan(theModel.getJabatan());
        this.theView.setTableModel(this.theModel.getTableModel());
    }

}
