package fr.dawan.atelier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import fr.dawan.atelier.controller.ProductManagementController;
import fr.dawan.atelier.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class AtelierApplicationTests {

    @Autowired
    private ProductManagementController productMgtController;

    @Test
    void contextLoads() {
        assertThat(productMgtController).isNotNull();
    }

    //Test des méthodes du contrôleur sans navigation
    @Test
    void testSearch() {
        List<ProductDto> lstDto = productMgtController.search("Licorne");
        assertEquals(1, lstDto.size());
        assertEquals("Licorne", lstDto.get(0).getProductDescription());
    }

}


