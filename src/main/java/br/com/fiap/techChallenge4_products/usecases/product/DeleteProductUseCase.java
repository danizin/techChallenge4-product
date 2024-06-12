package br.com.fiap.techChallenge4_products.usecases.product;


import br.com.fiap.techChallenge4_products.entities.product.exception.ProductNotFoundException;
import br.com.fiap.techChallenge4_products.entities.product.gateway.ProductGateway;
import br.com.fiap.techChallenge4_products.entities.product.model.Product;

public class DeleteProductUseCase {
    private final ProductGateway productGateway;

    public DeleteProductUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }


    public void execute(final Long id) throws ProductNotFoundException {
        Product product = productGateway.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        productGateway.delete(product.getId());
    }
}
