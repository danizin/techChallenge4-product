package br.com.fiap.techChallenge4_products.infraestructure.product.controller;


import br.com.fiap.techChallenge4_products.infraestructure.product.dto.ProductPublicData;
import br.com.fiap.techChallenge4_products.infraestructure.product.dto.ProductRegistrationData;
import br.com.fiap.techChallenge4_products.usecases.product.CreateProductUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CreateProductController {
    private final CreateProductUseCase createProductUseCase;

    public CreateProductController(CreateProductUseCase createProductUseCase) {
        this.createProductUseCase = createProductUseCase;
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductPublicData createProduct(@Valid @RequestBody ProductRegistrationData productData) {
        return new ProductPublicData(createProductUseCase.execute(productData));
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ProductPublicData> createProducts(@Valid @RequestBody List<ProductRegistrationData> productDataList) {
        return createProductUseCase.executeBatch(productDataList);
    }
}
