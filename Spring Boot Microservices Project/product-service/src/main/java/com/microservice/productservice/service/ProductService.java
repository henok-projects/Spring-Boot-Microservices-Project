package com.microservice.productservice.service;

import com.microservice.productservice.dto.ProductDto;
import com.microservice.productservice.dto.ProductResponseDto;
import com.microservice.productservice.model.Product;
import com.microservice.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductDto productDto) {
        var product = Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .build();
        productRepository.save(product);

        log.info("product {} is saved!", product.getId());
    }

    public List<ProductResponseDto> getAllProducts() {
        var products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponseDto).toList();
    }

    private ProductResponseDto mapToProductResponseDto(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
