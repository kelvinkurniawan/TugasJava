package controllers;


import daos.LocationDao;
import models.Location;
import views.LocationView;


import java.util.List;

public class LocationController extends BaseController<Location, Integer>{

    LocationDao locationDao;
    LocationView locationView;

    public LocationController() {
        locationDao = new LocationDao(dbc.getConnection());
        locationView = new LocationView();
    }

    @Override
    public List<Location> getAll() {
        return locationDao.getAll();
    }

    @Override
    public Location getById(Integer id) {
        return locationDao.getById(id);
    }

    @Override
    public boolean save(Location location) {
        return locationDao.save(location);
    }

    @Override
    public boolean delete(Integer id) {
        return locationDao.delete(id);
    }

    @Override
    public void display() {
        locationView.display();
    }

    @Override
    public void form(int type) {
        locationView.form(type);
    }

    @Override
    public void showSingle() {
        locationView.show();
    }

    @Override
    public void showAll() {
        locationView.showAll();
    }
}
