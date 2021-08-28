/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.EmployeeController;
import controllers.HomeController;
import models.Employee;

import java.sql.Date;

/**
 * @author kelvi
 */
public class EmployeeView implements BaseView {

    int empId;

    @Override
    public void display() {
        int option;
        System.out.println("Showing menu under Employee");
        System.out.println("1. Add employee");
        System.out.println("2. Show employee by ID");
        System.out.println("3. Show all employee");
        System.out.println("0. Back");

        System.out.print("your choice : ");
        option = scanner.nextInt();

        System.out.println("=================================");

        switch (option) {
            case 1:
                new EmployeeController().form(1);
                break;
            case 2:
                new EmployeeController().showSingle();
                break;
            case 3:
                new EmployeeController().showAll();
                break;
            case 0:
                new HomeController().start();

        }
    }

    @Override
    public void form(int type) {

        Employee employee = new Employee();


        System.out.println("=============================");

        if (type == 1) {
            System.out.print("Employee ID : ");
            employee.setId(scanner.nextInt());
        } else {
            System.out.println("Employee ID : " + empId);
            employee.setId(empId);
        }

        scanner.nextLine();
        System.out.print("First Name : ");
        employee.setFirstName(scanner.nextLine());
        System.out.print("Last Name : ");
        employee.setLastName(scanner.nextLine());
        System.out.print("Email : ");
        employee.setEmail(scanner.next());
        System.out.print("Phone : ");
        employee.setPhone(scanner.next());
        System.out.print("Hire Date : ");
        employee.setHireDate(Date.valueOf(scanner.next()));
        System.out.print("Job : ");
        employee.setJob(scanner.next());
        System.out.print("Salary : ");
        employee.setSalary(scanner.nextDouble());
        System.out.print("Commission pct : ");
        employee.setCommissionPct(scanner.nextDouble());
        System.out.print("Manager : ");
        employee.setManager(scanner.nextInt());
        System.out.print("Department : ");
        employee.setDepartment(scanner.nextInt());

        System.out.println("================================");

        String result = new EmployeeController().save(employee) ? "Successfully!" : "Failed!";

        System.out.println(result);

        System.out.println("================================");

        new EmployeeController().display();
    }

    @Override
    public void show() {
        System.out.print("Enter employee ID : ");
        empId = scanner.nextInt();
        System.out.println();
        System.out.println("Searching..");
        System.out.println();

        Employee employee = new EmployeeController().getById(empId);

        System.out.println("==================================");
        if (employee != null) {
            System.out.println("Employee ID : " + employee.getId());
            System.out.println("First Name : " + employee.getFirstName());
            System.out.println("Last Name : " + employee.getLastName());
            System.out.println("Email : " + employee.getEmail());
            System.out.println("Phone : " + employee.getPhone());
            System.out.println("Hire Date : " + employee.getHireDate());
            System.out.println("Job : " + employee.getJob());
            System.out.println("Salary : " + employee.getSalary());
            System.out.println("Commission pct : " + employee.getCommissionPct());
            System.out.println("Manager : " + employee.getManager());
            System.out.println("Department : " + employee.getDepartment());
            System.out.println("=================================");
            System.out.println("1. Update Employee");
            System.out.println("2. Delete Employee");
            System.out.println("0. Back");
            System.out.print("your choice : ");
            int option = scanner.nextInt();

            System.out.println("=================================");
            switch (option) {
                case 1:
                    form(2);
                    break;
                case 2:
                    new EmployeeController().delete(employee.getId());
                    System.out.println("Employee Deleted!");
                    System.out.println("====================================");
                    this.display();
                    break;
                case 0:
                    this.display();
                    break;
                default:
                    System.out.println("Your choice cannot be found");
                    this.display();
                    break;
            }
        } else {
            System.out.println("Sorry employee with id " + empId + " not found!");
        }
    }

    @Override
    public void showAll() {
        for (Employee employee : new EmployeeController().getAll()) {
            System.out.println("Employee ID : " + employee.getId());
            System.out.println("First Name : " + employee.getFirstName());
            System.out.println("Last Name : " + employee.getLastName());
            System.out.println("Email : " + employee.getEmail());
            System.out.println("Phone : " + employee.getPhone());
            System.out.println("Hire Date : " + employee.getHireDate());
            System.out.println("Job : " + employee.getJob());
            System.out.println("Salary : " + employee.getSalary());
            System.out.println("Commission pct : " + employee.getCommissionPct());
            System.out.println("Manager : " + employee.getManager());
            System.out.println("Department : " + employee.getDepartment());
            System.out.println("=================================");
        }
        System.out.println("0. Back");
        System.out.print("your choice : ");
        if (scanner.nextInt() == 0) {
            this.display();
        }
    }
}
