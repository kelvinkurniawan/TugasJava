/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import java.util.List;

/**
 *
 * @author kelvi
 * @param <T>
 * @param <K>
 */
public abstract class BaseController<T, K> implements DAOInterface<T, K>{
    public List<T> findAll(){
        return getAll();
    }
    
    public T getOne(K id){
        return getById(id);
    }
    
    public boolean remove(K id){
        return delete(id);
    }
    
    public boolean insertOrDelete(T t){
        return save(t);
    }
}
