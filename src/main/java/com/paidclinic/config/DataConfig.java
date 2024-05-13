package com.paidclinic.config;

import com.paidclinic.entity.Product;
import com.paidclinic.entity.Workshop;
import com.paidclinic.repository.WorkshopRepository;
import com.paidclinic.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class DataConfig
{
    @Bean
    public CommandLineRunner loadData(ProductRepository productRepository, WorkshopRepository workshopRepository)
    {
        return (args) -> {
            if (productRepository.findAll().isEmpty())
            {
                var products = new ArrayList<Product>();
                // Юдина
                products.add(new Product("13 мая 8:00 - 11:00 (1)", 7500, "udina"));
                products.add(new Product("13 мая 11:00 - 14:00 (1)", 7500, "udina"));
                products.add(new Product("14 мая 15:00 - 18:00 (1)", 8000, "udina"));
                products.add(new Product("14 мая 18:00 - 21:00 (1)", 10000, "udina"));

                // Попов
                products.add(new Product("13 мая 8:00 - 11:00 (2)", 2500, "popov"));
                products.add(new Product("13 мая 11:00 - 14:00 (2)", 2500, "popov"));
                products.add(new Product("14 мая 15:00 - 18:00 (2)", 3000, "popov"));
                products.add(new Product("14 мая 18:00 - 21:00 (2)", 4000, "popov"));
                // Ильина
                products.add(new Product("13 мая 8:00 - 11:00 (3)", 7000, "ilina"));
                products.add(new Product("13 мая 11:00 - 14:00 (3)", 7000, "ilina"));
                products.add(new Product("14 мая 15:00 - 18:00 (3)", 8000, "ilina"));
                products.add(new Product("14 мая 18:00 - 21:00 (3)", 9000, "ilina"));
                // Солнцев
                products.add(new Product("13 мая 8:00 - 11:00 (4)", 5500, "sun"));
                products.add(new Product("13 мая 11:00 - 14:00 (4)", 5500, "sun"));
                products.add(new Product("14 мая 15:00 - 18:00 (4)", 6000, "sun"));
                products.add(new Product("14 мая 18:00 - 21:00 (4)", 7000, "sun"));
                productRepository.saveAll(products);

                for (var product : products)
                {
                    workshopRepository.save(new Workshop(product, 4));
                }
            }
        };
    }
}

