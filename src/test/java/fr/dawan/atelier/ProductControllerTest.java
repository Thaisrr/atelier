package fr.dawan.atelier;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.dawan.atelier.dto.ProductDto;
import fr.dawan.atelier.services.ProductManagementServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductManagementServiceImpl service;

        @Test
        public void testSearch() throws Exception {
            String s = mockMvc.perform(get("/api/products/search/Licorne"))
                    .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
            System.out.println("------------------------------------------------Syo ::: ");
            System.out.println(s);
                   // .andExpect(jsonPath("$.length()", is(1)))
                //    .andExpect(jsonPath("$.[0].productDescription", is("Licorne")));
        }

    @Test
    public void testFindById() throws Exception {
            mockMvc.perform(get("/api/products/find/3"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.productId", is("3")))
                    .andExpect(jsonPath("$.productDescription", is("Licorne")))
                    .andExpect(jsonPath("$.productPrice", is(1870.3)))
                    .andExpect(jsonPath("$.categoryName", is("Test")));
    }

    @Test
    public void testSave() throws Exception {
        ProductDto productDto = new ProductDto("Truc", "Patate", 3.9);
        ObjectMapper jacksonMapper  = new ObjectMapper();
        mockMvc.perform(
                post("/api/products/save")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jacksonMapper.writeValueAsString(productDto))
                )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString()
                .contains("Product saved");

    }




}
