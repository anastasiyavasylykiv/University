package com.botscrew.university.database.service;

import java.sql.SQLException;
import java.util.List;

import com.botscrew.university.database.dao.implementation.DegreeDaoImplementation;
import com.botscrew.university.database.model.Degree;

public class DegreeService {
    public void create(Degree degree) throws SQLException {
        new DegreeDaoImplementation().create(degree);
    }

    public List<Degree> getAllDegree() throws SQLException {
        return new DegreeDaoImplementation().getAllDegree();
    }

    public void updateDegreeById(int id, Degree degree) throws SQLException {
        new DegreeDaoImplementation().updateById(id, degree);
    }

    public void deleteDegreeById(int id) throws SQLException {
        new DegreeDaoImplementation().deleteById(id);
    }
    public Degree getDegreeById(int id) throws SQLException{
       return  new DegreeDaoImplementation().getById(id);
    }
    public Degree getDegreeByName(String name) throws SQLException{
        return  new DegreeDaoImplementation().getByName(name);
    }
}
