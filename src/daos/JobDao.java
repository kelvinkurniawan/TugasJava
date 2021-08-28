/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;
import models.Job;
import tools.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kelvi
 */
public class JobDao implements DAOInterface<Job, String>{
    
    private final Connection connection;

    /**
     * <p>This method used to create connection to the database</p>
     * @param connection
     */
    public JobDao(Connection connection){
        this.connection = connection;
    }

    /**
     * <p>This method used to get list of Job</p>
     * @return list of Job
     */
    @Override
    public List<Job> getAll() {
        List<Job> jobs = new ArrayList<>();
        
        try {
            ResultSet resultSet = connection
                    .prepareStatement(Query.GET_JOB.getDisplayQuery())
                    .executeQuery();    
            
            System.out.println(resultSet);
            
            while(resultSet.next()) {
                Job job = new Job();
                jobs.add(new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getDouble(4)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return jobs;
    }

    /**
     * <p>This method used to get single row job by the job id</p>
     * @param id is a key from object entity
     * @return single row of job
     */
    @Override
    public Job getById(String id) {
        Job job = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.GET_BY_ID_JOB.getDisplayQuery());
            preparedStatement.setString(1, id);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            
            while(resultSet.next()) {
                job = new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getDouble(4));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return job;
    }

    /**
     * <p>this method used to insert or update job</p>
     * @param job
     * @return is boolean true when job saved or updated, and false when failed to saved or update
     */
    @Override
    public boolean save(Job job) {
        try {
            PreparedStatement preparedStatement;
            if(getById(job.getId()) != null){
                preparedStatement = connection.prepareStatement(Query.UPDATE_JOB.getDisplayQuery());
                System.out.println("Updating..");
            }else{
                preparedStatement = connection.prepareStatement(Query.INSERT_JOB.getDisplayQuery());
                System.out.println("Inserting..");
            }

            preparedStatement.setString(1, job.getTitle());
            preparedStatement.setDouble(2, job.getMinSalary());
            preparedStatement.setDouble(3, job.getMaxsalary());
            preparedStatement.setString(4, job.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * <p>This method used to delete the job</p>
     * @param id is a key from object entity
     * @return is boolean true when job deleted, and false when failed to delete
     */
    @Override
    public boolean delete(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.DELETE_JOB.getDisplayQuery());
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
    
}
