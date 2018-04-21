package com.botscrew.university.database.model;

import javax.swing.*;
import java.util.List;

public class Lector {
    private int id;
    private String name;
    private String surname;
    private Degree degree;
    private int salary;
    private List<Department> department;

    public Lector(int id, String name, String surname, Degree degree, int salary,List<Department> department) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.degree = degree;
        this.salary = salary;
        this.department=department;
    }

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }

    public Lector() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Lector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", degree=" + degree +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
