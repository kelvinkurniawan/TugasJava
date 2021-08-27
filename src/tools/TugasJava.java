/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.RegionDAO;
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

        DBConnection dBConnection = new DBConnection();
        System.out.println(dBConnection.getConnection()+"test");

        RegionDAO rdao = new RegionDAO(dBConnection.getConnection());

        System.out.print(rdao.getById(11103));

    }
    
}
