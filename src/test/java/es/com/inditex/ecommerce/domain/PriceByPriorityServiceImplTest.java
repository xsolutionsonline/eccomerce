package es.com.inditex.ecommerce.domain;

import es.com.inditex.ecommerce.comun.exception.NoDataException;
import es.com.inditex.ecommerce.domain.price.model.dto.PriceSummaryDTO;
import es.com.inditex.ecommerce.domain.service.PriceByPriorityServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceByPriorityServiceImplTest {

    @Mock
    private PriceSummaryDTO priceSummary1;

    @Mock
    private PriceSummaryDTO priceSummary2;

    @InjectMocks
    private PriceByPriorityServiceImpl priceByPriorityService;

    @Test
    void getPriorityPrice_WithValidPrices_ReturnsHighestPriorityPrice() {
        // Arrange
        when(priceSummary1.applicationPriority()).thenReturn(1L);
        when(priceSummary2.applicationPriority()).thenReturn(2L);

        List<PriceSummaryDTO> prices = Arrays.asList(priceSummary1, priceSummary2);

        // Act
        PriceSummaryDTO result = priceByPriorityService.getPriorityPrice(prices);

        // Assert
        assertEquals(priceSummary2, result);
    }

    @Test
    void getPriorityPrice_WithEmptyPrices_ThrowsNoDataException() {
        // Arrange
        List<PriceSummaryDTO> emptyPrices = Arrays.asList();

        // Act & Assert
        assertThrows(NoDataException.class, () -> {
            priceByPriorityService.getPriorityPrice(emptyPrices);
        });
    }
}
