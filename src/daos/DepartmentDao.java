/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Department;
import tools.Query;

/**
 *
 * @author kelvi
 */
public class DepartmentDao implements DAOInterface<Department, Integer>{
    private final Connection connection;
    
    public DepartmentDao(Connection connection){
        this.connection = connection;
    }

    /**
     *
     * @return List of department
     */
    @Override
    public List<Department> getAll() {
        List<Department> departments = new ArrayList<>();
        
        try {
            ResultSet resultSet = connection
                    .prepareStatement(Query.GET_DEPARTMENT.getDisplayQuery())
                    .executeQuery();    
            
            System.out.println(resultSet);
            
            while(resultSet.next()) {
                departments.add(new Department(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return departments;
    }

    /**
     *
     * @param id is key identifier of the Department object
     * @return single row of department
     */
    @Override
    public Department getById(Integer id) {
        Department department = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.GET_BY_ID_DEPARTMENT.getDisplayQuery());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                department = new Department(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return department;
    }

    /**
     *
     * @param department is an object of department
     * @return is boolean, true when department saved or updated, and false when failed to saved or update
     */
    @Override
    public boolean save(Department department) {
        try {
            PreparedStatement preparedStatement;
            if(getById(department.getId()) != null){
                preparedStatement = connection.prepareStatement(Query.UPDATE_DEPARTMENT.getDisplayQuery());
                System.out.println("Updating..");
            }else{
                preparedStatement = connection.prepareStatement(Query.INSERT_DEPARTMENT.getDisplayQuery());
                System.out.println("Inserting..");
            }

            preparedStatement.setString(1, department.getName());
            preparedStatement.setInt(2, department.getManager());
            preparedStatement.setInt(3, department.getLocation());
            preparedStatement.setInt(4, department.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     *
     * @param id is key identifier of the Department object
     * @return is boolean true when object deleted, and false when cannot delete the object
     */
    @Override
    public boolean delete(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.DELETE_DEPARTMENT.getDisplayQuery());
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
    
}
