package fr.dawan.atelier.repositories;

import fr.dawan.atelier.entities.Product;

import java.util.List;

public interface MyCustomRepo{

    List<Product> findAllByMultipleParam(String desc, double price);
}
