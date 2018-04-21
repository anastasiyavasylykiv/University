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
        try {
            DepartmentService departmentService = new DepartmentService();
            Department department = departmentService.getDepartmentByName(departmentName);
            if (department != null) {
                head = department.getHead().getName() + " " + department.getHead().getSurname();
            } else {
                System.out.println("There is no head of the department.");
            }
        } catch (SQLException e) {
            throw e;
        }

        return head;
    }

    public void globalSearchByTemplate(String template) throws SQLException {
        List<String> strings = new ArrayList();
        LectorService lectorService = new LectorService();
        List<Lector> lectors = lectorService.searchNameByTemplate(template);
        for (Lector l : lectors) {
            strings.add(l.getName() + " " + l.getSurname());
        }
        strings = strings.stream().distinct().collect(Collectors.toList());

        System.out.println(strings.toString());
    }

    public int countOfEmployee(String departmentName) throws SQLException, NullPointerException {
        LectorService lectorService = new LectorService();
        DepartmentService departmentService = new DepartmentService();
        int count = (lectorService.getLectorsOfDepartment(departmentService.getDepartmentByName(departmentName).getId())).size();
        return count;
    }

    public int averageSalaryForDepartment(String departmentName) throws SQLException, NullPointerException {
        int averageSalary = 0;
        LectorService lectorService = new LectorService();
        DepartmentService departmentService = new DepartmentService();
        List<Lector> lectorsOfDepartment = lectorService.getLectorsOfDepartment(departmentService.getDepartmentByName(departmentName).getId());
        for (Lector l : lectorsOfDepartment
                ) {
            averageSalary += l.getSalary();
        }
        return averageSalary / countOfEmployee(departmentName);
    }

    public void showDepartmentStatistic(String departmentName) throws SQLException, NullPointerException {
        int assistans = 0, associateProfessors = 0, professors = 0;
        LectorService lectorService = new LectorService();
        DepartmentService departmentService = new DepartmentService();
        List<Lector> lectorsOfDepartment = lectorService.getLectorsOfDepartment(departmentService.getDepartmentByName(departmentName).getId());
        for (Lector l : lectorsOfDepartment
                ) {
            if (l.getDegree().getId() == 1) {
                assistans++;
            } else if (l.getDegree().getId() == 2) {
                associateProfessors++;
            } else if (l.getDegree().getId() == 3) {
                professors++;
            }
        }
        System.out.println("assistans - " + assistans);
        System.out.println("associate professors - " + associateProfessors);
        System.out.println("professors - " + professors);
    }
}
//Who is head of department Faculty of Applied Mathematics
//Show Faculty of Applied Mathematics statistic
//Show the average salary for department Faculty of Philology
//Show count of employee for Faculty of Economics
//Global search by va