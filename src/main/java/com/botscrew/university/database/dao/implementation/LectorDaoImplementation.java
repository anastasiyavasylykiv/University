package com.botscrew.university.database.dao.implementation;

import com.botscrew.university.database.dao.LectorDAO;
import com.botscrew.university.database.model.Lector;
import com.botscrew.university.database.persistant.ConnectionManager;
import com.botscrew.university.database.transformers.LectorTransformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LectorDaoImplementation implements LectorDAO {
    private final String INSERT_NEW_LECTOR = "INSERT INTO lector (id_lector, first_name,second_name,degree_id,salary)" +
            " VALUES (?, ?,?,?,?)";
    private final String UPDATE_LECTOR_BY_ID = "UPDATE lector SET first_name = ?,second_name =?,degree_id=?,salary=? " +
            "WHERE id_lector = ?";
    private final String DELETE_LECTOR_BY_ID = "DELETE FROM lector WHERE id_lector = ?";
    private final String GET_ALL_LECTORS = "SELECT * FROM lector";
    private final String GET_LECTOR = "SELECT * FROM lector where id_lector = ?";
    private final String GET_LECTOR_BY_NAME = "SELECT * FROM lector where first_name = ?";
    private final String GET_LECTOR_BY_SURNAME = "SELECT * FROM lector where second_name = ?";
    private final String SEARCH_NAME_BY_TEMPLATE = "SELECT * FROM lector where first_name like ";
    private final String SEARCH_SURNAME_BY_TEMPLATE = " or second_name like ";
    private final String GET_LECTORS_OF_DEPARTMENT="SELECT * FROM lector join lector_department on lector.id_lector=lector_department.id_lector where id_department=?";
//private final String COUNT_BY_DEGREE=" SELECT count(*) FROM lector l JOIN department d ON ";

    public void create(Lector l) throws SQLException {
        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(INSERT_NEW_LECTOR)) {
            statement.setInt(1, l.getId());
            statement.setString(2, l.getName());
            statement.setString(3, l.getSurname());
            statement.setInt(4, l.getDegree().getId());
            statement.setInt(5, l.getSalary());

            statement.executeUpdate();
        }
    }

    public Lector getById(int id) throws SQLException {
        Lector lector;
        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(GET_LECTOR)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            lector = new LectorTransformer().fromResultsSetToObject(resultSet);

        }

        return lector;
    }

    public Lector getByName(String name) throws SQLException {
        Lector lector;
        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(GET_LECTOR_BY_NAME)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            lector = new LectorTransformer().fromResultsSetToObject(resultSet);

        }

        return lector;
    }

    public List<Lector> searchNameByTemplate(String template) throws SQLException {
        List<Lector> lector = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SEARCH_NAME_BY_TEMPLATE + "'%" + template + "%'" +SEARCH_SURNAME_BY_TEMPLATE+"'%" + template + "%'")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lector.add(new LectorTransformer().fromResultsSetToObject(resultSet));

            }
        }
        return lector;
    }
    public Lector getBySurname(String surname) throws SQLException {
        Lector lector;
        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(GET_LECTOR_BY_SURNAME)) {
            statement.setString(1, surname);
            ResultSet resultSet = statement.executeQuery();
            lector = new LectorTransformer().fromResultsSetToObject(resultSet);

        }

        return lector;
    }

    public List<Lector> getAllLectors() throws SQLException {

        List<Lector> list = new ArrayList<>();

        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_LECTORS)) {
            ResultSet resultSet = statement.executeQuery();

            while (!resultSet.isLast()) {
                list.add(new LectorTransformer().fromResultsSetToObject(resultSet));
            }
        }


        return list;
    }
    public List<Lector> getLectorsOfDepartment(int department) throws SQLException {

        List<Lector> lector = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(GET_LECTORS_OF_DEPARTMENT)) {
            statement.setInt(1, department);
            ResultSet resultSet = statement.executeQuery();
            while (!resultSet.isLast()) {
                lector.add(new LectorTransformer().fromResultsSetToObject(resultSet));

            }
        }
        return lector;
    }
    public void updateById(int id, Lector newLector) throws SQLException {
        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(UPDATE_LECTOR_BY_ID)) {
            statement.setString(1, newLector.getName());
            statement.setString(2, newLector.getSurname());
            statement.setInt(3, newLector.getDegree().getId());
            statement.setInt(4, newLector.getSalary());

            statement.setInt(5, id);

            statement.executeUpdate();
        }
    }

    public void deleteById(int id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(DELETE_LECTOR_BY_ID)) {
            statement.setInt(1, id);

            statement.executeUpdate();
        }
    }
}



