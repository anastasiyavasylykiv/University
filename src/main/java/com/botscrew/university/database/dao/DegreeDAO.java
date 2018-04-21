package com.botscrew.university.database.dao;

import com.botscrew.university.database.model.Degree;

import java.sql.SQLException;
import java.util.List;

public interface DegreeDAO {
    List<Degree> getAllDegree() throws SQLException;
    void create(Degree d) throws SQLException;
    void updateById(int id, Degree newDegree) throws SQLException;
    void deleteById(int id) throws SQLException;
    Degree getById(int id) throws SQLException;
}
