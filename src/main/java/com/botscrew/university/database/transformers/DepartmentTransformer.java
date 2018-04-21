package com.botscrew.university.database.transformers;

import com.botscrew.university.database.model.Department;
import com.botscrew.university.database.service.LectorService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Collectors;


public class DepartmentTransformer {
    private LectorService lectorService;

    public DepartmentTransformer() {
        lectorService = new LectorService();
    }

    public Department fromResultsSetToObject(ResultSet rs) throws SQLException {

        Department result = null;
        if (rs.next()) {
            result = new Department();
            result.setId(rs.getInt("id_department"));
            result.setName(rs.getString("name"));
            int lectorId = rs.getInt("id_head");
           result.setHead(lectorService.getLectorById(lectorId));
//            result.setHead(lectorService.getAllLectors().stream().filter(
//                    x -> x.getId() == lectorId).collect(Collectors.toList()).get(0));
        }

        return result;
    }
}
