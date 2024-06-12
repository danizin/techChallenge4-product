package br.com.fiap.techChallenge4_products.infraestructure.product.controller;


import br.com.fiap.techChallenge4_products.entities.product.exception.ProductNotFoundException;
import br.com.fiap.techChallenge4_products.infraestructure.product.dto.ProductPublicData;
import br.com.fiap.techChallenge4_products.infraestructure.product.dto.ProductUpdateData;
import br.com.fiap.techChallenge4_products.usecases.product.UpdateProductUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateProductController {
    private final UpdateProductUseCase updateProductUseCase;

    public UpdateProductController(UpdateProductUseCase updateProductUseCase) {
        this.updateProductUseCase = updateProductUseCase;
    }


    @PutMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductPublicData updateProduct(@PathVariable Long id, @Valid @RequestBody ProductUpdateData updateData) throws ProductNotFoundException {
        return new ProductPublicData(updateProductUseCase.execute(id, updateData));
    }
}
