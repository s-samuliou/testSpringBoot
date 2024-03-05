package com.ticket.org.service;

import com.ticket.org.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    ProductEntity create(ProductEntity entity);

    List<ProductEntity> list(String category, double price);
}
