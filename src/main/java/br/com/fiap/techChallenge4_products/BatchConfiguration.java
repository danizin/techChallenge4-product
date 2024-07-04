package br.com.fiap.techChallenge4_products;

import br.com.fiap.techChallenge4_products.entities.product.model.Product;
import br.com.fiap.techChallenge4_products.entities.stock.model.Stock;
import br.com.fiap.techChallenge4_products.usecases.product.GetProductUseCase;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfiguration {

    @Autowired
    private  GetProductUseCase getProductUseCase;

    @Bean
    public Job processProductAndStock(JobRepository jobRepository, Step step, Step stockStep) {
        return new JobBuilder("importProductAndStock", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step)
                .next(stockStep)
                .build();
    }

    @Bean
    public Step step(JobRepository jobRepository,
                     PlatformTransactionManager platformTransactionManager,
                     ItemReader<Product> itemReader,
                     ItemWriter<Product> itemWriter) {
        return new StepBuilder("step", jobRepository)
                .<Product, Product>chunk(20, platformTransactionManager)
                .reader(itemReader)
                .writer(itemWriter).build();
    }

    @Bean
    public Step stockStep(JobRepository jobRepository,
                          PlatformTransactionManager platformTransactionManager,
                          ItemReader<Stock> stockItemReader,
                          ItemWriter<Stock> stockItemWriter) {
        return new StepBuilder("stockStep", jobRepository)
                .<Stock, Stock>chunk(20, platformTransactionManager)
                .reader(stockItemReader)
                .writer(stockItemWriter)
                .build();
    }

    @Bean
    public ItemReader<Product> itemReader() {
        BeanWrapperFieldSetMapper<Product> productSetMapper = new BeanWrapperFieldSetMapper<>();
        productSetMapper.setTargetType(Product.class);
        return new FlatFileItemReaderBuilder<Product>()
                .name("productItemReader")
                .resource(new ClassPathResource("product.csv"))
                .delimited()
                .names("id", "name", "price", "width", "height")
                .fieldSetMapper(productSetMapper)
                .build();
    }

    @Bean
    public ItemReader<Stock> stockItemReader() {
        return new FlatFileItemReaderBuilder<Stock>()
                .name("stockItemReader")
                .resource(new ClassPathResource("stock.csv"))
                .delimited()
                .names("id", "quantity", "product")
                .fieldSetMapper(fieldSet -> {
                    Stock stock = new Stock();
                    stock.setId(fieldSet.readLong("id"));
                    stock.setQuantity(fieldSet.readInt("quantity"));
                    Product product = getProductUseCase.execute(fieldSet.readLong("product"));
                    stock.setProduct(product);
                    return stock;
                })
                .build();
    }

    @Bean
    public ItemWriter<Product> itemWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Product>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .dataSource(dataSource).
                sql("""
                        INSERT INTO Product (id, name, price, width, height) VALUES
                        (:id, :name, :price, :width, :height);    
                        """)
                .build();
    }

    @Bean
    public ItemWriter<Stock> stockItemWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Stock>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .dataSource(dataSource)
                .sql("""
                        INSERT INTO Stock (id, quantity, product_id) VALUES
                        (:id, :quantity, :product.id);
                        """)
                .build();
    }

}
