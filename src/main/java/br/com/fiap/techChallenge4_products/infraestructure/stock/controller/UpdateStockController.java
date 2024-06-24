package br.com.fiap.techChallenge4_products.infraestructure.stock.controller;


import br.com.fiap.techChallenge4_products.entities.product.exception.ProductNotFoundException;
import br.com.fiap.techChallenge4_products.infraestructure.stock.dto.StockPublicData;
import br.com.fiap.techChallenge4_products.infraestructure.stock.dto.StockUpdateData;
import br.com.fiap.techChallenge4_products.usecases.stock.UpdateStockUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateStockController {
    private final UpdateStockUseCase updateStockUseCase;

    public UpdateStockController(UpdateStockUseCase updateStockUseCase) {
        this.updateStockUseCase = updateStockUseCase;
    }


    @PutMapping("/stock/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public StockPublicData updateStock(@PathVariable Long productId, @Valid @RequestBody StockUpdateData updateData) throws ProductNotFoundException {
        return new StockPublicData(updateStockUseCase.execute(productId, updateData));
    }
}
