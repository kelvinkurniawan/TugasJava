package views;

import controllers.CountryController;
import controllers.HomeController;
import models.Country;


public class CountryView implements BaseView {

    String countryId;

    @Override
    public void display() {
        int option;
        System.out.println("Showing menu under Country");
        System.out.println("1. Add country");
        System.out.println("2. Show country by ID");
        System.out.println("3. Show all country");
        System.out.println("0. Back");

        System.out.print("your choice : ");
        option = scanner.nextInt();

        System.out.println("=================================");

        switch (option) {
            case 1:
                new CountryController().form(option);
                break;
            case 2:
                new CountryController().showSingle();
                break;
            case 3:
                new CountryController().showAll();
                break;
            case 0:
                new HomeController().start();
            default:
                System.out.println("your choice cannot be found");
                this.display();
                System.out.println("=================================");
        }
    }

    @Override
    public void form(int type) {
        Country country = new Country();

        System.out.println("=============================");

        if (type == 1) {
            System.out.print("Country ID : ");
            country.setId(scanner.next());
        }else if(type == 2) {
            System.out.println("UPDATE COUNTRY");
            System.out.println("=============================");
            System.out.println("Country ID : " + countryId);
            country.setId(countryId);
        }
        scanner.nextLine();
        System.out.print("Country Name : ");
        country.setCountry_name(scanner.nextLine());
        System.out.print("Region ID : ");
        country.setRegion_id(scanner.nextInt());

        System.out.println("================================");

        String result = new CountryController().save(country) ? "Successfully!" : "Failed!";

        System.out.println(result);

        System.out.println("================================");

        new CountryController().display();
    }

    @Override
    public void show() {
        System.out.print("Enter Country ID : ");
        countryId = scanner.next();
        System.out.println();
        System.out.println("Searching..");
        System.out.println();

        Country country = new CountryController().getById(countryId);

        if (country != null) {
            System.out.println("Country ID : " + country.getId());
            System.out.println("Country Name : " + country.getCountry_name());
            System.out.println("Region ID : " + country.getRegion_id());

            System.out.println("=================================");
            System.out.println("1. Update Country");
            System.out.println("2. Delete Country");
            System.out.println("0. Back");
            System.out.print("your choice : ");
            int option = scanner.nextInt();
            int update = 2;
            System.out.println("=================================");
            switch (option) {
                case 1:
                    this.form(update);
                    break;
                case 2:
                    new CountryController().delete(country.getId());
                    System.out.println("Country Deleted!");
                    System.out.println("====================================");
                    this.display();
                    break;
                case 0:
                    this.display();
                    break;
                default:
                    System.out.println("your choice cannot be found");
                    this.display();
            }
        } else {
            System.out.println("Sorry Country with id " + countryId + " not found!");
        }
    }

    @Override
    public void showAll() {
        for (Country country : new CountryController().getAll()) {
            System.out.println("Country ID : " + country.getId());
            System.out.println("Country Name : " + country.getCountry_name());
            System.out.println("Region ID : " + country.getRegion_id());
            System.out.println("=================================");
        }
        System.out.println("0. Back");
        System.out.print("your choice : ");
        if (scanner.nextInt() == 0) {
            this.display();
        }
    }
}
