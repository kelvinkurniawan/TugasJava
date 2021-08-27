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
public class RegionView implements BaseView{
    int regionId;

    @Override
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
                new RegionController().form(1);
                break;
            case 2:
                new RegionController().showSingle();
                break;
            case 3:
                new RegionController().showAll();
                break;
            case 0:
                new HomeController().start();
                        
        }
    }

    @Override
    public void form(int type){
        
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
        
        String result = new RegionController().save(region) ? "Succesfully" : "Failed";
        System.out.println(result);
        
        System.out.println("================================");
        
        this.display();
    }

    @Override
    public void show(){
        
        System.out.print("Enter Region ID : ");
        regionId = scanner.nextInt();
        System.out.println();
        System.out.println("Searching..");
        System.out.println();
        
        Region region = new RegionController().getById(regionId);
        
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
                    this.form(2);
                    break;
                case 2:
                    new RegionController().delete(region.getId());
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

    @Override
    public void showAll(){
        for (Region region : new RegionController().getAll()) {
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
