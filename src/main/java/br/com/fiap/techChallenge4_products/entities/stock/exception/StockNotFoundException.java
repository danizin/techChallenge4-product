package br.com.fiap.techChallenge4_products.entities.stock.exception;

public class StockNotFoundException extends RuntimeException {

    public StockNotFoundException() {
        super("Stock not found");
    }
}
