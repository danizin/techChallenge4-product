package br.com.fiap.techChallenge4_products.usecases.product.dto;


import br.com.fiap.techChallenge4_products.entities.stock.model.Stock;

import java.math.BigDecimal;

public interface IProductPublicData {

    String name();

    BigDecimal price();

    Stock stock();

}
