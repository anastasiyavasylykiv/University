package com.botscrew.university.database.dao;

import com.botscrew.university.database.model.Lector;

import java.sql.SQLException;
import java.util.List;

public interface LectorDAO {
    List<Lector> getAllLectors() throws SQLException;
    void create(Lector lector) throws SQLException;
    void updateById(int id, Lector newLector) throws SQLException;
    void deleteById(int id) throws SQLException;
    Lector getById(int id) throws  SQLException;
    Lector getByName(String name) throws  SQLException;
    Lector getBySurname(String surname) throws  SQLException;
    List<Lector> searchNameByTemplate(String template) throws SQLException;
    List<Lector> getLectorsOfDepartment(int department) throws SQLException;
}
