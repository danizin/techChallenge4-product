package br.com.fiap.techChallenge4_products.entities.stock.model;

import br.com.fiap.techChallenge4_products.entities.AbstractEntity;
import br.com.fiap.techChallenge4_products.entities.product.model.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Stock extends AbstractEntity<Long> {
    private int quantity;
    private Product product;

}
