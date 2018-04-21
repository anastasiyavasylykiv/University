package com.botscrew.university.database.transformers;

import com.botscrew.university.database.model.Lector;
import com.botscrew.university.database.service.DegreeService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class LectorTransformer {
    private DegreeService degreeService;

    public LectorTransformer() {
        degreeService = new DegreeService();
    }

    public Lector fromResultsSetToObject(ResultSet rs) throws SQLException {

        Lector result = null;
        if (rs.next()) {
            result = new Lector();
            result.setId(rs.getInt("id_lector"));
            result.setName(rs.getString("first_name"));
            result.setSurname(rs.getString("second_name"));
            result.setSalary(rs.getInt("salary"));
            int degreeId = rs.getInt("degree_id");
         //  result.setDegree(degreeService.getDegreeById(degreeId));
            result.setDegree(degreeService.getAllDegree().stream().filter(
                    x -> x.getId() == degreeId).collect(Collectors.toList()).get(0));
        }

        return result;
    }
}
