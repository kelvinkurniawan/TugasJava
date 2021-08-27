/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;

/**
 *
 * @author kelvi
 * @param <T> Replaced by entity object
 * @param <Key> Replaced by the identifier of object
 */
public interface DAOInterface <T, Key> {

    /**
     *
     * @param T will replaced By object parameter
     * @return will returning list of T
     */
    public List<T> getAll();

    /**
     *
     * @param id is a key from object entity
     * @return is object T
     */
    public T getById(Key id);

    /**
     *
     * @param object object will replaced by the object entity
     * @return boolean true when success and false when failed
     */
    public boolean save(T object);

    /**
     *
     * @param id is a key from object entity
     * @return boolean true when success and false when failed
     */
    public boolean delete(Key id);
    
}
