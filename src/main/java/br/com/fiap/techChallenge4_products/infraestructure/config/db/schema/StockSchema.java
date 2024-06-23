package br.com.fiap.techChallenge4_products.infraestructure.config.db.schema;


import br.com.fiap.techChallenge4_products.entities.stock.model.Stock;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Stock")
@Getter
@Setter
public class StockSchema extends AbstractEntitySchema<Long> {

    private int quantity;

    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductSchema product;


    public StockSchema() {
        super();
    }

    public StockSchema(Stock stock) {
        this.setId(stock.getId());
        this.quantity = stock.getQuantity();
    }

    public Stock toStock() {
        Stock stock = new Stock();
        stock.setId(this.getId());
        stock.setQuantity(this.getQuantity());

        return stock;
    }
}
