package es.com.inditex.ecommerce.domain.price.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceSummaryDTO(
        Long id,
        Long brandId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Long productId,
        Long applicationPriority,
        BigDecimal applicablePrice
){}
