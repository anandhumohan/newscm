package com.sci.productservice.service;

import com.sci.productservice.dto.ProductRequest;
import com.sci.productservice.model.Product;
import com.sci.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    public void testCreateProduct(){
        ProductRequest productRequest = new ProductRequest("new one","new one",new BigDecimal(20));

        productService.createProduct(productRequest);

        verify(productRepository).save(any(Product.class));
    }

}
