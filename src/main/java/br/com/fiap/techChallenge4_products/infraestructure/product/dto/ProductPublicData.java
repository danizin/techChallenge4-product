package br.com.fiap.techChallenge4_products.infraestructure.product.dto;


import br.com.fiap.techChallenge4_products.entities.product.model.Product;
import br.com.fiap.techChallenge4_products.entities.stock.model.Stock;
import br.com.fiap.techChallenge4_products.usecases.product.dto.IProductPublicData;

import java.math.BigDecimal;

public record ProductPublicData(
        Long id,
        String name,
        BigDecimal price,
        Stock stock
) implements IProductPublicData {
    public ProductPublicData(Product product) {
        this(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock());
    }
}
