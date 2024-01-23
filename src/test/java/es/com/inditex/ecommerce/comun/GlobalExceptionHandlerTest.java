package es.com.inditex.ecommerce.comun;

import es.com.inditex.ecommerce.comun.exception.GlobalExceptionHandler;
import es.com.inditex.ecommerce.comun.exception.NoDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class GlobalExceptionHandlerTest {

    @Mock
    private NoDataException mockNoDataException;

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void handleNoDataException_ShouldReturnNotFoundResponse() {
        // Arrange
        String errorMessage = "Test error message";
        when(mockNoDataException.getMessage()).thenReturn(errorMessage);

        // Act
        ResponseEntity<String> responseEntity = globalExceptionHandler.handleNoDataException(mockNoDataException);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals(errorMessage, responseEntity.getBody());
        verify(mockNoDataException).getMessage();
    }
}

