package com.ticket.org.controller;

import com.ticket.org.converter.Converter;
import com.ticket.org.entity.ProductEntity;
import com.ticket.org.model.dto.ProductCreateDto;
import com.ticket.org.model.dto.ProductDto;
import com.ticket.org.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private Converter<ProductEntity, ProductDto> converter;

    @GetMapping
    public List<ProductDto> list(@RequestParam(name = "category", required = false) String category,
                                 @RequestParam(name = "price") double price) { //required = false значит буит осуш фильтрац по заданным парам. с рек фолс можем получить список не всем категориям

        List<ProductEntity> list = service.list(category, price);
        return list.stream()
                .map(product -> converter.toDto(product))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        ProductEntity productEntity = converter.toEntity(productDto);
        ProductEntity entity = service.create(productEntity);
        return converter.toDto(entity);
    }
}
