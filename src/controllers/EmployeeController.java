/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDao;
import java.util.List;
import models.Employee;

/**
 *
 * @author kelvi
 */
public class EmployeeController extends BaseController{
    
    EmployeeDao employeeDao;
    
    public EmployeeController(){
        this.employeeDao = new EmployeeDao(dbc.getConnection());
    }
    
    public boolean save(Employee e){
        return employeeDao.save(e);
    }
    
    public Employee getById(int id){
        return employeeDao.getById(id);
    }
    
    public boolean delete(int id){
        return employeeDao.delete(id);
    }
    
    public List<Employee> getAll(){
        return employeeDao.getAll();
    }
}
