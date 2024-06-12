package br.com.fiap.techChallenge4_products.entities.product.gateway;

import br.com.fiap.techChallenge4_products.entities.product.model.Product;

import java.util.Optional;

public interface ProductGateway {
    Product create(Product product);
    Product update(Product product);
    void delete(Long id);
    Optional<Product> findById(Long id);
}
