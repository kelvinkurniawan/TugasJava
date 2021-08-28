/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JobDao;
import models.Job;
import views.JobView;

import java.util.List;

/**
 * @author kelvi
 */
public class JobController extends BaseController<Job, String> {

    JobDao jobDao;
    JobView jobView;

    public JobController() {
        jobDao = new JobDao(dbc.getConnection());
        jobView = new JobView();
    }

    @Override
    public List<Job> getAll() {
        return jobDao.getAll();
    }

    @Override
    public Job getById(String id) {
        return jobDao.getById(id);
    }

    @Override
    public boolean save(Job job) {
        return jobDao.save(job);
    }

    @Override
    public boolean delete(String id) {
        return jobDao.delete(id);
    }

    @Override
    public void display() {
        jobView.display();
    }

    @Override
    public void form(int type) {
        jobView.form(type);
    }

    @Override
    public void showSingle() {
        jobView.show();
    }

    @Override
    public void showAll() {
        jobView.showAll();
    }
}
