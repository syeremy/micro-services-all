package com.cacti.workshop.microservices.repositories;

import com.cacti.workshop.microservices.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by domix on 9/9/16.
 */
public interface ProductRepository extends ElasticsearchRepository<Product, String> {
}
