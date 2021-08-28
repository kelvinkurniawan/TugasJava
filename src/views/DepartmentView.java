package views;

import controllers.DepartmentController;
import controllers.HomeController;
import models.Department;

public class DepartmentView implements BaseView {
    int departmentId;

    @Override
    public void display() {
        int option;
        System.out.println("Showing menu under Department");
        System.out.println("1. Add Department");
        System.out.println("2. Show department by ID");
        System.out.println("3. Show all department");
        System.out.println("0. Back");

        System.out.print("your choice : ");
        option = scanner.nextInt();

        System.out.println("=================================");

        switch (option) {
            case 1:
                new DepartmentController().form(1);
                break;
            case 2:
                new DepartmentController().showSingle();
                break;
            case 3:
                new DepartmentController().showAll();
                break;
            case 0:
                new HomeController().start();

        }
    }

    @Override
    public void form(int type) {
        Department department = new Department();
        System.out.println("=============================");

        if (type == 1) {
            System.out.print("Department ID : ");
            department.setId(scanner.nextInt());
        } else {
            System.out.println("Department ID : " + departmentId);
            department.setId(departmentId);
        }
        scanner.nextLine();
        System.out.print("Department name : ");
        department.setName(scanner.nextLine());
        System.out.print("Manager : ");
        department.setManager(scanner.nextInt());
        System.out.print("Location : ");
        department.setLocation(scanner.nextInt());
        System.out.println("================================");

        String result = new DepartmentController().save(department) ? "Successfully" : "Failed";
        System.out.println(result);

        System.out.println("================================");

        this.display();
    }

    @Override
    public void show() {
        System.out.print("Enter Department ID : ");
        departmentId = scanner.nextInt();
        System.out.println();
        System.out.println("Searching..");
        System.out.println();

        Department department = new DepartmentController().getById(departmentId);

        if (department != null) {
            System.out.println("Department ID : " + department.getId());
            System.out.println("Department name : " + department.getName());
            System.out.println("Manager : " + department.getManager());
            System.out.println("Location : " + department.getLocation());
            System.out.println("=================================");
            System.out.println("1. Update Department");
            System.out.println("2. Delete Department");
            System.out.println("0. Back");
            System.out.print("your choice : ");
            int option = scanner.nextInt();

            System.out.println("=================================");
            switch (option) {
                case 1:
                    this.form(2);
                    break;
                case 2:
                    new DepartmentController().delete(department.getId());
                    System.out.println("Department Deleted!");
                    System.out.println("====================================");
                    this.display();
                    break;
                case 0:
                    System.out.println("your choice is not found");
                    this.display();
                    break;
                default:
                    this.display();
            }
        } else {
            System.out.println("Sorry Department with id " + departmentId + " not found!");
        }
    }

    @Override
    public void showAll() {
        for (Department department : new DepartmentController().getAll()) {
            System.out.println("Department ID : " + department.getId());
            System.out.println("Department name : " + department.getName());
            System.out.println("Manager : " + department.getManager());
            System.out.println("Location : " + department.getLocation());
            System.out.println("=================================");
        }
        System.out.println("0. Back");
        System.out.print("your choice : ");
        if (scanner.nextInt() == 0) {
            this.display();
        }
    }
}
