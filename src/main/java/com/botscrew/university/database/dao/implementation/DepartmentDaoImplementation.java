package com.botscrew.university.database.dao.implementation;

import com.botscrew.university.database.dao.DepartmentDAO;
import com.botscrew.university.database.model.Department;
import com.botscrew.university.database.persistant.ConnectionManager;
import com.botscrew.university.database.transformers.DepartmentTransformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImplementation implements DepartmentDAO {

    private final String INSERT_NEW_DEPARTMENT = "INSERT INTO department (id_department, name,id_head)" +
            " VALUES (?, ?,?)";
    private final String UPDATE_DEPARTMENT_BY_ID = "UPDATE department SET name = ?,id_head=? WHERE id_department = ?";
    private final String DELETE_DEPARTMENT_BY_ID = "DELETE FROM department WHERE id_department = ?";
    private final String GET_ALL_DEPARTMENTS = "SELECT * FROM department";
    private final String GET_DEPARTMENT_BY_NAME = "SELECT * FROM department WHERE name= ?";
    private final String GET_DEPARTMENT_BY_ID = "SELECT * FROM department WHERE id_department= ?";

    public void create(Department d) throws SQLException {
        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(INSERT_NEW_DEPARTMENT)) {
            statement.setInt(1, d.getId());
            statement.setString(2, d.getName());
            statement.setInt(3, d.getHead().getId());

            statement.executeUpdate();
        }
    }

    public Department getById(int id) throws SQLException {
        Department department;
        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(GET_DEPARTMENT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            department = new DepartmentTransformer().fromResultsSetToObject(resultSet);

        }
        return department;
    }
    public Department getByName(String name) throws SQLException {
        Department department;
        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(GET_DEPARTMENT_BY_NAME)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            department = new DepartmentTransformer().fromResultsSetToObject(resultSet);

        }
        return department;
    }
    public List<Department> getAllDepartments() throws SQLException {

        List<Department> list = new ArrayList<>();

        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_DEPARTMENTS)) {
            ResultSet resultSet = statement.executeQuery();

            while (!resultSet.isLast()) {
                list.add(new DepartmentTransformer().fromResultsSetToObject(resultSet));
            }
        }


        return list;
    }


    public void updateById(int id, Department newDepartment) throws SQLException {
        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(UPDATE_DEPARTMENT_BY_ID)) {
            statement.setString(1, newDepartment.getName());
            statement.setInt(2, newDepartment.getHead().getId());
            statement.setInt(3, id);

            statement.executeUpdate();
        }
    }

    public void deleteById(int id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(DELETE_DEPARTMENT_BY_ID)) {
            statement.setInt(1, id);

            statement.executeUpdate();
        }
    }
}

