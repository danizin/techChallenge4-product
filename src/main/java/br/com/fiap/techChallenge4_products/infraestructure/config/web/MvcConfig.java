package br.com.fiap.techChallenge4_products.infraestructure.config.web;

import br.com.fiap.techChallenge4_products.entities.product.gateway.ProductGateway;
import br.com.fiap.techChallenge4_products.infraestructure.config.db.repository.ProductRepository;
import br.com.fiap.techChallenge4_products.infraestructure.product.gateway.ProductDatabaseGateway;
import br.com.fiap.techChallenge4_products.usecases.product.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {

    @Bean
    public CreateProductUseCase createProductUseCase(ProductRepository productRepository) {
        ProductGateway productGateway = new ProductDatabaseGateway(productRepository);
        return new CreateProductUseCase(productGateway);
    }

    @Bean
    public DeleteProductUseCase deleteProductUseCase(ProductRepository productRepository) {
        ProductGateway productGateway = new ProductDatabaseGateway(productRepository);
        return new DeleteProductUseCase(productGateway);
    }

    @Bean
    public GetProductUseCase getProductUseCase(ProductRepository productRepository) {
        ProductGateway productGateway = new ProductDatabaseGateway(productRepository);
        return new GetProductUseCase(productGateway);
    }

    @Bean
    public UpdateProductUseCase updateProductUseCase(ProductRepository productRepository) {
        ProductGateway productGateway = new ProductDatabaseGateway(productRepository);
        return new UpdateProductUseCase(productGateway);
    }

}
