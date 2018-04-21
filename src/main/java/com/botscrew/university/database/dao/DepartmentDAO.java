package com.botscrew.university.database.dao;

import com.botscrew.university.database.model.Department;
import com.botscrew.university.database.model.Lector;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {
    void create(Department d) throws SQLException;
    List<Department> getAllDepartments() throws SQLException;
    void updateById(int id, Department newDepartment) throws SQLException;
    void deleteById(int id) throws SQLException;
    Department getById(int id)throws SQLException;
    Department getByName(String name)throws SQLException;

}
