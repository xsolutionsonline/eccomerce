package es.com.inditex.ecommerce.comun;

import es.com.inditex.ecommerce.comun.exception.TechnicalException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TechnicalExceptionTest {

    @Test
    public void constructorWithMessage_ShouldSetMessage() {
        // Arrange
        String errorMessage = "Test error message";

        // Act
        TechnicalException technicalException = new TechnicalException(errorMessage);

        // Assert
        assertEquals(errorMessage, technicalException.getMessage());
        assertNull(technicalException.getCause());
    }

    @Test
    public void constructorWithMessageAndException_ShouldSetMessageAndException() {
        // Arrange
        String errorMessage = "Test error message";
        Exception originalException = new Exception("Original exception message");

        // Act
        TechnicalException technicalException = new TechnicalException(errorMessage, originalException);

        // Assert
        assertEquals(errorMessage, technicalException.getMessage());
        assertEquals(originalException, technicalException.getCause());
    }
}

