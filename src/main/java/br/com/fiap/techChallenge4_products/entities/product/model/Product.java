package br.com.fiap.techChallenge4_products.entities.product.model;


import br.com.fiap.techChallenge4_products.entities.AbstractEntity;
import br.com.fiap.techChallenge4_products.entities.stock.model.Stock;
import br.com.fiap.techChallenge4_products.infraestructure.config.db.schema.ProductSchema;
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
    private BigDecimal width;
    private BigDecimal height;

    public Product(){
    }

    public Product(String name, BigDecimal price, BigDecimal width, BigDecimal height) {
        this.name = name;
        this.price = price;
        this.width = width;
        this.height = height;
    }

    public ProductSchema toProductSchema() {
        ProductSchema productSchema = new ProductSchema();
        productSchema.setId(this.getId());
        productSchema.setName(this.getName());
        productSchema.setPrice(this.getPrice());
        productSchema.setWidth(this.getWidth());
        productSchema.setHeight(this.getHeight());

        return productSchema;
    }
}
