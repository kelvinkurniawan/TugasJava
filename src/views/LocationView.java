package views;



import controllers.HomeController;
import controllers.LocationController;
import models.Location;

/**
 * @author fajar
 */
public class LocationView implements BaseView {

    int locationId;


    /**
     * <p>This method used to show main location menu</p>
     */
    @Override
    public void display() {
        int option;
        System.out.println("Showing menu under Location");
        System.out.println("1. Add location");
        System.out.println("2. Show location by ID");
        System.out.println("3. Show all location");
        System.out.println("0. Back");

        System.out.print("your choice : ");
        option = scanner.nextInt();

        System.out.println("=================================");

        switch (option) {
            case 1:
                new LocationController().form(option);
                break;
            case 2:
                new LocationController().showSingle();
                break;
            case 3:
                new LocationController().showAll();
                break;
            case 0:
                new HomeController().start();
            default:
                System.out.println("your choice cannot be found");
                this.display();
                System.out.println("=================================");
        }
    }

    /**
     * <p>This method used to show form INSERT or UPDATE the country</p>
     */
    @Override
    public void form(int type) {
        Location location = new Location();

        System.out.println("=============================");

        if (type == 1) {
            System.out.print("Location ID : ");
            location.setId(scanner.nextInt());
        }else if(type == 2) {
            System.out.println("UPDATE COUNTRY");
            System.out.println("=============================");
            System.out.println("Location ID : " + locationId);
            location.setId(locationId);
        }
        scanner.nextLine();
        System.out.print("Street Address : ");
        location.setStreet_address(scanner.nextLine());
        System.out.print("Postal Code : ");
        location.setPostal_code(scanner.nextLine());
        System.out.print("City : ");
        location.setCity(scanner.nextLine());
        System.out.print("State Province : ");
        location.setState_province(scanner.nextLine());
        System.out.print("Country ID : ");
        location.setCountry_id(scanner.nextLine());

        System.out.println("================================");
        String result = new LocationController().save(location) ? "Successfully!" : "Failed!";

        System.out.println(result);
        System.out.println("================================");

        new LocationController().display();
    }

    /**
     * <p>This method used to show specific data by input location ID </p>
     */
    @Override
    public void show() {
        System.out.print("Enter Location ID : ");
        locationId = scanner.nextInt();
        System.out.println();
        System.out.println("Searching..");
        System.out.println();

        Location location = new LocationController().getById(locationId);

        if (location != null) {
            System.out.println("Location ID : " + location.getId());
            System.out.println("Street Address : " + location.getStreet_address());
            System.out.println("Postal Code : " + location.getPostal_code());
            System.out.println("City : " + location.getCity());
            System.out.println("State Province : " + location.getState_province());
            System.out.println("Country ID : " + location.getCountry_id());

            System.out.println("=================================");
            System.out.println("1. Update Location");
            System.out.println("2. Delete Location");
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
                    new LocationController().delete(location.getId());
                    System.out.println("Location Deleted!");
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
            System.out.println("Sorry Country with id " + locationId + " not found!");
        }
    }


    /**
     * <p>This method used to show all data location</p>
     */
    @Override
    public void showAll() {
        for (Location location : new LocationController().getAll()) {
            System.out.println("Location ID : " + location.getId());
            System.out.println("Street Address : " + location.getStreet_address());
            System.out.println("Postal Code : " + location.getPostal_code());
            System.out.println("City : " + location.getCity());
            System.out.println("State Province : " + location.getState_province());
            System.out.println("Country ID : " + location.getCountry_id());
            System.out.println("=================================");
        }
        System.out.println("0. Back");
        System.out.print("your choice : ");
        if (scanner.nextInt() == 0) {
            this.display();
        }
    }
}
