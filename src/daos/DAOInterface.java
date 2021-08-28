/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;

/**
 * @param <T>   Replaced by entity object
 * @param <Key> Replaced by the identifier of object
 * @author kelvi
 */
public interface DAOInterface<T, Key> {

    /**
     * <p>This method used to get List of object</p>
     *
     * @return will returning list of T
     */
    List<T> getAll();

    /**
     * <p>This method used to get single row object by the identifier</p>
     *
     * @param id is a key from object entity
     * @return is object T
     */
    T getById(Key id);

    /**
     * <p>This method used to insert or update object</p>
     *
     * @param object object will replaced by the object entity
     * @return boolean true when success and false when failed
     */
    boolean save(T object);

    /**
     * <p>This method used to delete the object</p>
     *
     * @param id is a key from object entity
     * @return boolean true when success and false when failed
     */
    boolean delete(Key id);

}
