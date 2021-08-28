package controllers;

import daos.CountryDao;
import models.Country;
import views.CountryView;
import java.util.List;

/**
 * @author fajar
 */
public class CountryController extends BaseController<Country, String> {

    CountryDao countryDao;
    CountryView countryView;

    /**
     * Initialize Model & View Country
     */
    public CountryController() {
        countryDao = new CountryDao(dbc.getConnection());
        countryView = new CountryView();
    }


    /**
     * <p>This method used to get all data country</p>
     */
    @Override
    public List<Country> getAll() {
        return countryDao.getAll();
    }


    /**
     * <p>This method used to get data country by id</p>
     */
    @Override
    public Country getById(String id) {
        return countryDao.getById(id);
    }


    /**
     * <p>This method used to Insert or Update data country</p>
     */
    @Override
    public boolean save(Country country) {
        return countryDao.save(country);
    }


    /**
     * <p>This method used to delete data country</p>
     */
    @Override
    public boolean delete(String id) {
        return countryDao.delete(id);
    }


    /**
     * <p>This method used to display the country menu</p>
     */
    @Override
    public void display() {
        countryView.display();
    }


    /**
     * <p>This method used to display country form</p>
     */
    @Override
    public void form(int type) {
        countryView.form(type);
    }


    /**
     * <p>This method used to display menu input specific data</p>
     */
    @Override
    public void showSingle() {
        countryView.show();
    }


    /**
     * <p>This method used to display all data country</p>
     */
    @Override
    public void showAll() {
        countryView.showAll();
    }
}
