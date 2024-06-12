package br.com.fiap.techChallenge4_products.usecases.product;

import br.com.fiap.techChallenge4_products.entities.product.exception.ProductNotFoundException;
import br.com.fiap.techChallenge4_products.entities.product.gateway.ProductGateway;
import br.com.fiap.techChallenge4_products.entities.product.model.Product;
import br.com.fiap.techChallenge4_products.infraestructure.product.dto.ProductUpdateData;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class UpdateProductUseCase {
    private final ProductGateway productGateway;

    public UpdateProductUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public Product execute(Long id, ProductUpdateData updateData) throws ProductNotFoundException {
        Product product = productGateway.findById(id).orElseThrow(ProductNotFoundException::new);
        updatePropertyIfPresent(product::setName, updateData::name);
        updatePriceIfPresent(product::setPrice, updateData::price);

        return this.productGateway.update(product);
    }

    private void updatePropertyIfPresent(Consumer<String> setter, Supplier<Optional<String>> valueSupplier) {
        valueSupplier.get().ifPresent(setter);
    }

    private void updatePriceIfPresent(Consumer<BigDecimal> setter, Supplier<Optional<BigDecimal>> valueSupplier) {
        valueSupplier.get().ifPresent(setter);
    }
}
