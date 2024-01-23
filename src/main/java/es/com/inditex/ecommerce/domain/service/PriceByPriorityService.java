package es.com.inditex.ecommerce.domain.service;

import es.com.inditex.ecommerce.domain.price.model.dto.PriceSummaryDTO;
import java.util.List;

public interface PriceByPriorityService {
    PriceSummaryDTO getPriorityPrice(List<PriceSummaryDTO> listado);
}
