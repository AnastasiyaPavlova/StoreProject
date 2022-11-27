package com.example.storeproject.repository;

import com.example.storeproject.entity.OrderProduct;
import com.example.storeproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long>
{
    List<OrderProduct>
   findOrderProductsByOrderId(Long orderId) ;
}
