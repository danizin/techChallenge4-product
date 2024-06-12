package br.com.fiap.techChallenge4_products.infraestructure.config.db.schema;


import br.com.fiap.techChallenge4_products.entities.product.model.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "Product")
@Getter
@Setter
public class ProductSchema extends AbstractEntitySchema<Long> {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private BigDecimal price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private StockSchema stock;


    public ProductSchema() {
        super();
    }

    public ProductSchema(Product product) {
        this.setId(product.getId());
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public Product toProduct() {
        Product product = new Product(this.name, this.price);
        product.setId(this.getId());
        return product;
    }

}
