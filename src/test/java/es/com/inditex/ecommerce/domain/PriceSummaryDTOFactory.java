package es.com.inditex.ecommerce.domain;
import es.com.inditex.ecommerce.domain.price.model.dto.PriceSummaryDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PriceSummaryDTOFactory {

    public static PriceSummaryDTO createPriceSummaryDTO(long id,Long branchId, LocalDateTime startDate, LocalDateTime endDate,
                                                        long productId, long priority, BigDecimal price) {
        PriceSummaryDTO priceSummaryDTO = new PriceSummaryDTO(id,branchId ,startDate,endDate,productId,priority,price);
        return priceSummaryDTO;
    }
}

