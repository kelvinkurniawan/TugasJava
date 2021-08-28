/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import models.Employee;
import tools.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kelvi
 */
public class EmployeeDao implements DAOInterface<Employee, Integer> {
    private final Connection connection;

    /**
     * <p>This method used to create connection to the database</p>
     *
     * @param connection is connection parameter
     */
    public EmployeeDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * <p>This method used to get List of employee</p>
     *
     * @return List of Employee
     */
    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();

        try {
            ResultSet resultSet = connection
                    .prepareStatement(Query.GET_EMPLOYEE.getDisplayQuery())
                    .executeQuery();

            System.out.println(resultSet);

            while (resultSet.next()) {
                employees.add(
                        new Employee(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getDate(6),
                                resultSet.getString(7),
                                resultSet.getDouble(8),
                                resultSet.getDouble(9),
                                resultSet.getInt(10),
                                resultSet.getInt(11)
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return employees;
    }

    /**
     * <p>This method used to get single row employee by the employee ID</p>
     *
     * @param id is a key from object entity
     * @return single row of employee
     */
    @Override
    public Employee getById(Integer id) {

        Employee employee = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.GET_BY_ID_EMPLOYEE.getDisplayQuery());
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                employee = new Employee(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6),
                        resultSet.getString(7),
                        resultSet.getDouble(8),
                        resultSet.getDouble(9),
                        resultSet.getInt(10),
                        resultSet.getInt(11)
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return employee;
    }

    /**
     * <p>This method used to insert or update employee</p>
     *
     * @param employee is an object of employee
     * @return is boolean true when employee saved or updated, and false when failed to saved or update
     */
    @Override
    public boolean save(Employee employee) {
        try {
            PreparedStatement preparedStatement;
            if (getById(employee.getId()) != null) {
                preparedStatement = connection.prepareStatement(Query.UPDATE_EMPLOYEE.getDisplayQuery());
                System.out.println("Updating..");
            } else {
                preparedStatement = connection.prepareStatement(Query.INSERT_EMPLOYEE.getDisplayQuery());
                System.out.println("Inserting..");
            }

            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setDate(5, employee.getHireDate());
            preparedStatement.setString(6, employee.getJob());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.setDouble(8, employee.getCommissionPct());
            preparedStatement.setInt(9, employee.getManager());
            preparedStatement.setInt(10, employee.getDepartment());
            preparedStatement.setInt(11, employee.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * <p>This method used to delete the employee</p>
     *
     * @param id is a key from object entity
     * @return true when employee deleted, and false when failed to delete
     */
    @Override
    public boolean delete(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.DELETE_EMPLOYEE.getDisplayQuery());
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

}
