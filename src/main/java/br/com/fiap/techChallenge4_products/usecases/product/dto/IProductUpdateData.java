package br.com.fiap.techChallenge4_products.usecases.product.dto;


import java.math.BigDecimal;
import java.util.Optional;

public interface IProductUpdateData {
    Optional<String> name();

    Optional<BigDecimal> price();

}
