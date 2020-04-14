package fr.dawan.atelier.controller;

import fr.dawan.atelier.dto.ProductDto;
import fr.dawan.atelier.entities.Product;
import fr.dawan.atelier.services.ProductManagementService;
import fr.dawan.atelier.services.ProductManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductManagementController {

    @Autowired
    private ProductManagementService productManagementService;

    @GetMapping(value = "/search/{desc}", produces = "application/json")
    @ResponseBody
    public List<ProductDto> search(@PathVariable("desc") String desc) {
        List<ProductDto> p = productManagementService.searchByDescription(desc);
        return p;
    }

    @PostMapping(value = "/save", consumes = "application/json", produces = "text/plain")
    @ResponseBody
    public String add(@RequestBody ProductDto pDto) {
        return productManagementService.addProduct(pDto);
    }

    @GetMapping(value = "/find/{id}", produces = "application/json")
    @ResponseBody
    public ProductDto findById(@PathVariable("id") long id) {
        return productManagementService.findById(id);
    }


}
