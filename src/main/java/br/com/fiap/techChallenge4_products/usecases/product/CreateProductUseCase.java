package br.com.fiap.techChallenge4_products.usecases.product;


import br.com.fiap.techChallenge4_products.entities.product.gateway.ProductGateway;
import br.com.fiap.techChallenge4_products.entities.product.model.Product;
import br.com.fiap.techChallenge4_products.entities.stock.model.Stock;
import br.com.fiap.techChallenge4_products.infraestructure.product.dto.ProductPublicData;
import br.com.fiap.techChallenge4_products.infraestructure.product.dto.ProductRegistrationData;

import java.util.List;

public class CreateProductUseCase {

    private final ProductGateway productGateway;

    public CreateProductUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public Product execute(ProductRegistrationData registrationData) {
        Product product =
                new Product(registrationData.name(), registrationData.price(), registrationData.width(), registrationData.height());

        Stock stock = new Stock();
        stock.setQuantity(0);
        product.setStock(stock);
        product = productGateway.create(product);

        return product;
    }


    public List<ProductPublicData> executeBatch(List<ProductRegistrationData> productDataList) {
        return productDataList.stream()
                .map(this::execute)
                .map(ProductPublicData::new)
                .toList();
    }
}
