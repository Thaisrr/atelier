package fr.dawan.atelier.services;

import fr.dawan.atelier.dto.ProductDto;
import fr.dawan.atelier.entities.Product;

import java.util.List;

public interface ProductManagementService {

    List<ProductDto> searchByDescription(String desc);

    String  addProduct(ProductDto p);

    ProductDto findById(long id);
}
