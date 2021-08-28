/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDao;
import models.Employee;
import views.EmployeeView;

import java.util.List;

/**
 * @author kelvi
 */
public class EmployeeController extends BaseController<Employee, Integer> {

    EmployeeDao employeeDao;
    EmployeeView employeeView;

    public EmployeeController() {
        this.employeeDao = new EmployeeDao(dbc.getConnection());
        this.employeeView = new EmployeeView();
    }

    @Override
    public boolean save(Employee e) {
        return employeeDao.save(e);
    }

    @Override
    public Employee getById(Integer id) {
        return employeeDao.getById(id);
    }

    @Override
    public boolean delete(Integer id) {
        return employeeDao.delete(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public void display() {
        employeeView.display();
    }

    @Override
    public void showAll() {
        employeeView.showAll();
    }

    @Override
    public void form(int type) {
        employeeView.form(type);
    }

    @Override
    public void showSingle() {
        employeeView.show();
    }
}
