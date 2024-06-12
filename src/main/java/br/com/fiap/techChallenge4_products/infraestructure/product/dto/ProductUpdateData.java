package br.com.fiap.techChallenge4_products.infraestructure.product.dto;


import br.com.fiap.techChallenge4_products.usecases.product.dto.IProductUpdateData;

import java.math.BigDecimal;
import java.util.Optional;

public record ProductUpdateData(
        Optional<String> name,
        Optional<BigDecimal> price
) implements IProductUpdateData {
}
