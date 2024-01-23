package es.com.inditex.ecommerce.infrastructure.price.adapter.dao;

import es.com.inditex.ecommerce.comun.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import es.com.inditex.ecommerce.domain.price.model.dto.PriceSummaryDTO;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class PriceSummaryMapper implements RowMapper<PriceSummaryDTO>, MapperResult {
    @Override
    public PriceSummaryDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("ID");
        Long brandId = resultSet.getLong("BRAND_ID");
        LocalDateTime startDate = resultSet.getTimestamp("START_DATE").toLocalDateTime();
        LocalDateTime endDate = resultSet.getTimestamp("END_DATE").toLocalDateTime();
        Long productId = resultSet.getLong("PRODUCT_ID");
        Long applicationPriority = resultSet.getLong("APPLICATION_PRIORITY");
        BigDecimal applicablePrice= resultSet.getBigDecimal("APPLICABLE_PRICE");


        return new PriceSummaryDTO(id,
                brandId,
                startDate,
                endDate,
                productId,
                applicationPriority,
                applicablePrice);
    }
}
