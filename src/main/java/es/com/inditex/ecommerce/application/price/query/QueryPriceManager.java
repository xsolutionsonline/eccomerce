package es.com.inditex.ecommerce.application.price.query;

import es.com.inditex.ecommerce.domain.price.model.dto.PriceSummaryDTO;
import es.com.inditex.ecommerce.domain.price.port.DaoPrice;
import es.com.inditex.ecommerce.domain.service.PriceByPriorityService;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class QueryPriceManager {

    private final DaoPrice daoPrices;

    private final PriceByPriorityService priceByPriorityService;


    public QueryPriceManager(DaoPrice daoPrices,PriceByPriorityService priceByPriorityService){
        this.daoPrices = daoPrices;
        this.priceByPriorityService = priceByPriorityService;
    }

    public PriceSummaryDTO ejecutar(LocalDateTime applicationDate, Long productId, Long brandId){
        return priceByPriorityService.getPriorityPrice(daoPrices.obtainSummaryPrices(applicationDate,productId,brandId));
    }
}
