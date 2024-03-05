package com.ticket.org.repository;

import com.ticket.org.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> { //2й парам - тип первич ключа
}
