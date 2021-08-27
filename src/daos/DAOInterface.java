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
 * @param <Object>
 * @param <Key>
 */
public interface DAOInterface <T, Key> {
    
    public List<T> getAll();
    public T getById(Key id);
    public boolean save(T object);
    public boolean delete(Key id);
    
}
