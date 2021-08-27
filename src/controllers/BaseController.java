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
    
    public BaseController(){
        this.dbc = new DBConnection();
    }

    public abstract List<T> getAll();

    public abstract T getById(K id);

    public abstract boolean save(T object);

    public abstract boolean delete(K id);

    public abstract void display();

    public abstract void form(int type);

    public abstract void showSingle();

    public abstract void showAll();
}
