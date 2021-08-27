/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.EmployeeDao;
import daos.JobDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import models.Employee;

/**
 *
 * @author kelvi
 */
public class TugasJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here

        
        DBConnection dbc = new DBConnection();
        
        JobDao jd = new JobDao(dbc.getConnection());
        
        System.out.println(jd.getById("AC_ACCOUNT"));

    }
    
}
