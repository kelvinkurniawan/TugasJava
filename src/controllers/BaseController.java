/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import tools.DBConnection;

import java.util.List;

/**
 * @author kelvi
 */
public abstract class BaseController<T, K> {
    DBConnection dbc;

    /**
     * Initialize DBConnection
     */
    public BaseController() {
        this.dbc = new DBConnection();
    }

    /**
     * <p>Method to get all data of the object</p>
     *
     * @return list of object
     */
    public abstract List<T> getAll();

    /**
     * <p>Method to get object by the id</p>
     *
     * @param id is identifier of the object
     * @return single row object
     */
    public abstract T getById(K id);

    /**
     * <p>Method to insert or update object</p>
     *
     * @param object is the object
     * @return boolean true when saved, false when failed to save
     */
    public abstract boolean save(T object);

    /**
     * <p>Method to delete the object</p>
     *
     * @param id of the object
     * @return boolean true when deleted, false when failed
     */
    public abstract boolean delete(K id);

    /**
     * <p>Method to display the main menu</p>
     */
    public abstract void display();

    /**
     * <p>Method to display the form</p>
     *
     * @param type is int to decided the form is insert method or update method
     */
    public abstract void form(int type);

    /**
     * <p>Method to show single row of object</p>
     */
    public abstract void showSingle();

    /**
     * <p>Method to show all of the object</p>
     */
    public abstract void showAll();
}
