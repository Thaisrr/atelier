package fr.dawan.atelier.repositories;

import fr.dawan.atelier.entities.Category;
import fr.dawan.atelier.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("FROM Category c WHERE c.name= :name")
    Category findByName(@Param("name") String name);

    Category save(Category c);

    @Query("FROM Category c WHERE c.id = :id")
    Category findById(@Param("id") long id);
}
