/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDao;
import models.Region;
import views.RegionView;

import java.util.List;

/**
 * @author kelvi
 */
public class RegionController extends BaseController<Region, Integer> {
    RegionDao regionDao;
    RegionView regionView;

    public RegionController() {
        this.regionDao = new RegionDao(dbc.getConnection());
        this.regionView = new RegionView();
    }

    @Override
    public boolean save(Region r) {
        return regionDao.save(r);
    }

    @Override
    public Region getById(Integer id) {
        return regionDao.getById(id);
    }

    @Override
    public boolean delete(Integer id) {
        return regionDao.delete(id);
    }

    @Override
    public List<Region> getAll() {
        return regionDao.getAll();
    }

    @Override
    public void display() {
        regionView.display();
    }

    @Override
    public void form(int type) {
        regionView.form(type);
    }

    @Override
    public void showSingle() {
        regionView.show();
    }

    @Override
    public void showAll() {
        regionView.showAll();
    }
}
