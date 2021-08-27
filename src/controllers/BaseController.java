/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import tools.DBConnection;

/**
 *
 * @author kelvi
 */
public class BaseController {
    DBConnection dbc;
    
    public BaseController(){
        this.dbc = new DBConnection();
    }
    
}
