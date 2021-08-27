/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.HomeController;
import controllers.RegionController;
import java.util.Scanner;
import models.Region;

/**
 *
 * @author kelvi
 */
public class RegionView {
    Scanner scanner = new Scanner(System.in);
    RegionController regionController;
    int regionId;
    
    public RegionView(){
        this.regionController = new RegionController();
    }
    
    public void display(){
        int option = 0;
        System.out.println("Showing menu under Region");
        System.out.println("1. Add region");
        System.out.println("2. Show region by ID");
        System.out.println("3. Show all region");
        System.out.println("0. Back");
        
        System.out.print("your choice : ");
        option = scanner.nextInt();
        
        System.out.println("=================================");
        
        switch(option){
            case 1:
                formRegion(1);
                break;
            case 2:
                showRegion();
                break;
            case 3:
                showAllRegion();
                break;
            case 0:
                new HomeController().start();
                        
        }
    }
    
    public void formRegion(int type){
        
        Region region = new Region();
        System.out.println("=============================");
        
        if(type == 1){
            System.out.print("Region ID : ");
            region.setId(scanner.nextInt());
        }else{
            System.out.println("Region ID : " + regionId);
            region.setId(regionId);
        }
        scanner.nextLine();
        System.out.print("Region name : ");
        region.setName(scanner.nextLine());
        System.out.println("================================");
        
        String result = regionController.save(region) ? "Succesfully" : "Failed";
        System.out.println(result);
        
        System.out.println("================================");
        
        this.display();
    }
    
    public void showRegion(){
        
        System.out.print("Enter Region ID : ");
        regionId = scanner.nextInt();
        System.out.println();
        System.out.println("Searching..");
        System.out.println();
        
        Region region = regionController.getById(regionId);
        
        if(region != null){
            System.out.println("Region ID : " + region.getId());
            System.out.println("Region name : " + region.getName());
            System.out.println("=================================");
            System.out.println("1. Update Region");
            System.out.println("2. Delete Region");
            System.out.println("0. Back");
            System.out.print("your choice : ");
            int option = scanner.nextInt();
            
            System.out.println("=================================");
            switch(option){
                case 1:
                    formRegion(2);
                    break;
                case 2:
                    regionController.delete(region.getId());
                    System.out.println("Region Deleted!");
                    System.out.println("====================================");
                    this.display();
                    break;
                case 0:
                    this.display();
                    break;
                default:
                    this.display();
            }
        }else{
            System.out.println("Sorry Region with id " +region.getId()+ " not found!");
        }
    }
    
    public void showAllRegion(){
        for (Region region : regionController.getAll()) {
            System.out.println("Region ID : " + region.getId());
            System.out.println("Region name : " + region.getName());
            System.out.println("=================================");
        }
        System.out.println("0. Back");
        System.out.print("your choice : ");
        if(scanner.nextInt() == 0){
            this.display();
        }
    }
    
}
