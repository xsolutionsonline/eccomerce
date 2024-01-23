package es.com.inditex.ecommerce.infrastructure.price.controller;

import es.com.inditex.ecommerce.application.price.query.QueryPriceManager;
import es.com.inditex.ecommerce.domain.price.model.dto.PriceSummaryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/prices")
@Tag(name="Controller queries prices")
public class QueryControllerPrices {

    private final QueryPriceManager queryPriceManager;

    public QueryControllerPrices(QueryPriceManager queryPriceManager){
        this.queryPriceManager=queryPriceManager;
    }

    @GetMapping("byIdAndApplicationDate")
    @Operation(summary = "Consult prices by date, product, and brand",
            description = "Method that obtains prices based on the application date, product identifier, and brand identifier")
    public PriceSummaryDTO obtainPricesByIdAndApplicationDate(
            @RequestParam("applicationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId) {
        return queryPriceManager.ejecutar(applicationDate, productId, brandId);
    }
}
