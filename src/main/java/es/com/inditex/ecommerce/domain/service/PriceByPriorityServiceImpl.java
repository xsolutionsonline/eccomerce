package es.com.inditex.ecommerce.domain.service;

import es.com.inditex.ecommerce.comun.exception.NoDataException;
import es.com.inditex.ecommerce.domain.price.model.dto.PriceSummaryDTO;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;

@Service
public class PriceByPriorityServiceImpl implements PriceByPriorityService {
    private static final String NO_DATA_ERROR_MESSAGE = "No se encontraron  tarifa de precios aplicar en ese rango de fechas.";

    @Override
    public PriceSummaryDTO getPriorityPrice(List<PriceSummaryDTO> prices) {
        if (prices == null || prices.isEmpty()) {
            throw new NoDataException(NO_DATA_ERROR_MESSAGE);
        }
        prices.sort(Comparator.comparingLong(PriceSummaryDTO::applicationPriority).reversed());
        return prices.get(0);
    }
}
