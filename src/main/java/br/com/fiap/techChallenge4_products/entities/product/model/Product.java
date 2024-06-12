package br.com.fiap.techChallenge4_products.entities.product.model;


import br.com.fiap.techChallenge4_products.entities.AbstractEntity;
import br.com.fiap.techChallenge4_products.entities.stock.model.Stock;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class Product extends AbstractEntity<Long> {

    private String name;
    private BigDecimal price;
    private Stock stock;

    public Product(){
    }

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
