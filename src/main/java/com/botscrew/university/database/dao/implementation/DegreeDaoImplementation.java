package com.botscrew.university.database.dao.implementation;

import com.botscrew.university.database.dao.DegreeDAO;
import com.botscrew.university.database.model.Degree;
import com.botscrew.university.database.transformers.DegreeTransformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.botscrew.university.database.persistant.ConnectionManager;

public class DegreeDaoImplementation implements DegreeDAO{

    private final String INSERT_NEW_DEGREE = "INSERT INTO degree (id_degree, name)" +
            " VALUES (?, ?)";
    private final String UPDATE_DEGREE_BY_ID = "UPDATE degree SET name = ? WHERE id_degree = ?";
    private final String DELETE_DEGREE_BY_ID = "DELETE FROM degree WHERE id_degree = ?";
    private final String GET_ALL_DEGREE = "SELECT * FROM degree";
    private final String GET_DEGREE = "SELECT * FROM degree WHERE id_degree= ? ";

    public void create(Degree d) throws SQLException {
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(INSERT_NEW_DEGREE)){
            statement.setInt(1, d.getId());
            statement.setString(2, d.getName());

            statement.executeUpdate();
        }
    }


    public Degree getById(int id) throws SQLException {
        Degree degree;
        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(GET_DEGREE)) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            degree=new DegreeTransformer().fromResultsSetToObject(resultSet);

        }
        return degree;
    }
        public List<Degree> getAllDegree() throws SQLException {

        List<Degree> list = new ArrayList<>();

        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(GET_ALL_DEGREE)){
            ResultSet resultSet = statement.executeQuery();

            while(!resultSet.isLast()){
                list.add(new DegreeTransformer().fromResultsSetToObject(resultSet));
            }
        }


        return list;
    }

    public void updateById(int id, Degree newDegree) throws SQLException {
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(UPDATE_DEGREE_BY_ID)){
            statement.setString(1, newDegree.getName());
            statement.setInt(2, id);

            statement.executeUpdate();
        }
    }

    public void deleteById(int id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(DELETE_DEGREE_BY_ID)){
            statement.setInt(1, id);

            statement.executeUpdate();
        }
    }


}

