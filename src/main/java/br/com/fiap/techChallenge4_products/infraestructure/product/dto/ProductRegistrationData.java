package br.com.fiap.techChallenge4_products.infraestructure.product.dto;


import br.com.fiap.techChallenge4_products.usecases.product.dto.IProductRegistrationData;

import java.math.BigDecimal;

public record ProductRegistrationData(
        String name,
        BigDecimal price
) implements IProductRegistrationData {
}
