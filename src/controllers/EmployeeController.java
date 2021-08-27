/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDao;
import java.util.List;
import models.Employee;
import views.EmployeeView;

/**
 *
 * @author kelvi
 */
public class EmployeeController extends BaseController<Employee, Integer>{
    
    EmployeeDao employeeDao;
    EmployeeView employeeView;
    
    public EmployeeController(){
        this.employeeDao = new EmployeeDao(dbc.getConnection());
        this.employeeView = new EmployeeView();
    }

    public boolean save(Employee e){
        return employeeDao.save(e);
    }
    
    public Employee getById(Integer id){
        return employeeDao.getById(id);
    }
    
    public boolean delete(Integer id){
        return employeeDao.delete(id);
    }
    
    public List<Employee> getAll(){
        return employeeDao.getAll();
    }

    @Override
    public void display() {
        employeeView.display();
    }

    @Override
    public void showAll() {
        employeeView.showAllEmployee();
    }

    @Override
    public void form(int type) {
        employeeView.formEmployee(type);
    }

    @Override
    public void showSingle() {
        employeeView.showEmployee();
    }
}
