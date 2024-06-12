package br.com.fiap.techChallenge4_products.infraestructure.config.db.repository;

import br.com.fiap.techChallenge4_products.infraestructure.config.db.schema.ProductSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductSchema, Long> {
}
