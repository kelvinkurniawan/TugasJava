/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.HomeController;
import java.util.Scanner;

/**
 *
 * @author kelvi
 */
public class Homepage {
        
    int option = 0;
    
    public void display(){      
        
        Scanner scan = new Scanner(System.in);  
        
        this.menu();
        
        option = scan.nextInt();
        System.out.println("=====================================");
    
        new HomeController().setMenu(option);
        
    };
    
    public void menu(){
        
        System.out.println("Please select menu to use these application :");
        
        System.out.println("1. Manage Employee");
        System.out.println("2. Manage Departments");
        System.out.println("3. Manage Jobs");
        System.out.println("4. Manage Regions");
        System.out.println("5. Manage Countries");
        System.out.println("6. Manage Locations");
        System.out.println("0. Exit");
        
        System.out.print("your choices : ");
    }
}
