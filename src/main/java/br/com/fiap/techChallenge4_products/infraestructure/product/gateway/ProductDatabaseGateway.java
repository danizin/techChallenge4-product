package br.com.fiap.techChallenge4_products.infraestructure.product.gateway;

import br.com.fiap.techChallenge4_products.entities.product.gateway.ProductGateway;
import br.com.fiap.techChallenge4_products.entities.product.model.Product;
import br.com.fiap.techChallenge4_products.infraestructure.config.db.repository.ProductRepository;
import br.com.fiap.techChallenge4_products.infraestructure.config.db.schema.ProductSchema;
import br.com.fiap.techChallenge4_products.infraestructure.config.db.schema.StockSchema;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class ProductDatabaseGateway implements ProductGateway {

    private final ProductRepository productRepository;

    public ProductDatabaseGateway(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public Product create(Product product) {
        StockSchema stockSchema = new StockSchema(product.getStock());
        ProductSchema productSchema = new ProductSchema(product);
        productSchema.setStock(stockSchema);
        stockSchema.setProduct(productSchema);
        ProductSchema productSaved = productRepository.save(new ProductSchema(product));

        return productSaved.toProduct();
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(new ProductSchema(product)).toProduct();
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id).map(ProductSchema::toProduct);
    }
}
