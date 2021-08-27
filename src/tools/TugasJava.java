/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.DepartmentDAO;
import daos.JobDAO;
import daos.RegionDAO;
import models.Department;
import models.Job;
import models.Region;

/**
 *
 * @author kelvi
 */
public class TugasJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        
        DBConnection dbc = new DBConnection();
        DepartmentDAO ddao = new DepartmentDAO(dbc.getConnection());
        
        String result = ddao.save(new Department(1, "Communication", 200, 1700)) ? "Success" : "Failed";
        
        System.out.println(result);

    }
    
}
