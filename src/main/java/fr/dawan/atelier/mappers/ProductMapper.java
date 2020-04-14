package fr.dawan.atelier.mappers;

import fr.dawan.atelier.dto.ProductDto;
import fr.dawan.atelier.entities.Product;
import org.modelmapper.ModelMapper;

public class ProductMapper {

    public static ProductDto convertToDto(Product p) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(p, ProductDto.class);
    }

    public static Product convertToProduct(ProductDto p) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(p, Product.class);
    }
}
