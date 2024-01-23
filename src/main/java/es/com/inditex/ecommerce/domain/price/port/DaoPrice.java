package es.com.inditex.ecommerce.domain.price.port;

import es.com.inditex.ecommerce.domain.price.model.dto.PriceSummaryDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface DaoPrice {
    List<PriceSummaryDTO> obtainSummaryPrices(LocalDateTime applicationDate, Long productId, Long brandId);
}
