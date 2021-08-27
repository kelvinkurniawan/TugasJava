/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;



/**
 *
 * @author kelvi
 */
public class Employee {
    private int id, manager_id, department;
    private String firstName, lastName, email, phone, job;
    private Date hireDate;
    private double salary, commisionPct;

    public Employee(int id, String firstName, String lastName, String email, String phone, Date hireDate, String job_id, double salary, double commisionPct, int manager_id, int department_id) {
        this.id = id;
        this.manager_id = manager_id;
        this.department = department_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.job = job_id;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commisionPct = commisionPct;
    }
    
    public Employee(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManager() {
        return manager_id;
    }

    public void setManager(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department_id) {
        this.department = department_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job_id) {
        this.job = job_id;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCommisionPct() {
        return commisionPct;
    }

    public void setCommisionPct(double commisionPct) {
        this.commisionPct = commisionPct;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", manager_id=" + manager_id + ", department_id=" + department + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + ", job_id=" + job + ", hireDate=" + hireDate + ", salary=" + salary + ", commisionPct=" + commisionPct + '}';
    }
    
    
}
