package com.sci.productservice.service;



import java.util.List;

import com.sci.productservice.dto.UpdateProductRequest;
import org.springframework.stereotype.Service;

import com.sci.productservice.dto.ProductRequest;
import com.sci.productservice.dto.ProductResponse;
import com.sci.productservice.model.Product;
import com.sci.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	
	private final ProductRepository productRepository;

	public void createProduct(ProductRequest productRequest) {
		
		Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
		
		productRepository.save(product);
		log.info("Product is saved");
	}

	public List<ProductResponse> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(this::mapToProductResponse).toList();
		
	}

	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
	}

    public void updateProduct(UpdateProductRequest updateProductRequest) {
		Product productDetails = productRepository.findById(updateProductRequest.getId())
				.orElseThrow(()-> new RuntimeException("Run time exception: Product details not found"));

		Product product = Product.builder()
				.name(productDetails.getName())
				.description(productDetails.getDescription())
				.price(productDetails.getPrice())
				.build();
		productRepository.save(product);

    }

	public ProductResponse getProductById(String id) {
		Product product = productRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Run time exception:Product not found"));
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
	}
}
