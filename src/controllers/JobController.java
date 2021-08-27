/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Job;

import java.util.List;

/**
 *
 * @author kelvi
 */
public class JobController extends BaseController<Job, String>{

    @Override
    public List<Job> getAll() {
        return null;
    }

    @Override
    public Job getById(String id) {
        return null;
    }

    @Override
    public boolean save(Job object) {
        return false;
    }

    @Override
    public boolean delete(String id) {
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
