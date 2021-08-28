package controllers;

import daos.CountryDao;
import models.Country;
import views.CountryView;
import views.JobView;

import java.util.List;

public class CountryController extends BaseController<Country, String> {

    CountryDao countryDao;
    CountryView countryView;

    public CountryController() {
        countryDao = new CountryDao(dbc.getConnection());
        countryView = new CountryView();
    }

    @Override
    public List<Country> getAll() {
        return countryDao.getAll();
    }

    @Override
    public Country getById(String id) {
        return countryDao.getById(id);
    }

    @Override
    public boolean save(Country country) {
        return countryDao.save(country);
    }

    @Override
    public boolean delete(String id) {
        return countryDao.delete(id);
    }

    @Override
    public void display() {
        countryView.display();
    }

    @Override
    public void form(int type) {
        countryView.form(type);
    }

    @Override
    public void showSingle() {
        countryView.show();

    }

    @Override
    public void showAll() {
        countryView.showAll();
    }
}
