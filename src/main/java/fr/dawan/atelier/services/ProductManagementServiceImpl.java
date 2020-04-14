package fr.dawan.atelier.services;

import fr.dawan.atelier.dto.ProductDto;
import fr.dawan.atelier.entities.Category;
import fr.dawan.atelier.entities.Product;
import fr.dawan.atelier.mappers.ProductMapper;
import fr.dawan.atelier.repositories.CategoryRepository;
import fr.dawan.atelier.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductManagementServiceImpl implements ProductManagementService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

 /*   @Autowired
    private ModelMapper modelMapper; */

    @Override
    public List<ProductDto> searchByDescription(String desc) {
        List<Product> products = productRepository.findAllByDescription(desc+"%");
        System.out.println("------------------------------------------------------------------");
        System.out.println(products);

        // En param : source ( le produit ) , Destination
        return products.stream()
            /*    .map(p->modelMapper.map(p, ProductDto.class)) */
                .map(ProductMapper::convertToDto)
                .collect(Collectors.toList());

    }

    @Override
    public String addProduct(ProductDto pDto) {
      //  ModelMapper mapper = new ModelMapper();
        Product p = ProductMapper.convertToProduct(pDto);
       // productRepository.save(p);
        Category c = categoryRepository.findByName(pDto.getCategoryName());
        if ( c != null) {
           p.setCategory(c);
        }
        Product savedProduct = productRepository.save(p);
        return "Product saved " +savedProduct.getId();
    }

    @Override
    public ProductDto findById(long id) {
        Optional<Product> opt = productRepository.findById(id);
      /*  if(!opt.isPresent())
            return null;
        return ProductMapper.convertToDto(opt.get());
       */
        return opt.map(ProductMapper::convertToDto).orElse(null);
    }
}
