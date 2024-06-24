package br.com.fiap.techChallenge4_products.infraestructure.product.dto;


import br.com.fiap.techChallenge4_products.entities.product.model.Product;
import br.com.fiap.techChallenge4_products.usecases.product.dto.IProductPublicData;

import java.math.BigDecimal;

public record ProductWithStockPublicData(
        Long id,
        String name,
        BigDecimal price,
        BigDecimal width,
        BigDecimal height,
        Long stockId,
        int quantity


) implements IProductPublicData {
    public ProductWithStockPublicData(Product product) {
        this(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getWidth(),
                product.getHeight(),
                product.getStock().getId(),
                product.getStock().getQuantity());
    }
}
