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
public interface DAOInterface <Object, Key> {
    
    public List<Object> getAll();
    public Object getById(Key id);
    public boolean save(Object object);
    public boolean delete(Key id);
    
}
