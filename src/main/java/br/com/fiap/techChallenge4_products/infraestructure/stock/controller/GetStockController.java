package br.com.fiap.techChallenge4_products.infraestructure.stock.controller;


import br.com.fiap.techChallenge4_products.entities.product.exception.ProductNotFoundException;
import br.com.fiap.techChallenge4_products.infraestructure.stock.dto.StockPublicData;
import br.com.fiap.techChallenge4_products.usecases.stock.GetStockUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetStockController {
    private final GetStockUseCase getStockUseCase;


    public GetStockController(GetStockUseCase getStockUseCase) {
        this.getStockUseCase = getStockUseCase;
    }

    @GetMapping("/stock/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public StockPublicData getStockByProduct(@PathVariable Long productId) throws ProductNotFoundException {
        return new StockPublicData(getStockUseCase.execute(productId));
    }
}
