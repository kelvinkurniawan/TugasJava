/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import models.Region;
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
public class RegionDao implements DAOInterface<Region, Integer> {
    private final Connection connection;

    /**
     * <p>This method used to create connection to the database</p>
     *
     * @param connection is connection parameter
     */
    public RegionDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * <p>This method used to get list of Region</p>
     *
     * @return list of region
     */
    @Override
    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>();

        try {
            ResultSet resultSet = connection
                    .prepareStatement(Query.GET_REGION.getDisplayQuery())
                    .executeQuery();

            System.out.println(resultSet);

            while (resultSet.next()) {
                regions.add(new Region(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return regions;
    }

    /**
     * <p>This method used to get single row region by the region id</p>
     *
     * @param id is a key from object entity
     * @return single row of region
     */
    @Override
    public Region getById(Integer id) {
        Region region = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.GET_BY_ID_REGION.getDisplayQuery());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                region = new Region(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return region;
    }

    /**
     * <p>This method used to insert or update the region</p>
     *
     * @param region is a object
     * @return is boolean true when region saved or updated, and false when failed to saved or update
     */
    @Override
    public boolean save(Region region) {
        try {
            PreparedStatement preparedStatement;
            if (getById(region.getId()) != null) {
                preparedStatement = connection.prepareStatement(Query.UPDATE_REGION.getDisplayQuery());
                System.out.println("Updating..");
            } else {
                preparedStatement = connection.prepareStatement(Query.INSERT_REGION.getDisplayQuery());
                System.out.println("Inserting..");
            }

            preparedStatement.setString(1, region.getName());
            preparedStatement.setInt(2, region.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * <p>This method used to delete the region</p>
     *
     * @param id is a key from object entity
     * @return is boolean true when region deleted, and false when failed to delete
     */
    @Override
    public boolean delete(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.DELETE_REGION.getDisplayQuery());
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }


}
