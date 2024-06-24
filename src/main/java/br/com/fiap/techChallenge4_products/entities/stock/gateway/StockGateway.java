package br.com.fiap.techChallenge4_products.entities.stock.gateway;

import br.com.fiap.techChallenge4_products.entities.stock.model.Stock;

import java.util.Optional;

public interface StockGateway {

    Stock update(Stock product);

    Optional<Stock> findByProductId(Long id);
}
