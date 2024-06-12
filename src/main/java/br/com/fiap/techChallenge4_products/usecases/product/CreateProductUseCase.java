package br.com.fiap.techChallenge4_products.usecases.product;


import br.com.fiap.techChallenge4_products.entities.product.gateway.ProductGateway;
import br.com.fiap.techChallenge4_products.entities.product.model.Product;
import br.com.fiap.techChallenge4_products.infraestructure.product.dto.ProductRegistrationData;

public class CreateProductUseCase {

    private final ProductGateway productGateway;

    public CreateProductUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public Product execute(ProductRegistrationData registrationData) {
        Product product =
                new Product(registrationData.name(), registrationData.price());
        return productGateway.create(product);
    }
}
