package com.botscrew.university;

import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Questions readQueation = new Questions();
        readQueation.readQuestion();

    }
}


