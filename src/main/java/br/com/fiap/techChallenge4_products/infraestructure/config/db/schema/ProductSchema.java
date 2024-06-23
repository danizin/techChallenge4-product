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

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private StockSchema stock;

    private BigDecimal width;

    private BigDecimal height;


    public ProductSchema() {
        super();
    }

    public ProductSchema(Product product) {
        this.setId(product.getId());
        this.name = product.getName();
        this.price = product.getPrice();
        this.width = product.getWidth();
        this.height = product.getHeight();
        if (product.getStock() != null) {
            this.stock = new StockSchema(product.getStock());
            this.stock.setProduct(this);
        }
    }

    public Product toProduct() {
        Product product = new Product(this.name, this.price, this.width, this.height);
        product.setId(this.getId());
        if (this.getStock() != null) {
            product.setStock(this.getStock().toStock());
        }

        return product;
    }

}
