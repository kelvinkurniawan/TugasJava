/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDao;
import java.util.List;
import models.Region;

/**
 *
 * @author kelvi
 */
public class RegionController extends BaseController{
    RegionDao regionDao;
    
    public RegionController(){
        this.regionDao = new RegionDao(dbc.getConnection());
    }
    
    public boolean save(Region r){
        return regionDao.save(r);
    }
    
    public Region getById(int id){
        return regionDao.getById(id);
    }
    
    public boolean delete(int id){
        return regionDao.delete(id);
    }
    
    public List<Region> getAll(){
        return regionDao.getAll();
    }
}
