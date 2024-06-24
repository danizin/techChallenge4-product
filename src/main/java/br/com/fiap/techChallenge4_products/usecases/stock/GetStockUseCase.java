package br.com.fiap.techChallenge4_products.usecases.stock;


import br.com.fiap.techChallenge4_products.entities.product.exception.ProductNotFoundException;
import br.com.fiap.techChallenge4_products.entities.stock.gateway.StockGateway;
import br.com.fiap.techChallenge4_products.entities.stock.model.Stock;

public class GetStockUseCase {
    private final StockGateway stockGateway;

    public GetStockUseCase(StockGateway stockGateway) {
        this.stockGateway = stockGateway;
    }

    public Stock execute(Long productId) throws ProductNotFoundException {
        return this.stockGateway
                .findByProductId(productId)
                .orElseThrow(ProductNotFoundException::new);
    }
}
