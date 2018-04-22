package com.botscrew.university;

import com.botscrew.university.database.model.Department;
import com.botscrew.university.database.model.Lector;
import com.botscrew.university.database.service.DepartmentService;
import com.botscrew.university.database.service.LectorService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Answers {
    public String findHeadOfDepartment(String departmentName) throws SQLException, NullPointerException {
        String head = "";
        DepartmentService departmentService = new DepartmentService();
        Department department = departmentService.getDepartmentByName(departmentName);
        if (department != null) {
            head = department.getHead().getName() + " " + department.getHead().getSurname();
        } else {
            System.out.println("There is no head of the department.");
        }

        return head;
    }

    public void globalSearchByTemplate(String template) throws SQLException {
        List<String> strings = new ArrayList();
        LectorService lectorService = new LectorService();
        try {

            List<Lector> lectors = lectorService.searchNameByTemplate(template);
            if (lectors.size() == 0)
                System.out.println("Global search: no results");
            for (Lector l : lectors) {
                strings.add(l.getName() + " " + l.getSurname());
            }
            strings = strings.stream().distinct().collect(Collectors.toList());
        } catch (SQLException e) {
            throw new SQLException("Global search: no results");
        }
        System.out.println(strings.toString());
    }

    public int countOfEmployee(String departmentName) throws SQLException, NullPointerException {
        LectorService lectorService = new LectorService();
        DepartmentService departmentService = new DepartmentService();
        Department departmentByName = departmentService.getDepartmentByName(departmentName);
        if (departmentByName == null) {
            throw new SQLException("No department with this name");
        }
        return (lectorService.getLectorsOfDepartment(departmentByName.getId())).size();
    }

    public int averageSalaryForDepartment(String departmentName) throws SQLException, NullPointerException {
        int averageSalary = 0;
        LectorService lectorService = new LectorService();
        DepartmentService departmentService = new DepartmentService();
        Department departmentByName = departmentService.getDepartmentByName(departmentName);
        if (departmentByName == null) {
            throw new SQLException("No department with this name");
        }
        List<Lector> lectorsOfDepartment = lectorService.getLectorsOfDepartment(departmentByName.getId());
        for (Lector l : lectorsOfDepartment
                ) {
            averageSalary += l.getSalary();
        }
        return averageSalary / countOfEmployee(departmentName);
    }

    public void showDepartmentStatistic(String departmentName) throws SQLException, NullPointerException {
        int assistants = 0, associateProfessors = 0, professors = 0;
        LectorService lectorService = new LectorService();
        DepartmentService departmentService = new DepartmentService();
        Department departmentByName = departmentService.getDepartmentByName(departmentName);
        if (departmentByName == null) {
            throw new SQLException("No department with this name");
        }
        List<Lector> lectorsOfDepartment = lectorService.getLectorsOfDepartment(departmentByName.getId());
        for (Lector l : lectorsOfDepartment
                ) {
            if (l.getDegree().getName().equals("assistant")) {
                assistants++;
            } else if (l.getDegree().getName().equals("associate professor")) {
                associateProfessors++;
            } else if (l.getDegree().getName().equals("professor")) {
                professors++;
            }
        }
        System.out.println("assistants - " + assistants);
        System.out.println("associate professors - " + associateProfessors);
        System.out.println("professors - " + professors);
    }
}
//Who is head of department Faculty of Applied Mathematics
//Show Faculty of Applied Mathematics statistic
//Show the average salary for department Faculty of Philology
//Show count of employee for Faculty of Economics
//Global search by va
