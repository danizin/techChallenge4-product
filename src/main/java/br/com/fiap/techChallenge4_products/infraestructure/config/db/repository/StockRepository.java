package br.com.fiap.techChallenge4_products.infraestructure.config.db.repository;

import br.com.fiap.techChallenge4_products.infraestructure.config.db.schema.StockSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<StockSchema, Long> {

    Optional<StockSchema> findByProductId(Long productId);

}
