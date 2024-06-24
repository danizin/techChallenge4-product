package br.com.fiap.techChallenge4_products.entities.stock.model;

import br.com.fiap.techChallenge4_products.entities.AbstractEntity;
import br.com.fiap.techChallenge4_products.entities.product.model.Product;
import br.com.fiap.techChallenge4_products.infraestructure.config.db.schema.StockSchema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Stock extends AbstractEntity<Long> {
    private int quantity;
    private Product product;

    public StockSchema toStockSchema() {
        StockSchema stockSchema = new StockSchema();
        stockSchema.setId(this.getId());
        stockSchema.setQuantity(this.getQuantity());
        stockSchema.setProduct(this.getProduct().toProductSchema());

        return stockSchema;
    }

}
