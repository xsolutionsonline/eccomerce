package es.com.inditex.ecommerce.infraestructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.core.Is.is;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class QueryControllerPricesIntegratoinTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void obtainPricesByIdAndApplicationDateShouldReturnCorrectDataTest1() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T10:00:00");
        Long productId = 35455L;
        Long brandId = 1L;
        mvc.perform(MockMvcRequestBuilders
                        .get("/prices/byIdAndApplicationDate")
                        .param("applicationDate", applicationDate.toString())
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.startDate", is("2020-06-14T00:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-12-31T23:59:59")))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.applicablePrice", is(35.50)));
    }

    @Test
    public void obtainPricesByIdAndApplicationDateShouldReturnCorrectDataTest2() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T15:00:00");
        Long productId = 35455L;
        Long brandId = 1L;
        mvc.perform(MockMvcRequestBuilders
                        .get("/prices/byIdAndApplicationDate")
                        .param("applicationDate", applicationDate.toString())
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.startDate", is("2020-06-14T15:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-06-14T18:30:00")))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.applicablePrice", is(25.45)));
    }

    @Test
    public void obtainPricesByIdAndApplicationDateShouldReturnCorrectDataTest3() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T21:00:00");
        Long productId = 35455L;
        Long brandId = 1L;
        mvc.perform(MockMvcRequestBuilders
                        .get("/prices/byIdAndApplicationDate")
                        .param("applicationDate", applicationDate.toString())
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.startDate", is("2020-06-14T00:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-12-31T23:59:59")))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.applicablePrice", is(35.50)));
    }

    @Test
    public void obtainPricesByIdAndApplicationDateShouldReturnCorrectDataTest4() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-15T10:00:00");
        Long productId = 35455L;
        Long brandId = 1L;
        mvc.perform(MockMvcRequestBuilders
                        .get("/prices/byIdAndApplicationDate")
                        .param("applicationDate", applicationDate.toString())
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.startDate", is("2020-06-15T00:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-06-15T11:00:00")))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.applicablePrice", is(30.50)));
    }

    @Test
    public void obtainPricesByIdAndApplicationDateShouldReturnCorrectDataTest5() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-16T21:00:00");
        Long productId = 35455L;
        Long brandId = 1L;
        mvc.perform(MockMvcRequestBuilders
                        .get("/prices/byIdAndApplicationDate")
                        .param("applicationDate", applicationDate.toString())
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.startDate", is("2020-06-15T16:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-12-31T23:59:59")))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.applicablePrice", is(38.95)));
    }
}
