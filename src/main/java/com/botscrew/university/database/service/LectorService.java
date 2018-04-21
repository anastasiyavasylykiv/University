package com.botscrew.university.database.service;

import com.botscrew.university.database.dao.implementation.LectorDaoImplementation;
import com.botscrew.university.database.model.Lector;

import java.sql.SQLException;
import java.util.List;

public class LectorService {
    public void create(Lector lector) throws SQLException {
        new LectorDaoImplementation().create(lector);
    }

    public List<Lector> getAllLectors() throws SQLException {
        return new LectorDaoImplementation().getAllLectors();
    }

    public void updateLectorById(int id, Lector lector) throws SQLException {
        new LectorDaoImplementation().updateById(id, lector);
    }

    public void deleteLectorById(int id) throws SQLException {
        new LectorDaoImplementation().deleteById(id);
    }
    public Lector getLectorById(int id) throws SQLException{
        return  new LectorDaoImplementation().getById(id);
    }
    public Lector getLectorByName(String name) throws SQLException{
        return  new LectorDaoImplementation().getByName(name);
    }
    public Lector getLectorBySurname(String surname) throws SQLException{
        return  new LectorDaoImplementation().getBySurname(surname);
    }
    public List<Lector> searchNameByTemplate(String template) throws SQLException{
        return new LectorDaoImplementation().searchNameByTemplate(template);
    }
    public List<Lector> getLectorsOfDepartment(int department) throws SQLException{
        return new LectorDaoImplementation().getLectorsOfDepartment(department);
    }
}
