package fr.dawan.atelier.repositories;

import fr.dawan.atelier.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "FROM Product  p JOIN FETCH p.category c WHERE p.description LIKE :search")
    List<Product> findAllByDescription(@Param(("search")) String searchedDescription);


}
