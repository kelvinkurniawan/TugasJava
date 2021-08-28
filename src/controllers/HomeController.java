/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import views.Homepage;

/**
 * @author kelvi
 */
public class HomeController {

    /**
     * <p>Starting the application view</p>
     */
    public void start() {

        Homepage homepage = new Homepage();
        homepage.display();

    }

    /**
     * Set the display option when menu selected
     *
     * @param option is selected menu
     */
    public void setMenu(int option) {
        switch (option) {
            case 1:
                new EmployeeController().display();
                break;
            case 2:
                new DepartmentController().display();
                break;
            case 3:
                new JobController().display();
                break;
            case 4:
                new RegionController().display();
                break;
            case 5:
                new CountryController().display();
                break;
            case 6:
                new LocationController().display();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Your choice cannot be found!");
                new HomeController().start();
                break;
        }
    }
}
