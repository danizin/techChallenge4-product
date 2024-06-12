package br.com.fiap.techChallenge4_products.infraestructure.config.db.schema;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Stock")
@Getter
@Setter
public class StockSchema extends AbstractEntitySchema<Long> {

    private int quantity;
    @NotNull
    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductSchema product;


    public StockSchema() {
        super();
    }

    public StockSchema(ProductSchema productSchema) {
        super();
        this.quantity = 0;
        this.product = productSchema;
    }
}
