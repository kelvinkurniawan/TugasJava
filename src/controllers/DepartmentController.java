/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentDao;
import models.Department;
import views.DepartmentView;

import java.util.List;

/**
 * @author kelvi
 */
public class DepartmentController extends BaseController<Department, Integer> {

    DepartmentDao departmentDao;
    DepartmentView departmentView;

    public DepartmentController() {
        departmentDao = new DepartmentDao(dbc.getConnection());
        departmentView = new DepartmentView();
    }

    @Override
    public List<Department> getAll() {
        return departmentDao.getAll();
    }

    @Override
    public Department getById(Integer id) {
        return departmentDao.getById(id);
    }

    @Override
    public boolean save(Department department) {
        return departmentDao.save(department);
    }

    @Override
    public boolean delete(Integer id) {
        return departmentDao.delete(id);
    }

    @Override
    public void display() {
        departmentView.display();
    }

    @Override
    public void form(int type) {
        departmentView.form(type);
    }

    @Override
    public void showSingle() {
        departmentView.show();
    }

    @Override
    public void showAll() {
        departmentView.showAll();
    }
}
