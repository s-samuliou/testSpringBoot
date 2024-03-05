package com.ticket.org.service;

import com.ticket.org.entity.ProductEntity;
import com.ticket.org.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductJpaRepository repository;

    public ProductServiceImpl(ProductJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductEntity create(ProductEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<ProductEntity> list(String category, double price) {
        return null;
    }
}
