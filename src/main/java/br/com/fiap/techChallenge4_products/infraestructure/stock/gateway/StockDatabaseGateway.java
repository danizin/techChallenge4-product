package br.com.fiap.techChallenge4_products.infraestructure.stock.gateway;

import br.com.fiap.techChallenge4_products.entities.stock.gateway.StockGateway;
import br.com.fiap.techChallenge4_products.entities.stock.model.Stock;
import br.com.fiap.techChallenge4_products.infraestructure.config.db.repository.StockRepository;
import br.com.fiap.techChallenge4_products.infraestructure.config.db.schema.StockSchema;

import java.util.Optional;


public class StockDatabaseGateway implements StockGateway {

    private final StockRepository stockRepository;

    public StockDatabaseGateway(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock create(Stock stock) {
        return stockRepository.save(new StockSchema(stock)).toStock();
    }

    @Override
    public Stock update(Stock stock) {
        return stockRepository.save(new StockSchema(stock)).toStock();
    }

    @Override
    public void delete(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public Optional<Stock> findById(Long id) {
        return stockRepository.findById(id).map(StockSchema::toStock);
    }
}
