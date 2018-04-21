package com.botscrew.university;

import java.sql.SQLException;
import java.util.Scanner;

public class ReadQueation {
    public String deleteWhitespaces(String stringWithWhitespaces) {
        StringBuilder newString = new StringBuilder();
        String[] stringArr = stringWithWhitespaces.split(" ");
        for (int i = 0; i < stringArr.length; i++) {
            if (!stringArr[i].equals("")) {
                newString.append(stringArr[i]).append(" ");
            }
        }
        return newString.toString().trim();
    }

    public void readQuestion() throws SQLException {
        Answers answers = new Answers();
        String headOfDepartmentString = "Who is head of department";
        String startShowStatisticsString = "Show";
        String endShowStatisticsString = "statistic";
        String theAverageSalaryForDepartmentString = "Show the average salary for department";
        String countOfEmployeeString = "Show count of employee for";
        String searchByString = "Global search by";
        Scanner scanner = new Scanner(System.in);
        String question;
        System.out.println("Enter your question:");
        question = scanner.nextLine();
        question = deleteWhitespaces(question);
        String[] questionArr = question.split(" ");
        try {
            switch (questionArr[0].toLowerCase()) {
                case "who":
                    if (question.trim().toLowerCase().contains(headOfDepartmentString.toLowerCase())) {
                        String departmentName = question.substring(headOfDepartmentString.length() + 1);
                        if (!(answers.findHeadOfDepartment(departmentName)).equals("")) {
                            System.out.println("Head of " + departmentName + " department is " + answers.findHeadOfDepartment(departmentName));
                        }
                        readQuestion();
                    } else
                        readQuestion();
                    break;
                case "show":
                    if (question.endsWith(endShowStatisticsString)) {
                        String departmentName = question.substring(startShowStatisticsString.length()+1,question.length()- endShowStatisticsString.length()-1 );
                        answers.showDepartmentStatistic(departmentName);
                        readQuestion();
                    } else if (question.trim().toLowerCase().contains(theAverageSalaryForDepartmentString.toLowerCase())) {
                        String departmentName = question.substring(theAverageSalaryForDepartmentString.length() + 1);
                        System.out.println(answers.averageSalaryForDepartment(departmentName));
                        readQuestion();
                    } else if (question.trim().toLowerCase().contains(countOfEmployeeString.toLowerCase())) {
                        String departmentName = question.substring(countOfEmployeeString.length() + 1);
                        System.out.println(answers.countOfEmployee(departmentName));
                        readQuestion();
                    } else {
                    }
                    readQuestion();
                    break;
                case "global":
                    if (question.trim().toLowerCase().contains(searchByString.toLowerCase())) {
                        String template = question.substring(searchByString.length() + 1);
                        answers.globalSearchByTemplate(template);
                        readQuestion();
                    }
                    break;
                default:
                    readQuestion();

            }
        } catch (SQLException sql) {
        }
    }

}
