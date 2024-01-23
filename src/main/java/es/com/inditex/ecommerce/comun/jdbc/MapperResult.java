package es.com.inditex.ecommerce.comun.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface MapperResult {

    default LocalDate extractLocalDate(ResultSet resultSet,String label) throws SQLException {
        Timestamp date = resultSet.getTimestamp(label);
        LocalDate result = null;
        if(!resultSet.wasNull()){
            result= date.toLocalDateTime().toLocalDate();
        }
        return  result;
    }

    default LocalDateTime extractLocalDateTime(ResultSet resultSet, String label) throws SQLException {
        Timestamp date = resultSet.getTimestamp(label);
        LocalDateTime result = null;
        if(!resultSet.wasNull()){
            result= date.toLocalDateTime();
        }
        return  result;
    }



}
