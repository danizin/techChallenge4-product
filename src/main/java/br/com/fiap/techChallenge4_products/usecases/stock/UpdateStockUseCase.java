package br.com.fiap.techChallenge4_products.usecases.stock;

import br.com.fiap.techChallenge4_products.entities.product.exception.ProductNotFoundException;
import br.com.fiap.techChallenge4_products.entities.stock.gateway.StockGateway;
import br.com.fiap.techChallenge4_products.entities.stock.model.Stock;
import br.com.fiap.techChallenge4_products.infraestructure.stock.dto.StockUpdateData;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class UpdateStockUseCase {

    private final StockGateway stockGateway;

    public UpdateStockUseCase(StockGateway stockGateway) {
        this.stockGateway = stockGateway;
    }

    public Stock execute(Long productId, StockUpdateData updateData) throws ProductNotFoundException {
        Stock stock = stockGateway.findByProductId(productId).orElseThrow(ProductNotFoundException::new);
        updateQuantityIfPresent(stock::setQuantity, updateData::quantity);

        return this.stockGateway.update(stock);
    }

    private void updateQuantityIfPresent(Consumer<Integer> setter, Supplier<Optional<Integer>> valueSupplier) {
        valueSupplier.get().ifPresent(setter);
    }

}
