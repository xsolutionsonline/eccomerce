package es.com.inditex.ecommerce.infrastructure.price.adapter.dao;

import es.com.inditex.ecommerce.comun.jdbc.CustomNamedParameterJdbcTemplate;
import es.com.inditex.ecommerce.comun.jdbc.sqlstatement.SqlStatement;
import es.com.inditex.ecommerce.domain.price.model.dto.PriceSummaryDTO;
import es.com.inditex.ecommerce.domain.price.port.DaoPrice;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DaoPriceSql implements DaoPrice {

    public final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final PriceSummaryMapper priceSummaryMapper;

    @SqlStatement(namespace = "price",value="obtainPricesDateApplicationProductIdBranchId")
    private static String sqlObtainPrices;

    public DaoPriceSql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate,PriceSummaryMapper priceSummaryMapper){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.priceSummaryMapper = priceSummaryMapper;
    }

    @Override
    public List<PriceSummaryDTO> obtainSummaryPrices(LocalDateTime applicationDate, Long productId, Long brandId) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("applicationDate", Timestamp.valueOf(applicationDate));
        parameterSource.addValue("productId",productId);
        parameterSource.addValue("brandId",brandId);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtainPrices,parameterSource,priceSummaryMapper);
    }
}
