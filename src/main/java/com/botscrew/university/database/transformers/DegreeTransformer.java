package com.botscrew.university.database.transformers;

import com.botscrew.university.database.model.Degree;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DegreeTransformer {
    public Degree fromResultsSetToObject(ResultSet rs) throws SQLException {

        Degree result = null;

        if (rs.next()) {
            result = new Degree();
            result.setId(rs.getInt("id_degree"));
            result.setName(rs.getString("name"));
        }

        return result;
    }
}
