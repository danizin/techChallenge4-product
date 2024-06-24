package br.com.fiap.techChallenge4_products.infraestructure.stock.dto;


import br.com.fiap.techChallenge4_products.entities.stock.model.Stock;
import br.com.fiap.techChallenge4_products.usecases.stock.dto.IStockPublicData;

public record StockPublicData(
        Long id,
        String productName,

        Long productId,

        int quantity

) implements IStockPublicData {
    public StockPublicData(Stock stock) {
        this(
                stock.getId(),
                stock.getProduct().getName(),
                stock.getProduct().getId(),
                stock.getQuantity());
    }
}
