package controllers;


import daos.LocationDao;
import models.Location;
import views.LocationView;
import java.util.List;

/**
 * @author fajar
 */

public class LocationController extends BaseController<Location, Integer>{

    LocationDao locationDao;
    LocationView locationView;

    /**
     * Initialize Model & View Location
     */
    public LocationController() {
        locationDao = new LocationDao(dbc.getConnection());
        locationView = new LocationView();
    }


    /**
     * <p>This method used to get all data location</p>
     */
    @Override
    public List<Location> getAll() {
        return locationDao.getAll();
    }


    /**
     * <p>This method used to get data location by id</p>
     */
    @Override
    public Location getById(Integer id) {
        return locationDao.getById(id);
    }


    /**
     * <p>This method used to Insert or Update data location</p>
     */
    @Override
    public boolean save(Location location) {
        return locationDao.save(location);
    }


    /**
     * <p>This method used to delete data location</p>
     */
    @Override
    public boolean delete(Integer id) { return locationDao.delete(id); }


    /**
     * <p>This method used to display the location menu</p>
     */
    @Override
    public void display() { locationView.display(); }


    /**
     * <p>This method used to display location form</p>
     */
    @Override
    public void form(int type) {
        locationView.form(type);
    }


    /**
     * <p>This method used to display menu input specific data</p>
     */
    @Override
    public void showSingle() {
        locationView.show();
    }


    /**
     * <p>This method used to display all data location</p>
     */
    @Override
    public void showAll() {
        locationView.showAll();
    }
}
