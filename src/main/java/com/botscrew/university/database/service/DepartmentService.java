package com.botscrew.university.database.service;

import com.botscrew.university.database.dao.implementation.DepartmentDaoImplementation;
import com.botscrew.university.database.model.Department;

import java.sql.SQLException;
import java.util.List;

public class DepartmentService {
    public void create(Department degree) throws SQLException {
        new DepartmentDaoImplementation().create(degree);
    }

    public List<Department> getAllDepartments() throws SQLException {
        return new DepartmentDaoImplementation().getAllDepartments();
    }

    public void updateDepartmentById(int id, Department department) throws SQLException {
        new DepartmentDaoImplementation().updateById(id, department);
    }

    public void deleteDepartmentById(int id) throws SQLException {
        new DepartmentDaoImplementation().deleteById(id);
    }
    public Department getDepartmentById(int id) throws SQLException{
       return new DepartmentDaoImplementation().getById(id);
    }
    public Department getDepartmentByName(String name) throws SQLException{
        return new DepartmentDaoImplementation().getByName(name);
    }

}
