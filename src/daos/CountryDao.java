package daos;

import models.Country;
import models.Department;
import tools.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDao implements DAOInterface<Country, String>{

    private final Connection connection;

    public CountryDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Country> getAll() {
        List<Country> listCountry = new ArrayList<>();
        try {
            ResultSet resultSet = connection.prepareStatement(Query.GET_COUNTRIES.getDisplayQuery()).executeQuery();

            while (resultSet.next()){
                listCountry.add(new Country(resultSet.getString(1),resultSet.getString(2),resultSet.getInt(3)));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listCountry;
    }

    @Override
    public Country getById(String id) {
        Country country = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.GET_BY_ID_COUNTRIES.getDisplayQuery());
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                country = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return country;
    }

    @Override
    public boolean save(Country country) {
        try {
            PreparedStatement preparedStatement;
            if(getById(country.getId()) != null){
                preparedStatement = connection.prepareStatement(Query.UPDATE_COUNTRIES.getDisplayQuery());
                System.out.println("Updating..");
            }else{
                preparedStatement = connection.prepareStatement(Query.INSERT_COUNTRIES.getDisplayQuery());
                System.out.println("Inserting..");
            }
            preparedStatement.setString(1, country.getCountry_name());
            preparedStatement.setInt(2, country.getRegion_id());
            preparedStatement.setString(3, country.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    @Override
    public boolean delete(String id) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(Query.DELETE_COUNTRIES.getDisplayQuery());
            preparedStatement.setString(1,id);
            preparedStatement.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
