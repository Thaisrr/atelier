package fr.dawan.atelier.dto;

import fr.dawan.atelier.entities.Product;

public class ProductDto {

    private String categoryName;
    private String productDescription;
    private double productPrice;

    public ProductDto() {}

    public ProductDto(String categoryName, String productDescription, double productPrice) {
        super();
        this.categoryName = categoryName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
