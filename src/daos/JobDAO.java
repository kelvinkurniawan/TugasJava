/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Job;
import tools.Query;

/**
 *
 * @author kelvi
 */
public class JobDAO implements DAOInterface<Job, String>{
    
    private final Connection connection;
    
    public JobDAO(Connection connection){
        this.connection = connection;
    }

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

    @Override
    public Job getById(String id) {
        Job job = null;
        
        try {
            ResultSet resultSet = connection
                    .prepareStatement(Query.GET_JOB.getDisplayQuery())
                    .executeQuery();    
            
            System.out.println(resultSet);
            
            while(resultSet.next()) {
                job = new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getDouble(4));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return job;
    }

    @Override
    public boolean save(Job object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
