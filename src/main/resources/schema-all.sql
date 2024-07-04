DROP TABLE IF EXISTS Stock;
DROP TABLE IF EXISTS Product;

CREATE TABLE Product
(
    id     BIGINT         NOT NULL AUTO_INCREMENT,
    name   VARCHAR(255)   NOT NULL,
    price  DECIMAL(19, 2) NOT NULL,
    width  DECIMAL(19, 2),
    height DECIMAL(19, 2),
    PRIMARY KEY (id)
);

CREATE TABLE Stock
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    quantity   INT NOT NULL,
    product_id BIGINT,
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES Product (id) ON DELETE CASCADE
);

-- Definindo AUTO_INCREMENT começando de 11 para as tabelas Product e Stock
ALTER TABLE Product ALTER COLUMN id RESTART WITH 11;
ALTER TABLE Stock ALTER COLUMN id RESTART WITH 11;
