package daos;

import models.Location;
import tools.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDao implements DAOInterface<Location,Integer>{
    private final Connection connection;

    public LocationDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Location> getAll() {
        List<Location> listLocation = new ArrayList<>();
        try{
            ResultSet resultSet = connection.prepareStatement(Query.GET_LOCATIONS.getDisplayQuery()).executeQuery();
            while (resultSet.next()){
                listLocation.add(
                        new Location(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6)
                        ));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return listLocation;
    }

    @Override
    public Location getById(Integer id) {
        Location location = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(Query.GET_BY_ID_LOCATIONS.getDisplayQuery());
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                location = new Location(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return location;
    }

    @Override
    public boolean save(Location location) {
        try{
            PreparedStatement preparedStatement;
            if(getById(location.getId()) != null){
                preparedStatement = connection.prepareStatement(Query.UPDATE_LOCATIONS.getDisplayQuery());
                System.out.println("Updating..");
            }else {
                preparedStatement = connection.prepareStatement(Query.INSERT_LOCATIONS.getDisplayQuery());
                System.out.println("Inserting..");
            }
            preparedStatement.setString(1, location.getStreet_address());
            preparedStatement.setString(2, location.getPostal_code());
            preparedStatement.setString(3, location.getCity());
            preparedStatement.setString(4, location.getState_province());
            preparedStatement.setString(5, location.getCountry_id());
            preparedStatement.setInt(6, location.getId());
            preparedStatement.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.DELETE_LOCATIONS.getDisplayQuery());
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
