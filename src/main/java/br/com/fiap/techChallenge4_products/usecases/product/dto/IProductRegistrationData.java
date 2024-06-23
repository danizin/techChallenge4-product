package br.com.fiap.techChallenge4_products.usecases.product.dto;


import java.math.BigDecimal;

public interface IProductRegistrationData {
    String name();
    BigDecimal price();
    BigDecimal width();
    BigDecimal height();
}
