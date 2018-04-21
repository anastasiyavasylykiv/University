package com.botscrew.university;

import com.botscrew.university.database.service.DegreeService;
import com.botscrew.university.database.service.DepartmentService;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ReadQueation readQueation = new ReadQueation();
        readQueation.readQuestion();

    }
}


