package es.com.inditex.ecommerce.domain;

import es.com.inditex.ecommerce.comun.jdbc.CustomNamedParameterJdbcTemplate;
import es.com.inditex.ecommerce.domain.price.model.dto.PriceSummaryDTO;
import es.com.inditex.ecommerce.infrastructure.price.adapter.dao.DaoPriceSql;
import es.com.inditex.ecommerce.infrastructure.price.adapter.dao.PriceSummaryMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DaoPriceSqlTest {

    @Mock
    private CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Mock
    private PriceSummaryMapper priceSummaryMapper;

    @InjectMocks
    private DaoPriceSql daoPriceSql;

    @Test
    void obtainSummaryPrices_ShouldExecuteQueryWithCorrectParameters() {
        // Arrange
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T00:00:00");
        Long productId = 35455L;
        Long brandId = 1L;

        List<PriceSummaryDTO> expectedPrices = List.of(
                PriceSummaryDTOFactory.createPriceSummaryDTO(1L,1l, LocalDateTime.parse("2020-06-14T00:00:00"),
                        LocalDateTime.parse("2020-12-31T23:59:59"), 35455L, 0L, new BigDecimal("35.50")),
                PriceSummaryDTOFactory.createPriceSummaryDTO(2L,1L,LocalDateTime.parse("2020-06-14T15:00:00"),
                        LocalDateTime.parse("2020-06-14T18:30:00"), 35455L, 1L, new BigDecimal("25.45")),
                PriceSummaryDTOFactory.createPriceSummaryDTO(3L,1L, LocalDateTime.parse("2020-06-15T00:00:00"),
                        LocalDateTime.parse("2020-06-15T11:00:00"), 35455L, 1L, new BigDecimal("30.50")),
                PriceSummaryDTOFactory.createPriceSummaryDTO(4L,1L, LocalDateTime.parse("2020-06-15T16:00:00"),
                        LocalDateTime.parse("2020-12-31T23:59:59"), 35455L, 1L, new BigDecimal("38.95")));

        when(customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()).thenReturn(namedParameterJdbcTemplate);
        when(namedParameterJdbcTemplate.query(any(), any(MapSqlParameterSource.class), any(PriceSummaryMapper.class)))
                .thenReturn(expectedPrices);

        // Act
        List<PriceSummaryDTO> result = daoPriceSql.obtainSummaryPrices(applicationDate, productId, brandId);

        // Assert
        assertEquals(expectedPrices, result);
        verify(namedParameterJdbcTemplate).query(any(), any(MapSqlParameterSource.class), any(PriceSummaryMapper.class));
    }
}
