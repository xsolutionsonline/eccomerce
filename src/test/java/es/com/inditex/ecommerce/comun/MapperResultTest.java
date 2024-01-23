package es.com.inditex.ecommerce.comun;

import es.com.inditex.ecommerce.comun.jdbc.MapperResult;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class MapperResultTest {

    private static final String TEST_LABEL = "testLabel";

    @Test
    void extractLocalDate_ReturnsCorrectValue() throws SQLException {
        // Arrange
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        MapperResult mapperResult = new MapperResult() {};

        when(resultSet.getTimestamp(TEST_LABEL)).thenReturn(new Timestamp(System.currentTimeMillis()));

        // Act
        LocalDate result = mapperResult.extractLocalDate(resultSet, TEST_LABEL);

        // Assert
        assertEquals(LocalDate.class, result.getClass());
    }

    @Test
    void extractLocalDateTime_ReturnsCorrectValue() throws SQLException {
        // Arrange
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        MapperResult mapperResult = new MapperResult() {};

        when(resultSet.getTimestamp(TEST_LABEL)).thenReturn(new Timestamp(System.currentTimeMillis()));

        // Act
        LocalDateTime result = mapperResult.extractLocalDateTime(resultSet, TEST_LABEL);

        // Assert
        assertEquals(LocalDateTime.class, result.getClass());
    }
}

