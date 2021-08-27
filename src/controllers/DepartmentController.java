/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Department;

import java.util.List;

/**
 *
 * @author kelvi
 */
public class DepartmentController extends BaseController<Department, Integer>{

    @Override
    public List<Department> getAll() {
        return null;
    }

    @Override
    public Department getById(Integer id) {
        return null;
    }

    @Override
    public boolean save(Department object) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void display() {

    }

    @Override
    public void form(int type) {

    }

    @Override
    public void showSingle() {

    }

    @Override
    public void showAll() {

    }
}
