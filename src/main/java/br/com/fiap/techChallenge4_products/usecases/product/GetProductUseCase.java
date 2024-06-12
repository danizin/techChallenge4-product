package br.com.fiap.techChallenge4_products.usecases.product;


import br.com.fiap.techChallenge4_products.entities.product.exception.ProductNotFoundException;
import br.com.fiap.techChallenge4_products.entities.product.gateway.ProductGateway;
import br.com.fiap.techChallenge4_products.entities.product.model.Product;

public class GetProductUseCase {
    private final ProductGateway productGateway;

    public GetProductUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public Product execute(Long id) throws ProductNotFoundException {
        return this.productGateway
                .findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }
}
