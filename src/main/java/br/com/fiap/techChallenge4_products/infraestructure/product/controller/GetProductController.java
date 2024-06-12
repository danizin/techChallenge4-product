package br.com.fiap.techChallenge4_products.infraestructure.product.controller;


import br.com.fiap.techChallenge4_products.entities.product.exception.ProductNotFoundException;
import br.com.fiap.techChallenge4_products.infraestructure.product.dto.ProductPublicData;
import br.com.fiap.techChallenge4_products.usecases.product.GetProductUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetProductController {
    private final GetProductUseCase getProductUseCase;


    public GetProductController(GetProductUseCase getProductUseCase) {
        this.getProductUseCase = getProductUseCase;
    }

    @GetMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductPublicData getProductByName(@PathVariable Long id) throws ProductNotFoundException {
        return new ProductPublicData(getProductUseCase.execute(id));
    }
}
