/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Scanner;
import views.EmployeeView;
import views.Homepage;
import views.RegionView;

/**
 *
 * @author kelvi
 */
public class HomeController {
    
    public void start(){
        
        Homepage homepage = new Homepage();
        homepage.display();
        
    }
    
    public void setMenu(int option){
        switch(option){
            case 1:
                new EmployeeController().display();
                break;
            case 3:
                new JobController().display();
                break;
            case 4:
                new RegionController().display();
                break;
        }
    }
}
