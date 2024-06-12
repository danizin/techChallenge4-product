package br.com.fiap.techChallenge4_products.infraestructure.product.controller;

import br.com.fiap.techChallenge4_products.usecases.product.DeleteProductUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeleteProductController {
    private final DeleteProductUseCase deleteProductUseCase;

    public DeleteProductController(DeleteProductUseCase deleteProductUseCase) {
        this.deleteProductUseCase = deleteProductUseCase;
    }

    @DeleteMapping("/product/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {
        deleteProductUseCase.execute(id);
    }
}
