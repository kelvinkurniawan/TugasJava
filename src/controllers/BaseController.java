/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import tools.DBConnection;

import java.util.List;

/**
 *
 * @author kelvi
 */
public abstract class BaseController<T, K> {
    DBConnection dbc;

    /**
     * Initialize DBConnection
     */
    public BaseController(){
        this.dbc = new DBConnection();
    }

    /**
     * <p>Abstract to get all data</p>
     * @return list of object
     */
    public abstract List<T> getAll();

    /**
     * <p>Abstract to get object by the id</p>
     * @param id is identifier of the object
     * @return single row object
     */
    public abstract T getById(K id);

    /**
     * <p>Abstract to insert or update object</p>
     * @param object is the object
     * @return boolean true when saved, false when failed to save
     */
    public abstract boolean save(T object);

    /**
     * <p>Abstract to delete the object</p>
     * @param id of the object
     * @return boolean true when deleted, false when failed
     */
    public abstract boolean delete(K id);

    /**
     * <p>Abstract to display the main menu</p>
     */
    public abstract void display();

    /**
     * <p>Abstract to display the form</p>
     * @param type is int to decided the form is insert method or update method
     */
    public abstract void form(int type);

    /**
     * <p>Abstract to show single row of object</p>
     */
    public abstract void showSingle();

    /**
     * <p>Abstract to show all of the object</p>
     */
    public abstract void showAll();
}
