package controllers;

import daos.CountryDao;
import models.Country;

import java.util.List;

public class CountryController extends BaseController<Country, String> {

    CountryDao countryDao;


    @Override
    public List<Country> getAll() {
        return null;
    }

    @Override
    public Country getById(String id) {
        return null;
    }

    @Override
    public boolean save(Country object) {
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
