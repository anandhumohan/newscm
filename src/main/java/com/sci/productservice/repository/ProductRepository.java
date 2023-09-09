package com.sci.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sci.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
