package br.com.fiap.techChallenge4_products.infraestructure.config.web;

import br.com.fiap.techChallenge4_products.entities.product.gateway.ProductGateway;
import br.com.fiap.techChallenge4_products.entities.stock.gateway.StockGateway;
import br.com.fiap.techChallenge4_products.infraestructure.config.db.repository.ProductRepository;
import br.com.fiap.techChallenge4_products.infraestructure.config.db.repository.StockRepository;
import br.com.fiap.techChallenge4_products.infraestructure.product.gateway.ProductDatabaseGateway;
import br.com.fiap.techChallenge4_products.infraestructure.stock.gateway.StockDatabaseGateway;
import br.com.fiap.techChallenge4_products.usecases.product.CreateProductUseCase;
import br.com.fiap.techChallenge4_products.usecases.product.DeleteProductUseCase;
import br.com.fiap.techChallenge4_products.usecases.product.GetProductUseCase;
import br.com.fiap.techChallenge4_products.usecases.product.UpdateProductUseCase;
import br.com.fiap.techChallenge4_products.usecases.stock.GetStockUseCase;
import br.com.fiap.techChallenge4_products.usecases.stock.UpdateStockUseCase;
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

    @Bean
    public UpdateStockUseCase updateStockUseCase(StockRepository stockRepository) {
        StockGateway stockGateway = new StockDatabaseGateway(stockRepository);
        return new UpdateStockUseCase(stockGateway);
    }

    @Bean
    public GetStockUseCase getStockUseCase(StockRepository stockRepository) {
        StockGateway stockGateway = new StockDatabaseGateway(stockRepository);
        return new GetStockUseCase(stockGateway);
    }

}
