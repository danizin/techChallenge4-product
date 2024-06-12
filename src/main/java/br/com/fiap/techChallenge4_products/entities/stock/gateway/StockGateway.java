package br.com.fiap.techChallenge4_products.entities.stock.gateway;

import br.com.fiap.techChallenge4_products.entities.stock.model.Stock;

import java.util.Optional;

public interface StockGateway {
    Stock create(Stock product);
    Stock update(Stock product);
    void delete(Long id);
    Optional<Stock> findById(Long id);
}
