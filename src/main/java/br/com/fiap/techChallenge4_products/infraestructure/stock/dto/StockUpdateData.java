package br.com.fiap.techChallenge4_products.infraestructure.stock.dto;


import br.com.fiap.techChallenge4_products.usecases.stock.dto.IStockUpdateData;

import java.util.Optional;

public record StockUpdateData(
        Optional<Integer> quantity
) implements IStockUpdateData {
}
